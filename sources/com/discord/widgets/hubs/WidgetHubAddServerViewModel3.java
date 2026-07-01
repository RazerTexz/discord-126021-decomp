package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppLog;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.hubs.WidgetHubAddServerViewModel;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServerViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddServerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServerViewModel3 extends Lambda implements Function0<WidgetHubAddServerViewModel2> {
    public final /* synthetic */ StoreChannelsSelected $channelsSelectedStore;
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ StoreDirectories $directoriesStore;
    public final /* synthetic */ StoreGuildSelected $guildsSelected;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServerViewModel3(StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StorePermissions storePermissions, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreDirectories storeDirectories) {
        super(0);
        this.$guildsStore = storeGuilds;
        this.$guildsSelected = storeGuildSelected;
        this.$permissionsStore = storePermissions;
        this.$channelsSelectedStore = storeChannelsSelected;
        this.$channelsStore = storeChannels;
        this.$directoriesStore = storeDirectories;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:120:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0070  */
    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:27:0x0079  */
    /* JADX WARN: Code duplicated, block: B:31:0x008d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f2  */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAddServerViewModel2 invoke() {
        Object next;
        long id2;
        Iterator<T> it;
        Object next2;
        Map.Entry entry;
        boolean z2;
        List<DirectoryEntryGuild> listEmptyList;
        Collection<Guild> collectionValues = this.$guildsStore.getGuilds().values();
        Iterator<T> it2 = collectionValues.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (!(((Guild) next).getId() == this.$guildsSelected.getSelectedGuildId()));
        Guild guild = (Guild) next;
        if (guild == null) {
            WidgetHubAddServerViewModel.Companion companion = WidgetHubAddServerViewModel.INSTANCE;
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Missing guild for guild id: ");
            sbU.append(this.$guildsSelected.getSelectedGuildId());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            guild = null;
        }
        Map<Long, Long> guildPermissions = this.$permissionsStore.getGuildPermissions();
        Channel selectedChannel = this.$channelsSelectedStore.getSelectedChannel();
        if (selectedChannel == null) {
            StoreChannels storeChannels = this.$channelsStore;
            if (guild != null) {
                id2 = guild.getId();
            } else {
                id2 = -1;
            }
            it = storeChannels.getChannelsForGuild(id2).entrySet().iterator();
            do {
                if (it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                if (((Channel) ((Map.Entry) next2).getValue()).getType() == 14) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } while (!z2);
            entry = (Map.Entry) next2;
            if (entry != null) {
                selectedChannel = (Channel) entry.getValue();
            } else {
                selectedChannel = null;
            }
        } else {
            if (!ChannelUtils.o(selectedChannel)) {
                selectedChannel = null;
            }
            if (selectedChannel == null) {
                StoreChannels storeChannels2 = this.$channelsStore;
                if (guild != null) {
                    id2 = guild.getId();
                } else {
                    id2 = -1;
                }
                it = storeChannels2.getChannelsForGuild(id2).entrySet().iterator();
                do {
                    if (it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    if (((Channel) ((Map.Entry) next2).getValue()).getType() == 14) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } while (!z2);
                entry = (Map.Entry) next2;
                if (entry != null) {
                    selectedChannel = (Channel) entry.getValue();
                } else {
                    selectedChannel = null;
                }
            }
        }
        if (selectedChannel == null) {
            WidgetHubAddServerViewModel.Companion companion2 = WidgetHubAddServerViewModel.INSTANCE;
            AppLog appLog2 = AppLog.g;
            StringBuilder sbU2 = outline.U("Guild has no directory channels for id: ");
            sbU2.append(guild != null ? Long.valueOf(guild.getId()) : null);
            Logger.e$default(appLog2, sbU2.toString(), null, null, 6, null);
            selectedChannel = null;
        }
        if (selectedChannel != null) {
            RestCallState<List<DirectoryEntryGuild>> directoriesForChannel = this.$directoriesStore.getDirectoriesForChannel(selectedChannel.getId());
            if (directoriesForChannel != null) {
                listEmptyList = directoriesForChannel.invoke();
            } else {
                listEmptyList = null;
            }
        } else {
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listEmptyList, 10));
        Iterator it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            arrayList.add(Long.valueOf(((DirectoryEntryGuild) it3.next()).getGuild().getId()));
        }
        Set set = _Collections.toSet(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(8L, (Long) outline.e((Guild) obj, guildPermissions))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!set.contains(Long.valueOf(((Guild) obj2).getId()))) {
                arrayList3.add(obj2);
            } else {
                arrayList4.add(obj2);
            }
        }
        Tuples2 tuples2 = new Tuples2(arrayList3, arrayList4);
        List list = (List) tuples2.component1();
        List list2 = (List) tuples2.component2();
        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
        Iterator it4 = list2.iterator();
        while (it4.hasNext()) {
            arrayList5.add(Long.valueOf(((Guild) it4.next()).getId()));
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : listEmptyList) {
            if (arrayList5.contains(Long.valueOf(((DirectoryEntryGuild) obj3).getGuild().getId()))) {
                arrayList6.add(obj3);
            }
        }
        String name = guild != null ? guild.getName() : null;
        if (name == null) {
            name = "";
        }
        return new WidgetHubAddServerViewModel2(name, selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, 0, list, list2, arrayList6, 4, null);
    }
}
