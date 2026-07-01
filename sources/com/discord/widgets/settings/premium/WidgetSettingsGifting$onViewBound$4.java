package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGifting$onViewBound$4 extends k implements Function1<SettingsGiftingViewModel$OutboundPromoItem, Unit> {
    public WidgetSettingsGifting$onViewBound$4(SettingsGiftingViewModel settingsGiftingViewModel) {
        super(1, settingsGiftingViewModel, SettingsGiftingViewModel.class, "handlePromoButtonClicked", "handlePromoButtonClicked(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$OutboundPromoItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem) {
        invoke2(settingsGiftingViewModel$OutboundPromoItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem) {
        m.checkNotNullParameter(settingsGiftingViewModel$OutboundPromoItem, "p1");
        ((SettingsGiftingViewModel) this.receiver).handlePromoButtonClicked(settingsGiftingViewModel$OutboundPromoItem);
    }
}
