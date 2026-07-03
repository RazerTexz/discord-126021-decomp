package p007b.p225i.p355b.p357b;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.b.b.o0 */
/* JADX INFO: compiled from: Sets.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4522o0<E> extends AbstractSet<E> {
    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        if (collection instanceof InterfaceC4502e0) {
            collection = ((InterfaceC4502e0) collection).m6235q();
        }
        if (!(collection instanceof Set) || collection.size() <= size()) {
            return C4507h.m6241d(this, collection.iterator());
        }
        Iterator<E> it = iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        Objects.requireNonNull(collection);
        return super.retainAll(collection);
    }
}
