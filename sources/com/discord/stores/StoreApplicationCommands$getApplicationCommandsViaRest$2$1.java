package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$getApplicationCommandsViaRest$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreApplicationCommands$getApplicationCommandsViaRest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$getApplicationCommandsViaRest$2$1(StoreApplicationCommands$getApplicationCommandsViaRest$2 storeApplicationCommands$getApplicationCommandsViaRest$2) {
        super(0);
        this.this$0 = storeApplicationCommands$getApplicationCommandsViaRest$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(this.this$0.this$0, false);
    }
}
