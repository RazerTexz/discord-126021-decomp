package com.discord.widgets.settings.guildboost;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsGuildBoost$showContent$4 extends k implements Function1<Long, Unit> {
    public WidgetSettingsGuildBoost$showContent$4(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        super(1, widgetSettingsGuildBoost, WidgetSettingsGuildBoost.class, "handleSampleGuildSelected", "handleSampleGuildSelected(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetSettingsGuildBoost.access$handleSampleGuildSelected((WidgetSettingsGuildBoost) this.receiver, j);
    }
}
