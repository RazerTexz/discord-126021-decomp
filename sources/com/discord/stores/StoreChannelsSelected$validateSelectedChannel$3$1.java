package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$validateSelectedChannel$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel $selected;
    public final /* synthetic */ StoreChannelsSelected$validateSelectedChannel$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$validateSelectedChannel$3$1(StoreChannelsSelected$validateSelectedChannel$3 storeChannelsSelected$validateSelectedChannel$3, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        super(0);
        this.this$0 = storeChannelsSelected$validateSelectedChannel$3;
        this.$selected = storeChannelsSelected$ResolvedSelectedChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreChannelsSelected storeChannelsSelected = this.this$0.this$0;
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel = this.$selected;
        m.checkNotNullExpressionValue(storeChannelsSelected$ResolvedSelectedChannel, "selected");
        StoreChannelsSelected.access$onSelectedChannelResolved(storeChannelsSelected, storeChannelsSelected$ResolvedSelectedChannel);
    }
}
