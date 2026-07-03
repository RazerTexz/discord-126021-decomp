package com.discord.widgets.auth;

import com.discord.C5419R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$validationManager$2(WidgetAuthLogin widgetAuthLogin) {
        super(0);
        this.this$0 = widgetAuthLogin;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout mainTextInputLayout = this.this$0.getBinding().f15684e.getMainTextInputLayout();
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(C5419R.string.login_required)};
        TextInputLayout textInputLayout = this.this$0.getBinding().f15686g;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("binding.authLogin", mainTextInputLayout, inputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, companion.createRequiredInputValidator(C5419R.string.password_required)));
    }
}
