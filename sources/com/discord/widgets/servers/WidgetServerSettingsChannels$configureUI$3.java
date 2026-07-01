package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$configureUI$3<T> implements Action1<Map<Long, ? extends SettingsChannelListAdapter$UpdatedPosition>> {
    public final /* synthetic */ WidgetServerSettingsChannels$Model $model;
    public final /* synthetic */ WidgetServerSettingsChannels this$0;

    public WidgetServerSettingsChannels$configureUI$3(WidgetServerSettingsChannels widgetServerSettingsChannels, WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model) {
        this.this$0 = widgetServerSettingsChannels;
        this.$model = widgetServerSettingsChannels$Model;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Map<Long, ? extends SettingsChannelListAdapter$UpdatedPosition> map) {
        call2((Map<Long, SettingsChannelListAdapter$UpdatedPosition>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Map<Long, SettingsChannelListAdapter$UpdatedPosition> map) {
        WidgetServerSettingsChannels widgetServerSettingsChannels = this.this$0;
        WidgetServerSettingsChannels$Model widgetServerSettingsChannels$Model = this.$model;
        m.checkNotNullExpressionValue(map, "newPositions");
        WidgetServerSettingsChannels.access$reorderChannels(widgetServerSettingsChannels, widgetServerSettingsChannels$Model, map);
    }
}
