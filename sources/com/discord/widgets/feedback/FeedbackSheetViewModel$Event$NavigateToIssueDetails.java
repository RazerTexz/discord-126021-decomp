package com.discord.widgets.feedback;

import b.d.b.a.a;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.m;

/* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FeedbackSheetViewModel$Event$NavigateToIssueDetails extends FeedbackSheetViewModel$Event {
    private final PendingFeedback pendingFeedback;
    private final boolean showCxLinkForIssueDetails;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackSheetViewModel$Event$NavigateToIssueDetails(PendingFeedback pendingFeedback, boolean z2) {
        super(null);
        m.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        this.pendingFeedback = pendingFeedback;
        this.showCxLinkForIssueDetails = z2;
    }

    public static /* synthetic */ FeedbackSheetViewModel$Event$NavigateToIssueDetails copy$default(FeedbackSheetViewModel$Event$NavigateToIssueDetails feedbackSheetViewModel$Event$NavigateToIssueDetails, PendingFeedback pendingFeedback, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            pendingFeedback = feedbackSheetViewModel$Event$NavigateToIssueDetails.pendingFeedback;
        }
        if ((i & 2) != 0) {
            z2 = feedbackSheetViewModel$Event$NavigateToIssueDetails.showCxLinkForIssueDetails;
        }
        return feedbackSheetViewModel$Event$NavigateToIssueDetails.copy(pendingFeedback, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PendingFeedback getPendingFeedback() {
        return this.pendingFeedback;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getShowCxLinkForIssueDetails() {
        return this.showCxLinkForIssueDetails;
    }

    public final FeedbackSheetViewModel$Event$NavigateToIssueDetails copy(PendingFeedback pendingFeedback, boolean showCxLinkForIssueDetails) {
        m.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        return new FeedbackSheetViewModel$Event$NavigateToIssueDetails(pendingFeedback, showCxLinkForIssueDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedbackSheetViewModel$Event$NavigateToIssueDetails)) {
            return false;
        }
        FeedbackSheetViewModel$Event$NavigateToIssueDetails feedbackSheetViewModel$Event$NavigateToIssueDetails = (FeedbackSheetViewModel$Event$NavigateToIssueDetails) other;
        return m.areEqual(this.pendingFeedback, feedbackSheetViewModel$Event$NavigateToIssueDetails.pendingFeedback) && this.showCxLinkForIssueDetails == feedbackSheetViewModel$Event$NavigateToIssueDetails.showCxLinkForIssueDetails;
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
        StringBuilder sbU = a.U("NavigateToIssueDetails(pendingFeedback=");
        sbU.append(this.pendingFeedback);
        sbU.append(", showCxLinkForIssueDetails=");
        return a.O(sbU, this.showCxLinkForIssueDetails, ")");
    }
}
