package b.i.a.f.h.l;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class j7 {
    public static final Unsafe a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f1452b;
    public static final boolean c;
    public static final boolean d;
    public static final j7$c e;
    public static final boolean f;
    public static final boolean g;
    public static final long h;
    public static final boolean i;

    static {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        j7$c j7_c;
        Unsafe unsafeK = k();
        a = unsafeK;
        f1452b = q3.a;
        Class<?> cls = Long.TYPE;
        boolean zP = p(cls);
        c = zP;
        Class<?> cls2 = Integer.TYPE;
        boolean zP2 = p(cls2);
        d = zP2;
        j7$c j7_d = null;
        if (unsafeK != null) {
            if (!q3.a()) {
                j7_d = new j7$d(unsafeK);
            } else if (zP) {
                j7_d = new j7$a(unsafeK);
            } else if (zP2) {
                j7_d = new j7$b(unsafeK);
            }
        }
        e = j7_d;
        if (unsafeK == null) {
            str = "getByte";
            z2 = false;
        } else {
            try {
                Class<?> cls3 = unsafeK.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (s() == null) {
                    str = "getByte";
                    z2 = false;
                } else {
                    if (q3.a()) {
                        str = "getByte";
                    } else {
                        cls3.getMethod("getByte", cls);
                        Class<?>[] clsArr = new Class[2];
                        clsArr[0] = cls;
                        str = "getByte";
                        try {
                            clsArr[1] = Byte.TYPE;
                            cls3.getMethod("putByte", clsArr);
                            cls3.getMethod("getInt", cls);
                            cls3.getMethod("putInt", cls, cls2);
                            cls3.getMethod("getLong", cls);
                            cls3.getMethod("putLong", cls, cls);
                            cls3.getMethod("copyMemory", cls, cls, cls);
                            cls3.getMethod("copyMemory", Object.class, cls, Object.class, cls, cls);
                        } catch (Throwable th) {
                            th = th;
                            Logger logger = Logger.getLogger(j7.class.getName());
                            Level level = Level.WARNING;
                            String strValueOf = String.valueOf(th);
                            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", b.d.b.a.a.j(strValueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", strValueOf));
                            z2 = false;
                        }
                    }
                    z2 = true;
                }
            } catch (Throwable th2) {
                th = th2;
                str = "getByte";
            }
        }
        f = z2;
        Unsafe unsafe = a;
        if (unsafe == null) {
            z4 = false;
        } else {
            try {
                Class<?> cls4 = unsafe.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                Class<?>[] clsArr2 = new Class[2];
                clsArr2[0] = Object.class;
                Class<?> cls5 = Long.TYPE;
                boolean z6 = true;
                try {
                    clsArr2[1] = cls5;
                    cls4.getMethod("getInt", clsArr2);
                    Class<?>[] clsArr3 = new Class[3];
                    clsArr3[0] = Object.class;
                    clsArr3[1] = cls5;
                    clsArr3[2] = Integer.TYPE;
                    cls4.getMethod("putInt", clsArr3);
                    Class<?>[] clsArr4 = new Class[2];
                    clsArr4[0] = Object.class;
                    clsArr4[1] = cls5;
                    cls4.getMethod("getLong", clsArr4);
                    Class<?>[] clsArr5 = new Class[3];
                    clsArr5[0] = Object.class;
                    clsArr5[1] = cls5;
                    clsArr5[2] = cls5;
                    cls4.getMethod("putLong", clsArr5);
                    cls4.getMethod("getObject", Object.class, cls5);
                    cls4.getMethod("putObject", Object.class, cls5, Object.class);
                    if (!q3.a()) {
                        cls4.getMethod(str, Object.class, cls5);
                        cls4.getMethod("putByte", Object.class, cls5, Byte.TYPE);
                        cls4.getMethod("getBoolean", Object.class, cls5);
                        cls4.getMethod("putBoolean", Object.class, cls5, Boolean.TYPE);
                        Class<?>[] clsArr6 = new Class[2];
                        clsArr6[0] = Object.class;
                        clsArr6[1] = cls5;
                        cls4.getMethod("getFloat", clsArr6);
                        Class<?>[] clsArr7 = new Class[3];
                        clsArr7[0] = Object.class;
                        clsArr7[1] = cls5;
                        clsArr7[2] = Float.TYPE;
                        cls4.getMethod("putFloat", clsArr7);
                        Class<?>[] clsArr8 = new Class[2];
                        clsArr8[0] = Object.class;
                        z6 = true;
                        clsArr8[1] = cls5;
                        cls4.getMethod("getDouble", clsArr8);
                        cls4.getMethod("putDouble", Object.class, cls5, Double.TYPE);
                    }
                    z4 = true;
                } catch (Throwable th3) {
                    th = th3;
                    z3 = z6;
                    Logger logger2 = Logger.getLogger(j7.class.getName());
                    Level level2 = Level.WARNING;
                    String strValueOf2 = String.valueOf(th);
                    logger2.logp(level2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", b.d.b.a.a.j(strValueOf2.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", strValueOf2));
                    z4 = false;
                    z5 = z3;
                }
            } catch (Throwable th4) {
                th = th4;
                z3 = true;
            }
        }
        z5 = true;
        g = z4;
        h = h(byte[].class);
        h(boolean[].class);
        j(boolean[].class);
        h(int[].class);
        j(int[].class);
        h(long[].class);
        j(long[].class);
        h(float[].class);
        j(float[].class);
        h(double[].class);
        j(double[].class);
        h(Object[].class);
        j(Object[].class);
        Field fieldS = s();
        if (fieldS != null && (j7_c = e) != null) {
            j7_c.a.objectFieldOffset(fieldS);
        }
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z5 = false;
        }
        i = z5;
    }

    public static byte a(byte[] bArr, long j) {
        return e.a(bArr, h + j);
    }

    public static int b(Object obj, long j) {
        return e.k(obj, j);
    }

    public static <T> T c(Class<T> cls) {
        try {
            return (T) a.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static void d(Object obj, long j, double d2) {
        e.c(obj, j, d2);
    }

    public static void e(Object obj, long j, long j2) {
        e.f(obj, j, j2);
    }

    public static void f(Object obj, long j, Object obj2) {
        e.a.putObject(obj, j, obj2);
    }

    public static void g(byte[] bArr, long j, byte b2) {
        e.b(bArr, h + j, b2);
    }

    public static int h(Class<?> cls) {
        if (g) {
            return e.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static long i(Object obj, long j) {
        return e.l(obj, j);
    }

    public static int j(Class<?> cls) {
        if (g) {
            return e.a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new i7());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void l(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iB = b(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        e.e(obj, j2, ((255 & b2) << i2) | (iB & (~(255 << i2))));
    }

    public static boolean m(Object obj, long j) {
        return e.h(obj, j);
    }

    public static float n(Object obj, long j) {
        return e.i(obj, j);
    }

    public static void o(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i2 = (((int) j) & 3) << 3;
        e.e(obj, j2, ((255 & b2) << i2) | (b(obj, j2) & (~(255 << i2))));
    }

    public static boolean p(Class<?> cls) {
        if (!q3.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f1452b;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static double q(Object obj, long j) {
        return e.j(obj, j);
    }

    public static Object r(Object obj, long j) {
        return e.a.getObject(obj, j);
    }

    public static Field s() {
        Field declaredField;
        Field declaredField2;
        if (q3.a()) {
            try {
                declaredField2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                declaredField2 = null;
            }
            if (declaredField2 != null) {
                return declaredField2;
            }
        }
        try {
            declaredField = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            declaredField = null;
        }
        if (declaredField == null || declaredField.getType() != Long.TYPE) {
            return null;
        }
        return declaredField;
    }

    public static byte t(Object obj, long j) {
        return (byte) (b(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    public static byte u(Object obj, long j) {
        return (byte) (b(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }
}
