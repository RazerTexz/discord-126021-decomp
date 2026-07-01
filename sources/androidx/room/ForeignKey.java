package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.CLASS)
public @interface ForeignKey {
    public static final int CASCADE = 5;
    public static final int NO_ACTION = 1;
    public static final int RESTRICT = 2;
    public static final int SET_DEFAULT = 4;
    public static final int SET_NULL = 3;

    String[] childColumns();

    boolean deferred() default false;

    Class<?> entity();

    @ForeignKey$Action
    int onDelete() default 1;

    @ForeignKey$Action
    int onUpdate() default 1;

    String[] parentColumns();
}
