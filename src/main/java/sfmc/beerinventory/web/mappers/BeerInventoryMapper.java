package sfmc.beerinventory.web.mappers;

import org.mapstruct.Mapper;
import sfmc.beerinventory.domain.BeerInventory;
import sfmc.beerinventory.web.model.BeerInventoryDTO;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {
    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDTO beerInventoryDTO);

    BeerInventoryDTO beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
