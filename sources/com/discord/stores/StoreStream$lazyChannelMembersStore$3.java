package com.discord.stores;

import com.discord.models.presence.Presence;
import com.discord.utilities.collections.SnowflakePartitionMap$CopiablePartitionMap;
import d0.z.d.k;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$3 extends k implements Function1<Long, Presence> {
    public StoreStream$lazyChannelMembersStore$3(SnowflakePartitionMap$CopiablePartitionMap snowflakePartitionMap$CopiablePartitionMap) {
        super(1, snowflakePartitionMap$CopiablePartitionMap, SnowflakePartitionMap$CopiablePartitionMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Presence invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Presence invoke(long j) {
        return (Presence) ((SnowflakePartitionMap$CopiablePartitionMap) this.receiver).get(Long.valueOf(j));
    }
}
