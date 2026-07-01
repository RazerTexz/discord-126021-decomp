package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMap$CopiablePartitionMap<V> extends ShallowPartitionMap$CopiablePartitionMap<Long, V> {
    public SnowflakePartitionMap$CopiablePartitionMap() {
        this(0, 1, null);
    }

    public /* synthetic */ SnowflakePartitionMap$CopiablePartitionMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 256 : i);
    }

    public /* bridge */ boolean containsKey(long j) {
        return super.containsKey(Long.valueOf(j));
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap$CopiablePartitionMap
    public Map<Long, V> fastCopy() {
        setDefensiveCopyPartitions(defensiveCopy(getDefensiveCopyPartitions()));
        return new SnowflakePartitionMap(getDefensiveCopyPartitions());
    }

    public /* bridge */ Object get(long j) {
        return super.get(Long.valueOf(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ Object getOrDefault(long j, Object obj) {
        return super.getOrDefault(Long.valueOf(j), obj);
    }

    public /* bridge */ Object remove(long j) {
        return super.remove(Long.valueOf(j));
    }

    public SnowflakePartitionMap$CopiablePartitionMap(int i) {
        super(i, SnowflakePartitionMap.access$getPARTITION_SNOWFLAKE_ID_STRATEGY$cp());
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof Long) {
            return containsKey(((Number) obj).longValue());
        }
        return false;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public final /* bridge */ V get(Object obj) {
        if (obj instanceof Long) {
            return (V) get(((Number) obj).longValue());
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return obj instanceof Long ? getOrDefault(((Number) obj).longValue(), obj2) : obj2;
    }

    @Override // com.discord.utilities.collections.ShallowPartitionMap, java.util.Map
    public final /* bridge */ V remove(Object obj) {
        if (obj instanceof Long) {
            return (V) remove(((Number) obj).longValue());
        }
        return null;
    }

    public /* bridge */ boolean remove(long j, Object obj) {
        return super.remove(Long.valueOf(j), obj);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (obj instanceof Long) {
            return remove(((Number) obj).longValue(), obj2);
        }
        return false;
    }
}
