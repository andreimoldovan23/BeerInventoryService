package sfmc.beerinventory.services.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import sfmc.beerinventory.config.JmsConfig;
import sfmc.beerinventory.events.AllocateOrderEvent;
import sfmc.beerinventory.events.AllocationResponseEvent;
import sfmc.beerinventory.services.interfaces.BeerAllocationService;
import sfmc.beerinventory.web.model.BeerOrderDTO;

@Service
@Slf4j
@RequiredArgsConstructor
public class AllocationRequestListener {
    private final BeerAllocationService allocationService;
    private final JmsTemplate jmsTemplate;

    @JmsListener(destination = JmsConfig.ALLOCATE_ORDER_QUEUE)
    public void listen(AllocateOrderEvent event) {
        BeerOrderDTO dto = event.getBeerOrderDTO();
        log.trace("Got incoming allocation request for: {}", dto);

        try {
            send(dto, false, !allocationService.allocateInventory(dto));
        } catch (Exception e) {
            send(dto, true, false);
        }
    }

    private void send(BeerOrderDTO dto, Boolean allocationError, Boolean pendingInventory) {
        jmsTemplate.convertAndSend(JmsConfig.ALLOCATION_RESPONSE_QUEUE, AllocationResponseEvent.builder()
            .beerOrderDTO(dto).allocationError(allocationError).pendingInventory(pendingInventory)
            .build());
    }
}
