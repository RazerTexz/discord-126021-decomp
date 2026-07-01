package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$configureUI$6 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    public WidgetGuildInviteShare$configureUI$6(WidgetGuildInviteShare widgetGuildInviteShare, ModelInvite modelInvite) {
        this.this$0 = widgetGuildInviteShare;
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
