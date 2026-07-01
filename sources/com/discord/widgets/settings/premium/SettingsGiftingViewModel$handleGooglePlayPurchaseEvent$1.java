package com.discord.widgets.settings.premium;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ SettingsGiftingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel$handleGooglePlayPurchaseEvent$1(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(1);
        this.this$0 = settingsGiftingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        SettingsGiftingViewModel.access$getStoreEntitlements$p(this.this$0).fetchMyGiftEntitlements();
        SettingsGiftingViewModel.access$getGiftPurchaseEventSubject$p(this.this$0).k.onNext((T) new SettingsGiftingViewModel$GiftPurchaseEvent$ErrorGiftPurchase(2131887073));
    }
}
