package com.discord.widgets.guilds.profile;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity8 extends Lambda implements Function0<WidgetChangeGuildIdentityViewModel> {
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentity8(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        super(0);
        this.this$0 = widgetChangeGuildIdentity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChangeGuildIdentityViewModel invoke() {
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra("com.discord.intent.extra.EXTRA_SOURCE");
        if (stringExtra == null) {
            stringExtra = "";
        }
        return new WidgetChangeGuildIdentityViewModel(longExtra, stringExtra, null, 4, null);
    }
}
