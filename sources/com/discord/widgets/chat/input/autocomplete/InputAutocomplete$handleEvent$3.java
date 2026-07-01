package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$handleEvent$3 extends o implements Function0<Unit> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$handleEvent$3(InputAutocomplete inputAutocomplete) {
        super(0);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InputAutocomplete.access$getFragment$p(this.this$0).showKeyboard(InputAutocomplete.access$getEditText$p(this.this$0));
    }
}
