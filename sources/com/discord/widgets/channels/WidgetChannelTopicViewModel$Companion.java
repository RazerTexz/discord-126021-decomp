package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$Companion {
    private WidgetChannelTopicViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$mapChannelToGuildStoreState(WidgetChannelTopicViewModel$Companion widgetChannelTopicViewModel$Companion, Channel channel, WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
        return widgetChannelTopicViewModel$Companion.mapChannelToGuildStoreState(channel, widgetChannelTopicViewModel$Companion$NavState, storeChannels, storeUser, storeGuilds, storeUserSettings);
    }

    public static final /* synthetic */ Observable access$mapChannelToPrivateStoreState(WidgetChannelTopicViewModel$Companion widgetChannelTopicViewModel$Companion, Channel channel, WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
        return widgetChannelTopicViewModel$Companion.mapChannelToPrivateStoreState(channel, widgetChannelTopicViewModel$Companion$NavState, storeGuilds, storeUserSettings);
    }

    private final Observable<WidgetChannelTopicViewModel$StoreState$Guild> mapChannelToGuildStoreState(Channel channel, WidgetChannelTopicViewModel$Companion$NavState navState, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
        long guildId = channel.getGuildId();
        Observable<WidgetChannelTopicViewModel$StoreState$Guild> observableG = Observable.g(StoreChannels.observeChannelsForGuild$default(storeChannels, guildId, null, 2, null), storeUsers.observeAllUsers(), storeGuilds.observeComputed(guildId), storeGuilds.observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeUserSettings, false, 1, null), new WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1(channel, navState));
        m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…HomeTab\n        )\n      }");
        return observableG;
    }

    private final Observable<WidgetChannelTopicViewModel$StoreState> mapChannelToPrivateStoreState(Channel channel, WidgetChannelTopicViewModel$Companion$NavState navState, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
        if (ChannelUtils.p(channel)) {
            k kVar = new k(new WidgetChannelTopicViewModel$StoreState$GDM(channel, storeUserSettings.getIsDeveloperMode(), navState.isRightPanelOpened(), navState.isOnHomeTab()));
            m.checkNotNullExpressionValue(kVar, "Observable.just(\n       …            )\n          )");
            return kVar;
        }
        Observable observableG = storeGuilds.observeComputed().G(new WidgetChannelTopicViewModel$Companion$mapChannelToPrivateStoreState$1(channel, storeUserSettings, navState));
        m.checkNotNullExpressionValue(observableG, "storeGuilds.observeCompu…            )\n          }");
        return observableG;
    }

    private final Observable<WidgetChannelTopicViewModel$Companion$NavState> observeNavState(StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation) {
        Observable<WidgetChannelTopicViewModel$Companion$NavState> observableJ = Observable.j(storeNavigation.observeRightPanelState().G(WidgetChannelTopicViewModel$Companion$observeNavState$1.INSTANCE), storeTabsNavigation.observeSelectedTab().G(WidgetChannelTopicViewModel$Companion$observeNavState$2.INSTANCE), WidgetChannelTopicViewModel$Companion$observeNavState$3.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…sOpen, isOnHomeTab)\n    }");
        return observableJ;
    }

    public static /* synthetic */ Observable observeNavState$default(WidgetChannelTopicViewModel$Companion widgetChannelTopicViewModel$Companion, StoreNavigation storeNavigation, StoreTabsNavigation storeTabsNavigation, int i, Object obj) {
        if ((i & 1) != 0) {
            storeNavigation = StoreStream.Companion.getNavigation();
        }
        if ((i & 2) != 0) {
            storeTabsNavigation = StoreStream.Companion.getTabsNavigation();
        }
        return widgetChannelTopicViewModel$Companion.observeNavState(storeNavigation, storeTabsNavigation);
    }

    private final Observable<WidgetChannelTopicViewModel$StoreState> observeStoreState(WidgetChannelTopicViewModel$Companion$NavState navState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUsers, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings) {
        Observable observableY = storeChannelsSelected.observeSelectedChannel().Y(new WidgetChannelTopicViewModel$Companion$observeStoreState$1(navState, storeGuilds, storeUserSettings, storeChannels, storeUsers));
        m.checkNotNullExpressionValue(observableY, "storeChannelsSelected\n  …            }\n          }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(WidgetChannelTopicViewModel$Companion widgetChannelTopicViewModel$Companion, WidgetChannelTopicViewModel$Companion$NavState widgetChannelTopicViewModel$Companion$NavState, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserSettings storeUserSettings, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannelsSelected = StoreStream.Companion.getChannelsSelected();
        }
        StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
        if ((i & 4) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 8) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 16) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 32) != 0) {
            storeUserSettings = StoreStream.Companion.getUserSettings();
        }
        return widgetChannelTopicViewModel$Companion.observeStoreState(widgetChannelTopicViewModel$Companion$NavState, storeChannelsSelected2, storeChannels2, storeUser2, storeGuilds2, storeUserSettings);
    }

    public /* synthetic */ WidgetChannelTopicViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
