import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.orders.OrdersRequest;

import static org.hamcrest.Matchers.hasKey;

public class GetOrderTest {
    OrdersRequest ordersRequest;

    @Test
    @DisplayName("Список заказов успешно получен")
    public void isGetAnyOrders() {
        ordersRequest = new OrdersRequest();
        ordersRequest.getOrders(3)
                .assertThat()
                .body("$", hasKey("orders"))
                .extract();
    }
}
