package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: StoreMessageReplies.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessageReplies$MessageCache<K, V> extends LinkedHashMap<K, V> {
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map$Entry<K, V>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map$Entry<K, V> eldest) {
        return size() > 1000;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
