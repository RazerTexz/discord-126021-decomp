package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$c;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetGuildsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsListViewModel$Companion$observeStores$4<T, R> implements b<PanelState, Boolean> {
    public static final WidgetGuildsListViewModel$Companion$observeStores$4 INSTANCE = new WidgetGuildsListViewModel$Companion$observeStores$4();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(m.areEqual(panelState, PanelState$c.a));
    }
}
