package com.discord.widgets.chat.input.autocomplete;

import com.discord.widgets.chat.input.models.InputSelectionModel;
import d0.z.d.k;
import d0.z.d.m;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AutocompleteViewModel$5 extends k implements Function1<InputSelectionModel, Unit> {
    public AutocompleteViewModel$5(AutocompleteViewModel autocompleteViewModel) {
        super(1, autocompleteViewModel, AutocompleteViewModel.class, "handleInputSelectionModel", "handleInputSelectionModel(Lcom/discord/widgets/chat/input/models/InputSelectionModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputSelectionModel inputSelectionModel) throws IOException {
        invoke2(inputSelectionModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InputSelectionModel inputSelectionModel) throws IOException {
        m.checkNotNullParameter(inputSelectionModel, "p1");
        AutocompleteViewModel.access$handleInputSelectionModel((AutocompleteViewModel) this.receiver, inputSelectionModel);
    }
}
