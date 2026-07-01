package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGifting$onViewBoundOrOnResume$3 extends k implements Function1<SettingsGiftingViewModel$Event, Unit> {
    public WidgetSettingsGifting$onViewBoundOrOnResume$3(WidgetSettingsGifting widgetSettingsGifting) {
        super(1, widgetSettingsGifting, WidgetSettingsGifting.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsGiftingViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsGiftingViewModel$Event settingsGiftingViewModel$Event) {
        invoke2(settingsGiftingViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsGiftingViewModel$Event settingsGiftingViewModel$Event) {
        m.checkNotNullParameter(settingsGiftingViewModel$Event, "p1");
        WidgetSettingsGifting.access$handleEvent((WidgetSettingsGifting) this.receiver, settingsGiftingViewModel$Event);
    }
}
