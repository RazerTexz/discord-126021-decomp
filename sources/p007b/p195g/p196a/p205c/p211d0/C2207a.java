package p007b.p195g.p196a.p205c.p211d0;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.g.a.c.d0.a */
/* JADX INFO: compiled from: JDK14Util.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2207a {

    /* JADX INFO: renamed from: a */
    public static final C2207a f4766a;

    /* JADX INFO: renamed from: b */
    public static final RuntimeException f4767b;

    /* JADX INFO: renamed from: c */
    public final Method f4768c;

    /* JADX INFO: renamed from: d */
    public final Method f4769d;

    static {
        C2207a c2207a = null;
        try {
            e = null;
            c2207a = new C2207a();
        } catch (RuntimeException e) {
            e = e;
        }
        f4766a = c2207a;
        f4767b = e;
    }

    public C2207a() throws RuntimeException {
        try {
            this.f4768c = Class.class.getMethod("getRecordComponents", new Class[0]);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.f4769d = cls.getMethod("getName", new Class[0]);
            cls.getMethod("getType", new Class[0]);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e.getClass().getName(), e.getMessage()), e);
        }
    }
}
