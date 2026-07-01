package com.discord.stores;

import com.discord.api.channel.ChannelRecipient;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$48 extends k implements Function1<ChannelRecipient, Unit> {
    public StoreStream$initGatewaySocketListeners$48(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleGroupDMRecipientRemove", "handleGroupDMRecipientRemove(Lcom/discord/api/channel/ChannelRecipient;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelRecipient channelRecipient) {
        invoke2(channelRecipient);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelRecipient channelRecipient) {
        m.checkNotNullParameter(channelRecipient, "p1");
        StoreStream.access$handleGroupDMRecipientRemove((StoreStream) this.receiver, channelRecipient);
    }
}
