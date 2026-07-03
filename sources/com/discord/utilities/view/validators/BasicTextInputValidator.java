package com.discord.utilities.view.validators;

import androidx.annotation.StringRes;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BasicTextInputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BasicTextInputValidator implements InputValidator<TextInputLayout> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<String, Boolean> inputPredicate;
    private final int messageResId;

    /* JADX INFO: compiled from: BasicTextInputValidator.kt */
    public static final class Companion {
        private Companion() {
        }

        public final BasicTextInputValidator createRequiredInputValidator(@StringRes int messageResId) {
            return new BasicTextInputValidator(messageResId, BasicTextInputValidator$Companion$createRequiredInputValidator$1.INSTANCE);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BasicTextInputValidator(@StringRes int i, Function1<? super String, Boolean> function1) {
        C12238m.checkNotNullParameter(function1, "inputPredicate");
        this.messageResId = i;
        this.inputPredicate = function1;
    }

    public final int getMessageResId() {
        return this.messageResId;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public CharSequence getErrorMessage(TextInputLayout view) {
        C12238m.checkNotNullParameter(view, "view");
        if (this.inputPredicate.invoke(ViewExtensions.getTextOrEmpty(view)).booleanValue()) {
            return null;
        }
        return C1107b.m212d(view, this.messageResId, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
    }
}
