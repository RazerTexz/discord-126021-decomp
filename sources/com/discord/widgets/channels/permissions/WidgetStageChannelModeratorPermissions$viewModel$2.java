package com.discord.widgets.channels.permissions;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions$viewModel$2 extends AbstractC12240o implements Function0<WidgetStageChannelModeratorPermissionsViewModel> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissions$viewModel$2(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        super(0);
        this.this$0 = widgetStageChannelModeratorPermissions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetStageChannelModeratorPermissionsViewModel invoke() {
        return new WidgetStageChannelModeratorPermissionsViewModel(this.this$0.getChannelId());
    }
}
