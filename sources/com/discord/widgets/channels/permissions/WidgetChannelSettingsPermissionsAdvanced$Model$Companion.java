package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.n;
import d0.t.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$Model$Companion {
    private WidgetChannelSettingsPermissionsAdvanced$Model$Companion() {
    }

    public static final /* synthetic */ Collection access$getOverwriteIds(WidgetChannelSettingsPermissionsAdvanced$Model$Companion widgetChannelSettingsPermissionsAdvanced$Model$Companion, Channel channel, PermissionOverwrite$Type permissionOverwrite$Type) {
        return widgetChannelSettingsPermissionsAdvanced$Model$Companion.getOverwriteIds(channel, permissionOverwrite$Type);
    }

    private final Collection<Long> getOverwriteIds(Channel channel, PermissionOverwrite$Type type) {
        List<PermissionOverwrite> listV = channel.v();
        if (listV == null) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : listV) {
            if (((PermissionOverwrite) obj).getType() == type) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Long.valueOf(((PermissionOverwrite) it.next()).e()));
        }
        return arrayList2;
    }

    public final Observable<WidgetChannelSettingsPermissionsAdvanced$Model> get(long channelId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        StoreChannels channels = storeStream$Companion.getChannels();
        StoreUser users = storeStream$Companion.getUsers();
        StorePermissions permissions = storeStream$Companion.getPermissions();
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{channels, users, permissions, guilds}, false, null, null, new WidgetChannelSettingsPermissionsAdvanced$Model$Companion$get$1(channels, channelId, guilds, users, permissions), 14, null);
    }

    public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
        return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
    }

    public /* synthetic */ WidgetChannelSettingsPermissionsAdvanced$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
