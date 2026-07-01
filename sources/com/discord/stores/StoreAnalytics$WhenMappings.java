package com.discord.stores;

import com.discord.widgets.voice.feedback.FeedbackIssue;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreAnalytics$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        FeedbackIssue.values();
        int[] iArr = new int[24];
        $EnumSwitchMapping$0 = iArr;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_BLACK.ordinal()] = 1;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_BLURRY.ordinal()] = 2;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_LAGGING.ordinal()] = 3;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_OUT_OF_SYNC.ordinal()] = 4;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_MISSING.ordinal()] = 5;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_AUDIO_POOR.ordinal()] = 6;
        iArr[FeedbackIssue.STREAM_REPORT_ENDED_STREAM_STOPPED_UNEXPECTEDLY.ordinal()] = 7;
        iArr[FeedbackIssue.OTHER.ordinal()] = 8;
    }
}
