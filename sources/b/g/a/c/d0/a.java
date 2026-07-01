package b.g.a.c.d0;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: JDK14Util.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RuntimeException f697b;
    public final Method c;
    public final Method d;

    static {
        a aVar = null;
        try {
            e = null;
            aVar = new a();
        } catch (RuntimeException e) {
            e = e;
        }
        a = aVar;
        f697b = e;
    }

    public a() throws RuntimeException {
        try {
            this.c = Class.class.getMethod("getRecordComponents", new Class[0]);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.d = cls.getMethod("getName", new Class[0]);
            cls.getMethod("getType", new Class[0]);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e.getClass().getName(), e.getMessage()), e);
        }
    }
}
