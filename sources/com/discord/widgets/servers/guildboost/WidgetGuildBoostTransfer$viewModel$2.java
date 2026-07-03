package com.discord.widgets.servers.guildboost;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer$viewModel$2 extends AbstractC12240o implements Function0<GuildBoostTransferInProgressViewModel> {
    public final /* synthetic */ WidgetGuildBoostTransfer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoostTransfer$viewModel$2(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        super(0);
        this.this$0 = widgetGuildBoostTransfer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildBoostTransferInProgressViewModel invoke() {
        return new GuildBoostTransferInProgressViewModel(this.this$0.getMostRecentIntent().getLongExtra("SLOT_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("SUBSCRIPTION_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("PREVIOUS_GUILD_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("TARGET_GUILD_ID", -1L), null, null, null, 112, null);
    }
}
