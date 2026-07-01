package com.discord.api.stageinstance;


/* JADX INFO: compiled from: StageInstancePrivacyLevel.kt */
/* JADX INFO: loaded from: classes.dex */
public enum StageInstancePrivacyLevel {
    INVALID(0),
    PUBLIC(1),
    GUILD_ONLY(2);

    private final int apiValue;

    StageInstancePrivacyLevel(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
