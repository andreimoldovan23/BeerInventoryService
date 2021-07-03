package sfmc.beerinventory.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)

@Entity
public class BeerInventory extends BaseEntity {
    private UUID beerId;
    private String upc;

    @Builder.Default
    private Integer quantityOnHand = 0;
}
