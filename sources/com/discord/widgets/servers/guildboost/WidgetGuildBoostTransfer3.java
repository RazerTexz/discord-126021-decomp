package com.discord.widgets.servers.guildboost;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer3 extends Lambda implements Function0<GuildBoostTransferInProgressViewModel> {
    public final /* synthetic */ WidgetGuildBoostTransfer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildBoostTransfer3(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        super(0);
        this.this$0 = widgetGuildBoostTransfer;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildBoostTransferInProgressViewModel invoke() {
        return new GuildBoostTransferInProgressViewModel(this.this$0.getMostRecentIntent().getLongExtra("SLOT_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("SUBSCRIPTION_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("PREVIOUS_GUILD_ID", -1L), this.this$0.getMostRecentIntent().getLongExtra("TARGET_GUILD_ID", -1L), null, null, null, 112, null);
    }
}
