package b.i.b.b;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.b.e, reason: use source file name */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMapBasedMultimap2<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    public transient Map<K, Collection<V>> m;
    public transient int n;

    /* JADX INFO: renamed from: b.i.b.b.e$a */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class a extends Maps<K, Collection<V>> {
        public final transient Map<K, Collection<V>> l;

        /* JADX INFO: renamed from: b.i.b.b.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class C0044a extends Maps3<K, Collection<V>> {
            public C0044a() {
            }

            @Override // b.i.b.b.Maps3, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                Set<Map.Entry<K, Collection<V>>> setEntrySet = a.this.l.entrySet();
                Objects.requireNonNull(setEntrySet);
                try {
                    return setEntrySet.contains(obj);
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Collection<V> collectionRemove;
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
                Object key = ((Map.Entry) obj).getKey();
                Map<K, Collection<V>> map = abstractMapBasedMultimap2.m;
                Objects.requireNonNull(map);
                try {
                    collectionRemove = map.remove(key);
                } catch (ClassCastException | NullPointerException unused) {
                    collectionRemove = null;
                }
                Collection<V> collection = collectionRemove;
                if (collection == null) {
                    return true;
                }
                int size = collection.size();
                collection.clear();
                abstractMapBasedMultimap2.n -= size;
                return true;
            }
        }

        /* JADX INFO: renamed from: b.i.b.b.e$a$b */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {
            public final Iterator<Map.Entry<K, Collection<V>>> j;

            @NullableDecl
            public Collection<V> k;

            public b() {
                this.j = a.this.l.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.j.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry<K, Collection<V>> next = this.j.next();
                this.k = next.getValue();
                return a.this.a(next);
            }

            @Override // java.util.Iterator
            public void remove() {
                b.i.a.f.e.o.f.E(this.k != null);
                this.j.remove();
                AbstractMapBasedMultimap2.this.n -= this.k.size();
                this.k.clear();
                this.k = null;
            }
        }

        public a(Map<K, Collection<V>> map) {
            this.l = map;
        }

        public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
            Collection<V> value = entry.getValue();
            AbstractListMultimap abstractListMultimap = (AbstractListMultimap) abstractMapBasedMultimap2;
            Objects.requireNonNull(abstractListMultimap);
            List list = (List) value;
            return new ImmutableEntry(key, list instanceof RandomAccess ? new f(abstractListMultimap, key, list, null) : new j(key, list, null));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<K, Collection<V>> map = this.l;
            AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
            if (map == abstractMapBasedMultimap2.m) {
                abstractMapBasedMultimap2.d();
                return;
            }
            b bVar = new b();
            while (bVar.hasNext()) {
                bVar.next();
                bVar.remove();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<K, Collection<V>> map = this.l;
            Objects.requireNonNull(map);
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.l.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Collection<V> collection;
            Map<K, Collection<V>> map = this.l;
            Objects.requireNonNull(map);
            try {
                collection = map.get(obj);
            } catch (ClassCastException | NullPointerException unused) {
                collection = null;
            }
            Collection<V> collection2 = collection;
            if (collection2 == null) {
                return null;
            }
            AbstractListMultimap abstractListMultimap = (AbstractListMultimap) AbstractMapBasedMultimap2.this;
            Objects.requireNonNull(abstractListMultimap);
            List list = (List) collection2;
            return list instanceof RandomAccess ? new f(abstractListMultimap, obj, list, null) : new j(obj, list, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.l.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> hVar;
            AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
            Set<K> set = abstractMapBasedMultimap2.j;
            if (set == null) {
                Multimaps multimaps = (Multimaps) abstractMapBasedMultimap2;
                Map<K, Collection<V>> map = multimaps.m;
                if (map instanceof NavigableMap) {
                    hVar = new e((NavigableMap) multimaps.m);
                } else {
                    hVar = map instanceof SortedMap ? new h((SortedMap) multimaps.m) : new c(multimaps.m);
                }
                set = hVar;
                abstractMapBasedMultimap2.j = set;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            Collection<V> collectionRemove = this.l.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionE = AbstractMapBasedMultimap2.this.e();
            collectionE.addAll(collectionRemove);
            AbstractMapBasedMultimap2.this.n -= collectionRemove.size();
            collectionRemove.clear();
            return collectionE;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.l.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.l.toString();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$b */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public abstract class b<T> implements Iterator<T> {
        public final Iterator<Map.Entry<K, Collection<V>>> j;

        @NullableDecl
        public K k = null;

        @MonotonicNonNullDecl
        public Collection<V> l = null;
        public Iterator<V> m = Iterators2.INSTANCE;

        public b() {
            this.j = AbstractMapBasedMultimap2.this.m.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext() || this.m.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.m.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.j.next();
                this.k = next.getKey();
                Collection<V> value = next.getValue();
                this.l = value;
                this.m = value.iterator();
            }
            return this.m.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.m.remove();
            if (this.l.isEmpty()) {
                this.j.remove();
            }
            AbstractMapBasedMultimap2.c(AbstractMapBasedMultimap2.this);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$c */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class c extends Maps4<K, Collection<V>> {

        /* JADX INFO: renamed from: b.i.b.b.e$c$a */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class a implements Iterator<K> {

            @NullableDecl
            public Map.Entry<K, Collection<V>> j;
            public final /* synthetic */ Iterator k;

            public a(Iterator it) {
                this.k = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.k.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.k.next();
                this.j = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                b.i.a.f.e.o.f.E(this.j != null);
                Collection<V> value = this.j.getValue();
                this.k.remove();
                AbstractMapBasedMultimap2.this.n -= value.size();
                value.clear();
                this.j = null;
            }
        }

        public c(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterator<K> it = iterator();
            while (true) {
                a aVar = (a) it;
                if (!aVar.hasNext()) {
                    return;
                }
                aVar.next();
                aVar.remove();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.j.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.j.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.j.keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this.j.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) this.j.remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap2.this.n -= size;
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$d */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class d extends AbstractMapBasedMultimap2<K, V>.g implements NavigableMap<K, Collection<V>> {
        public d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.g
        public SortedSet b() {
            return new e(d());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = d().ceilingEntry(k);
            if (entryCeilingEntry == null) {
                return null;
            }
            return a(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return ((d) descendingMap()).navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new d(d().descendingMap());
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.g, b.i.b.b.AbstractMapBasedMultimap2.a, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> keySet() {
            SortedSet<K> sortedSetB = this.n;
            if (sortedSetB == null) {
                sortedSetB = b();
                this.n = sortedSetB;
            }
            return (NavigableSet) sortedSetB;
        }

        public Map.Entry<K, Collection<V>> f(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionE = AbstractMapBasedMultimap2.this.e();
            collectionE.addAll(next.getValue());
            it.remove();
            K key = next.getKey();
            Objects.requireNonNull((AbstractListMultimap) AbstractMapBasedMultimap2.this);
            return new ImmutableEntry(key, Collections.unmodifiableList((List) collectionE));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = d().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return a(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> entryFloorEntry = d().floorEntry(k);
            if (entryFloorEntry == null) {
                return null;
            }
            return a(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return d().floorKey(k);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.g
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> d() {
            return (NavigableMap) ((SortedMap) this.l);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> entryHigherEntry = d().higherEntry(k);
            if (entryHigherEntry == null) {
                return null;
            }
            return a(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = d().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return a(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> entryLowerEntry = d().lowerEntry(k);
            if (entryLowerEntry == null) {
                return null;
            }
            return a(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return d().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return c();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return f(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return f(((Maps) descendingMap()).entrySet().iterator());
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z2) {
            return new d(d().headMap(k, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z2, K k2, boolean z3) {
            return new d(d().subMap(k, z2, k2, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z2) {
            return new d(d().tailMap(k, z2));
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$e */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class e extends AbstractMapBasedMultimap2<K, V>.h implements NavigableSet<K> {
        public e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return c().ceilingKey(k);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.h
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> c() {
            return (NavigableMap) ((SortedMap) this.j);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return ((c) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new e(c().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return c().floorKey(k);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return c().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return c().lowerKey(k);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            c.a aVar = (c.a) iterator();
            if (!aVar.hasNext()) {
                return null;
            }
            K k = (K) aVar.next();
            aVar.remove();
            return k;
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            Iterator<K> itDescendingIterator = descendingIterator();
            if (!itDescendingIterator.hasNext()) {
                return null;
            }
            K next = itDescendingIterator.next();
            itDescendingIterator.remove();
            return next;
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z2) {
            return new e(c().headMap(k, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z2, K k2, boolean z3) {
            return new e(c().subMap(k, z2, k2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z2) {
            return new e(c().tailMap(k, z2));
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$f */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class f extends AbstractMapBasedMultimap2<K, V>.j implements RandomAccess {
        public f(@NullableDecl AbstractMapBasedMultimap2 abstractMapBasedMultimap2, K k, @NullableDecl List<V> list, AbstractMapBasedMultimap2<K, V>.i iVar) {
            super(k, list, iVar);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$g */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class g extends AbstractMapBasedMultimap2<K, V>.a implements SortedMap<K, Collection<V>> {

        @MonotonicNonNullDecl
        public SortedSet<K> n;

        public g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedSet<K> b() {
            return new h(d());
        }

        @Override // b.i.b.b.AbstractMapBasedMultimap2.a, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: c */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.n;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetB = b();
            this.n = sortedSetB;
            return sortedSetB;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        public SortedMap<K, Collection<V>> d() {
            return (SortedMap) this.l;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(d().headMap(k));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(d().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(d().tailMap(k));
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$h */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class h extends AbstractMapBasedMultimap2<K, V>.c implements SortedSet<K> {
        public h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        public SortedMap<K, Collection<V>> c() {
            return (SortedMap) this.j;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new h(c().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(c().tailMap(k));
        }
    }

    public AbstractMapBasedMultimap2(Map<K, Collection<V>> map) {
        b.i.a.f.e.o.f.v(map.isEmpty());
        this.m = map;
    }

    public static /* synthetic */ int b(AbstractMapBasedMultimap2 abstractMapBasedMultimap2) {
        int i2 = abstractMapBasedMultimap2.n;
        abstractMapBasedMultimap2.n = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(AbstractMapBasedMultimap2 abstractMapBasedMultimap2) {
        int i2 = abstractMapBasedMultimap2.n;
        abstractMapBasedMultimap2.n = i2 - 1;
        return i2;
    }

    public void d() {
        Iterator<Collection<V>> it = this.m.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.m.clear();
        this.n = 0;
    }

    public abstract Collection<V> e();

    /* JADX INFO: renamed from: b.i.b.b.e$j */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class j extends AbstractMapBasedMultimap2<K, V>.i implements List<V> {

        /* JADX INFO: renamed from: b.i.b.b.e$j$a */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class a extends AbstractMapBasedMultimap2<K, V>.i.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean zIsEmpty = j.this.isEmpty();
                b().add(v);
                AbstractMapBasedMultimap2.b(AbstractMapBasedMultimap2.this);
                if (zIsEmpty) {
                    j.this.c();
                }
            }

            public final ListIterator<V> b() {
                a();
                return (ListIterator) this.j;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return b().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return b().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return b().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return b().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                b().set(v);
            }

            public a(int i) {
                super(((List) j.this.k).listIterator(i));
            }
        }

        public j(K k, @NullableDecl List<V> list, AbstractMapBasedMultimap2<K, V>.i iVar) {
            super(k, list, iVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            d();
            boolean zIsEmpty = this.k.isEmpty();
            ((List) this.k).add(i, v);
            AbstractMapBasedMultimap2.b(AbstractMapBasedMultimap2.this);
            if (zIsEmpty) {
                c();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = ((List) this.k).addAll(i, collection);
            if (zAddAll) {
                int size2 = this.k.size();
                AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
                abstractMapBasedMultimap2.n = (size2 - size) + abstractMapBasedMultimap2.n;
                if (size == 0) {
                    c();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i) {
            d();
            return (V) ((List) this.k).get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            d();
            return ((List) this.k).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            d();
            return ((List) this.k).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            d();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            d();
            V v = (V) ((List) this.k).remove(i);
            AbstractMapBasedMultimap2.c(AbstractMapBasedMultimap2.this);
            e();
            return v;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            d();
            return (V) ((List) this.k).set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            d();
            AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
            K k = this.j;
            List listSubList = ((List) this.k).subList(i, i2);
            AbstractMapBasedMultimap2<K, V>.i iVar = this.l;
            if (iVar == null) {
                iVar = this;
            }
            Objects.requireNonNull(abstractMapBasedMultimap2);
            return listSubList instanceof RandomAccess ? new f(abstractMapBasedMultimap2, k, listSubList, iVar) : new j(k, listSubList, iVar);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            d();
            return new a(i);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$i */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class i extends AbstractCollection<V> {

        @NullableDecl
        public final K j;
        public Collection<V> k;

        @NullableDecl
        public final AbstractMapBasedMultimap2<K, V>.i l;

        @NullableDecl
        public final Collection<V> m;

        public i(K k, @NullableDecl Collection<V> collection, AbstractMapBasedMultimap2<K, V>.i iVar) {
            this.j = k;
            this.k = collection;
            this.l = iVar;
            this.m = iVar == null ? null : iVar.k;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            d();
            boolean zIsEmpty = this.k.isEmpty();
            boolean zAdd = this.k.add(v);
            if (zAdd) {
                AbstractMapBasedMultimap2.b(AbstractMapBasedMultimap2.this);
                if (zIsEmpty) {
                    c();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.k.addAll(collection);
            if (zAddAll) {
                int size2 = this.k.size();
                AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
                abstractMapBasedMultimap2.n = (size2 - size) + abstractMapBasedMultimap2.n;
                if (size == 0) {
                    c();
                }
            }
            return zAddAll;
        }

        public void c() {
            AbstractMapBasedMultimap2<K, V>.i iVar = this.l;
            if (iVar != null) {
                iVar.c();
            } else {
                AbstractMapBasedMultimap2.this.m.put(this.j, this.k);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.k.clear();
            AbstractMapBasedMultimap2.this.n -= size;
            e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            d();
            return this.k.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            d();
            return this.k.containsAll(collection);
        }

        public void d() {
            Collection<V> collection;
            AbstractMapBasedMultimap2<K, V>.i iVar = this.l;
            if (iVar != null) {
                iVar.d();
                if (this.l.k != this.m) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.k.isEmpty() || (collection = AbstractMapBasedMultimap2.this.m.get(this.j)) == null) {
                    return;
                }
                this.k = collection;
            }
        }

        public void e() {
            AbstractMapBasedMultimap2<K, V>.i iVar = this.l;
            if (iVar != null) {
                iVar.e();
            } else if (this.k.isEmpty()) {
                AbstractMapBasedMultimap2.this.m.remove(this.j);
            }
        }

        @Override // java.util.Collection
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            d();
            return this.k.equals(obj);
        }

        @Override // java.util.Collection
        public int hashCode() {
            d();
            return this.k.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            d();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            d();
            boolean zRemove = this.k.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap2.c(AbstractMapBasedMultimap2.this);
                e();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.k.removeAll(collection);
            if (zRemoveAll) {
                int size2 = this.k.size();
                AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
                abstractMapBasedMultimap2.n = (size2 - size) + abstractMapBasedMultimap2.n;
                e();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Objects.requireNonNull(collection);
            int size = size();
            boolean zRetainAll = this.k.retainAll(collection);
            if (zRetainAll) {
                int size2 = this.k.size();
                AbstractMapBasedMultimap2 abstractMapBasedMultimap2 = AbstractMapBasedMultimap2.this;
                abstractMapBasedMultimap2.n = (size2 - size) + abstractMapBasedMultimap2.n;
                e();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            d();
            return this.k.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            d();
            return this.k.toString();
        }

        /* JADX INFO: renamed from: b.i.b.b.e$i$a */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class a implements Iterator<V> {
            public final Iterator<V> j;
            public final Collection<V> k;

            public a() {
                Collection<V> collection = i.this.k;
                this.k = collection;
                this.j = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
            }

            public void a() {
                i.this.d();
                if (i.this.k != this.k) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.j.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                a();
                return this.j.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.j.remove();
                AbstractMapBasedMultimap2.c(AbstractMapBasedMultimap2.this);
                i.this.e();
            }

            public a(Iterator<V> it) {
                this.k = i.this.k;
                this.j = it;
            }
        }
    }
}
