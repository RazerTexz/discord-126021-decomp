package com.discord.stores;

import com.discord.utilities.error.Error;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ ApplicationCommandValue $option;
    public final /* synthetic */ StoreApplicationCommands$requestApplicationCommandAutocompleteData$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1(StoreApplicationCommands$requestApplicationCommandAutocompleteData$1 storeApplicationCommands$requestApplicationCommandAutocompleteData$1, ApplicationCommandValue applicationCommandValue) {
        super(1);
        this.this$0 = storeApplicationCommands$requestApplicationCommandAutocompleteData$1;
        this.$option = applicationCommandValue;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        StoreApplicationCommands.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$1$1(this));
    }
}
