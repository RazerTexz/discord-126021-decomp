package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.permissions.PermissionUtils;
import j0.k.b;

/* JADX INFO: compiled from: WidgetPruneUsersViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsersViewModel$1<T, R> implements b<WidgetPruneUsersViewModel$StoreData, Boolean> {
    public static final WidgetPruneUsersViewModel$1 INSTANCE = new WidgetPruneUsersViewModel$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(WidgetPruneUsersViewModel$StoreData widgetPruneUsersViewModel$StoreData) {
        return call2(widgetPruneUsersViewModel$StoreData);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetPruneUsersViewModel$StoreData widgetPruneUsersViewModel$StoreData) {
        return Boolean.valueOf((widgetPruneUsersViewModel$StoreData.getPermission() == null || widgetPruneUsersViewModel$StoreData.getUser() == null || widgetPruneUsersViewModel$StoreData.getGuild() == null || !PermissionUtils.canAndIsElevated(2L, widgetPruneUsersViewModel$StoreData.getPermission(), widgetPruneUsersViewModel$StoreData.getUser().getMfaEnabled(), widgetPruneUsersViewModel$StoreData.getGuild().getMfaLevel())) ? false : true);
    }
}
