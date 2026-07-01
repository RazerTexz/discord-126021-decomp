package com.discord.widgets.auth;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.BasicTextInputValidator$Companion;
import com.discord.utilities.view.validators.Input$GenericInput;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetAuthRegisterAccountInformation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterAccountInformation$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterAccountInformation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterAccountInformation$validationManager$2(WidgetAuthRegisterAccountInformation widgetAuthRegisterAccountInformation) {
        super(0);
        this.this$0 = widgetAuthRegisterAccountInformation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetAuthRegisterAccountInformation.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterAccountInformationUsernameWrap");
        BasicTextInputValidator$Companion basicTextInputValidator$Companion = BasicTextInputValidator.Companion;
        InputValidator[] inputValidatorArr = {basicTextInputValidator$Companion.createRequiredInputValidator(2131897012)};
        TextInputLayout textInputLayout2 = WidgetAuthRegisterAccountInformation.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.authRegisterAccountInformationPasswordWrap");
        return new ValidationManager(new Input$TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input$TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout2, basicTextInputValidator$Companion.createRequiredInputValidator(2131893660), AuthUtils.INSTANCE.createPasswordInputValidator(2131893649)), new Input$GenericInput("tos", WidgetAuthRegisterAccountInformation.access$getBinding$p(this.this$0).f, new WidgetAuthRegisterAccountInformation$validationManager$2$1(this), WidgetAuthRegisterAccountInformation$validationManager$2$2.INSTANCE));
    }
}
