package com.discord.widgets.guild_role_subscriptions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet$bindSubscriptions$1 extends o implements Function1<PriceTierPickerBottomSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetPriceTierPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPriceTierPickerBottomSheet$bindSubscriptions$1(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        super(1);
        this.this$0 = widgetPriceTierPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PriceTierPickerBottomSheetViewModel$ViewState priceTierPickerBottomSheetViewModel$ViewState) {
        invoke2(priceTierPickerBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PriceTierPickerBottomSheetViewModel$ViewState priceTierPickerBottomSheetViewModel$ViewState) {
        WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = this.this$0;
        m.checkNotNullExpressionValue(priceTierPickerBottomSheetViewModel$ViewState, "it");
        WidgetPriceTierPickerBottomSheet.access$configureUI(widgetPriceTierPickerBottomSheet, priceTierPickerBottomSheetViewModel$ViewState);
    }
}
