package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils$getSortByNameAndType$1;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.permissions.ManageGuildContext;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.functions.Func8;

/* JADX INFO: compiled from: GuildChannelsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildChannelsInfo {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: GuildChannelsInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<GuildChannelsInfo> get(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<GuildChannelsInfo> observableM11112r = ObservableWithLeadingEdgeThrottle.combineLatest(companion.getUsers().observeMe(true), companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getUserGuildSettings().observeHideMutedChannels(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), new Func8<MeUser, Guild, ModelNotificationSettings, Boolean, Map<Long, ? extends GuildRole>, Long, Map<Long, ? extends Long>, List<? extends Channel>, GuildChannelsInfo>() { // from class: com.discord.utilities.channel.GuildChannelsInfo$Companion$get$1
                @Override // p658rx.functions.Func8
                public /* bridge */ /* synthetic */ GuildChannelsInfo call(MeUser meUser, Guild guild, ModelNotificationSettings modelNotificationSettings, Boolean bool, Map<Long, ? extends GuildRole> map, Long l, Map<Long, ? extends Long> map2, List<? extends Channel> list) {
                    return call2(meUser, guild, modelNotificationSettings, bool, (Map<Long, GuildRole>) map, l, (Map<Long, Long>) map2, (List<Channel>) list);
                }

                /* JADX WARN: Code duplicated, block: B:25:0x0042  */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GuildChannelsInfo call2(MeUser meUser, Guild guild, ModelNotificationSettings modelNotificationSettings, Boolean bool, Map<Long, GuildRole> map, Long l, Map<Long, Long> map2, List<Channel> list) {
                    boolean z2;
                    Set<GuildFeature> features;
                    boolean z3 = meUser != null && meUser.getMfaEnabled();
                    int mfaLevel = guild != null ? guild.getMfaLevel() : 0;
                    boolean zIsElevated = PermissionUtils.isElevated(16L, z3, mfaLevel);
                    boolean z4 = zIsElevated && PermissionUtils.can(16L, l);
                    if (PermissionUtils.can(1L, l)) {
                        z2 = true;
                    } else {
                        if ((guild != null ? guild.getVanityUrlCode() : null) != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    GuildRole guildRole = guild != null ? (GuildRole) C1643a.m847e(guild, map) : null;
                    boolean z5 = !zIsElevated && z4;
                    boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.VERIFIED);
                    ManageGuildContext.Companion companion2 = ManageGuildContext.INSTANCE;
                    C12238m.checkNotNullExpressionValue(list, "categories");
                    boolean z6 = ((guild != null ? Long.valueOf(guild.getOwnerId()) : null) == null || meUser == null || meUser.getId() != guild.getOwnerId()) ? false : true;
                    C12238m.checkNotNullExpressionValue(map2, "channelPermissions");
                    ManageGuildContext manageGuildContextFrom = companion2.from(list, z6, l, map2, mfaLevel, meUser != null ? meUser.getMfaEnabled() : false);
                    boolean zCan = PermissionUtils.can(Permission.CHANGE_NICKNAME, l);
                    C12238m.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
                    C12238m.checkNotNullExpressionValue(bool, "hideMuted");
                    return new GuildChannelsInfo(guild, guildRole, modelNotificationSettings, bool.booleanValue(), map2, z2, z5, zContains, manageGuildContextFrom, zCan, map);
                }
            }, 500L, TimeUnit.MILLISECONDS).m11112r();
            C12238m.checkNotNullExpressionValue(observableM11112r, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildChannelsInfo(Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map<Long, Long> map, boolean z3, boolean z4, boolean z5, ManageGuildContext manageGuildContext, boolean z6, Map<Long, GuildRole> map2) {
        C12238m.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
        C12238m.checkNotNullParameter(map, "channelPermissions");
        C12238m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
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
        C12238m.checkNotNullParameter(notificationSettings, "notificationSettings");
        C12238m.checkNotNullParameter(channelPermissions, "channelPermissions");
        C12238m.checkNotNullParameter(manageGuildContext, "manageGuildContext");
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
        return C12238m.areEqual(this.guild, guildChannelsInfo.guild) && C12238m.areEqual(this.everyoneRole, guildChannelsInfo.everyoneRole) && C12238m.areEqual(this.notificationSettings, guildChannelsInfo.notificationSettings) && this.hideMutedChannels == guildChannelsInfo.hideMutedChannels && C12238m.areEqual(this.channelPermissions, guildChannelsInfo.channelPermissions) && this.ableToInstantInvite == guildChannelsInfo.ableToInstantInvite && this.unelevated == guildChannelsInfo.unelevated && this.isVerifiedServer == guildChannelsInfo.isVerifiedServer && C12238m.areEqual(this.manageGuildContext, guildChannelsInfo.manageGuildContext) && this.canChangeNickname == guildChannelsInfo.canChangeNickname && C12238m.areEqual(this.guildRoles, guildChannelsInfo.guildRoles);
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

    public final Map<Long, Collection<Channel>> getSortedCategories(final Map<Long, Channel> guildChannels) {
        C12238m.checkNotNullParameter(guildChannels, "guildChannels");
        TreeMap treeMap = new TreeMap(new Comparator<Long>() { // from class: com.discord.utilities.channel.GuildChannelsInfo$getSortedCategories$sortedCategories$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(Long l, Long l2) {
                return ((ChannelUtils$getSortByNameAndType$1) ChannelUtils.m7684h(Channel.INSTANCE)).compare(guildChannels.get(l), guildChannels.get(l2));
            }
        });
        for (Channel channel : C12163u.filterNotNull(guildChannels.values())) {
            Long lValueOf = Long.valueOf(ChannelUtils.m7687k(channel) ? channel.getId() : channel.getParentId());
            Object treeSet = treeMap.get(lValueOf);
            if (treeSet == null) {
                treeSet = new TreeSet(ChannelUtils.m7684h(Channel.INSTANCE));
                treeMap.put(lValueOf, treeSet);
            }
            ((Set) treeSet).add(channel);
        }
        return treeMap;
    }

    public final List<Channel> getSortedVisibleChannels(Map<Long, Channel> guildChannels) {
        C12238m.checkNotNullParameter(guildChannels, "guildChannels");
        Map<Long, Collection<Channel>> sortedCategories = getSortedCategories(guildChannels);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, Collection<Channel>>> it = sortedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Collection<Channel> value = it.next().getValue();
            List arrayList2 = new ArrayList();
            for (Object obj : value) {
                Channel channel = (Channel) obj;
                if (PermissionUtils.INSTANCE.hasAccess(channel, (Long) C1643a.m845d(channel, this.channelPermissions))) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() == 1) {
                arrayList2 = C12147n.emptyList();
            }
            C12160r.addAll(arrayList, arrayList2);
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
        StringBuilder sbM833U = C1643a.m833U("GuildChannelsInfo(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", everyoneRole=");
        sbM833U.append(this.everyoneRole);
        sbM833U.append(", notificationSettings=");
        sbM833U.append(this.notificationSettings);
        sbM833U.append(", hideMutedChannels=");
        sbM833U.append(this.hideMutedChannels);
        sbM833U.append(", channelPermissions=");
        sbM833U.append(this.channelPermissions);
        sbM833U.append(", ableToInstantInvite=");
        sbM833U.append(this.ableToInstantInvite);
        sbM833U.append(", unelevated=");
        sbM833U.append(this.unelevated);
        sbM833U.append(", isVerifiedServer=");
        sbM833U.append(this.isVerifiedServer);
        sbM833U.append(", manageGuildContext=");
        sbM833U.append(this.manageGuildContext);
        sbM833U.append(", canChangeNickname=");
        sbM833U.append(this.canChangeNickname);
        sbM833U.append(", guildRoles=");
        return C1643a.m825M(sbM833U, this.guildRoles, ")");
    }
}
