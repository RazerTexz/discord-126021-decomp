package com.discord.widgets.auth;

import android.widget.CheckBox;
import com.discord.C5419R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2$2 */
    /* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
    public static final class C72272 extends AbstractC12240o implements Function2<MaterialCheckBox, CharSequence, Boolean> {
        public static final C72272 INSTANCE = new C72272();

        public C72272() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            return Boolean.valueOf(invoke2(materialCheckBox, charSequence));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
            C12238m.checkNotNullParameter(materialCheckBox, "checkBox");
            C12238m.checkNotNullParameter(charSequence, "errorMessage");
            C0876m.m170h(materialCheckBox.getContext(), charSequence, 0, null, 12);
            ViewExtensions.hintWithRipple$default(materialCheckBox, 0L, 1, null);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation$validationManager$2(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(0);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f15706e;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(C5419R.string.username_required)};
        TextInputLayout textInputLayout2 = this.this$0.getBinding().f15705d;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout2, companion.createRequiredInputValidator(C5419R.string.password_required), AuthUtils.INSTANCE.createPasswordInputValidator(C5419R.string.password_length_error)), new Input.GenericInput("tos", this.this$0.getBinding().f15707f, new InputValidator<CheckBox>() { // from class: com.discord.widgets.auth.WidgetAuthRegisterAccountInformation$validationManager$2.1
            @Override // com.discord.utilities.view.validators.InputValidator
            public CharSequence getErrorMessage(CheckBox view) {
                C12238m.checkNotNullParameter(view, "view");
                if ((WidgetAuthRegisterAccountInformation$validationManager$2.this.this$0.isConsentRequired && view.isChecked()) || !WidgetAuthRegisterAccountInformation$validationManager$2.this.this$0.isConsentRequired) {
                    return null;
                }
                return view.getContext().getString(C5419R.string.terms_privacy_opt_in_tooltip);
            }
        }, C72272.INSTANCE));
    }
}
