package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$observePreviousId$1 extends o implements Function0<Long> {
    public final /* synthetic */ StoreChannelsSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$observePreviousId$1(StoreChannelsSelected storeChannelsSelected) {
        super(0);
        this.this$0 = storeChannelsSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return StoreChannelsSelected.access$getPreviouslySelectedChannel$p(this.this$0).getId();
    }
}
