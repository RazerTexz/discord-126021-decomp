package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation5 extends Lambda implements Function0<GuildBoostInProgressViewModel> {
    public final /* synthetic */ WidgetGuildBoostConfirmation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoostConfirmation5(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        super(0);
        this.this$0 = widgetGuildBoostConfirmation;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildBoostInProgressViewModel invoke() {
        return new GuildBoostInProgressViewModel(this.this$0.getGuildId(), null, null, 6, null);
    }
}
