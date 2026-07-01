package com.discord.widgets.channels.permissions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$1 extends o implements Function1<WidgetChannelSettingsPermissionsOverview$Model, Unit> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$1(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        super(1);
        this.this$0 = widgetChannelSettingsPermissionsOverview;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsPermissionsOverview$Model widgetChannelSettingsPermissionsOverview$Model) {
        invoke2(widgetChannelSettingsPermissionsOverview$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSettingsPermissionsOverview$Model widgetChannelSettingsPermissionsOverview$Model) {
        WidgetChannelSettingsPermissionsOverview.access$configureUI(this.this$0, widgetChannelSettingsPermissionsOverview$Model);
    }
}
