package b.i.b.b;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.i.b.b.v$i;
import b.i.b.b.v$n;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class v<K, V, E extends v$i<K, V, E>, S extends v$n<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    public static final v$b0<Object, Object, v$e> j = new v$a();
    private static final long serialVersionUID = 5;
    public final int concurrencyLevel;
    public final transient int k;
    public final b.i.b.a.d<Object> keyEquivalence;
    public final transient int l;
    public final transient v$n<K, V, E, S>[] m;
    public final transient v$j<K, V, E, S> n;

    @MonotonicNonNullDecl
    public transient Set<K> o;

    @MonotonicNonNullDecl
    public transient Collection<V> p;

    @MonotonicNonNullDecl
    public transient Set<Map$Entry<K, V>> q;

    public v(u uVar, v$j<K, V, E, S> v_j) {
        int i = uVar.c;
        this.concurrencyLevel = Math.min(i == -1 ? 4 : i, 65536);
        this.keyEquivalence = (b.i.b.a.d) b.i.a.f.e.o.f.W(uVar.f, uVar.a().f());
        this.n = v_j;
        int i2 = uVar.f1649b;
        int iMin = Math.min(i2 == -1 ? 16 : i2, BasicMeasure.EXACTLY);
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i5 < this.concurrencyLevel) {
            i6++;
            i5 <<= 1;
        }
        this.l = 32 - i6;
        this.k = i5 - 1;
        this.m = new v$n[i5];
        int i7 = iMin / i5;
        while (i4 < (i5 * i7 < iMin ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        while (true) {
            v$n<K, V, E, S>[] v_nArr = this.m;
            if (i3 >= v_nArr.length) {
                return;
            }
            v_nArr[i3] = this.n.e(this, i4, -1);
            i3++;
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
        b.i.b.a.d<Object> dVar = this.keyEquivalence;
        Objects.requireNonNull(dVar);
        int iB = dVar.b(obj);
        int i = iB + ((iB << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = (i4 << 2) + (i4 << 14) + i4;
        return (i5 >>> 16) ^ i5;
    }

    public v$n<K, V, E, S> c(int i) {
        return this.m[(i >>> this.l) & this.k];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (v$n<K, V, E, S> v_n : this.m) {
            if (v_n.count != 0) {
                v_n.lock();
                try {
                    AtomicReferenceArray<E> atomicReferenceArray = v_n.table;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        atomicReferenceArray.set(i, null);
                    }
                    v_n.f();
                    v_n.readCount.set(0);
                    v_n.modCount++;
                    v_n.count = 0;
                    v_n.unlock();
                } catch (Throwable th) {
                    v_n.unlock();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        v$i v_iE;
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        int iB = b(obj);
        v$n<K, V, E, S> v_nC = c(iB);
        Objects.requireNonNull(v_nC);
        try {
            if (v_nC.count != 0 && (v_iE = v_nC.e(obj, iB)) != null && v_iE.getValue() != null) {
                z2 = true;
            }
            return z2;
        } finally {
            v_nC.h();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        Object value;
        if (obj == null) {
            return false;
        }
        v$n<K, V, E, S>[] v_nArr = this.m;
        long j2 = -1;
        int i = 0;
        while (i < 3) {
            long j3 = 0;
            int length = v_nArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                v$n<K, V, E, S> v_n = v_nArr[i2];
                int i3 = v_n.count;
                AtomicReferenceArray<E> atomicReferenceArray = v_n.table;
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    for (E eA = atomicReferenceArray.get(i4); eA != null; eA = eA.a()) {
                        if (eA.getKey() == null || (value = eA.getValue()) == null) {
                            v_n.n();
                            value = null;
                        }
                        if (value != null && d().c(obj, value)) {
                            return true;
                        }
                    }
                }
                j3 += (long) v_n.modCount;
            }
            if (j3 == j2) {
                return false;
            }
            i++;
            j2 = j3;
        }
        return false;
    }

    public b.i.b.a.d<Object> d() {
        return this.n.c().f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map$Entry<K, V>> entrySet() {
        Set<Map$Entry<K, V>> set = this.q;
        if (set != null) {
            return set;
        }
        v$g v_g = new v$g(this);
        this.q = v_g;
        return v_g;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        V v = null;
        if (obj == null) {
            return null;
        }
        int iB = b(obj);
        v$n<K, V, E, S> v_nC = c(iB);
        Objects.requireNonNull(v_nC);
        try {
            v$i v_iE = v_nC.e(obj, iB);
            if (v_iE != null && (v = (V) v_iE.getValue()) == null) {
                v_nC.n();
            }
            return v;
        } finally {
            v_nC.h();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        v$n<K, V, E, S>[] v_nArr = this.m;
        long j2 = 0;
        for (int i = 0; i < v_nArr.length; i++) {
            if (v_nArr[i].count != 0) {
                return false;
            }
            j2 += (long) v_nArr[i].modCount;
        }
        if (j2 == 0) {
            return true;
        }
        for (int i2 = 0; i2 < v_nArr.length; i2++) {
            if (v_nArr[i2].count != 0) {
                return false;
            }
            j2 -= (long) v_nArr[i2].modCount;
        }
        return j2 == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.o;
        if (set != null) {
            return set;
        }
        v$l v_l = new v$l(this);
        this.o = v_l;
        return v_l;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @CanIgnoreReturnValue
    public V put(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        int iB = b(k);
        return c(iB).i(k, iB, v, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map$Entry<? extends K, ? extends V> map$Entry : map.entrySet()) {
            put(map$Entry.getKey(), map$Entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        int iB = b(k);
        return c(iB).i(k, iB, v, true);
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
        v$n<K, V, E, S> v_nC = c(iB);
        v_nC.lock();
        try {
            v_nC.k();
            AtomicReferenceArray<E> atomicReferenceArray = v_nC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e = atomicReferenceArray.get(length);
            v$i v_iA = e;
            while (v_iA != null) {
                Object key = v_iA.getKey();
                if (v_iA.c() == iB && key != null && v_nC.map.keyEquivalence.c(obj, key)) {
                    V v = (V) v_iA.getValue();
                    if (v == null) {
                    }
                    v_nC.modCount++;
                    v$i v_iJ = v_nC.j(e, v_iA);
                    int i = v_nC.count - 1;
                    atomicReferenceArray.set(length, (E) v_iJ);
                    v_nC.count = i;
                    return v;
                }
                v_iA = v_iA.a();
            }
            return null;
        } finally {
            v_nC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k, V v) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v);
        int iB = b(k);
        v$n<K, V, E, S> v_nC = c(iB);
        v_nC.lock();
        try {
            v_nC.k();
            AtomicReferenceArray<E> atomicReferenceArray = v_nC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e = atomicReferenceArray.get(length);
            for (v$i v_iA = e; v_iA != null; v_iA = v_iA.a()) {
                Object key = v_iA.getKey();
                if (v_iA.c() == iB && key != null && v_nC.map.keyEquivalence.c(k, key)) {
                    V v2 = (V) v_iA.getValue();
                    if (v2 != null) {
                        v_nC.modCount++;
                        v_nC.map.n.d(v_nC.l(), v_iA, v);
                        return v2;
                    }
                    if (!(v_iA.getValue() == null)) {
                        break;
                    }
                    v_nC.modCount++;
                    v$i v_iJ = v_nC.j(e, v_iA);
                    int i = v_nC.count - 1;
                    atomicReferenceArray.set(length, (E) v_iJ);
                    v_nC.count = i;
                    break;
                }
            }
            return null;
        } finally {
            v_nC.unlock();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j2 = 0;
        for (v$n<K, V, E, S> v_n : this.m) {
            j2 += (long) v_n.count;
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
        v$v v_v = new v$v(this);
        this.p = v_v;
        return v_v;
    }

    public Object writeReplace() {
        return new v$o(this.n.b(), this.n.c(), this.keyEquivalence, this.n.c().f(), this.concurrencyLevel, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        boolean z2 = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iB = b(obj);
        v$n<K, V, E, S> v_nC = c(iB);
        v_nC.lock();
        try {
            v_nC.k();
            AtomicReferenceArray<E> atomicReferenceArray = v_nC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e = atomicReferenceArray.get(length);
            for (v$i v_iA = e; v_iA != null; v_iA = v_iA.a()) {
                Object key = v_iA.getKey();
                if (v_iA.c() == iB && key != null && v_nC.map.keyEquivalence.c(obj, key)) {
                    if (!v_nC.map.d().c(obj2, v_iA.getValue())) {
                        if (!(v_iA.getValue() == null)) {
                            break;
                        }
                        break;
                    }
                    z2 = true;
                    v_nC.modCount++;
                    v$i v_iJ = v_nC.j(e, v_iA);
                    int i = v_nC.count - 1;
                    atomicReferenceArray.set(length, (E) v_iJ);
                    v_nC.count = i;
                    break;
                }
            }
            return z2;
        } finally {
            v_nC.unlock();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k, @NullableDecl V v, V v2) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(v2);
        if (v == null) {
            return false;
        }
        int iB = b(k);
        v$n<K, V, E, S> v_nC = c(iB);
        v_nC.lock();
        try {
            v_nC.k();
            AtomicReferenceArray<E> atomicReferenceArray = v_nC.table;
            int length = (atomicReferenceArray.length() - 1) & iB;
            E e = atomicReferenceArray.get(length);
            for (v$i v_iA = e; v_iA != null; v_iA = v_iA.a()) {
                Object key = v_iA.getKey();
                if (v_iA.c() == iB && key != null && v_nC.map.keyEquivalence.c(k, key)) {
                    Object value = v_iA.getValue();
                    if (value == null) {
                        if (!(v_iA.getValue() == null)) {
                            break;
                        }
                        v_nC.modCount++;
                        v$i v_iJ = v_nC.j(e, v_iA);
                        int i = v_nC.count - 1;
                        atomicReferenceArray.set(length, (E) v_iJ);
                        v_nC.count = i;
                        break;
                    }
                    if (!v_nC.map.d().c(v, value)) {
                        break;
                    }
                    v_nC.modCount++;
                    v_nC.map.n.d(v_nC.l(), v_iA, v2);
                    return true;
                }
            }
            return false;
        } finally {
            v_nC.unlock();
        }
    }
}
