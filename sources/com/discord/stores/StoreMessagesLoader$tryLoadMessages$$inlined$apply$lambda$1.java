package com.discord.stores;

import com.discord.models.message.Message;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$1 extends o implements Function1<List<? extends Message>, Unit> {
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreMessagesLoader$ChannelLoadedState $channelLoadedState$inlined;
    public final /* synthetic */ StoreMessagesLoader$tryLoadMessages$4 $loadPagedMessages$4$inlined;
    public final /* synthetic */ boolean $shouldRequestNewerMessages;
    public final /* synthetic */ boolean $shouldRequestOlderMessages;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$1(boolean z2, boolean z3, StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState, long j, StoreMessagesLoader$tryLoadMessages$4 storeMessagesLoader$tryLoadMessages$4) {
        super(1);
        this.$shouldRequestOlderMessages = z2;
        this.$shouldRequestNewerMessages = z3;
        this.this$0 = storeMessagesLoader;
        this.$channelLoadedState$inlined = storeMessagesLoader$ChannelLoadedState;
        this.$channelId$inlined = j;
        this.$loadPagedMessages$4$inlined = storeMessagesLoader$tryLoadMessages$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
        invoke2((List<Message>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<Message> list) {
        StoreMessagesLoader$tryLoadMessages$4 storeMessagesLoader$tryLoadMessages$4 = this.$loadPagedMessages$4$inlined;
        long j = this.$channelId$inlined;
        m.checkNotNullExpressionValue(list, "messages");
        storeMessagesLoader$tryLoadMessages$4.invoke(j, list, this.$shouldRequestOlderMessages, this.$shouldRequestNewerMessages);
    }
}
