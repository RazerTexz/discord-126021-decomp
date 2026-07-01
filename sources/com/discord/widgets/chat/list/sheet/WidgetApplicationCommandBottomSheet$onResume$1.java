package com.discord.widgets.chat.list.sheet;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$onResume$1 extends o implements Function1<WidgetApplicationCommandBottomSheetViewModel$ViewState, Unit> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet$onResume$1(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel$ViewState widgetApplicationCommandBottomSheetViewModel$ViewState) {
        invoke2(widgetApplicationCommandBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetApplicationCommandBottomSheetViewModel$ViewState widgetApplicationCommandBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(widgetApplicationCommandBottomSheetViewModel$ViewState, "viewState");
        WidgetApplicationCommandBottomSheet.access$configureUI(this.this$0, widgetApplicationCommandBottomSheetViewModel$ViewState);
    }
}
