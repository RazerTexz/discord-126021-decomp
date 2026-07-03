package com.discord.widgets.botuikit;

import android.text.Editable;
import com.discord.databinding.BotUikitTextInputBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$components$2$1 extends AbstractC12240o implements Function1<Editable, Unit> {
    public final /* synthetic */ BotUikitTextInputBinding $textInput;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$onViewBound$components$2$1(BotUikitTextInputBinding botUikitTextInputBinding) {
        super(1);
        this.$textInput = botUikitTextInputBinding;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        C12238m.checkNotNullParameter(editable, "it");
        TextInputLayout textInputLayout = this.$textInput.f15017d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
        textInputLayout.setError(null);
    }
}
