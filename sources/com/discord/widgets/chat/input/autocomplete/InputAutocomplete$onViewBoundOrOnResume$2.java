package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$onViewBoundOrOnResume$2 extends o implements Function1<InputEditTextAction, Unit> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$onViewBoundOrOnResume$2(InputAutocomplete inputAutocomplete) {
        super(1);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(InputEditTextAction inputEditTextAction) {
        invoke2(inputEditTextAction);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(InputEditTextAction inputEditTextAction) {
        InputAutocomplete inputAutocomplete = this.this$0;
        m.checkNotNullExpressionValue(inputEditTextAction, "it");
        InputAutocomplete.access$applyEditTextAction(inputAutocomplete, inputEditTextAction);
    }
}
