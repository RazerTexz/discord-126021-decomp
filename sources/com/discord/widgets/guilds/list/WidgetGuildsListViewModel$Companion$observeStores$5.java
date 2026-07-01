package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.tabs.NavigationTab;
import j0.k.b;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$5<T, R> implements b<NavigationTab, Boolean> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$5 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$5();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(NavigationTab navigationTab) {
        return call2(navigationTab);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(NavigationTab navigationTab) {
        return Boolean.valueOf(navigationTab == NavigationTab.HOME);
    }
}
