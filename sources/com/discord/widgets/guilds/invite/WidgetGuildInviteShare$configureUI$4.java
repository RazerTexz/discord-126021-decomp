package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    public WidgetGuildInviteShare$configureUI$4(WidgetGuildInviteShare widgetGuildInviteShare, ModelInvite modelInvite) {
        this.this$0 = widgetGuildInviteShare;
        this.$invite = modelInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GuildInviteUiHelperKt.copyLinkClick(a.x(view, "it", "it.context"), this.$invite, this.this$0.getMostRecentIntent());
    }
}
