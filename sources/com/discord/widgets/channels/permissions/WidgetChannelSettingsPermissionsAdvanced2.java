package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced2 extends Lambda implements Function0<WidgetChannelSettingsPermissionsAdvanced.Model> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsAdvanced2(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions) {
        super(0);
        this.$storeChannels = storeChannels;
        this.$channelId = j;
        this.$storeGuilds = storeGuilds;
        this.$storeUser = storeUser;
        this.$storePermissions = storePermissions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsAdvanced.Model invoke() {
        Channel channel = this.$storeChannels.getChannel(this.$channelId);
        if (channel == null) {
            return null;
        }
        Collection overwriteIds = WidgetChannelSettingsPermissionsAdvanced.Model.INSTANCE.getOverwriteIds(channel, PermissionOverwrite.Type.MEMBER);
        long guildId = channel.getGuildId();
        Guild guild = this.$storeGuilds.getGuild(guildId);
        Map<Long, GuildRole> mapEmptyMap = this.$storeGuilds.getRoles().get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        Map<Long, GuildRole> map = mapEmptyMap;
        MeUser meSnapshot = this.$storeUser.getMeSnapshot();
        Long l = this.$storePermissions.getPermissionsByChannel().get(Long.valueOf(this.$channelId));
        Map<Long, User> users = this.$storeUser.getUsers();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            if (overwriteIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Collection collectionValues = linkedHashMap.values();
        final WidgetChannelSettingsPermissionsAdvanced3 widgetChannelSettingsPermissionsAdvanced3 = WidgetChannelSettingsPermissionsAdvanced3.INSTANCE;
        Object obj = widgetChannelSettingsPermissionsAdvanced3;
        if (widgetChannelSettingsPermissionsAdvanced3 != null) {
            obj = new Comparator() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj2, Object obj3) {
                    Object objInvoke = widgetChannelSettingsPermissionsAdvanced3.invoke(obj2, obj3);
                    Intrinsics3.checkNotNullExpressionValue(objInvoke, "invoke(...)");
                    return ((Number) objInvoke).intValue();
                }
            };
        }
        List<User> listSortedWith = _Collections.sortedWith(collectionValues, (Comparator) obj);
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
        for (User user : listSortedWith) {
            arrayList.add(new SimpleMembersAdapter.MemberItem(user, this.$storeGuilds.getMember(guildId, user.getId())));
        }
        if (!WidgetChannelSettingsPermissionsAdvanced.Model.INSTANCE.isValid(meSnapshot, guild, channel, l)) {
            return null;
        }
        Intrinsics3.checkNotNull(guild);
        Intrinsics3.checkNotNull(l);
        return new WidgetChannelSettingsPermissionsAdvanced.Model(meSnapshot, guild, channel, l.longValue(), map, arrayList);
    }
}
