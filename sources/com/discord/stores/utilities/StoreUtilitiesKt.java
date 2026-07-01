package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StoreUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUtilitiesKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> snapshotDirtyKeys(Map<K, ? extends V> map, Map<K, ? extends V> map2, Set<K> set, Function2<? super K, ? super V, ? extends V> function2) {
        m.checkNotNullParameter(map, "$this$snapshotDirtyKeys");
        m.checkNotNullParameter(map2, "snapshot");
        m.checkNotNullParameter(set, "dirtyKeys");
        m.checkNotNullParameter(function2, "snapshotDirtyValue");
        if (!(!set.isEmpty())) {
            return map2;
        }
        HashMap map3 = new HashMap(map.size());
        for (Map$Entry<K, ? extends V> map$Entry : map.entrySet()) {
            Object key = map$Entry.getKey();
            V value = map$Entry.getValue();
            if (set.contains(key)) {
                map3.put(key, function2.invoke(key, value));
            } else {
                Object obj = map2.get(key);
                if (obj != null) {
                    map3.put(key, obj);
                }
            }
        }
        return map3;
    }
}
