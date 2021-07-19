package sfmc.beerinventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import sfmc.beerinventory.events.AllocateOrderEvent;
import sfmc.beerinventory.events.AllocationResponseEvent;
import sfmc.beerinventory.events.BeerEvent;
import sfmc.beerinventory.events.NewInventoryEvent;
import sfmc.beerinventory.web.model.BeerDTO;
import sfmc.beerinventory.web.model.BeerOrderDTO;
import sfmc.beerinventory.web.model.BeerOrderLineDTO;

import java.util.HashMap;

@Configuration
public class JmsConfig {
    public static final String NEW_INVENTORY_QUEUE = "new-inventory-request";
    public static final String ALLOCATE_ORDER_QUEUE = "allocate-order-request";
    public static final String ALLOCATION_RESPONSE_QUEUE = "allocate-request-response";

    @Bean
    MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);

        HashMap<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put(BeerEvent.class.getSimpleName(), BeerEvent.class);
        typeIdMappings.put(BeerDTO.class.getSimpleName(), BeerDTO.class);
        typeIdMappings.put(NewInventoryEvent.class.getSimpleName(), NewInventoryEvent.class);
        typeIdMappings.put(BeerOrderDTO.class.getSimpleName(), BeerOrderDTO.class);
        typeIdMappings.put(BeerOrderLineDTO.class.getSimpleName(), BeerOrderLineDTO.class);
        typeIdMappings.put(AllocateOrderEvent.class.getSimpleName(), AllocateOrderEvent.class);
        typeIdMappings.put(AllocationResponseEvent.class.getSimpleName(), AllocationResponseEvent.class);

        converter.setTypeIdMappings(typeIdMappings);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
