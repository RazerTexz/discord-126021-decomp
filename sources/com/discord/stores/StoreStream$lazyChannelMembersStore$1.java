package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.FunctionReferenceImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$lazyChannelMembersStore$1 extends FunctionReferenceImpl implements Function1<Long, Channel> {
    public StoreStream$lazyChannelMembersStore$1(StoreChannels storeChannels) {
        super(1, storeChannels, StoreChannels.class, "getChannel", "getChannel(J)Lcom/discord/api/channel/Channel;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Channel invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Channel invoke(long j) {
        return ((StoreChannels) this.receiver).getChannel(j);
    }
}
