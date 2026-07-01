package com.discord.widgets.settings.guildboost;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter$subscribeListener$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter7 extends Lambda implements Function1<Long, Unit> {
    public static final WidgetSettingsGuildBoostSubscriptionAdapter7 INSTANCE = new WidgetSettingsGuildBoostSubscriptionAdapter7();

    public WidgetSettingsGuildBoostSubscriptionAdapter7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
    }
}
