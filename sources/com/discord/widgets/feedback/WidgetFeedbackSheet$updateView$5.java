package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.FeedbackIssue;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet$updateView$5 extends o implements Function1<FeedbackIssue, Unit> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet$updateView$5(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(1);
        this.this$0 = widgetFeedbackSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
        invoke2(feedbackIssue);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackIssue feedbackIssue) {
        m.checkNotNullParameter(feedbackIssue, "issue");
        WidgetFeedbackSheet.access$getViewModel$p(this.this$0).selectIssue(feedbackIssue, this.this$0.getString(feedbackIssue.getReasonStringRes()));
    }
}
