package com.discord.widgets.settings.guildboost;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$onViewBound$3 extends o implements Function2<Long, String, Unit> {
    public final /* synthetic */ WidgetSettingsGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoost$onViewBound$3(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        super(2);
        this.this$0 = widgetSettingsGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
        invoke(l.longValue(), str);
        return Unit.a;
    }

    public final void invoke(long j, String str) {
        m.checkNotNullParameter(str, "<anonymous parameter 1>");
        WidgetSettingsGuildBoost.access$getViewModel$p(this.this$0).handleGuildSearchCallback(j);
    }
}
