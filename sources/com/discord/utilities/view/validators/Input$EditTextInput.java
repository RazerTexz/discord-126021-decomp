package com.discord.utilities.view.validators;

import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Input$EditTextInput extends Input<TextInputLayout> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Input$EditTextInput(String str, TextInputLayout textInputLayout, InputValidator<? super TextInputLayout>... inputValidatorArr) {
        super(str, textInputLayout, (InputValidator[]) Arrays.copyOf(inputValidatorArr, inputValidatorArr.length));
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(textInputLayout, "view");
        m.checkNotNullParameter(inputValidatorArr, "validators");
    }

    @Override // com.discord.utilities.view.validators.Input
    public boolean setErrorMessage(CharSequence errorMessage) {
        getView().setError(errorMessage);
        boolean z2 = !(errorMessage == null || t.isBlank(errorMessage));
        if (z2) {
            getView().requestFocus();
        }
        return z2;
    }
}
