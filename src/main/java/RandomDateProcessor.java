import java.lang.reflect.Field;
import java.time.*;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Реализован RandomDateProcessor по аналогии с RandomIntegerProcessor, который обрабатывает аннотацию RandomDate
 */
public class RandomDateProcessor {
    private static final long MILLISECONDS_IN_DAY = 86400000L; //(в милисикундах)
    private static final long MILLISECONDS_IN_SEC = 1000L; //(в милисикундах)

    public static void processRandomDate(Object obj) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomDate.class)) {
                RandomDate annotation = field.getAnnotation(RandomDate.class);
                long min = annotation.min();
                long max = annotation.max();

                field.setAccessible(true);
                try {
                    if (field.getType().equals(Date.class)) {
                        field.set(obj, new Date(ThreadLocalRandom.current().nextLong(min, max)));
                    } else if (field.getType().equals(LocalDate.class)) {
                        // Объект LocalDate получаем из количества дней, прошедщих с начала java (01.01.1970)
                        field.set(obj, LocalDate.ofEpochDay(
                                ThreadLocalRandom.current().nextLong(min, max) / MILLISECONDS_IN_DAY));
                    } else if (field.getType().equals(LocalDateTime.class)) {
                        // Объект LocalDateTime получаем из количества секунд, прошедших с начала java (01.01.1970)
                        field.set(obj, LocalDateTime.ofEpochSecond(
                                ThreadLocalRandom.current().nextLong(min, max) / MILLISECONDS_IN_SEC,
                                0, ZoneOffset.ofHours(-3)));
                    } else if (field.getType().equals(Instant.class)) {
                        // Объект Instant получаем из количества миллисекунд, прошедших с начала java (01.01.1970)
                        field.set(obj, Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong(min, max)));
                    } else if (field.getType().equals(ZonedDateTime.class)) {
                        // Объект ZonedDateTime получаем из объекта Instant и системного ID для временной зоны
                        field.set(obj, ZonedDateTime.ofInstant(
                                Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong(min, max)),
                                ZoneId.systemDefault()));
                    } else if (field.getType().equals(OffsetDateTime.class)) {
                        // Объект OffsetDateTime получаем из объекта Instant и системного ID для временной зоны
                        field.set(obj, OffsetDateTime.ofInstant(
                                Instant.ofEpochMilli(ThreadLocalRandom.current().nextLong(min, max)),
                                ZoneId.systemDefault()));
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("Не удалось установить случайное значение в поле даты " + e);
                }
                field.setAccessible(false);
            }
        }
    }
}
