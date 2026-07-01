package com.discord.widgets.bugreports;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.BasicTextInputValidator$Companion;
import com.discord.utilities.view.validators.Input$TextInputLayoutInput;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$validationManager$2 extends o implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$validationManager$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetBugReport.access$getBinding$p(this.this$0).h;
        m.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        BasicTextInputValidator$Companion basicTextInputValidator$Companion = BasicTextInputValidator.Companion;
        InputValidator[] inputValidatorArr = {basicTextInputValidator$Companion.createRequiredInputValidator(2131887309)};
        TextInputLayout textInputLayout2 = WidgetBugReport.access$getBinding$p(this.this$0).j;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportPriority");
        return new ValidationManager(new Input$TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, inputValidatorArr), new Input$TextInputLayoutInput("priority", textInputLayout2, basicTextInputValidator$Companion.createRequiredInputValidator(2131887310)));
    }
}
