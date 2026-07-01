package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMessagesLoader$jumpToMessage$8 extends k implements Function1<Channel, Unit> {
    public final /* synthetic */ StoreMessagesLoader$jumpToMessage$2 $handleTargetChannelResolved$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$jumpToMessage$8(StoreMessagesLoader$jumpToMessage$2 storeMessagesLoader$jumpToMessage$2) {
        super(1, null, "handleTargetChannelResolved", "invoke(Lcom/discord/api/channel/Channel;)V", 0);
        this.$handleTargetChannelResolved$2 = storeMessagesLoader$jumpToMessage$2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        m.checkNotNullParameter(channel, "p1");
        this.$handleTargetChannelResolved$2.invoke2(channel);
    }
}
