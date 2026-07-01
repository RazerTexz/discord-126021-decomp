package com.discord.widgets.voice.feedback.stream;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback$StreamFeedback;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StreamFeedbackSubmitter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback$StreamFeedback pendingStreamFeedback;

    public StreamFeedbackSubmitter(PendingFeedback$StreamFeedback pendingFeedback$StreamFeedback, StoreAnalytics storeAnalytics) {
        m.checkNotNullParameter(pendingFeedback$StreamFeedback, "pendingStreamFeedback");
        m.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingStreamFeedback = pendingFeedback$StreamFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback$StreamFeedback getPendingStreamFeedback() {
        return this.pendingStreamFeedback;
    }

    public final void setPendingStreamFeedback(PendingFeedback$StreamFeedback pendingFeedback$StreamFeedback) {
        m.checkNotNullParameter(pendingFeedback$StreamFeedback, "<set-?>");
        this.pendingStreamFeedback = pendingFeedback$StreamFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        this.analyticsStore.trackStreamReportProblem(issueDetails != null ? PendingFeedback$StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, null, null, issueDetails, 15, null) : this.pendingStreamFeedback);
    }

    public /* synthetic */ StreamFeedbackSubmitter(PendingFeedback$StreamFeedback pendingFeedback$StreamFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingFeedback$StreamFeedback, (i & 2) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics);
    }
}
