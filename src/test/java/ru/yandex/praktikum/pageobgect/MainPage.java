package ru.yandex.praktikum.pageobgect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver webDriver;

    // локатор кнопки "Заказать" в заголовке главной страницы
    private By orderButton = By.xpath("//button[@class='Button_Button__ra12g']");

    //локатор кнопки "Заказать" в середине главной страницы
    private By orderButtonOnMiddlePage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор выпадающего списка вопроса "Сколько это стоит и как оплатить?"
    private By dropDownOneQuestion = By.xpath("(//div[@class='accordion__heading'])[1]");

    //локатор текста в первом выпадающем списке
    private By textDropDownOneQuestion = By.xpath("//*[@id='accordion__panel-0']/p");

    //локатор выпадающего списка вопроса "Хочу сразу несколько самокатов! Так можно?"
    private By dropDownTwoQuestion = By.xpath("(//div[@class='accordion__heading'])[2]");

    //локатор текста во втором выпадающем списке
    private By textDropDownTwoQuestion = By.xpath("//*[@id='accordion__panel-1']/p");

    //локатор выпадающего списка вопроса "Как рассчитывается время аренды?"
    private By dropDownThreeQuestion = By.xpath("(//div[@class='accordion__heading'])[3]");

    //локатор текста в третьем выпадающем списке
    private By textDropDownThreeQuestion = By.xpath("//*[@id='accordion__panel-2']/p");

    //локатор выпадающего списка вопроса "Можно ли заказать самокат прямо на сегодня?"
    private By dropDownFourQuestion = By.xpath("(//div[@class='accordion__heading'])[4]");

    //локатор текста в четвертом выпадающем списке
    private By textDropDownFourQuestion = By.xpath("//*[@id='accordion__panel-3']/p");

    //локатор выпадающего списка вопроса "Можно ли продлить заказ или вернуть самокат раньше?"
    private By dropDownFiveQuestion = By.xpath("(//div[@class='accordion__heading'])[5]");

    //локатор текста в пятом выпадающем списке
    private By textDropDownFiveQuestion = By.xpath("//*[@id='accordion__panel-4']/p");

    //локатор выпадающего списка вопроса "Вы привозите зарядку вместе с самокатом?"
    private By dropDownSixQuestion = By.xpath("(//div[@class='accordion__heading'])[6]");

    //локатор текста в шестом выпадающем списке
    private By textDropDownSixQuestion = By.xpath("//*[@id='accordion__panel-5']/p");

    //локатор выпадающего списка вопроса "Можно ли отменить заказ?"
    private By dropDownSevenQuestion = By.xpath("(//div[@class='accordion__heading'])[7]");

    //локатор текста в седьмом выпадающем списке
    private By textDropDownSevenQuestion = By.xpath("//*[@id='accordion__panel-6']/p");

    //локатор выпадающего списка вопроса "Я жизу за МКАДом, привезёте?"
    private By dropDownEightQuestion = By.xpath("(//div[@class='accordion__heading'])[8]");

    //локатор текста в восьмом выпадающем списке
    private By textDropDownEightuestion = By.xpath("//*[@id='accordion__panel-7']/p");

    // локатор кнопки куков "да все привыкли"
    private By buttonCookies = By.id("rcc-confirm-button");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOrderButton(boolean isOrderButton) {
        if (isOrderButton) {
            webDriver.findElement(orderButton).click();
        } else {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(orderButtonOnMiddlePage));
            webDriver.findElement(orderButtonOnMiddlePage).click();
        }
    }

    public void scrollToQuestion(By dropQuestion) {
        WebElement dropDownQuestionElement = webDriver.findElement(dropQuestion);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", dropDownQuestionElement);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(dropDownQuestionElement));
    }

    public String clickDropDownQuestion(String dropDownQuestion) {
        if ("Сколько это стоит? И как оплатить?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownOneQuestion);
            webDriver.findElement(dropDownOneQuestion).click();
            return webDriver.findElement(textDropDownOneQuestion).getText();
        } else if ("Хочу сразу несколько самокатов! Так можно?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownTwoQuestion);
            webDriver.findElement(dropDownTwoQuestion).click();
            return webDriver.findElement(textDropDownTwoQuestion).getText();
        } else if ("Как рассчитывается время аренды?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownThreeQuestion);
            webDriver.findElement(dropDownThreeQuestion).click();
            return webDriver.findElement(textDropDownThreeQuestion).getText();
        } else if ("Можно ли заказать самокат прямо на сегодня?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownFourQuestion);
            webDriver.findElement(dropDownFourQuestion).click();
            return webDriver.findElement(textDropDownFourQuestion).getText();
        } else if ("Можно ли продлить заказ или вернуть самокат раньше?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownFiveQuestion);
            webDriver.findElement(dropDownFiveQuestion).click();
            return webDriver.findElement(textDropDownFiveQuestion).getText();
        } else if ("Вы привозите зарядку вместе с самокатом?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownSixQuestion);
            webDriver.findElement(dropDownSixQuestion).click();
            return webDriver.findElement(textDropDownSixQuestion).getText();
        } else if ("Можно ли отменить заказ?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownSevenQuestion);
            webDriver.findElement(dropDownSevenQuestion).click();
            return webDriver.findElement(textDropDownSevenQuestion).getText();
        } else if ("Я жизу за МКАДом, привезёте?".equals(dropDownQuestion)) {
            scrollToQuestion(dropDownEightQuestion);
            webDriver.findElement(dropDownEightQuestion).click();
            return webDriver.findElement(textDropDownEightuestion).getText();
        } else {
            throw new IllegalArgumentException("Вопрос не найден: " + dropDownQuestion);
        }
    }

    public void clickButtonCookies() {
        webDriver.findElement(buttonCookies).click();
    }

}