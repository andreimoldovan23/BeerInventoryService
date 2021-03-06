package sfmc.beerinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sfmc.beerinventory.domain.BeerInventory;

import java.util.List;
import java.util.UUID;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {
    List<BeerInventory> findAllByBeerId(UUID beerId);
    List<BeerInventory> findAllByUpc(String upc);
}
