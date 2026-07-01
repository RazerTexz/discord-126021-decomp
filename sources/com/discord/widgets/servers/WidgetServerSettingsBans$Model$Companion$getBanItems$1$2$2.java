package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelBan;
import j0.k.b;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$2<T, R> implements b<ModelBan, WidgetServerSettingsBans$Model$BanItem> {
    public static final WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$2 INSTANCE = new WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetServerSettingsBans$Model$BanItem call(ModelBan modelBan) {
        return call2(modelBan);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsBans$Model$BanItem call2(ModelBan modelBan) {
        return new WidgetServerSettingsBans$Model$BanItem(modelBan);
    }
}
