package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.SimpleMembersAdapter$MemberItem;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1 extends o implements Function0<WidgetChannelSettingsPermissionsAdvanced$Model> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$channelId = j;
        this.$storeGuilds = storeGuilds;
        this.$storeUser = storeUser;
        this.$storePermissions = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsAdvanced$Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsAdvanced$Model invoke() {
        Channel channel = this.$storeChannels.getChannel(this.$channelId);
        if (channel == null) {
            return null;
        }
        Collection collectionAccess$getOverwriteIds = WidgetChannelSettingsPermissionsAdvanced$Model$Companion.access$getOverwriteIds(WidgetChannelSettingsPermissionsAdvanced$Model.Companion, channel, PermissionOverwrite$Type.MEMBER);
        long guildId = channel.getGuildId();
        Guild guild = this.$storeGuilds.getGuild(guildId);
        Map<Long, GuildRole> mapEmptyMap = this.$storeGuilds.getRoles().get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Map<Long, GuildRole> map = mapEmptyMap;
        MeUser meSnapshot = this.$storeUser.getMeSnapshot();
        Long l = this.$storePermissions.getPermissionsByChannel().get(Long.valueOf(this.$channelId));
        Map<Long, User> users = this.$storeUser.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<Long, User> map$Entry : users.entrySet()) {
            if (collectionAccess$getOverwriteIds.contains(Long.valueOf(map$Entry.getKey().longValue()))) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        Collection collectionValues = linkedHashMap.values();
        WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2 widgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2 = WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2.INSTANCE;
        Object widgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0 = widgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2;
        if (widgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2 != null) {
            widgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0 = new WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0(widgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1$sortedUsers$2);
        }
        List<User> listSortedWith = u.sortedWith(collectionValues, (Comparator) widgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0);
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listSortedWith, 10));
        for (User user : listSortedWith) {
            arrayList.add(new SimpleMembersAdapter$MemberItem(user, this.$storeGuilds.getMember(guildId, user.getId())));
        }
        if (!WidgetChannelSettingsPermissionsAdvanced$Model.Companion.isValid(meSnapshot, guild, channel, l)) {
            return null;
        }
        m.checkNotNull(guild);
        m.checkNotNull(l);
        return new WidgetChannelSettingsPermissionsAdvanced$Model(meSnapshot, guild, channel, l.longValue(), map, arrayList);
    }
}
