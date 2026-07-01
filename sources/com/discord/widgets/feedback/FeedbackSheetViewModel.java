package com.discord.widgets.feedback;

import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.widgets.voice.feedback.FeedbackIssue;
import com.discord.widgets.voice.feedback.FeedbackRating;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface FeedbackSheetViewModel {

    /* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
    public static final class DefaultImpls {
        public static void selectRating(FeedbackSheetViewModel feedbackSheetViewModel, FeedbackRating feedbackRating) {
            Intrinsics3.checkNotNullParameter(feedbackRating, "feedbackRating");
        }
    }

    /* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
        public static final /* data */ class NavigateToIssueDetails extends Event {
            private final PendingFeedback pendingFeedback;
            private final boolean showCxLinkForIssueDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToIssueDetails(PendingFeedback pendingFeedback, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
                this.pendingFeedback = pendingFeedback;
                this.showCxLinkForIssueDetails = z2;
            }

            public static /* synthetic */ NavigateToIssueDetails copy$default(NavigateToIssueDetails navigateToIssueDetails, PendingFeedback pendingFeedback, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    pendingFeedback = navigateToIssueDetails.pendingFeedback;
                }
                if ((i & 2) != 0) {
                    z2 = navigateToIssueDetails.showCxLinkForIssueDetails;
                }
                return navigateToIssueDetails.copy(pendingFeedback, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PendingFeedback getPendingFeedback() {
                return this.pendingFeedback;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowCxLinkForIssueDetails() {
                return this.showCxLinkForIssueDetails;
            }

            public final NavigateToIssueDetails copy(PendingFeedback pendingFeedback, boolean showCxLinkForIssueDetails) {
                Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
                return new NavigateToIssueDetails(pendingFeedback, showCxLinkForIssueDetails);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigateToIssueDetails)) {
                    return false;
                }
                NavigateToIssueDetails navigateToIssueDetails = (NavigateToIssueDetails) other;
                return Intrinsics3.areEqual(this.pendingFeedback, navigateToIssueDetails.pendingFeedback) && this.showCxLinkForIssueDetails == navigateToIssueDetails.showCxLinkForIssueDetails;
            }

            public final PendingFeedback getPendingFeedback() {
                return this.pendingFeedback;
            }

            public final boolean getShowCxLinkForIssueDetails() {
                return this.showCxLinkForIssueDetails;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                PendingFeedback pendingFeedback = this.pendingFeedback;
                int iHashCode = (pendingFeedback != null ? pendingFeedback.hashCode() : 0) * 31;
                boolean z2 = this.showCxLinkForIssueDetails;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("NavigateToIssueDetails(pendingFeedback=");
                sbU.append(this.pendingFeedback);
                sbU.append(", showCxLinkForIssueDetails=");
                return outline.O(sbU, this.showCxLinkForIssueDetails, ")");
            }
        }

        /* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
        public static final /* data */ class Submitted extends Event {
            private final boolean showConfirmation;

            public Submitted(boolean z2) {
                super(null);
                this.showConfirmation = z2;
            }

            public static /* synthetic */ Submitted copy$default(Submitted submitted, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = submitted.showConfirmation;
                }
                return submitted.copy(z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getShowConfirmation() {
                return this.showConfirmation;
            }

            public final Submitted copy(boolean showConfirmation) {
                return new Submitted(showConfirmation);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Submitted) && this.showConfirmation == ((Submitted) other).showConfirmation;
                }
                return true;
            }

            public final boolean getShowConfirmation() {
                return this.showConfirmation;
            }

            public int hashCode() {
                boolean z2 = this.showConfirmation;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return outline.O(outline.U("Submitted(showConfirmation="), this.showConfirmation, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Observable<Event> observeEvents();

    Observable<ViewState> observeViewState();

    void selectIssue(FeedbackIssue feedbackIssue, String reasonDescription);

    void selectRating(FeedbackRating feedbackRating);

    void submitForm();

    /* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<FeedbackIssue> feedbackIssues;
        private final int issuesHeaderTextResId;
        private final Integer promptTextResId;
        private final FeedbackRating selectedFeedbackRating;
        private final boolean showFaceRatings;
        private final int titleTextResId;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(FeedbackRating feedbackRating, List<? extends FeedbackIssue> list, @StringRes int i, @StringRes Integer num, @StringRes int i2) {
            Intrinsics3.checkNotNullParameter(feedbackRating, "selectedFeedbackRating");
            Intrinsics3.checkNotNullParameter(list, "feedbackIssues");
            this.selectedFeedbackRating = feedbackRating;
            this.feedbackIssues = list;
            this.titleTextResId = i;
            this.promptTextResId = num;
            this.issuesHeaderTextResId = i2;
            this.showFaceRatings = num != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, FeedbackRating feedbackRating, List list, int i, Integer num, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                feedbackRating = viewState.selectedFeedbackRating;
            }
            if ((i3 & 2) != 0) {
                list = viewState.feedbackIssues;
            }
            List list2 = list;
            if ((i3 & 4) != 0) {
                i = viewState.titleTextResId;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                num = viewState.promptTextResId;
            }
            Integer num2 = num;
            if ((i3 & 16) != 0) {
                i2 = viewState.issuesHeaderTextResId;
            }
            return viewState.copy(feedbackRating, list2, i4, num2, i2);
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

        public final ViewState copy(FeedbackRating selectedFeedbackRating, List<? extends FeedbackIssue> feedbackIssues, @StringRes int titleTextResId, @StringRes Integer promptTextResId, @StringRes int issuesHeaderTextResId) {
            Intrinsics3.checkNotNullParameter(selectedFeedbackRating, "selectedFeedbackRating");
            Intrinsics3.checkNotNullParameter(feedbackIssues, "feedbackIssues");
            return new ViewState(selectedFeedbackRating, feedbackIssues, titleTextResId, promptTextResId, issuesHeaderTextResId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedFeedbackRating, viewState.selectedFeedbackRating) && Intrinsics3.areEqual(this.feedbackIssues, viewState.feedbackIssues) && this.titleTextResId == viewState.titleTextResId && Intrinsics3.areEqual(this.promptTextResId, viewState.promptTextResId) && this.issuesHeaderTextResId == viewState.issuesHeaderTextResId;
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
            StringBuilder sbU = outline.U("ViewState(selectedFeedbackRating=");
            sbU.append(this.selectedFeedbackRating);
            sbU.append(", feedbackIssues=");
            sbU.append(this.feedbackIssues);
            sbU.append(", titleTextResId=");
            sbU.append(this.titleTextResId);
            sbU.append(", promptTextResId=");
            sbU.append(this.promptTextResId);
            sbU.append(", issuesHeaderTextResId=");
            return outline.B(sbU, this.issuesHeaderTextResId, ")");
        }

        public /* synthetic */ ViewState(FeedbackRating feedbackRating, List list, int i, Integer num, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(feedbackRating, list, i, (i3 & 8) != 0 ? null : num, i2);
        }
    }
}
