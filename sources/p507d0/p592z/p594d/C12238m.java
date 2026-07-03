package p507d0.p592z.p594d;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.z.d.m */
/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12238m {
    /* JADX INFO: renamed from: a */
    public static String m10092a(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX INFO: renamed from: b */
    public static <T extends Throwable> T m10093b(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(C1643a.m883w(str, " must not be null"));
        m10093b(illegalStateException, C12238m.class.getName());
        throw illegalStateException;
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(C1643a.m883w(str, " must not be null"));
        m10093b(nullPointerException, C12238m.class.getName());
        throw nullPointerException;
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(m10092a(str));
        m10093b(nullPointerException, C12238m.class.getName());
        throw nullPointerException;
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(m10092a(str));
        m10093b(illegalArgumentException, C12238m.class.getName());
        throw illegalArgumentException;
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    public static String stringPlus(String str, Object obj) {
        return C1643a.m881v(str, obj);
    }

    public static void throwJavaNpe() {
        NullPointerException nullPointerException = new NullPointerException();
        m10093b(nullPointerException, C12238m.class.getName());
        throw nullPointerException;
    }

    public static void throwNpe() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        m10093b(kotlinNullPointerException, C12238m.class.getName());
        throw kotlinNullPointerException;
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUninitializedProperty(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        m10093b(uninitializedPropertyAccessException, C12238m.class.getName());
        throw uninitializedPropertyAccessException;
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        throwUninitializedProperty("lateinit property " + str + " has not been initialized");
    }

    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }
}
