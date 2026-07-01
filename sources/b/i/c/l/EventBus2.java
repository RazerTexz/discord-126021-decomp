package b.i.c.l;

import androidx.annotation.GuardedBy;
import b.i.c.q.Event3;
import b.i.c.q.EventHandler2;
import b.i.c.q.Publisher;
import b.i.c.q.Subscriber2;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.i.c.l.q, reason: use source file name */
/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
public class EventBus2 implements Subscriber2, Publisher {

    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<EventHandler2<Object>, Executor>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    public Queue<Event3<?>> f1669b = new ArrayDeque();
    public final Executor c;

    public EventBus2(Executor executor) {
        this.c = executor;
    }

    @Override // b.i.c.q.Subscriber2
    public <T> void a(Class<T> cls, EventHandler2<? super T> eventHandler2) {
        b(cls, this.c, eventHandler2);
    }

    @Override // b.i.c.q.Subscriber2
    public synchronized <T> void b(Class<T> cls, Executor executor, EventHandler2<? super T> eventHandler2) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(eventHandler2);
        Objects.requireNonNull(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(eventHandler2, executor);
    }
}
