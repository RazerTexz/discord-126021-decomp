package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.app.AppActivity;
import com.discord.stores.StoreUserSettings;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia$onViewBound$1<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetSettingsMedia this$0;

    public WidgetSettingsMedia$onViewBound$1(WidgetSettingsMedia widgetSettingsMedia) {
        this.this$0 = widgetSettingsMedia;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StoreUserSettings storeUserSettingsAccess$getUserSettings$p = WidgetSettingsMedia.access$getUserSettings$p(this.this$0);
        AppActivity appActivity = this.this$0.getAppActivity();
        m.checkNotNullExpressionValue(bool, "checked");
        storeUserSettingsAccess$getUserSettings$p.setIsAttachmentMediaInline(appActivity, bool.booleanValue());
    }
}
