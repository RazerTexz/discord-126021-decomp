package com.discord.widgets.settings.premium;

import com.discord.stores.StoreGooglePlayPurchases$Event;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$1 extends k implements Function1<StoreGooglePlayPurchases$Event, Unit> {
    public SettingsGiftingViewModel$1(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleGooglePlayPurchaseEvent", "handleGooglePlayPurchaseEvent(Lcom/discord/stores/StoreGooglePlayPurchases$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StoreGooglePlayPurchases$Event storeGooglePlayPurchases$Event) {
        invoke2(storeGooglePlayPurchases$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StoreGooglePlayPurchases$Event storeGooglePlayPurchases$Event) {
        m.checkNotNullParameter(storeGooglePlayPurchases$Event, "p1");
        SettingsGiftingViewModel.access$handleGooglePlayPurchaseEvent((SettingsGiftingViewModel) this.receiver, storeGooglePlayPurchases$Event);
    }
}
