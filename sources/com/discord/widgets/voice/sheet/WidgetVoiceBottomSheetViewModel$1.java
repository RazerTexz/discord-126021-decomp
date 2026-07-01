package com.discord.widgets.voice.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel$1 extends o implements Function1<WidgetVoiceBottomSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetVoiceBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel$1(WidgetVoiceBottomSheetViewModel widgetVoiceBottomSheetViewModel) {
        super(1);
        this.this$0 = widgetVoiceBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState) {
        invoke2(widgetVoiceBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetVoiceBottomSheetViewModel$StoreState widgetVoiceBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetVoiceBottomSheetViewModel$StoreState, "storeState");
        WidgetVoiceBottomSheetViewModel.access$handleStoreState(this.this$0, widgetVoiceBottomSheetViewModel$StoreState);
    }
}
