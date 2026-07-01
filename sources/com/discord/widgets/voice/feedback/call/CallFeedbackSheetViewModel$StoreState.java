package com.discord.widgets.voice.feedback.call;

import b.d.b.a.a;

/* JADX INFO: compiled from: CallFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class CallFeedbackSheetViewModel$StoreState {
    private final boolean shouldShowCxLinkForIssueDetails;

    public CallFeedbackSheetViewModel$StoreState(boolean z2) {
        this.shouldShowCxLinkForIssueDetails = z2;
    }

    public static /* synthetic */ CallFeedbackSheetViewModel$StoreState copy$default(CallFeedbackSheetViewModel$StoreState callFeedbackSheetViewModel$StoreState, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = callFeedbackSheetViewModel$StoreState.shouldShowCxLinkForIssueDetails;
        }
        return callFeedbackSheetViewModel$StoreState.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldShowCxLinkForIssueDetails() {
        return this.shouldShowCxLinkForIssueDetails;
    }

    public final CallFeedbackSheetViewModel$StoreState copy(boolean shouldShowCxLinkForIssueDetails) {
        return new CallFeedbackSheetViewModel$StoreState(shouldShowCxLinkForIssueDetails);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof CallFeedbackSheetViewModel$StoreState) && this.shouldShowCxLinkForIssueDetails == ((CallFeedbackSheetViewModel$StoreState) other).shouldShowCxLinkForIssueDetails;
        }
        return true;
    }

    public final boolean getShouldShowCxLinkForIssueDetails() {
        return this.shouldShowCxLinkForIssueDetails;
    }

    public int hashCode() {
        boolean z2 = this.shouldShowCxLinkForIssueDetails;
        if (z2) {
            return 1;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return a.O(a.U("StoreState(shouldShowCxLinkForIssueDetails="), this.shouldShowCxLinkForIssueDetails, ")");
    }
}
