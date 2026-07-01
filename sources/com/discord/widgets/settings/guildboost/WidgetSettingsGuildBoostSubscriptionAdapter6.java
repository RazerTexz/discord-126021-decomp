package com.discord.widgets.settings.guildboost;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$cancelListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter6 extends Lambda implements Function2<Long, Boolean, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter6 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter6();

    public WidgetSettingsGuildBoostSubscriptionAdapter6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
        invoke(l.longValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(long j, boolean z2) {
    }
}
