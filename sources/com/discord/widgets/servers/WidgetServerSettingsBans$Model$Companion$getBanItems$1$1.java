package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import j0.k.b;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1$1<T, R> implements b<Guild, WidgetServerSettingsBans$Model> {
    public static final WidgetServerSettingsBans$Model$Companion$getBanItems$1$1 INSTANCE = new WidgetServerSettingsBans$Model$Companion$getBanItems$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetServerSettingsBans$Model call(Guild guild) {
        return call2(guild);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsBans$Model call2(Guild guild) {
        return WidgetServerSettingsBans$Model$Companion.access$createLoading(WidgetServerSettingsBans$Model.Companion, guild);
    }
}
