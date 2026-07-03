package p637j0.p642l.p647e.p648n;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.e.n.b */
/* JADX INFO: compiled from: LinkedQueueNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12725b<E> extends AtomicReference<C12725b<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public C12725b() {
    }

    /* JADX INFO: renamed from: a */
    public E m10824a() {
        E e = this.value;
        this.value = null;
        return e;
    }

    /* JADX INFO: renamed from: b */
    public E m10825b() {
        return this.value;
    }

    /* JADX INFO: renamed from: c */
    public C12725b<E> m10826c() {
        return get();
    }

    public C12725b(E e) {
        this.value = e;
    }
}
