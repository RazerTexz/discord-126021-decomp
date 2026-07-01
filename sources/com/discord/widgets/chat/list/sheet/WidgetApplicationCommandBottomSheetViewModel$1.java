package com.discord.widgets.chat.list.sheet;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetApplicationCommandBottomSheetViewModel$1 extends k implements Function1<WidgetApplicationCommandBottomSheetViewModel$StoreState, Unit> {
    public WidgetApplicationCommandBottomSheetViewModel$1(WidgetApplicationCommandBottomSheetViewModel widgetApplicationCommandBottomSheetViewModel) {
        super(1, widgetApplicationCommandBottomSheetViewModel, WidgetApplicationCommandBottomSheetViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/list/sheet/WidgetApplicationCommandBottomSheetViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState) {
        invoke2(widgetApplicationCommandBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(widgetApplicationCommandBottomSheetViewModel$StoreState, "p1");
        WidgetApplicationCommandBottomSheetViewModel.access$handleStoreState((WidgetApplicationCommandBottomSheetViewModel) this.receiver, widgetApplicationCommandBottomSheetViewModel$StoreState);
    }
}
