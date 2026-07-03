package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Comparator<Comparable> f21495j = new C11101a();
    public Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.C11102b entrySet;
    public final C11105e<K, V> header;
    private LinkedTreeMap<K, V>.C11103c keySet;
    public int modCount;
    public C11105e<K, V> root;
    public int size;

    /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$a */
    public class C11101a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$b */
    public class C11102b extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$b$a */
        public class a extends LinkedTreeMap<K, V>.AbstractC11104d<Map.Entry<K, V>> {
            public a(C11102b c11102b) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return m9231a();
            }
        }

        public C11102b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.m9224b((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            C11105e<K, V> c11105eM9224b;
            if (!(obj instanceof Map.Entry) || (c11105eM9224b = LinkedTreeMap.this.m9224b((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.m9227e(c11105eM9224b, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$c */
    public final class C11103c extends AbstractSet<K> {

        /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$c$a */
        public class a extends LinkedTreeMap<K, V>.AbstractC11104d<K> {
            public a(C11103c c11103c) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return m9231a().f21507o;
            }
        }

        public C11103c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.m9225c(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            C11105e<K, V> c11105eM9225c = linkedTreeMap.m9225c(obj);
            if (c11105eM9225c != null) {
                linkedTreeMap.m9227e(c11105eM9225c, true);
            }
            return c11105eM9225c != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$d */
    public abstract class AbstractC11104d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: j */
        public C11105e<K, V> f21498j;

        /* JADX INFO: renamed from: k */
        public C11105e<K, V> f21499k = null;

        /* JADX INFO: renamed from: l */
        public int f21500l;

        public AbstractC11104d() {
            this.f21498j = LinkedTreeMap.this.header.f21505m;
            this.f21500l = LinkedTreeMap.this.modCount;
        }

        /* JADX INFO: renamed from: a */
        public final C11105e<K, V> m9231a() {
            C11105e<K, V> c11105e = this.f21498j;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (c11105e == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != this.f21500l) {
                throw new ConcurrentModificationException();
            }
            this.f21498j = c11105e.f21505m;
            this.f21499k = c11105e;
            return c11105e;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f21498j != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            C11105e<K, V> c11105e = this.f21499k;
            if (c11105e == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.m9227e(c11105e, true);
            this.f21499k = null;
            this.f21500l = LinkedTreeMap.this.modCount;
        }
    }

    public LinkedTreeMap() {
        Comparator<Comparable> comparator = f21495j;
        this.size = 0;
        this.modCount = 0;
        this.header = new C11105e<>();
        this.comparator = comparator;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    /* JADX INFO: renamed from: a */
    public C11105e<K, V> m9223a(K k, boolean z2) {
        int iCompareTo;
        C11105e<K, V> c11105e;
        Comparator<? super K> comparator = this.comparator;
        C11105e<K, V> c11105e2 = this.root;
        if (c11105e2 != null) {
            Comparable comparable = comparator == f21495j ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(c11105e2.f21507o) : comparator.compare(k, c11105e2.f21507o);
                if (iCompareTo == 0) {
                    return c11105e2;
                }
                C11105e<K, V> c11105e3 = iCompareTo < 0 ? c11105e2.f21503k : c11105e2.f21504l;
                if (c11105e3 == null) {
                    break;
                }
                c11105e2 = c11105e3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        C11105e<K, V> c11105e4 = this.header;
        if (c11105e2 != null) {
            c11105e = new C11105e<>(c11105e2, k, c11105e4, c11105e4.f21506n);
            if (iCompareTo < 0) {
                c11105e2.f21503k = c11105e;
            } else {
                c11105e2.f21504l = c11105e;
            }
            m9226d(c11105e2, true);
        } else {
            if (comparator == f21495j && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            c11105e = new C11105e<>(c11105e2, k, c11105e4, c11105e4.f21506n);
            this.root = c11105e;
        }
        this.size++;
        this.modCount++;
        return c11105e;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    /* JADX INFO: renamed from: b */
    public C11105e<K, V> m9224b(Map.Entry<?, ?> entry) {
        boolean z2;
        C11105e<K, V> c11105eM9225c = m9225c(entry.getKey());
        if (c11105eM9225c != null) {
            V v = c11105eM9225c.f21508p;
            Object value = entry.getValue();
            z2 = v == value || (v != null && v.equals(value));
        }
        if (z2) {
            return c11105eM9225c;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    public C11105e<K, V> m9225c(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return m9223a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        C11105e<K, V> c11105e = this.header;
        c11105e.f21506n = c11105e;
        c11105e.f21505m = c11105e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m9225c(obj) != null;
    }

    /* JADX INFO: renamed from: d */
    public final void m9226d(C11105e<K, V> c11105e, boolean z2) {
        while (c11105e != null) {
            C11105e<K, V> c11105e2 = c11105e.f21503k;
            C11105e<K, V> c11105e3 = c11105e.f21504l;
            int i = c11105e2 != null ? c11105e2.f21509q : 0;
            int i2 = c11105e3 != null ? c11105e3.f21509q : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                C11105e<K, V> c11105e4 = c11105e3.f21503k;
                C11105e<K, V> c11105e5 = c11105e3.f21504l;
                int i4 = (c11105e4 != null ? c11105e4.f21509q : 0) - (c11105e5 != null ? c11105e5.f21509q : 0);
                if (i4 == -1 || (i4 == 0 && !z2)) {
                    m9229g(c11105e);
                } else {
                    m9230h(c11105e3);
                    m9229g(c11105e);
                }
                if (z2) {
                    return;
                }
            } else if (i3 == 2) {
                C11105e<K, V> c11105e6 = c11105e2.f21503k;
                C11105e<K, V> c11105e7 = c11105e2.f21504l;
                int i5 = (c11105e6 != null ? c11105e6.f21509q : 0) - (c11105e7 != null ? c11105e7.f21509q : 0);
                if (i5 == 1 || (i5 == 0 && !z2)) {
                    m9230h(c11105e);
                } else {
                    m9229g(c11105e2);
                    m9230h(c11105e);
                }
                if (z2) {
                    return;
                }
            } else if (i3 == 0) {
                c11105e.f21509q = i + 1;
                if (z2) {
                    return;
                }
            } else {
                c11105e.f21509q = Math.max(i, i2) + 1;
                if (!z2) {
                    return;
                }
            }
            c11105e = c11105e.f21502j;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m9227e(C11105e<K, V> c11105e, boolean z2) {
        C11105e<K, V> c11105e2;
        C11105e<K, V> c11105e3;
        int i;
        if (z2) {
            C11105e<K, V> c11105e4 = c11105e.f21506n;
            c11105e4.f21505m = c11105e.f21505m;
            c11105e.f21505m.f21506n = c11105e4;
        }
        C11105e<K, V> c11105e5 = c11105e.f21503k;
        C11105e<K, V> c11105e6 = c11105e.f21504l;
        C11105e<K, V> c11105e7 = c11105e.f21502j;
        int i2 = 0;
        if (c11105e5 == null || c11105e6 == null) {
            if (c11105e5 != null) {
                m9228f(c11105e, c11105e5);
                c11105e.f21503k = null;
            } else if (c11105e6 != null) {
                m9228f(c11105e, c11105e6);
                c11105e.f21504l = null;
            } else {
                m9228f(c11105e, null);
            }
            m9226d(c11105e7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (c11105e5.f21509q > c11105e6.f21509q) {
            C11105e<K, V> c11105e8 = c11105e5.f21504l;
            while (true) {
                C11105e<K, V> c11105e9 = c11105e8;
                c11105e3 = c11105e5;
                c11105e5 = c11105e9;
                if (c11105e5 == null) {
                    break;
                } else {
                    c11105e8 = c11105e5.f21504l;
                }
            }
        } else {
            C11105e<K, V> c11105e10 = c11105e6.f21503k;
            while (true) {
                c11105e2 = c11105e6;
                c11105e6 = c11105e10;
                if (c11105e6 == null) {
                    break;
                } else {
                    c11105e10 = c11105e6.f21503k;
                }
            }
            c11105e3 = c11105e2;
        }
        m9227e(c11105e3, false);
        C11105e<K, V> c11105e11 = c11105e.f21503k;
        if (c11105e11 != null) {
            i = c11105e11.f21509q;
            c11105e3.f21503k = c11105e11;
            c11105e11.f21502j = c11105e3;
            c11105e.f21503k = null;
        } else {
            i = 0;
        }
        C11105e<K, V> c11105e12 = c11105e.f21504l;
        if (c11105e12 != null) {
            i2 = c11105e12.f21509q;
            c11105e3.f21504l = c11105e12;
            c11105e12.f21502j = c11105e3;
            c11105e.f21504l = null;
        }
        c11105e3.f21509q = Math.max(i, i2) + 1;
        m9228f(c11105e, c11105e3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.C11102b c11102b = this.entrySet;
        if (c11102b != null) {
            return c11102b;
        }
        LinkedTreeMap<K, V>.C11102b c11102b2 = new C11102b();
        this.entrySet = c11102b2;
        return c11102b2;
    }

    /* JADX INFO: renamed from: f */
    public final void m9228f(C11105e<K, V> c11105e, C11105e<K, V> c11105e2) {
        C11105e<K, V> c11105e3 = c11105e.f21502j;
        c11105e.f21502j = null;
        if (c11105e2 != null) {
            c11105e2.f21502j = c11105e3;
        }
        if (c11105e3 == null) {
            this.root = c11105e2;
        } else if (c11105e3.f21503k == c11105e) {
            c11105e3.f21503k = c11105e2;
        } else {
            c11105e3.f21504l = c11105e2;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m9229g(C11105e<K, V> c11105e) {
        C11105e<K, V> c11105e2 = c11105e.f21503k;
        C11105e<K, V> c11105e3 = c11105e.f21504l;
        C11105e<K, V> c11105e4 = c11105e3.f21503k;
        C11105e<K, V> c11105e5 = c11105e3.f21504l;
        c11105e.f21504l = c11105e4;
        if (c11105e4 != null) {
            c11105e4.f21502j = c11105e;
        }
        m9228f(c11105e, c11105e3);
        c11105e3.f21503k = c11105e;
        c11105e.f21502j = c11105e3;
        int iMax = Math.max(c11105e2 != null ? c11105e2.f21509q : 0, c11105e4 != null ? c11105e4.f21509q : 0) + 1;
        c11105e.f21509q = iMax;
        c11105e3.f21509q = Math.max(iMax, c11105e5 != null ? c11105e5.f21509q : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        C11105e<K, V> c11105eM9225c = m9225c(obj);
        if (c11105eM9225c != null) {
            return c11105eM9225c.f21508p;
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public final void m9230h(C11105e<K, V> c11105e) {
        C11105e<K, V> c11105e2 = c11105e.f21503k;
        C11105e<K, V> c11105e3 = c11105e.f21504l;
        C11105e<K, V> c11105e4 = c11105e2.f21503k;
        C11105e<K, V> c11105e5 = c11105e2.f21504l;
        c11105e.f21503k = c11105e5;
        if (c11105e5 != null) {
            c11105e5.f21502j = c11105e;
        }
        m9228f(c11105e, c11105e2);
        c11105e2.f21504l = c11105e;
        c11105e.f21502j = c11105e2;
        int iMax = Math.max(c11105e3 != null ? c11105e3.f21509q : 0, c11105e5 != null ? c11105e5.f21509q : 0) + 1;
        c11105e.f21509q = iMax;
        c11105e2.f21509q = Math.max(iMax, c11105e4 != null ? c11105e4.f21509q : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.C11103c c11103c = this.keySet;
        if (c11103c != null) {
            return c11103c;
        }
        LinkedTreeMap<K, V>.C11103c c11103c2 = new C11103c();
        this.keySet = c11103c2;
        return c11103c2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        C11105e<K, V> c11105eM9223a = m9223a(k, true);
        V v2 = c11105eM9223a.f21508p;
        c11105eM9223a.f21508p = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        C11105e<K, V> c11105eM9225c = m9225c(obj);
        if (c11105eM9225c != null) {
            m9227e(c11105eM9225c, true);
        }
        if (c11105eM9225c != null) {
            return c11105eM9225c.f21508p;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    /* JADX INFO: renamed from: com.google.gson.internal.LinkedTreeMap$e */
    public static final class C11105e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: j */
        public C11105e<K, V> f21502j;

        /* JADX INFO: renamed from: k */
        public C11105e<K, V> f21503k;

        /* JADX INFO: renamed from: l */
        public C11105e<K, V> f21504l;

        /* JADX INFO: renamed from: m */
        public C11105e<K, V> f21505m;

        /* JADX INFO: renamed from: n */
        public C11105e<K, V> f21506n;

        /* JADX INFO: renamed from: o */
        public final K f21507o;

        /* JADX INFO: renamed from: p */
        public V f21508p;

        /* JADX INFO: renamed from: q */
        public int f21509q;

        public C11105e() {
            this.f21507o = null;
            this.f21506n = this;
            this.f21505m = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f21507o;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f21508p;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f21507o;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f21508p;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f21507o;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.f21508p;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f21508p;
            this.f21508p = v;
            return v2;
        }

        public String toString() {
            return this.f21507o + "=" + this.f21508p;
        }

        public C11105e(C11105e<K, V> c11105e, K k, C11105e<K, V> c11105e2, C11105e<K, V> c11105e3) {
            this.f21502j = c11105e;
            this.f21507o = k;
            this.f21509q = 1;
            this.f21505m = c11105e2;
            this.f21506n = c11105e3;
            c11105e3.f21505m = this;
            c11105e2.f21506n = this;
        }
    }
}
