package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.tabs.NavigationTab;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChannelTopicViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel$Companion$observeNavState$2<T, R> implements b<NavigationTab, Boolean> {
    public static final WidgetChannelTopicViewModel$Companion$observeNavState$2 INSTANCE = new WidgetChannelTopicViewModel$Companion$observeNavState$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(NavigationTab navigationTab) {
        return call2(navigationTab);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(NavigationTab navigationTab) {
        return Boolean.valueOf(navigationTab == NavigationTab.HOME);
    }
}
