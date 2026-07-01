package com.discord.widgets.settings.premium;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$cancelSubscription$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ SettingsPremiumViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPremiumViewModel$cancelSubscription$1(SettingsPremiumViewModel settingsPremiumViewModel) {
        super(1);
        this.this$0 = settingsPremiumViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r1) {
        SettingsPremiumViewModel.access$fetchData(this.this$0);
    }
}
