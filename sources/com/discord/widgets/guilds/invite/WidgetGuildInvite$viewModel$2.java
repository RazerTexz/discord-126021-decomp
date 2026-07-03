package com.discord.widgets.guilds.invite;

import com.discord.stores.StoreInviteSettings;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite$viewModel$2 extends AbstractC12240o implements Function0<GuildInviteViewModel> {
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$viewModel$2(WidgetGuildInvite widgetGuildInvite) {
        super(0);
        this.this$0 = widgetGuildInvite;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildInviteViewModel invoke() {
        return new GuildInviteViewModel((StoreInviteSettings.InviteCode) this.this$0.getMostRecentIntent().getParcelableExtra("EXTRA_CODE"), null, null, 6, null);
    }
}
