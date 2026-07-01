package com.discord.widgets.settings.guildboost;

import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreStream;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.guilds.WidgetGuildSelector$Companion;
import com.discord.widgets.guilds.WidgetGuildSelector$GuildFilterFunction;
import d0.t.o0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost$showContent$1 extends o implements Function2<ModelGuildBoostSlot, Long, Unit> {
    public final /* synthetic */ WidgetSettingsGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoost$showContent$1(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        super(2);
        this.this$0 = widgetSettingsGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
        invoke(modelGuildBoostSlot, l.longValue());
        return Unit.a;
    }

    public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
        m.checkNotNullParameter(modelGuildBoostSlot, "slot");
        WidgetSettingsGuildBoost.access$getViewModel$p(this.this$0).transferClicked(modelGuildBoostSlot, j);
        WidgetGuildSelector$Companion.launch$default(WidgetGuildSelector.Companion, this.this$0, null, false, 0, new WidgetGuildSelector$GuildFilterFunction(o0.minus(StoreStream.Companion.getGuilds().getGuilds().keySet(), Long.valueOf(j))), 14, null);
    }
}
