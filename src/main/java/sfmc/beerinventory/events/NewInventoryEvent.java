package sfmc.beerinventory.events;

import lombok.NoArgsConstructor;
import sfmc.beerinventory.web.model.BeerDTO;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {
    public NewInventoryEvent(BeerDTO beerDTO) {
        super(beerDTO);
    }
}
