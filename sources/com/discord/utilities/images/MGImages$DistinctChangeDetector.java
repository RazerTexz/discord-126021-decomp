package com.discord.utilities.images;

import d0.z.d.m;
import java.util.HashMap;

/* JADX INFO: compiled from: MGImages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImages$DistinctChangeDetector implements MGImages$ChangeDetector {
    private final HashMap<Object, Object> dataMap = new HashMap<>();

    @Override // com.discord.utilities.images.MGImages$ChangeDetector
    public boolean track(Object key, Object value) {
        m.checkNotNullParameter(key, "key");
        if (this.dataMap.containsKey(key) && m.areEqual(this.dataMap.get(key), value)) {
            return false;
        }
        this.dataMap.put(key, value);
        return true;
    }
}
