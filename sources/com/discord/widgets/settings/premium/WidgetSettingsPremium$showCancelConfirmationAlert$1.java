package com.discord.widgets.settings.premium;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$showCancelConfirmationAlert$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ SettingsPremiumViewModel $viewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$showCancelConfirmationAlert$1(SettingsPremiumViewModel settingsPremiumViewModel) {
        super(1);
        this.$viewModel = settingsPremiumViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$viewModel.cancelSubscription();
    }
}
