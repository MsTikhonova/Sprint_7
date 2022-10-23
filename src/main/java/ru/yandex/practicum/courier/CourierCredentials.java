package ru.yandex.practicum.courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierCredentials {
    private String login;
    private String password;

    public CourierCredentials(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public CourierCredentials(String login) {
        this.login = login;
    }

    public static CourierCredentials from(Courier courier) {
        return new CourierCredentials(courier.getLogin(), courier.getPassword());
    }

    public static CourierCredentials withoutPasswordFrom(Courier courier) {
        return new CourierCredentials(courier.getLogin());
    }

}
