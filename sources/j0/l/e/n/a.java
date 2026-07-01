package j0.l.e.n;

import j0.l.e.m;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: AtomicReferenceArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<E> extends AbstractQueue<E> {
    public final AtomicReferenceArray<E> j;
    public final int k;

    public a(int i) {
        int iB = m.b(i);
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
