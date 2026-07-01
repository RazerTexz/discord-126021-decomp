package b.i.b.b;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: Sets.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a<E> extends p0<E> {
    public final /* synthetic */ Set j;
    public final /* synthetic */ Set k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a(Set set, Set set2) {
        super(null);
        this.j = set;
        this.k = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.j.contains(obj) && this.k.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return this.j.containsAll(collection) && this.k.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return Collections.disjoint(this.k, this.j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new n0(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Iterator<E> it = this.j.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.k.contains(it.next())) {
                i++;
            }
        }
        return i;
    }
}
