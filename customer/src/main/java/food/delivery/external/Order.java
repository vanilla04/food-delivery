package food.delivery.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

    private Long id;
    private String foodId;
    private Object options;
    private String address;
    private String customerId;
    private String storeId;
}


