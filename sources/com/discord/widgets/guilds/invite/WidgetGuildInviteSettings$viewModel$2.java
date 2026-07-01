package com.discord.widgets.guilds.invite;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildInviteSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteSettings$viewModel$2 extends o implements Function0<GuildInviteSettingsViewModel> {
    public final /* synthetic */ WidgetGuildInviteSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteSettings$viewModel$2(WidgetGuildInviteSettings widgetGuildInviteSettings) {
        super(0);
        this.this$0 = widgetGuildInviteSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildInviteSettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildInviteSettingsViewModel invoke() {
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        return new GuildInviteSettingsViewModel(longExtra != 0 ? Long.valueOf(longExtra) : null, this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L), null, null, null, 28, null);
    }
}
