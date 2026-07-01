package b.i.b.b;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class e$j$a<V> extends e<K, V>.e$i.e$i$a implements ListIterator<V> {
    public final /* synthetic */ e$j m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$j$a(e$j e_j) {
        super(e_j);
        this.m = e_j;
    }

    @Override // java.util.ListIterator
    public void add(V v) {
        boolean zIsEmpty = this.m.isEmpty();
        b().add(v);
        e.b(this.m.o);
        if (zIsEmpty) {
            this.m.c();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$j$a(e$j e_j, int i) {
        super(e_j, ((List) e_j.k).listIterator(i));
        this.m = e_j;
    }
}
