package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreConnectivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreConnectivity$handleChannelMessagesLoading$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $channelMessagesLoading;
    public final /* synthetic */ StoreConnectivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreConnectivity$handleChannelMessagesLoading$1(StoreConnectivity storeConnectivity, boolean z2) {
        super(0);
        this.this$0 = storeConnectivity;
        this.$channelMessagesLoading = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreConnectivity.access$setChannelMessagesLoading$p(this.this$0, this.$channelMessagesLoading);
        StoreConnectivity.access$updateConnectivityState(this.this$0);
    }
}
