package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetPruneUsersViewModel$StoreData {
    private final Guild guild;
    private final Long permission;
    private final MeUser user;

    public WidgetPruneUsersViewModel$StoreData(Long l, Guild guild, MeUser meUser) {
        this.permission = l;
        this.guild = guild;
        this.user = meUser;
    }

    public static /* synthetic */ WidgetPruneUsersViewModel$StoreData copy$default(WidgetPruneUsersViewModel$StoreData widgetPruneUsersViewModel$StoreData, Long l, Guild guild, MeUser meUser, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetPruneUsersViewModel$StoreData.permission;
        }
        if ((i & 2) != 0) {
            guild = widgetPruneUsersViewModel$StoreData.guild;
        }
        if ((i & 4) != 0) {
            meUser = widgetPruneUsersViewModel$StoreData.user;
        }
        return widgetPruneUsersViewModel$StoreData.copy(l, guild, meUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getPermission() {
        return this.permission;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MeUser getUser() {
        return this.user;
    }

    public final WidgetPruneUsersViewModel$StoreData copy(Long permission, Guild guild, MeUser user) {
        return new WidgetPruneUsersViewModel$StoreData(permission, guild, user);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetPruneUsersViewModel$StoreData)) {
            return false;
        }
        WidgetPruneUsersViewModel$StoreData widgetPruneUsersViewModel$StoreData = (WidgetPruneUsersViewModel$StoreData) other;
        return m.areEqual(this.permission, widgetPruneUsersViewModel$StoreData.permission) && m.areEqual(this.guild, widgetPruneUsersViewModel$StoreData.guild) && m.areEqual(this.user, widgetPruneUsersViewModel$StoreData.user);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Long getPermission() {
        return this.permission;
    }

    public final MeUser getUser() {
        return this.user;
    }

    public int hashCode() {
        Long l = this.permission;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        MeUser meUser = this.user;
        return iHashCode2 + (meUser != null ? meUser.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreData(permission=");
        sbU.append(this.permission);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(")");
        return sbU.toString();
    }
}
