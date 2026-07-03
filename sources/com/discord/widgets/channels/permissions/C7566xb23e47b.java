package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreUser;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$Companion$observeStores$1 */
/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7566xb23e47b extends AbstractC12240o implements Function0<WidgetStageChannelModeratorPermissionsViewModel.StoreState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ StorePermissions $permissionStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7566xb23e47b(StoreChannels storeChannels, long j, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions) {
        super(0);
        this.$channelStore = storeChannels;
        this.$channelId = j;
        this.$guildStore = storeGuilds;
        this.$userStore = storeUser;
        this.$permissionStore = storePermissions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageChannelModeratorPermissionsViewModel.StoreState invoke() {
        Channel channel = this.$channelStore.getChannel(this.$channelId);
        if (channel == null || channel.getType() != 13) {
            return WidgetStageChannelModeratorPermissionsViewModel.StoreState.Invalid.INSTANCE;
        }
        Guild guild = (Guild) C1643a.m843c(channel, this.$guildStore.getGuilds());
        if (guild == null) {
            return WidgetStageChannelModeratorPermissionsViewModel.StoreState.Invalid.INSTANCE;
        }
        List<PermissionOverwrite> listM7655v = channel.m7655v();
        if (listM7655v == null) {
            listM7655v = C12147n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listM7655v.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).getType() == PermissionOverwrite.Type.MEMBER) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((PermissionOverwrite) it2.next()).m8131e()));
        }
        Set set = C12163u.toSet(arrayList2);
        Map mapEmptyMap = (Map) C1643a.m843c(channel, this.$guildStore.getRoles());
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        Map map = mapEmptyMap;
        Map<Long, User> users = this.$userStore.getUsers(set, true);
        Map mapEmptyMap2 = (Map) C1643a.m843c(channel, this.$guildStore.getMembers());
        if (mapEmptyMap2 == null) {
            mapEmptyMap2 = C12136h0.emptyMap();
        }
        return new WidgetStageChannelModeratorPermissionsViewModel.StoreState.Valid(guild, listM7655v, map, users, mapEmptyMap2, this.$userStore.getUsers(C12145m.listOf(Long.valueOf(guild.getOwnerId())), true).get(Long.valueOf(guild.getOwnerId())), StageChannelUtils.computeCanEditStageModerators(this.$permissionStore, this.$guildStore, this.$userStore.getMeSnapshot().getId(), guild.getId(), channel));
    }
}
