package com.discord.widgets.settings.premium;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPremium$onViewBoundOrOnResume$2 extends k implements Function1<SettingsPremiumViewModel$Event, Unit> {
    public WidgetSettingsPremium$onViewBoundOrOnResume$2(WidgetSettingsPremium widgetSettingsPremium) {
        super(1, widgetSettingsPremium, WidgetSettingsPremium.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel$Event settingsPremiumViewModel$Event) {
        invoke2(settingsPremiumViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SettingsPremiumViewModel$Event settingsPremiumViewModel$Event) {
        m.checkNotNullParameter(settingsPremiumViewModel$Event, "p1");
        WidgetSettingsPremium.access$handleEvent((WidgetSettingsPremium) this.receiver, settingsPremiumViewModel$Event);
    }
}
