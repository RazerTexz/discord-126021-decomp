package com.discord.api.friendsuggestions;

import com.discord.api.user.User;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FriendSuggestion.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FriendSuggestion {
    private final List<FriendSuggestionReason> reasons;
    private final User suggestedUser;

    /* JADX INFO: renamed from: a */
    public final List<FriendSuggestionReason> m7830a() {
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
        return C12238m.areEqual(this.suggestedUser, friendSuggestion.suggestedUser) && C12238m.areEqual(this.reasons, friendSuggestion.reasons);
    }

    public int hashCode() {
        User user = this.suggestedUser;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        List<FriendSuggestionReason> list = this.reasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("FriendSuggestion(suggestedUser=");
        sbM833U.append(this.suggestedUser);
        sbM833U.append(", reasons=");
        return C1643a.m824L(sbM833U, this.reasons, ")");
    }
}
