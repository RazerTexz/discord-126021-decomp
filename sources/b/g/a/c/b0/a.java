package b.g.a.c.b0;

import b.g.a.c.n;

/* JADX INFO: compiled from: Java7Handlers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static final a a;

    static {
        a aVar;
        try {
            aVar = (a) b.g.a.c.i0.d.g(Class.forName("b.g.a.c.b0.b"), false);
        } catch (Throwable unused) {
            aVar = null;
        }
        a = aVar;
    }

    public abstract n<?> a(Class<?> cls);
}
