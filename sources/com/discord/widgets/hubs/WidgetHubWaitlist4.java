package com.discord.widgets.hubs;

import com.discord.R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist4(WidgetHubWaitlist widgetHubWaitlist) {
        super(0);
        this.this$0 = widgetHubWaitlist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.hubWaitlistLayout");
        return new ValidationManager(new Input.TextInputLayoutInput("school name", textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(R.string.member_verification_form_required_item)));
    }
}
