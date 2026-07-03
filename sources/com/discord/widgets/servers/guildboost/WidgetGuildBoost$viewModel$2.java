package com.discord.widgets.servers.guildboost;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$viewModel$2 extends AbstractC12240o implements Function0<GuildBoostViewModel> {
    public final /* synthetic */ WidgetGuildBoost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoost$viewModel$2(WidgetGuildBoost widgetGuildBoost) {
        super(0);
        this.this$0 = widgetGuildBoost;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildBoostViewModel invoke() {
        return new GuildBoostViewModel(this.this$0.getGuildId(), null, null, null, null, 30, null);
    }
}
