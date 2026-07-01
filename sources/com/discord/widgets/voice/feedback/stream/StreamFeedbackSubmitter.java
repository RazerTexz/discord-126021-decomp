package com.discord.widgets.voice.feedback.stream;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StreamFeedbackSubmitter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StreamFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback.StreamFeedback pendingStreamFeedback;

    public StreamFeedbackSubmitter(PendingFeedback.StreamFeedback streamFeedback, StoreAnalytics storeAnalytics) {
        Intrinsics3.checkNotNullParameter(streamFeedback, "pendingStreamFeedback");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingStreamFeedback = streamFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback.StreamFeedback getPendingStreamFeedback() {
        return this.pendingStreamFeedback;
    }

    public final void setPendingStreamFeedback(PendingFeedback.StreamFeedback streamFeedback) {
        Intrinsics3.checkNotNullParameter(streamFeedback, "<set-?>");
        this.pendingStreamFeedback = streamFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        this.analyticsStore.trackStreamReportProblem(issueDetails != null ? PendingFeedback.StreamFeedback.copy$default(this.pendingStreamFeedback, null, null, null, null, issueDetails, 15, null) : this.pendingStreamFeedback);
    }

    public /* synthetic */ StreamFeedbackSubmitter(PendingFeedback.StreamFeedback streamFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamFeedback, (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics);
    }
}
