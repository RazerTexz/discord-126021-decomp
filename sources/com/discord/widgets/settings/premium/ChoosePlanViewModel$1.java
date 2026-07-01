package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChoosePlanViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ChoosePlanViewModel$1 extends k implements Function1<ChoosePlanViewModel$StoreState, Unit> {
    public ChoosePlanViewModel$1(ChoosePlanViewModel choosePlanViewModel) {
        super(1, choosePlanViewModel, ChoosePlanViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel$StoreState choosePlanViewModel$StoreState) {
        invoke2(choosePlanViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChoosePlanViewModel$StoreState choosePlanViewModel$StoreState) {
        m.checkNotNullParameter(choosePlanViewModel$StoreState, "p1");
        ChoosePlanViewModel.access$handleStoreState((ChoosePlanViewModel) this.receiver, choosePlanViewModel$StoreState);
    }
}
