package com.discord.stores;

import com.discord.api.commands.ApplicationCommandAutocompleteResult;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$66 extends k implements Function1<ApplicationCommandAutocompleteResult, Unit> {
    public StoreStream$initGatewaySocketListeners$66(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleApplicationCommandAutocompleteResult", "handleApplicationCommandAutocompleteResult(Lcom/discord/api/commands/ApplicationCommandAutocompleteResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult) {
        invoke2(applicationCommandAutocompleteResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ApplicationCommandAutocompleteResult applicationCommandAutocompleteResult) {
        m.checkNotNullParameter(applicationCommandAutocompleteResult, "p1");
        ((StoreStream) this.receiver).handleApplicationCommandAutocompleteResult(applicationCommandAutocompleteResult);
    }
}
