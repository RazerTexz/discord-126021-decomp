package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$configureUI$1<T> implements Action1<String> {
    public final /* synthetic */ WidgetServerSettingsEmojis$Model $model;
    public final /* synthetic */ WidgetServerSettingsEmojis this$0;

    public WidgetServerSettingsEmojis$configureUI$1(WidgetServerSettingsEmojis widgetServerSettingsEmojis, WidgetServerSettingsEmojis$Model widgetServerSettingsEmojis$Model) {
        this.this$0 = widgetServerSettingsEmojis;
        this.$model = widgetServerSettingsEmojis$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetServerSettingsEmojis widgetServerSettingsEmojis = this.this$0;
        String defaultName = this.$model.getDefaultName();
        m.checkNotNullExpressionValue(str, "dataUrl");
        WidgetServerSettingsEmojis.access$uploadEmoji(widgetServerSettingsEmojis, defaultName, str);
    }
}
