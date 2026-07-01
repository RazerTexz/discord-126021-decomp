package com.discord.widgets.settings.connections;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel$1<T1, T2, R> implements Func2<WidgetSettingsUserConnectionsViewModel$StoreState, Map<String, ? extends WidgetSettingsUserConnectionsViewModel$JoinStatus>, List<? extends WidgetSettingsUserConnectionsViewModel$ConnectionState>> {
    public final /* synthetic */ WidgetSettingsUserConnectionsViewModel this$0;

    public WidgetSettingsUserConnectionsViewModel$1(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        this.this$0 = widgetSettingsUserConnectionsViewModel;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ List<? extends WidgetSettingsUserConnectionsViewModel$ConnectionState> call(WidgetSettingsUserConnectionsViewModel$StoreState widgetSettingsUserConnectionsViewModel$StoreState, Map<String, ? extends WidgetSettingsUserConnectionsViewModel$JoinStatus> map) {
        return call2(widgetSettingsUserConnectionsViewModel$StoreState, map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final List<WidgetSettingsUserConnectionsViewModel$ConnectionState> call2(WidgetSettingsUserConnectionsViewModel$StoreState widgetSettingsUserConnectionsViewModel$StoreState, Map<String, ? extends WidgetSettingsUserConnectionsViewModel$JoinStatus> map) {
        WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetSettingsUserConnectionsViewModel$StoreState, "storeState");
        m.checkNotNullExpressionValue(map, "joinMap");
        return WidgetSettingsUserConnectionsViewModel.access$combineState(widgetSettingsUserConnectionsViewModel, widgetSettingsUserConnectionsViewModel$StoreState, map);
    }
}
