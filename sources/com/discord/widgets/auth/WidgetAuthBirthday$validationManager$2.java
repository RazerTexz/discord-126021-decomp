package com.discord.widgets.auth;

import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input$GenericInput;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthBirthday this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthBirthday$validationManager$2(WidgetAuthBirthday widgetAuthBirthday) {
        super(0);
        this.this$0 = widgetAuthBirthday;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetAuthBirthday.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.authRegisterBirthday");
        return new ValidationManager(new Input$TextInputLayoutInput("dateOfBirth", textInputLayout, BasicTextInputValidator.Companion.createRequiredInputValidator(2131886390)), new Input$GenericInput("tos", WidgetAuthBirthday.access$getBinding$p(this.this$0).e, new WidgetAuthBirthday$validationManager$2$1(this), WidgetAuthBirthday$validationManager$2$2.INSTANCE));
    }
}
