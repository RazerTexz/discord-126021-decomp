package com.discord.widgets.settings.account;

import com.discord.C5419R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit$validationManager$2(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f17832c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountUsernameWrap");
        InputValidator[] inputValidatorArr = {BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.username_required)};
        TextInputLayout textInputLayout2 = this.this$0.getBinding().f17831b;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.editAccountDiscriminatorWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("username", textInputLayout, inputValidatorArr), new Input.EditTextInput("discriminator", textInputLayout2, AuthUtils.INSTANCE.createDiscriminatorInputValidator(C5419R.string.premium_change_discriminator_length_error, C5419R.string.premium_change_discriminator_zero_error)));
    }
}
