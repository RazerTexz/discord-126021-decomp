package com.discord.widgets.voice.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet$onResume$1 extends o implements Function1<WidgetNoiseCancellationBottomSheetViewModel$Event, Unit> {
    public final /* synthetic */ WidgetNoiseCancellationBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoiseCancellationBottomSheet$onResume$1(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet) {
        super(1);
        this.this$0 = widgetNoiseCancellationBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetNoiseCancellationBottomSheetViewModel$Event widgetNoiseCancellationBottomSheetViewModel$Event) {
        invoke2(widgetNoiseCancellationBottomSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetNoiseCancellationBottomSheetViewModel$Event widgetNoiseCancellationBottomSheetViewModel$Event) {
        m.checkNotNullParameter(widgetNoiseCancellationBottomSheetViewModel$Event, "event");
        WidgetNoiseCancellationBottomSheet.access$handleEvent(this.this$0, widgetNoiseCancellationBottomSheetViewModel$Event);
    }
}
