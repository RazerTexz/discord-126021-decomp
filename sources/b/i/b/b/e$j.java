package b.i.b.b;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$j<V> extends e<K, V>.e$i implements List<V> {
    public final /* synthetic */ e o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect inner types in method signature: (TK;Ljava/util/List<TV;>;Lb/i/b/b/e<TK;TV;>.i;)V */
    public e$j(@NullableDecl e eVar, Object obj, @NullableDecl List list, e$i e_i) {
        super(eVar, obj, list, e_i);
        this.o = eVar;
    }

    @Override // java.util.List
    public void add(int i, V v) {
        d();
        boolean zIsEmpty = this.k.isEmpty();
        ((List) this.k).add(i, v);
        e.b(this.o);
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
            e eVar = this.o;
            eVar.n = (size2 - size) + eVar.n;
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
        return new e$j$a(this);
    }

    @Override // java.util.List
    public V remove(int i) {
        d();
        V v = (V) ((List) this.k).remove(i);
        e.c(this.o);
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
        e eVar = this.o;
        K k = this.j;
        List listSubList = ((List) this.k).subList(i, i2);
        e$i e_i = this.l;
        if (e_i == null) {
            e_i = this;
        }
        Objects.requireNonNull(eVar);
        return listSubList instanceof RandomAccess ? new e$f(eVar, k, listSubList, e_i) : new e$j(eVar, k, listSubList, e_i);
    }

    @Override // java.util.List
    public ListIterator<V> listIterator(int i) {
        d();
        return new e$j$a(this, i);
    }
}
