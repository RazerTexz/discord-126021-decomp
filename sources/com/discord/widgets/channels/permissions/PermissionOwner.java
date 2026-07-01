package com.discord.widgets.channels.permissions;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PermissionOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PermissionOwner implements Serializable {
    private final long entityId;

    /* JADX INFO: compiled from: PermissionOwner.kt */
    public static final /* data */ class Member extends PermissionOwner {
        private final boolean isOwner;
        private final String nickname;
        private final User user;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Member(User user, String str, boolean z2) {
            super(user.getId(), null);
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.nickname = str;
            this.isOwner = z2;
        }

        public static /* synthetic */ Member copy$default(Member member, User user, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = member.user;
            }
            if ((i & 2) != 0) {
                str = member.nickname;
            }
            if ((i & 4) != 0) {
                z2 = member.isOwner;
            }
            return member.copy(user, str, z2);
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

        public final Member copy(User user, String nickname, boolean isOwner) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new Member(user, nickname, isOwner);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Member)) {
                return false;
            }
            Member member = (Member) other;
            return Intrinsics3.areEqual(this.user, member.user) && Intrinsics3.areEqual(this.nickname, member.nickname) && this.isOwner == member.isOwner;
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
            StringBuilder sbU = outline.U("Member(user=");
            sbU.append(this.user);
            sbU.append(", nickname=");
            sbU.append(this.nickname);
            sbU.append(", isOwner=");
            return outline.O(sbU, this.isOwner, ")");
        }
    }

    /* JADX INFO: compiled from: PermissionOwner.kt */
    public static final /* data */ class Role extends PermissionOwner {
        private final GuildRole role;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Role(GuildRole guildRole) {
            super(guildRole.getId(), null);
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
        }

        public static /* synthetic */ Role copy$default(Role role, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = role.role;
            }
            return role.copy(guildRole);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final Role copy(GuildRole role) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new Role(role);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Role) && Intrinsics3.areEqual(this.role, ((Role) other).role);
            }
            return true;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public int hashCode() {
            GuildRole guildRole = this.role;
            if (guildRole != null) {
                return guildRole.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Role(role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private PermissionOwner(long j) {
        this.entityId = j;
    }

    public final long getEntityId() {
        return this.entityId;
    }

    public /* synthetic */ PermissionOwner(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }
}
