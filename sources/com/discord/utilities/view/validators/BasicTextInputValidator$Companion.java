package com.discord.utilities.view.validators;

import androidx.annotation.StringRes;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BasicTextInputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BasicTextInputValidator$Companion {
    private BasicTextInputValidator$Companion() {
    }

    public final BasicTextInputValidator createRequiredInputValidator(@StringRes int messageResId) {
        return new BasicTextInputValidator(messageResId, BasicTextInputValidator$Companion$createRequiredInputValidator$1.INSTANCE);
    }

    public /* synthetic */ BasicTextInputValidator$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
