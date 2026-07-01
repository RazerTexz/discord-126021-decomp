package com.discord.widgets.settings.connections;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel$2 extends o implements Function1<List<? extends WidgetSettingsUserConnectionsViewModel$ConnectionState>, Unit> {
    public final /* synthetic */ WidgetSettingsUserConnectionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsViewModel$2(WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel) {
        super(1);
        this.this$0 = widgetSettingsUserConnectionsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetSettingsUserConnectionsViewModel$ConnectionState> list) {
        invoke2((List<WidgetSettingsUserConnectionsViewModel$ConnectionState>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<WidgetSettingsUserConnectionsViewModel$ConnectionState> list) {
        WidgetSettingsUserConnectionsViewModel widgetSettingsUserConnectionsViewModel = this.this$0;
        m.checkNotNullExpressionValue(list, "storeState");
        WidgetSettingsUserConnectionsViewModel.access$handleConnectionsState(widgetSettingsUserConnectionsViewModel, list);
    }
}
