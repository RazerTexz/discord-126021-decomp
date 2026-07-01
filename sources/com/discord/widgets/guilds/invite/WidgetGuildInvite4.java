package com.discord.widgets.guilds.invite;

import com.discord.stores.StoreInviteSettings;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite4 extends Lambda implements Function0<GuildInviteViewModel> {
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite4(WidgetGuildInvite widgetGuildInvite) {
        super(0);
        this.this$0 = widgetGuildInvite;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildInviteViewModel invoke() {
        return new GuildInviteViewModel((StoreInviteSettings.InviteCode) this.this$0.getMostRecentIntent().getParcelableExtra("EXTRA_CODE"), null, null, 6, null);
    }
}
