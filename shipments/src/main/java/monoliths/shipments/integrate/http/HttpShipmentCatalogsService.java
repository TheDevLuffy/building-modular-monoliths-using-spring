package monoliths.shipments.integrate.http;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import monoliths.commons.model.OrderSheet.OrderSheetItem;
import monoliths.shipments.domain.entity.DeliveryProduct;
import monoliths.shipments.domain.entity.DeliveryProductMapper;

@Component
class HttpShipmentCatalogsService implements DeliveryProductMapper {

    @Override
    public List<DeliveryProduct> mapFrom(List<OrderSheetItem> orderSheetItems) {
        return Collections.emptyList();
    }
    
}