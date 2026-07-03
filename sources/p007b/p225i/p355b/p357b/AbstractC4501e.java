package p007b.p225i.p355b.p357b;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.b.e */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4501e<K, V> extends AbstractC4505g<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* JADX INFO: renamed from: m */
    public transient Map<K, Collection<V>> f11973m;

    /* JADX INFO: renamed from: n */
    public transient int f11974n;

    /* JADX INFO: renamed from: b.i.b.b.e$a */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class a extends AbstractC4494a0<K, Collection<V>> {

        /* JADX INFO: renamed from: l */
        public final transient Map<K, Collection<V>> f11975l;

        /* JADX INFO: renamed from: b.i.b.b.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class C13230a extends AbstractC4535x<K, Collection<V>> {
            public C13230a() {
            }

            @Override // p007b.p225i.p355b.p357b.AbstractC4535x, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                Set<Map.Entry<K, Collection<V>>> setEntrySet = a.this.f11975l.entrySet();
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
                AbstractC4501e abstractC4501e = AbstractC4501e.this;
                Object key = ((Map.Entry) obj).getKey();
                Map<K, Collection<V>> map = abstractC4501e.f11973m;
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
                abstractC4501e.f11974n -= size;
                return true;
            }
        }

        /* JADX INFO: renamed from: b.i.b.b.e$a$b */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: j */
            public final Iterator<Map.Entry<K, Collection<V>>> f11978j;

            /* JADX INFO: renamed from: k */
            @NullableDecl
            public Collection<V> f11979k;

            public b() {
                this.f11978j = a.this.f11975l.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11978j.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry<K, Collection<V>> next = this.f11978j.next();
                this.f11979k = next.getValue();
                return a.this.m6221a(next);
            }

            @Override // java.util.Iterator
            public void remove() {
                C3404f.m4201E(this.f11979k != null);
                this.f11978j.remove();
                AbstractC4501e.this.f11974n -= this.f11979k.size();
                this.f11979k.clear();
                this.f11979k = null;
            }
        }

        public a(Map<K, Collection<V>> map) {
            this.f11975l = map;
        }

        /* JADX INFO: renamed from: a */
        public Map.Entry<K, Collection<V>> m6221a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            AbstractC4501e abstractC4501e = AbstractC4501e.this;
            Collection<V> value = entry.getValue();
            AbstractC4497c abstractC4497c = (AbstractC4497c) abstractC4501e;
            Objects.requireNonNull(abstractC4497c);
            List list = (List) value;
            return new C4521o(key, list instanceof RandomAccess ? new f(abstractC4497c, key, list, null) : new j(key, list, null));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<K, Collection<V>> map = this.f11975l;
            AbstractC4501e abstractC4501e = AbstractC4501e.this;
            if (map == abstractC4501e.f11973m) {
                abstractC4501e.m6220d();
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
            Map<K, Collection<V>> map = this.f11975l;
            Objects.requireNonNull(map);
            try {
                return map.containsKey(obj);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.f11975l.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Collection<V> collection;
            Map<K, Collection<V>> map = this.f11975l;
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
            AbstractC4497c abstractC4497c = (AbstractC4497c) AbstractC4501e.this;
            Objects.requireNonNull(abstractC4497c);
            List list = (List) collection2;
            return list instanceof RandomAccess ? new f(abstractC4497c, obj, list, null) : new j(obj, list, null);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f11975l.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> hVar;
            AbstractC4501e abstractC4501e = AbstractC4501e.this;
            Set<K> set = abstractC4501e.f12006j;
            if (set == null) {
                C4500d0 c4500d0 = (C4500d0) abstractC4501e;
                Map<K, Collection<V>> map = c4500d0.f11973m;
                if (map instanceof NavigableMap) {
                    hVar = new e((NavigableMap) c4500d0.f11973m);
                } else {
                    hVar = map instanceof SortedMap ? new h((SortedMap) c4500d0.f11973m) : new c(c4500d0.f11973m);
                }
                set = hVar;
                abstractC4501e.f12006j = set;
            }
            return set;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            Collection<V> collectionRemove = this.f11975l.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionMo6217e = AbstractC4501e.this.mo6217e();
            collectionMo6217e.addAll(collectionRemove);
            AbstractC4501e.this.f11974n -= collectionRemove.size();
            collectionRemove.clear();
            return collectionMo6217e;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f11975l.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f11975l.toString();
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$b */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public abstract class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: j */
        public final Iterator<Map.Entry<K, Collection<V>>> f11981j;

        /* JADX INFO: renamed from: k */
        @NullableDecl
        public K f11982k = null;

        /* JADX INFO: renamed from: l */
        @MonotonicNonNullDecl
        public Collection<V> f11983l = null;

        /* JADX INFO: renamed from: m */
        public Iterator<V> f11984m = EnumC4531t.INSTANCE;

        public b() {
            this.f11981j = AbstractC4501e.this.f11973m.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11981j.hasNext() || this.f11984m.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f11984m.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f11981j.next();
                this.f11982k = next.getKey();
                Collection<V> value = next.getValue();
                this.f11983l = value;
                this.f11984m = value.iterator();
            }
            return this.f11984m.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f11984m.remove();
            if (this.f11983l.isEmpty()) {
                this.f11981j.remove();
            }
            AbstractC4501e.m6219c(AbstractC4501e.this);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$c */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class c extends C4536y<K, Collection<V>> {

        /* JADX INFO: renamed from: b.i.b.b.e$c$a */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class a implements Iterator<K> {

            /* JADX INFO: renamed from: j */
            @NullableDecl
            public Map.Entry<K, Collection<V>> f11987j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ Iterator f11988k;

            public a(Iterator it) {
                this.f11988k = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11988k.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f11988k.next();
                this.f11987j = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                C3404f.m4201E(this.f11987j != null);
                Collection<V> value = this.f11987j.getValue();
                this.f11988k.remove();
                AbstractC4501e.this.f11974n -= value.size();
                value.clear();
                this.f11987j = null;
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
            return this.f12111j.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.f12111j.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f12111j.keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(this.f12111j.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) this.f12111j.remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractC4501e.this.f11974n -= size;
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$d */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class d extends AbstractC4501e<K, V>.g implements NavigableMap<K, Collection<V>> {
        public d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.g
        /* JADX INFO: renamed from: b */
        public SortedSet mo6222b() {
            return new e(mo6224d());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry<K, Collection<V>> entryCeilingEntry = mo6224d().ceilingEntry(k);
            if (entryCeilingEntry == null) {
                return null;
            }
            return m6221a(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k) {
            return mo6224d().ceilingKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return ((d) descendingMap()).navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new d(mo6224d().descendingMap());
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.g, p007b.p225i.p355b.p357b.AbstractC4501e.a, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public NavigableSet<K> keySet() {
            SortedSet<K> sortedSetMo6222b = this.f11992n;
            if (sortedSetMo6222b == null) {
                sortedSetMo6222b = mo6222b();
                this.f11992n = sortedSetMo6222b;
            }
            return (NavigableSet) sortedSetMo6222b;
        }

        /* JADX INFO: renamed from: f */
        public Map.Entry<K, Collection<V>> m6226f(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> collectionMo6217e = AbstractC4501e.this.mo6217e();
            collectionMo6217e.addAll(next.getValue());
            it.remove();
            K key = next.getKey();
            Objects.requireNonNull((AbstractC4497c) AbstractC4501e.this);
            return new C4521o(key, Collections.unmodifiableList((List) collectionMo6217e));
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> entryFirstEntry = mo6224d().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return m6221a(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry<K, Collection<V>> entryFloorEntry = mo6224d().floorEntry(k);
            if (entryFloorEntry == null) {
                return null;
            }
            return m6221a(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k) {
            return mo6224d().floorKey(k);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.g
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> mo6224d() {
            return (NavigableMap) ((SortedMap) this.f11975l);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry<K, Collection<V>> entryHigherEntry = mo6224d().higherEntry(k);
            if (entryHigherEntry == null) {
                return null;
            }
            return m6221a(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k) {
            return mo6224d().higherKey(k);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> entryLastEntry = mo6224d().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return m6221a(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry<K, Collection<V>> entryLowerEntry = mo6224d().lowerEntry(k);
            if (entryLowerEntry == null) {
                return null;
            }
            return m6221a(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k) {
            return mo6224d().lowerKey(k);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return mo6223c();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m6226f(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m6226f(((AbstractC4494a0) descendingMap()).entrySet().iterator());
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.g, java.util.SortedMap, java.util.NavigableMap
        public SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k, boolean z2) {
            return new d(mo6224d().headMap(k, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k, boolean z2, K k2, boolean z3) {
            return new d(mo6224d().subMap(k, z2, k2, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z2) {
            return new d(mo6224d().tailMap(k, z2));
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$e */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class e extends AbstractC4501e<K, V>.h implements NavigableSet<K> {
        public e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k) {
            return mo6228c().ceilingKey(k);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.h
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public NavigableMap<K, Collection<V>> mo6228c() {
            return (NavigableMap) ((SortedMap) this.f12111j);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return ((c) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new e(mo6228c().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k) {
            return mo6228c().floorKey(k);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public K higher(K k) {
            return mo6228c().higherKey(k);
        }

        @Override // java.util.NavigableSet
        public K lower(K k) {
            return mo6228c().lowerKey(k);
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

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.h, java.util.SortedSet, java.util.NavigableSet
        public SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k, boolean z2) {
            return new e(mo6228c().headMap(k, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k, boolean z2, K k2, boolean z3) {
            return new e(mo6228c().subMap(k, z2, k2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k, boolean z2) {
            return new e(mo6228c().tailMap(k, z2));
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$f */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class f extends AbstractC4501e<K, V>.j implements RandomAccess {
        public f(@NullableDecl AbstractC4501e abstractC4501e, K k, @NullableDecl List<V> list, AbstractC4501e<K, V>.i iVar) {
            super(k, list, iVar);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$g */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class g extends AbstractC4501e<K, V>.a implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: n */
        @MonotonicNonNullDecl
        public SortedSet<K> f11992n;

        public g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* JADX INFO: renamed from: b */
        public SortedSet<K> mo6222b() {
            return new h(mo6224d());
        }

        @Override // p007b.p225i.p355b.p357b.AbstractC4501e.a, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: c */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f11992n;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetMo6222b = mo6222b();
            this.f11992n = sortedSetMo6222b;
            return sortedSetMo6222b;
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return mo6224d().comparator();
        }

        /* JADX INFO: renamed from: d */
        public SortedMap<K, Collection<V>> mo6224d() {
            return (SortedMap) this.f11975l;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return mo6224d().firstKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(mo6224d().headMap(k));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return mo6224d().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(mo6224d().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(mo6224d().tailMap(k));
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$h */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class h extends AbstractC4501e<K, V>.c implements SortedSet<K> {
        public h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* JADX INFO: renamed from: c */
        public SortedMap<K, Collection<V>> mo6228c() {
            return (SortedMap) this.f12111j;
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return mo6228c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return mo6228c().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new h(mo6228c().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return mo6228c().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(mo6228c().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(mo6228c().tailMap(k));
        }
    }

    public AbstractC4501e(Map<K, Collection<V>> map) {
        C3404f.m4351v(map.isEmpty());
        this.f11973m = map;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ int m6218b(AbstractC4501e abstractC4501e) {
        int i2 = abstractC4501e.f11974n;
        abstractC4501e.f11974n = i2 + 1;
        return i2;
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ int m6219c(AbstractC4501e abstractC4501e) {
        int i2 = abstractC4501e.f11974n;
        abstractC4501e.f11974n = i2 - 1;
        return i2;
    }

    /* JADX INFO: renamed from: d */
    public void m6220d() {
        Iterator<Collection<V>> it = this.f11973m.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.f11973m.clear();
        this.f11974n = 0;
    }

    /* JADX INFO: renamed from: e */
    public abstract Collection<V> mo6217e();

    /* JADX INFO: renamed from: b.i.b.b.e$j */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class j extends AbstractC4501e<K, V>.i implements List<V> {

        /* JADX INFO: renamed from: b.i.b.b.e$j$a */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class a extends AbstractC4501e<K, V>.i.a implements ListIterator<V> {
            public a() {
                super();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean zIsEmpty = j.this.isEmpty();
                m6234b().add(v);
                AbstractC4501e.m6218b(AbstractC4501e.this);
                if (zIsEmpty) {
                    j.this.m6230c();
                }
            }

            /* JADX INFO: renamed from: b */
            public final ListIterator<V> m6234b() {
                m6233a();
                return (ListIterator) this.f12000j;
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return m6234b().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return m6234b().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return m6234b().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return m6234b().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                m6234b().set(v);
            }

            public a(int i) {
                super(((List) j.this.f11996k).listIterator(i));
            }
        }

        public j(K k, @NullableDecl List<V> list, AbstractC4501e<K, V>.i iVar) {
            super(k, list, iVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            m6231d();
            boolean zIsEmpty = this.f11996k.isEmpty();
            ((List) this.f11996k).add(i, v);
            AbstractC4501e.m6218b(AbstractC4501e.this);
            if (zIsEmpty) {
                m6230c();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = ((List) this.f11996k).addAll(i, collection);
            if (zAddAll) {
                int size2 = this.f11996k.size();
                AbstractC4501e abstractC4501e = AbstractC4501e.this;
                abstractC4501e.f11974n = (size2 - size) + abstractC4501e.f11974n;
                if (size == 0) {
                    m6230c();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i) {
            m6231d();
            return (V) ((List) this.f11996k).get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            m6231d();
            return ((List) this.f11996k).indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            m6231d();
            return ((List) this.f11996k).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            m6231d();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            m6231d();
            V v = (V) ((List) this.f11996k).remove(i);
            AbstractC4501e.m6219c(AbstractC4501e.this);
            m6232e();
            return v;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            m6231d();
            return (V) ((List) this.f11996k).set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            m6231d();
            AbstractC4501e abstractC4501e = AbstractC4501e.this;
            K k = this.f11995j;
            List listSubList = ((List) this.f11996k).subList(i, i2);
            AbstractC4501e<K, V>.i iVar = this.f11997l;
            if (iVar == null) {
                iVar = this;
            }
            Objects.requireNonNull(abstractC4501e);
            return listSubList instanceof RandomAccess ? new f(abstractC4501e, k, listSubList, iVar) : new j(k, listSubList, iVar);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            m6231d();
            return new a(i);
        }
    }

    /* JADX INFO: renamed from: b.i.b.b.e$i */
    /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
    public class i extends AbstractCollection<V> {

        /* JADX INFO: renamed from: j */
        @NullableDecl
        public final K f11995j;

        /* JADX INFO: renamed from: k */
        public Collection<V> f11996k;

        /* JADX INFO: renamed from: l */
        @NullableDecl
        public final AbstractC4501e<K, V>.i f11997l;

        /* JADX INFO: renamed from: m */
        @NullableDecl
        public final Collection<V> f11998m;

        public i(K k, @NullableDecl Collection<V> collection, AbstractC4501e<K, V>.i iVar) {
            this.f11995j = k;
            this.f11996k = collection;
            this.f11997l = iVar;
            this.f11998m = iVar == null ? null : iVar.f11996k;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            m6231d();
            boolean zIsEmpty = this.f11996k.isEmpty();
            boolean zAdd = this.f11996k.add(v);
            if (zAdd) {
                AbstractC4501e.m6218b(AbstractC4501e.this);
                if (zIsEmpty) {
                    m6230c();
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
            boolean zAddAll = this.f11996k.addAll(collection);
            if (zAddAll) {
                int size2 = this.f11996k.size();
                AbstractC4501e abstractC4501e = AbstractC4501e.this;
                abstractC4501e.f11974n = (size2 - size) + abstractC4501e.f11974n;
                if (size == 0) {
                    m6230c();
                }
            }
            return zAddAll;
        }

        /* JADX INFO: renamed from: c */
        public void m6230c() {
            AbstractC4501e<K, V>.i iVar = this.f11997l;
            if (iVar != null) {
                iVar.m6230c();
            } else {
                AbstractC4501e.this.f11973m.put(this.f11995j, this.f11996k);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f11996k.clear();
            AbstractC4501e.this.f11974n -= size;
            m6232e();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            m6231d();
            return this.f11996k.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            m6231d();
            return this.f11996k.containsAll(collection);
        }

        /* JADX INFO: renamed from: d */
        public void m6231d() {
            Collection<V> collection;
            AbstractC4501e<K, V>.i iVar = this.f11997l;
            if (iVar != null) {
                iVar.m6231d();
                if (this.f11997l.f11996k != this.f11998m) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f11996k.isEmpty() || (collection = AbstractC4501e.this.f11973m.get(this.f11995j)) == null) {
                    return;
                }
                this.f11996k = collection;
            }
        }

        /* JADX INFO: renamed from: e */
        public void m6232e() {
            AbstractC4501e<K, V>.i iVar = this.f11997l;
            if (iVar != null) {
                iVar.m6232e();
            } else if (this.f11996k.isEmpty()) {
                AbstractC4501e.this.f11973m.remove(this.f11995j);
            }
        }

        @Override // java.util.Collection
        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            m6231d();
            return this.f11996k.equals(obj);
        }

        @Override // java.util.Collection
        public int hashCode() {
            m6231d();
            return this.f11996k.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            m6231d();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            m6231d();
            boolean zRemove = this.f11996k.remove(obj);
            if (zRemove) {
                AbstractC4501e.m6219c(AbstractC4501e.this);
                m6232e();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f11996k.removeAll(collection);
            if (zRemoveAll) {
                int size2 = this.f11996k.size();
                AbstractC4501e abstractC4501e = AbstractC4501e.this;
                abstractC4501e.f11974n = (size2 - size) + abstractC4501e.f11974n;
                m6232e();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Objects.requireNonNull(collection);
            int size = size();
            boolean zRetainAll = this.f11996k.retainAll(collection);
            if (zRetainAll) {
                int size2 = this.f11996k.size();
                AbstractC4501e abstractC4501e = AbstractC4501e.this;
                abstractC4501e.f11974n = (size2 - size) + abstractC4501e.f11974n;
                m6232e();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            m6231d();
            return this.f11996k.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            m6231d();
            return this.f11996k.toString();
        }

        /* JADX INFO: renamed from: b.i.b.b.e$i$a */
        /* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
        public class a implements Iterator<V> {

            /* JADX INFO: renamed from: j */
            public final Iterator<V> f12000j;

            /* JADX INFO: renamed from: k */
            public final Collection<V> f12001k;

            public a() {
                Collection<V> collection = i.this.f11996k;
                this.f12001k = collection;
                this.f12000j = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
            }

            /* JADX INFO: renamed from: a */
            public void m6233a() {
                i.this.m6231d();
                if (i.this.f11996k != this.f12001k) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                m6233a();
                return this.f12000j.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                m6233a();
                return this.f12000j.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f12000j.remove();
                AbstractC4501e.m6219c(AbstractC4501e.this);
                i.this.m6232e();
            }

            public a(Iterator<V> it) {
                this.f12001k = i.this.f11996k;
                this.f12000j = it;
            }
        }
    }
}
