package com.discord.widgets.stage.sheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet$onViewCreated$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetStageStartEventBottomSheet$onViewCreated$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageStartEventBottomSheet$onViewCreated$2$1(WidgetStageStartEventBottomSheet$onViewCreated$2 widgetStageStartEventBottomSheet$onViewCreated$2) {
        super(0);
        this.this$0 = widgetStageStartEventBottomSheet$onViewCreated$2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetStageStartEventBottomSheet.access$getViewModel$p(this.this$0.this$0).openStage(false);
        Function0<Unit> onDismiss = this.this$0.this$0.getOnDismiss();
        if (onDismiss != null) {
            onDismiss.invoke();
        }
    }
}
