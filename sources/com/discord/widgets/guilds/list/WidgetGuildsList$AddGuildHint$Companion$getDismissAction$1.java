package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$a;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$AddGuildHint$Companion$getDismissAction$1<T, R> implements b<PanelState, Boolean> {
    public static final WidgetGuildsList$AddGuildHint$Companion$getDismissAction$1 INSTANCE = new WidgetGuildsList$AddGuildHint$Companion$getDismissAction$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(PanelState panelState) {
        return call2(panelState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(PanelState panelState) {
        return Boolean.valueOf(m.areEqual(panelState, PanelState$a.a));
    }
}
