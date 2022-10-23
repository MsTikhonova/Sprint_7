import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.courier.Courier;
import ru.yandex.practicum.courier.CourierClient;
import ru.yandex.practicum.courier.CourierCredentials;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourierRequestTest {

    Courier courier;
    CourierClient courierClient;
    private int courierId;

    @Before
    public void setup(){
        courier = Courier.getRandomCourier();
        courierClient = new CourierClient();
    }

    @After
    public void teardown(){

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);
        courierClient.delete(courierId);
    }

    @Test
    public void isCourierCreated(){
        boolean isOk = courierClient.create(courier);
        assertTrue(isOk);
    }

    @Test
    public void isDuplicateCreated(){
        boolean isOk = courierClient.create(courier);
        assertTrue(isOk);

        String message = courierClient.createConflict(courier);
        assertEquals("Этот логин уже используется", message);
    }

    @Test
    public void isCourierNotCreatedWithoutPassword(){
        courier = Courier.getCourierWithoutPassword();

        String messageBadRequest = courierClient.createBadRequest(courier);
        assertEquals("Недостаточно данных для создания учетной записи", messageBadRequest);

    }

}
