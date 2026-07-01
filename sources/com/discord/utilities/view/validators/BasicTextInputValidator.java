package com.discord.utilities.view.validators;

import androidx.annotation.StringRes;
import b.a.k.b;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BasicTextInputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BasicTextInputValidator implements InputValidator<TextInputLayout> {
    public static final BasicTextInputValidator$Companion Companion = new BasicTextInputValidator$Companion(null);
    private final Function1<String, Boolean> inputPredicate;
    private final int messageResId;

    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextInputValidator(@StringRes int i, Function1<? super String, Boolean> function1) {
        m.checkNotNullParameter(function1, "inputPredicate");
        this.messageResId = i;
        this.inputPredicate = function1;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(TextInputLayout textInputLayout) {
        return getErrorMessage2(textInputLayout);
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    /* JADX INFO: renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(TextInputLayout view) {
        m.checkNotNullParameter(view, "view");
        if (this.inputPredicate.invoke(ViewExtensions.getTextOrEmpty(view)).booleanValue()) {
            return null;
        }
        return b.j(view, this.messageResId, new Object[0], null, 4);
    }
}
