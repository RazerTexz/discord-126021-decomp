package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AutocompleteViewModel$2 extends k implements Function1<AutocompleteViewModel$StoreState, Unit> {
    public AutocompleteViewModel$2(AutocompleteViewModel autocompleteViewModel) {
        super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/autocomplete/AutocompleteViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AutocompleteViewModel$StoreState autocompleteViewModel$StoreState) {
        invoke2(autocompleteViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AutocompleteViewModel$StoreState autocompleteViewModel$StoreState) {
        m.checkNotNullParameter(autocompleteViewModel$StoreState, "p1");
        AutocompleteViewModel.access$handleStoreState((AutocompleteViewModel) this.receiver, autocompleteViewModel$StoreState);
    }
}
