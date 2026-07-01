package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$configureFriendSourceRadio$2<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public WidgetSettingsPrivacy$configureFriendSourceRadio$2(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetSettingsPrivacy widgetSettingsPrivacy = this.this$0;
        m.checkNotNullExpressionValue(bool, "checked");
        WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 1, bool.booleanValue());
    }
}
