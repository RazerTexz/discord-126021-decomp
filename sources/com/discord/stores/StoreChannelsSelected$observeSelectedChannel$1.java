package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected$observeSelectedChannel$1 extends o implements Function0<Channel> {
    public final /* synthetic */ StoreChannelsSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannelsSelected$observeSelectedChannel$1(StoreChannelsSelected storeChannelsSelected) {
        super(0);
        this.this$0 = storeChannelsSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Channel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Channel invoke() {
        return this.this$0.getSelectedChannel();
    }
}
