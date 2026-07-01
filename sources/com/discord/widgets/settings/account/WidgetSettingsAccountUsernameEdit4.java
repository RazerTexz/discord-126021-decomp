package com.discord.widgets.settings.account;

import com.discord.R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit4(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.username_required)};
        TextInputLayout textInputLayout2 = this.this$0.getBinding().f2598b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input.EditTextInput("discriminator", textInputLayout2, AuthUtils.INSTANCE.createDiscriminatorInputValidator(R.string.premium_change_discriminator_length_error, R.string.premium_change_discriminator_zero_error)));
    }
}
