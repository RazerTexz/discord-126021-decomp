package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases$QueryState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$2 extends k implements Function1<StoreGooglePlayPurchases$QueryState, Unit> {
    public SettingsGiftingViewModel$2(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleGooglePlayQueryStateUpdate", "handleGooglePlayQueryStateUpdate(Lcom/discord/stores/StoreGooglePlayPurchases$QueryState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState) {
        invoke2(storeGooglePlayPurchases$QueryState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreGooglePlayPurchases$QueryState storeGooglePlayPurchases$QueryState) {
        m.checkNotNullParameter(storeGooglePlayPurchases$QueryState, "p1");
        SettingsGiftingViewModel.access$handleGooglePlayQueryStateUpdate((SettingsGiftingViewModel) this.receiver, storeGooglePlayPurchases$QueryState);
    }
}
