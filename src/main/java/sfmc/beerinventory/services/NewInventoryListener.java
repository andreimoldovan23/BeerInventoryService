package sfmc.beerinventory.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sfmc.beerinventory.config.JmsConfig;
import sfmc.beerinventory.domain.BeerInventory;
import sfmc.beerinventory.events.NewInventoryEvent;
import sfmc.beerinventory.repositories.BeerInventoryRepository;
import sfmc.beerinventory.web.model.BeerDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewInventoryListener {
    private final BeerInventoryRepository repository;

    @Transactional
    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event) {
        BeerDTO dto = event.getBeerDTO();
        log.trace("Got inventory for {}: {}", dto.getId(), dto);
        repository.save(BeerInventory.builder()
            .beerId(dto.getId())
            .upc(dto.getUpc())
            .quantityOnHand(dto.getQuantityOnHand())
            .build()
        );
    }
}
