package com.discord.widgets.botuikit;

import android.text.Editable;
import com.discord.databinding.BotUikitTextInputBinding;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.botuikit.ModalComponent$onViewBound$components$2$1, reason: use source file name */
/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent3 extends Lambda implements Function1<Editable, Unit> {
    public final /* synthetic */ BotUikitTextInputBinding $textInput;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent3(BotUikitTextInputBinding botUikitTextInputBinding) {
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
        Intrinsics3.checkNotNullParameter(editable, "it");
        TextInputLayout textInputLayout = this.$textInput.d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInput.layout");
        textInputLayout.setError(null);
    }
}
