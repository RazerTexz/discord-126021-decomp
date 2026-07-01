package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReflectProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class c0 {
    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = "initializer";
        objArr[1] = "kotlin/reflect/jvm/internal/ReflectProperties";
        if (i == 1 || i == 2) {
            objArr[2] = "lazySoft";
        } else {
            objArr[2] = "lazy";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static <T> c0$b<T> lazy(Function0<T> function0) {
        if (function0 != null) {
            return new c0$b<>(function0);
        }
        a(0);
        throw null;
    }

    public static <T> c0$a<T> lazySoft(T t, Function0<T> function0) {
        if (function0 != null) {
            return new c0$a<>(t, function0);
        }
        a(1);
        throw null;
    }

    public static <T> c0$a<T> lazySoft(Function0<T> function0) {
        if (function0 != null) {
            return lazySoft(null, function0);
        }
        a(2);
        throw null;
    }
}
