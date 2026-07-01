package com.discord.widgets.settings.profile;

import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsUserProfileViewModel$StoreState {
    private final Guild guild;
    private final GuildChannelsInfo guildChannelsInfo;
    private final GuildMember meMember;
    private final MeUser user;
    private final UserProfile userProfile;

    public SettingsUserProfileViewModel$StoreState(MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
        m.checkNotNullParameter(meUser, "user");
        m.checkNotNullParameter(userProfile, "userProfile");
        m.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        this.user = meUser;
        this.guild = guild;
        this.userProfile = userProfile;
        this.meMember = guildMember;
        this.guildChannelsInfo = guildChannelsInfo;
    }

    public static /* synthetic */ SettingsUserProfileViewModel$StoreState copy$default(SettingsUserProfileViewModel$StoreState settingsUserProfileViewModel$StoreState, MeUser meUser, Guild guild, UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = settingsUserProfileViewModel$StoreState.user;
        }
        if ((i & 2) != 0) {
            guild = settingsUserProfileViewModel$StoreState.guild;
        }
        Guild guild2 = guild;
        if ((i & 4) != 0) {
            userProfile = settingsUserProfileViewModel$StoreState.userProfile;
        }
        UserProfile userProfile2 = userProfile;
        if ((i & 8) != 0) {
            guildMember = settingsUserProfileViewModel$StoreState.meMember;
        }
        GuildMember guildMember2 = guildMember;
        if ((i & 16) != 0) {
            guildChannelsInfo = settingsUserProfileViewModel$StoreState.guildChannelsInfo;
        }
        return settingsUserProfileViewModel$StoreState.copy(meUser, guild2, userProfile2, guildMember2, guildChannelsInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildMember getMeMember() {
        return this.meMember;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildChannelsInfo getGuildChannelsInfo() {
        return this.guildChannelsInfo;
    }

    public final SettingsUserProfileViewModel$StoreState copy(MeUser user, Guild guild, UserProfile userProfile, GuildMember meMember, GuildChannelsInfo guildChannelsInfo) {
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(userProfile, "userProfile");
        m.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        return new SettingsUserProfileViewModel$StoreState(user, guild, userProfile, meMember, guildChannelsInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsUserProfileViewModel$StoreState)) {
            return false;
        }
        SettingsUserProfileViewModel$StoreState settingsUserProfileViewModel$StoreState = (SettingsUserProfileViewModel$StoreState) other;
        return m.areEqual(this.user, settingsUserProfileViewModel$StoreState.user) && m.areEqual(this.guild, settingsUserProfileViewModel$StoreState.guild) && m.areEqual(this.userProfile, settingsUserProfileViewModel$StoreState.userProfile) && m.areEqual(this.meMember, settingsUserProfileViewModel$StoreState.meMember) && m.areEqual(this.guildChannelsInfo, settingsUserProfileViewModel$StoreState.guildChannelsInfo);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildChannelsInfo getGuildChannelsInfo() {
        return this.guildChannelsInfo;
    }

    public final GuildMember getMeMember() {
        return this.meMember;
    }

    public final MeUser getUser() {
        return this.user;
    }

    public final UserProfile getUserProfile() {
        return this.userProfile;
    }

    public int hashCode() {
        MeUser meUser = this.user;
        int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        UserProfile userProfile = this.userProfile;
        int iHashCode3 = (iHashCode2 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
        GuildMember guildMember = this.meMember;
        int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
        return iHashCode4 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(user=");
        sbU.append(this.user);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", userProfile=");
        sbU.append(this.userProfile);
        sbU.append(", meMember=");
        sbU.append(this.meMember);
        sbU.append(", guildChannelsInfo=");
        sbU.append(this.guildChannelsInfo);
        sbU.append(")");
        return sbU.toString();
    }
}
