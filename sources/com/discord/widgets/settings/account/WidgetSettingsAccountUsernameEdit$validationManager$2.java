package com.discord.widgets.settings.account;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input$EditTextInput;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit$validationManager$2(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetSettingsAccountUsernameEdit.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.Companion.createRequiredInputValidator(2131897012)};
        TextInputLayout textInputLayout2 = WidgetSettingsAccountUsernameEdit.access$getBinding$p(this.this$0).f2598b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
        return new ValidationManager(new Input$TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input$EditTextInput("discriminator", textInputLayout2, AuthUtils.INSTANCE.createDiscriminatorInputValidator(2131893974, 2131893977)));
    }
}
