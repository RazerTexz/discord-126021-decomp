package d0.t;

import d0.z.d.g0.KMarkers2;
import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: renamed from: d0.t.d, reason: use source file name */
/* JADX INFO: compiled from: AbstractMutableCollection.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractMutableCollection<E> extends AbstractCollection<E> implements Collection<E>, KMarkers2 {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
