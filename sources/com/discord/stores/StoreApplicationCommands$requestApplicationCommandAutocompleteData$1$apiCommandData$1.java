package com.discord.stores;

import com.discord.api.commands.ApplicationCommandValue;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1 extends o implements Function1<ApplicationCommandValue, ApplicationCommandValue> {
    public static final StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1 INSTANCE = new StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1();

    public StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandValue invoke2(ApplicationCommandValue applicationCommandValue) {
        m.checkNotNullParameter(applicationCommandValue, "it");
        return applicationCommandValue;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandValue invoke(ApplicationCommandValue applicationCommandValue) {
        return invoke2(applicationCommandValue);
    }
}
