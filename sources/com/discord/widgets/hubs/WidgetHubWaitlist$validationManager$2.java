package com.discord.widgets.hubs;

import com.discord.C5419R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$validationManager$2 extends AbstractC12240o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist$validationManager$2(WidgetHubWaitlist widgetHubWaitlist) {
        super(0);
        this.this$0 = widgetHubWaitlist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f17191d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.hubWaitlistLayout");
        return new ValidationManager(new Input.TextInputLayoutInput("school name", textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.member_verification_form_required_item)));
    }
}
