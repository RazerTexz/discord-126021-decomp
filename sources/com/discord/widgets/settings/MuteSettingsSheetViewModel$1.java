package com.discord.widgets.settings;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel$1 extends o implements Function1<MuteSettingsSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ MuteSettingsSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MuteSettingsSheetViewModel$1(MuteSettingsSheetViewModel muteSettingsSheetViewModel) {
        super(1);
        this.this$0 = muteSettingsSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel$StoreState muteSettingsSheetViewModel$StoreState) {
        invoke2(muteSettingsSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MuteSettingsSheetViewModel$StoreState muteSettingsSheetViewModel$StoreState) {
        m.checkNotNullParameter(muteSettingsSheetViewModel$StoreState, "storeState");
        MuteSettingsSheetViewModel.access$handleStoreState(this.this$0, muteSettingsSheetViewModel$StoreState);
    }
}
