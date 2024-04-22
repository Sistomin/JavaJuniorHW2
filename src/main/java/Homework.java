import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Домашняя работа №2 по курсу Java Junior
 * Истомина Сергея, группа 6413
 *
 *  Task:
 *  1. Создать аннотацию RandomDate со следующими возможностями:
 *  1.1 Если параметры не заданы, то в поле должна вставляться рандомная дата в диапазоне min, max.
 *  1.2 Аннотация должна работать с полем типа java.util.Date.
 *  1.3 Должна генерить дату в диапазоне [min, max)
 *  1.4 ** Научиться работать с полями LocalDateTime, LocalDate, Instant, ... (классы java.time.*)
 *  Реализовать класс RandomDateProcessor по аналогии с RandomIntegerProcessor, который обрабатывает аннотацию.
 *
 */

//Класс для проверки ДЗ, вывод данных в консоль
public class Homework {
    //region Проверка ДЗ
    public static void main(String[] args) {

        DateClass dateClass = new DateClass();
        RandomDateProcessor.processRandomDate(dateClass);


        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Check Date:");
        System.out.println(format.format(dateClass.dateDate1) + " -> рандомная дата за весь 2024 год");
        System.out.println(format.format(dateClass.dateDate2) + " -> рандомная дата с 20.03.1985 по 21.04.2024");
        System.out.println(format.format(dateClass.dateDate3) + " -> рандомная дата с 21.04.2024 до конца 2024 года (с сейчас до 2024 конца года)");
        System.out.println(format.format(dateClass.dateDate4) + " -> рандомная дата с 01.01.1970 до 21.04.2024 (начала Java до сейчас)");
        System.out.println();


        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Check LocalDate:");
        System.out.println(dateClass.localDate1.format(localFormat) + " -> рандомная дата за весь 2024 год");
        System.out.println(dateClass.localDate2.format(localFormat) + " -> рандомная дата с 20.03.1985 по 21.04.2024");
        System.out.println(dateClass.localDate3.format(localFormat) + " -> рандомная дата с 21.04.2024 до конца 2024 года (с сейчас до конца 2024 года)");
        System.out.println(dateClass.localDate4.format(localFormat) + " -> рандомная дата с 01.01.1970 до 21.04.2024 (начала Java до сейчас)");
        System.out.println();

        DateTimeFormatter localTimeFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        System.out.println("Check localDateTime:");
        System.out.println(dateClass.localDateTime1.format(localTimeFormat) + " -> рандомная дата за весь 2024 год");
        System.out.println(dateClass.localDateTime2.format(localTimeFormat) + " -> рандомная дата с 20.03.1985 по 21.04.2024");
        System.out.println(dateClass.localDateTime3.format(localTimeFormat) + " -> рандомная дата с 21.04.2024 до конца 2024 года (с сейчас до конца 2024 года)");
        System.out.println(dateClass.localDateTime4.format(localTimeFormat) + " -> рандомная дата с 01.01.1970 до 21.04.2024 (начала Java до сейчас)");
        System.out.println();

        System.out.println("Check instant:");
        System.out.println(dateClass.instant1 + " -> рандомная дата за весь 2024 год");
        System.out.println(dateClass.instant2 + " -> рандомная дата с 20.03.1985 по 21.04.2024");
        System.out.println(dateClass.instant3 + " -> рандомная дата с 21.04.2024 до конца 2024 года (с сейчас до конца 2024 года)");
        System.out.println(dateClass.instant4 + " -> рандомная дата с 01.01.1970 до 21.04.2024 (начала Java до сейчас)");
        System.out.println();

        System.out.println("Check zonedDate:");
        System.out.println(dateClass.zonedDate1 + " -> рандомная дата за весь 2024 год");
        System.out.println(dateClass.zonedDate2 + " -> рандомная дата с 20.03.1985 по 21.04.2024");
        System.out.println(dateClass.zonedDate3 + " -> рандомная дата с 21.04.2024 до конца 2024 года (с сейчас до конца 2024 года)");
        System.out.println(dateClass.zonedDate4 + " -> рандомная дата с 01.01.1970 до 21.04.2024 (начала Java до сейчас)");
        System.out.println();

        System.out.println("Check offsetDate:");
        System.out.println(dateClass.offsetDate1 + " -> рандомная дата за весь 2024 год");
        System.out.println(dateClass.offsetDate2 + " -> рандомная дата с 20.03.1985 по 21.04.2024");
        System.out.println(dateClass.offsetDate3 + " -> рандомная дата с 21.04.2024 до конца 2024 года (с сейчас до конца 2024 года)");
        System.out.println(dateClass.offsetDate4 + " -> рандомная дата с 01.01.1970 до 21.04.2024 (начала Java до сейчас)");
        System.out.println();

    }
    //endregion

    //region Класс вспомогательный для проверки ДЗ
    private static class DateClass {

        @RandomDate
        private Date dateDate1; // По умолчанию весь 2024 год

        @RandomDate(min = 480099600000L, max = 1713681059000L) // 20.03.1985 - 21.04.2024 13:30:59
        private Date dateDate2;

        @RandomDate(min = 1713681059000L) // с 21.04.2024 13:30:59 до конца 2024 года
        private Date dateDate3;

        @RandomDate(min = 0L, max = 1713681059000L) // с 01.01.1970 до 21.04.2024 13:30:59
        private Date dateDate4;


        @RandomDate
        private LocalDate localDate1; // По умолчанию весь 2024 год

        @RandomDate(min = 480099600000L, max = 1713681059000L) // 20.03.1985 - 21.04.2024 13:30:59
        private LocalDate localDate2;

        @RandomDate(min = 1713681059000L) // с 21.04.2024 13:30:59 до конца 2024 года
        private LocalDate localDate3;

        @RandomDate(min = 0L, max = 1713681059000L) // с 01.01.1970 до 21.04.2024 13:30:59
        private LocalDate localDate4;

        @RandomDate
        private LocalDateTime localDateTime1; // По умолчанию весь 2024 год

        @RandomDate(min = 946674000000L, max = 978210000000L) // 20.03.1985 - 21.04.2024 13:30:59
        private LocalDateTime localDateTime2;

        @RandomDate(min = 1713474000000L) // с 21.04.2024 13:30:59 до конца 2024 года
        private LocalDateTime localDateTime3;

        @RandomDate(min = 0L, max = 946674000000L) // с 01.01.1970 до 21.04.2024 13:30:59
        private LocalDateTime localDateTime4;


        @RandomDate
        private Instant instant1; // По умолчанию весь 2024 год

        @RandomDate(min = 946674000000L, max = 978210000000L) // 20.03.1985 - 21.04.2024 13:30:59
        private Instant instant2;

        @RandomDate(min = 1713474000000L) // с 21.04.2024 13:30:59 до конца 2024 года
        private Instant instant3;

        @RandomDate(min = 0L, max = 946674000000L) // с 01.01.1970 до 21.04.2024 13:30:59
        private Instant instant4;


        @RandomDate
        private ZonedDateTime zonedDate1; // По умолчанию весь 2024 год

        @RandomDate(min = 946674000000L, max = 978210000000L) // 20.03.1985 - 21.04.2024 13:30:59
        private ZonedDateTime zonedDate2;

        @RandomDate(min = 1713474000000L) // с 21.04.2024 13:30:59 до конца 2024 года
        private ZonedDateTime zonedDate3;

        @RandomDate(min = 0L, max = 946674000000L) // с 01.01.1970 до 21.04.2024 13:30:59
        private ZonedDateTime zonedDate4;


        @RandomDate
        private OffsetDateTime offsetDate1; // По умолчанию весь 2024 год

        @RandomDate(min = 946674000000L, max = 978210000000L) // 20.03.1985 - 21.04.2024 13:30:59
        private OffsetDateTime offsetDate2;

        @RandomDate(min = 1713474000000L) // с 21.04.2024 13:30:59 до конца 2024 года
        private OffsetDateTime offsetDate3;

        @RandomDate(min = 0L, max = 946674000000L) // с 01.01.1970 до 21.04.2024 13:30:59
        private OffsetDateTime offsetDate4;
    }
    //endregion
}