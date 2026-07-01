package com.discord.widgets.servers.community;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid extends WidgetServerSettingsEnableCommunityViewModel$StoreState {
    private final Guild guild;
    private final MeUser me;
    private final Long permissions;
    private final Map<Long, GuildRole> roles;
    private final Channel rulesChannel;
    private final Channel updatesChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(meUser, "me");
        this.guild = guild;
        this.me = meUser;
        this.permissions = l;
        this.roles = map;
        this.rulesChannel = channel;
        this.updatesChannel = channel2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid copy$default(WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid widgetServerSettingsEnableCommunityViewModel$StoreState$Valid, Guild guild, MeUser meUser, Long l, Map map, Channel channel, Channel channel2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.guild;
        }
        if ((i & 2) != 0) {
            meUser = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.me;
        }
        MeUser meUser2 = meUser;
        if ((i & 4) != 0) {
            l = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.permissions;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            map = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.roles;
        }
        Map map2 = map;
        if ((i & 16) != 0) {
            channel = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.rulesChannel;
        }
        Channel channel3 = channel;
        if ((i & 32) != 0) {
            channel2 = widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.updatesChannel;
        }
        return widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.copy(guild, meUser2, l2, map2, channel3, channel2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getPermissions() {
        return this.permissions;
    }

    public final Map<Long, GuildRole> component4() {
        return this.roles;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Channel getRulesChannel() {
        return this.rulesChannel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Channel getUpdatesChannel() {
        return this.updatesChannel;
    }

    public final WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid copy(Guild guild, MeUser me2, Long permissions, Map<Long, GuildRole> roles, Channel rulesChannel, Channel updatesChannel) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(me2, "me");
        return new WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid(guild, me2, permissions, roles, rulesChannel, updatesChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid widgetServerSettingsEnableCommunityViewModel$StoreState$Valid = (WidgetServerSettingsEnableCommunityViewModel$StoreState$Valid) other;
        return m.areEqual(this.guild, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.guild) && m.areEqual(this.me, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.me) && m.areEqual(this.permissions, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.permissions) && m.areEqual(this.roles, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.roles) && m.areEqual(this.rulesChannel, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.rulesChannel) && m.areEqual(this.updatesChannel, widgetServerSettingsEnableCommunityViewModel$StoreState$Valid.updatesChannel);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final Long getPermissions() {
        return this.permissions;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    public final Channel getRulesChannel() {
        return this.rulesChannel;
    }

    public final Channel getUpdatesChannel() {
        return this.updatesChannel;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        MeUser meUser = this.me;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        Long l = this.permissions;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
        Channel channel = this.rulesChannel;
        int iHashCode5 = (iHashCode4 + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.updatesChannel;
        return iHashCode5 + (channel2 != null ? channel2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", rulesChannel=");
        sbU.append(this.rulesChannel);
        sbU.append(", updatesChannel=");
        sbU.append(this.updatesChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
