package com.discord.api.guild;


/* JADX INFO: compiled from: GuildExplicitContentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public enum GuildExplicitContentFilter {
    NONE(0),
    SOME(1),
    ALL(2);

    private final int apiValue;

    GuildExplicitContentFilter(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
