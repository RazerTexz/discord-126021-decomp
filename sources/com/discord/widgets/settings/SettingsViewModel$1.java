package com.discord.widgets.settings;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsViewModel$1 extends o implements Function1<SettingsViewModel$StoreState, Unit> {
    public final /* synthetic */ SettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$1(SettingsViewModel settingsViewModel) {
        super(1);
        this.this$0 = settingsViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsViewModel$StoreState settingsViewModel$StoreState) {
        invoke2(settingsViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsViewModel$StoreState settingsViewModel$StoreState) {
        SettingsViewModel settingsViewModel = this.this$0;
        m.checkNotNullExpressionValue(settingsViewModel$StoreState, "storeState");
        SettingsViewModel.access$handleStoreState(settingsViewModel, settingsViewModel$StoreState);
    }
}
