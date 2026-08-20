package lombok.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: discord-126021.apk:lombok/core/HandlerPriority.SCL.lombok */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HandlerPriority {
    int value();

    int subValue() default 0;
}
