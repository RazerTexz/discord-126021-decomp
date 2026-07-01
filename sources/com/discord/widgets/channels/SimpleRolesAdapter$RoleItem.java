package com.discord.widgets.channels;

import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: SimpleRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SimpleRolesAdapter$RoleItem implements MGRecyclerDataPayload, Comparable<SimpleRolesAdapter$RoleItem> {
    public static final SimpleRolesAdapter$RoleItem$Companion Companion = new SimpleRolesAdapter$RoleItem$Companion(null);
    public static final int TYPE_ROLE = 0;
    private final String key;
    private final GuildRole role;
    private final int type;

    public SimpleRolesAdapter$RoleItem(GuildRole guildRole) {
        m.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
        this.key = String.valueOf(guildRole.getId());
    }

    public static /* synthetic */ SimpleRolesAdapter$RoleItem copy$default(SimpleRolesAdapter$RoleItem simpleRolesAdapter$RoleItem, GuildRole guildRole, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = simpleRolesAdapter$RoleItem.role;
        }
        return simpleRolesAdapter$RoleItem.copy(guildRole);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SimpleRolesAdapter$RoleItem simpleRolesAdapter$RoleItem) {
        return compareTo2(simpleRolesAdapter$RoleItem);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    public final SimpleRolesAdapter$RoleItem copy(GuildRole role) {
        m.checkNotNullParameter(role, "role");
        return new SimpleRolesAdapter$RoleItem(role);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SimpleRolesAdapter$RoleItem) && m.areEqual(this.role, ((SimpleRolesAdapter$RoleItem) other).role);
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        GuildRole guildRole = this.role;
        if (guildRole != null) {
            return guildRole.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("RoleItem(role=");
        sbU.append(this.role);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SimpleRolesAdapter$RoleItem other) {
        m.checkNotNullParameter(other, "other");
        return RoleUtils.getROLE_COMPARATOR().compare(this.role, other.role);
    }
}
