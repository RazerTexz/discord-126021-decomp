package com.discord.widgets.chat.input;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AppFlexInputViewModel$1 extends k implements Function1<AppFlexInputViewModel$StoreState, Unit> {
    public AppFlexInputViewModel$1(AppFlexInputViewModel appFlexInputViewModel) {
        super(1, appFlexInputViewModel, AppFlexInputViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/AppFlexInputViewModel$StoreState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppFlexInputViewModel$StoreState appFlexInputViewModel$StoreState) {
        invoke2(appFlexInputViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppFlexInputViewModel$StoreState appFlexInputViewModel$StoreState) {
        m.checkNotNullParameter(appFlexInputViewModel$StoreState, "p1");
        AppFlexInputViewModel.access$handleStoreState((AppFlexInputViewModel) this.receiver, appFlexInputViewModel$StoreState);
    }
}
