package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEditMember$Model {
    public static final WidgetServerSettingsEditMember$Model$Companion Companion = new WidgetServerSettingsEditMember$Model$Companion(null);
    private final boolean canBan;
    private final boolean canChangeNickname;
    private final boolean canDisableCommunication;
    private final boolean canKick;
    private final boolean canManage;
    private final boolean canTransferOwnership;
    private final Guild guild;
    private final long myId;
    private final List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> roleItems;
    private final User user;
    private final GuildMember userComputed;
    private final Set<Long> userRoles;

    public WidgetServerSettingsEditMember$Model(long j, Guild guild, GuildMember guildMember, Set<Long> set, User user, List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(guildMember, "userComputed");
        m.checkNotNullParameter(set, "userRoles");
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(list, "roleItems");
        this.myId = j;
        this.guild = guild;
        this.userComputed = guildMember;
        this.userRoles = set;
        this.user = user;
        this.roleItems = list;
        this.canManage = z2;
        this.canKick = z3;
        this.canBan = z4;
        this.canChangeNickname = z5;
        this.canTransferOwnership = z6;
        this.canDisableCommunication = z7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsEditMember$Model copy$default(WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model, long j, Guild guild, GuildMember guildMember, Set set, User user, List list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        return widgetServerSettingsEditMember$Model.copy((i & 1) != 0 ? widgetServerSettingsEditMember$Model.myId : j, (i & 2) != 0 ? widgetServerSettingsEditMember$Model.guild : guild, (i & 4) != 0 ? widgetServerSettingsEditMember$Model.userComputed : guildMember, (i & 8) != 0 ? widgetServerSettingsEditMember$Model.userRoles : set, (i & 16) != 0 ? widgetServerSettingsEditMember$Model.user : user, (i & 32) != 0 ? widgetServerSettingsEditMember$Model.roleItems : list, (i & 64) != 0 ? widgetServerSettingsEditMember$Model.canManage : z2, (i & 128) != 0 ? widgetServerSettingsEditMember$Model.canKick : z3, (i & 256) != 0 ? widgetServerSettingsEditMember$Model.canBan : z4, (i & 512) != 0 ? widgetServerSettingsEditMember$Model.canChangeNickname : z5, (i & 1024) != 0 ? widgetServerSettingsEditMember$Model.canTransferOwnership : z6, (i & 2048) != 0 ? widgetServerSettingsEditMember$Model.canDisableCommunication : z7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getMyId() {
        return this.myId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getCanTransferOwnership() {
        return this.canTransferOwnership;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getUserComputed() {
        return this.userComputed;
    }

    public final Set<Long> component4() {
        return this.userRoles;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> component6() {
        return this.roleItems;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanManage() {
        return this.canManage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getCanKick() {
        return this.canKick;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getCanBan() {
        return this.canBan;
    }

    public final WidgetServerSettingsEditMember$Model copy(long myId, Guild guild, GuildMember userComputed, Set<Long> userRoles, User user, List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> roleItems, boolean canManage, boolean canKick, boolean canBan, boolean canChangeNickname, boolean canTransferOwnership, boolean canDisableCommunication) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(userComputed, "userComputed");
        m.checkNotNullParameter(userRoles, "userRoles");
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(roleItems, "roleItems");
        return new WidgetServerSettingsEditMember$Model(myId, guild, userComputed, userRoles, user, roleItems, canManage, canKick, canBan, canChangeNickname, canTransferOwnership, canDisableCommunication);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEditMember$Model)) {
            return false;
        }
        WidgetServerSettingsEditMember$Model widgetServerSettingsEditMember$Model = (WidgetServerSettingsEditMember$Model) other;
        return this.myId == widgetServerSettingsEditMember$Model.myId && m.areEqual(this.guild, widgetServerSettingsEditMember$Model.guild) && m.areEqual(this.userComputed, widgetServerSettingsEditMember$Model.userComputed) && m.areEqual(this.userRoles, widgetServerSettingsEditMember$Model.userRoles) && m.areEqual(this.user, widgetServerSettingsEditMember$Model.user) && m.areEqual(this.roleItems, widgetServerSettingsEditMember$Model.roleItems) && this.canManage == widgetServerSettingsEditMember$Model.canManage && this.canKick == widgetServerSettingsEditMember$Model.canKick && this.canBan == widgetServerSettingsEditMember$Model.canBan && this.canChangeNickname == widgetServerSettingsEditMember$Model.canChangeNickname && this.canTransferOwnership == widgetServerSettingsEditMember$Model.canTransferOwnership && this.canDisableCommunication == widgetServerSettingsEditMember$Model.canDisableCommunication;
    }

    public final boolean getCanBan() {
        return this.canBan;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final boolean getCanDisableCommunication() {
        return this.canDisableCommunication;
    }

    public final boolean getCanKick() {
        return this.canKick;
    }

    public final boolean getCanManage() {
        return this.canManage;
    }

    public final boolean getCanTransferOwnership() {
        return this.canTransferOwnership;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final long getMyId() {
        return this.myId;
    }

    public final List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> getRoleItems() {
        return this.roleItems;
    }

    public final User getUser() {
        return this.user;
    }

    public final GuildMember getUserComputed() {
        return this.userComputed;
    }

    public final Set<Long> getUserRoles() {
        return this.userRoles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int iA = b.a(this.myId) * 31;
        Guild guild = this.guild;
        int iHashCode = (iA + (guild != null ? guild.hashCode() : 0)) * 31;
        GuildMember guildMember = this.userComputed;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        Set<Long> set = this.userRoles;
        int iHashCode3 = (iHashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> list = this.roleItems;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.canManage;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode5 + r1) * 31;
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
        boolean z5 = this.canChangeNickname;
        ?? r4 = z5;
        if (z5) {
            r4 = 1;
        }
        int i4 = (i3 + r4) * 31;
        boolean z6 = this.canTransferOwnership;
        ?? r5 = z6;
        if (z6) {
            r5 = 1;
        }
        int i5 = (i4 + r5) * 31;
        boolean z7 = this.canDisableCommunication;
        return i5 + (z7 ? 1 : z7);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(myId=");
        sbU.append(this.myId);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", userComputed=");
        sbU.append(this.userComputed);
        sbU.append(", userRoles=");
        sbU.append(this.userRoles);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", roleItems=");
        sbU.append(this.roleItems);
        sbU.append(", canManage=");
        sbU.append(this.canManage);
        sbU.append(", canKick=");
        sbU.append(this.canKick);
        sbU.append(", canBan=");
        sbU.append(this.canBan);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", canTransferOwnership=");
        sbU.append(this.canTransferOwnership);
        sbU.append(", canDisableCommunication=");
        return a.O(sbU, this.canDisableCommunication, ")");
    }
}
