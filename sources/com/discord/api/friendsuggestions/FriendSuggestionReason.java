package com.discord.api.friendsuggestions;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        return Intrinsics3.areEqual(this.type, friendSuggestionReason.type) && Intrinsics3.areEqual(this.platformType, friendSuggestionReason.platformType) && Intrinsics3.areEqual(this.name, friendSuggestionReason.name);
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
        StringBuilder sbU = outline.U("FriendSuggestionReason(type=");
        sbU.append(this.type);
        sbU.append(", platformType=");
        sbU.append(this.platformType);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
