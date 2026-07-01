package com.discord.widgets.user.usersheet;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheetViewModel$1 extends o implements Function1<WidgetUserSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ WidgetUserSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheetViewModel$1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        super(1);
        this.this$0 = widgetUserSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetUserSheetViewModel$StoreState widgetUserSheetViewModel$StoreState) {
        invoke2(widgetUserSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetUserSheetViewModel$StoreState widgetUserSheetViewModel$StoreState) {
        WidgetUserSheetViewModel.access$handleStoreState(this.this$0, widgetUserSheetViewModel$StoreState);
    }
}
