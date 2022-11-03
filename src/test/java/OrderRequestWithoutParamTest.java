import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.practicum.orders.Order;
import ru.yandex.practicum.orders.OrdersRequest;
import static org.hamcrest.CoreMatchers.notNullValue;

public class OrderRequestWithoutParamTest {
    Order order;
    OrdersRequest ordersRequest;

    @Test
    @DisplayName("Проверка создания заказа с двумя цветами самокатов")
    public void isOrderWithTwoColorsCreated(){
        final String[] twoColors = new String[]{"BLACK", "GREY"};
        order = order.getRandomOrderWithColor(twoColors);
        ordersRequest = new OrdersRequest();
        ordersRequest.createOrder(order)
                .assertThat()
                .statusCode(201)
                .body("track", notNullValue());
    }

    @Test
    @DisplayName("Проверка создания заказа без необязательного поля color")
    public void isOrderWithoutColorsCreated(){
        order = order.getRandomOrderWithoutColor();
        ordersRequest = new OrdersRequest();
        ordersRequest.createOrder(order)
                .assertThat()
                .statusCode(201)
                .body("track", notNullValue());
    }
    }
