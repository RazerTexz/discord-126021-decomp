package com.discord.widgets.voice.feedback.stream;

import b.d.b.a.a;

/* JADX INFO: compiled from: StreamFeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StreamFeedbackSheetViewModel$StoreState {
    private final boolean shouldShowCxLinkForIssueDetails;

    public StreamFeedbackSheetViewModel$StoreState(boolean z2) {
        this.shouldShowCxLinkForIssueDetails = z2;
    }

    public static /* synthetic */ StreamFeedbackSheetViewModel$StoreState copy$default(StreamFeedbackSheetViewModel$StoreState streamFeedbackSheetViewModel$StoreState, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = streamFeedbackSheetViewModel$StoreState.shouldShowCxLinkForIssueDetails;
        }
        return streamFeedbackSheetViewModel$StoreState.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShouldShowCxLinkForIssueDetails() {
        return this.shouldShowCxLinkForIssueDetails;
    }

    public final StreamFeedbackSheetViewModel$StoreState copy(boolean shouldShowCxLinkForIssueDetails) {
        return new StreamFeedbackSheetViewModel$StoreState(shouldShowCxLinkForIssueDetails);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StreamFeedbackSheetViewModel$StoreState) && this.shouldShowCxLinkForIssueDetails == ((StreamFeedbackSheetViewModel$StoreState) other).shouldShowCxLinkForIssueDetails;
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
