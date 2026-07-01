package j0.l.e.n;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.e.n.f, reason: use source file name */
/* JADX INFO: compiled from: SpscLinkedAtomicQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpscLinkedAtomicQueue<E> {
    public final AtomicReference<LinkedQueueNode<E>> j;
    public final AtomicReference<LinkedQueueNode<E>> k;

    public SpscLinkedAtomicQueue() {
        AtomicReference<LinkedQueueNode<E>> atomicReference = new AtomicReference<>();
        this.j = atomicReference;
        AtomicReference<LinkedQueueNode<E>> atomicReference2 = new AtomicReference<>();
        this.k = atomicReference2;
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        atomicReference.lazySet(linkedQueueNode);
        atomicReference2.lazySet(linkedQueueNode);
        linkedQueueNode.lazySet(null);
    }

    public final boolean isEmpty() {
        return this.k.get() == this.j.get();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        this.j.get().lazySet(linkedQueueNode);
        this.j.lazySet(linkedQueueNode);
        return true;
    }

    public E peek() {
        LinkedQueueNode<E> linkedQueueNodeC = this.k.get().c();
        if (linkedQueueNodeC != null) {
            return linkedQueueNodeC.b();
        }
        return null;
    }

    public E poll() {
        LinkedQueueNode<E> linkedQueueNodeC = this.k.get().c();
        if (linkedQueueNodeC == null) {
            return null;
        }
        E eA = linkedQueueNodeC.a();
        this.k.lazySet(linkedQueueNodeC);
        return eA;
    }

    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeC;
        LinkedQueueNode<E> linkedQueueNode = this.k.get();
        LinkedQueueNode<E> linkedQueueNode2 = this.j.get();
        int i = 0;
        while (linkedQueueNode != linkedQueueNode2 && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeC = linkedQueueNode.c();
            } while (linkedQueueNodeC == null);
            i++;
            linkedQueueNode = linkedQueueNodeC;
        }
        return i;
    }
}
