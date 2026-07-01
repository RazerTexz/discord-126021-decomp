package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.collections.ShallowPartitionMap;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Iterators4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Ranges2;

/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMap<V> extends ShallowPartitionMap<Long, V> {
    private static final int PARTITION_SIZE = 256;
    private static final Function1<Long, Integer> PARTITION_SNOWFLAKE_ID_STRATEGY = SnowflakePartitionMap2.INSTANCE;

    /* JADX INFO: compiled from: SnowflakePartitionMap.kt */
    public static final class CopiablePartitionMap<V> extends ShallowPartitionMap.CopiablePartitionMap<Long, V> {
        public CopiablePartitionMap() {
            this(0, 1, null);
        }

        public /* synthetic */ CopiablePartitionMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 256 : i);
        }

        public /* bridge */ boolean containsKey(long j) {
            return super.containsKey(Long.valueOf(j));
        }

        @Override // com.discord.utilities.collections.ShallowPartitionMap.CopiablePartitionMap
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

        public CopiablePartitionMap(int i) {
            super(i, SnowflakePartitionMap.PARTITION_SNOWFLAKE_ID_STRATEGY);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SnowflakePartitionMap(List<? extends Map<Long, V>> list) {
        super(list, PARTITION_SNOWFLAKE_ID_STRATEGY);
        Intrinsics3.checkNotNullParameter(list, "partitions");
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
        Ranges2 ranges2Until = _Ranges.until(0, i);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(ranges2Until, 10));
        Iterator<Integer> it = ranges2Until.iterator();
        while (it.hasNext()) {
            ((Iterators4) it).nextInt();
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
