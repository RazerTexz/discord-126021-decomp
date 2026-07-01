package b.g.a.c.b0;

import b.g.a.c.c0.m;
import b.g.a.c.t;

/* JADX INFO: compiled from: Java7Support.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final c a;

    static {
        c cVar;
        try {
            cVar = (c) b.g.a.c.i0.d.g(Class.forName("b.g.a.c.b0.d"), false);
        } catch (Throwable unused) {
            cVar = null;
        }
        a = cVar;
    }

    public abstract t a(m mVar);

    public abstract Boolean b(b.g.a.c.c0.b bVar);

    public abstract Boolean c(b.g.a.c.c0.b bVar);
}
