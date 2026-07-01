package j0.l.e.o;

import j0.l.e.n.LinkedQueueNode;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: j0.l.e.o.s, reason: use source file name */
/* JADX INFO: compiled from: SpscLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpscLinkedQueue<E> {
    public SpscLinkedQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.producerNode = linkedQueueNode;
        this.consumerNode = linkedQueueNode;
        linkedQueueNode.lazySet(null);
    }

    public final boolean isEmpty() {
        return d() == c();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        this.producerNode.lazySet(linkedQueueNode);
        this.producerNode = linkedQueueNode;
        return true;
    }

    public E peek() {
        LinkedQueueNode<E> linkedQueueNodeC = this.consumerNode.c();
        if (linkedQueueNodeC != null) {
            return linkedQueueNodeC.b();
        }
        return null;
    }

    public E poll() {
        LinkedQueueNode<E> linkedQueueNodeC = this.consumerNode.c();
        if (linkedQueueNodeC == null) {
            return null;
        }
        E eA = linkedQueueNodeC.a();
        this.consumerNode = linkedQueueNodeC;
        return eA;
    }

    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeC;
        LinkedQueueNode<E> linkedQueueNodeD = d();
        LinkedQueueNode<E> linkedQueueNodeC2 = c();
        int i = 0;
        while (linkedQueueNodeD != linkedQueueNodeC2 && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeC = linkedQueueNodeD.c();
            } while (linkedQueueNodeC == null);
            i++;
            linkedQueueNodeD = linkedQueueNodeC;
        }
        return i;
    }
}
