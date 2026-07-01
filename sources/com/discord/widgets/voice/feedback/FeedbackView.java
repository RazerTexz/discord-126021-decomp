package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.FeedbackViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.voice.feedback.FeedbackView;
import d0.Tuples;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView extends LinearLayout {
    private final FeedbackViewBinding binding;
    private final IssuesAdapter issuesAdapter;
    private final Map<View, FeedbackRating> viewToFeedbackRatingMap;

    /* JADX INFO: compiled from: FeedbackView.kt */
    public static final class IssueViewHolder extends MGRecyclerViewHolder<IssuesAdapter, FeedbackIssue> {
        private final TextView issueItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IssueViewHolder(@LayoutRes int i, IssuesAdapter issuesAdapter) {
            super(i, issuesAdapter);
            Intrinsics3.checkNotNullParameter(issuesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.issueItem = (TextView) view;
        }

        public static final /* synthetic */ IssuesAdapter access$getAdapter$p(IssueViewHolder issueViewHolder) {
            return (IssuesAdapter) issueViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final FeedbackIssue data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.issueItem;
            textView.setText(textView.getResources().getString(data.getReasonStringRes()));
            this.issueItem.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView$IssueViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedbackView.IssueViewHolder.access$getAdapter$p(this.this$0).getOnIssueClick().invoke(data);
                }
            });
        }
    }

    /* JADX INFO: compiled from: FeedbackView.kt */
    public static final class IssuesAdapter extends MGRecyclerAdapterSimple<FeedbackIssue> {
        private Function1<? super FeedbackIssue, Unit> onIssueClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IssuesAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            this.onIssueClick = FeedbackView3.INSTANCE;
        }

        public final Function1<FeedbackIssue, Unit> getOnIssueClick() {
            return this.onIssueClick;
        }

        public final void setOnIssueClick(Function1<? super FeedbackIssue, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            this.onIssueClick = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<IssuesAdapter, FeedbackIssue> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new IssueViewHolder(R.layout.selectable_list_item, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.feedback_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.feedback_happy_rating;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.feedback_happy_rating);
        if (imageButton != null) {
            i = R.id.feedback_issue_section_header;
            TextView textView = (TextView) viewInflate.findViewById(R.id.feedback_issue_section_header);
            if (textView != null) {
                i = R.id.feedback_issues_card;
                CardView cardView = (CardView) viewInflate.findViewById(R.id.feedback_issues_card);
                if (cardView != null) {
                    i = R.id.feedback_issues_recycler;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.feedback_issues_recycler);
                    if (recyclerView != null) {
                        i = R.id.feedback_neutral_rating;
                        ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(R.id.feedback_neutral_rating);
                        if (imageButton2 != null) {
                            i = R.id.feedback_rating_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R.id.feedback_rating_container);
                            if (constraintLayout != null) {
                                i = R.id.feedback_rating_summary_prompt;
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.feedback_rating_summary_prompt);
                                if (textView2 != null) {
                                    i = R.id.feedback_sad_rating;
                                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.feedback_sad_rating);
                                    if (imageView != null) {
                                        FeedbackViewBinding feedbackViewBinding = new FeedbackViewBinding((LinearLayout) viewInflate, imageButton, textView, cardView, recyclerView, imageButton2, constraintLayout, textView2, imageView);
                                        Intrinsics3.checkNotNullExpressionValue(feedbackViewBinding, "FeedbackViewBinding.infl…rom(context), this, true)");
                                        this.binding = feedbackViewBinding;
                                        this.viewToFeedbackRatingMap = Maps6.mapOf(Tuples.to(imageView, FeedbackRating.BAD), Tuples.to(imageButton2, FeedbackRating.NEUTRAL), Tuples.to(imageButton, FeedbackRating.GOOD));
                                        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                                        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.feedbackIssuesRecycler");
                                        this.issuesAdapter = (IssuesAdapter) companion.configure(new IssuesAdapter(recyclerView));
                                        recyclerView.setHasFixedSize(false);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void updateView(String ratingSummaryPromptText, FeedbackRating selectedFeedbackRating, final Function0<Unit> onSadRatingClick, final Function0<Unit> onNeutralRatingClick, final Function0<Unit> onHappyRatingClick, String issuesHeaderText, List<? extends FeedbackIssue> feedbackIssues, Function1<? super FeedbackIssue, Unit> onIssueClick) {
        Intrinsics3.checkNotNullParameter(selectedFeedbackRating, "selectedFeedbackRating");
        Intrinsics3.checkNotNullParameter(onSadRatingClick, "onSadRatingClick");
        Intrinsics3.checkNotNullParameter(onNeutralRatingClick, "onNeutralRatingClick");
        Intrinsics3.checkNotNullParameter(onHappyRatingClick, "onHappyRatingClick");
        Intrinsics3.checkNotNullParameter(issuesHeaderText, "issuesHeaderText");
        Intrinsics3.checkNotNullParameter(feedbackIssues, "feedbackIssues");
        Intrinsics3.checkNotNullParameter(onIssueClick, "onIssueClick");
        boolean z2 = ratingSummaryPromptText != null;
        ConstraintLayout constraintLayout = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.feedbackRatingContainer");
        constraintLayout.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.feedbackRatingSummaryPrompt");
        textView.setText(ratingSummaryPromptText);
        this.binding.i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView.updateView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSadRatingClick.invoke();
            }
        });
        this.binding.f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView.updateView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onNeutralRatingClick.invoke();
            }
        });
        this.binding.f2106b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView.updateView.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onHappyRatingClick.invoke();
            }
        });
        Iterator<T> it = this.viewToFeedbackRatingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((View) entry.getKey()).setSelected(selectedFeedbackRating == ((FeedbackRating) entry.getValue()));
        }
        boolean z3 = !feedbackIssues.isEmpty();
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.feedbackIssueSectionHeader");
        textView2.setText(issuesHeaderText);
        TextView textView3 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.feedbackIssueSectionHeader");
        textView3.setVisibility(z3 ? 0 : 8);
        CardView cardView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.feedbackIssuesCard");
        cardView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.feedbackIssuesRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        this.issuesAdapter.setOnIssueClick(onIssueClick);
        this.issuesAdapter.setData(feedbackIssues);
    }
}
