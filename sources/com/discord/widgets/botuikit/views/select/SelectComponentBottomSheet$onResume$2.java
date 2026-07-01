package com.discord.widgets.botuikit.views.select;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet$onResume$2 extends k implements Function1<SelectComponentBottomSheetViewModel$Event, Unit> {
    public SelectComponentBottomSheet$onResume$2(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel$Event selectComponentBottomSheetViewModel$Event) {
        invoke2(selectComponentBottomSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SelectComponentBottomSheetViewModel$Event selectComponentBottomSheetViewModel$Event) {
        m.checkNotNullParameter(selectComponentBottomSheetViewModel$Event, "p1");
        SelectComponentBottomSheet.access$handleEvent((SelectComponentBottomSheet) this.receiver, selectComponentBottomSheetViewModel$Event);
    }
}
