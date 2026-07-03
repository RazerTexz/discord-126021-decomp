package p637j0.p642l.p647e.p648n;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.e.n.f */
/* JADX INFO: compiled from: SpscLinkedAtomicQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12729f<E> {

    /* JADX INFO: renamed from: j */
    public final AtomicReference<C12725b<E>> f27320j;

    /* JADX INFO: renamed from: k */
    public final AtomicReference<C12725b<E>> f27321k;

    public C12729f() {
        AtomicReference<C12725b<E>> atomicReference = new AtomicReference<>();
        this.f27320j = atomicReference;
        AtomicReference<C12725b<E>> atomicReference2 = new AtomicReference<>();
        this.f27321k = atomicReference2;
        C12725b<E> c12725b = new C12725b<>();
        atomicReference.lazySet(c12725b);
        atomicReference2.lazySet(c12725b);
        c12725b.lazySet(null);
    }

    public final boolean isEmpty() {
        return this.f27321k.get() == this.f27320j.get();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        C12725b<E> c12725b = new C12725b<>(e);
        this.f27320j.get().lazySet(c12725b);
        this.f27320j.lazySet(c12725b);
        return true;
    }

    public E peek() {
        C12725b<E> c12725bM10826c = this.f27321k.get().m10826c();
        if (c12725bM10826c != null) {
            return c12725bM10826c.m10825b();
        }
        return null;
    }

    public E poll() {
        C12725b<E> c12725bM10826c = this.f27321k.get().m10826c();
        if (c12725bM10826c == null) {
            return null;
        }
        E eM10824a = c12725bM10826c.m10824a();
        this.f27321k.lazySet(c12725bM10826c);
        return eM10824a;
    }

    public final int size() {
        C12725b<E> c12725bM10826c;
        C12725b<E> c12725b = this.f27321k.get();
        C12725b<E> c12725b2 = this.f27320j.get();
        int i = 0;
        while (c12725b != c12725b2 && i < Integer.MAX_VALUE) {
            do {
                c12725bM10826c = c12725b.m10826c();
            } while (c12725bM10826c == null);
            i++;
            c12725b = c12725bM10826c;
        }
        return i;
    }
}
