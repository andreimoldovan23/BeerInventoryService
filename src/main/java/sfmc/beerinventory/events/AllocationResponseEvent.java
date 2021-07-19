package sfmc.beerinventory.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sfmc.beerinventory.web.model.BeerOrderDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllocationResponseEvent {
    private BeerOrderDTO beerOrderDTO;
    private Boolean allocationError;
    private Boolean pendingInventory;
}
