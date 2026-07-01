package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGifting$onViewBoundOrOnResume$1 extends k implements Function1<SettingsGiftingViewModel$ViewState, Unit> {
    public WidgetSettingsGifting$onViewBoundOrOnResume$1(WidgetSettingsGifting widgetSettingsGifting) {
        super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel$ViewState settingsGiftingViewModel$ViewState) {
        invoke2(settingsGiftingViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGiftingViewModel$ViewState settingsGiftingViewModel$ViewState) {
        m.checkNotNullParameter(settingsGiftingViewModel$ViewState, "p1");
        WidgetSettingsGifting.access$configureUI((WidgetSettingsGifting) this.receiver, settingsGiftingViewModel$ViewState);
    }
}
