package com.discord.widgets.auth;

import com.discord.C5419R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetAuthRegisterIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity$phoneValidationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity$phoneValidationManager$2(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(0);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        return new ValidationManager(new Input.TextInputLayoutInput("phone", this.this$0.getBinding().f15711d.getMainTextInputLayout(), BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.phone_required), AuthUtils.INSTANCE.createPhoneInputValidator(C5419R.string.phone_invalid)));
    }
}
