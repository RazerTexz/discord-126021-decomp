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
import com.discord.C5419R;
import com.discord.databinding.FeedbackViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.voice.feedback.FeedbackView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(issuesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type android.widget.TextView");
            this.issueItem = (TextView) view;
        }

        public static final /* synthetic */ IssuesAdapter access$getAdapter$p(IssueViewHolder issueViewHolder) {
            return (IssuesAdapter) issueViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final FeedbackIssue data) {
            C12238m.checkNotNullParameter(data, "data");
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
            C12238m.checkNotNullParameter(recyclerView, "recyclerView");
            this.onIssueClick = FeedbackView$IssuesAdapter$onIssueClick$1.INSTANCE;
        }

        public final Function1<FeedbackIssue, Unit> getOnIssueClick() {
            return this.onIssueClick;
        }

        public final void setOnIssueClick(Function1<? super FeedbackIssue, Unit> function1) {
            C12238m.checkNotNullParameter(function1, "<set-?>");
            this.onIssueClick = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<IssuesAdapter, FeedbackIssue> onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            return new IssueViewHolder(C5419R.layout.selectable_list_item, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.feedback_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.feedback_happy_rating;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(C5419R.id.feedback_happy_rating);
        if (imageButton != null) {
            i = C5419R.id.feedback_issue_section_header;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.feedback_issue_section_header);
            if (textView != null) {
                i = C5419R.id.feedback_issues_card;
                CardView cardView = (CardView) viewInflate.findViewById(C5419R.id.feedback_issues_card);
                if (cardView != null) {
                    i = C5419R.id.feedback_issues_recycler;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(C5419R.id.feedback_issues_recycler);
                    if (recyclerView != null) {
                        i = C5419R.id.feedback_neutral_rating;
                        ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(C5419R.id.feedback_neutral_rating);
                        if (imageButton2 != null) {
                            i = C5419R.id.feedback_rating_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(C5419R.id.feedback_rating_container);
                            if (constraintLayout != null) {
                                i = C5419R.id.feedback_rating_summary_prompt;
                                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.feedback_rating_summary_prompt);
                                if (textView2 != null) {
                                    i = C5419R.id.feedback_sad_rating;
                                    ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.feedback_sad_rating);
                                    if (imageView != null) {
                                        FeedbackViewBinding feedbackViewBinding = new FeedbackViewBinding((LinearLayout) viewInflate, imageButton, textView, cardView, recyclerView, imageButton2, constraintLayout, textView2, imageView);
                                        C12238m.checkNotNullExpressionValue(feedbackViewBinding, "FeedbackViewBinding.infl…rom(context), this, true)");
                                        this.binding = feedbackViewBinding;
                                        this.viewToFeedbackRatingMap = C12136h0.mapOf(C12116o.m10073to(imageView, FeedbackRating.BAD), C12116o.m10073to(imageButton2, FeedbackRating.NEUTRAL), C12116o.m10073to(imageButton, FeedbackRating.GOOD));
                                        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
                                        C12238m.checkNotNullExpressionValue(recyclerView, "binding.feedbackIssuesRecycler");
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
        C12238m.checkNotNullParameter(selectedFeedbackRating, "selectedFeedbackRating");
        C12238m.checkNotNullParameter(onSadRatingClick, "onSadRatingClick");
        C12238m.checkNotNullParameter(onNeutralRatingClick, "onNeutralRatingClick");
        C12238m.checkNotNullParameter(onHappyRatingClick, "onHappyRatingClick");
        C12238m.checkNotNullParameter(issuesHeaderText, "issuesHeaderText");
        C12238m.checkNotNullParameter(feedbackIssues, "feedbackIssues");
        C12238m.checkNotNullParameter(onIssueClick, "onIssueClick");
        boolean z2 = ratingSummaryPromptText != null;
        ConstraintLayout constraintLayout = this.binding.f15073g;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.feedbackRatingContainer");
        constraintLayout.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.f15074h;
        C12238m.checkNotNullExpressionValue(textView, "binding.feedbackRatingSummaryPrompt");
        textView.setText(ratingSummaryPromptText);
        this.binding.f15075i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView.updateView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onSadRatingClick.invoke();
            }
        });
        this.binding.f15072f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView.updateView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onNeutralRatingClick.invoke();
            }
        });
        this.binding.f15068b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.FeedbackView.updateView.3
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
        TextView textView2 = this.binding.f15069c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.feedbackIssueSectionHeader");
        textView2.setText(issuesHeaderText);
        TextView textView3 = this.binding.f15069c;
        C12238m.checkNotNullExpressionValue(textView3, "binding.feedbackIssueSectionHeader");
        textView3.setVisibility(z3 ? 0 : 8);
        CardView cardView = this.binding.f15070d;
        C12238m.checkNotNullExpressionValue(cardView, "binding.feedbackIssuesCard");
        cardView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = this.binding.f15071e;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.feedbackIssuesRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        this.issuesAdapter.setOnIssueClick(onIssueClick);
        this.issuesAdapter.setData(feedbackIssues);
    }
}
