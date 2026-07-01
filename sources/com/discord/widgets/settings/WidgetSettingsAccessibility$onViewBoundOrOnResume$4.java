package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility$onViewBoundOrOnResume$4<T> implements Action1<Boolean> {
    public static final WidgetSettingsAccessibility$onViewBoundOrOnResume$4 INSTANCE = new WidgetSettingsAccessibility$onViewBoundOrOnResume$4();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings userSettings = StoreStream.Companion.getUserSettings();
        m.checkNotNullExpressionValue(bool, "checked");
        userSettings.setIsAutoPlayGifsEnabled(bool.booleanValue());
    }
}
