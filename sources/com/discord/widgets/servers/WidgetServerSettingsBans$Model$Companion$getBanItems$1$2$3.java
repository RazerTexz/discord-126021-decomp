package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.User;
import com.discord.models.domain.ModelBan;
import d0.g0.t;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$3<T1, T2, R> implements Func2<WidgetServerSettingsBans$Model$BanItem, WidgetServerSettingsBans$Model$BanItem, Integer> {
    public static final WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$3 INSTANCE = new WidgetServerSettingsBans$Model$Companion$getBanItems$1$2$3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Integer call(WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem, WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem2) {
        return call2(widgetServerSettingsBans$Model$BanItem, widgetServerSettingsBans$Model$BanItem2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Integer call2(WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem, WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem2) {
        User user;
        String username;
        String username2;
        User user2;
        ModelBan ban = widgetServerSettingsBans$Model$BanItem.getBan();
        if (ban == null || (user = ban.getUser()) == null || (username = user.getUsername()) == null) {
            return null;
        }
        ModelBan ban2 = widgetServerSettingsBans$Model$BanItem2.getBan();
        if (ban2 == null || (user2 = ban2.getUser()) == null || (username2 = user2.getUsername()) == null) {
            username2 = "";
        }
        return Integer.valueOf(t.compareTo(username, username2, true));
    }
}
