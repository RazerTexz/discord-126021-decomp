package com.discord.widgets.settings.billing;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsBillingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsBillingViewModel$2 extends o implements Function1<SettingsBillingViewModel$StoreState, Unit> {
    public final /* synthetic */ SettingsBillingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsBillingViewModel$2(SettingsBillingViewModel settingsBillingViewModel) {
        super(1);
        this.this$0 = settingsBillingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsBillingViewModel$StoreState settingsBillingViewModel$StoreState) {
        invoke2(settingsBillingViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsBillingViewModel$StoreState settingsBillingViewModel$StoreState) {
        m.checkNotNullParameter(settingsBillingViewModel$StoreState, "storeState");
        SettingsBillingViewModel.access$handleStoreState(this.this$0, settingsBillingViewModel$StoreState);
    }
}
