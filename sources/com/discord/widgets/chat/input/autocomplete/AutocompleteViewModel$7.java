package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.input.models.AutocompleteInputSelectionModel;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AutocompleteViewModel$7 extends k implements Function1<AutocompleteInputSelectionModel, Unit> {
    public AutocompleteViewModel$7(AutocompleteViewModel autocompleteViewModel) {
        super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleAutocompleteInputSelectionModel", "handleAutocompleteInputSelectionModel(Lcom/discord/widgets/chat/input/models/AutocompleteInputSelectionModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        invoke2(autocompleteInputSelectionModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AutocompleteInputSelectionModel autocompleteInputSelectionModel) {
        m.checkNotNullParameter(autocompleteInputSelectionModel, "p1");
        AutocompleteViewModel.access$handleAutocompleteInputSelectionModel((AutocompleteViewModel) this.receiver, autocompleteInputSelectionModel);
    }
}
