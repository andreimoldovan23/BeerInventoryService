package sfmc.beerinventory.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sfmc.beerinventory.web.model.BeerDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerEvent {
    private BeerDTO beerDTO;
}
