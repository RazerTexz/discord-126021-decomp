package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.collections.ShallowPartitionMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p507d0.p512d0.C11226f;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMap<V> extends ShallowPartitionMap<Long, V> {
    private static final int PARTITION_SIZE = 256;
    private static final Function1<Long, Integer> PARTITION_SNOWFLAKE_ID_STRATEGY = C6733x74f7fa2a.INSTANCE;

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
        C12238m.checkNotNullParameter(list, "partitions");
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
        IntRange intRangeUntil = C11226f.until(0, i);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            ((AbstractC12126c0) it).nextInt();
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
