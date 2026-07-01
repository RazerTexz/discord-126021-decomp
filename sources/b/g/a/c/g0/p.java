package b.g.a.c.g0;

import b.g.a.c.i0.u;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SerializerCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    public final HashMap<u, b.g.a.c.n<Object>> a = new HashMap<>(64);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b.g.a.c.g0.t.m> f703b = new AtomicReference<>();

    public b.g.a.c.n<Object> a(b.g.a.c.j jVar) {
        b.g.a.c.n<Object> nVar;
        synchronized (this) {
            nVar = this.a.get(new u(jVar, false));
        }
        return nVar;
    }

    public b.g.a.c.n<Object> b(Class<?> cls) {
        b.g.a.c.n<Object> nVar;
        synchronized (this) {
            nVar = this.a.get(new u(cls, false));
        }
        return nVar;
    }
}
