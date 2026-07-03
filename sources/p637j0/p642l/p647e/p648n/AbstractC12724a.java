package p637j0.p642l.p647e.p648n;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p637j0.p642l.p647e.C12723m;

/* JADX INFO: renamed from: j0.l.e.n.a */
/* JADX INFO: compiled from: AtomicReferenceArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12724a<E> extends AbstractQueue<E> {

    /* JADX INFO: renamed from: j */
    public final AtomicReferenceArray<E> f27303j;

    /* JADX INFO: renamed from: k */
    public final int f27304k;

    public AbstractC12724a(int i) {
        int iM10823b = C12723m.m10823b(i);
        this.f27304k = iM10823b - 1;
        this.f27303j = new AtomicReferenceArray<>(iM10823b);
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
