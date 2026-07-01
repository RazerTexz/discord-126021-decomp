package com.discord.utilities.channel;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils4;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
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
import rx.Observable;
import rx.functions.Func8;

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
    private final PermissionsContexts manageGuildContext;
    private final ModelNotificationSettings notificationSettings;
    private final boolean unelevated;

    /* JADX INFO: compiled from: GuildChannelsInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<GuildChannelsInfo> get(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<GuildChannelsInfo> observableR = ObservableWithLeadingEdgeThrottle.combineLatest(companion.getUsers().observeMe(true), companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getUserGuildSettings().observeHideMutedChannels(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), new Func8<MeUser, Guild, ModelNotificationSettings, Boolean, Map<Long, ? extends GuildRole>, Long, Map<Long, ? extends Long>, List<? extends Channel>, GuildChannelsInfo>() { // from class: com.discord.utilities.channel.GuildChannelsInfo$Companion$get$1
                @Override // rx.functions.Func8
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
                    GuildRole guildRole = guild != null ? (GuildRole) outline.e(guild, map) : null;
                    boolean z5 = !zIsElevated && z4;
                    boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.VERIFIED);
                    PermissionsContexts.Companion companion2 = PermissionsContexts.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(list, "categories");
                    boolean z6 = ((guild != null ? Long.valueOf(guild.getOwnerId()) : null) == null || meUser == null || meUser.getId() != guild.getOwnerId()) ? false : true;
                    Intrinsics3.checkNotNullExpressionValue(map2, "channelPermissions");
                    PermissionsContexts permissionsContextsFrom = companion2.from(list, z6, l, map2, mfaLevel, meUser != null ? meUser.getMfaEnabled() : false);
                    boolean zCan = PermissionUtils.can(Permission.CHANGE_NICKNAME, l);
                    Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
                    Intrinsics3.checkNotNullExpressionValue(bool, "hideMuted");
                    return new GuildChannelsInfo(guild, guildRole, modelNotificationSettings, bool.booleanValue(), map2, z2, z5, zContains, permissionsContextsFrom, zCan, map);
                }
            }, 500L, TimeUnit.MILLISECONDS).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildChannelsInfo(Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map<Long, Long> map, boolean z3, boolean z4, boolean z5, PermissionsContexts permissionsContexts, boolean z6, Map<Long, GuildRole> map2) {
        Intrinsics3.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
        Intrinsics3.checkNotNullParameter(map, "channelPermissions");
        Intrinsics3.checkNotNullParameter(permissionsContexts, "manageGuildContext");
        this.guild = guild;
        this.everyoneRole = guildRole;
        this.notificationSettings = modelNotificationSettings;
        this.hideMutedChannels = z2;
        this.channelPermissions = map;
        this.ableToInstantInvite = z3;
        this.unelevated = z4;
        this.isVerifiedServer = z5;
        this.manageGuildContext = permissionsContexts;
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
    public final PermissionsContexts getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final GuildChannelsInfo copy(Guild guild, GuildRole everyoneRole, ModelNotificationSettings notificationSettings, boolean hideMutedChannels, Map<Long, Long> channelPermissions, boolean ableToInstantInvite, boolean unelevated, boolean isVerifiedServer, PermissionsContexts manageGuildContext, boolean canChangeNickname, Map<Long, GuildRole> guildRoles) {
        Intrinsics3.checkNotNullParameter(notificationSettings, "notificationSettings");
        Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
        Intrinsics3.checkNotNullParameter(manageGuildContext, "manageGuildContext");
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
        return Intrinsics3.areEqual(this.guild, guildChannelsInfo.guild) && Intrinsics3.areEqual(this.everyoneRole, guildChannelsInfo.everyoneRole) && Intrinsics3.areEqual(this.notificationSettings, guildChannelsInfo.notificationSettings) && this.hideMutedChannels == guildChannelsInfo.hideMutedChannels && Intrinsics3.areEqual(this.channelPermissions, guildChannelsInfo.channelPermissions) && this.ableToInstantInvite == guildChannelsInfo.ableToInstantInvite && this.unelevated == guildChannelsInfo.unelevated && this.isVerifiedServer == guildChannelsInfo.isVerifiedServer && Intrinsics3.areEqual(this.manageGuildContext, guildChannelsInfo.manageGuildContext) && this.canChangeNickname == guildChannelsInfo.canChangeNickname && Intrinsics3.areEqual(this.guildRoles, guildChannelsInfo.guildRoles);
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

    public final PermissionsContexts getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public final Map<Long, Collection<Channel>> getSortedCategories(final Map<Long, Channel> guildChannels) {
        Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
        TreeMap treeMap = new TreeMap(new Comparator<Long>() { // from class: com.discord.utilities.channel.GuildChannelsInfo$getSortedCategories$sortedCategories$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(Long l, Long l2) {
                return ((ChannelUtils4) ChannelUtils.h(Channel.INSTANCE)).compare(guildChannels.get(l), guildChannels.get(l2));
            }
        });
        for (Channel channel : _Collections.filterNotNull(guildChannels.values())) {
            Long lValueOf = Long.valueOf(ChannelUtils.k(channel) ? channel.getId() : channel.getParentId());
            Object treeSet = treeMap.get(lValueOf);
            if (treeSet == null) {
                treeSet = new TreeSet(ChannelUtils.h(Channel.INSTANCE));
                treeMap.put(lValueOf, treeSet);
            }
            ((Set) treeSet).add(channel);
        }
        return treeMap;
    }

    public final List<Channel> getSortedVisibleChannels(Map<Long, Channel> guildChannels) {
        Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
        Map<Long, Collection<Channel>> sortedCategories = getSortedCategories(guildChannels);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, Collection<Channel>>> it = sortedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Collection<Channel> value = it.next().getValue();
            List arrayList2 = new ArrayList();
            for (Object obj : value) {
                Channel channel = (Channel) obj;
                if (PermissionUtils.INSTANCE.hasAccess(channel, (Long) outline.d(channel, this.channelPermissions))) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() == 1) {
                arrayList2 = Collections2.emptyList();
            }
            MutableCollections.addAll(arrayList, arrayList2);
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
        PermissionsContexts permissionsContexts = this.manageGuildContext;
        int iHashCode5 = (i4 + (permissionsContexts != null ? permissionsContexts.hashCode() : 0)) * 31;
        boolean z6 = this.canChangeNickname;
        int i5 = (iHashCode5 + (z6 ? 1 : z6)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        return i5 + (map2 != null ? map2.hashCode() : 0);
    }

    public final boolean isVerifiedServer() {
        return this.isVerifiedServer;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildChannelsInfo(guild=");
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
        return outline.M(sbU, this.guildRoles, ")");
    }
}
