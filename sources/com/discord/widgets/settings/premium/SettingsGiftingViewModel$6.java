package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$6 extends k implements Function1<SettingsGiftingViewModel$GiftAndPromoData, Unit> {
    public SettingsGiftingViewModel$6(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handleAsyncData", "handleAsyncData(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel$GiftAndPromoData settingsGiftingViewModel$GiftAndPromoData) {
        invoke2(settingsGiftingViewModel$GiftAndPromoData);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGiftingViewModel$GiftAndPromoData settingsGiftingViewModel$GiftAndPromoData) {
        m.checkNotNullParameter(settingsGiftingViewModel$GiftAndPromoData, "p1");
        SettingsGiftingViewModel.access$handleAsyncData((SettingsGiftingViewModel) this.receiver, settingsGiftingViewModel$GiftAndPromoData);
    }
}
