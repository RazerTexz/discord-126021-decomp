package com.discord.utilities.view.validators;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes2.dex */
public class Input<T extends View> {
    private final String name;
    private final InputValidator<T>[] validators;
    private final T view;

    /* JADX WARN: Multi-variable type inference failed */
    public Input(String str, T t, InputValidator<? super T>... inputValidatorArr) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(t, "view");
        m.checkNotNullParameter(inputValidatorArr, "validators");
        this.name = str;
        this.view = t;
        this.validators = inputValidatorArr;
    }

    public static /* synthetic */ boolean validate$default(Input input, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validate");
        }
        if ((i & 1) != 0) {
            z2 = true;
        }
        return input.validate(z2);
    }

    public final String getName() {
        return this.name;
    }

    public final T getView() {
        return this.view;
    }

    public boolean setErrorMessage(CharSequence errorMessage) {
        return false;
    }

    public boolean validate(boolean showErrors) {
        boolean z2 = false;
        for (InputValidator<T> inputValidator : this.validators) {
            CharSequence errorMessage = inputValidator.getErrorMessage(this.view);
            if (showErrors ? setErrorMessage(errorMessage) : !(errorMessage == null || errorMessage.length() == 0)) {
                z2 = true;
                break;
            }
        }
        return !z2;
    }
}
