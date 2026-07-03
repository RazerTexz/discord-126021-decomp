package com.discord.utilities.collections;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.utilities.collections.SnowflakePartitionMap$Companion$PARTITION_SNOWFLAKE_ID_STRATEGY$1 */
/* JADX INFO: compiled from: SnowflakePartitionMap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6733x74f7fa2a extends AbstractC12240o implements Function1<Long, Integer> {
    public static final C6733x74f7fa2a INSTANCE = new C6733x74f7fa2a();

    public C6733x74f7fa2a() {
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
