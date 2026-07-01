package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InputAutocomplete$onViewBoundOrOnResume$1 extends k implements Function1<ViewState, Unit> {
    public InputAutocomplete$onViewBoundOrOnResume$1(InputAutocomplete inputAutocomplete) {
        super(1, inputAutocomplete, InputAutocomplete.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/input/autocomplete/ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
        invoke2(viewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewState viewState) {
        m.checkNotNullParameter(viewState, "p1");
        InputAutocomplete.access$configureUI((InputAutocomplete) this.receiver, viewState);
    }
}
