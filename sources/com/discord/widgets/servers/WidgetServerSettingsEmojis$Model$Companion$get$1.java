package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$get$1<T, R> implements b<WidgetServerSettingsEmojis$Model$Permission, Observable<? extends WidgetServerSettingsEmojis$Model>> {
    public static final WidgetServerSettingsEmojis$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsEmojis$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEmojis$Model> call(WidgetServerSettingsEmojis$Model$Permission widgetServerSettingsEmojis$Model$Permission) {
        return call2(widgetServerSettingsEmojis$Model$Permission);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEmojis$Model> call2(WidgetServerSettingsEmojis$Model$Permission widgetServerSettingsEmojis$Model$Permission) {
        return (widgetServerSettingsEmojis$Model$Permission == null || !widgetServerSettingsEmojis$Model$Permission.getCanManage()) ? new k(null) : WidgetServerSettingsEmojis$Model$Companion.access$getGuildEmojis(WidgetServerSettingsEmojis$Model.Companion, widgetServerSettingsEmojis$Model$Permission.getGuild());
    }
}
