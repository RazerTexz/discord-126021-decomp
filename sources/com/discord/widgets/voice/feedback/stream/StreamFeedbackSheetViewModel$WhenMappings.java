package com.discord.widgets.voice.feedback.stream;

import com.discord.widgets.voice.feedback.FeedbackRating;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StreamFeedbackSheetViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        FeedbackRating.values();
        int[] iArr = new int[4];
        $EnumSwitchMapping$0 = iArr;
        iArr[FeedbackRating.NO_RESPONSE.ordinal()] = 1;
        iArr[FeedbackRating.GOOD.ordinal()] = 2;
        FeedbackRating feedbackRating = FeedbackRating.NEUTRAL;
        iArr[feedbackRating.ordinal()] = 3;
        FeedbackRating feedbackRating2 = FeedbackRating.BAD;
        iArr[feedbackRating2.ordinal()] = 4;
        FeedbackRating.values();
        int[] iArr2 = new int[4];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[feedbackRating.ordinal()] = 1;
        iArr2[feedbackRating2.ordinal()] = 2;
    }
}
