package com.discord.api.friendsuggestions;


/* JADX INFO: compiled from: AllowedInSuggestionsType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum AllowedInSuggestionsType {
    DISABLED(-1),
    MUTUAL_CONTACT_INFO_ONLY(1),
    ANYONE_WITH_CONTACT_INFO(2);

    private final int apiValue;

    AllowedInSuggestionsType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
