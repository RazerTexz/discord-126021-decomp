package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.stage.StageChannelUtils;
import d0.t.h0;
import d0.t.m;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel$Companion$observeStores$1 extends o implements Function0<WidgetStageChannelModeratorPermissionsViewModel$StoreState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ StorePermissions $permissionStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissionsViewModel$Companion$observeStores$1(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions) {
        super(0);
        this.$channelStore = storeChannels;
        this.$channelId = j;
        this.$guildStore = storeGuilds;
        this.$userStore = storeUser;
        this.$permissionStore = storePermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel$StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageChannelModeratorPermissionsViewModel$StoreState invoke() {
        Channel channel = this.$channelStore.getChannel(this.$channelId);
        if (channel == null || channel.getType() != 13) {
            return WidgetStageChannelModeratorPermissionsViewModel$StoreState$Invalid.INSTANCE;
        }
        Guild guild = (Guild) a.c(channel, this.$guildStore.getGuilds());
        if (guild == null) {
            return WidgetStageChannelModeratorPermissionsViewModel$StoreState$Invalid.INSTANCE;
        }
        List<PermissionOverwrite> listV = channel.v();
        if (listV == null) {
            listV = n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listV.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).getType() == PermissionOverwrite$Type.MEMBER) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((PermissionOverwrite) it2.next()).e()));
        }
        Set set = u.toSet(arrayList2);
        Map mapEmptyMap = (Map) a.c(channel, this.$guildStore.getRoles());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Map map = mapEmptyMap;
        Map<Long, User> users = this.$userStore.getUsers(set, true);
        Map mapEmptyMap2 = (Map) a.c(channel, this.$guildStore.getMembers());
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = h0.emptyMap();
        }
        return new WidgetStageChannelModeratorPermissionsViewModel$StoreState$Valid(guild, listV, map, users, mapEmptyMap2, this.$userStore.getUsers(m.listOf(Long.valueOf(guild.getOwnerId())), true).get(Long.valueOf(guild.getOwnerId())), StageChannelUtils.computeCanEditStageModerators(this.$permissionStore, this.$guildStore, this.$userStore.getMeSnapshot().getId(), guild.getId(), channel));
    }
}
