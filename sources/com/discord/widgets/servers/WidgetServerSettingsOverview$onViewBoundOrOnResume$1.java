package com.discord.widgets.servers;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$onViewBoundOrOnResume$1 extends o implements Function1<WidgetServerSettingsOverview$Model, Unit> {
    public final /* synthetic */ WidgetServerSettingsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsOverview$onViewBoundOrOnResume$1(WidgetServerSettingsOverview widgetServerSettingsOverview) {
        super(1);
        this.this$0 = widgetServerSettingsOverview;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        invoke2(widgetServerSettingsOverview$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsOverview$Model widgetServerSettingsOverview$Model) {
        WidgetServerSettingsOverview.access$configureUI(this.this$0, widgetServerSettingsOverview$Model);
    }
}
