package j0.l.e.o;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: SpscLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s<E> {
    public s() {
        j0.l.e.n.b<E> bVar = new j0.l.e.n.b<>();
        this.producerNode = bVar;
        this.consumerNode = bVar;
        bVar.lazySet(null);
    }

    public final boolean isEmpty() {
        return d() == c();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        j0.l.e.n.b<E> bVar = new j0.l.e.n.b<>(e);
        this.producerNode.lazySet(bVar);
        this.producerNode = bVar;
        return true;
    }

    public E peek() {
        j0.l.e.n.b<E> bVarC = this.consumerNode.c();
        if (bVarC != null) {
            return bVarC.b();
        }
        return null;
    }

    public E poll() {
        j0.l.e.n.b<E> bVarC = this.consumerNode.c();
        if (bVarC == null) {
            return null;
        }
        E eA = bVarC.a();
        this.consumerNode = bVarC;
        return eA;
    }

    public final int size() {
        j0.l.e.n.b<E> bVarC;
        j0.l.e.n.b<E> bVarD = d();
        j0.l.e.n.b<E> bVarC2 = c();
        int i = 0;
        while (bVarD != bVarC2 && i < Integer.MAX_VALUE) {
            do {
                bVarC = bVarD.c();
            } while (bVarC == null);
            i++;
            bVarD = bVarC;
        }
        return i;
    }
}
