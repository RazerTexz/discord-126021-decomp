package com.discord.widgets.servers.settings.invites;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsInstantInvites$Model$InviteItem $data;
    public final /* synthetic */ WidgetServerSettingsInstantInvitesListItem this$0;

    public WidgetServerSettingsInstantInvitesListItem$onConfigure$1(WidgetServerSettingsInstantInvitesListItem widgetServerSettingsInstantInvitesListItem, WidgetServerSettingsInstantInvites$Model$InviteItem widgetServerSettingsInstantInvites$Model$InviteItem) {
        this.this$0 = widgetServerSettingsInstantInvitesListItem;
        this.$data = widgetServerSettingsInstantInvites$Model$InviteItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsInstantInvitesListItem.access$getAdapter$p(this.this$0).onInviteSelected(this.$data.getInvite());
    }
}
