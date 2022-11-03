import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practicum.orders.Order;
import ru.yandex.practicum.orders.OrdersRequest;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class OrderRequestWithParamsTest {
    Order order;
    OrdersRequest ordersRequest;
    private final String color;

    public OrderRequestWithParamsTest(String color){
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getColorData() {
        return new Object[][] {
                {"BLACK"},
                {"GREY"},
                {""},
        };
    }

    @Test
    @DisplayName("Проверка создания заказа с одним цветом самокатов")
    public void isOrderWithOneColorCreated() {
         order = order.getRandomOrderWithColor(new String[]{color});
         ordersRequest = new OrdersRequest();
         ordersRequest.createOrder(order)
                 .assertThat()
                 .statusCode(201)
                 .body("track", notNullValue());
        }
    @Test
    @DisplayName("Проверка создания заказа с произвольным форматом данных")
    public void isOrderCreated(){
        order = order.getRandomOrderWithRandomDataFormat(new String[]{color});
        ordersRequest = new OrdersRequest();
        ordersRequest.createOrder(order)
                .assertThat()
                .statusCode(201)
                .body("track", notNullValue());
    }
    }
