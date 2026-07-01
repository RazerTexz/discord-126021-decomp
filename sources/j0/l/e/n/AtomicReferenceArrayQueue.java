package j0.l.e.n;

import j0.l.e.UtilityFunctions;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: j0.l.e.n.a, reason: use source file name */
/* JADX INFO: compiled from: AtomicReferenceArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AtomicReferenceArrayQueue<E> extends AbstractQueue<E> {
    public final AtomicReferenceArray<E> j;
    public final int k;

    public AtomicReferenceArrayQueue(int i) {
        int iB = UtilityFunctions.b(i);
        this.k = iB - 1;
        this.j = new AtomicReferenceArray<>(iB);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
