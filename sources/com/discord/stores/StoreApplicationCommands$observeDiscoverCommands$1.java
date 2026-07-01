package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$observeDiscoverCommands$1 extends o implements Function0<DiscoverCommands> {
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$observeDiscoverCommands$1(StoreApplicationCommands storeApplicationCommands) {
        super(0);
        this.this$0 = storeApplicationCommands;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ DiscoverCommands invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final DiscoverCommands invoke() {
        return this.this$0.getDiscoverCommandsSnapshot();
    }
}
