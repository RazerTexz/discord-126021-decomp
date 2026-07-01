package com.discord.widgets.stage.sheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet$onViewCreated$1$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetStageModeratorJoinBottomSheet$onViewCreated$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageModeratorJoinBottomSheet$onViewCreated$1$2(WidgetStageModeratorJoinBottomSheet$onViewCreated$1 widgetStageModeratorJoinBottomSheet$onViewCreated$1) {
        super(0);
        this.this$0 = widgetStageModeratorJoinBottomSheet$onViewCreated$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetStageModeratorJoinBottomSheet.access$setSelfSpeaker(this.this$0.this$0);
    }
}
