package com.discord.widgets.feedback;

import androidx.annotation.StringRes;
import b.d.b.a.a;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FeedbackSheetViewModel$ViewState {
    private final List<FeedbackIssue> feedbackIssues;
    private final int issuesHeaderTextResId;
    private final Integer promptTextResId;
    private final FeedbackRating selectedFeedbackRating;
    private final boolean showFaceRatings;
    private final int titleTextResId;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedbackSheetViewModel$ViewState(FeedbackRating feedbackRating, List<? extends FeedbackIssue> list, @StringRes int i, @StringRes Integer num, @StringRes int i2) {
        m.checkNotNullParameter(feedbackRating, "selectedFeedbackRating");
        m.checkNotNullParameter(list, "feedbackIssues");
        this.selectedFeedbackRating = feedbackRating;
        this.feedbackIssues = list;
        this.titleTextResId = i;
        this.promptTextResId = num;
        this.issuesHeaderTextResId = i2;
        this.showFaceRatings = num != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeedbackSheetViewModel$ViewState copy$default(FeedbackSheetViewModel$ViewState feedbackSheetViewModel$ViewState, FeedbackRating feedbackRating, List list, int i, Integer num, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            feedbackRating = feedbackSheetViewModel$ViewState.selectedFeedbackRating;
        }
        if ((i3 & 2) != 0) {
            list = feedbackSheetViewModel$ViewState.feedbackIssues;
        }
        List list2 = list;
        if ((i3 & 4) != 0) {
            i = feedbackSheetViewModel$ViewState.titleTextResId;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            num = feedbackSheetViewModel$ViewState.promptTextResId;
        }
        Integer num2 = num;
        if ((i3 & 16) != 0) {
            i2 = feedbackSheetViewModel$ViewState.issuesHeaderTextResId;
        }
        return feedbackSheetViewModel$ViewState.copy(feedbackRating, list2, i4, num2, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final FeedbackRating getSelectedFeedbackRating() {
        return this.selectedFeedbackRating;
    }

    public final List<FeedbackIssue> component2() {
        return this.feedbackIssues;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTitleTextResId() {
        return this.titleTextResId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getPromptTextResId() {
        return this.promptTextResId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getIssuesHeaderTextResId() {
        return this.issuesHeaderTextResId;
    }

    public final FeedbackSheetViewModel$ViewState copy(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues, @StringRes int titleTextResId, @StringRes Integer promptTextResId, @StringRes int issuesHeaderTextResId) {
        m.checkNotNullParameter(selectedFeedbackRating, "selectedFeedbackRating");
        m.checkNotNullParameter(feedbackIssues, "feedbackIssues");
        return new FeedbackSheetViewModel$ViewState(selectedFeedbackRating, feedbackIssues, titleTextResId, promptTextResId, issuesHeaderTextResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackSheetViewModel$ViewState)) {
            return false;
        }
        FeedbackSheetViewModel$ViewState feedbackSheetViewModel$ViewState = (FeedbackSheetViewModel$ViewState) other;
        return m.areEqual(this.selectedFeedbackRating, feedbackSheetViewModel$ViewState.selectedFeedbackRating) && m.areEqual(this.feedbackIssues, feedbackSheetViewModel$ViewState.feedbackIssues) && this.titleTextResId == feedbackSheetViewModel$ViewState.titleTextResId && m.areEqual(this.promptTextResId, feedbackSheetViewModel$ViewState.promptTextResId) && this.issuesHeaderTextResId == feedbackSheetViewModel$ViewState.issuesHeaderTextResId;
    }

    public final List<FeedbackIssue> getFeedbackIssues() {
        return this.feedbackIssues;
    }

    public final int getIssuesHeaderTextResId() {
        return this.issuesHeaderTextResId;
    }

    public final Integer getPromptTextResId() {
        return this.promptTextResId;
    }

    public final FeedbackRating getSelectedFeedbackRating() {
        return this.selectedFeedbackRating;
    }

    public final boolean getShowFaceRatings() {
        return this.showFaceRatings;
    }

    public final int getTitleTextResId() {
        return this.titleTextResId;
    }

    public int hashCode() {
        FeedbackRating feedbackRating = this.selectedFeedbackRating;
        int iHashCode = (feedbackRating != null ? feedbackRating.hashCode() : 0) * 31;
        List<FeedbackIssue> list = this.feedbackIssues;
        int iHashCode2 = (((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.titleTextResId) * 31;
        Integer num = this.promptTextResId;
        return ((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.issuesHeaderTextResId;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(selectedFeedbackRating=");
        sbU.append(this.selectedFeedbackRating);
        sbU.append(", feedbackIssues=");
        sbU.append(this.feedbackIssues);
        sbU.append(", titleTextResId=");
        sbU.append(this.titleTextResId);
        sbU.append(", promptTextResId=");
        sbU.append(this.promptTextResId);
        sbU.append(", issuesHeaderTextResId=");
        return a.B(sbU, this.issuesHeaderTextResId, ")");
    }

    public /* synthetic */ FeedbackSheetViewModel$ViewState(FeedbackRating feedbackRating, List list, int i, Integer num, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(feedbackRating, list, i, (i3 & 8) != 0 ? null : num, i2);
    }
}
