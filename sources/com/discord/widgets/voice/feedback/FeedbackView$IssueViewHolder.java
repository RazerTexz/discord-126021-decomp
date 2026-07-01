package com.discord.widgets.voice.feedback;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView$IssueViewHolder extends MGRecyclerViewHolder<FeedbackView$IssuesAdapter, FeedbackIssue> {
    private final TextView issueItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackView$IssueViewHolder(@LayoutRes int i, FeedbackView$IssuesAdapter feedbackView$IssuesAdapter) {
        super(i, feedbackView$IssuesAdapter);
        m.checkNotNullParameter(feedbackView$IssuesAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
        this.issueItem = (TextView) view;
    }

    public static final /* synthetic */ FeedbackView$IssuesAdapter access$getAdapter$p(FeedbackView$IssueViewHolder feedbackView$IssueViewHolder) {
        return (FeedbackView$IssuesAdapter) feedbackView$IssueViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, FeedbackIssue feedbackIssue) {
        onConfigure2(i, feedbackIssue);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, FeedbackIssue data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        TextView textView = this.issueItem;
        textView.setText(textView.getResources().getString(data.getReasonStringRes()));
        this.issueItem.setOnClickListener(new FeedbackView$IssueViewHolder$onConfigure$1(this, data));
    }
}
