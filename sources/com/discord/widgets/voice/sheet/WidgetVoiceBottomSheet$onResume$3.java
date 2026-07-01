package com.discord.widgets.voice.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheet$onResume$3 extends o implements Function1<WidgetVoiceBottomSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetVoiceBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheet$onResume$3(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(1);
        this.this$0 = widgetVoiceBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel$ViewState widgetVoiceBottomSheetViewModel$ViewState) {
        invoke2(widgetVoiceBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceBottomSheetViewModel$ViewState widgetVoiceBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetVoiceBottomSheetViewModel$ViewState, "viewState");
        WidgetVoiceBottomSheet.access$configureUI(this.this$0, widgetVoiceBottomSheetViewModel$ViewState);
    }
}
