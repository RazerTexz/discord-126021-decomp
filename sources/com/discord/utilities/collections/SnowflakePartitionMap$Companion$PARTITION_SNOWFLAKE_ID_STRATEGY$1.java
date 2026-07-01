package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1 extends o implements Function1<Long, Integer> {
    public static final SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1 INSTANCE = new SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1();

    public SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Long l) {
        return Integer.valueOf(invoke(l.longValue()));
    }

    public final int invoke(long j) {
        return (int) ((j >>> 22) % ((long) 256));
    }
}
