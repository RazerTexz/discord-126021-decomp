package com.discord.widgets.channels.permissions;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageChannelModeratorPermissions$configureUI$2 extends k implements Function1<PermissionOwner, Unit> {
    public WidgetStageChannelModeratorPermissions$configureUI$2(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
        invoke2(permissionOwner);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PermissionOwner permissionOwner) {
        m.checkNotNullParameter(permissionOwner, "p1");
        WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
    }
}
