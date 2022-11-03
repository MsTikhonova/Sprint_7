package ru.yandex.practicum.orders;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;

public class Order {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private Number rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;


    public Order(String firstName, String lastName, String address, String metroStation, String phone, Number rentTime, String deliveryDate, String comment, String[] color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    public Order(String firstName, String lastName, String address, String metroStation, String phone, Number rentTime, String deliveryDate, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    public static Order getRandomOrderWithColor(String[] color) {
        Faker faker = new Faker();
        return new Order(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                faker.expression("#{numerify '+79#########'}"),
//              заменён харкод в комментарии ниже
//                "+7" + RandomStringUtils.randomNumeric(10),
                RandomUtils.nextInt(1,9),
                faker.date().future(10, TimeUnit.DAYS, "YYYY-MM-dd"),
//              заменён харкод в комментарии ниже
//                "20" +RandomUtils.nextInt(0,22)+"-"+RandomUtils.nextInt(1,12)+"-"+RandomUtils.nextInt(1,28),
                RandomStringUtils.randomAlphabetic(10),
                color
        );
    }

    public static Order getRandomOrderWithoutColor() {
        Faker faker = new Faker();
        return new Order(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                faker.expression("#{numerify '+79#########'}"),
//              заменён харкод в комментарии ниже
//                "+7" + RandomStringUtils.randomNumeric(10),
                RandomUtils.nextInt(1,9),
                faker.date().future(10, TimeUnit.DAYS, "YYYY-MM-dd"),
//              заменён харкод в комментарии ниже
//                "20" +RandomUtils.nextInt(0,22)+"-"+RandomUtils.nextInt(1,12)+"-"+RandomUtils.nextInt(1,28),
                RandomStringUtils.randomAlphabetic(10)
        );
    }

    public static Order getRandomOrderWithRandomDataFormat(String[] color) {
        return new Order(
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                RandomUtils.nextInt(1,9),
                RandomStringUtils.randomAlphabetic(10),
                RandomStringUtils.randomAlphabetic(10),
                color
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Number getRentTime() {
        return rentTime;
    }

    public void setRentTime(Number rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }
}
