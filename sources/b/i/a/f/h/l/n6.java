package b.i.a.f.h.l;

import java.nio.charset.Charset;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n6 {
    public static final n6 a = new n6();
    public final ConcurrentMap<Class<?>, q6<?>> c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6 f1462b = new p5();

    public final <T> q6<T> a(Class<T> cls) {
        q6<T> q6VarN;
        g6 g6Var;
        Class<?> cls2;
        Charset charset = w4.a;
        Objects.requireNonNull(cls, "messageType");
        q6<T> q6Var = (q6) this.c.get(cls);
        if (q6Var != null) {
            return q6Var;
        }
        p5 p5Var = (p5) this.f1462b;
        Objects.requireNonNull(p5Var);
        Class<?> cls3 = s6.a;
        if (!u4.class.isAssignableFrom(cls) && (cls2 = s6.a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        a6 a6VarB = p5Var.f1478b.b(cls);
        if (a6VarB.b()) {
            if (u4.class.isAssignableFrom(cls)) {
                d7<?, ?> d7Var = s6.d;
                j4<?> j4Var = k4.a;
                g6Var = new g6(d7Var, k4.a, a6VarB.c());
            } else {
                d7<?, ?> d7Var2 = s6.f1495b;
                j4<?> j4Var2 = k4.f1453b;
                if (j4Var2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                g6Var = new g6(d7Var2, j4Var2, a6VarB.c());
            }
            q6VarN = g6Var;
        } else {
            if (u4.class.isAssignableFrom(cls)) {
                if (a6VarB.a() == 1) {
                    i6 i6Var = k6.f1454b;
                    m5 m5Var = m5.f1459b;
                    d7<?, ?> d7Var3 = s6.d;
                    j4<?> j4Var3 = k4.a;
                    q6VarN = e6.n(a6VarB, i6Var, m5Var, d7Var3, k4.a, x5.f1502b);
                } else {
                    q6VarN = e6.n(a6VarB, k6.f1454b, m5.f1459b, s6.d, null, x5.f1502b);
                }
            } else {
                if (a6VarB.a() == 1) {
                    i6 i6Var2 = k6.a;
                    m5 m5Var2 = m5.a;
                    d7<?, ?> d7Var4 = s6.f1495b;
                    j4<?> j4Var4 = k4.f1453b;
                    if (j4Var4 == null) {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                    q6VarN = e6.n(a6VarB, i6Var2, m5Var2, d7Var4, j4Var4, x5.a);
                } else {
                    q6VarN = e6.n(a6VarB, k6.a, m5.a, s6.c, null, x5.a);
                }
            }
        }
        q6<T> q6Var2 = (q6) this.c.putIfAbsent(cls, q6VarN);
        return q6Var2 != null ? q6Var2 : q6VarN;
    }

    public final <T> q6<T> b(T t) {
        return a(t.getClass());
    }
}
