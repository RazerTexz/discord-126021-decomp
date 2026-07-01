package com.discord.widgets.settings.connections;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnections$onViewBoundOrOnResume$1 extends o implements Function1<WidgetSettingsUserConnectionsViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetSettingsUserConnections this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnections$onViewBoundOrOnResume$1(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        super(1);
        this.this$0 = widgetSettingsUserConnections;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsUserConnectionsViewModel$ViewState widgetSettingsUserConnectionsViewModel$ViewState) {
        invoke2(widgetSettingsUserConnectionsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetSettingsUserConnectionsViewModel$ViewState widgetSettingsUserConnectionsViewModel$ViewState) {
        m.checkNotNullParameter(widgetSettingsUserConnectionsViewModel$ViewState, "viewState");
        WidgetSettingsUserConnections.access$handleViewState(this.this$0, widgetSettingsUserConnectionsViewModel$ViewState);
    }
}
