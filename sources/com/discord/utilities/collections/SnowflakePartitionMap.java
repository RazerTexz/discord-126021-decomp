package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.d0.f;
import d0.t.c0;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMap<V> extends ShallowPartitionMap<Long, V> {
    private static final int PARTITION_SIZE = 256;
    public static final SnowflakePartitionMap$Companion Companion = new SnowflakePartitionMap$Companion(null);
    private static final Function1<Long, Integer> PARTITION_SNOWFLAKE_ID_STRATEGY = SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1.INSTANCE;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnowflakePartitionMap(List<? extends Map<Long, V>> list) {
        super(list, PARTITION_SNOWFLAKE_ID_STRATEGY);
        m.checkNotNullParameter(list, "partitions");
    }

    public static final /* synthetic */ Function1 access$getPARTITION_SNOWFLAKE_ID_STRATEGY$cp() {
        return PARTITION_SNOWFLAKE_ID_STRATEGY;
    }

    public /* bridge */ boolean containsKey(long j) {
        return super.containsKey(Long.valueOf(j));
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

    public SnowflakePartitionMap(int i) {
        IntRange intRangeUntil = f.until(0, i);
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((c0) it).nextInt();
            arrayList.add(new HashMap());
        }
        this(arrayList);
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
