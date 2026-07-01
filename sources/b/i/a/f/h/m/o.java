package b.i.a.f.h.m;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class o<K, V> {
    public final Map<K, WeakReference<V>> a = new WeakHashMap();

    public final boolean a(K k) {
        return b(k) != null;
    }

    public final V b(K k) {
        WeakReference<V> weakReference = this.a.get(k);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
