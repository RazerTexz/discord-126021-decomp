package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettingsSystem;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$onViewBoundOrOnResume$2<T> implements Action1<Boolean> {
    public static final WidgetSettingsLanguage$onViewBoundOrOnResume$2 INSTANCE = new WidgetSettingsLanguage$onViewBoundOrOnResume$2();

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettingsSystem userSettingsSystem = StoreStream.Companion.getUserSettingsSystem();
        m.checkNotNullExpressionValue(bool, "checked");
        userSettingsSystem.setIsLocaleSyncEnabled(bool.booleanValue());
    }
}
