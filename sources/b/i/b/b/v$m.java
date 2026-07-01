package b.i.b.b;

import java.util.AbstractSet;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v$m<E> extends AbstractSet<E> {
    public v$m(v$a v_a) {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return v.a(this).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) v.a(this).toArray(tArr);
    }
}
