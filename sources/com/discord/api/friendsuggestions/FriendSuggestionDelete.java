package com.discord.api.friendsuggestions;

import b.d.b.a.a;

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
        return a.C(a.U("FriendSuggestionDelete(suggestedUserId="), this.suggestedUserId, ")");
    }
}
