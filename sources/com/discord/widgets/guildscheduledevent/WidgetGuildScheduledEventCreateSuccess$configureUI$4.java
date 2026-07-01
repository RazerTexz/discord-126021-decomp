package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.GuildInviteUiHelperKt;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    public WidgetGuildScheduledEventCreateSuccess$configureUI$4(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess, ModelInvite modelInvite) {
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
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
