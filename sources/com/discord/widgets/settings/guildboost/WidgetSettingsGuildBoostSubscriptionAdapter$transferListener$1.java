package com.discord.widgets.settings.guildboost;

import com.discord.models.domain.ModelGuildBoostSlot;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1 extends AbstractC12240o implements Function2<ModelGuildBoostSlot, Long, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1();

    public WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
        invoke(modelGuildBoostSlot, l.longValue());
        return Unit.f27425a;
    }

    public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
        C12238m.checkNotNullParameter(modelGuildBoostSlot, "<anonymous parameter 0>");
    }
}
