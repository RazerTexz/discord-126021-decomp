package com.discord.stores;

import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$observeAutocompleteResults$1 extends o implements Function0<Map<String, ? extends Map<String, ? extends CommandAutocompleteState>>> {
    public final /* synthetic */ StoreApplicationCommands this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$observeAutocompleteResults$1(StoreApplicationCommands storeApplicationCommands) {
        super(0);
        this.this$0 = storeApplicationCommands;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Map<String, ? extends CommandAutocompleteState>> invoke2() {
        return this.this$0.getAutocompleteOptionResults();
    }
}
