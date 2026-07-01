package com.discord.widgets.user.profile;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserStatusPresenceCustomView$Emoji {
    private final String id;
    private final boolean isAnimated;
    private final String name;

    public UserStatusPresenceCustomView$Emoji(String str, String str2, boolean z2) {
        this.id = str;
        this.name = str2;
        this.isAnimated = z2;
    }

    public static /* synthetic */ UserStatusPresenceCustomView$Emoji copy$default(UserStatusPresenceCustomView$Emoji userStatusPresenceCustomView$Emoji, String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userStatusPresenceCustomView$Emoji.id;
        }
        if ((i & 2) != 0) {
            str2 = userStatusPresenceCustomView$Emoji.name;
        }
        if ((i & 4) != 0) {
            z2 = userStatusPresenceCustomView$Emoji.isAnimated;
        }
        return userStatusPresenceCustomView$Emoji.copy(str, str2, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAnimated() {
        return this.isAnimated;
    }

    public final UserStatusPresenceCustomView$Emoji copy(String id2, String name, boolean isAnimated) {
        return new UserStatusPresenceCustomView$Emoji(id2, name, isAnimated);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserStatusPresenceCustomView$Emoji)) {
            return false;
        }
        UserStatusPresenceCustomView$Emoji userStatusPresenceCustomView$Emoji = (UserStatusPresenceCustomView$Emoji) other;
        return m.areEqual(this.id, userStatusPresenceCustomView$Emoji.id) && m.areEqual(this.name, userStatusPresenceCustomView$Emoji.name) && this.isAnimated == userStatusPresenceCustomView$Emoji.isAnimated;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.isAnimated;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isAnimated() {
        return this.isAnimated;
    }

    public String toString() {
        StringBuilder sbU = a.U("Emoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", isAnimated=");
        return a.O(sbU, this.isAnimated, ")");
    }
}
