package com.discord.utilities.permissions;

import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.utilities.permissions.ManageUserContext, reason: use source file name */
/* JADX INFO: compiled from: PermissionsContexts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class PermissionsContexts3 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canBan;
    private final boolean canChangeNickname;
    private final boolean canDeafen;
    private final boolean canDisableCommunication;
    private final boolean canKick;
    private final boolean canManageRoles;
    private final boolean canMove;
    private final boolean canMute;
    private final boolean canTransferOwnership;

    /* JADX INFO: renamed from: com.discord.utilities.permissions.ManageUserContext$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: PermissionsContexts.kt */
    public static final class Companion {
        private Companion() {
        }

        public final PermissionsContexts3 from(Guild guild, MeUser actingUser, User targetUser, Collection<Long> actingUserRoles, Collection<Long> userRoles, Long myPermissions, Map<Long, GuildRole> guildRoles) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(actingUser, "actingUser");
            Intrinsics3.checkNotNullParameter(targetUser, "targetUser");
            Intrinsics3.checkNotNullParameter(actingUserRoles, "actingUserRoles");
            Intrinsics3.checkNotNullParameter(userRoles, "userRoles");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
            long id2 = targetUser.getId();
            long id3 = actingUser.getId();
            boolean z2 = id3 == id2;
            boolean z3 = id3 == guild.getOwnerId();
            boolean z4 = z3 || (!((id2 > guild.getOwnerId() ? 1 : (id2 == guild.getOwnerId() ? 0 : -1)) == 0) && RoleUtils.rankIsHigher(RoleUtils.getHighestRole(guildRoles, actingUserRoles), RoleUtils.getHighestRole(guildRoles, userRoles)));
            int mfaLevel = guild.getMfaLevel();
            boolean mfaEnabled = actingUser.getMfaEnabled();
            boolean z5 = z3 || PermissionUtils.canAndIsElevated(8L, myPermissions, mfaEnabled, mfaLevel);
            boolean z6 = (z2 || z4) && (z5 || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, myPermissions, mfaEnabled, mfaLevel));
            boolean z7 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(2L, myPermissions, mfaEnabled, mfaLevel));
            boolean z8 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(4L, myPermissions, mfaEnabled, mfaLevel));
            boolean z9 = !z2 && z4 && (z5 || PermissionUtils.canAndIsElevated(Permission.MODERATE_MEMBERS, myPermissions, mfaEnabled, mfaLevel));
            return new PermissionsContexts3(z6, z7, z8, z5 || PermissionUtils.can(Permission.MUTE_MEMBERS, myPermissions), z5 || PermissionUtils.can(Permission.DEAFEN_MEMBERS, myPermissions), z5 || PermissionUtils.can(Permission.MOVE_MEMBERS, myPermissions), !z2 ? !(z4 && (z5 || PermissionUtils.canAndIsElevated(Permission.MANAGE_NICKNAMES, myPermissions, mfaEnabled, mfaLevel))) : !(z5 || PermissionUtils.can(Permission.CHANGE_NICKNAME, myPermissions)), z9, !z2 && z3);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PermissionsContexts3(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.canManageRoles = z2;
        this.canKick = z3;
        this.canBan = z4;
        this.canMute = z5;
        this.canDeafen = z6;
        this.canMove = z7;
        this.canChangeNickname = z8;
        this.canDisableCommunication = z9;
        this.canTransferOwnership = z10;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final boolean getCanTransferOwnership() {
        return this.canTransferOwnership;
    }

    public static final PermissionsContexts3 from(Guild guild, MeUser meUser, User user, Collection<Long> collection, Collection<Long> collection2, Long l, Map<Long, GuildRole> map) {
        return INSTANCE.from(guild, meUser, user, collection, collection2, l, map);
    }

    public final boolean canManage() {
        return this.canManageRoles || this.canKick || this.canBan || this.canMute || this.canDeafen || this.canMove || this.canChangeNickname || this.canTransferOwnership;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanKick() {
        return this.canKick;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getCanBan() {
        return this.canBan;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getCanMute() {
        return this.canMute;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getCanDeafen() {
        return this.canDeafen;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanMove() {
        return this.canMove;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    public final PermissionsContexts3 copy(boolean canManageRoles, boolean canKick, boolean canBan, boolean canMute, boolean canDeafen, boolean canMove, boolean canChangeNickname, boolean canDisableCommunication, boolean canTransferOwnership) {
        return new PermissionsContexts3(canManageRoles, canKick, canBan, canMute, canDeafen, canMove, canChangeNickname, canDisableCommunication, canTransferOwnership);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsContexts3)) {
            return false;
        }
        PermissionsContexts3 permissionsContexts3 = (PermissionsContexts3) other;
        return this.canManageRoles == permissionsContexts3.canManageRoles && this.canKick == permissionsContexts3.canKick && this.canBan == permissionsContexts3.canBan && this.canMute == permissionsContexts3.canMute && this.canDeafen == permissionsContexts3.canDeafen && this.canMove == permissionsContexts3.canMove && this.canChangeNickname == permissionsContexts3.canChangeNickname && this.canDisableCommunication == permissionsContexts3.canDisableCommunication && this.canTransferOwnership == permissionsContexts3.canTransferOwnership;
    }

    public final boolean getCanBan() {
        return this.canBan;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final boolean getCanDeafen() {
        return this.canDeafen;
    }

    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    public final boolean getCanKick() {
        return this.canKick;
    }

    public final boolean getCanManageRoles() {
        return this.canManageRoles;
    }

    public final boolean getCanMove() {
        return this.canMove;
    }

    public final boolean getCanMute() {
        return this.canMute;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public int hashCode() {
        boolean z2 = this.canManageRoles;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.canKick;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.canBan;
        ?? r3 = z4;
        if (z4) {
            r3 = 1;
        }
        int i3 = (i2 + r3) * 31;
        boolean z5 = this.canMute;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.canDeafen;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.canMove;
        ?? r6 = z7;
        if (z7) {
            r6 = 1;
        }
        int i6 = (i5 + r6) * 31;
        boolean z8 = this.canChangeNickname;
        ?? r7 = z8;
        if (z8) {
            r7 = 1;
        }
        int i7 = (i6 + r7) * 31;
        boolean z9 = this.canDisableCommunication;
        ?? r8 = z9;
        if (z9) {
            r8 = 1;
        }
        int i8 = (i7 + r8) * 31;
        boolean z10 = this.canTransferOwnership;
        return i8 + (z10 ? 1 : z10);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ManageUserContext(canManageRoles=");
        sbU.append(this.canManageRoles);
        sbU.append(", canKick=");
        sbU.append(this.canKick);
        sbU.append(", canBan=");
        sbU.append(this.canBan);
        sbU.append(", canMute=");
        sbU.append(this.canMute);
        sbU.append(", canDeafen=");
        sbU.append(this.canDeafen);
        sbU.append(", canMove=");
        sbU.append(this.canMove);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", canDisableCommunication=");
        sbU.append(this.canDisableCommunication);
        sbU.append(", canTransferOwnership=");
        return outline.O(sbU, this.canTransferOwnership, ")");
    }
}
