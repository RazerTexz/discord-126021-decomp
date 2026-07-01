package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShareCompact this$0;

    public WidgetGuildInviteShareCompact$configureUI$4(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact, ModelInvite modelInvite) {
        this.this$0 = widgetGuildInviteShareCompact;
        this.$invite = modelInvite;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ModelInvite modelInvite = this.$invite;
        if (modelInvite != null) {
            GuildInviteUiHelperKt.shareLinkClick(this.this$0.getContext(), modelInvite);
        }
    }
}
