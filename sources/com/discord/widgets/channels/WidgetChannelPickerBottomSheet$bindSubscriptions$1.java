package com.discord.widgets.channels;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet$bindSubscriptions$1 extends o implements Function1<WidgetChannelPickerBottomSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetChannelPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPickerBottomSheet$bindSubscriptions$1(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        super(1);
        this.this$0 = widgetChannelPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerBottomSheetViewModel$ViewState widgetChannelPickerBottomSheetViewModel$ViewState) {
        invoke2(widgetChannelPickerBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelPickerBottomSheetViewModel$ViewState widgetChannelPickerBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetChannelPickerBottomSheetViewModel$ViewState, "it");
        WidgetChannelPickerBottomSheet.access$configureUI(this.this$0, widgetChannelPickerBottomSheetViewModel$ViewState);
    }
}
