package com.discord.widgets.voice.feedback;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView$IssueViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ FeedbackIssue $data;
    public final /* synthetic */ FeedbackView$IssueViewHolder this$0;

    public FeedbackView$IssueViewHolder$onConfigure$1(FeedbackView$IssueViewHolder feedbackView$IssueViewHolder, FeedbackIssue feedbackIssue) {
        this.this$0 = feedbackView$IssueViewHolder;
        this.$data = feedbackIssue;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FeedbackView$IssueViewHolder.access$getAdapter$p(this.this$0).getOnIssueClick().invoke(this.$data);
    }
}
