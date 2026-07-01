package com.discord.widgets.voice.feedback;


/* JADX INFO: compiled from: FeedbackRating.kt */
/* JADX INFO: loaded from: classes.dex */
public enum FeedbackRating {
    GOOD("good"),
    NEUTRAL("neutral"),
    BAD("bad"),
    NO_RESPONSE("no response");

    private final String analyticsValue;

    FeedbackRating(String str) {
        this.analyticsValue = str;
    }

    public final String getAnalyticsValue() {
        return this.analyticsValue;
    }
}
