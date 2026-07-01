package com.discord.widgets.voice.feedback.call;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.widgets.voice.feedback.FeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: CallFeedbackSubmitter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallFeedbackSubmitter implements FeedbackSubmitter {
    private final StoreAnalytics analyticsStore;
    private PendingFeedback.CallFeedback pendingCallFeedback;

    public CallFeedbackSubmitter(PendingFeedback.CallFeedback callFeedback, StoreAnalytics storeAnalytics) {
        Intrinsics3.checkNotNullParameter(callFeedback, "pendingCallFeedback");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        this.pendingCallFeedback = callFeedback;
        this.analyticsStore = storeAnalytics;
    }

    public final PendingFeedback.CallFeedback getPendingCallFeedback() {
        return this.pendingCallFeedback;
    }

    public final void setPendingCallFeedback(PendingFeedback.CallFeedback callFeedback) {
        Intrinsics3.checkNotNullParameter(callFeedback, "<set-?>");
        this.pendingCallFeedback = callFeedback;
    }

    @Override // com.discord.widgets.voice.feedback.FeedbackSubmitter
    public void submit(String issueDetails) {
        PendingFeedback.CallFeedback callFeedbackCopy;
        if (issueDetails != null) {
            PendingFeedback.CallFeedback callFeedback = this.pendingCallFeedback;
            callFeedbackCopy = callFeedback.copy((Opcodes.IF_ICMPEQ & 1) != 0 ? callFeedback.channelId : 0L, (Opcodes.IF_ICMPEQ & 2) != 0 ? callFeedback.rtcConnectionId : null, (Opcodes.IF_ICMPEQ & 4) != 0 ? callFeedback.durationMs : null, (Opcodes.IF_ICMPEQ & 8) != 0 ? callFeedback.mediaSessionId : null, (Opcodes.IF_ICMPEQ & 16) != 0 ? callFeedback.feedbackRating : null, (Opcodes.IF_ICMPEQ & 32) != 0 ? callFeedback.reasonCode : null, (Opcodes.IF_ICMPEQ & 64) != 0 ? callFeedback.reasonDescription : null, (Opcodes.IF_ICMPEQ & 128) != 0 ? callFeedback.issueDetails : issueDetails);
        } else {
            callFeedbackCopy = this.pendingCallFeedback;
        }
        this.analyticsStore.trackCallReportProblem(callFeedbackCopy);
    }

    public /* synthetic */ CallFeedbackSubmitter(PendingFeedback.CallFeedback callFeedback, StoreAnalytics storeAnalytics, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(callFeedback, (i & 2) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics);
    }
}
