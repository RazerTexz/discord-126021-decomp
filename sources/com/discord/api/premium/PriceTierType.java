package com.discord.api.premium;


/* JADX INFO: compiled from: PriceTierType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum PriceTierType {
    UNKNOWN(-1),
    GUILD_ROLE_SUBSCRIPTIONS(1);

    private final int apiValue;

    PriceTierType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
