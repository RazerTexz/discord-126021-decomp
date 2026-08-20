package com.discord.widgets.directories;

import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearchViewModel$Companion$observeStores$1 extends AbstractC12240o implements Function0<WidgetDirectoriesSearchViewModel.ViewState> {
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoriesSearchViewModel.ViewState invoke() {
        Map<Long, Long> guildPermissions = this.$permissionsStore.getGuildPermissions();
        Guild guild = this.$guildsStore.getGuild(this.$guildSelectedStore.getSelectedGuildId());
        Map<Long, Long> permissionsByChannel = this.$permissionsStore.getPermissionsByChannel();
        Set<Long> setKeySet = this.$guildsStore.getGuilds().keySet();
        Collection<Guild> collectionValues = this.$guildsStore.getGuilds().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(8L, (Long) C1643a.m847e((Guild) obj, guildPermissions))) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        return new WidgetDirectoriesSearchViewModel.ViewState(guild, null, null, setKeySet, C12163u.toSet(arrayList2), PermissionUtils.can(Permission.SEND_MESSAGES, permissionsByChannel.get(Long.valueOf(this.$channelId))), null, 70, null);
    }
}
