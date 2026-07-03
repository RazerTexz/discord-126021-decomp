package p507d0.p580t;

import java.util.AbstractSet;
import java.util.Set;
import p507d0.p592z.p594d.p595g0.InterfaceC12232e;

/* JADX INFO: renamed from: d0.t.f */
/* JADX INFO: compiled from: AbstractMutableSet.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12131f<E> extends AbstractSet<E> implements Set<E>, InterfaceC12232e {
    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
