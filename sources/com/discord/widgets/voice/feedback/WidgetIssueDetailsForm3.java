package com.discord.widgets.voice.feedback;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm3 extends Lambda implements Function0<IssueDetailsFormViewModel> {
    public final /* synthetic */ WidgetIssueDetailsForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIssueDetailsForm3(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        super(0);
        this.this$0 = widgetIssueDetailsForm;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final IssueDetailsFormViewModel invoke() {
        return new IssueDetailsFormViewModel(this.this$0.getPendingFeedback(), null, 2, null);
    }
}
