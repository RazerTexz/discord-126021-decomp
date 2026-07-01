package com.discord.widgets.settings.guildboost;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel$1 extends o implements Function1<SettingsGuildBoostViewModel$StoreState, Unit> {
    public final /* synthetic */ SettingsGuildBoostViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostViewModel$1(SettingsGuildBoostViewModel settingsGuildBoostViewModel) {
        super(1);
        this.this$0 = settingsGuildBoostViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGuildBoostViewModel$StoreState settingsGuildBoostViewModel$StoreState) {
        invoke2(settingsGuildBoostViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGuildBoostViewModel$StoreState settingsGuildBoostViewModel$StoreState) {
        m.checkNotNullParameter(settingsGuildBoostViewModel$StoreState, "storeState");
        SettingsGuildBoostViewModel.access$handleStoreState(this.this$0, settingsGuildBoostViewModel$StoreState);
    }
}
