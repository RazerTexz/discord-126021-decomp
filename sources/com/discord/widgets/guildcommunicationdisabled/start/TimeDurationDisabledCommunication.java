package com.discord.widgets.guildcommunicationdisabled.start;

import com.adjust.sdk.Constants;

/* JADX INFO: compiled from: GuildCommunicationDisabledDateUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum TimeDurationDisabledCommunication {
    SECONDS_60(60000),
    MINUTES_5(300000),
    MINUTES_10(600000),
    HOUR_1(Constants.ONE_HOUR),
    DAY_1(86400000),
    WEEK_1(604800000);

    private final int durationMs;

    TimeDurationDisabledCommunication(int i) {
        this.durationMs = i;
    }

    public final int getDurationMs() {
        return this.durationMs;
    }
}
