package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoost$guildId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoost4(WidgetGuildBoost widgetGuildBoost) {
        super(0);
        this.this$0 = widgetGuildBoost;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("GUILD_ID", -1L);
    }
}
