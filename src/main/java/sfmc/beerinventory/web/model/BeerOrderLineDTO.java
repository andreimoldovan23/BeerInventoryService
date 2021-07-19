package sfmc.beerinventory.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerOrderLineDTO {
    private UUID id;
    private String upc;
    private Integer orderQuantity;
    private Integer quantityAllocated;
}
