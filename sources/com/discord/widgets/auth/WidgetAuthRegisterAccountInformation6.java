package com.discord.widgets.auth;

import android.widget.CheckBox;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation6 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<MaterialCheckBox, CharSequence, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(materialCheckBox, charSequence));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(materialCheckBox, "checkBox");
            Intrinsics3.checkNotNullParameter(charSequence, "errorMessage");
            AppToast.h(materialCheckBox.getContext(), charSequence, 0, null, 12);
            ViewExtensions.hintWithRipple$default(materialCheckBox, 0L, 1, null);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation6(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(0);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(R.string.username_required)};
        TextInputLayout textInputLayout2 = this.this$0.getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout2, companion.createRequiredInputValidator(R.string.password_required), AuthUtils.INSTANCE.createPasswordInputValidator(R.string.password_length_error)), new Input.GenericInput("tos", this.this$0.getBinding().f, new InputValidator<CheckBox>() { // from class: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2.1
            @Override // com.discord.utilities.view.validators.InputValidator
            public CharSequence getErrorMessage(CheckBox view) {
                Intrinsics3.checkNotNullParameter(view, "view");
                if ((WidgetAuthRegisterAccountInformation6.this.this$0.isConsentRequired && view.isChecked()) || !WidgetAuthRegisterAccountInformation6.this.this$0.isConsentRequired) {
                    return null;
                }
                return view.getContext().getString(R.string.terms_privacy_opt_in_tooltip);
            }
        }, AnonymousClass2.INSTANCE));
    }
}
