package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1$1<T, R> implements b<Map<Long, ? extends User>, WidgetSettingsBlockedUsersViewModel$StoreState> {
    public static final WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1$1 INSTANCE = new WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetSettingsBlockedUsersViewModel$StoreState call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsBlockedUsersViewModel$StoreState call2(Map<Long, ? extends User> map) {
        m.checkNotNullExpressionValue(map, "users");
        return new WidgetSettingsBlockedUsersViewModel$StoreState(map);
    }
}
