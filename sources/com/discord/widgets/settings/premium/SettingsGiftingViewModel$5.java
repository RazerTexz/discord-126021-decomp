package com.discord.widgets.settings.premium;

import com.discord.api.premium.ClaimedOutboundPromotion;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SettingsGiftingViewModel$5 extends k implements Function2<SettingsGiftingViewModel$StoreState, List<? extends ClaimedOutboundPromotion>, SettingsGiftingViewModel$GiftAndPromoData> {
    public SettingsGiftingViewModel$5(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(2, settingsGiftingViewModel, SettingsGiftingViewModel.class, "combineData", "combineData(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$StoreState;Ljava/util/List;)Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftAndPromoData;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ SettingsGiftingViewModel$GiftAndPromoData invoke(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState, List<? extends ClaimedOutboundPromotion> list) {
        return invoke2(settingsGiftingViewModel$StoreState, (List<ClaimedOutboundPromotion>) list);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final SettingsGiftingViewModel$GiftAndPromoData invoke2(SettingsGiftingViewModel$StoreState settingsGiftingViewModel$StoreState, List<ClaimedOutboundPromotion> list) {
        m.checkNotNullParameter(settingsGiftingViewModel$StoreState, "p1");
        m.checkNotNullParameter(list, "p2");
        return SettingsGiftingViewModel.access$combineData((SettingsGiftingViewModel) this.receiver, settingsGiftingViewModel$StoreState, list);
    }
}
