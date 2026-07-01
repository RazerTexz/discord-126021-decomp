package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsBehavior.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$3<T> implements Action1<Boolean> {
    public final /* synthetic */ StoreUserSettings $userSettings$inlined;

    public WidgetSettingsBehavior$onViewBound$$inlined$apply$lambda$3(StoreUserSettings storeUserSettings) {
        this.$userSettings$inlined = storeUserSettings;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettings = this.$userSettings$inlined;
        m.checkNotNullExpressionValue(bool, "isChecked");
        storeUserSettings.setIsChromeCustomTabsEnabled(bool.booleanValue());
    }
}
