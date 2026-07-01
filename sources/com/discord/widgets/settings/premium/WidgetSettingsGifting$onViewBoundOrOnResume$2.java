package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGifting$onViewBoundOrOnResume$2 extends k implements Function1<SettingsGiftingViewModel$GiftPurchaseEvent, Unit> {
    public WidgetSettingsGifting$onViewBoundOrOnResume$2(WidgetSettingsGifting widgetSettingsGifting) {
        super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleGiftPurchaseEvent", "handleGiftPurchaseEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$GiftPurchaseEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel$GiftPurchaseEvent settingsGiftingViewModel$GiftPurchaseEvent) {
        invoke2(settingsGiftingViewModel$GiftPurchaseEvent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGiftingViewModel$GiftPurchaseEvent settingsGiftingViewModel$GiftPurchaseEvent) {
        m.checkNotNullParameter(settingsGiftingViewModel$GiftPurchaseEvent, "p1");
        WidgetSettingsGifting.access$handleGiftPurchaseEvent((WidgetSettingsGifting) this.receiver, settingsGiftingViewModel$GiftPurchaseEvent);
    }
}
