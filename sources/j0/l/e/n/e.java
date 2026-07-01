package j0.l.e.n;

import j0.l.e.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SpscLinkedArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e<T> implements Queue<T> {
    public static final int j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object k = new Object();
    public final AtomicLong l;
    public int m;
    public long n;
    public int o;
    public AtomicReferenceArray<Object> p;
    public int q;
    public AtomicReferenceArray<Object> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicLong f3796s;

    public e(int i) {
        int iB = m.b(i);
        int i2 = iB - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iB + 1);
        this.p = atomicReferenceArray;
        this.o = i2;
        this.m = Math.min(iB / 4, j);
        this.r = atomicReferenceArray;
        this.q = i2;
        this.n = i2 - 1;
        this.l = new AtomicLong();
        this.f3796s = new AtomicLong();
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public final long c() {
        return this.f3796s.get();
    }

    @Override // java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final long d() {
        return this.l.get();
    }

    public boolean e(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.p;
        long jD = d();
        int i = this.o;
        long j2 = 2 + jD;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            int i2 = ((int) jD) & i;
            atomicReferenceArray.lazySet(i2 + 1, t2);
            atomicReferenceArray.lazySet(i2, t);
            this.l.lazySet(j2);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.p = atomicReferenceArray2;
        int i3 = ((int) jD) & i;
        atomicReferenceArray2.lazySet(i3 + 1, t2);
        atomicReferenceArray2.lazySet(i3, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i3, k);
        this.l.lazySet(j2);
        return true;
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return d() == c();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.p;
        long j2 = this.l.get();
        int i = this.o;
        int i2 = ((int) j2) & i;
        if (j2 < this.n) {
            atomicReferenceArray.lazySet(i2, t);
            this.l.lazySet(j2 + 1);
            return true;
        }
        long j3 = ((long) this.m) + j2;
        if (atomicReferenceArray.get(((int) j3) & i) == null) {
            this.n = j3 - 1;
            atomicReferenceArray.lazySet(i2, t);
            this.l.lazySet(j2 + 1);
            return true;
        }
        long j4 = j2 + 1;
        if (atomicReferenceArray.get(((int) j4) & i) == null) {
            atomicReferenceArray.lazySet(i2, t);
            this.l.lazySet(j4);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.p = atomicReferenceArray2;
        this.n = (((long) i) + j2) - 1;
        atomicReferenceArray2.lazySet(i2, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i2, k);
        this.l.lazySet(j4);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.r;
        int i = ((int) this.f3796s.get()) & this.q;
        T t = (T) atomicReferenceArray.get(i);
        if (t != k) {
            return t;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
        this.r = atomicReferenceArray2;
        return (T) atomicReferenceArray2.get(i);
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.r;
        long j2 = this.f3796s.get();
        int i = this.q & ((int) j2);
        T t = (T) atomicReferenceArray.get(i);
        boolean z2 = t == k;
        if (t != null && !z2) {
            atomicReferenceArray.lazySet(i, null);
            this.f3796s.lazySet(j2 + 1);
            return t;
        }
        if (!z2) {
            return null;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
        this.r = atomicReferenceArray2;
        T t2 = (T) atomicReferenceArray2.get(i);
        if (t2 == null) {
            return null;
        }
        atomicReferenceArray2.lazySet(i, null);
        this.f3796s.lazySet(j2 + 1);
        return t2;
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        long jC = c();
        while (true) {
            long jD = d();
            long jC2 = c();
            if (jC == jC2) {
                return (int) (jD - jC2);
            }
            jC = jC2;
        }
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public T remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }
}
