package com.discord.widgets.channels.permissions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel$1 extends o implements Function1<WidgetStageChannelModeratorPermissionsViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissionsViewModel$1(WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel) {
        super(1);
        this.this$0 = widgetStageChannelModeratorPermissionsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel$StoreState widgetStageChannelModeratorPermissionsViewModel$StoreState) {
        invoke2(widgetStageChannelModeratorPermissionsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel$StoreState widgetStageChannelModeratorPermissionsViewModel$StoreState) {
        WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetStageChannelModeratorPermissionsViewModel$StoreState, "storeState");
        WidgetStageChannelModeratorPermissionsViewModel.access$handleStoreState(widgetStageChannelModeratorPermissionsViewModel, widgetStageChannelModeratorPermissionsViewModel$StoreState);
    }
}
