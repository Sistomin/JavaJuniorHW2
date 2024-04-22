import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Реализована анатация RandomDate
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomDate {
    long min() default 1704042000000L; // 1 января 2024 UTC+7 (в милисикундах)

    long max() default 1735664399000L; // 31 декабря 2024 UTC+7 (в милисикундах)

}
