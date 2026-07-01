package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChangeGuildIdentityViewModel$StoreState {
    private final Guild guild;
    private final GuildChannelsInfo guildChannelsInfo;
    private final MeUser meUser;
    private final GuildMember member;

    public WidgetChangeGuildIdentityViewModel$StoreState(Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        this.guild = guild;
        this.meUser = meUser;
        this.member = guildMember;
        this.guildChannelsInfo = guildChannelsInfo;
    }

    public static /* synthetic */ WidgetChangeGuildIdentityViewModel$StoreState copy$default(WidgetChangeGuildIdentityViewModel$StoreState widgetChangeGuildIdentityViewModel$StoreState, Guild guild, MeUser meUser, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetChangeGuildIdentityViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            meUser = widgetChangeGuildIdentityViewModel$StoreState.meUser;
        }
        if ((i & 4) != 0) {
            guildMember = widgetChangeGuildIdentityViewModel$StoreState.member;
        }
        if ((i & 8) != 0) {
            guildChannelsInfo = widgetChangeGuildIdentityViewModel$StoreState.guildChannelsInfo;
        }
        return widgetChangeGuildIdentityViewModel$StoreState.copy(guild, meUser, guildMember, guildChannelsInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getMember() {
        return this.member;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildChannelsInfo getGuildChannelsInfo() {
        return this.guildChannelsInfo;
    }

    public final WidgetChangeGuildIdentityViewModel$StoreState copy(Guild guild, MeUser meUser, GuildMember member, GuildChannelsInfo guildChannelsInfo) {
        m.checkNotNullParameter(meUser, "meUser");
        m.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        return new WidgetChangeGuildIdentityViewModel$StoreState(guild, meUser, member, guildChannelsInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChangeGuildIdentityViewModel$StoreState)) {
            return false;
        }
        WidgetChangeGuildIdentityViewModel$StoreState widgetChangeGuildIdentityViewModel$StoreState = (WidgetChangeGuildIdentityViewModel$StoreState) other;
        return m.areEqual(this.guild, widgetChangeGuildIdentityViewModel$StoreState.guild) && m.areEqual(this.meUser, widgetChangeGuildIdentityViewModel$StoreState.meUser) && m.areEqual(this.member, widgetChangeGuildIdentityViewModel$StoreState.member) && m.areEqual(this.guildChannelsInfo, widgetChangeGuildIdentityViewModel$StoreState.guildChannelsInfo);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildChannelsInfo getGuildChannelsInfo() {
        return this.guildChannelsInfo;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final GuildMember getMember() {
        return this.member;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        MeUser meUser = this.meUser;
        int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
        GuildMember guildMember = this.member;
        int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
        return iHashCode3 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", member=");
        sbU.append(this.member);
        sbU.append(", guildChannelsInfo=");
        sbU.append(this.guildChannelsInfo);
        sbU.append(")");
        return sbU.toString();
    }
}
