package com.discord.widgets.botuikit;

import android.text.Editable;
import com.discord.databinding.BotUikitTextInputBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$components$2$1 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ BotUikitTextInputBinding $textInput;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$onViewBound$components$2$1(BotUikitTextInputBinding botUikitTextInputBinding) {
        super(1);
        this.$textInput = botUikitTextInputBinding;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "it");
        TextInputLayout textInputLayout = this.$textInput.d;
        m.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
        textInputLayout.setError(null);
    }
}
