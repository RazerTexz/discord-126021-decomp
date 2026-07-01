package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$observeResolvedSelectedChannel$1 extends o implements Function0<StoreChannelsSelected$ResolvedSelectedChannel> {
    public final /* synthetic */ StoreChannelsSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$observeResolvedSelectedChannel$1(StoreChannelsSelected storeChannelsSelected) {
        super(0);
        this.this$0 = storeChannelsSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreChannelsSelected$ResolvedSelectedChannel invoke() {
        return StoreChannelsSelected.access$getSelectedChannel$p(this.this$0);
    }
}
