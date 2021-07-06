package sfmc.beerinventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import sfmc.beerinventory.events.BeerEvent;
import sfmc.beerinventory.events.NewInventoryEvent;
import sfmc.beerinventory.web.model.BeerDTO;

import java.util.HashMap;

@Configuration
public class JmsConfig {
    public static final String NEW_INVENTORY_QUEUE = "new-inventory-request";

    @Bean
    MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);

        HashMap<String, Class<?>> typeIdMappings = new HashMap<>();
        typeIdMappings.put(BeerEvent.class.getSimpleName(), BeerEvent.class);
        typeIdMappings.put(BeerDTO.class.getSimpleName(), BeerDTO.class);
        typeIdMappings.put(NewInventoryEvent.class.getSimpleName(), NewInventoryEvent.class);

        converter.setTypeIdMappings(typeIdMappings);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
