package sfmc.beerinventory.services.interfaces;

import sfmc.beerinventory.web.model.BeerOrderDTO;

public interface BeerAllocationService {
    Boolean allocateInventory(BeerOrderDTO dto);
    void deallocateInventory(BeerOrderDTO dto);
}
