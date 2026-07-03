package p507d0.p580t.p581q0;

import java.util.Map;
import java.util.Map.Entry;
import p507d0.p580t.AbstractC12131f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.q0.a */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12154a<E extends Map.Entry<? extends K, ? extends V>, K, V> extends AbstractC12131f<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    public abstract boolean containsEntry(Map.Entry<? extends K, ? extends V> entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return remove((Map.Entry) obj);
        }
        return false;
    }

    public abstract /* bridge */ boolean remove(Map.Entry entry);

    public final boolean contains(E e) {
        C12238m.checkNotNullParameter(e, "element");
        return containsEntry(e);
    }
}
