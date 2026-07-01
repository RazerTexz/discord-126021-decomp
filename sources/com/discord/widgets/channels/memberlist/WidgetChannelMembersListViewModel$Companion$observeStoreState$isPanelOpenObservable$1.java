package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$c;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChannelMembersListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1<T, R> implements b<PanelState, Boolean> {
    public static final WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1 INSTANCE = new WidgetChannelMembersListViewModel$Companion$observeStoreState$isPanelOpenObservable$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(m.areEqual(panelState, PanelState$c.a));
    }
}
