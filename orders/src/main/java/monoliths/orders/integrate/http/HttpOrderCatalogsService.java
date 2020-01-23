package monoliths.orders.integrate.http;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import monoliths.commons.model.OrderSheet;
import monoliths.orders.domain.entity.OrderProduct;
import monoliths.orders.domain.entity.OrderProductItem;
import monoliths.orders.domain.entity.OrderProductMapper;

@AllArgsConstructor
@Component
class HttpOrderCatalogsService implements OrderProductMapper {

    private RestTemplate restTemplate;

    @Override
    public List<OrderProduct> mapFrom(List<OrderSheet.OrderSheetItem> orderSheetItems) {
        return orderSheetItems.stream().map(orderSheetItem -> {
            Product product = getProductFor(orderSheetItem);
            List<OrderProductItem> productItems = product.getItems().stream().map(productItem ->
                    OrderProductItem.builder()
                                    .productItemId(productItem.getId())
                                    .productItemName(productItem.getName())
                                    .productItemPrice(productItem.getPrice())
                                    .productItemSkuId(productItem.getSkuId())
                                    .build()).collect(Collectors.toList());

            return OrderProduct.builder()
                               .productId(product.getId())
                               .productName(product.getName())
                               .productItems(productItems)
                               .price(product.getPrice())
                               .quantity(orderSheetItem.getQuantity())
                               .build();
        }).collect(Collectors.toList());
    }

    private Product getProductFor(OrderSheet.OrderSheetItem item) {
        return restTemplate.getForObject("http://catalogs-service/product/{id}", Product.class, item.getProductId());
    }    
    
    @Data
    class Product {
        private UUID id;
        private String code;
        private String name;
        private BigDecimal price;
        private Set<ProductItem> items;
    }

    @Data
    class ProductItem {
        private UUID id;
        private String name;
        private BigDecimal price;
        private boolean base;
        private UUID skuId;
    }
    
}