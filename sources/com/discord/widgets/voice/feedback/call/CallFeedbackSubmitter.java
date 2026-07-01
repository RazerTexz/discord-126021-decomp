package com.discord.widgets.voice.feedback.call;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback$CallFeedback;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: CallFeedbackSubmitter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback$CallFeedback pendingCallFeedback;

    public CallFeedbackSubmitter(PendingFeedback$CallFeedback pendingFeedback$CallFeedback, StoreAnalytics storeAnalytics) {
        m.checkNotNullParameter(pendingFeedback$CallFeedback, "pendingCallFeedback");
        m.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingCallFeedback = pendingFeedback$CallFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback$CallFeedback getPendingCallFeedback() {
        return this.pendingCallFeedback;
    }

    public final void setPendingCallFeedback(PendingFeedback$CallFeedback pendingFeedback$CallFeedback) {
        m.checkNotNullParameter(pendingFeedback$CallFeedback, "<set-?>");
        this.pendingCallFeedback = pendingFeedback$CallFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        this.analyticsStore.trackCallReportProblem(issueDetails != null ? PendingFeedback$CallFeedback.copy$default(this.pendingCallFeedback, 0L, null, null, null, null, null, null, issueDetails, Opcodes.LAND, null) : this.pendingCallFeedback);
    }

    public /* synthetic */ CallFeedbackSubmitter(PendingFeedback$CallFeedback pendingFeedback$CallFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendingFeedback$CallFeedback, (i & 2) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics);
    }
}
