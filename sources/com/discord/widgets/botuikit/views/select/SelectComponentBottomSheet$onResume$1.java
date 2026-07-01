package com.discord.widgets.botuikit.views.select;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SelectComponentBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet$onResume$1 extends k implements Function1<SelectComponentBottomSheetViewModel$ViewState, Unit> {
    public SelectComponentBottomSheet$onResume$1(SelectComponentBottomSheet selectComponentBottomSheet) {
        super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel$ViewState selectComponentBottomSheetViewModel$ViewState) {
        invoke2(selectComponentBottomSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SelectComponentBottomSheetViewModel$ViewState selectComponentBottomSheetViewModel$ViewState) {
        m.checkNotNullParameter(selectComponentBottomSheetViewModel$ViewState, "p1");
        SelectComponentBottomSheet.access$configureUI((SelectComponentBottomSheet) this.receiver, selectComponentBottomSheetViewModel$ViewState);
    }
}
