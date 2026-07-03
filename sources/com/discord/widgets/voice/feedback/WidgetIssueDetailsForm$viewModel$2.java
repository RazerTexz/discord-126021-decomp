package com.discord.widgets.voice.feedback;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm$viewModel$2 extends AbstractC12240o implements Function0<IssueDetailsFormViewModel> {
    public final /* synthetic */ WidgetIssueDetailsForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIssueDetailsForm$viewModel$2(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        super(0);
        this.this$0 = widgetIssueDetailsForm;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IssueDetailsFormViewModel invoke() {
        return new IssueDetailsFormViewModel(this.this$0.getPendingFeedback(), null, 2, null);
    }
}
