package com.discord.widgets.channels;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel$Companion {
    private WidgetChannelSidebarActionsViewModel$Companion() {
    }

    private final Observable<WidgetChannelSidebarActionsViewModel$StoreState> observeStoreState(StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildNSFW, StoreUser storeUser) {
        Observable observableY = storeNavigation.observeRightPanelState().Y(new WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1(storeChannelsSelected, storeUserGuildSettings, storeUser, storeChannels, storeGuildNSFW));
        m.checkNotNullExpressionValue(observableY, "storeNavigation\n        …          }\n            }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetChannelSidebarActionsViewModel$Companion widgetChannelSidebarActionsViewModel$Companion, StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, int i, Object obj) {
        if ((i & 1) != 0) {
            storeNavigation = StoreStream.Companion.getNavigation();
        }
        if ((i & 2) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 4) != 0) {
            storeChannelsSelected = StoreStream.Companion.getChannelsSelected();
        }
        StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
        if ((i & 8) != 0) {
            storeUserGuildSettings = StoreStream.Companion.getUserGuildSettings();
        }
        StoreUserGuildSettings storeUserGuildSettings2 = storeUserGuildSettings;
        if ((i & 16) != 0) {
            storeGuildsNsfw = StoreStream.Companion.getGuildsNsfw();
        }
        StoreGuildsNsfw storeGuildsNsfw2 = storeGuildsNsfw;
        if ((i & 32) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        return widgetChannelSidebarActionsViewModel$Companion.observeStoreState(storeNavigation, storeChannels2, storeChannelsSelected2, storeUserGuildSettings2, storeGuildsNsfw2, storeUser);
    }

    public /* synthetic */ WidgetChannelSidebarActionsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
