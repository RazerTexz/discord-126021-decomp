package com.discord.widgets.settings.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$2 extends o implements Function1<SettingsUserProfileViewModel$StoreState, Unit> {
    public final /* synthetic */ SettingsUserProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUserProfileViewModel$2(SettingsUserProfileViewModel settingsUserProfileViewModel) {
        super(1);
        this.this$0 = settingsUserProfileViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsUserProfileViewModel$StoreState settingsUserProfileViewModel$StoreState) {
        invoke2(settingsUserProfileViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsUserProfileViewModel$StoreState settingsUserProfileViewModel$StoreState) {
        SettingsUserProfileViewModel settingsUserProfileViewModel = this.this$0;
        m.checkNotNullExpressionValue(settingsUserProfileViewModel$StoreState, "storeState");
        SettingsUserProfileViewModel.access$handleStoreState(settingsUserProfileViewModel, settingsUserProfileViewModel$StoreState);
    }
}
