package com.discord.stores;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreMessagesLoader$ChannelLoadedState $channelLoadedState$inlined;
    public final /* synthetic */ StoreMessagesLoader$tryLoadMessages$4 $loadPagedMessages$4$inlined;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$2(StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState, long j, StoreMessagesLoader$tryLoadMessages$4 storeMessagesLoader$tryLoadMessages$4) {
        super(1);
        this.this$0 = storeMessagesLoader;
        this.$channelLoadedState$inlined = storeMessagesLoader$ChannelLoadedState;
        this.$channelId$inlined = j;
        this.$loadPagedMessages$4$inlined = storeMessagesLoader$tryLoadMessages$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreMessagesLoader.access$handleLoadMessagesError(this.this$0, this.$channelId$inlined);
    }
}
