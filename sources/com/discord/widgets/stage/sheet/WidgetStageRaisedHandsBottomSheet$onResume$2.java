package com.discord.widgets.stage.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet$onResume$2 extends o implements Function1<WidgetStageRaisedHandsBottomSheetViewModel$Event, Unit> {
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheet$onResume$2(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        super(1);
        this.this$0 = widgetStageRaisedHandsBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel$Event widgetStageRaisedHandsBottomSheetViewModel$Event) {
        invoke2(widgetStageRaisedHandsBottomSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel$Event widgetStageRaisedHandsBottomSheetViewModel$Event) {
        m.checkNotNullParameter(widgetStageRaisedHandsBottomSheetViewModel$Event, "event");
        WidgetStageRaisedHandsBottomSheet.access$handleEvent(this.this$0, widgetStageRaisedHandsBottomSheetViewModel$Event);
    }
}
