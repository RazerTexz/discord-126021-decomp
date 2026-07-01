package com.discord.widgets.servers.community;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid extends WidgetServerSettingsCommunityOverviewViewModel$StoreState {
    private final Guild guild;
    private final MeUser me;
    private final Long permissions;
    private final Channel rulesChannel;
    private final Channel updatesChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid(Guild guild, MeUser meUser, Long l, Channel channel, Channel channel2) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(meUser, "me");
        this.guild = guild;
        this.me = meUser;
        this.permissions = l;
        this.rulesChannel = channel;
        this.updatesChannel = channel2;
    }

    public static /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid copy$default(WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid, Guild guild, MeUser meUser, Long l, Channel channel, Channel channel2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.guild;
        }
        if ((i & 2) != 0) {
            meUser = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.me;
        }
        MeUser meUser2 = meUser;
        if ((i & 4) != 0) {
            l = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.permissions;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            channel = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.rulesChannel;
        }
        Channel channel3 = channel;
        if ((i & 16) != 0) {
            channel2 = widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.updatesChannel;
        }
        return widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.copy(guild, meUser2, l2, channel3, channel2);
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

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Channel getRulesChannel() {
        return this.rulesChannel;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Channel getUpdatesChannel() {
        return this.updatesChannel;
    }

    public final WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid copy(Guild guild, MeUser me2, Long permissions, Channel rulesChannel, Channel updatesChannel) {
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(me2, "me");
        return new WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid(guild, me2, permissions, rulesChannel, updatesChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid = (WidgetServerSettingsCommunityOverviewViewModel$StoreState$Valid) other;
        return m.areEqual(this.guild, widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.guild) && m.areEqual(this.me, widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.me) && m.areEqual(this.permissions, widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.permissions) && m.areEqual(this.rulesChannel, widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.rulesChannel) && m.areEqual(this.updatesChannel, widgetServerSettingsCommunityOverviewViewModel$StoreState$Valid.updatesChannel);
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
        Channel channel = this.rulesChannel;
        int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.updatesChannel;
        return iHashCode4 + (channel2 != null ? channel2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(guild=");
        sbU.append(this.guild);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", rulesChannel=");
        sbU.append(this.rulesChannel);
        sbU.append(", updatesChannel=");
        sbU.append(this.updatesChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
