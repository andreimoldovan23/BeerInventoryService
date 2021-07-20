package sfmc.beerinventory.services.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import sfmc.beerinventory.config.JmsConfig;
import sfmc.beerinventory.events.DeallocateOrderEvent;
import sfmc.beerinventory.services.interfaces.BeerAllocationService;

@Component
@RequiredArgsConstructor
public class DeallocationRequestListener {
    private final BeerAllocationService allocationService;

    @JmsListener(destination = JmsConfig.DEALLOCATE_ORDER_QUEUE)
    public void listen(DeallocateOrderEvent event) {
        allocationService.deallocateInventory(event.getBeerOrderDTO());
    }
}
