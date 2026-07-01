package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ InviteSuggestionItem $data;
    public final /* synthetic */ WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item this$0;

    public WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item$onConfigure$1(WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item widgetGuildInviteShareCompact$PrivateChannelAdapter$Item, InviteSuggestionItem inviteSuggestionItem) {
        this.this$0 = widgetGuildInviteShareCompact$PrivateChannelAdapter$Item;
        this.$data = inviteSuggestionItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item.access$getAdapter$p(this.this$0).getOnClick().invoke(this.$data);
    }
}
