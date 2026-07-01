package com.discord.widgets.voice.feedback;

import com.discord.stores.StoreAnalytics;
import com.discord.widgets.guild_delete_feedback.GuildDeleteFeedbackSubmitter;
import com.discord.widgets.voice.feedback.PendingFeedback;
import com.discord.widgets.voice.feedback.call.CallFeedbackSubmitter;
import com.discord.widgets.voice.feedback.stream.StreamFeedbackSubmitter;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: FeedbackSubmitterFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackSubmitterFactory {
    public static final FeedbackSubmitterFactory INSTANCE = new FeedbackSubmitterFactory();

    private FeedbackSubmitterFactory() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final FeedbackSubmitter create(PendingFeedback pendingFeedback) {
        Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        int i = 2;
        StoreAnalytics storeAnalytics = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (pendingFeedback instanceof PendingFeedback.CallFeedback) {
            return new CallFeedbackSubmitter((PendingFeedback.CallFeedback) pendingFeedback, storeAnalytics, i, objArr3 == true ? 1 : 0);
        }
        if (pendingFeedback instanceof PendingFeedback.StreamFeedback) {
            return new StreamFeedbackSubmitter((PendingFeedback.StreamFeedback) pendingFeedback, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        if (pendingFeedback instanceof PendingFeedback.GuildDeleteFeedback) {
            return new GuildDeleteFeedbackSubmitter((PendingFeedback.GuildDeleteFeedback) pendingFeedback);
        }
        throw new NoWhenBranchMatchedException();
    }
}
