package p507d0.p580t;

import java.util.AbstractCollection;
import java.util.Collection;
import p507d0.p592z.p594d.p595g0.InterfaceC12229b;

/* JADX INFO: renamed from: d0.t.d */
/* JADX INFO: compiled from: AbstractMutableCollection.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12127d<E> extends AbstractCollection<E> implements Collection<E>, InterfaceC12229b {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
