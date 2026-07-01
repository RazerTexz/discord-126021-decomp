package com.discord.utilities.view.validators;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Input.kt */
/* JADX INFO: loaded from: classes2.dex */
public class Input<T extends View> {
    private final String name;
    private final InputValidator<T>[] validators;
    private final T view;

    /* JADX INFO: compiled from: Input.kt */
    public static final class EditTextInput extends Input<TextInputLayout> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EditTextInput(String str, TextInputLayout textInputLayout, InputValidator<? super TextInputLayout>... inputValidatorArr) {
            super(str, textInputLayout, (InputValidator[]) Arrays.copyOf(inputValidatorArr, inputValidatorArr.length));
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(textInputLayout, "view");
            Intrinsics3.checkNotNullParameter(inputValidatorArr, "validators");
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            getView().setError(errorMessage);
            boolean z2 = !(errorMessage == null || StringsJVM.isBlank(errorMessage));
            if (z2) {
                getView().requestFocus();
            }
            return z2;
        }
    }

    /* JADX INFO: compiled from: Input.kt */
    public static final class GenericInput<T extends View> extends Input<T> {
        private final Function2<T, CharSequence, Boolean> onError;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public GenericInput(String str, T t, InputValidator<? super T> inputValidator, Function2<? super T, ? super CharSequence, Boolean> function2) {
            super(str, t, inputValidator);
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(t, "view");
            Intrinsics3.checkNotNullParameter(inputValidator, "validator");
            Intrinsics3.checkNotNullParameter(function2, "onError");
            this.onError = function2;
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            if (errorMessage == null || StringsJVM.isBlank(errorMessage)) {
                return false;
            }
            return this.onError.invoke(getView(), errorMessage).booleanValue();
        }
    }

    /* JADX INFO: compiled from: Input.kt */
    public static final class TextInputLayoutInput extends Input<TextInputLayout> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextInputLayoutInput(String str, TextInputLayout textInputLayout, InputValidator<? super TextInputLayout>... inputValidatorArr) {
            super(str, textInputLayout, (InputValidator[]) Arrays.copyOf(inputValidatorArr, inputValidatorArr.length));
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(textInputLayout, "view");
            Intrinsics3.checkNotNullParameter(inputValidatorArr, "validators");
        }

        @Override // com.discord.utilities.view.validators.Input
        public boolean setErrorMessage(CharSequence errorMessage) {
            getView().setError(errorMessage);
            if (getView().getEndIconMode() == 1) {
                getView().setErrorIconDrawable(0);
            }
            boolean z2 = !(errorMessage == null || StringsJVM.isBlank(errorMessage));
            getView().setErrorEnabled(z2);
            if (z2) {
                getView().requestFocus();
            }
            return z2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Input(String str, T t, InputValidator<? super T>... inputValidatorArr) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(t, "view");
        Intrinsics3.checkNotNullParameter(inputValidatorArr, "validators");
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
