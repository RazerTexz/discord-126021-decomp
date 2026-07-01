package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.collections.SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1, reason: use source file name */
/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SnowflakePartitionMap2 extends Lambda implements Function1<Long, Integer> {
    public static final SnowflakePartitionMap2 INSTANCE = new SnowflakePartitionMap2();

    public SnowflakePartitionMap2() {
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
