package com.discord.widgets.settings.account;

import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.BasicTextInputValidator$Companion;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountChangePassword$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountChangePassword this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountChangePassword$validationManager$2(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword) {
        super(0);
        this.this$0 = widgetSettingsAccountChangePassword;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
        BasicTextInputValidator$Companion basicTextInputValidator$Companion = BasicTextInputValidator.Companion;
        BasicTextInputValidator[] basicTextInputValidatorArr = {basicTextInputValidator$Companion.createRequiredInputValidator(2131893660)};
        TextInputLayout textInputLayout2 = this.this$0.getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordNewPasswordInput");
        return new ValidationManager(new Input$TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, basicTextInputValidatorArr), new Input$TextInputLayoutInput(WidgetSettingsAccountChangePassword.NEW_PASSWORD_FIELD, textInputLayout2, basicTextInputValidator$Companion.createRequiredInputValidator(2131893662)));
    }
}
