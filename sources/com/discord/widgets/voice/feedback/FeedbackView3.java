package com.discord.widgets.voice.feedback;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.voice.feedback.FeedbackView$IssuesAdapter$onIssueClick$1, reason: use source file name */
/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView3 extends Lambda implements Function1<FeedbackIssue, Unit> {
    public static final FeedbackView3 INSTANCE = new FeedbackView3();

    public FeedbackView3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackIssue feedbackIssue) {
        invoke2(feedbackIssue);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackIssue feedbackIssue) {
        Intrinsics3.checkNotNullParameter(feedbackIssue, "<anonymous parameter 0>");
    }
}
