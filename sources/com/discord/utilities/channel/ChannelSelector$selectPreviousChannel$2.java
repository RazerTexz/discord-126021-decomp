package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$selectPreviousChannel$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$selectPreviousChannel$2(ChannelSelector channelSelector, long j) {
        super(1);
        this.this$0 = channelSelector;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        long id2 = 0;
        if (channel != null && !ChannelUtils.J(channel) && channel.getId() >= 0) {
            id2 = channel.getId();
        }
        ChannelSelector.selectChannel$default(this.this$0, this.$guildId, id2, null, null, 12, null);
    }
}
