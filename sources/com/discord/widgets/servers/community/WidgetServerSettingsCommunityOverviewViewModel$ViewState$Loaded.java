package com.discord.widgets.servers.community;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded extends WidgetServerSettingsCommunityOverviewViewModel$ViewState {
    private final Guild guild;
    private final Channel rulesChannel;
    private final Channel updatesChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded(Guild guild, Channel channel, Channel channel2) {
        super(null);
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.rulesChannel = channel;
        this.updatesChannel = channel2;
    }

    public static /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded copy$default(WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded, Guild guild, Channel channel, Channel channel2, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.guild;
        }
        if ((i & 2) != 0) {
            channel = widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.rulesChannel;
        }
        if ((i & 4) != 0) {
            channel2 = widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.updatesChannel;
        }
        return widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.copy(guild, channel, channel2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getRulesChannel() {
        return this.rulesChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getUpdatesChannel() {
        return this.updatesChannel;
    }

    public final WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded copy(Guild guild, Channel rulesChannel, Channel updatesChannel) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded(guild, rulesChannel, updatesChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded = (WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded) other;
        return m.areEqual(this.guild, widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.guild) && m.areEqual(this.rulesChannel, widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.rulesChannel) && m.areEqual(this.updatesChannel, widgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded.updatesChannel);
    }

    public final Guild getGuild() {
        return this.guild;
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
        Channel channel = this.rulesChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.updatesChannel;
        return iHashCode2 + (channel2 != null ? channel2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(guild=");
        sbU.append(this.guild);
        sbU.append(", rulesChannel=");
        sbU.append(this.rulesChannel);
        sbU.append(", updatesChannel=");
        sbU.append(this.updatesChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
