package b.i.b.b;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: AbstractMultimap.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a<V> extends AbstractCollection<V> {
    public final /* synthetic */ g j;

    public g$a(g gVar) {
        this.j = gVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ((e) this.j).d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        Iterator<V> it = this.j.a().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        e eVar = (e) this.j;
        Objects.requireNonNull(eVar);
        return new d(eVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return ((e) this.j).n;
    }
}
