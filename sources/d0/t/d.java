package d0.t;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: compiled from: AbstractMutableCollection.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<E> extends AbstractCollection<E> implements Collection<E>, d0.z.d.g0.b {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
