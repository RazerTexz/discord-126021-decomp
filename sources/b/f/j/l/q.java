package b.f.j.l;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: LruBucketsPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q<T> {
    public final Set<T> a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g<T> f598b = new g<>();

    public abstract T a(int i);

    public abstract int b(T t);

    public T c() {
        T t;
        g<T> gVar = this.f598b;
        synchronized (gVar) {
            g$b<T> g_b = gVar.c;
            if (g_b == null) {
                t = null;
            } else {
                T tPollLast = g_b.c.pollLast();
                if (g_b.c.isEmpty()) {
                    gVar.b(g_b);
                    gVar.a.remove(g_b.f596b);
                }
                t = tPollLast;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.a.remove(t);
            }
        }
        return t;
    }
}
