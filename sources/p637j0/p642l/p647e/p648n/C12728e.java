package p637j0.p642l.p647e.p648n;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p637j0.p642l.p647e.C12723m;

/* JADX INFO: renamed from: j0.l.e.n.e */
/* JADX INFO: compiled from: SpscLinkedArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12728e<T> implements Queue<T> {

    /* JADX INFO: renamed from: j */
    public static final int f27310j = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: k */
    public static final Object f27311k = new Object();

    /* JADX INFO: renamed from: l */
    public final AtomicLong f27312l;

    /* JADX INFO: renamed from: m */
    public int f27313m;

    /* JADX INFO: renamed from: n */
    public long f27314n;

    /* JADX INFO: renamed from: o */
    public int f27315o;

    /* JADX INFO: renamed from: p */
    public AtomicReferenceArray<Object> f27316p;

    /* JADX INFO: renamed from: q */
    public int f27317q;

    /* JADX INFO: renamed from: r */
    public AtomicReferenceArray<Object> f27318r;

    /* JADX INFO: renamed from: s */
    public final AtomicLong f27319s;

    public C12728e(int i) {
        int iM10823b = C12723m.m10823b(i);
        int i2 = iM10823b - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iM10823b + 1);
        this.f27316p = atomicReferenceArray;
        this.f27315o = i2;
        this.f27313m = Math.min(iM10823b / 4, f27310j);
        this.f27318r = atomicReferenceArray;
        this.f27317q = i2;
        this.f27314n = i2 - 1;
        this.f27312l = new AtomicLong();
        this.f27319s = new AtomicLong();
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
    public final long m10828c() {
        return this.f27319s.get();
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
    public final long m10829d() {
        return this.f27312l.get();
    }

    /* JADX INFO: renamed from: e */
    public boolean m10830e(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27316p;
        long jM10829d = m10829d();
        int i = this.f27315o;
        long j = 2 + jM10829d;
        if (atomicReferenceArray.get(((int) j) & i) == null) {
            int i2 = ((int) jM10829d) & i;
            atomicReferenceArray.lazySet(i2 + 1, t2);
            atomicReferenceArray.lazySet(i2, t);
            this.f27312l.lazySet(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f27316p = atomicReferenceArray2;
        int i3 = ((int) jM10829d) & i;
        atomicReferenceArray2.lazySet(i3 + 1, t2);
        atomicReferenceArray2.lazySet(i3, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i3, f27311k);
        this.f27312l.lazySet(j);
        return true;
    }

    @Override // java.util.Queue
    public T element() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m10829d() == m10828c();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Queue
    public boolean offer(T t) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27316p;
        long j = this.f27312l.get();
        int i = this.f27315o;
        int i2 = ((int) j) & i;
        if (j < this.f27314n) {
            atomicReferenceArray.lazySet(i2, t);
            this.f27312l.lazySet(j + 1);
            return true;
        }
        long j2 = ((long) this.f27313m) + j;
        if (atomicReferenceArray.get(((int) j2) & i) == null) {
            this.f27314n = j2 - 1;
            atomicReferenceArray.lazySet(i2, t);
            this.f27312l.lazySet(j + 1);
            return true;
        }
        long j3 = j + 1;
        if (atomicReferenceArray.get(((int) j3) & i) == null) {
            atomicReferenceArray.lazySet(i2, t);
            this.f27312l.lazySet(j3);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f27316p = atomicReferenceArray2;
        this.f27314n = (((long) i) + j) - 1;
        atomicReferenceArray2.lazySet(i2, t);
        atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
        atomicReferenceArray.lazySet(i2, f27311k);
        this.f27312l.lazySet(j3);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27318r;
        int i = ((int) this.f27319s.get()) & this.f27317q;
        T t = (T) atomicReferenceArray.get(i);
        if (t != f27311k) {
            return t;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
        this.f27318r = atomicReferenceArray2;
        return (T) atomicReferenceArray2.get(i);
    }

    @Override // java.util.Queue
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f27318r;
        long j = this.f27319s.get();
        int i = this.f27317q & ((int) j);
        T t = (T) atomicReferenceArray.get(i);
        boolean z2 = t == f27311k;
        if (t != null && !z2) {
            atomicReferenceArray.lazySet(i, null);
            this.f27319s.lazySet(j + 1);
            return t;
        }
        if (!z2) {
            return null;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(atomicReferenceArray.length() - 1);
        this.f27318r = atomicReferenceArray2;
        T t2 = (T) atomicReferenceArray2.get(i);
        if (t2 == null) {
            return null;
        }
        atomicReferenceArray2.lazySet(i, null);
        this.f27319s.lazySet(j + 1);
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
        long jM10828c = m10828c();
        while (true) {
            long jM10829d = m10829d();
            long jM10828c2 = m10828c();
            if (jM10828c == jM10828c2) {
                return (int) (jM10829d - jM10828c2);
            }
            jM10828c = jM10828c2;
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
