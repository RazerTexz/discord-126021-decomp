package p637j0.p642l.p647e.p649o;

import java.util.Iterator;
import java.util.Objects;
import p637j0.p642l.p647e.p648n.C12725b;

/* JADX INFO: renamed from: j0.l.e.o.s */
/* JADX INFO: compiled from: SpscLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12749s<E> {
    public C12749s() {
        C12725b<E> c12725b = new C12725b<>();
        this.producerNode = c12725b;
        this.consumerNode = c12725b;
        c12725b.lazySet(null);
    }

    public final boolean isEmpty() {
        return m10833d() == m10834c();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        C12725b<E> c12725b = new C12725b<>(e);
        this.producerNode.lazySet(c12725b);
        this.producerNode = c12725b;
        return true;
    }

    public E peek() {
        C12725b<E> c12725bM10826c = this.consumerNode.m10826c();
        if (c12725bM10826c != null) {
            return c12725bM10826c.m10825b();
        }
        return null;
    }

    public E poll() {
        C12725b<E> c12725bM10826c = this.consumerNode.m10826c();
        if (c12725bM10826c == null) {
            return null;
        }
        E eM10824a = c12725bM10826c.m10824a();
        this.consumerNode = c12725bM10826c;
        return eM10824a;
    }

    public final int size() {
        C12725b<E> c12725bM10826c;
        C12725b<E> c12725bM10833d = m10833d();
        C12725b<E> c12725bM10834c = m10834c();
        int i = 0;
        while (c12725bM10833d != c12725bM10834c && i < Integer.MAX_VALUE) {
            do {
                c12725bM10826c = c12725bM10833d.m10826c();
            } while (c12725bM10826c == null);
            i++;
            c12725bM10833d = c12725bM10826c;
        }
        return i;
    }
}
