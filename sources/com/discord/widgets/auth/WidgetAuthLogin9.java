package com.discord.widgets.auth;

import com.discord.R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLogin$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin9 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin9(WidgetAuthLogin widgetAuthLogin) {
        super(0);
        this.this$0 = widgetAuthLogin;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout mainTextInputLayout = this.this$0.getBinding().e.getMainTextInputLayout();
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(R.string.login_required)};
        TextInputLayout textInputLayout = this.this$0.getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("binding.authLogin", mainTextInputLayout, inputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, companion.createRequiredInputValidator(R.string.password_required)));
    }
}
