package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$jumpToMessage$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$jumpToMessage$2(StoreMessagesLoader storeMessagesLoader, long j) {
        super(1);
        this.this$0 = storeMessagesLoader;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final synchronized void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        if (channel.getId() != StoreMessagesLoader.access$getSelectedChannelId$p(this.this$0)) {
            StoreMessagesLoader.access$channelLoadedStateUpdate(this.this$0, this.$channelId, StoreMessagesLoader$jumpToMessage$2$1.INSTANCE);
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), channel, null, null, 6, null);
        }
    }
}
