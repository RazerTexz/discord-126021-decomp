package com.discord.widgets.settings.premium;

import androidx.core.app.NotificationCompat;
import rx.functions.Action1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel$maybeCheckClaimedPromos$1<T> implements Action1<Throwable> {
    public final /* synthetic */ SettingsGiftingViewModel this$0;

    public SettingsGiftingViewModel$maybeCheckClaimedPromos$1(SettingsGiftingViewModel settingsGiftingViewModel) {
        this.this$0 = settingsGiftingViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        SettingsGiftingViewModel.access$getShouldCheckClaimedPromos$p(this.this$0).set(true);
    }
}
