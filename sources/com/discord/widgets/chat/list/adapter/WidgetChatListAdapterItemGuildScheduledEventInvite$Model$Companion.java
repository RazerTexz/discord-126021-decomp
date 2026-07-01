package com.discord.widgets.chat.list.adapter;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion {
    private WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion() {
    }

    public static /* synthetic */ Observable observe$default(WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion widgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion, GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, int i, Object obj) {
        return widgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion.observe(guildScheduledEventInviteEntry, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 32) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.Companion.getPermissions() : storePermissions);
    }

    public final Observable<WidgetChatListAdapterItemGuildScheduledEventInvite$Model> observe(GuildScheduledEventInviteEntry item, StoreGuilds guildStore, StoreUser userStore, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StorePermissions permissionStore) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(guildStore, "guildStore");
        m.checkNotNullParameter(userStore, "userStore");
        m.checkNotNullParameter(channelStore, "channelStore");
        m.checkNotNullParameter(guildScheduledEventStore, "guildScheduledEventStore");
        m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        m.checkNotNullParameter(permissionStore, "permissionStore");
        return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{guildStore, userStore, guildScheduledEventStore, voiceChannelSelectedStore, permissionStore}, false, null, null, new WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion$observe$1(item, guildStore, userStore, guildScheduledEventStore, channelStore, voiceChannelSelectedStore, permissionStore), 14, null);
    }

    public /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
