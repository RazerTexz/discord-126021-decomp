package com.discord.widgets.guilds.invite;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$viewModel$2 extends o implements Function0<GuildInviteShareSheetViewModel> {
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareSheet$viewModel$2(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        super(0);
        this.this$0 = widgetGuildInviteShareSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildInviteShareSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildInviteShareSheetViewModel invoke() {
        long j = WidgetGuildInviteShareSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID");
        return new GuildInviteShareSheetViewModel(j != 0 ? Long.valueOf(j) : null, WidgetGuildInviteShareSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID"), null, null, null, null, null, null, 252, null);
    }
}
