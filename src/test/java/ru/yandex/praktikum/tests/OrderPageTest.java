package ru.yandex.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.praktikum.pageobgect.MainPage;
import ru.yandex.praktikum.pageobgect.OrderPage;

@RunWith(Parameterized.class)

public class OrderPageTest {
    WebDriver webDriver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String numberPhone;
    private final String time;
    private final String comment;
    private final boolean isOrderButton;

    public OrderPageTest(String name, String lastName, String address, String metroStation, String numberPhone, String time, String comment, boolean isOrderButton) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.numberPhone = numberPhone;
        this.time = time;
        this.comment = comment;
        this.isOrderButton = isOrderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Элла", "Элла", "ул. Яснополянская, д.7, кв. 98", "Рязанский проспект", "79853967227", "22.06.2023", "захватите, пож., поесть что-нибудь", true},
                {"СЕМЕН", "Петровсидоров", "Зеленоград", "Динамо", "79998887766", "13.07.2023", "не,я передумал, не надо мне ваших самокатов", false},
                {"Ангелинангелина", "Коломникова", "корпус 2014, кв. 101", "Речной вокзал", "79111111111", "01.01.01", "", true},
                {"Яя", "СноваЯ", "Кремль", "Лубянка", "12345678998", "14.06.2023", "захватите, пож., поесть что-нибудь", false},
        };
    }

    @Before
    public void setupAll() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }

    @Test
    public void shouldBeOrderScooterOnButtonPageHeaderWithRequiredFieldTest() {
        OrderPage orderPage = new OrderPage(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickButtonCookies();
        mainPage.clickOrderButton(isOrderButton);
        orderPage.enterOrderName(name);
        orderPage.enterOrderLastName(lastName);
        orderPage.enterOrderAddress(address);
        orderPage.enterMetroStation(metroStation);
        orderPage.clickMetroStationFull();
        orderPage.enterNumberPhone(numberPhone);
        orderPage.clickOrderButtonNext();
        orderPage.enterOrderTime(time);
        orderPage.clickOrderRentalPeriod();
        orderPage.enterOrderRentalTwoDay();
        orderPage.clickCheckBoxGreyColorScooter();
        orderPage.enterOrderComment(comment);
        orderPage.clickOrderButtonOnOrderPage();
        orderPage.clickOrderConfirmationButton();
        boolean isDisplayed = orderPage.checkOrderConfirmationIsDisplayed();
        Assert.assertTrue("Confirmation is not displayed", isDisplayed);
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        webDriver.quit();
    }
}