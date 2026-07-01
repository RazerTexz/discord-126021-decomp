package d0.t.q0;

import d0.d0._Ranges;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import d0.z.d.g0.KMarkers4;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.t.q0.c, reason: use source file name */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MapBuilder2<K, V> implements Map<K, V>, KMarkers4 {
    public static final a j = new a(null);
    public int k;
    public int l;
    public MapBuilder4<K> m;
    public MapBuilder5<V> n;
    public MapBuilder3<K, V> o;
    public boolean p;
    public K[] q;
    public V[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int[] f3583s;
    public int[] t;
    public int u;
    public int v;

    /* JADX INFO: renamed from: d0.t.q0.c$a */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$computeHashSize(a aVar, int i) {
            Objects.requireNonNull(aVar);
            return Integer.highestOneBit(_Ranges.coerceAtLeast(i, 1) * 3);
        }

        public static final int access$computeShift(a aVar, int i) {
            Objects.requireNonNull(aVar);
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$b */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, KMarkers {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder2<K, V> mapBuilder2) {
            super(mapBuilder2);
            Intrinsics3.checkNotNullParameter(mapBuilder2, "map");
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics3.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().q[getLastIndex$kotlin_stdlib()];
            if (Intrinsics3.areEqual(obj, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = getMap$kotlin_stdlib().r;
            Intrinsics3.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            if (Intrinsics3.areEqual(obj2, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            initNext$kotlin_stdlib();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().q[getLastIndex$kotlin_stdlib()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = getMap$kotlin_stdlib().r;
            Intrinsics3.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return iHashCode2;
        }

        @Override // java.util.Iterator
        public c<K, V> next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            c<K, V> cVar = new c<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return cVar;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$c */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class c<K, V> implements Map.Entry<K, V>, KMarkers {
        public final MapBuilder2<K, V> j;
        public final int k;

        public c(MapBuilder2<K, V> mapBuilder2, int i) {
            Intrinsics3.checkNotNullParameter(mapBuilder2, "map");
            this.j = mapBuilder2;
            this.k = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (Intrinsics3.areEqual(entry.getKey(), getKey()) && Intrinsics3.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.j.q[this.k];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.j.r;
            Intrinsics3.checkNotNull(objArr);
            return (V) objArr[this.k];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.j.checkIsMutable$kotlin_stdlib();
            Object[] objArrA = this.j.a();
            int i = this.k;
            V v2 = (V) objArrA[i];
            objArrA[i] = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$d */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static class d<K, V> {
        public int j;
        public int k;
        public final MapBuilder2<K, V> l;

        public d(MapBuilder2<K, V> mapBuilder2) {
            Intrinsics3.checkNotNullParameter(mapBuilder2, "map");
            this.l = mapBuilder2;
            this.k = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.j;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.k;
        }

        public final MapBuilder2<K, V> getMap$kotlin_stdlib() {
            return this.l;
        }

        public final boolean hasNext() {
            return this.j < this.l.v;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.j < this.l.v) {
                int[] iArr = this.l.f3583s;
                int i = this.j;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.j = i + 1;
                }
            }
        }

        public final void remove() {
            if (!(this.k != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.l.checkIsMutable$kotlin_stdlib();
            this.l.g(this.k);
            this.k = -1;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.j = i;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.k = i;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$e */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, KMarkers {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder2<K, V> mapBuilder2) {
            super(mapBuilder2);
            Intrinsics3.checkNotNullParameter(mapBuilder2, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            K k = (K) getMap$kotlin_stdlib().q[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$f */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, KMarkers {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder2<K, V> mapBuilder2) {
            super(mapBuilder2);
            Intrinsics3.checkNotNullParameter(mapBuilder2, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object[] objArr = getMap$kotlin_stdlib().r;
            Intrinsics3.checkNotNull(objArr);
            V v = (V) objArr[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    public MapBuilder2() {
        this(8);
    }

    public final V[] a() {
        V[] vArr = this.r;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) ListBuilder.arrayOfUninitializedElements(this.q.length);
        this.r = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iE = e(k);
            int iCoerceAtMost = _Ranges.coerceAtMost(this.u * 2, this.t.length / 2);
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
                if (Intrinsics3.areEqual(this.q[i2 - 1], k)) {
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
        this.q = (K[]) ListBuilder.copyOfUninitializedElements(kArr, i3);
        V[] vArr = this.r;
        this.r = vArr != null ? (V[]) ListBuilder.copyOfUninitializedElements(vArr, i3) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.f3583s, i3);
        Intrinsics3.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        this.f3583s = iArrCopyOf;
        int iAccess$computeHashSize = a.access$computeHashSize(j, i3);
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
                if (Intrinsics3.areEqual(this.q[i3], k)) {
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
        ListBuilder.resetRange(this.q, 0, this.v);
        V[] vArr = this.r;
        if (vArr != null) {
            ListBuilder.resetRange(vArr, 0, this.v);
        }
        this.l = 0;
        this.v = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        Intrinsics3.checkNotNullParameter(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "entry");
        int iC = c(entry.getKey());
        if (iC < 0) {
            return false;
        }
        V[] vArr = this.r;
        Intrinsics3.checkNotNull(vArr);
        return Intrinsics3.areEqual(vArr[iC], entry.getValue());
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
                Intrinsics3.checkNotNull(vArr);
                if (Intrinsics3.areEqual(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    public final int e(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.k;
    }

    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
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
            ListBuilder.resetRange(this.q, i4, i2);
            if (vArr != null) {
                ListBuilder.resetRange(vArr, i4, this.v);
            }
            this.v = i4;
        }
        int[] iArr = this.t;
        if (i != iArr.length) {
            this.t = new int[i];
            this.k = a.access$computeShift(j, i);
        } else {
            _ArraysJvm.fill(iArr, 0, 0, iArr.length);
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
        ListBuilder.resetAt(this.q, i);
        int length = this.f3583s[i];
        int iCoerceAtMost = _Ranges.coerceAtMost(this.u * 2, this.t.length / 2);
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
        Intrinsics3.checkNotNull(vArr);
        return vArr[iC];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilder3<K, V> mapBuilder3 = this.o;
        if (mapBuilder3 != null) {
            return mapBuilder3;
        }
        MapBuilder3<K, V> mapBuilder4 = new MapBuilder3<>(this);
        this.o = mapBuilder4;
        return mapBuilder4;
    }

    public Set<K> getKeys() {
        MapBuilder4<K> mapBuilder4 = this.m;
        if (mapBuilder4 != null) {
            return mapBuilder4;
        }
        MapBuilder4<K> mapBuilder5 = new MapBuilder4<>(this);
        this.m = mapBuilder5;
        return mapBuilder5;
    }

    public int getSize() {
        return this.l;
    }

    public Collection<V> getValues() {
        MapBuilder5<V> mapBuilder5 = this.n;
        if (mapBuilder5 != null) {
            return mapBuilder5;
        }
        MapBuilder5<V> mapBuilder6 = new MapBuilder5<>(this);
        this.n = mapBuilder6;
        return mapBuilder6;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iNextHashCode$kotlin_stdlib = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iNextHashCode$kotlin_stdlib += bVarEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
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

    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
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
        Intrinsics3.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        b(setEntrySet.size());
        for (Map.Entry<? extends K, ? extends V> entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
            V[] vArrA = a();
            if (iAddKey$kotlin_stdlib >= 0) {
                vArrA[iAddKey$kotlin_stdlib] = entry.getValue();
            } else {
                int i = (-iAddKey$kotlin_stdlib) - 1;
                if (!Intrinsics3.areEqual(entry.getValue(), vArrA[i])) {
                    vArrA[i] = entry.getValue();
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
        Intrinsics3.checkNotNull(vArr);
        V v = vArr[iRemoveKey$kotlin_stdlib];
        ListBuilder.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics3.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iC = c(entry.getKey());
        if (iC < 0) {
            return false;
        }
        V[] vArr = this.r;
        Intrinsics3.checkNotNull(vArr);
        if (!Intrinsics3.areEqual(vArr[iC], entry.getValue())) {
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
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public MapBuilder2(int i) {
        K[] kArr = (K[]) ListBuilder.arrayOfUninitializedElements(i);
        int[] iArr = new int[i];
        a aVar = j;
        int iAccess$computeHashSize = a.access$computeHashSize(aVar, i);
        this.q = kArr;
        this.r = null;
        this.f3583s = iArr;
        this.t = new int[iAccess$computeHashSize];
        this.u = 2;
        this.v = 0;
        this.k = a.access$computeShift(aVar, iAccess$computeHashSize);
    }
}
