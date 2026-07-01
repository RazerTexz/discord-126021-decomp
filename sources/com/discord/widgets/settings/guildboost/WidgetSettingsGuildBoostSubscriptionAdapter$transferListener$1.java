package com.discord.widgets.settings.guildboost;

import com.discord.models.domain.ModelGuildBoostSlot;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1 extends o implements Function2<ModelGuildBoostSlot, Long, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1();

    public WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
        invoke(modelGuildBoostSlot, l.longValue());
        return Unit.a;
    }

    public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
        m.checkNotNullParameter(modelGuildBoostSlot, "<anonymous parameter 0>");
    }
}
