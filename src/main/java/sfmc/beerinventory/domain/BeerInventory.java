package sfmc.beerinventory.domain;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
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
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false)
    private UUID beerId;
    private String upc;

    @Builder.Default
    private Integer quantityOnHand = 0;
}
