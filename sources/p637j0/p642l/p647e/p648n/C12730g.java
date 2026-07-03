package p637j0.p642l.p647e.p648n;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p637j0.p642l.p647e.C12723m;

/* JADX INFO: renamed from: j0.l.e.n.g */
/* JADX INFO: compiled from: SpscUnboundedAtomicArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12730g<T> implements Queue<T> {

    /* JADX INFO: renamed from: j */
    public static final int f27322j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: k */
    public static final Object f27323k = new Object();

    /* JADX INFO: renamed from: l */
    public final AtomicLong f27324l;

    /* JADX INFO: renamed from: m */
    public int f27325m;

    /* JADX INFO: renamed from: n */
    public long f27326n;

    /* JADX INFO: renamed from: o */
    public int f27327o;

    /* JADX INFO: renamed from: p */
    public AtomicReferenceArray<Object> f27328p;

    /* JADX INFO: renamed from: q */
    public int f27329q;

    /* JADX INFO: renamed from: r */
    public AtomicReferenceArray<Object> f27330r;

    /* JADX INFO: renamed from: s */
    public final AtomicLong f27331s;

    public C12730g(int i) {
        int iM10823b = C12723m.m10823b(Math.max(8, i));
        int i2 = iM10823b - 1;
        AtomicLong atomicLong = new AtomicLong();
        this.f27324l = atomicLong;
        this.f27331s = new AtomicLong();
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iM10823b + 1);
        this.f27328p = atomicReferenceArray;
        this.f27327o = i2;
        this.f27325m = Math.min(iM10823b / 4, f27322j);
        this.f27330r = atomicReferenceArray;
        this.f27329q = i2;
        this.f27326n = i2 - 1;
        atomicLong.lazySet(0L);
    }

    @Override // java.util.Queue, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: c */
    public final long m10831c() {
        return this.f27331s.get();
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

    /* JADX INFO: renamed from: d */
    public final boolean m10832d(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        this.f27324l.lazySet(j + 1);
        atomicReferenceArray.lazySet(i, t);
        return true;
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f27324l.get() == m10831c();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        Objects.requireNonNull(t);
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27328p;
        long j = this.f27324l.get();
        int i = this.f27327o;
        int i2 = ((int) j) & i;
        if (j < this.f27326n) {
            m10832d(atomicReferenceArray, t, j, i2);
            return true;
        }
        long j2 = ((long) this.f27325m) + j;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            this.f27326n = j2 - 1;
            this.f27324l.lazySet(j + 1);
            atomicReferenceArray.lazySet(i2, t);
            return true;
        }
        long j3 = j + 1;
        if (atomicReferenceArray.get(((int) j3) & i) != null) {
            this.f27324l.lazySet(j3);
            atomicReferenceArray.lazySet(i2, t);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f27328p = atomicReferenceArray2;
        this.f27326n = (((long) i) + j) - 1;
        this.f27324l.lazySet(j3);
        atomicReferenceArray2.lazySet(i2, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i2, f27323k);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27330r;
        int i = ((int) this.f27331s.get()) & this.f27329q;
        T t = (T) atomicReferenceArray.get(i);
        if (t != f27323k) {
            return t;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
        this.f27330r = atomicReferenceArray2;
        return (T) atomicReferenceArray2.get(i);
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27330r;
        long j = this.f27331s.get();
        int i = this.f27329q & ((int) j);
        T t = (T) atomicReferenceArray.get(i);
        boolean z2 = t == f27323k;
        if (t != null && !z2) {
            this.f27331s.lazySet(j + 1);
            atomicReferenceArray.lazySet(i, null);
            return t;
        }
        if (!z2) {
            return null;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
        this.f27330r = atomicReferenceArray2;
        T t2 = (T) atomicReferenceArray2.get(i);
        if (t2 == null) {
            return null;
        }
        this.f27331s.lazySet(j + 1);
        atomicReferenceArray2.lazySet(i, null);
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
        long jM10831c = m10831c();
        while (true) {
            long j = this.f27324l.get();
            long jM10831c2 = m10831c();
            if (jM10831c == jM10831c2) {
                return (int) (j - jM10831c2);
            }
            jM10831c = jM10831c2;
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
