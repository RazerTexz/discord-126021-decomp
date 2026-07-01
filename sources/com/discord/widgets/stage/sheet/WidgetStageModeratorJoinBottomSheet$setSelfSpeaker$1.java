package com.discord.widgets.stage.sheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet$setSelfSpeaker$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetStageModeratorJoinBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageModeratorJoinBottomSheet$setSelfSpeaker$1(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        super(1);
        this.this$0 = widgetStageModeratorJoinBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        this.this$0.dismiss();
    }
}
