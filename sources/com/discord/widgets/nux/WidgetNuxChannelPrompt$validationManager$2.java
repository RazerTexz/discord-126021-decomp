package com.discord.widgets.nux;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetNuxChannelPrompt.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetNuxChannelPrompt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxChannelPrompt$validationManager$2(WidgetNuxChannelPrompt widgetNuxChannelPrompt) {
        super(0);
        this.this$0 = widgetNuxChannelPrompt;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetNuxChannelPrompt.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        return new ValidationManager(new Input$TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, new InputValidator[0]));
    }
}
