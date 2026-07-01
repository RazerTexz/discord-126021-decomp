package com.discord.widgets.hubs;

import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubAddName.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddName$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubAddName this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddName$validationManager$2(WidgetHubAddName widgetHubAddName) {
        super(0);
        this.this$0 = widgetHubAddName;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.discordHubAddNameInputLayout");
        return new ValidationManager(new Input$TextInputLayoutInput("binding.discordHubAddNameInputLayout", textInputLayout, BasicTextInputValidator.Companion.createRequiredInputValidator(2131892854)));
    }
}
