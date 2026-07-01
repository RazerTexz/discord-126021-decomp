package com.discord.api.friendsuggestions;

import b.d.b.a.a;
import com.discord.api.user.User;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: FriendSuggestion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FriendSuggestion {
    private final List<FriendSuggestionReason> reasons;
    private final User suggestedUser;

    public final List<FriendSuggestionReason> a() {
        return this.reasons;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final User getSuggestedUser() {
        return this.suggestedUser;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendSuggestion)) {
            return false;
        }
        FriendSuggestion friendSuggestion = (FriendSuggestion) other;
        return m.areEqual(this.suggestedUser, friendSuggestion.suggestedUser) && m.areEqual(this.reasons, friendSuggestion.reasons);
    }

    public int hashCode() {
        User user = this.suggestedUser;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        List<FriendSuggestionReason> list = this.reasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("FriendSuggestion(suggestedUser=");
        sbU.append(this.suggestedUser);
        sbU.append(", reasons=");
        return a.L(sbU, this.reasons, ")");
    }
}
