package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Location$Section;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetSettingsMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsMedia$onViewBound$7<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetSettingsMedia this$0;

    public WidgetSettingsMedia$onViewBound$7(WidgetSettingsMedia widgetSettingsMedia) {
        this.this$0 = widgetSettingsMedia;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        m.checkNotNullExpressionValue(bool, "checked");
        analyticsTracker.stickerSuggestionsEnabledToggled(bool.booleanValue(), new Traits$Location(null, Traits$Location$Section.SETTINGS_TEXT_AND_IMAGES, null, null, null, 29, null));
        WidgetSettingsMedia.access$getUserSettings$p(this.this$0).setIsStickerSuggestionsEnabled(bool.booleanValue());
    }
}
