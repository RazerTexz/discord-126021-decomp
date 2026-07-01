package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector$findAndSet$3 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ ChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelSelector$findAndSet$3(ChannelSelector channelSelector) {
        super(1);
        this.this$0 = channelSelector;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        ChannelSelector.selectChannel$default(this.this$0, channel, null, null, 6, null);
    }
}
