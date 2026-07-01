package com.discord.widgets.channels.memberlist;

import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannelMembers;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMembers;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserRelationships;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion {
    private WidgetChannelMembersListViewModel$Companion() {
    }

    private final Observable<WidgetChannelMembersListViewModel$StoreState> observeStoreState(StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storePresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined) {
        Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new WidgetChannelMembersListViewModel$Companion$observeStoreState$1(storeNavigation.observeRightPanelState().G(WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1.INSTANCE), privateChannelMemberListService, storeUserRelationships, storeChannels, storePermissions, storeChannelMembers, storeGuilds, storeThreadMembers, storeUser, storePresence, storeApplicationStreaming, storeThreadsJoined));
        m.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetChannelMembersListViewModel$Companion widgetChannelMembersListViewModel$Companion, StoreGuilds storeGuilds, StoreChannelMembers storeChannelMembers, StoreThreadMembers storeThreadMembers, StoreChannelsSelected storeChannelsSelected, StoreNavigation storeNavigation, PrivateChannelMemberListService privateChannelMemberListService, StorePermissions storePermissions, StoreUserRelationships storeUserRelationships, StoreChannels storeChannels, StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, StoreThreadsJoined storeThreadsJoined, int i, Object obj) {
        return widgetChannelMembersListViewModel$Companion.observeStoreState((i & 1) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 2) != 0 ? StoreStream.Companion.getChannelMembers() : storeChannelMembers, (i & 4) != 0 ? StoreStream.Companion.getThreadMembers() : storeThreadMembers, (i & 8) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected, (i & 16) != 0 ? StoreStream.Companion.getNavigation() : storeNavigation, (i & 32) != 0 ? new PrivateChannelMemberListService(null, null, null, 7, null) : privateChannelMemberListService, (i & 64) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.Companion.getUserRelationships() : storeUserRelationships, (i & 256) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 512) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 1024) != 0 ? StoreStream.Companion.getPresences() : storeUserPresence, (i & 2048) != 0 ? StoreStream.Companion.getApplicationStreaming() : storeApplicationStreaming, (i & 4096) != 0 ? StoreStream.Companion.getThreadsJoined() : storeThreadsJoined);
    }

    public /* synthetic */ WidgetChannelMembersListViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
