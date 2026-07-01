package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheetViewModel$1 extends o implements Function1<WidgetChannelPickerBottomSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetChannelPickerBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheetViewModel$1(WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel) {
        super(1);
        this.this$0 = widgetChannelPickerBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerBottomSheetViewModel$StoreState widgetChannelPickerBottomSheetViewModel$StoreState) {
        invoke2(widgetChannelPickerBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelPickerBottomSheetViewModel$StoreState widgetChannelPickerBottomSheetViewModel$StoreState) {
        WidgetChannelPickerBottomSheetViewModel widgetChannelPickerBottomSheetViewModel = this.this$0;
        m.checkNotNullExpressionValue(widgetChannelPickerBottomSheetViewModel$StoreState, "storeState");
        WidgetChannelPickerBottomSheetViewModel.access$handleStoreState(widgetChannelPickerBottomSheetViewModel, widgetChannelPickerBottomSheetViewModel$StoreState);
    }
}
