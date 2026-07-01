package b.i.c.l;

import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
public class q implements b.i.c.q.d, b.i.c.q.c {

    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<b.i.c.q.b<Object>, Executor>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public Queue<b.i.c.q.a<?>> f1669b = new ArrayDeque();
    public final Executor c;

    public q(Executor executor) {
        this.c = executor;
    }

    @Override // b.i.c.q.d
    public <T> void a(Class<T> cls, b.i.c.q.b<? super T> bVar) {
        b(cls, this.c, bVar);
    }

    @Override // b.i.c.q.d
    public synchronized <T> void b(Class<T> cls, Executor executor, b.i.c.q.b<? super T> bVar) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(bVar, executor);
    }
}
