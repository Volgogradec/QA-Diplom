package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.pages.paymentMethod;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditGateTest {
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
    void creditPositiveAllFieldValid() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getValidCard());
        payment.waitNotificationApproved();
        assertEquals("OK", "OK");
    }

    @Test
    void creditNegativeAllFieldEmpty() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getEmptyCard());
        payment.waitNotificationWrongFormat4Fields();
    }

    @Test
    void creditNegativeNumberCard15Symbols() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getNumberCard15Symbols());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeCardNotInDatabase() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardNotInDatabase());
        payment.waitNotificationFailure();
    }

    @Test
    void creditNegativeMonth1Symbol() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardMonth1Symbol());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeMonthOver12() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardMonthOver12());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void creditNegativeMonth00ThisYear() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardMonth00ThisYear());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void creditNegativeMonth00OverThisYear() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardMonth00OverThisYear());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void creditNegativeYear00() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardYear00());
        payment.waitNotificationExpiredError();
    }

    @Test
    void creditNegativeYear1Symbol() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardYear1Symbol());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeYearUnderThisYear() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardYearUnderThisYear());
        payment.waitNotificationExpiredError();
    }

    @Test
    void creditNegativeYearOverThisYearOn6() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardYearOverThisYearOn6());
        payment.waitNotificationExpirationDateError();
    }

    @Test
    void creditNegativeCvv1Symbol() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardCvv1Symbol());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeCvv2Symbols() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardCvv2Symbols());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeOwner1Word() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardHolder1Word());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeOwnerCirillic() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardHolderCirillic());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeOwnerNumeric() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardHolderNumeric());
        payment.waitNotificationWrongFormat();
    }

    @Test
    void creditNegativeOwnerSpecialSymbols() {
        val startPage = new paymentMethod();
        val payment = startPage.goToCreditPage();
        payment.inputData(DataHelper.getCardSpecialSymbols());
        payment.waitNotificationWrongFormat();
    }
}
