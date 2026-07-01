package com.discord.widgets.channels.permissions;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsEditPermissions$onViewBoundOrOnResume$1 extends k implements Function1<WidgetChannelSettingsEditPermissionsModel, Unit> {
    public WidgetChannelSettingsEditPermissions$onViewBoundOrOnResume$1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(1, widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
        invoke2(widgetChannelSettingsEditPermissionsModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
        WidgetChannelSettingsEditPermissions.access$configureUI((WidgetChannelSettingsEditPermissions) this.receiver, widgetChannelSettingsEditPermissionsModel);
    }
}
