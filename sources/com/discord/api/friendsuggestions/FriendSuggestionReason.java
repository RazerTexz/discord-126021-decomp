package com.discord.api.friendsuggestions;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FriendSuggestionReason.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class FriendSuggestionReason {
    private final String name;
    private final String platformType;
    private final FriendSuggestionReasonType type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getPlatformType() {
        return this.platformType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendSuggestionReason)) {
            return false;
        }
        FriendSuggestionReason friendSuggestionReason = (FriendSuggestionReason) other;
        return C12238m.areEqual(this.type, friendSuggestionReason.type) && C12238m.areEqual(this.platformType, friendSuggestionReason.platformType) && C12238m.areEqual(this.name, friendSuggestionReason.name);
    }

    public int hashCode() {
        FriendSuggestionReasonType friendSuggestionReasonType = this.type;
        int iHashCode = (friendSuggestionReasonType != null ? friendSuggestionReasonType.hashCode() : 0) * 31;
        String str = this.platformType;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("FriendSuggestionReason(type=");
        sbM833U.append(this.type);
        sbM833U.append(", platformType=");
        sbM833U.append(this.platformType);
        sbM833U.append(", name=");
        return C1643a.m822J(sbM833U, this.name, ")");
    }
}
