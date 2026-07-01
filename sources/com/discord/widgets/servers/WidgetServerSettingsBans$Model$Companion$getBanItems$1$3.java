package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import java.util.List;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1$3<T1, T2, T3, R> implements Func3<Guild, Integer, List<WidgetServerSettingsBans$Model$BanItem>, WidgetServerSettingsBans$Model> {
    public static final WidgetServerSettingsBans$Model$Companion$getBanItems$1$3 INSTANCE = new WidgetServerSettingsBans$Model$Companion$getBanItems$1$3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsBans$Model call(Guild guild, Integer num, List<WidgetServerSettingsBans$Model$BanItem> list) {
        return call2(guild, num, list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsBans$Model call2(Guild guild, Integer num, List<WidgetServerSettingsBans$Model$BanItem> list) {
        return WidgetServerSettingsBans$Model.Companion.create(guild, num, list);
    }
}
