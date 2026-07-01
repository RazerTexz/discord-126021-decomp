package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels$stageChannelIdsInGuildForDispatch$1 extends o implements Function1<Channel, Long> {
    public static final StoreStageChannels$stageChannelIdsInGuildForDispatch$1 INSTANCE = new StoreStageChannels$stageChannelIdsInGuildForDispatch$1();

    public StoreStageChannels$stageChannelIdsInGuildForDispatch$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Long invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        Long lValueOf = Long.valueOf(channel.getId());
        lValueOf.longValue();
        if (ChannelUtils.D(channel)) {
            return lValueOf;
        }
        return null;
    }
}
