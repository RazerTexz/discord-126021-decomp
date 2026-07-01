package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureBannerImage$1$1<T> implements Action1<String> {
    public final /* synthetic */ WidgetServerSettingsOverview$configureBannerImage$1 this$0;

    public WidgetServerSettingsOverview$configureBannerImage$1$1(WidgetServerSettingsOverview$configureBannerImage$1 widgetServerSettingsOverview$configureBannerImage$1) {
        this.this$0 = widgetServerSettingsOverview$configureBannerImage$1;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetServerSettingsOverview$configureBannerImage$1 widgetServerSettingsOverview$configureBannerImage$1 = this.this$0;
        WidgetServerSettingsOverview.access$configureBannerImage(widgetServerSettingsOverview$configureBannerImage$1.this$0, widgetServerSettingsOverview$configureBannerImage$1.$bannerOriginalUrl, str, true);
    }
}
