package com.discord.widgets.auth;

import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.BasicTextInputValidator$Companion;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$validationManager$2(WidgetAuthLogin widgetAuthLogin) {
        super(0);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout mainTextInputLayout = WidgetAuthLogin.access$getBinding$p(this.this$0).e.getMainTextInputLayout();
        BasicTextInputValidator$Companion basicTextInputValidator$Companion = BasicTextInputValidator.Companion;
        InputValidator[] inputValidatorArr = {basicTextInputValidator$Companion.createRequiredInputValidator(2131892648)};
        TextInputLayout textInputLayout = WidgetAuthLogin.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        return new ValidationManager(new Input$TextInputLayoutInput("binding.authLogin", mainTextInputLayout, inputValidatorArr), new Input$TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, basicTextInputValidator$Companion.createRequiredInputValidator(2131893660)));
    }
}
