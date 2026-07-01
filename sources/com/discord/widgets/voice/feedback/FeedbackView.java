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
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.FeedbackViewBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView extends LinearLayout {
    private final FeedbackViewBinding binding;
    private final FeedbackView$IssuesAdapter issuesAdapter;
    private final Map<View, FeedbackRating> viewToFeedbackRatingMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.feedback_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.feedback_happy_rating;
        ImageButton imageButton = (ImageButton) viewInflate.findViewById(R$id.feedback_happy_rating);
        if (imageButton != null) {
            i = R$id.feedback_issue_section_header;
            TextView textView = (TextView) viewInflate.findViewById(R$id.feedback_issue_section_header);
            if (textView != null) {
                i = R$id.feedback_issues_card;
                CardView cardView = (CardView) viewInflate.findViewById(R$id.feedback_issues_card);
                if (cardView != null) {
                    i = R$id.feedback_issues_recycler;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.feedback_issues_recycler);
                    if (recyclerView != null) {
                        i = R$id.feedback_neutral_rating;
                        ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(R$id.feedback_neutral_rating);
                        if (imageButton2 != null) {
                            i = R$id.feedback_rating_container;
                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate.findViewById(R$id.feedback_rating_container);
                            if (constraintLayout != null) {
                                i = R$id.feedback_rating_summary_prompt;
                                TextView textView2 = (TextView) viewInflate.findViewById(R$id.feedback_rating_summary_prompt);
                                if (textView2 != null) {
                                    i = R$id.feedback_sad_rating;
                                    ImageView imageView = (ImageView) viewInflate.findViewById(R$id.feedback_sad_rating);
                                    if (imageView != null) {
                                        FeedbackViewBinding feedbackViewBinding = new FeedbackViewBinding((LinearLayout) viewInflate, imageButton, textView, cardView, recyclerView, imageButton2, constraintLayout, textView2, imageView);
                                        m.checkNotNullExpressionValue(feedbackViewBinding, "FeedbackViewBinding.infl…rom(context), this, true)");
                                        this.binding = feedbackViewBinding;
                                        this.viewToFeedbackRatingMap = h0.mapOf(o.to(imageView, FeedbackRating.BAD), o.to(imageButton2, FeedbackRating.NEUTRAL), o.to(imageButton, FeedbackRating.GOOD));
                                        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
                                        m.checkNotNullExpressionValue(recyclerView, "binding.feedbackIssuesRecycler");
                                        this.issuesAdapter = (FeedbackView$IssuesAdapter) mGRecyclerAdapter$Companion.configure(new FeedbackView$IssuesAdapter(recyclerView));
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

    public final void updateView(String ratingSummaryPromptText, FeedbackRating selectedFeedbackRating, Function0<Unit> onSadRatingClick, Function0<Unit> onNeutralRatingClick, Function0<Unit> onHappyRatingClick, String issuesHeaderText, List<? extends FeedbackIssue> feedbackIssues, Function1<? super FeedbackIssue, Unit> onIssueClick) {
        m.checkNotNullParameter(selectedFeedbackRating, "selectedFeedbackRating");
        m.checkNotNullParameter(onSadRatingClick, "onSadRatingClick");
        m.checkNotNullParameter(onNeutralRatingClick, "onNeutralRatingClick");
        m.checkNotNullParameter(onHappyRatingClick, "onHappyRatingClick");
        m.checkNotNullParameter(issuesHeaderText, "issuesHeaderText");
        m.checkNotNullParameter(feedbackIssues, "feedbackIssues");
        m.checkNotNullParameter(onIssueClick, "onIssueClick");
        boolean z2 = ratingSummaryPromptText != null;
        ConstraintLayout constraintLayout = this.binding.g;
        m.checkNotNullExpressionValue(constraintLayout, "binding.feedbackRatingContainer");
        constraintLayout.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.feedbackRatingSummaryPrompt");
        textView.setText(ratingSummaryPromptText);
        this.binding.i.setOnClickListener(new FeedbackView$updateView$1(onSadRatingClick));
        this.binding.f.setOnClickListener(new FeedbackView$updateView$2(onNeutralRatingClick));
        this.binding.f2106b.setOnClickListener(new FeedbackView$updateView$3(onHappyRatingClick));
        Iterator<T> it = this.viewToFeedbackRatingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            ((View) map$Entry.getKey()).setSelected(selectedFeedbackRating == ((FeedbackRating) map$Entry.getValue()));
        }
        boolean z3 = !feedbackIssues.isEmpty();
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.feedbackIssueSectionHeader");
        textView2.setText(issuesHeaderText);
        TextView textView3 = this.binding.c;
        m.checkNotNullExpressionValue(textView3, "binding.feedbackIssueSectionHeader");
        textView3.setVisibility(z3 ? 0 : 8);
        CardView cardView = this.binding.d;
        m.checkNotNullExpressionValue(cardView, "binding.feedbackIssuesCard");
        cardView.setVisibility(z3 ? 0 : 8);
        RecyclerView recyclerView = this.binding.e;
        m.checkNotNullExpressionValue(recyclerView, "binding.feedbackIssuesRecycler");
        recyclerView.setVisibility(z3 ? 0 : 8);
        this.issuesAdapter.setOnIssueClick(onIssueClick);
        this.issuesAdapter.setData(feedbackIssues);
    }
}
