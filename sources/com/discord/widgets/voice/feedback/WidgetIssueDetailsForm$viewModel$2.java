package com.discord.widgets.voice.feedback;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm$viewModel$2 extends o implements Function0<IssueDetailsFormViewModel> {
    public final /* synthetic */ WidgetIssueDetailsForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIssueDetailsForm$viewModel$2(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        super(0);
        this.this$0 = widgetIssueDetailsForm;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ IssueDetailsFormViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IssueDetailsFormViewModel invoke() {
        return new IssueDetailsFormViewModel(WidgetIssueDetailsForm.access$getPendingFeedback(this.this$0), null, 2, null);
    }
}
