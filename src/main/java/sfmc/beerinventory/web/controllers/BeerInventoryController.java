package sfmc.beerinventory.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sfmc.beerinventory.repositories.BeerInventoryRepository;
import sfmc.beerinventory.web.mappers.BeerInventoryMapper;
import sfmc.beerinventory.web.model.BeerInventoryDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    private final BeerInventoryRepository beerInventoryRepository;
    private final BeerInventoryMapper beerInventoryMapper;

    @GetMapping("api/v1/beer/{beerId}/inventory")
    List<BeerInventoryDTO> listBeersById(@PathVariable UUID beerId){
        log.trace("Finding Inventory for beerId: {}", beerId);

        List<BeerInventoryDTO> inventoryDTOS = beerInventoryRepository.findAllByBeerId(beerId).stream()
                .map(beerInventoryMapper::beerInventoryToBeerInventoryDto)
                .collect(Collectors.toList());

        log.trace("For beer {} got inventories: {}", beerId, inventoryDTOS);

        return inventoryDTOS;
    }
}
