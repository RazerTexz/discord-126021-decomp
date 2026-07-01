package b.g.a.c.d0;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.g.a.c.d0.a, reason: use source file name */
/* JADX INFO: compiled from: JDK14Util.java */
/* JADX INFO: loaded from: classes3.dex */
public class JDK14Util {
    public static final JDK14Util a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RuntimeException f697b;
    public final Method c;
    public final Method d;

    static {
        JDK14Util jDK14Util = null;
        try {
            e = null;
            jDK14Util = new JDK14Util();
        } catch (RuntimeException e) {
            e = e;
        }
        a = jDK14Util;
        f697b = e;
    }

    public JDK14Util() throws RuntimeException {
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
