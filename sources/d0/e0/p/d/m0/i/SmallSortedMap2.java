package d0.e0.p.d.m0.i;

import b.d.b.a.outline;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.t, reason: use source file name */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class SmallSortedMap2<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int j = 0;
    public final int k;
    public List<SmallSortedMap2<K, V>.b> l = Collections.emptyList();
    public Map<K, V> m = Collections.emptyMap();
    public boolean n;
    public volatile SmallSortedMap2<K, V>.d o;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$a */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public static class a {
        public static final Iterator<Object> a = new C0401a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Iterable<Object> f3433b = new b();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SmallSortedMap.java */
        public static class C0401a implements Iterator<Object> {
            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$a$b */
        /* JADX INFO: compiled from: SmallSortedMap.java */
        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return a.a;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$b */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class b implements Comparable<SmallSortedMap2<K, V>.b>, Map.Entry<K, V> {
        public final K j;
        public V k;

        public b(SmallSortedMap2 smallSortedMap2, Map.Entry<K, V> entry) {
            K key = entry.getKey();
            V value = entry.getValue();
            SmallSortedMap2.this = smallSortedMap2;
            this.j = key;
            this.k = value;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            boolean zEquals;
            boolean zEquals2;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.j;
            Object key = entry.getKey();
            if (k == null) {
                zEquals = key == null;
            } else {
                zEquals = k.equals(key);
            }
            if (zEquals) {
                V v = this.k;
                Object value = entry.getValue();
                if (v == null) {
                    zEquals2 = value == null;
                } else {
                    zEquals2 = v.equals(value);
                }
                if (zEquals2) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.k;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.j;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.k;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            SmallSortedMap2 smallSortedMap2 = SmallSortedMap2.this;
            int i = SmallSortedMap2.j;
            smallSortedMap2.b();
            V v2 = this.k;
            this.k = v;
            return v2;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.j);
            String strValueOf2 = String.valueOf(this.k);
            return outline.K(new StringBuilder(strValueOf2.length() + strValueOf.length() + 1), strValueOf, "=", strValueOf2);
        }

        @Override // java.lang.Comparable
        public int compareTo(SmallSortedMap2<K, V>.b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.j;
        }

        public b(K k, V v) {
            this.j = k;
            this.k = v;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$c */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class c implements Iterator<Map.Entry<K, V>> {
        public int j = -1;
        public boolean k;
        public Iterator<Map.Entry<K, V>> l;

        public c(SmallSortedMap smallSortedMap) {
        }

        public final Iterator<Map.Entry<K, V>> a() {
            if (this.l == null) {
                this.l = SmallSortedMap2.this.m.entrySet().iterator();
            }
            return this.l;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j + 1 < SmallSortedMap2.this.l.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.k) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.k = false;
            SmallSortedMap2 smallSortedMap2 = SmallSortedMap2.this;
            int i = SmallSortedMap2.j;
            smallSortedMap2.b();
            if (this.j >= SmallSortedMap2.this.l.size()) {
                a().remove();
                return;
            }
            SmallSortedMap2 smallSortedMap3 = SmallSortedMap2.this;
            int i2 = this.j;
            this.j = i2 - 1;
            smallSortedMap3.d(i2);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.k = true;
            int i = this.j + 1;
            this.j = i;
            return i < SmallSortedMap2.this.l.size() ? SmallSortedMap2.this.l.get(this.j) : a().next();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$d */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d(SmallSortedMap smallSortedMap) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            SmallSortedMap2.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = SmallSortedMap2.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c(null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            SmallSortedMap2.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return SmallSortedMap2.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            SmallSortedMap2.this.put((Comparable) entry.getKey(), (Object) entry.getValue());
            return true;
        }
    }

    public SmallSortedMap2(int i, SmallSortedMap smallSortedMap) {
        this.k = i;
    }

    public final int a(K k) {
        int size = this.l.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo(this.l.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int iCompareTo2 = k.compareTo(this.l.get(i2).getKey());
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final void b() {
        if (this.n) {
            throw new UnsupportedOperationException();
        }
    }

    public final SortedMap<K, V> c() {
        b();
        if (this.m.isEmpty() && !(this.m instanceof TreeMap)) {
            this.m = new TreeMap();
        }
        return (SortedMap) this.m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        b();
        if (!this.l.isEmpty()) {
            this.l.clear();
        }
        if (this.m.isEmpty()) {
            return;
        }
        this.m.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.m.containsKey(comparable);
    }

    public final V d(int i) {
        b();
        V value = this.l.remove(i).getValue();
        if (!this.m.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = c().entrySet().iterator();
            this.l.add(new b(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.o == null) {
            this.o = new d(null);
        }
        return this.o;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.l.get(iA).getValue() : this.m.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i) {
        return this.l.get(i);
    }

    public int getNumArrayEntries() {
        return this.l.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        return this.m.isEmpty() ? (Iterable<Map.Entry<K, V>>) a.f3433b : this.m.entrySet();
    }

    public boolean isImmutable() {
        return this.n;
    }

    public void makeImmutable() {
        if (this.n) {
            return;
        }
        this.m = this.m.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.m);
        this.n = true;
    }

    public V put(K k, V v) {
        b();
        int iA = a(k);
        if (iA >= 0) {
            return this.l.get(iA).setValue(v);
        }
        b();
        if (this.l.isEmpty() && !(this.l instanceof ArrayList)) {
            this.l = new ArrayList(this.k);
        }
        int i = -(iA + 1);
        if (i >= this.k) {
            return c().put(k, v);
        }
        int size = this.l.size();
        int i2 = this.k;
        if (size == i2) {
            SmallSortedMap2<K, V>.b bVarRemove = this.l.remove(i2 - 1);
            c().put(bVarRemove.getKey(), bVarRemove.getValue());
        }
        this.l.add(i, new b(k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return d(iA);
        }
        if (this.m.isEmpty()) {
            return null;
        }
        return this.m.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.m.size() + this.l.size();
    }
}
