package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$validateSelectedChannel$3 extends o implements Function1<StoreChannelsSelected$ResolvedSelectedChannel, Unit> {
    public final /* synthetic */ StoreChannelsSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$validateSelectedChannel$3(StoreChannelsSelected storeChannelsSelected) {
        super(1);
        this.this$0 = storeChannelsSelected;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        invoke2(storeChannelsSelected$ResolvedSelectedChannel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        StoreChannelsSelected.access$getDispatcher$p(this.this$0).schedule(new StoreChannelsSelected$validateSelectedChannel$3$1(this, storeChannelsSelected$ResolvedSelectedChannel));
    }
}
