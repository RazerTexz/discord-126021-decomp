package com.discord.utilities.view.validators;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Input$GenericInput<T extends View> extends Input<T> {
    private final Function2<T, CharSequence, Boolean> onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Input$GenericInput(String str, T t, InputValidator<? super T> inputValidator, Function2<? super T, ? super CharSequence, Boolean> function2) {
        super(str, t, inputValidator);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(t, "view");
        m.checkNotNullParameter(inputValidator, "validator");
        m.checkNotNullParameter(function2, "onError");
        this.onError = function2;
    }

    @Override // com.discord.utilities.view.validators.Input
    public boolean setErrorMessage(CharSequence errorMessage) {
        if (errorMessage == null || t.isBlank(errorMessage)) {
            return false;
        }
        return this.onError.invoke(getView(), errorMessage).booleanValue();
    }
}
