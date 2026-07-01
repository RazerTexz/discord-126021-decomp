package com.discord.widgets.channels.permissions;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1 extends k implements Function1<WidgetStageChannelModeratorPermissionsViewModel$ViewState, Unit> {
    public WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel$ViewState widgetStageChannelModeratorPermissionsViewModel$ViewState) {
        invoke2(widgetStageChannelModeratorPermissionsViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel$ViewState widgetStageChannelModeratorPermissionsViewModel$ViewState) {
        m.checkNotNullParameter(widgetStageChannelModeratorPermissionsViewModel$ViewState, "p1");
        WidgetStageChannelModeratorPermissions.access$configureUI((WidgetStageChannelModeratorPermissions) this.receiver, widgetStageChannelModeratorPermissionsViewModel$ViewState);
    }
}
