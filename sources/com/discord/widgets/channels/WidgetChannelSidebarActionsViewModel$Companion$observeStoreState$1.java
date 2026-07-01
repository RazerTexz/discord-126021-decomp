package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1<T, R> implements b<PanelState, Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildNSFW;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    public WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1(StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeUser = storeUser;
        this.$storeChannels = storeChannels;
        this.$storeGuildNSFW = storeGuildsNsfw;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState> call(PanelState panelState) {
        return call2(panelState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState> call2(PanelState panelState) {
        return this.$storeChannelsSelected.observeSelectedChannel().Y(new WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1(this, panelState));
    }
}
