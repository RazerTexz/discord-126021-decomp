package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList$AddGuildHint$Companion$get$2<T, R> implements b<WidgetGuildsList$AddGuildHint, Boolean> {
    public static final WidgetGuildsList$AddGuildHint$Companion$get$2 INSTANCE = new WidgetGuildsList$AddGuildHint$Companion$get$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint) {
        return call2(widgetGuildsList$AddGuildHint);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetGuildsList$AddGuildHint widgetGuildsList$AddGuildHint) {
        return Boolean.valueOf(widgetGuildsList$AddGuildHint.isEligible());
    }
}
