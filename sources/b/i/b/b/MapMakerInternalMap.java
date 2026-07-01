package b.i.b.b;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.b.a.Equivalence;
import b.i.b.b.MapMakerInternalMap.i;
import b.i.b.b.MapMakerInternalMap.n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.google.j2objc.annotations.Weak;
import j0.l.e.n.SpscExactAtomicArrayQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.v, reason: use source file name */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class MapMakerInternalMap<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final b0<Object, Object, e> j = new a();
    private static final long serialVersionUID = 5;
    public final int concurrencyLevel;
    public final transient int k;
    public final Equivalence<Object> keyEquivalence;
    public final transient int l;
    public final transient n<K, V, E, S>[] m;
    public final transient j<K, V, E, S> n;

    @MonotonicNonNullDecl
    public transient Set<K> o;

    @MonotonicNonNullDecl
    public transient Collection<V> p;

    @MonotonicNonNullDecl
    public transient Set<Map.Entry<K, V>> q;

    /* JADX INFO: renamed from: b.i.b.b.v$a */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static class a implements b0<Object, Object, e> {
        @Override // b.i.b.b.MapMakerInternalMap.b0
        public /* bridge */ /* synthetic */ i a() {
            return null;
        }

        @Override // b.i.b.b.MapMakerInternalMap.b0
        public b0 b(ReferenceQueue<Object> referenceQueue, i iVar) {
            return this;
        }

        @Override // b.i.b.b.MapMakerInternalMap.b0
        public void clear() {
        }

        @Override // b.i.b.b.MapMakerInternalMap.b0
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$a0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface a0<K, V, E extends i<K, V, E>> extends i<K, V, E> {
        b0<K, V, E> b();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$b */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class b<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;
        public final int concurrencyLevel;
        public transient ConcurrentMap<K, V> j;
        public final Equivalence<Object> keyEquivalence;
        public final p keyStrength;
        public final Equivalence<Object> valueEquivalence;
        public final p valueStrength;

        public b(p pVar, p pVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            this.keyStrength = pVar;
            this.valueStrength = pVar2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.concurrencyLevel = i;
            this.j = concurrentMap;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$b0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface b0<K, V, E extends i<K, V, E>> {
        E a();

        b0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e);

        void clear();

        @NullableDecl
        V get();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$c */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class c<K, V, E extends i<K, V, E>> implements i<K, V, E> {
        public final K a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1650b;

        @NullableDecl
        public final E c;

        public c(K k, int i, @NullableDecl E e) {
            this.a = k;
            this.f1650b = i;
            this.c = e;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public E a() {
            return this.c;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public int c() {
            return this.f1650b;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public K getKey() {
            return this.a;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$c0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class c0<K, V, E extends i<K, V, E>> extends WeakReference<V> implements b0<K, V, E> {

        @Weak
        public final E a;

        public c0(ReferenceQueue<V> referenceQueue, V v, E e) {
            super(v, referenceQueue);
            this.a = e;
        }

        @Override // b.i.b.b.MapMakerInternalMap.b0
        public E a() {
            return this.a;
        }

        @Override // b.i.b.b.MapMakerInternalMap.b0
        public b0<K, V, E> b(ReferenceQueue<V> referenceQueue, E e) {
            return new c0(referenceQueue, get(), e);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$d */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class d<K, V, E extends i<K, V, E>> extends WeakReference<K> implements i<K, V, E> {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NullableDecl
        public final E f1651b;

        public d(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl E e) {
            super(k, referenceQueue);
            this.a = i;
            this.f1651b = e;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public E a() {
            return this.f1651b;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public int c() {
            return this.a;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public K getKey() {
            return get();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$d0 */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class d0 extends AbstractMapEntry<K, V> {
        public final K j;
        public V k;

        public d0(K k, V v) {
            this.j = k;
            this.k = v;
        }

        @Override // b.i.b.b.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.j.equals(entry.getKey()) && this.k.equals(entry.getValue());
        }

        @Override // b.i.b.b.AbstractMapEntry, java.util.Map.Entry
        public K getKey() {
            return this.j;
        }

        @Override // b.i.b.b.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.k;
        }

        @Override // b.i.b.b.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            return this.j.hashCode() ^ this.k.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = (V) MapMakerInternalMap.this.put(this.j, v);
            this.k = v;
            return v2;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$e */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class e implements i<Object, Object, e> {
        public e() {
            throw new AssertionError();
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public i a() {
            throw new AssertionError();
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public int c() {
            throw new AssertionError();
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$f */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class f extends MapMakerInternalMap<K, V, E, S>.h<Map.Entry<K, V>> {
        public f(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$g */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class g extends m<Map.Entry<K, V>> {
        public g() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.d().c(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$h */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public abstract class h<T> implements Iterator<T> {
        public int j;
        public int k = -1;

        @MonotonicNonNullDecl
        public n<K, V, E, S> l;

        @MonotonicNonNullDecl
        public AtomicReferenceArray<E> m;

        @NullableDecl
        public E n;

        @NullableDecl
        public MapMakerInternalMap<K, V, E, S>.d0 o;

        @NullableDecl
        public MapMakerInternalMap<K, V, E, S>.d0 p;

        public h() {
            this.j = MapMakerInternalMap.this.m.length - 1;
            a();
        }

        public final void a() {
            this.o = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i = this.j;
                if (i < 0) {
                    return;
                }
                n<K, V, E, S>[] nVarArr = MapMakerInternalMap.this.m;
                this.j = i - 1;
                n<K, V, E, S> nVar = nVarArr[i];
                this.l = nVar;
                if (nVar.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.l.table;
                    this.m = atomicReferenceArray;
                    this.k = atomicReferenceArray.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        public boolean b(E e) {
            Object value;
            boolean z2;
            try {
                Object key = e.getKey();
                Objects.requireNonNull(MapMakerInternalMap.this);
                Object obj = null;
                if (e.getKey() != null && (value = e.getValue()) != null) {
                    obj = value;
                }
                if (obj != null) {
                    this.o = new d0(key, obj);
                    z2 = true;
                } else {
                    z2 = false;
                }
                return z2;
            } finally {
                this.l.h();
            }
        }

        public MapMakerInternalMap<K, V, E, S>.d0 c() {
            MapMakerInternalMap<K, V, E, S>.d0 d0Var = this.o;
            if (d0Var == null) {
                throw new NoSuchElementException();
            }
            this.p = d0Var;
            a();
            return this.p;
        }

        public boolean d() {
            E e = this.n;
            if (e == null) {
                return false;
            }
            while (true) {
                this.n = (E) e.a();
                E e2 = this.n;
                if (e2 == null) {
                    return false;
                }
                if (b(e2)) {
                    return true;
                }
                e = this.n;
            }
        }

        public boolean e() {
            while (true) {
                int i = this.k;
                if (i < 0) {
                    return false;
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.m;
                this.k = i - 1;
                E e = atomicReferenceArray.get(i);
                this.n = e;
                if (e != null && (b(e) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.o != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            b.i.a.f.e.o.f.E(this.p != null);
            MapMakerInternalMap.this.remove(this.p.j);
            this.p = null;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$i */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface i<K, V, E extends i<K, V, E>> {
        E a();

        int c();

        K getKey();

        V getValue();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$j */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public interface j<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> {
        E a(S s2, E e, @NullableDecl E e2);

        p b();

        p c();

        void d(S s2, E e, V v);

        S e(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2);

        E f(S s2, K k, int i, @NullableDecl E e);
    }

    /* JADX INFO: renamed from: b.i.b.b.v$k */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class k extends MapMakerInternalMap<K, V, E, S>.h<K> {
        public k(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return c().j;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$l */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class l extends m<K> {
        public l() {
            super(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new k(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$m */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class m<E> extends AbstractSet<E> {
        public m(a aVar) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$n */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class n<K, V, E extends i<K, V, E>, S extends n<K, V, E, S>> extends ReentrantLock {
        public static final /* synthetic */ int j = 0;
        public volatile int count;

        @Weak
        public final MapMakerInternalMap<K, V, E, S> map;
        public final int maxSegmentSize;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();

        @MonotonicNonNullDecl
        public volatile AtomicReferenceArray<E> table;
        public int threshold;

        public n(MapMakerInternalMap<K, V, E, S> mapMakerInternalMap, int i, int i2) {
            this.map = mapMakerInternalMap;
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
                i iVar = (i) referencePoll;
                MapMakerInternalMap<K, V, E, S> mapMakerInternalMap = this.map;
                Objects.requireNonNull(mapMakerInternalMap);
                int iC = iVar.c();
                n<K, V, E, S> nVarC = mapMakerInternalMap.c(iC);
                nVarC.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVarC.table;
                    int length = iC & (atomicReferenceArray.length() - 1);
                    E e = atomicReferenceArray.get(length);
                    for (i iVarA = e; iVarA != null; iVarA = iVarA.a()) {
                        if (iVarA == iVar) {
                            nVarC.modCount++;
                            i iVarJ = nVarC.j(e, iVarA);
                            int i2 = nVarC.count - 1;
                            atomicReferenceArray.set(length, (E) iVarJ);
                            nVarC.count = i2;
                            break;
                        }
                    }
                    nVarC.unlock();
                    i++;
                } catch (Throwable th) {
                    nVarC.unlock();
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
                b0<K, V, E> b0Var = (b0) referencePoll;
                MapMakerInternalMap<K, V, E, S> mapMakerInternalMap = this.map;
                Objects.requireNonNull(mapMakerInternalMap);
                i iVarA = b0Var.a();
                int iC = iVarA.c();
                n<K, V, E, S> nVarC = mapMakerInternalMap.c(iC);
                Object key = iVarA.getKey();
                nVarC.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVarC.table;
                    int length = (atomicReferenceArray.length() - 1) & iC;
                    E e = atomicReferenceArray.get(length);
                    for (i iVarA2 = e; iVarA2 != null; iVarA2 = iVarA2.a()) {
                        Object key2 = iVarA2.getKey();
                        if (iVarA2.c() == iC && key2 != null && nVarC.map.keyEquivalence.c(key, key2)) {
                            if (((a0) iVarA2).b() != b0Var) {
                                break;
                            }
                            nVarC.modCount++;
                            i iVarJ = nVarC.j(e, iVarA2);
                            int i2 = nVarC.count - 1;
                            atomicReferenceArray.set(length, (E) iVarJ);
                            nVarC.count = i2;
                            break;
                        }
                    }
                    nVarC.unlock();
                    i++;
                } catch (Throwable th) {
                    nVarC.unlock();
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
            SpscExactAtomicArrayQueue spscExactAtomicArrayQueue = (AtomicReferenceArray<E>) new AtomicReferenceArray(length << 1);
            this.threshold = (spscExactAtomicArrayQueue.length() * 3) / 4;
            int length2 = spscExactAtomicArrayQueue.length() - 1;
            for (int i2 = 0; i2 < length; i2++) {
                E eA = atomicReferenceArray.get(i2);
                if (eA != null) {
                    i iVarA = eA.a();
                    int iC = eA.c() & length2;
                    if (iVarA == null) {
                        spscExactAtomicArrayQueue.set(iC, eA);
                    } else {
                        i iVar = eA;
                        while (iVarA != null) {
                            int iC2 = iVarA.c() & length2;
                            if (iC2 != iC) {
                                iVar = iVarA;
                                iC = iC2;
                            }
                            iVarA = iVarA.a();
                        }
                        spscExactAtomicArrayQueue.set(iC, iVar);
                        while (eA != iVar) {
                            int iC3 = eA.c() & length2;
                            i iVarA2 = this.map.n.a(l(), eA, (i) spscExactAtomicArrayQueue.get(iC3));
                            if (iVarA2 != null) {
                                spscExactAtomicArrayQueue.set(iC3, iVarA2);
                            } else {
                                i--;
                            }
                            eA = eA.a();
                        }
                    }
                }
            }
            this.table = spscExactAtomicArrayQueue;
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
                for (i iVarA = e; iVarA != null; iVarA = iVarA.a()) {
                    Object key = iVarA.getKey();
                    if (iVarA.c() == i && key != null && this.map.keyEquivalence.c(k, key)) {
                        V v2 = (V) iVarA.getValue();
                        if (v2 == null) {
                            this.modCount++;
                            this.map.n.d(l(), iVarA, v);
                            this.count = this.count;
                            return null;
                        }
                        if (z2) {
                            return v2;
                        }
                        this.modCount++;
                        this.map.n.d(l(), iVarA, v);
                        return v2;
                    }
                }
                this.modCount++;
                i iVarF = this.map.n.f(l(), k, i, e);
                m(iVarF, v);
                atomicReferenceArray.set(length, (E) iVarF);
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
                i iVarA = this.map.n.a(l(), e, e3);
                if (iVarA != null) {
                    e3 = (E) iVarA;
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

    /* JADX INFO: renamed from: b.i.b.b.v$o */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class o<K, V> extends b<K, V> {
        private static final long serialVersionUID = 3;

        public o(p pVar, p pVar2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, int i, ConcurrentMap<K, V> concurrentMap) {
            super(pVar, pVar2, equivalence, equivalence2, i, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            int i = objectInputStream.readInt();
            MapMaker mapMaker = new MapMaker();
            int i2 = mapMaker.f1649b;
            b.i.a.f.e.o.f.F(i2 == -1, "initial capacity was already set to %s", i2);
            b.i.a.f.e.o.f.v(i >= 0);
            mapMaker.f1649b = i;
            mapMaker.d(this.keyStrength);
            p pVar = this.valueStrength;
            p pVar2 = mapMaker.e;
            b.i.a.f.e.o.f.G(pVar2 == null, "Value strength was already set to %s", pVar2);
            Objects.requireNonNull(pVar);
            mapMaker.e = pVar;
            if (pVar != p.j) {
                mapMaker.a = true;
            }
            Equivalence<Object> equivalence = this.keyEquivalence;
            Equivalence<Object> equivalence2 = mapMaker.f;
            b.i.a.f.e.o.f.G(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
            Objects.requireNonNull(equivalence);
            mapMaker.f = equivalence;
            mapMaker.a = true;
            int i3 = this.concurrencyLevel;
            int i4 = mapMaker.c;
            b.i.a.f.e.o.f.F(i4 == -1, "concurrency level was already set to %s", i4);
            b.i.a.f.e.o.f.v(i3 > 0);
            mapMaker.c = i3;
            this.j = mapMaker.c();
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                } else {
                    this.j.put((K) object, (V) objectInputStream.readObject());
                }
            }
        }

        private Object readResolve() {
            return this.j;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(this.j.size());
            for (Map.Entry<K, V> entry : this.j.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: renamed from: b.i.b.b.v$p */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static abstract class p {
        public static final p j;
        public static final p k;
        public static final /* synthetic */ p[] l;

        /* JADX INFO: renamed from: b.i.b.b.v$p$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static enum a extends p {
            public a(String str, int i) {
                super(str, i, null);
            }

            @Override // b.i.b.b.MapMakerInternalMap.p
            public Equivalence<Object> f() {
                return Equivalence.a.j;
            }
        }

        /* JADX INFO: renamed from: b.i.b.b.v$p$b */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static enum b extends p {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // b.i.b.b.MapMakerInternalMap.p
            public Equivalence<Object> f() {
                return Equivalence.b.j;
            }
        }

        static {
            a aVar = new a("STRONG", 0);
            j = aVar;
            b bVar = new b("WEAK", 1);
            k = bVar;
            l = new p[]{aVar, bVar};
        }

        public p(String str, int i, a aVar) {
            super(str, i);
        }

        public static p valueOf(String str) {
            return (p) Enum.valueOf(p.class, str);
        }

        public static p[] values() {
            return (p[]) l.clone();
        }

        public abstract Equivalence<Object> f();
    }

    /* JADX INFO: renamed from: b.i.b.b.v$q */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class q<K, V> extends c<K, V, q<K, V>> implements i {

        @NullableDecl
        public volatile V d;

        /* JADX INFO: renamed from: b.i.b.b.v$q$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, q<K, V>, r<K, V>> {
            public static final a<?, ?> a = new a<>();

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i a(n nVar, i iVar, @NullableDecl i iVar2) {
                q qVar = (q) iVar;
                q qVar2 = new q(qVar.a, qVar.f1650b, (q) iVar2);
                qVar2.d = qVar.d;
                return qVar2;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p b() {
                return p.j;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p c() {
                return p.j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.i.b.b.MapMakerInternalMap.j
            public void d(n nVar, i iVar, Object obj) {
                ((q) iVar).d = obj;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public n e(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new r(mapMakerInternalMap, i, i2);
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new q(obj, i, (q) iVar);
            }
        }

        public q(K k, int i, @NullableDecl q<K, V> qVar) {
            super(k, i, qVar);
            this.d = null;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        @NullableDecl
        public V getValue() {
            return this.d;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$r */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class r<K, V> extends n<K, V, q<K, V>, r<K, V>> {
        public r(MapMakerInternalMap<K, V, q<K, V>, r<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public n l() {
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$s */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class s<K, V> extends c<K, V, s<K, V>> implements a0<K, V, s<K, V>> {
        public volatile b0<K, V, s<K, V>> d;

        /* JADX INFO: renamed from: b.i.b.b.v$s$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, s<K, V>, t<K, V>> {
            public static final a<?, ?> a = new a<>();

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i a(n nVar, i iVar, @NullableDecl i iVar2) {
                t tVar = (t) nVar;
                s sVar = (s) iVar;
                s sVar2 = (s) iVar2;
                int i = n.j;
                if (sVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue<V> referenceQueue = tVar.queueForValues;
                s sVar3 = new s(sVar.a, sVar.f1650b, sVar2);
                sVar3.d = sVar.d.b(referenceQueue, sVar3);
                return sVar3;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p b() {
                return p.j;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p c() {
                return p.k;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public void d(n nVar, i iVar, Object obj) {
                s sVar = (s) iVar;
                ReferenceQueue referenceQueue = ((t) nVar).queueForValues;
                b0<K, V, s<K, V>> b0Var = sVar.d;
                sVar.d = new c0(referenceQueue, obj, sVar);
                b0Var.clear();
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public n e(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new t(mapMakerInternalMap, i, i2);
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new s(obj, i, (s) iVar);
            }
        }

        public s(K k, int i, @NullableDecl s<K, V> sVar) {
            super(k, i, sVar);
            b0<Object, Object, e> b0Var = MapMakerInternalMap.j;
            this.d = (b0<K, V, s<K, V>>) MapMakerInternalMap.j;
        }

        @Override // b.i.b.b.MapMakerInternalMap.a0
        public b0<K, V, s<K, V>> b() {
            return this.d;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public V getValue() {
            return this.d.get();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$t */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class t<K, V> extends n<K, V, s<K, V>, t<K, V>> {
        private final ReferenceQueue<V> queueForValues;

        public t(MapMakerInternalMap<K, V, s<K, V>, t<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public void f() {
            a(this.queueForValues);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public void g() {
            c(this.queueForValues);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public n l() {
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$u */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class u extends MapMakerInternalMap<K, V, E, S>.h<V> {
        public u(MapMakerInternalMap mapMakerInternalMap) {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return c().k;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$v */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public final class v extends AbstractCollection<V> {
        public v() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new u(MapMakerInternalMap.this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return MapMakerInternalMap.a(this).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) MapMakerInternalMap.a(this).toArray(tArr);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$w */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class w<K, V> extends d<K, V, w<K, V>> implements i {

        @NullableDecl
        public volatile V c;

        /* JADX INFO: renamed from: b.i.b.b.v$w$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, w<K, V>, x<K, V>> {
            public static final a<?, ?> a = new a<>();

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i a(n nVar, i iVar, @NullableDecl i iVar2) {
                x xVar = (x) nVar;
                w wVar = (w) iVar;
                w wVar2 = (w) iVar2;
                if (wVar.get() == null) {
                    return null;
                }
                w wVar3 = new w(xVar.queueForKeys, wVar.get(), wVar.a, wVar2);
                wVar3.c = wVar.c;
                return wVar3;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p b() {
                return p.k;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p c() {
                return p.j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.i.b.b.MapMakerInternalMap.j
            public void d(n nVar, i iVar, Object obj) {
                ((w) iVar).c = obj;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public n e(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new x(mapMakerInternalMap, i, i2);
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new w(((x) nVar).queueForKeys, obj, i, (w) iVar);
            }
        }

        public w(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl w<K, V> wVar) {
            super(referenceQueue, k, i, wVar);
            this.c = null;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        @NullableDecl
        public V getValue() {
            return this.c;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$x */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class x<K, V> extends n<K, V, w<K, V>, x<K, V>> {
        private final ReferenceQueue<K> queueForKeys;

        public x(MapMakerInternalMap<K, V, w<K, V>, x<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public void f() {
            a(this.queueForKeys);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public void g() {
            b(this.queueForKeys);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public n l() {
            return this;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$y */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class y<K, V> extends d<K, V, y<K, V>> implements a0<K, V, y<K, V>> {
        public volatile b0<K, V, y<K, V>> c;

        /* JADX INFO: renamed from: b.i.b.b.v$y$a */
        /* JADX INFO: compiled from: MapMakerInternalMap.java */
        public static final class a<K, V> implements j<K, V, y<K, V>, z<K, V>> {
            public static final a<?, ?> a = new a<>();

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i a(n nVar, i iVar, @NullableDecl i iVar2) {
                z zVar = (z) nVar;
                y yVar = (y) iVar;
                y yVar2 = (y) iVar2;
                if (yVar.get() == null) {
                    return null;
                }
                int i = n.j;
                if (yVar.getValue() == null) {
                    return null;
                }
                ReferenceQueue referenceQueue = zVar.queueForKeys;
                ReferenceQueue<V> referenceQueue2 = zVar.queueForValues;
                y yVar3 = new y(referenceQueue, yVar.get(), yVar.a, yVar2);
                yVar3.c = yVar.c.b(referenceQueue2, yVar3);
                return yVar3;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p b() {
                return p.k;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public p c() {
                return p.k;
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public void d(n nVar, i iVar, Object obj) {
                y yVar = (y) iVar;
                ReferenceQueue referenceQueue = ((z) nVar).queueForValues;
                b0<K, V, y<K, V>> b0Var = yVar.c;
                yVar.c = new c0(referenceQueue, obj, yVar);
                b0Var.clear();
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public n e(MapMakerInternalMap mapMakerInternalMap, int i, int i2) {
                return new z(mapMakerInternalMap, i, i2);
            }

            @Override // b.i.b.b.MapMakerInternalMap.j
            public i f(n nVar, Object obj, int i, @NullableDecl i iVar) {
                return new y(((z) nVar).queueForKeys, obj, i, (y) iVar);
            }
        }

        public y(ReferenceQueue<K> referenceQueue, K k, int i, @NullableDecl y<K, V> yVar) {
            super(referenceQueue, k, i, yVar);
            b0<Object, Object, e> b0Var = MapMakerInternalMap.j;
            this.c = (b0<K, V, y<K, V>>) MapMakerInternalMap.j;
        }

        @Override // b.i.b.b.MapMakerInternalMap.a0
        public b0<K, V, y<K, V>> b() {
            return this.c;
        }

        @Override // b.i.b.b.MapMakerInternalMap.i
        public V getValue() {
            return this.c.get();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.v$z */
    /* JADX INFO: compiled from: MapMakerInternalMap.java */
    public static final class z<K, V> extends n<K, V, y<K, V>, z<K, V>> {
        private final ReferenceQueue<K> queueForKeys;
        private final ReferenceQueue<V> queueForValues;

        public z(MapMakerInternalMap<K, V, y<K, V>, z<K, V>> mapMakerInternalMap, int i, int i2) {
            super(mapMakerInternalMap, i, i2);
            this.queueForKeys = new ReferenceQueue<>();
            this.queueForValues = new ReferenceQueue<>();
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public void f() {
            a(this.queueForKeys);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public void g() {
            b(this.queueForKeys);
            c(this.queueForValues);
        }

        @Override // b.i.b.b.MapMakerInternalMap.n
        public n l() {
            return this;
        }
    }

    public MapMakerInternalMap(MapMaker mapMaker, j<K, V, E, S> jVar) {
        int i2 = mapMaker.c;
        this.concurrencyLevel = Math.min(i2 == -1 ? 4 : i2, 65536);
        this.keyEquivalence = (Equivalence) b.i.a.f.e.o.f.W(mapMaker.f, mapMaker.a().f());
        this.n = jVar;
        int i3 = mapMaker.f1649b;
        int iMin = Math.min(i3 == -1 ? 16 : i3, BasicMeasure.EXACTLY);
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (i6 < this.concurrencyLevel) {
            i7++;
            i6 <<= 1;
        }
        this.l = 32 - i7;
        this.k = i6 - 1;
        this.m = new n[i6];
        int i8 = iMin / i6;
        while (i5 < (i6 * i8 < iMin ? i8 + 1 : i8)) {
            i5 <<= 1;
        }
        while (true) {
            n<K, V, E, S>[] nVarArr = this.m;
            if (i4 >= nVarArr.length) {
                return;
            }
            nVarArr[i4] = this.n.e(this, i5, -1);
            i4++;
        }
    }

    public static ArrayList a(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        Objects.requireNonNull(it);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public int b(Object obj) {
        Equivalence<Object> equivalence = this.keyEquivalence;
        Objects.requireNonNull(equivalence);
        int iB = equivalence.b(obj);
        int i2 = iB + ((iB << 15) ^ (-12931));
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = (i5 << 2) + (i5 << 14) + i5;
        return (i6 >>> 16) ^ i6;
    }

    public n<K, V, E, S> c(int i2) {
        return this.m[(i2 >>> this.l) & this.k];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (n<K, V, E, S> nVar : this.m) {
            if (nVar.count != 0) {
                nVar.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = nVar.table;
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    nVar.f();
                    nVar.readCount.set(0);
                    nVar.modCount++;
                    nVar.count = 0;
                    nVar.unlock();
                } catch (Throwable th) {
                    nVar.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        i iVarE;
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        int iB = b(obj);
        n<K, V, E, S> nVarC = c(iB);
        Objects.requireNonNull(nVarC);
        try {
            if (nVarC.count != 0 && (iVarE = nVarC.e(obj, iB)) != null && iVarE.getValue() != null) {
                z2 = true;
            }
            return z2;
        } finally {
            nVarC.h();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        Object value;
        if (obj == null) {
            return false;
        }
        n<K, V, E, S>[] nVarArr = this.m;
        long j2 = -1;
        int i2 = 0;
        while (i2 < 3) {
            long j3 = 0;
            int length = nVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                n<K, V, E, S> nVar = nVarArr[i3];
                int i4 = nVar.count;
                AtomicReferenceArray<E> atomicReferenceArray = nVar.table;
                for (int i5 = 0; i5 < atomicReferenceArray.length(); i5++) {
                    for (E eA = atomicReferenceArray.get(i5); eA != null; eA = eA.a()) {
                        if (eA.getKey() == null || (value = eA.getValue()) == null) {
                            nVar.n();
                            value = null;
                        }
                        if (value != null && d().c(obj, value)) {
                            return true;
                        }
                    }
                }
                j3 += (long) nVar.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i2++;
            j2 = j3;
        }
        return false;
    }

    public Equivalence<Object> d() {
        return this.n.c().f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.q;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.q = gVar;
        return gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        V v2 = null;
        if (obj == null) {
            return null;
        }
        int iB = b(obj);
        n<K, V, E, S> nVarC = c(iB);
        Objects.requireNonNull(nVarC);
        try {
            i iVarE = nVarC.e(obj, iB);
            if (iVarE != null && (v2 = (V) iVarE.getValue()) == null) {
                nVarC.n();
            }
            return v2;
        } finally {
            nVarC.h();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        n<K, V, E, S>[] nVarArr = this.m;
        long j2 = 0;
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            if (nVarArr[i2].count != 0) {
                return false;
            }
            j2 += (long) nVarArr[i2].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i3 = 0; i3 < nVarArr.length; i3++) {
            if (nVarArr[i3].count != 0) {
                return false;
            }
            j2 -= (long) nVarArr[i3].modCount;
        }
        return j2 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.o;
        if (set != null) {
            return set;
        }
        l lVar = new l();
        this.o = lVar;
        return lVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int iB = b(k2);
        return c(iB).i(k2, iB, v2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int iB = b(k2);
        return c(iB).i(k2, iB, v2, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        if ((r7.getValue() == null) != false) goto L21;
     */
    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public V remove(@NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        int iB = b(obj);
        n<K, V, E, S> nVarC = c(iB);
        nVarC.lock();
        try {
            nVarC.k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e2 = atomicReferenceArray.get(length);
            i iVarA = e2;
            while (iVarA != null) {
                Object key = iVarA.getKey();
                if (iVarA.c() == iB && key != null && nVarC.map.keyEquivalence.c(obj, key)) {
                    V v2 = (V) iVarA.getValue();
                    if (v2 == null) {
                    }
                    nVarC.modCount++;
                    i iVarJ = nVarC.j(e2, iVarA);
                    int i2 = nVarC.count - 1;
                    atomicReferenceArray.set(length, (E) iVarJ);
                    nVarC.count = i2;
                    return v2;
                }
                iVarA = iVarA.a();
            }
            return null;
        } finally {
            nVarC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k2, V v2) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v2);
        int iB = b(k2);
        n<K, V, E, S> nVarC = c(iB);
        nVarC.lock();
        try {
            nVarC.k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e2 = atomicReferenceArray.get(length);
            for (i iVarA = e2; iVarA != null; iVarA = iVarA.a()) {
                Object key = iVarA.getKey();
                if (iVarA.c() == iB && key != null && nVarC.map.keyEquivalence.c(k2, key)) {
                    V v3 = (V) iVarA.getValue();
                    if (v3 != null) {
                        nVarC.modCount++;
                        nVarC.map.n.d(nVarC.l(), iVarA, v2);
                        return v3;
                    }
                    if (!(iVarA.getValue() == null)) {
                        break;
                    }
                    nVarC.modCount++;
                    i iVarJ = nVarC.j(e2, iVarA);
                    int i2 = nVarC.count - 1;
                    atomicReferenceArray.set(length, (E) iVarJ);
                    nVarC.count = i2;
                    break;
                }
            }
            return null;
        } finally {
            nVarC.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (n<K, V, E, S> nVar : this.m) {
            j2 += (long) nVar.count;
        }
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.p;
        if (collection != null) {
            return collection;
        }
        v vVar = new v();
        this.p = vVar;
        return vVar;
    }

    public Object writeReplace() {
        return new o(this.n.b(), this.n.c(), this.keyEquivalence, this.n.c().f(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        boolean z2 = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iB = b(obj);
        n<K, V, E, S> nVarC = c(iB);
        nVarC.lock();
        try {
            nVarC.k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e2 = atomicReferenceArray.get(length);
            for (i iVarA = e2; iVarA != null; iVarA = iVarA.a()) {
                Object key = iVarA.getKey();
                if (iVarA.c() == iB && key != null && nVarC.map.keyEquivalence.c(obj, key)) {
                    if (!nVarC.map.d().c(obj2, iVarA.getValue())) {
                        if (!(iVarA.getValue() == null)) {
                            break;
                        }
                        break;
                    }
                    z2 = true;
                    nVarC.modCount++;
                    i iVarJ = nVarC.j(e2, iVarA);
                    int i2 = nVarC.count - 1;
                    atomicReferenceArray.set(length, (E) iVarJ);
                    nVarC.count = i2;
                    break;
                }
            }
            return z2;
        } finally {
            nVarC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k2, @NullableDecl V v2, V v3) {
        Objects.requireNonNull(k2);
        Objects.requireNonNull(v3);
        if (v2 == null) {
            return false;
        }
        int iB = b(k2);
        n<K, V, E, S> nVarC = c(iB);
        nVarC.lock();
        try {
            nVarC.k();
            AtomicReferenceArray<E> atomicReferenceArray = nVarC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e2 = atomicReferenceArray.get(length);
            for (i iVarA = e2; iVarA != null; iVarA = iVarA.a()) {
                Object key = iVarA.getKey();
                if (iVarA.c() == iB && key != null && nVarC.map.keyEquivalence.c(k2, key)) {
                    Object value = iVarA.getValue();
                    if (value == null) {
                        if (!(iVarA.getValue() == null)) {
                            break;
                        }
                        nVarC.modCount++;
                        i iVarJ = nVarC.j(e2, iVarA);
                        int i2 = nVarC.count - 1;
                        atomicReferenceArray.set(length, (E) iVarJ);
                        nVarC.count = i2;
                        break;
                    }
                    if (!nVarC.map.d().c(v2, value)) {
                        break;
                    }
                    nVarC.modCount++;
                    nVarC.map.n.d(nVarC.l(), iVarA, v3);
                    return true;
                }
            }
            return false;
        } finally {
            nVarC.unlock();
        }
    }
}
