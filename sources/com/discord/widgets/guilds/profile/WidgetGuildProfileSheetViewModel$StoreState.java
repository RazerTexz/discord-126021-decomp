package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildProfiles$GuildProfileData;
import com.discord.utilities.channel.GuildChannelsInfo;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$StoreState {
    private final GuildMember computedMe;
    private final List<Emoji> emojis;
    private final Guild guild;
    private final GuildChannelsInfo guildChannelsInfo;
    private final StoreGuildProfiles$GuildProfileData guildProfile;
    private final boolean isDeveloper;
    private final boolean isLurking;
    private final boolean isUnread;
    private final MeUser me;
    private final List<Long> restrictedGuildIds;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGuildProfileSheetViewModel$StoreState(Guild guild, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List<Long> list, boolean z2, List<? extends Emoji> list2, boolean z3, boolean z4) {
        m.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(list, "restrictedGuildIds");
        m.checkNotNullParameter(list2, "emojis");
        this.guild = guild;
        this.guildProfile = storeGuildProfiles$GuildProfileData;
        this.guildChannelsInfo = guildChannelsInfo;
        this.me = meUser;
        this.computedMe = guildMember;
        this.restrictedGuildIds = list;
        this.isDeveloper = z2;
        this.emojis = list2;
        this.isLurking = z3;
        this.isUnread = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGuildProfileSheetViewModel$StoreState copy$default(WidgetGuildProfileSheetViewModel$StoreState widgetGuildProfileSheetViewModel$StoreState, Guild guild, StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData, GuildChannelsInfo guildChannelsInfo, MeUser meUser, GuildMember guildMember, List list, boolean z2, List list2, boolean z3, boolean z4, int i, Object obj) {
        return widgetGuildProfileSheetViewModel$StoreState.copy((i & 1) != 0 ? widgetGuildProfileSheetViewModel$StoreState.guild : guild, (i & 2) != 0 ? widgetGuildProfileSheetViewModel$StoreState.guildProfile : storeGuildProfiles$GuildProfileData, (i & 4) != 0 ? widgetGuildProfileSheetViewModel$StoreState.guildChannelsInfo : guildChannelsInfo, (i & 8) != 0 ? widgetGuildProfileSheetViewModel$StoreState.me : meUser, (i & 16) != 0 ? widgetGuildProfileSheetViewModel$StoreState.computedMe : guildMember, (i & 32) != 0 ? widgetGuildProfileSheetViewModel$StoreState.restrictedGuildIds : list, (i & 64) != 0 ? widgetGuildProfileSheetViewModel$StoreState.isDeveloper : z2, (i & 128) != 0 ? widgetGuildProfileSheetViewModel$StoreState.emojis : list2, (i & 256) != 0 ? widgetGuildProfileSheetViewModel$StoreState.isLurking : z3, (i & 512) != 0 ? widgetGuildProfileSheetViewModel$StoreState.isUnread : z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsUnread() {
        return this.isUnread;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final StoreGuildProfiles$GuildProfileData getGuildProfile() {
        return this.guildProfile;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildChannelsInfo getGuildChannelsInfo() {
        return this.guildChannelsInfo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildMember getComputedMe() {
        return this.computedMe;
    }

    public final List<Long> component6() {
        return this.restrictedGuildIds;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsDeveloper() {
        return this.isDeveloper;
    }

    public final List<Emoji> component8() {
        return this.emojis;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    public final WidgetGuildProfileSheetViewModel$StoreState copy(Guild guild, StoreGuildProfiles$GuildProfileData guildProfile, GuildChannelsInfo guildChannelsInfo, MeUser me2, GuildMember computedMe, List<Long> restrictedGuildIds, boolean isDeveloper, List<? extends Emoji> emojis, boolean isLurking, boolean isUnread) {
        m.checkNotNullParameter(guildChannelsInfo, "guildChannelsInfo");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(restrictedGuildIds, "restrictedGuildIds");
        m.checkNotNullParameter(emojis, "emojis");
        return new WidgetGuildProfileSheetViewModel$StoreState(guild, guildProfile, guildChannelsInfo, me2, computedMe, restrictedGuildIds, isDeveloper, emojis, isLurking, isUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$StoreState)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$StoreState widgetGuildProfileSheetViewModel$StoreState = (WidgetGuildProfileSheetViewModel$StoreState) other;
        return m.areEqual(this.guild, widgetGuildProfileSheetViewModel$StoreState.guild) && m.areEqual(this.guildProfile, widgetGuildProfileSheetViewModel$StoreState.guildProfile) && m.areEqual(this.guildChannelsInfo, widgetGuildProfileSheetViewModel$StoreState.guildChannelsInfo) && m.areEqual(this.me, widgetGuildProfileSheetViewModel$StoreState.me) && m.areEqual(this.computedMe, widgetGuildProfileSheetViewModel$StoreState.computedMe) && m.areEqual(this.restrictedGuildIds, widgetGuildProfileSheetViewModel$StoreState.restrictedGuildIds) && this.isDeveloper == widgetGuildProfileSheetViewModel$StoreState.isDeveloper && m.areEqual(this.emojis, widgetGuildProfileSheetViewModel$StoreState.emojis) && this.isLurking == widgetGuildProfileSheetViewModel$StoreState.isLurking && this.isUnread == widgetGuildProfileSheetViewModel$StoreState.isUnread;
    }

    public final GuildMember getComputedMe() {
        return this.computedMe;
    }

    public final List<Emoji> getEmojis() {
        return this.emojis;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildChannelsInfo getGuildChannelsInfo() {
        return this.guildChannelsInfo;
    }

    public final StoreGuildProfiles$GuildProfileData getGuildProfile() {
        return this.guildProfile;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final List<Long> getRestrictedGuildIds() {
        return this.restrictedGuildIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        StoreGuildProfiles$GuildProfileData storeGuildProfiles$GuildProfileData = this.guildProfile;
        int iHashCode2 = (iHashCode + (storeGuildProfiles$GuildProfileData != null ? storeGuildProfiles$GuildProfileData.hashCode() : 0)) * 31;
        GuildChannelsInfo guildChannelsInfo = this.guildChannelsInfo;
        int iHashCode3 = (iHashCode2 + (guildChannelsInfo != null ? guildChannelsInfo.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        GuildMember guildMember = this.computedMe;
        int iHashCode5 = (iHashCode4 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        List<Long> list = this.restrictedGuildIds;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isDeveloper;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode6 + r2) * 31;
        List<Emoji> list2 = this.emojis;
        int iHashCode7 = (i + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z3 = this.isLurking;
        ?? r1 = z3;
        if (z3) {
            r1 = 1;
        }
        int i2 = (iHashCode7 + r1) * 31;
        boolean z4 = this.isUnread;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isDeveloper() {
        return this.isDeveloper;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public final boolean isUnread() {
        return this.isUnread;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", guildProfile=");
        sbU.append(this.guildProfile);
        sbU.append(", guildChannelsInfo=");
        sbU.append(this.guildChannelsInfo);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", computedMe=");
        sbU.append(this.computedMe);
        sbU.append(", restrictedGuildIds=");
        sbU.append(this.restrictedGuildIds);
        sbU.append(", isDeveloper=");
        sbU.append(this.isDeveloper);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", isUnread=");
        return a.O(sbU, this.isUnread, ")");
    }
}
