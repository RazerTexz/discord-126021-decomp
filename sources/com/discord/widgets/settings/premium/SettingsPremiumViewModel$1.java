package com.discord.widgets.settings.premium;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$1 extends o implements Function1<SettingsPremiumViewModel$StoreState, Unit> {
    public final /* synthetic */ SettingsPremiumViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPremiumViewModel$1(SettingsPremiumViewModel settingsPremiumViewModel) {
        super(1);
        this.this$0 = settingsPremiumViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel$StoreState settingsPremiumViewModel$StoreState) {
        invoke2(settingsPremiumViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsPremiumViewModel$StoreState settingsPremiumViewModel$StoreState) {
        m.checkNotNullParameter(settingsPremiumViewModel$StoreState, "storeState");
        SettingsPremiumViewModel.access$handleStoreState(this.this$0, settingsPremiumViewModel$StoreState);
    }
}
