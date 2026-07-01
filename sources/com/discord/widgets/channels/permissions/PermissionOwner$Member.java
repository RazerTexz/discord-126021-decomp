package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: PermissionOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionOwner$Member extends PermissionOwner {
    private final boolean isOwner;
    private final String nickname;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionOwner$Member(User user, String str, boolean z2) {
        super(user.getId(), null);
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.nickname = str;
        this.isOwner = z2;
    }

    public static /* synthetic */ PermissionOwner$Member copy$default(PermissionOwner$Member permissionOwner$Member, User user, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            user = permissionOwner$Member.user;
        }
        if ((i & 2) != 0) {
            str = permissionOwner$Member.nickname;
        }
        if ((i & 4) != 0) {
            z2 = permissionOwner$Member.isOwner;
        }
        return permissionOwner$Member.copy(user, str, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }

    public final PermissionOwner$Member copy(User user, String nickname, boolean isOwner) {
        m.checkNotNullParameter(user, "user");
        return new PermissionOwner$Member(user, nickname, isOwner);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionOwner$Member)) {
            return false;
        }
        PermissionOwner$Member permissionOwner$Member = (PermissionOwner$Member) other;
        return m.areEqual(this.user, permissionOwner$Member.user) && m.areEqual(this.nickname, permissionOwner$Member.nickname) && this.isOwner == permissionOwner$Member.isOwner;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        String str = this.nickname;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isOwner;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public String toString() {
        StringBuilder sbU = a.U("Member(user=");
        sbU.append(this.user);
        sbU.append(", nickname=");
        sbU.append(this.nickname);
        sbU.append(", isOwner=");
        return a.O(sbU, this.isOwner, ")");
    }
}
