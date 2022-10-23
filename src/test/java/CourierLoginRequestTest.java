import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.courier.Courier;
import ru.yandex.practicum.courier.CourierClient;
import ru.yandex.practicum.courier.CourierCredentials;

import static org.junit.Assert.*;

public class CourierLoginRequestTest {

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
        courierClient.delete(courierId);
    }

    @Test
    public void isCourierLoggedIn(){
        boolean isOk = courierClient.create(courier);
        assertTrue(isOk);

        CourierCredentials creds = CourierCredentials.from(courier);
        courierId = courierClient.login(creds);

        assertNotEquals(0, courierId);
    }

    @Test
    public void isCourierDoesNotLoggedInWithoutPassword(){
        boolean isOk = courierClient.create(courier);
        assertTrue(isOk);

        CourierCredentials creds = CourierCredentials.withoutPasswordFrom(courier);
        String messageBadRequest = courierClient.loginBadRequest(creds);
        assertEquals("Недостаточно данных для входа", messageBadRequest);
    }
}
