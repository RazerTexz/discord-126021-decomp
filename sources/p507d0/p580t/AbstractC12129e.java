package p507d0.p580t;

import java.util.AbstractList;
import java.util.List;
import p507d0.p592z.p594d.p595g0.InterfaceC12230c;

/* JADX INFO: renamed from: d0.t.e */
/* JADX INFO: compiled from: AbstractMutableList.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12129e<E> extends AbstractList<E> implements List<E>, InterfaceC12230c {
    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i) {
        return removeAt(i);
    }

    public abstract E removeAt(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
