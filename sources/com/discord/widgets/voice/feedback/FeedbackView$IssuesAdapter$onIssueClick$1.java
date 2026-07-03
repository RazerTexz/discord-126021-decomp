package com.discord.widgets.voice.feedback;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView$IssuesAdapter$onIssueClick$1 extends AbstractC12240o implements Function1<FeedbackIssue, Unit> {
    public static final FeedbackView$IssuesAdapter$onIssueClick$1 INSTANCE = new FeedbackView$IssuesAdapter$onIssueClick$1();

    public FeedbackView$IssuesAdapter$onIssueClick$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
        invoke2(feedbackIssue);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackIssue feedbackIssue) {
        C12238m.checkNotNullParameter(feedbackIssue, "<anonymous parameter 0>");
    }
}
