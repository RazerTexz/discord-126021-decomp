package p507d0.p513e0.p514p.p515d.p517m0.p550i;

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
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.t */
/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11740t<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f24167j = 0;

    /* JADX INFO: renamed from: k */
    public final int f24168k;

    /* JADX INFO: renamed from: l */
    public List<C11740t<K, V>.b> f24169l = Collections.emptyList();

    /* JADX INFO: renamed from: m */
    public Map<K, V> f24170m = Collections.emptyMap();

    /* JADX INFO: renamed from: n */
    public boolean f24171n;

    /* JADX INFO: renamed from: o */
    public volatile C11740t<K, V>.d f24172o;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$a */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public static final Iterator<Object> f24173a = new C13325a();

        /* JADX INFO: renamed from: b */
        public static final Iterable<Object> f24174b = new b();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SmallSortedMap.java */
        public static class C13325a implements Iterator<Object> {
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
                return a.f24173a;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$b */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class b implements Comparable<C11740t<K, V>.b>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: j */
        public final K f24175j;

        /* JADX INFO: renamed from: k */
        public V f24176k;

        public b(C11740t c11740t, Map.Entry<K, V> entry) {
            K key = entry.getKey();
            V value = entry.getValue();
            C11740t.this = c11740t;
            this.f24175j = key;
            this.f24176k = value;
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
            K k = this.f24175j;
            Object key = entry.getKey();
            if (k == null) {
                zEquals = key == null;
            } else {
                zEquals = k.equals(key);
            }
            if (zEquals) {
                V v = this.f24176k;
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
            return this.f24176k;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f24175j;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.f24176k;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            C11740t c11740t = C11740t.this;
            int i = C11740t.f24167j;
            c11740t.m9862b();
            V v2 = this.f24176k;
            this.f24176k = v;
            return v2;
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f24175j);
            String strValueOf2 = String.valueOf(this.f24176k);
            return C1643a.m823K(new StringBuilder(strValueOf2.length() + strValueOf.length() + 1), strValueOf, "=", strValueOf2);
        }

        @Override // java.lang.Comparable
        public int compareTo(C11740t<K, V>.b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f24175j;
        }

        public b(K k, V v) {
            this.f24175j = k;
            this.f24176k = v;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$c */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class c implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: j */
        public int f24178j = -1;

        /* JADX INFO: renamed from: k */
        public boolean f24179k;

        /* JADX INFO: renamed from: l */
        public Iterator<Map.Entry<K, V>> f24180l;

        public c(C11739s c11739s) {
        }

        /* JADX INFO: renamed from: a */
        public final Iterator<Map.Entry<K, V>> m9865a() {
            if (this.f24180l == null) {
                this.f24180l = C11740t.this.f24170m.entrySet().iterator();
            }
            return this.f24180l;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24178j + 1 < C11740t.this.f24169l.size() || m9865a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f24179k) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f24179k = false;
            C11740t c11740t = C11740t.this;
            int i = C11740t.f24167j;
            c11740t.m9862b();
            if (this.f24178j >= C11740t.this.f24169l.size()) {
                m9865a().remove();
                return;
            }
            C11740t c11740t2 = C11740t.this;
            int i2 = this.f24178j;
            this.f24178j = i2 - 1;
            c11740t2.m9864d(i2);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.f24179k = true;
            int i = this.f24178j + 1;
            this.f24178j = i;
            return i < C11740t.this.f24169l.size() ? C11740t.this.f24169l.get(this.f24178j) : m9865a().next();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.t$d */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d(C11739s c11739s) {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            C11740t.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = C11740t.this.get(entry.getKey());
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
            C11740t.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C11740t.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            C11740t.this.put((Comparable) entry.getKey(), (Object) entry.getValue());
            return true;
        }
    }

    public C11740t(int i, C11739s c11739s) {
        this.f24168k = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m9861a(K k) {
        int size = this.f24169l.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo(this.f24169l.get(size).getKey());
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
            int iCompareTo2 = k.compareTo(this.f24169l.get(i2).getKey());
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

    /* JADX INFO: renamed from: b */
    public final void m9862b() {
        if (this.f24171n) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: c */
    public final SortedMap<K, V> m9863c() {
        m9862b();
        if (this.f24170m.isEmpty() && !(this.f24170m instanceof TreeMap)) {
            this.f24170m = new TreeMap();
        }
        return (SortedMap) this.f24170m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        m9862b();
        if (!this.f24169l.isEmpty()) {
            this.f24169l.clear();
        }
        if (this.f24170m.isEmpty()) {
            return;
        }
        this.f24170m.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m9861a(comparable) >= 0 || this.f24170m.containsKey(comparable);
    }

    /* JADX INFO: renamed from: d */
    public final V m9864d(int i) {
        m9862b();
        V value = this.f24169l.remove(i).getValue();
        if (!this.f24170m.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m9863c().entrySet().iterator();
            this.f24169l.add(new b(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f24172o == null) {
            this.f24172o = new d(null);
        }
        return this.f24172o;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iM9861a = m9861a(comparable);
        return iM9861a >= 0 ? this.f24169l.get(iM9861a).getValue() : this.f24170m.get(comparable);
    }

    public Map.Entry<K, V> getArrayEntryAt(int i) {
        return this.f24169l.get(i);
    }

    public int getNumArrayEntries() {
        return this.f24169l.size();
    }

    public Iterable<Map.Entry<K, V>> getOverflowEntries() {
        return this.f24170m.isEmpty() ? (Iterable<Map.Entry<K, V>>) a.f24174b : this.f24170m.entrySet();
    }

    public boolean isImmutable() {
        return this.f24171n;
    }

    public void makeImmutable() {
        if (this.f24171n) {
            return;
        }
        this.f24170m = this.f24170m.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f24170m);
        this.f24171n = true;
    }

    public V put(K k, V v) {
        m9862b();
        int iM9861a = m9861a(k);
        if (iM9861a >= 0) {
            return this.f24169l.get(iM9861a).setValue(v);
        }
        m9862b();
        if (this.f24169l.isEmpty() && !(this.f24169l instanceof ArrayList)) {
            this.f24169l = new ArrayList(this.f24168k);
        }
        int i = -(iM9861a + 1);
        if (i >= this.f24168k) {
            return m9863c().put(k, v);
        }
        int size = this.f24169l.size();
        int i2 = this.f24168k;
        if (size == i2) {
            C11740t<K, V>.b bVarRemove = this.f24169l.remove(i2 - 1);
            m9863c().put(bVarRemove.getKey(), bVarRemove.getValue());
        }
        this.f24169l.add(i, new b(k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        m9862b();
        Comparable comparable = (Comparable) obj;
        int iM9861a = m9861a(comparable);
        if (iM9861a >= 0) {
            return m9864d(iM9861a);
        }
        if (this.f24170m.isEmpty()) {
            return null;
        }
        return this.f24170m.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f24170m.size() + this.f24169l.size();
    }
}
