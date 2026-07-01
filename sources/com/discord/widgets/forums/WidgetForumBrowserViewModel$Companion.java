package com.discord.widgets.forums;

import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserTyping;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$Companion {
    private WidgetForumBrowserViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetForumBrowserViewModel$Companion widgetForumBrowserViewModel$Companion, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsActive storeThreadsActive, ArchivedThreadsStore archivedThreadsStore, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping) {
        return widgetForumBrowserViewModel$Companion.observeStoreState(storeUser, storeChannels, storeGuilds, storeThreadsActive, archivedThreadsStore, storeThreadMessages, storeForumPostMessages, storeUserRelationships, storeChannelsSelected, storeTabsNavigation, storeExperiments, storePermissions, storeMessagesMostRecent, storeEmoji, storeForumPostReadStates, storeUserTyping);
    }

    private final Observable<WidgetForumBrowserViewModel$MinimalStoreState> observeMinimalStoreState(StoreThreadsActive storeThreadsActive, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments) {
        Observable observableY = storeChannelsSelected.observeResolvedSelectedChannel().Y(new WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1(storeTabsNavigation, storeThreadsActive, storeExperiments));
        m.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…      }\n        }\n      }");
        return observableY;
    }

    private final Observable<WidgetForumBrowserViewModel$StoreState> observeStoreState(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreThreadsActive storeThreadsActive, ArchivedThreadsStore storeArchivedThreads, StoreThreadMessages storeThreadsMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping) {
        Observable observableY = observeMinimalStoreState(storeThreadsActive, storeChannelsSelected, storeTabsNavigation, storeExperiments).Y(new WidgetForumBrowserViewModel$Companion$observeStoreState$1(storeUser, storeArchivedThreads, storeChannels, storeGuilds, storeForumPostMessages, storeThreadsMessages, storeUserRelationships, storePermissions, storeMessagesMostRecent, storeEmoji, storeForumPostReadStates, storeThreadsActive, storeUserTyping));
        m.checkNotNullExpressionValue(observableY, "observeMinimalStoreState…      }\n        }\n      }");
        return observableY;
    }

    public /* synthetic */ WidgetForumBrowserViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
