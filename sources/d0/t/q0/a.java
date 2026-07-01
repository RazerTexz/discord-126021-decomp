package d0.t.q0;

import d0.z.d.m;
import java.util.Map$Entry;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<E extends Map$Entry<? extends K, ? extends V>, K, V> extends d0.t.f<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map$Entry) {
            return contains((Map$Entry) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map$Entry<? extends K, ? extends V> map$Entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map$Entry) {
            return remove((Map$Entry) obj);
        }
        return false;
    }

    public abstract /* bridge */ boolean remove(Map$Entry map$Entry);

    public final boolean contains(E e) {
        m.checkNotNullParameter(e, "element");
        return containsEntry(e);
    }
}
