package b.i.b.b;

import b.i.b.b.v$i;
import b.i.b.b.v$n;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$n<K, V, E extends v$i<K, V, E>, S extends v$n<K, V, E, S>> extends ReentrantLock {
    public static final /* synthetic */ int j = 0;
    public volatile int count;

    @Weak
    public final v<K, V, E, S> map;
    public final int maxSegmentSize;
    public int modCount;
    public final AtomicInteger readCount = new AtomicInteger();

    @MonotonicNonNullDecl
    public volatile AtomicReferenceArray<E> table;
    public int threshold;

    public v$n(v<K, V, E, S> vVar, int i, int i2) {
        this.map = vVar;
        this.maxSegmentSize = i2;
        AtomicReferenceArray<E> atomicReferenceArray = new AtomicReferenceArray<>(i);
        int length = (atomicReferenceArray.length() * 3) / 4;
        this.threshold = length;
        if (length == i2) {
            this.threshold = length + 1;
        }
        this.table = atomicReferenceArray;
    }

    public <T> void a(ReferenceQueue<T> referenceQueue) {
        while (referenceQueue.poll() != null) {
        }
    }

    @GuardedBy("this")
    public void b(ReferenceQueue<K> referenceQueue) {
        int i = 0;
        do {
            Reference<? extends K> referencePoll = referenceQueue.poll();
            if (referencePoll == null) {
                return;
            }
            v$i v_i = (v$i) referencePoll;
            v<K, V, E, S> vVar = this.map;
            Objects.requireNonNull(vVar);
            int iC = v_i.c();
            v$n<K, V, E, S> v_nC = vVar.c(iC);
            v_nC.lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = v_nC.table;
                int length = iC & (atomicReferenceArray.length() - 1);
                E e = atomicReferenceArray.get(length);
                for (v$i v_iA = e; v_iA != null; v_iA = v_iA.a()) {
                    if (v_iA == v_i) {
                        v_nC.modCount++;
                        v$i v_iJ = v_nC.j(e, v_iA);
                        int i2 = v_nC.count - 1;
                        atomicReferenceArray.set(length, (E) v_iJ);
                        v_nC.count = i2;
                        break;
                    }
                }
                v_nC.unlock();
                i++;
            } catch (Throwable th) {
                v_nC.unlock();
                throw th;
            }
        } while (i != 16);
    }

    @GuardedBy("this")
    public void c(ReferenceQueue<V> referenceQueue) {
        int i = 0;
        do {
            Reference<? extends V> referencePoll = referenceQueue.poll();
            if (referencePoll == null) {
                return;
            }
            v$b0<K, V, E> v_b0 = (v$b0) referencePoll;
            v<K, V, E, S> vVar = this.map;
            Objects.requireNonNull(vVar);
            v$i v_iA = v_b0.a();
            int iC = v_iA.c();
            v$n<K, V, E, S> v_nC = vVar.c(iC);
            Object key = v_iA.getKey();
            v_nC.lock();
            try {
                AtomicReferenceArray<E> atomicReferenceArray = v_nC.table;
                int length = (atomicReferenceArray.length() - 1) & iC;
                E e = atomicReferenceArray.get(length);
                for (v$i v_iA2 = e; v_iA2 != null; v_iA2 = v_iA2.a()) {
                    Object key2 = v_iA2.getKey();
                    if (v_iA2.c() == iC && key2 != null && v_nC.map.keyEquivalence.c(key, key2)) {
                        if (((v$a0) v_iA2).b() != v_b0) {
                            break;
                        }
                        v_nC.modCount++;
                        v$i v_iJ = v_nC.j(e, v_iA2);
                        int i2 = v_nC.count - 1;
                        atomicReferenceArray.set(length, (E) v_iJ);
                        v_nC.count = i2;
                        break;
                    }
                }
                v_nC.unlock();
                i++;
            } catch (Throwable th) {
                v_nC.unlock();
                throw th;
            }
        } while (i != 16);
    }

    @GuardedBy("this")
    public void d() {
        AtomicReferenceArray<E> atomicReferenceArray = this.table;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i = this.count;
        j0.l.e.n.d dVar = (AtomicReferenceArray<E>) new AtomicReferenceArray(length << 1);
        this.threshold = (dVar.length() * 3) / 4;
        int length2 = dVar.length() - 1;
        for (int i2 = 0; i2 < length; i2++) {
            E eA = atomicReferenceArray.get(i2);
            if (eA != null) {
                v$i v_iA = eA.a();
                int iC = eA.c() & length2;
                if (v_iA == null) {
                    dVar.set(iC, eA);
                } else {
                    v$i v_i = eA;
                    while (v_iA != null) {
                        int iC2 = v_iA.c() & length2;
                        if (iC2 != iC) {
                            v_i = v_iA;
                            iC = iC2;
                        }
                        v_iA = v_iA.a();
                    }
                    dVar.set(iC, v_i);
                    while (eA != v_i) {
                        int iC3 = eA.c() & length2;
                        v$i v_iA2 = this.map.n.a(l(), eA, (v$i) dVar.get(iC3));
                        if (v_iA2 != null) {
                            dVar.set(iC3, v_iA2);
                        } else {
                            i--;
                        }
                        eA = eA.a();
                    }
                }
            }
        }
        this.table = dVar;
        this.count = i;
    }

    public E e(Object obj, int i) {
        if (this.count != 0) {
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            for (E e = atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); e != null; e = (E) e.a()) {
                if (e.c() == i) {
                    Object key = e.getKey();
                    if (key == null) {
                        n();
                    } else if (this.map.keyEquivalence.c(obj, key)) {
                        return e;
                    }
                }
            }
        }
        return null;
    }

    public void f() {
    }

    @GuardedBy("this")
    public void g() {
    }

    public void h() {
        if ((this.readCount.incrementAndGet() & 63) == 0) {
            k();
        }
    }

    public V i(K k, int i, V v, boolean z2) {
        lock();
        try {
            k();
            int i2 = this.count + 1;
            if (i2 > this.threshold) {
                d();
                i2 = this.count + 1;
            }
            AtomicReferenceArray<E> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i;
            E e = atomicReferenceArray.get(length);
            for (v$i v_iA = e; v_iA != null; v_iA = v_iA.a()) {
                Object key = v_iA.getKey();
                if (v_iA.c() == i && key != null && this.map.keyEquivalence.c(k, key)) {
                    V v2 = (V) v_iA.getValue();
                    if (v2 == null) {
                        this.modCount++;
                        this.map.n.d(l(), v_iA, v);
                        this.count = this.count;
                        return null;
                    }
                    if (z2) {
                        return v2;
                    }
                    this.modCount++;
                    this.map.n.d(l(), v_iA, v);
                    return v2;
                }
            }
            this.modCount++;
            v$i v_iF = this.map.n.f(l(), k, i, e);
            m(v_iF, v);
            atomicReferenceArray.set(length, (E) v_iF);
            this.count = i2;
            return null;
        } finally {
            unlock();
        }
    }

    @GuardedBy("this")
    public E j(E e, E e2) {
        int i = this.count;
        E e3 = (E) e2.a();
        while (e != e2) {
            v$i v_iA = this.map.n.a(l(), e, e3);
            if (v_iA != null) {
                e3 = (E) v_iA;
            } else {
                i--;
            }
            e = (E) e.a();
        }
        this.count = i;
        return e3;
    }

    public void k() {
        if (tryLock()) {
            try {
                g();
                this.readCount.set(0);
            } finally {
                unlock();
            }
        }
    }

    public abstract S l();

    public void m(E e, V v) {
        this.map.n.d(l(), e, v);
    }

    public void n() {
        if (tryLock()) {
            try {
                g();
            } finally {
                unlock();
            }
        }
    }
}
