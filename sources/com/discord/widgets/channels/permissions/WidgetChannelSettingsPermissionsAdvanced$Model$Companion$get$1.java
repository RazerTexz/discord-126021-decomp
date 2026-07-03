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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1 extends AbstractC12240o implements Function0<WidgetChannelSettingsPermissionsAdvanced.Model> {
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
            mapEmptyMap = C12136h0.emptyMap();
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
        final C7545x6e0b1e05 c7545x6e0b1e05 = C7545x6e0b1e05.INSTANCE;
        Object obj = c7545x6e0b1e05;
        if (c7545x6e0b1e05 != null) {
            obj = new Comparator() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(Object obj2, Object obj3) {
                    Object objInvoke = c7545x6e0b1e05.invoke(obj2, obj3);
                    C12238m.checkNotNullExpressionValue(objInvoke, "invoke(...)");
                    return ((Number) objInvoke).intValue();
                }
            };
        }
        List<User> listSortedWith = C12163u.sortedWith(collectionValues, (Comparator) obj);
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listSortedWith, 10));
        for (User user : listSortedWith) {
            arrayList.add(new SimpleMembersAdapter.MemberItem(user, this.$storeGuilds.getMember(guildId, user.getId())));
        }
        if (!WidgetChannelSettingsPermissionsAdvanced.Model.INSTANCE.isValid(meSnapshot, guild, channel, l)) {
            return null;
        }
        C12238m.checkNotNull(guild);
        C12238m.checkNotNull(l);
        return new WidgetChannelSettingsPermissionsAdvanced.Model(meSnapshot, guild, channel, l.longValue(), map, arrayList);
    }
}
