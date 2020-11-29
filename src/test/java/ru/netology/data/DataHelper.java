package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    public static Card getApprovedCard() {
        return new Card("4444444444444441", "11", "20", "Dmitry Evdokimov", "123");
    }

    public static Card getDeclinedCard() {
        return new Card("4444444444444442", "11", "20", "Dmitry Evdokimov", "123");
    }

    public static Card getEmptyCard() {
        return new Card("", "", "", "", "");
    }

    public static Card getNumberCard15Symbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        int number = faker.number().randomDigit();
        return new Card("" + number, month, year, holder, cvv);
    }

    public static Card getCardNotInDatabase() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("1444444444444444", month, year, holder, cvv);
    }

    public static Card getCardMonth1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = faker.number().digit();
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardMonthOver12() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "13", year, holder, cvv);
    }

    public static Card getCardMonth00ThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "00", year, holder, cvv);
    }

    public static Card getCardMonth00OverThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", "00", year, holder, cvv);
    }

    public static Card getCardYear1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = faker.number().digit();
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardYearOverThisYearOn6() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardYearUnderThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardYear00() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, "00", holder, cvv);
    }

    public static Card getCardCvv1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(1);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardCvv2Symbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(2);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardHolder1Word() {
        Faker faker = new Faker();
        String holder = faker.name().firstName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardHolderCirillic() {
        Faker faker = new Faker(new Locale("ru"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardHolderNumeric() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.number().digit();
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }

    public static Card getCardSpecialSymbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " %$ * &";
        String month = LocalDate.now().plusMonths(faker.number().randomDigit()).format(DateTimeFormatter.ofPattern("MM"));
        String year = LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("YY"));
        String cvv = faker.number().digits(3);
        return new Card("4444444444444441", month, year, holder, cvv);
    }
}