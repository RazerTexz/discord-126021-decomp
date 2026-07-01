package j0.l.e.n;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SpscLinkedAtomicQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<E> {
    public final AtomicReference<b<E>> j;
    public final AtomicReference<b<E>> k;

    public f() {
        AtomicReference<b<E>> atomicReference = new AtomicReference<>();
        this.j = atomicReference;
        AtomicReference<b<E>> atomicReference2 = new AtomicReference<>();
        this.k = atomicReference2;
        b<E> bVar = new b<>();
        atomicReference.lazySet(bVar);
        atomicReference2.lazySet(bVar);
        bVar.lazySet(null);
    }

    public final boolean isEmpty() {
        return this.k.get() == this.j.get();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        b<E> bVar = new b<>(e);
        this.j.get().lazySet(bVar);
        this.j.lazySet(bVar);
        return true;
    }

    public E peek() {
        b<E> bVarC = this.k.get().c();
        if (bVarC != null) {
            return bVarC.b();
        }
        return null;
    }

    public E poll() {
        b<E> bVarC = this.k.get().c();
        if (bVarC == null) {
            return null;
        }
        E eA = bVarC.a();
        this.k.lazySet(bVarC);
        return eA;
    }

    public final int size() {
        b<E> bVarC;
        b<E> bVar = this.k.get();
        b<E> bVar2 = this.j.get();
        int i = 0;
        while (bVar != bVar2 && i < Integer.MAX_VALUE) {
            do {
                bVarC = bVar.c();
            } while (bVarC == null);
            i++;
            bVar = bVarC;
        }
        return i;
    }
}
