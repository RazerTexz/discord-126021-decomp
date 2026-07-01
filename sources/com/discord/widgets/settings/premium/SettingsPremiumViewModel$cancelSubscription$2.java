package com.discord.widgets.settings.premium;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsPremiumViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPremiumViewModel$cancelSubscription$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ SettingsPremiumViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsPremiumViewModel$cancelSubscription$2(SettingsPremiumViewModel settingsPremiumViewModel) {
        super(1);
        this.this$0 = settingsPremiumViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        SettingsPremiumViewModel.access$onCancelError(this.this$0);
    }
}
