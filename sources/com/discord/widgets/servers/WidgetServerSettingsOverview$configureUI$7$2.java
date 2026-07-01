package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$7$2<T, R> implements b<Guild, Observable<? extends WidgetServerSettingsOverview$Model>> {
    public static final WidgetServerSettingsOverview$configureUI$7$2 INSTANCE = new WidgetServerSettingsOverview$configureUI$7$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsOverview$Model> call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsOverview$Model> call2(Guild guild) {
        return WidgetServerSettingsOverview$Model.Companion.get(guild.getId());
    }
}
