package com.discord.widgets.feedback;

import b.d.b.a.a;

/* JADX INFO: compiled from: FeedbackSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FeedbackSheetViewModel$Event$Submitted extends FeedbackSheetViewModel$Event {
    private final boolean showConfirmation;

    public FeedbackSheetViewModel$Event$Submitted(boolean z2) {
        super(null);
        this.showConfirmation = z2;
    }

    public static /* synthetic */ FeedbackSheetViewModel$Event$Submitted copy$default(FeedbackSheetViewModel$Event$Submitted feedbackSheetViewModel$Event$Submitted, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = feedbackSheetViewModel$Event$Submitted.showConfirmation;
        }
        return feedbackSheetViewModel$Event$Submitted.copy(z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getShowConfirmation() {
        return this.showConfirmation;
    }

    public final FeedbackSheetViewModel$Event$Submitted copy(boolean showConfirmation) {
        return new FeedbackSheetViewModel$Event$Submitted(showConfirmation);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FeedbackSheetViewModel$Event$Submitted) && this.showConfirmation == ((FeedbackSheetViewModel$Event$Submitted) other).showConfirmation;
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
        return a.O(a.U("Submitted(showConfirmation="), this.showConfirmation, ")");
    }
}
