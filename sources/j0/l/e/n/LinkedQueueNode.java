package j0.l.e.n;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.e.n.b, reason: use source file name */
/* JADX INFO: compiled from: LinkedQueueNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public LinkedQueueNode() {
    }

    public E a() {
        E e = this.value;
        this.value = null;
        return e;
    }

    public E b() {
        return this.value;
    }

    public LinkedQueueNode<E> c() {
        return get();
    }

    public LinkedQueueNode(E e) {
        this.value = e;
    }
}
