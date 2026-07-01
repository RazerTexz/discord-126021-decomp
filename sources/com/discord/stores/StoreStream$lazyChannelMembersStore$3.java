package com.discord.stores;

import com.discord.models.presence.Presence;
import com.discord.utilities.collections.SnowflakePartitionMap;
import d0.z.d.FunctionReferenceImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$3 extends FunctionReferenceImpl implements Function1<Long, Presence> {
    public StoreStream$lazyChannelMembersStore$3(SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap) {
        super(1, copiablePartitionMap, SnowflakePartitionMap.CopiablePartitionMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Presence invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Presence invoke(long j) {
        return (Presence) ((SnowflakePartitionMap.CopiablePartitionMap) this.receiver).get(Long.valueOf(j));
    }
}
