package com.discord.widgets.directories;

import b.d.b.a.a;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel$Companion$observeStores$1 extends o implements Function0<WidgetDirectoriesSearchViewModel$ViewState> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreGuildSelected $guildSelectedStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearchViewModel$Companion$observeStores$1(StorePermissions storePermissions, StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, long j) {
        super(0);
        this.$permissionsStore = storePermissions;
        this.$guildsStore = storeGuilds;
        this.$guildSelectedStore = storeGuildSelected;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetDirectoriesSearchViewModel$ViewState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoriesSearchViewModel$ViewState invoke() {
        Map<Long, Long> guildPermissions = this.$permissionsStore.getGuildPermissions();
        Guild guild = this.$guildsStore.getGuild(this.$guildSelectedStore.getSelectedGuildId());
        Map<Long, Long> permissionsByChannel = this.$permissionsStore.getPermissionsByChannel();
        Set<Long> setKeySet = this.$guildsStore.getGuilds().keySet();
        Collection<Guild> collectionValues = this.$guildsStore.getGuilds().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(8L, (Long) a.e((Guild) obj, guildPermissions))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        return new WidgetDirectoriesSearchViewModel$ViewState(guild, null, null, setKeySet, u.toSet(arrayList2), PermissionUtils.can(Permission.SEND_MESSAGES, permissionsByChannel.get(Long.valueOf(this.$channelId))), null, 70, null);
    }
}
