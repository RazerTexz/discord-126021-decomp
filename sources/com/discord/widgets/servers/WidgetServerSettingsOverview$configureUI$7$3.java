package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureUI$7$3<T> implements Action1<WidgetServerSettingsOverview$Model> {
    public final /* synthetic */ WidgetServerSettingsOverview$configureUI$7 this$0;

    public WidgetServerSettingsOverview$configureUI$7$3(WidgetServerSettingsOverview$configureUI$7 widgetServerSettingsOverview$configureUI$7) {
        this.this$0 = widgetServerSettingsOverview$configureUI$7;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        call2(widgetServerSettingsOverview$Model);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        WidgetServerSettingsOverview.access$configureUpdatedGuild(this.this$0.this$0, widgetServerSettingsOverview$Model);
    }
}
