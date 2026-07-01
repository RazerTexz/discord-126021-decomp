package com.discord.api.friendsuggestions;


/* JADX INFO: compiled from: FriendSuggestionReasonType.kt */
/* JADX INFO: loaded from: classes.dex */
public enum FriendSuggestionReasonType {
    NONE(0),
    EXTERNAL_FRIEND(1);

    private final int apiValue;

    FriendSuggestionReasonType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
