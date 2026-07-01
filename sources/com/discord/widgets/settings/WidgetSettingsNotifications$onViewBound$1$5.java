package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreNotifications;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotifications$onViewBound$1$5<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreNotifications $this_apply;

    public WidgetSettingsNotifications$onViewBound$1$5(StoreNotifications storeNotifications) {
        this.$this_apply = storeNotifications;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreNotifications storeNotifications = this.$this_apply;
        m.checkNotNullExpressionValue(bool, "isChecked");
        storeNotifications.setNotificationSoundDisabled(bool.booleanValue());
    }
}
