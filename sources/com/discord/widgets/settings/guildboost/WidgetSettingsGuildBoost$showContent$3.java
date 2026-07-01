package com.discord.widgets.settings.guildboost;

import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.guilds.WidgetGuildSelector$Companion;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$showContent$3 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetSettingsGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoost$showContent$3(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        super(1);
        this.this$0 = widgetSettingsGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetSettingsGuildBoost.access$getViewModel$p(this.this$0).subscribeClicked(j);
        WidgetGuildSelector$Companion.launch$default(WidgetGuildSelector.Companion, this.this$0, null, false, 0, null, 30, null);
    }
}
