package com.discord.widgets.chat.input.autocomplete;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: InputAutocomplete.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InputAutocomplete$3 extends o implements Function2<Integer, Integer, Unit> {
    public final /* synthetic */ InputAutocomplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputAutocomplete$3(InputAutocomplete inputAutocomplete) {
        super(2);
        this.this$0 = inputAutocomplete;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.a;
    }

    public final void invoke(int i, int i2) {
        InputAutocomplete.access$getViewModel$p(this.this$0).onSelectionChanged(InputAutocomplete.access$getEditText$p(this.this$0).getEditableText().toString(), i, i2);
    }
}
