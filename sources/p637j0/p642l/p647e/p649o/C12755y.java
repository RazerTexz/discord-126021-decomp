package p637j0.p642l.p647e.p649o;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: j0.l.e.o.y */
/* JADX INFO: compiled from: UnsafeAccess.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12755y {

    /* JADX INFO: renamed from: a */
    public static final Unsafe f27357a;

    /* JADX INFO: renamed from: b */
    public static final boolean f27358b;

    static {
        f27358b = System.getProperty("rx.unsafe-disable") != null;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        f27357a = unsafe;
    }

    /* JADX INFO: renamed from: a */
    public static long m10857a(Class<?> cls, String str) {
        try {
            return f27357a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10858b() {
        return (f27357a == null || f27358b) ? false : true;
    }
}
