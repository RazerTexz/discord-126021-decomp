package com.discord.widgets.stage.model;


/* JADX INFO: compiled from: StageAnalyticsRequestToSpeakState.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StageAnalyticsRequestToSpeakState {
    REQUEST_TO_SPEAK_EVERYONE(1),
    REQUEST_TO_SPEAK_NO_ONE(2);

    private final int integerValue;

    StageAnalyticsRequestToSpeakState(int i) {
        this.integerValue = i;
    }

    public final int getIntegerValue() {
        return this.integerValue;
    }
}
