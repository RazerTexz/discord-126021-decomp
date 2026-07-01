package com.discord.widgets.guild_role_subscriptions;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel$1 extends o implements Function1<PriceTierPickerBottomSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ PriceTierPickerBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel$1(PriceTierPickerBottomSheetViewModel priceTierPickerBottomSheetViewModel) {
        super(1);
        this.this$0 = priceTierPickerBottomSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PriceTierPickerBottomSheetViewModel$StoreState priceTierPickerBottomSheetViewModel$StoreState) {
        invoke2(priceTierPickerBottomSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PriceTierPickerBottomSheetViewModel$StoreState priceTierPickerBottomSheetViewModel$StoreState) {
        m.checkNotNullParameter(priceTierPickerBottomSheetViewModel$StoreState, "storeState");
        PriceTierPickerBottomSheetViewModel.access$handleStoreState(this.this$0, priceTierPickerBottomSheetViewModel$StoreState);
    }
}
