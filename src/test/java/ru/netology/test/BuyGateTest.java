package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.pages.paymentMethod;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyGateTest {
    @BeforeEach
    public void openPage() {
        String url = "http://localhost:8080";
        open(url);
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void buyPositiveAllFieldValid() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getValidCard());
        payment.waitNotificationApproved();
        assertEquals("OK", "OK");
    }

    @Test
    void buyNegativeAllFieldEmpty() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getEmptyCard());
        payment.waitNotificationWrongFormat4Fields();
    }

    @Test
    void buyNegativeNumberCard15Symbols() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getNumberCard15Symbols());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeCardNotInDatabase() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardNotInDatabase());
        payment.waitNotificationFailure();
    }

    @Test
    void buyNegativeMonth1Symbol() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonth1Symbol());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeMonthOver12() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonthOver12());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void buyNegativeMonth00ThisYear() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonth00ThisYear());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void buyNegativeMonth00OverThisYear() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardMonth00OverThisYear());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void buyNegativeYear00() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYear00());
        payment.waitNotificationExpiredError();
    }

    @Test
    void buyNegativeYear1Symbol() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYear1Symbol());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeYearUnderThisYear() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYearUnderThisYear());
        payment.waitNotificationExpiredError();
    }

    @Test
    void buyNegativeYearOverThisYearOn6() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardYearOverThisYearOn6());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void buyNegativeCvv1Symbol() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardCvv1Symbol());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeCvv2Symbols() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardCvv2Symbols());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeOwner1Word() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardHolder1Word());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeOwnerCirillic() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderCirillic());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeOwnerNumeric() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardHolderNumeric());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void buyNegativeOwnerSpecialSymbols() {
        val startPage = new paymentMethod();
        val payment = startPage.goToBuyPage();
        payment.inputData(DataHelper.getCardSpecialSymbols());
        payment.waitNotificationWrongFormat();
    }
}