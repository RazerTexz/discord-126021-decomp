package com.discord.widgets.settings.premium;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1 extends o implements Function1<SettingsGiftingViewModel$OutboundPromoItem, Object> {
    public static final WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1 INSTANCE = new WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1();

    public WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem) {
        return invoke2(settingsGiftingViewModel$OutboundPromoItem);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SettingsGiftingViewModel$OutboundPromoItem settingsGiftingViewModel$OutboundPromoItem) {
        m.checkNotNullParameter(settingsGiftingViewModel$OutboundPromoItem, "it");
        return Long.valueOf(settingsGiftingViewModel$OutboundPromoItem.getId());
    }
}
