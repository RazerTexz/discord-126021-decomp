package d0.t.q0;

import d0.t.j;
import d0.z.d.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c<K, V> implements Map<K, V>, d0.z.d.g0.d {
    public static final c$a j = new c$a(null);
    public int k;
    public int l;
    public e<K> m;
    public f<V> n;
    public d<K, V> o;
    public boolean p;
    public K[] q;
    public V[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f3583s;
    public int[] t;
    public int u;
    public int v;

    public c() {
        this(8);
    }

    public static final /* synthetic */ Object[] access$allocateValuesArray(c cVar) {
        return cVar.a();
    }

    public static final /* synthetic */ Object[] access$getKeysArray$p(c cVar) {
        return cVar.q;
    }

    public static final /* synthetic */ int access$getLength$p(c cVar) {
        return cVar.v;
    }

    public static final /* synthetic */ int[] access$getPresenceArray$p(c cVar) {
        return cVar.f3583s;
    }

    public static final /* synthetic */ Object[] access$getValuesArray$p(c cVar) {
        return cVar.r;
    }

    public static final /* synthetic */ void access$removeKeyAt(c cVar, int i) {
        cVar.g(i);
    }

    public final V[] a() {
        V[] vArr = this.r;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) b.arrayOfUninitializedElements(this.q.length);
        this.r = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iE = e(k);
            int iCoerceAtMost = d0.d0.f.coerceAtMost(this.u * 2, this.t.length / 2);
            int i = 0;
            while (true) {
                int[] iArr = this.t;
                int i2 = iArr[iE];
                if (i2 <= 0) {
                    int i3 = this.v;
                    K[] kArr = this.q;
                    if (i3 >= kArr.length) {
                        b(1);
                        break;
                    }
                    int i4 = i3 + 1;
                    this.v = i4;
                    kArr[i3] = k;
                    this.f3583s[i3] = iE;
                    iArr[iE] = i4;
                    this.l = size() + 1;
                    if (i > this.u) {
                        this.u = i;
                    }
                    return i3;
                }
                if (m.areEqual(this.q[i2 - 1], k)) {
                    return -i2;
                }
                i++;
                if (i > iCoerceAtMost) {
                    f(this.t.length * 2);
                    break;
                }
                iE = iE == 0 ? this.t.length - 1 : iE - 1;
            }
        }
    }

    public final void b(int i) {
        int i2 = this.v;
        int i3 = i + i2;
        K[] kArr = this.q;
        if (i3 <= kArr.length) {
            if ((i2 + i3) - size() > this.q.length) {
                f(this.t.length);
                return;
            }
            return;
        }
        int length = (kArr.length * 3) / 2;
        if (i3 <= length) {
            i3 = length;
        }
        this.q = (K[]) b.copyOfUninitializedElements(kArr, i3);
        V[] vArr = this.r;
        this.r = vArr != null ? (V[]) b.copyOfUninitializedElements(vArr, i3) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.f3583s, i3);
        m.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        this.f3583s = iArrCopyOf;
        int iAccess$computeHashSize = c$a.access$computeHashSize(j, i3);
        if (iAccess$computeHashSize > this.t.length) {
            f(iAccess$computeHashSize);
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.p = true;
        return this;
    }

    public final int c(K k) {
        int iE = e(k);
        int i = this.u;
        while (true) {
            int i2 = this.t[iE];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (m.areEqual(this.q[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iE = iE == 0 ? this.t.length - 1 : iE - 1;
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.p) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.v - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f3583s;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.t[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        b.resetRange(this.q, 0, this.v);
        V[] vArr = this.r;
        if (vArr != null) {
            b.resetRange(vArr, 0, this.v);
        }
        this.l = 0;
        this.v = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        m.checkNotNullParameter(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map$Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map$Entry<? extends K, ? extends V> map$Entry) {
        m.checkNotNullParameter(map$Entry, "entry");
        int iC = c(map$Entry.getKey());
        if (iC < 0) {
            return false;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        return m.areEqual(vArr[iC], map$Entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return d(obj) >= 0;
    }

    public final int d(V v) {
        int i = this.v;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f3583s[i] >= 0) {
                V[] vArr = this.r;
                m.checkNotNull(vArr);
                if (m.areEqual(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    public final int e(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.k;
    }

    public final c$b<K, V> entriesIterator$kotlin_stdlib() {
        return new c$b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map$Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof Map)) {
                return false;
            }
            Map map = (Map) obj;
            if (!(size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet()))) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i) {
        boolean z2;
        int i2;
        if (this.v > size()) {
            V[] vArr = this.r;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = this.v;
                if (i3 >= i2) {
                    break;
                }
                if (this.f3583s[i3] >= 0) {
                    K[] kArr = this.q;
                    kArr[i4] = kArr[i3];
                    if (vArr != null) {
                        vArr[i4] = vArr[i3];
                    }
                    i4++;
                }
                i3++;
            }
            b.resetRange(this.q, i4, i2);
            if (vArr != null) {
                b.resetRange(vArr, i4, this.v);
            }
            this.v = i4;
        }
        int[] iArr = this.t;
        if (i != iArr.length) {
            this.t = new int[i];
            this.k = c$a.access$computeShift(j, i);
        } else {
            j.fill(iArr, 0, 0, iArr.length);
        }
        int i5 = 0;
        while (i5 < this.v) {
            int i6 = i5 + 1;
            int iE = e(this.q[i5]);
            int i7 = this.u;
            while (true) {
                int[] iArr2 = this.t;
                z2 = true;
                if (iArr2[iE] == 0) {
                    iArr2[iE] = i6;
                    this.f3583s[i5] = iE;
                    break;
                } else {
                    i7--;
                    if (i7 < 0) {
                        z2 = false;
                        break;
                    }
                    iE = iE == 0 ? iArr2.length - 1 : iE - 1;
                }
            }
            if (!z2) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i5 = i6;
        }
    }

    public final void g(int i) {
        b.resetAt(this.q, i);
        int length = this.f3583s[i];
        int iCoerceAtMost = d0.d0.f.coerceAtMost(this.u * 2, this.t.length / 2);
        int i2 = 0;
        int i3 = length;
        do {
            length = length == 0 ? this.t.length - 1 : length - 1;
            i2++;
            if (i2 > this.u) {
                this.t[i3] = 0;
            } else {
                int[] iArr = this.t;
                int i4 = iArr[length];
                if (i4 == 0) {
                    iArr[i3] = 0;
                } else {
                    if (i4 < 0) {
                        iArr[i3] = -1;
                    } else {
                        int i5 = i4 - 1;
                        int iE = e(this.q[i5]) - length;
                        int[] iArr2 = this.t;
                        if ((iE & (iArr2.length - 1)) >= i2) {
                            iArr2[i3] = i4;
                            this.f3583s[i5] = i3;
                        }
                        iCoerceAtMost--;
                    }
                    i3 = length;
                    i2 = 0;
                    iCoerceAtMost--;
                }
            }
            this.f3583s[i] = -1;
            this.l = size() - 1;
        } while (iCoerceAtMost >= 0);
        this.t[i3] = -1;
        this.f3583s[i] = -1;
        this.l = size() - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iC = c(obj);
        if (iC < 0) {
            return null;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        return vArr[iC];
    }

    public Set<Map$Entry<K, V>> getEntries() {
        d<K, V> dVar = this.o;
        if (dVar != null) {
            return dVar;
        }
        d<K, V> dVar2 = new d<>(this);
        this.o = dVar2;
        return dVar2;
    }

    public Set<K> getKeys() {
        e<K> eVar = this.m;
        if (eVar != null) {
            return eVar;
        }
        e<K> eVar2 = new e<>(this);
        this.m = eVar2;
        return eVar2;
    }

    public int getSize() {
        return this.l;
    }

    public Collection<V> getValues() {
        f<V> fVar = this.n;
        if (fVar != null) {
            return fVar;
        }
        f<V> fVar2 = new f<>(this);
        this.n = fVar2;
        return fVar2;
    }

    @Override // java.util.Map
    public int hashCode() {
        c$b<K, V> c_bEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iNextHashCode$kotlin_stdlib = 0;
        while (c_bEntriesIterator$kotlin_stdlib.hasNext()) {
            iNextHashCode$kotlin_stdlib += c_bEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return iNextHashCode$kotlin_stdlib;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final c$e<K, V> keysIterator$kotlin_stdlib() {
        return new c$e<>(this);
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] vArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrA[iAddKey$kotlin_stdlib] = v;
            return null;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        V v2 = vArrA[i];
        vArrA[i] = v;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map$Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        b(setEntrySet.size());
        for (Map$Entry<? extends K, ? extends V> map$Entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(map$Entry.getKey());
            V[] vArrA = a();
            if (iAddKey$kotlin_stdlib >= 0) {
                vArrA[iAddKey$kotlin_stdlib] = map$Entry.getValue();
            } else {
                int i = (-iAddKey$kotlin_stdlib) - 1;
                if (!m.areEqual(map$Entry.getValue(), vArrA[i])) {
                    vArrA[i] = map$Entry.getValue();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        V v = vArr[iRemoveKey$kotlin_stdlib];
        b.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map$Entry<? extends K, ? extends V> map$Entry) {
        m.checkNotNullParameter(map$Entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iC = c(map$Entry.getKey());
        if (iC < 0) {
            return false;
        }
        V[] vArr = this.r;
        m.checkNotNull(vArr);
        if (!m.areEqual(vArr[iC], map$Entry.getValue())) {
            return false;
        }
        g(iC);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int iC = c(k);
        if (iC < 0) {
            return -1;
        }
        g(iC);
        return iC;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int iD = d(v);
        if (iD < 0) {
            return false;
        }
        g(iD);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        c$b<K, V> c_bEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (c_bEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            c_bEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final c$f<K, V> valuesIterator$kotlin_stdlib() {
        return new c$f<>(this);
    }

    public c(int i) {
        K[] kArr = (K[]) b.arrayOfUninitializedElements(i);
        int[] iArr = new int[i];
        c$a c_a = j;
        int iAccess$computeHashSize = c$a.access$computeHashSize(c_a, i);
        this.q = kArr;
        this.r = null;
        this.f3583s = iArr;
        this.t = new int[iAccess$computeHashSize];
        this.u = 2;
        this.v = 0;
        this.k = c$a.access$computeShift(c_a, iAccess$computeHashSize);
    }
}
