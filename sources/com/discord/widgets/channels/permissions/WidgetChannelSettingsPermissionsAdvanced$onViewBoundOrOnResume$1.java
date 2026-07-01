package com.discord.widgets.channels.permissions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced$onViewBoundOrOnResume$1 extends o implements Function1<WidgetChannelSettingsPermissionsAdvanced$Model, Unit> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAdvanced this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsAdvanced$onViewBoundOrOnResume$1(WidgetChannelSettingsPermissionsAdvanced widgetChannelSettingsPermissionsAdvanced) {
        super(1);
        this.this$0 = widgetChannelSettingsPermissionsAdvanced;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model) {
        invoke2(widgetChannelSettingsPermissionsAdvanced$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSettingsPermissionsAdvanced$Model widgetChannelSettingsPermissionsAdvanced$Model) {
        WidgetChannelSettingsPermissionsAdvanced.access$configureUI(this.this$0, widgetChannelSettingsPermissionsAdvanced$Model);
    }
}
