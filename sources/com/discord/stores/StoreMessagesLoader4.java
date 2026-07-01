package com.discord.stores;

import com.discord.stores.StoreMessagesLoader;
import com.discord.utilities.error.Error;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$$inlined$apply$lambda$2, reason: use source file name */
/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader4 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ long $channelId$inlined;
    public final /* synthetic */ StoreMessagesLoader.ChannelLoadedState $channelLoadedState$inlined;
    public final /* synthetic */ StoreMessagesLoader.AnonymousClass4 $loadPagedMessages$4$inlined;
    public final /* synthetic */ StoreMessagesLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessagesLoader4(StoreMessagesLoader storeMessagesLoader, StoreMessagesLoader.ChannelLoadedState channelLoadedState, long j, StoreMessagesLoader.AnonymousClass4 anonymousClass4) {
        super(1);
        this.this$0 = storeMessagesLoader;
        this.$channelLoadedState$inlined = channelLoadedState;
        this.$channelId$inlined = j;
        this.$loadPagedMessages$4$inlined = anonymousClass4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "it");
        this.this$0.handleLoadMessagesError(this.$channelId$inlined);
    }
}
