package b.i.b.b;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$i<V> extends AbstractCollection<V> {

    @NullableDecl
    public final K j;
    public Collection<V> k;

    /* JADX WARN: Incorrect inner types in field signature: Lb/i/b/b/e<TK;TV;>.i; */
    @NullableDecl
    public final e$i l;

    @NullableDecl
    public final Collection<V> m;
    public final /* synthetic */ e n;

    /* JADX WARN: Incorrect inner types in method signature: (TK;Ljava/util/Collection<TV;>;Lb/i/b/b/e<TK;TV;>.i;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public e$i(@NullableDecl e eVar, Object obj, @NullableDecl Collection collection, e$i e_i) {
        this.n = eVar;
        this.j = obj;
        this.k = collection;
        this.l = e_i;
        this.m = e_i == null ? null : e_i.k;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        d();
        boolean zIsEmpty = this.k.isEmpty();
        boolean zAdd = this.k.add(v);
        if (zAdd) {
            e.b(this.n);
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
            e eVar = this.n;
            eVar.n = (size2 - size) + eVar.n;
            if (size == 0) {
                c();
            }
        }
        return zAddAll;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void c() {
        e$i e_i = this.l;
        if (e_i != null) {
            e_i.c();
            return;
        }
        this.n.m.put(this.j, this.k);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.k.clear();
        this.n.n -= size;
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
        e$i e_i = this.l;
        if (e_i != null) {
            e_i.d();
            if (this.l.k != this.m) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.k.isEmpty() || (collection = this.n.m.get(this.j)) == null) {
                return;
            }
            this.k = collection;
        }
    }

    public void e() {
        e$i e_i = this.l;
        if (e_i != null) {
            e_i.e();
        } else if (this.k.isEmpty()) {
            this.n.m.remove(this.j);
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
        return new e$i$a(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        d();
        boolean zRemove = this.k.remove(obj);
        if (zRemove) {
            e.c(this.n);
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
            e eVar = this.n;
            eVar.n = (size2 - size) + eVar.n;
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
            e eVar = this.n;
            eVar.n = (size2 - size) + eVar.n;
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
}
