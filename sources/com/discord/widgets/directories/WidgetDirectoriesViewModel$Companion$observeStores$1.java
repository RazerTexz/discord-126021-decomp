package com.discord.widgets.directories;

import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.utilities.Default;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel$Companion$observeStores$1 extends AbstractC12240o implements Function0<WidgetDirectoriesViewModel.ViewState> {
    public final /* synthetic */ StoreChannelsSelected $channelsSelectedStore;
    public final /* synthetic */ StoreDirectories $directoriesStore;
    public final /* synthetic */ StoreGuildSelected $guildSelectedStore;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel$Companion$observeStores$1(StoreChannelsSelected storeChannelsSelected, StoreGuildSelected storeGuildSelected, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreDirectories storeDirectories) {
        super(0);
        this.$channelsSelectedStore = storeChannelsSelected;
        this.$guildSelectedStore = storeGuildSelected;
        this.$guildsStore = storeGuilds;
        this.$permissionsStore = storePermissions;
        this.$directoriesStore = storeDirectories;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:21:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00be  */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoriesViewModel.ViewState invoke() {
        RestCallState<List<DirectoryEntryGuild>> directoriesForChannel;
        RestCallState<Map<Integer, Integer>> entryCountsForChannel;
        Channel selectedChannel = this.$channelsSelectedStore.getSelectedChannel();
        Guild guild = this.$guildsStore.getGuild(this.$guildSelectedStore.getSelectedGuildId());
        Map<Long, Long> guildPermissions = this.$permissionsStore.getGuildPermissions();
        boolean zCan = PermissionUtils.can(Permission.SEND_MESSAGES, this.$permissionsStore.getPermissionsByChannel().get(selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null));
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
        Set set = C12163u.toSet(arrayList2);
        if (selectedChannel != null) {
            directoriesForChannel = this.$directoriesStore.getDirectoriesForChannel(selectedChannel.getId());
            if (directoriesForChannel == null) {
                directoriesForChannel = Default.INSTANCE;
            }
        } else {
            directoriesForChannel = Default.INSTANCE;
        }
        RestCallState<List<DirectoryEntryGuild>> restCallState = directoriesForChannel;
        if (selectedChannel != null) {
            entryCountsForChannel = this.$directoriesStore.getEntryCountsForChannel(selectedChannel.getId());
            if (entryCountsForChannel == null) {
                entryCountsForChannel = Default.INSTANCE;
            }
        } else {
            entryCountsForChannel = Default.INSTANCE;
        }
        return new WidgetDirectoriesViewModel.ViewState(guild, selectedChannel, setKeySet, set, zCan, restCallState, entryCountsForChannel);
    }
}
