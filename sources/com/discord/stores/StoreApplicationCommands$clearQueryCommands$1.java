package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$clearQueryCommands$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$clearQueryCommands$1(StoreApplicationCommands storeApplicationCommands) {
        super(0);
        this.this$0 = storeApplicationCommands;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreApplicationCommands.access$getQueryCommands$p(this.this$0).clear();
        this.this$0.markChanged(StoreApplicationCommands.Companion.getQueryCommandsUpdate());
    }
}
