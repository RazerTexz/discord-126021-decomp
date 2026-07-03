package p007b.p225i.p226a.p288f.p313h.p325l;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import p007b.p100d.p104b.p105a.C1643a;
import sun.misc.Unsafe;

/* JADX INFO: renamed from: b.i.a.f.h.l.j7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3711j7 {

    /* JADX INFO: renamed from: a */
    public static final Unsafe f10032a;

    /* JADX INFO: renamed from: b */
    public static final Class<?> f10033b;

    /* JADX INFO: renamed from: c */
    public static final boolean f10034c;

    /* JADX INFO: renamed from: d */
    public static final boolean f10035d;

    /* JADX INFO: renamed from: e */
    public static final c f10036e;

    /* JADX INFO: renamed from: f */
    public static final boolean f10037f;

    /* JADX INFO: renamed from: g */
    public static final boolean f10038g;

    /* JADX INFO: renamed from: h */
    public static final long f10039h;

    /* JADX INFO: renamed from: i */
    public static final boolean f10040i;

    /* JADX INFO: renamed from: b.i.a.f.h.l.j7$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class a extends c {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: a */
        public final byte mo4997a(Object obj, long j) {
            return C3711j7.f10040i ? C3711j7.m4995t(obj, j) : C3711j7.m4996u(obj, j);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: b */
        public final void mo4998b(Object obj, long j, byte b2) {
            if (C3711j7.f10040i) {
                C3711j7.m4987l(obj, j, b2);
            } else {
                C3711j7.m4990o(obj, j, b2);
            }
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: c */
        public final void mo4999c(Object obj, long j, double d) {
            m5006f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: d */
        public final void mo5000d(Object obj, long j, float f) {
            m5005e(obj, j, Float.floatToIntBits(f));
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: g */
        public final void mo5001g(Object obj, long j, boolean z2) {
            if (C3711j7.f10040i) {
                C3711j7.m4987l(obj, j, z2 ? (byte) 1 : (byte) 0);
            } else {
                C3711j7.m4990o(obj, j, z2 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: h */
        public final boolean mo5002h(Object obj, long j) {
            if (C3711j7.f10040i) {
                return C3711j7.m4995t(obj, j) != 0;
            }
            return C3711j7.m4996u(obj, j) != 0;
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: i */
        public final float mo5003i(Object obj, long j) {
            return Float.intBitsToFloat(m5007k(obj, j));
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: j */
        public final double mo5004j(Object obj, long j) {
            return Double.longBitsToDouble(m5008l(obj, j));
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.j7$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class b extends c {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: a */
        public final byte mo4997a(Object obj, long j) {
            return C3711j7.f10040i ? C3711j7.m4995t(obj, j) : C3711j7.m4996u(obj, j);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: b */
        public final void mo4998b(Object obj, long j, byte b2) {
            if (C3711j7.f10040i) {
                C3711j7.m4987l(obj, j, b2);
            } else {
                C3711j7.m4990o(obj, j, b2);
            }
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: c */
        public final void mo4999c(Object obj, long j, double d) {
            m5006f(obj, j, Double.doubleToLongBits(d));
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: d */
        public final void mo5000d(Object obj, long j, float f) {
            m5005e(obj, j, Float.floatToIntBits(f));
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: g */
        public final void mo5001g(Object obj, long j, boolean z2) {
            if (C3711j7.f10040i) {
                C3711j7.m4987l(obj, j, z2 ? (byte) 1 : (byte) 0);
            } else {
                C3711j7.m4990o(obj, j, z2 ? (byte) 1 : (byte) 0);
            }
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: h */
        public final boolean mo5002h(Object obj, long j) {
            if (C3711j7.f10040i) {
                return C3711j7.m4995t(obj, j) != 0;
            }
            return C3711j7.m4996u(obj, j) != 0;
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: i */
        public final float mo5003i(Object obj, long j) {
            return Float.intBitsToFloat(m5007k(obj, j));
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: j */
        public final double mo5004j(Object obj, long j) {
            return Double.longBitsToDouble(m5008l(obj, j));
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.j7$c */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class c {

        /* JADX INFO: renamed from: a */
        public Unsafe f10041a;

        public c(Unsafe unsafe) {
            this.f10041a = unsafe;
        }

        /* JADX INFO: renamed from: a */
        public abstract byte mo4997a(Object obj, long j);

        /* JADX INFO: renamed from: b */
        public abstract void mo4998b(Object obj, long j, byte b2);

        /* JADX INFO: renamed from: c */
        public abstract void mo4999c(Object obj, long j, double d);

        /* JADX INFO: renamed from: d */
        public abstract void mo5000d(Object obj, long j, float f);

        /* JADX INFO: renamed from: e */
        public final void m5005e(Object obj, long j, int i) {
            this.f10041a.putInt(obj, j, i);
        }

        /* JADX INFO: renamed from: f */
        public final void m5006f(Object obj, long j, long j2) {
            this.f10041a.putLong(obj, j, j2);
        }

        /* JADX INFO: renamed from: g */
        public abstract void mo5001g(Object obj, long j, boolean z2);

        /* JADX INFO: renamed from: h */
        public abstract boolean mo5002h(Object obj, long j);

        /* JADX INFO: renamed from: i */
        public abstract float mo5003i(Object obj, long j);

        /* JADX INFO: renamed from: j */
        public abstract double mo5004j(Object obj, long j);

        /* JADX INFO: renamed from: k */
        public final int m5007k(Object obj, long j) {
            return this.f10041a.getInt(obj, j);
        }

        /* JADX INFO: renamed from: l */
        public final long m5008l(Object obj, long j) {
            return this.f10041a.getLong(obj, j);
        }
    }

    /* JADX INFO: renamed from: b.i.a.f.h.l.j7$d */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class d extends c {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: a */
        public final byte mo4997a(Object obj, long j) {
            return this.f10041a.getByte(obj, j);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: b */
        public final void mo4998b(Object obj, long j, byte b2) {
            this.f10041a.putByte(obj, j, b2);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: c */
        public final void mo4999c(Object obj, long j, double d) {
            this.f10041a.putDouble(obj, j, d);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: d */
        public final void mo5000d(Object obj, long j, float f) {
            this.f10041a.putFloat(obj, j, f);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: g */
        public final void mo5001g(Object obj, long j, boolean z2) {
            this.f10041a.putBoolean(obj, j, z2);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: h */
        public final boolean mo5002h(Object obj, long j) {
            return this.f10041a.getBoolean(obj, j);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: i */
        public final float mo5003i(Object obj, long j) {
            return this.f10041a.getFloat(obj, j);
        }

        @Override // p007b.p225i.p226a.p288f.p313h.p325l.C3711j7.c
        /* JADX INFO: renamed from: j */
        public final double mo5004j(Object obj, long j) {
            return this.f10041a.getDouble(obj, j);
        }
    }

    static {
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        c cVar;
        Unsafe unsafeM4986k = m4986k();
        f10032a = unsafeM4986k;
        f10033b = C3798q3.f10264a;
        Class<?> cls = Long.TYPE;
        boolean zM4991p = m4991p(cls);
        f10034c = zM4991p;
        Class<?> cls2 = Integer.TYPE;
        boolean zM4991p2 = m4991p(cls2);
        f10035d = zM4991p2;
        c dVar = null;
        if (unsafeM4986k != null) {
            if (!C3798q3.m5185a()) {
                dVar = new d(unsafeM4986k);
            } else if (zM4991p) {
                dVar = new a(unsafeM4986k);
            } else if (zM4991p2) {
                dVar = new b(unsafeM4986k);
            }
        }
        f10036e = dVar;
        if (unsafeM4986k == null) {
            str = "getByte";
            z2 = false;
        } else {
            try {
                Class<?> cls3 = unsafeM4986k.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (m4994s() == null) {
                    str = "getByte";
                    z2 = false;
                } else {
                    if (C3798q3.m5185a()) {
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
                            Logger logger = Logger.getLogger(C3711j7.class.getName());
                            Level level = Level.WARNING;
                            String strValueOf = String.valueOf(th);
                            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", C1643a.m857j(strValueOf.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", strValueOf));
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
        f10037f = z2;
        Unsafe unsafe = f10032a;
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
                    if (!C3798q3.m5185a()) {
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
                    Logger logger2 = Logger.getLogger(C3711j7.class.getName());
                    Level level2 = Level.WARNING;
                    String strValueOf2 = String.valueOf(th);
                    logger2.logp(level2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", C1643a.m857j(strValueOf2.length() + 71, "platform method missing - proto runtime falling back to safer methods: ", strValueOf2));
                    z4 = false;
                    z5 = z3;
                }
            } catch (Throwable th4) {
                th = th4;
                z3 = true;
            }
        }
        z5 = true;
        f10038g = z4;
        f10039h = m4983h(byte[].class);
        m4983h(boolean[].class);
        m4985j(boolean[].class);
        m4983h(int[].class);
        m4985j(int[].class);
        m4983h(long[].class);
        m4985j(long[].class);
        m4983h(float[].class);
        m4985j(float[].class);
        m4983h(double[].class);
        m4985j(double[].class);
        m4983h(Object[].class);
        m4985j(Object[].class);
        Field fieldM4994s = m4994s();
        if (fieldM4994s != null && (cVar = f10036e) != null) {
            cVar.f10041a.objectFieldOffset(fieldM4994s);
        }
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) {
            z5 = false;
        }
        f10040i = z5;
    }

    /* JADX INFO: renamed from: a */
    public static byte m4976a(byte[] bArr, long j) {
        return f10036e.mo4997a(bArr, f10039h + j);
    }

    /* JADX INFO: renamed from: b */
    public static int m4977b(Object obj, long j) {
        return f10036e.m5007k(obj, j);
    }

    /* JADX INFO: renamed from: c */
    public static <T> T m4978c(Class<T> cls) {
        try {
            return (T) f10032a.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4979d(Object obj, long j, double d2) {
        f10036e.mo4999c(obj, j, d2);
    }

    /* JADX INFO: renamed from: e */
    public static void m4980e(Object obj, long j, long j2) {
        f10036e.m5006f(obj, j, j2);
    }

    /* JADX INFO: renamed from: f */
    public static void m4981f(Object obj, long j, Object obj2) {
        f10036e.f10041a.putObject(obj, j, obj2);
    }

    /* JADX INFO: renamed from: g */
    public static void m4982g(byte[] bArr, long j, byte b2) {
        f10036e.mo4998b(bArr, f10039h + j, b2);
    }

    /* JADX INFO: renamed from: h */
    public static int m4983h(Class<?> cls) {
        if (f10038g) {
            return f10036e.f10041a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: renamed from: i */
    public static long m4984i(Object obj, long j) {
        return f10036e.m5008l(obj, j);
    }

    /* JADX INFO: renamed from: j */
    public static int m4985j(Class<?> cls) {
        if (f10038g) {
            return f10036e.f10041a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: renamed from: k */
    public static Unsafe m4986k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C3697i7());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: l */
    public static void m4987l(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iM4977b = m4977b(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        f10036e.m5005e(obj, j2, ((255 & b2) << i) | (iM4977b & (~(255 << i))));
    }

    /* JADX INFO: renamed from: m */
    public static boolean m4988m(Object obj, long j) {
        return f10036e.mo5002h(obj, j);
    }

    /* JADX INFO: renamed from: n */
    public static float m4989n(Object obj, long j) {
        return f10036e.mo5003i(obj, j);
    }

    /* JADX INFO: renamed from: o */
    public static void m4990o(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        f10036e.m5005e(obj, j2, ((255 & b2) << i) | (m4977b(obj, j2) & (~(255 << i))));
    }

    /* JADX INFO: renamed from: p */
    public static boolean m4991p(Class<?> cls) {
        if (!C3798q3.m5185a()) {
            return false;
        }
        try {
            Class<?> cls2 = f10033b;
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

    /* JADX INFO: renamed from: q */
    public static double m4992q(Object obj, long j) {
        return f10036e.mo5004j(obj, j);
    }

    /* JADX INFO: renamed from: r */
    public static Object m4993r(Object obj, long j) {
        return f10036e.f10041a.getObject(obj, j);
    }

    /* JADX INFO: renamed from: s */
    public static Field m4994s() {
        Field declaredField;
        Field declaredField2;
        if (C3798q3.m5185a()) {
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

    /* JADX INFO: renamed from: t */
    public static byte m4995t(Object obj, long j) {
        return (byte) (m4977b(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* JADX INFO: renamed from: u */
    public static byte m4996u(Object obj, long j) {
        return (byte) (m4977b(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }
}
