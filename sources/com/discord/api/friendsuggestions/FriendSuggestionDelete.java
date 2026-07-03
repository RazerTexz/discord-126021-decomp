package com.discord.api.friendsuggestions;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: compiled from: FriendSuggestionDelete.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FriendSuggestionDelete {
    private final long suggestedUserId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getSuggestedUserId() {
        return this.suggestedUserId;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendSuggestionDelete) && this.suggestedUserId == ((FriendSuggestionDelete) other).suggestedUserId;
        }
        return true;
    }

    public int hashCode() {
        long j = this.suggestedUserId;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return C1643a.m815C(C1643a.m833U("FriendSuggestionDelete(suggestedUserId="), this.suggestedUserId, ")");
    }
}
