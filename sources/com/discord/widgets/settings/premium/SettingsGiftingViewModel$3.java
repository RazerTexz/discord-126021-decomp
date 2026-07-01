package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel$3<T> implements Action1<SettingsGiftingViewModel$StoreState> {
    public final /* synthetic */ SettingsGiftingViewModel this$0;

    public SettingsGiftingViewModel$3(SettingsGiftingViewModel settingsGiftingViewModel) {
        this.this$0 = settingsGiftingViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState) {
        call2(settingsGiftingViewModel$StoreState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState) {
        SettingsGiftingViewModel.access$maybeCheckClaimedPromos(this.this$0, settingsGiftingViewModel$StoreState.isUserPremium());
    }
}
