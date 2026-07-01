package com.discord.utilities.channel;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.utilities.permissions.ManageGuildContext;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.n;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: GuildChannelsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildChannelsInfo {
    public static final GuildChannelsInfo$Companion Companion = new GuildChannelsInfo$Companion(null);
    private final boolean ableToInstantInvite;
    private final boolean canChangeNickname;
    private final Map<Long, Long> channelPermissions;
    private final GuildRole everyoneRole;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean hideMutedChannels;
    private final boolean isVerifiedServer;
    private final ManageGuildContext manageGuildContext;
    private final ModelNotificationSettings notificationSettings;
    private final boolean unelevated;

    public GuildChannelsInfo(Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map<Long, Long> map, boolean z3, boolean z4, boolean z5, ManageGuildContext manageGuildContext, boolean z6, Map<Long, GuildRole> map2) {
        m.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
        m.checkNotNullParameter(map, "channelPermissions");
        m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
        this.guild = guild;
        this.everyoneRole = guildRole;
        this.notificationSettings = modelNotificationSettings;
        this.hideMutedChannels = z2;
        this.channelPermissions = map;
        this.ableToInstantInvite = z3;
        this.unelevated = z4;
        this.isVerifiedServer = z5;
        this.manageGuildContext = manageGuildContext;
        this.canChangeNickname = z6;
        this.guildRoles = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildChannelsInfo copy$default(GuildChannelsInfo guildChannelsInfo, Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map map, boolean z3, boolean z4, boolean z5, ManageGuildContext manageGuildContext, boolean z6, Map map2, int i, Object obj) {
        return guildChannelsInfo.copy((i & 1) != 0 ? guildChannelsInfo.guild : guild, (i & 2) != 0 ? guildChannelsInfo.everyoneRole : guildRole, (i & 4) != 0 ? guildChannelsInfo.notificationSettings : modelNotificationSettings, (i & 8) != 0 ? guildChannelsInfo.hideMutedChannels : z2, (i & 16) != 0 ? guildChannelsInfo.channelPermissions : map, (i & 32) != 0 ? guildChannelsInfo.ableToInstantInvite : z3, (i & 64) != 0 ? guildChannelsInfo.unelevated : z4, (i & 128) != 0 ? guildChannelsInfo.isVerifiedServer : z5, (i & 256) != 0 ? guildChannelsInfo.manageGuildContext : manageGuildContext, (i & 512) != 0 ? guildChannelsInfo.canChangeNickname : z6, (i & 1024) != 0 ? guildChannelsInfo.guildRoles : map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final Map<Long, GuildRole> component11() {
        return this.guildRoles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildRole getEveryoneRole() {
        return this.everyoneRole;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final Map<Long, Long> component5() {
        return this.channelPermissions;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getUnelevated() {
        return this.unelevated;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsVerifiedServer() {
        return this.isVerifiedServer;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final ManageGuildContext getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final GuildChannelsInfo copy(Guild guild, GuildRole everyoneRole, ModelNotificationSettings notificationSettings, boolean hideMutedChannels, Map<Long, Long> channelPermissions, boolean ableToInstantInvite, boolean unelevated, boolean isVerifiedServer, ManageGuildContext manageGuildContext, boolean canChangeNickname, Map<Long, GuildRole> guildRoles) {
        m.checkNotNullParameter(notificationSettings, "notificationSettings");
        m.checkNotNullParameter(channelPermissions, "channelPermissions");
        m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
        return new GuildChannelsInfo(guild, everyoneRole, notificationSettings, hideMutedChannels, channelPermissions, ableToInstantInvite, unelevated, isVerifiedServer, manageGuildContext, canChangeNickname, guildRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChannelsInfo)) {
            return false;
        }
        GuildChannelsInfo guildChannelsInfo = (GuildChannelsInfo) other;
        return m.areEqual(this.guild, guildChannelsInfo.guild) && m.areEqual(this.everyoneRole, guildChannelsInfo.everyoneRole) && m.areEqual(this.notificationSettings, guildChannelsInfo.notificationSettings) && this.hideMutedChannels == guildChannelsInfo.hideMutedChannels && m.areEqual(this.channelPermissions, guildChannelsInfo.channelPermissions) && this.ableToInstantInvite == guildChannelsInfo.ableToInstantInvite && this.unelevated == guildChannelsInfo.unelevated && this.isVerifiedServer == guildChannelsInfo.isVerifiedServer && m.areEqual(this.manageGuildContext, guildChannelsInfo.manageGuildContext) && this.canChangeNickname == guildChannelsInfo.canChangeNickname && m.areEqual(this.guildRoles, guildChannelsInfo.guildRoles);
    }

    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final GuildRole getEveryoneRole() {
        return this.everyoneRole;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final ManageGuildContext getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public final Map<Long, Collection<Channel>> getSortedCategories(Map<Long, Channel> guildChannels) {
        m.checkNotNullParameter(guildChannels, "guildChannels");
        TreeMap treeMap = new TreeMap(new GuildChannelsInfo$getSortedCategories$sortedCategories$1(guildChannels));
        for (Channel channel : u.filterNotNull(guildChannels.values())) {
            Long lValueOf = Long.valueOf(ChannelUtils.k(channel) ? channel.getId() : channel.getParentId());
            Object treeSet = treeMap.get(lValueOf);
            if (treeSet == null) {
                treeSet = new TreeSet(ChannelUtils.h(Channel.Companion));
                treeMap.put(lValueOf, treeSet);
            }
            ((Set) treeSet).add(channel);
        }
        return treeMap;
    }

    public final List<Channel> getSortedVisibleChannels(Map<Long, Channel> guildChannels) {
        m.checkNotNullParameter(guildChannels, "guildChannels");
        Map<Long, Collection<Channel>> sortedCategories = getSortedCategories(guildChannels);
        ArrayList arrayList = new ArrayList();
        Iterator<Map$Entry<Long, Collection<Channel>>> it = sortedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Collection<Channel> value = it.next().getValue();
            List arrayList2 = new ArrayList();
            for (Object obj : value) {
                Channel channel = (Channel) obj;
                if (PermissionUtils.INSTANCE.hasAccess(channel, (Long) a.d(channel, this.channelPermissions))) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() == 1) {
                arrayList2 = n.emptyList();
            }
            r.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public final boolean getUnelevated() {
        return this.unelevated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        GuildRole guildRole = this.everyoneRole;
        int iHashCode2 = (iHashCode + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
        int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
        boolean z2 = this.hideMutedChannels;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        Map<Long, Long> map = this.channelPermissions;
        int iHashCode4 = (i + (map != null ? map.hashCode() : 0)) * 31;
        boolean z3 = this.ableToInstantInvite;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (iHashCode4 + r3) * 31;
        boolean z4 = this.unelevated;
        ?? r4 = z4;
        if (z4) {
            r4 = 1;
        }
        int i3 = (i2 + r4) * 31;
        boolean z5 = this.isVerifiedServer;
        ?? r5 = z5;
        if (z5) {
            r5 = 1;
        }
        int i4 = (i3 + r5) * 31;
        ManageGuildContext manageGuildContext = this.manageGuildContext;
        int iHashCode5 = (i4 + (manageGuildContext != null ? manageGuildContext.hashCode() : 0)) * 31;
        boolean z6 = this.canChangeNickname;
        int i5 = (iHashCode5 + (z6 ? 1 : z6)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        return i5 + (map2 != null ? map2.hashCode() : 0);
    }

    public final boolean isVerifiedServer() {
        return this.isVerifiedServer;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildChannelsInfo(guild=");
        sbU.append(this.guild);
        sbU.append(", everyoneRole=");
        sbU.append(this.everyoneRole);
        sbU.append(", notificationSettings=");
        sbU.append(this.notificationSettings);
        sbU.append(", hideMutedChannels=");
        sbU.append(this.hideMutedChannels);
        sbU.append(", channelPermissions=");
        sbU.append(this.channelPermissions);
        sbU.append(", ableToInstantInvite=");
        sbU.append(this.ableToInstantInvite);
        sbU.append(", unelevated=");
        sbU.append(this.unelevated);
        sbU.append(", isVerifiedServer=");
        sbU.append(this.isVerifiedServer);
        sbU.append(", manageGuildContext=");
        sbU.append(this.manageGuildContext);
        sbU.append(", canChangeNickname=");
        sbU.append(this.canChangeNickname);
        sbU.append(", guildRoles=");
        return a.M(sbU, this.guildRoles, ")");
    }
}
