package p007b.p225i.p361c.p368l;

import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.p396q.C4796a;
import p007b.p225i.p361c.p396q.InterfaceC4797b;
import p007b.p225i.p361c.p396q.InterfaceC4798c;
import p007b.p225i.p361c.p396q.InterfaceC4799d;

/* JADX INFO: renamed from: b.i.c.l.q */
/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4585q implements InterfaceC4799d, InterfaceC4798c {

    /* JADX INFO: renamed from: a */
    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<InterfaceC4797b<Object>, Executor>> f12206a = new HashMap();

    /* JADX INFO: renamed from: b */
    @GuardedBy("this")
    public Queue<C4796a<?>> f12207b = new ArrayDeque();

    /* JADX INFO: renamed from: c */
    public final Executor f12208c;

    public C4585q(Executor executor) {
        this.f12208c = executor;
    }

    @Override // p007b.p225i.p361c.p396q.InterfaceC4799d
    /* JADX INFO: renamed from: a */
    public <T> void mo6359a(Class<T> cls, InterfaceC4797b<? super T> interfaceC4797b) {
        mo6360b(cls, this.f12208c, interfaceC4797b);
    }

    @Override // p007b.p225i.p361c.p396q.InterfaceC4799d
    /* JADX INFO: renamed from: b */
    public synchronized <T> void mo6360b(Class<T> cls, Executor executor, InterfaceC4797b<? super T> interfaceC4797b) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(interfaceC4797b);
        Objects.requireNonNull(executor);
        if (!this.f12206a.containsKey(cls)) {
            this.f12206a.put(cls, new ConcurrentHashMap<>());
        }
        this.f12206a.get(cls).put(interfaceC4797b, executor);
    }
}
