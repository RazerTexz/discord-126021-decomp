package com.discord.widgets.servers.settings.members;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsMembersModel$MemberItem implements MGRecyclerDataPayload {
    private final GuildMember guildMember;
    private final boolean isManagable;
    private final String key;
    private final List<GuildRole> roles;
    private final int type;
    private final User user;
    private final String userDisplayName;

    public WidgetServerSettingsMembersModel$MemberItem(User user, String str, List<GuildRole> list, boolean z2, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(str, "userDisplayName");
        m.checkNotNullParameter(list, "roles");
        m.checkNotNullParameter(guildMember, "guildMember");
        this.user = user;
        this.userDisplayName = str;
        this.roles = list;
        this.isManagable = z2;
        this.guildMember = guildMember;
        this.key = String.valueOf(user.getId());
        this.type = 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsMembersModel$MemberItem copy$default(WidgetServerSettingsMembersModel$MemberItem widgetServerSettingsMembersModel$MemberItem, User user, String str, List list, boolean z2, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetServerSettingsMembersModel$MemberItem.user;
        }
        if ((i & 2) != 0) {
            str = widgetServerSettingsMembersModel$MemberItem.userDisplayName;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = widgetServerSettingsMembersModel$MemberItem.roles;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            z2 = widgetServerSettingsMembersModel$MemberItem.isManagable;
        }
        boolean z3 = z2;
        if ((i & 16) != 0) {
            guildMember = widgetServerSettingsMembersModel$MemberItem.guildMember;
        }
        return widgetServerSettingsMembersModel$MemberItem.copy(user, str2, list2, z3, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserDisplayName() {
        return this.userDisplayName;
    }

    public final List<GuildRole> component3() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsManagable() {
        return this.isManagable;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final WidgetServerSettingsMembersModel$MemberItem copy(User user, String userDisplayName, List<GuildRole> roles, boolean isManagable, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userDisplayName, "userDisplayName");
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(guildMember, "guildMember");
        return new WidgetServerSettingsMembersModel$MemberItem(user, userDisplayName, roles, isManagable, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsMembersModel$MemberItem)) {
            return false;
        }
        WidgetServerSettingsMembersModel$MemberItem widgetServerSettingsMembersModel$MemberItem = (WidgetServerSettingsMembersModel$MemberItem) other;
        return m.areEqual(this.user, widgetServerSettingsMembersModel$MemberItem.user) && m.areEqual(this.userDisplayName, widgetServerSettingsMembersModel$MemberItem.userDisplayName) && m.areEqual(this.roles, widgetServerSettingsMembersModel$MemberItem.roles) && this.isManagable == widgetServerSettingsMembersModel$MemberItem.isManagable && m.areEqual(this.guildMember, widgetServerSettingsMembersModel$MemberItem.guildMember);
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public final String getUserDisplayName() {
        return this.userDisplayName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        String str = this.userDisplayName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<GuildRole> list = this.roles;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isManagable;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        GuildMember guildMember = this.guildMember;
        return i + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public final boolean isManagable() {
        return this.isManagable;
    }

    public String toString() {
        StringBuilder sbU = a.U("MemberItem(user=");
        sbU.append(this.user);
        sbU.append(", userDisplayName=");
        sbU.append(this.userDisplayName);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", isManagable=");
        sbU.append(this.isManagable);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
