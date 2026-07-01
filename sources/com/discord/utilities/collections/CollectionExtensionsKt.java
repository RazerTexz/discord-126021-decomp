package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.d0.f;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CollectionExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CollectionExtensionsKt {
    public static final <T> boolean equals(Collection<? extends T> collection, Collection<? extends T> collection2, Function2<? super T, ? super T, Boolean> function2) {
        m.checkNotNullParameter(collection, "$this$equals");
        m.checkNotNullParameter(collection2, "collection");
        m.checkNotNullParameter(function2, "comparator");
        if (collection.size() != collection2.size()) {
            return false;
        }
        int i = 0;
        for (Object obj : collection) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            if (!function2.invoke(obj, (Object) u.elementAt(collection2, i)).booleanValue()) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> filterNonNullValues(Map<K, ? extends V> map) {
        m.checkNotNullParameter(map, "$this$filterNonNullValues");
        HashMap map2 = new HashMap(map.size());
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            Object value = map$Entry.getValue();
            if (value != null) {
                map2.put(key, value);
            }
        }
        return map2;
    }

    public static final <K, V> HashMap<K, V> snapshot(Map<K, ? extends V> map, int i, float f) {
        m.checkNotNullParameter(map, "$this$snapshot");
        HashMap<K, V> map2 = new HashMap<>(i, f);
        map2.putAll(map);
        return map2;
    }

    public static /* synthetic */ HashMap snapshot$default(Map map, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = f.coerceAtLeast(map.size(), 1);
        }
        if ((i2 & 2) != 0) {
            f = 0.75f;
        }
        return snapshot(map, i, f);
    }
}
