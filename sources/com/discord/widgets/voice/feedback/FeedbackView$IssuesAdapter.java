package com.discord.widgets.voice.feedback;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView$IssuesAdapter extends MGRecyclerAdapterSimple<FeedbackIssue> {
    private Function1<? super FeedbackIssue, Unit> onIssueClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackView$IssuesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        this.onIssueClick = FeedbackView$IssuesAdapter$onIssueClick$1.INSTANCE;
    }

    public final Function1<FeedbackIssue, Unit> getOnIssueClick() {
        return this.onIssueClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnIssueClick(Function1<? super FeedbackIssue, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onIssueClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<FeedbackView$IssuesAdapter, FeedbackIssue> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new FeedbackView$IssueViewHolder(R$layout.selectable_list_item, this);
    }
}
