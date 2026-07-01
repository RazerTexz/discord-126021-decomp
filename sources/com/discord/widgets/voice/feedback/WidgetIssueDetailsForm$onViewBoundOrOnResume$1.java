package com.discord.widgets.voice.feedback;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm$onViewBoundOrOnResume$1 extends o implements Function1<IssueDetailsFormViewModel$Event, Unit> {
    public final /* synthetic */ WidgetIssueDetailsForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIssueDetailsForm$onViewBoundOrOnResume$1(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        super(1);
        this.this$0 = widgetIssueDetailsForm;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IssueDetailsFormViewModel$Event issueDetailsFormViewModel$Event) {
        invoke2(issueDetailsFormViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IssueDetailsFormViewModel$Event issueDetailsFormViewModel$Event) {
        m.checkNotNullParameter(issueDetailsFormViewModel$Event, "event");
        WidgetIssueDetailsForm.access$handleEvent(this.this$0, issueDetailsFormViewModel$Event);
    }
}
