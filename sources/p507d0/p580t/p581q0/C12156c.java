package p507d0.p580t.p581q0;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12139j;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;
import p507d0.p592z.p594d.p595g0.InterfaceC12231d;

/* JADX INFO: renamed from: d0.t.q0.c */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12156c<K, V> implements Map<K, V>, InterfaceC12231d {

    /* JADX INFO: renamed from: j */
    public static final a f25198j = new a(null);

    /* JADX INFO: renamed from: k */
    public int f25199k;

    /* JADX INFO: renamed from: l */
    public int f25200l;

    /* JADX INFO: renamed from: m */
    public C12158e<K> f25201m;

    /* JADX INFO: renamed from: n */
    public C12159f<V> f25202n;

    /* JADX INFO: renamed from: o */
    public C12157d<K, V> f25203o;

    /* JADX INFO: renamed from: p */
    public boolean f25204p;

    /* JADX INFO: renamed from: q */
    public K[] f25205q;

    /* JADX INFO: renamed from: r */
    public V[] f25206r;

    /* JADX INFO: renamed from: s */
    public int[] f25207s;

    /* JADX INFO: renamed from: t */
    public int[] f25208t;

    /* JADX INFO: renamed from: u */
    public int f25209u;

    /* JADX INFO: renamed from: v */
    public int f25210v;

    /* JADX INFO: renamed from: d0.t.q0.c$a */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$computeHashSize(a aVar, int i) {
            Objects.requireNonNull(aVar);
            return Integer.highestOneBit(C11226f.coerceAtLeast(i, 1) * 3);
        }

        public static final int access$computeShift(a aVar, int i) {
            Objects.requireNonNull(aVar);
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$b */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, InterfaceC12228a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C12156c<K, V> c12156c) {
            super(c12156c);
            C12238m.checkNotNullParameter(c12156c, "map");
        }

        public final void nextAppendString(StringBuilder sb) {
            C12238m.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f25210v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().f25205q[getLastIndex$kotlin_stdlib()];
            if (C12238m.areEqual(obj, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = getMap$kotlin_stdlib().f25206r;
            C12238m.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            if (C12238m.areEqual(obj2, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            initNext$kotlin_stdlib();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f25210v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().f25205q[getLastIndex$kotlin_stdlib()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = getMap$kotlin_stdlib().f25206r;
            C12238m.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return iHashCode2;
        }

        @Override // java.util.Iterator
        public c<K, V> next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f25210v) {
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
    public static final class c<K, V> implements Map.Entry<K, V>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public final C12156c<K, V> f25211j;

        /* JADX INFO: renamed from: k */
        public final int f25212k;

        public c(C12156c<K, V> c12156c, int i) {
            C12238m.checkNotNullParameter(c12156c, "map");
            this.f25211j = c12156c;
            this.f25212k = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (C12238m.areEqual(entry.getKey(), getKey()) && C12238m.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.f25211j.f25205q[this.f25212k];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.f25211j.f25206r;
            C12238m.checkNotNull(objArr);
            return (V) objArr[this.f25212k];
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
            this.f25211j.checkIsMutable$kotlin_stdlib();
            Object[] objArrM10075a = this.f25211j.m10075a();
            int i = this.f25212k;
            V v2 = (V) objArrM10075a[i];
            objArrM10075a[i] = v;
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

        /* JADX INFO: renamed from: j */
        public int f25213j;

        /* JADX INFO: renamed from: k */
        public int f25214k;

        /* JADX INFO: renamed from: l */
        public final C12156c<K, V> f25215l;

        public d(C12156c<K, V> c12156c) {
            C12238m.checkNotNullParameter(c12156c, "map");
            this.f25215l = c12156c;
            this.f25214k = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.f25213j;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.f25214k;
        }

        public final C12156c<K, V> getMap$kotlin_stdlib() {
            return this.f25215l;
        }

        public final boolean hasNext() {
            return this.f25213j < this.f25215l.f25210v;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.f25213j < this.f25215l.f25210v) {
                int[] iArr = this.f25215l.f25207s;
                int i = this.f25213j;
                if (iArr[i] >= 0) {
                    return;
                } else {
                    this.f25213j = i + 1;
                }
            }
        }

        public final void remove() {
            if (!(this.f25214k != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f25215l.checkIsMutable$kotlin_stdlib();
            this.f25215l.m10081g(this.f25214k);
            this.f25214k = -1;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.f25213j = i;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.f25214k = i;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$e */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, InterfaceC12228a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C12156c<K, V> c12156c) {
            super(c12156c);
            C12238m.checkNotNullParameter(c12156c, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f25210v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            K k = (K) getMap$kotlin_stdlib().f25205q[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    /* JADX INFO: renamed from: d0.t.q0.c$f */
    /* JADX INFO: compiled from: MapBuilder.kt */
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, InterfaceC12228a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(C12156c<K, V> c12156c) {
            super(c12156c);
            C12238m.checkNotNullParameter(c12156c, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().f25210v) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object[] objArr = getMap$kotlin_stdlib().f25206r;
            C12238m.checkNotNull(objArr);
            V v = (V) objArr[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    public C12156c() {
        this(8);
    }

    /* JADX INFO: renamed from: a */
    public final V[] m10075a() {
        V[] vArr = this.f25206r;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) C12155b.arrayOfUninitializedElements(this.f25205q.length);
        this.f25206r = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iM10079e = m10079e(k);
            int iCoerceAtMost = C11226f.coerceAtMost(this.f25209u * 2, this.f25208t.length / 2);
            int i = 0;
            while (true) {
                int[] iArr = this.f25208t;
                int i2 = iArr[iM10079e];
                if (i2 <= 0) {
                    int i3 = this.f25210v;
                    K[] kArr = this.f25205q;
                    if (i3 >= kArr.length) {
                        m10076b(1);
                        break;
                    }
                    int i4 = i3 + 1;
                    this.f25210v = i4;
                    kArr[i3] = k;
                    this.f25207s[i3] = iM10079e;
                    iArr[iM10079e] = i4;
                    this.f25200l = size() + 1;
                    if (i > this.f25209u) {
                        this.f25209u = i;
                    }
                    return i3;
                }
                if (C12238m.areEqual(this.f25205q[i2 - 1], k)) {
                    return -i2;
                }
                i++;
                if (i > iCoerceAtMost) {
                    m10080f(this.f25208t.length * 2);
                    break;
                }
                iM10079e = iM10079e == 0 ? this.f25208t.length - 1 : iM10079e - 1;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10076b(int i) {
        int i2 = this.f25210v;
        int i3 = i + i2;
        K[] kArr = this.f25205q;
        if (i3 <= kArr.length) {
            if ((i2 + i3) - size() > this.f25205q.length) {
                m10080f(this.f25208t.length);
                return;
            }
            return;
        }
        int length = (kArr.length * 3) / 2;
        if (i3 <= length) {
            i3 = length;
        }
        this.f25205q = (K[]) C12155b.copyOfUninitializedElements(kArr, i3);
        V[] vArr = this.f25206r;
        this.f25206r = vArr != null ? (V[]) C12155b.copyOfUninitializedElements(vArr, i3) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.f25207s, i3);
        C12238m.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        this.f25207s = iArrCopyOf;
        int iAccess$computeHashSize = a.access$computeHashSize(f25198j, i3);
        if (iAccess$computeHashSize > this.f25208t.length) {
            m10080f(iAccess$computeHashSize);
        }
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.f25204p = true;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final int m10077c(K k) {
        int iM10079e = m10079e(k);
        int i = this.f25209u;
        while (true) {
            int i2 = this.f25208t[iM10079e];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (C12238m.areEqual(this.f25205q[i3], k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iM10079e = iM10079e == 0 ? this.f25208t.length - 1 : iM10079e - 1;
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.f25204p) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.f25210v - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f25207s;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.f25208t[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        C12155b.resetRange(this.f25205q, 0, this.f25210v);
        V[] vArr = this.f25206r;
        if (vArr != null) {
            C12155b.resetRange(vArr, 0, this.f25210v);
        }
        this.f25200l = 0;
        this.f25210v = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        C12238m.checkNotNullParameter(collection, "m");
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
        C12238m.checkNotNullParameter(entry, "entry");
        int iM10077c = m10077c(entry.getKey());
        if (iM10077c < 0) {
            return false;
        }
        V[] vArr = this.f25206r;
        C12238m.checkNotNull(vArr);
        return C12238m.areEqual(vArr[iM10077c], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return m10077c(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return m10078d(obj) >= 0;
    }

    /* JADX INFO: renamed from: d */
    public final int m10078d(V v) {
        int i = this.f25210v;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f25207s[i] >= 0) {
                V[] vArr = this.f25206r;
                C12238m.checkNotNull(vArr);
                if (C12238m.areEqual(vArr[i], v)) {
                    return i;
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m10079e(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.f25199k;
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

    /* JADX INFO: renamed from: f */
    public final void m10080f(int i) {
        boolean z2;
        int i2;
        if (this.f25210v > size()) {
            V[] vArr = this.f25206r;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i2 = this.f25210v;
                if (i3 >= i2) {
                    break;
                }
                if (this.f25207s[i3] >= 0) {
                    K[] kArr = this.f25205q;
                    kArr[i4] = kArr[i3];
                    if (vArr != null) {
                        vArr[i4] = vArr[i3];
                    }
                    i4++;
                }
                i3++;
            }
            C12155b.resetRange(this.f25205q, i4, i2);
            if (vArr != null) {
                C12155b.resetRange(vArr, i4, this.f25210v);
            }
            this.f25210v = i4;
        }
        int[] iArr = this.f25208t;
        if (i != iArr.length) {
            this.f25208t = new int[i];
            this.f25199k = a.access$computeShift(f25198j, i);
        } else {
            C12139j.fill(iArr, 0, 0, iArr.length);
        }
        int i5 = 0;
        while (i5 < this.f25210v) {
            int i6 = i5 + 1;
            int iM10079e = m10079e(this.f25205q[i5]);
            int i7 = this.f25209u;
            while (true) {
                int[] iArr2 = this.f25208t;
                z2 = true;
                if (iArr2[iM10079e] == 0) {
                    iArr2[iM10079e] = i6;
                    this.f25207s[i5] = iM10079e;
                    break;
                } else {
                    i7--;
                    if (i7 < 0) {
                        z2 = false;
                        break;
                    }
                    iM10079e = iM10079e == 0 ? iArr2.length - 1 : iM10079e - 1;
                }
            }
            if (!z2) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i5 = i6;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m10081g(int i) {
        C12155b.resetAt(this.f25205q, i);
        int length = this.f25207s[i];
        int iCoerceAtMost = C11226f.coerceAtMost(this.f25209u * 2, this.f25208t.length / 2);
        int i2 = 0;
        int i3 = length;
        do {
            length = length == 0 ? this.f25208t.length - 1 : length - 1;
            i2++;
            if (i2 > this.f25209u) {
                this.f25208t[i3] = 0;
            } else {
                int[] iArr = this.f25208t;
                int i4 = iArr[length];
                if (i4 == 0) {
                    iArr[i3] = 0;
                } else {
                    if (i4 < 0) {
                        iArr[i3] = -1;
                    } else {
                        int i5 = i4 - 1;
                        int iM10079e = m10079e(this.f25205q[i5]) - length;
                        int[] iArr2 = this.f25208t;
                        if ((iM10079e & (iArr2.length - 1)) >= i2) {
                            iArr2[i3] = i4;
                            this.f25207s[i5] = i3;
                        }
                        iCoerceAtMost--;
                    }
                    i3 = length;
                    i2 = 0;
                    iCoerceAtMost--;
                }
            }
            this.f25207s[i] = -1;
            this.f25200l = size() - 1;
        } while (iCoerceAtMost >= 0);
        this.f25208t[i3] = -1;
        this.f25207s[i] = -1;
        this.f25200l = size() - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iM10077c = m10077c(obj);
        if (iM10077c < 0) {
            return null;
        }
        V[] vArr = this.f25206r;
        C12238m.checkNotNull(vArr);
        return vArr[iM10077c];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        C12157d<K, V> c12157d = this.f25203o;
        if (c12157d != null) {
            return c12157d;
        }
        C12157d<K, V> c12157d2 = new C12157d<>(this);
        this.f25203o = c12157d2;
        return c12157d2;
    }

    public Set<K> getKeys() {
        C12158e<K> c12158e = this.f25201m;
        if (c12158e != null) {
            return c12158e;
        }
        C12158e<K> c12158e2 = new C12158e<>(this);
        this.f25201m = c12158e2;
        return c12158e2;
    }

    public int getSize() {
        return this.f25200l;
    }

    public Collection<V> getValues() {
        C12159f<V> c12159f = this.f25202n;
        if (c12159f != null) {
            return c12159f;
        }
        C12159f<V> c12159f2 = new C12159f<>(this);
        this.f25202n = c12159f2;
        return c12159f2;
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
        V[] vArrM10075a = m10075a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrM10075a[iAddKey$kotlin_stdlib] = v;
            return null;
        }
        int i = (-iAddKey$kotlin_stdlib) - 1;
        V v2 = vArrM10075a[i];
        vArrM10075a[i] = v;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        C12238m.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        m10076b(setEntrySet.size());
        for (Map.Entry<? extends K, ? extends V> entry : setEntrySet) {
            int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
            V[] vArrM10075a = m10075a();
            if (iAddKey$kotlin_stdlib >= 0) {
                vArrM10075a[iAddKey$kotlin_stdlib] = entry.getValue();
            } else {
                int i = (-iAddKey$kotlin_stdlib) - 1;
                if (!C12238m.areEqual(entry.getValue(), vArrM10075a[i])) {
                    vArrM10075a[i] = entry.getValue();
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
        V[] vArr = this.f25206r;
        C12238m.checkNotNull(vArr);
        V v = vArr[iRemoveKey$kotlin_stdlib];
        C12155b.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        C12238m.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iM10077c = m10077c(entry.getKey());
        if (iM10077c < 0) {
            return false;
        }
        V[] vArr = this.f25206r;
        C12238m.checkNotNull(vArr);
        if (!C12238m.areEqual(vArr[iM10077c], entry.getValue())) {
            return false;
        }
        m10081g(iM10077c);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int iM10077c = m10077c(k);
        if (iM10077c < 0) {
            return -1;
        }
        m10081g(iM10077c);
        return iM10077c;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int iM10078d = m10078d(v);
        if (iM10078d < 0) {
            return false;
        }
        m10081g(iM10078d);
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
        C12238m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public C12156c(int i) {
        K[] kArr = (K[]) C12155b.arrayOfUninitializedElements(i);
        int[] iArr = new int[i];
        a aVar = f25198j;
        int iAccess$computeHashSize = a.access$computeHashSize(aVar, i);
        this.f25205q = kArr;
        this.f25206r = null;
        this.f25207s = iArr;
        this.f25208t = new int[iAccess$computeHashSize];
        this.f25209u = 2;
        this.f25210v = 0;
        this.f25199k = a.access$computeShift(aVar, iAccess$computeHashSize);
    }
}
