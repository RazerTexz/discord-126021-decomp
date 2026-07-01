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
    public static final Comparator<Comparable> j = new a();
    public Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.b entrySet;
    public final e<K, V> header;
    private LinkedTreeMap<K, V>.c keySet;
    public int modCount;
    public e<K, V> root;
    public int size;

    public class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends LinkedTreeMap<K, V>.d<Map.Entry<K, V>> {
            public a(b bVar) {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.b((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarB;
            if (!(obj instanceof Map.Entry) || (eVarB = LinkedTreeMap.this.b((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.e(eVarB, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends LinkedTreeMap<K, V>.d<K> {
            public a(c cVar) {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().o;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.c(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            e<K, V> eVarC = linkedTreeMap.c(obj);
            if (eVarC != null) {
                linkedTreeMap.e(eVarC, true);
            }
            return eVarC != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    public abstract class d<T> implements Iterator<T> {
        public e<K, V> j;
        public e<K, V> k = null;
        public int l;

        public d() {
            this.j = LinkedTreeMap.this.header.m;
            this.l = LinkedTreeMap.this.modCount;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.j;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (eVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != this.l) {
                throw new ConcurrentModificationException();
            }
            this.j = eVar.m;
            this.k = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.j != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.k;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.e(eVar, true);
            this.k = null;
            this.l = LinkedTreeMap.this.modCount;
        }
    }

    public LinkedTreeMap() {
        Comparator<Comparable> comparator = j;
        this.size = 0;
        this.modCount = 0;
        this.header = new e<>();
        this.comparator = comparator;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public e<K, V> a(K k, boolean z2) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.comparator;
        e<K, V> eVar2 = this.root;
        if (eVar2 != null) {
            Comparable comparable = comparator == j ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.o) : comparator.compare(k, eVar2.o);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.k : eVar2.l;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z2) {
            return null;
        }
        e<K, V> eVar4 = this.header;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.n);
            if (iCompareTo < 0) {
                eVar2.k = eVar;
            } else {
                eVar2.l = eVar;
            }
            d(eVar2, true);
        } else {
            if (comparator == j && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k, eVar4, eVar4.n);
            this.root = eVar;
        }
        this.size++;
        this.modCount++;
        return eVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0023  */
    public e<K, V> b(Map.Entry<?, ?> entry) {
        boolean z2;
        e<K, V> eVarC = c(entry.getKey());
        if (eVarC != null) {
            V v = eVarC.p;
            Object value = entry.getValue();
            z2 = v == value || (v != null && v.equals(value));
        }
        if (z2) {
            return eVarC;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> c(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        e<K, V> eVar = this.header;
        eVar.n = eVar;
        eVar.m = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return c(obj) != null;
    }

    public final void d(e<K, V> eVar, boolean z2) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.k;
            e<K, V> eVar3 = eVar.l;
            int i = eVar2 != null ? eVar2.q : 0;
            int i2 = eVar3 != null ? eVar3.q : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.k;
                e<K, V> eVar5 = eVar3.l;
                int i4 = (eVar4 != null ? eVar4.q : 0) - (eVar5 != null ? eVar5.q : 0);
                if (i4 == -1 || (i4 == 0 && !z2)) {
                    g(eVar);
                } else {
                    h(eVar3);
                    g(eVar);
                }
                if (z2) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.k;
                e<K, V> eVar7 = eVar2.l;
                int i5 = (eVar6 != null ? eVar6.q : 0) - (eVar7 != null ? eVar7.q : 0);
                if (i5 == 1 || (i5 == 0 && !z2)) {
                    h(eVar);
                } else {
                    g(eVar2);
                    h(eVar);
                }
                if (z2) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.q = i + 1;
                if (z2) {
                    return;
                }
            } else {
                eVar.q = Math.max(i, i2) + 1;
                if (!z2) {
                    return;
                }
            }
            eVar = eVar.j;
        }
    }

    public void e(e<K, V> eVar, boolean z2) {
        e<K, V> eVar2;
        e<K, V> eVar3;
        int i;
        if (z2) {
            e<K, V> eVar4 = eVar.n;
            eVar4.m = eVar.m;
            eVar.m.n = eVar4;
        }
        e<K, V> eVar5 = eVar.k;
        e<K, V> eVar6 = eVar.l;
        e<K, V> eVar7 = eVar.j;
        int i2 = 0;
        if (eVar5 == null || eVar6 == null) {
            if (eVar5 != null) {
                f(eVar, eVar5);
                eVar.k = null;
            } else if (eVar6 != null) {
                f(eVar, eVar6);
                eVar.l = null;
            } else {
                f(eVar, null);
            }
            d(eVar7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (eVar5.q > eVar6.q) {
            e<K, V> eVar8 = eVar5.l;
            while (true) {
                e<K, V> eVar9 = eVar8;
                eVar3 = eVar5;
                eVar5 = eVar9;
                if (eVar5 == null) {
                    break;
                } else {
                    eVar8 = eVar5.l;
                }
            }
        } else {
            e<K, V> eVar10 = eVar6.k;
            while (true) {
                eVar2 = eVar6;
                eVar6 = eVar10;
                if (eVar6 == null) {
                    break;
                } else {
                    eVar10 = eVar6.k;
                }
            }
            eVar3 = eVar2;
        }
        e(eVar3, false);
        e<K, V> eVar11 = eVar.k;
        if (eVar11 != null) {
            i = eVar11.q;
            eVar3.k = eVar11;
            eVar11.j = eVar3;
            eVar.k = null;
        } else {
            i = 0;
        }
        e<K, V> eVar12 = eVar.l;
        if (eVar12 != null) {
            i2 = eVar12.q;
            eVar3.l = eVar12;
            eVar12.j = eVar3;
            eVar.l = null;
        }
        eVar3.q = Math.max(i, i2) + 1;
        f(eVar, eVar3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.b bVar = this.entrySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.entrySet = bVar2;
        return bVar2;
    }

    public final void f(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.j;
        eVar.j = null;
        if (eVar2 != null) {
            eVar2.j = eVar3;
        }
        if (eVar3 == null) {
            this.root = eVar2;
        } else if (eVar3.k == eVar) {
            eVar3.k = eVar2;
        } else {
            eVar3.l = eVar2;
        }
    }

    public final void g(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.k;
        e<K, V> eVar3 = eVar.l;
        e<K, V> eVar4 = eVar3.k;
        e<K, V> eVar5 = eVar3.l;
        eVar.l = eVar4;
        if (eVar4 != null) {
            eVar4.j = eVar;
        }
        f(eVar, eVar3);
        eVar3.k = eVar;
        eVar.j = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.q : 0, eVar4 != null ? eVar4.q : 0) + 1;
        eVar.q = iMax;
        eVar3.q = Math.max(iMax, eVar5 != null ? eVar5.q : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarC = c(obj);
        if (eVarC != null) {
            return eVarC.p;
        }
        return null;
    }

    public final void h(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.k;
        e<K, V> eVar3 = eVar.l;
        e<K, V> eVar4 = eVar2.k;
        e<K, V> eVar5 = eVar2.l;
        eVar.k = eVar5;
        if (eVar5 != null) {
            eVar5.j = eVar;
        }
        f(eVar, eVar2);
        eVar2.l = eVar;
        eVar.j = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.q : 0, eVar5 != null ? eVar5.q : 0) + 1;
        eVar.q = iMax;
        eVar2.q = Math.max(iMax, eVar4 != null ? eVar4.q : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.c cVar = this.keySet;
        if (cVar != null) {
            return cVar;
        }
        LinkedTreeMap<K, V>.c cVar2 = new c();
        this.keySet = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> eVarA = a(k, true);
        V v2 = eVarA.p;
        eVarA.p = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarC = c(obj);
        if (eVarC != null) {
            e(eVarC, true);
        }
        if (eVarC != null) {
            return eVarC.p;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public static final class e<K, V> implements Map.Entry<K, V> {
        public e<K, V> j;
        public e<K, V> k;
        public e<K, V> l;
        public e<K, V> m;
        public e<K, V> n;
        public final K o;
        public V p;
        public int q;

        public e() {
            this.o = null;
            this.n = this;
            this.m = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.o;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.p;
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
            return this.o;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.p;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.o;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.p;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.p;
            this.p = v;
            return v2;
        }

        public String toString() {
            return this.o + "=" + this.p;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.j = eVar;
            this.o = k;
            this.q = 1;
            this.m = eVar2;
            this.n = eVar3;
            eVar3.m = this;
            eVar2.n = this;
        }
    }
}
