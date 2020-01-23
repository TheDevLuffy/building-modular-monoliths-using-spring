package monoliths.shipments.integrate.http;

import java.util.List;

import org.springframework.stereotype.Component;

import monoliths.shipments.domain.entity.Delivery;
import monoliths.shipments.domain.entity.DeliveryProduct;
import monoliths.shipments.domain.entity.DistributionCenter;

@Component
class HttpFulfillmentService implements DistributionCenter {

    @Override
    public void verifyStockFor(List<DeliveryProduct> deliveryProducts) {
        // TODO Catalogs 서비스에서 제공하는 Web API 기반 구현
    }

    @Override
    public void dispatching(Delivery delivery) {
        // TODO 물류센터에 배달 요청한다.
    }

}