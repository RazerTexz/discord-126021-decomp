package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;

/* JADX INFO: compiled from: ViewInviteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewInviteSettingsSheet$configureUi$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetInviteModel $data;
    public final /* synthetic */ ViewInviteSettingsSheet this$0;

    public ViewInviteSettingsSheet$configureUi$10(ViewInviteSettingsSheet viewInviteSettingsSheet, WidgetInviteModel widgetInviteModel) {
        this.this$0 = viewInviteSettingsSheet;
        this.$data = widgetInviteModel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ModelInvite$Settings modelInvite$SettingsAccess$getPendingInviteSettings$p = ViewInviteSettingsSheet.access$getPendingInviteSettings$p(this.this$0);
        if (modelInvite$SettingsAccess$getPendingInviteSettings$p != null) {
            this.this$0.getViewModel().updateInviteSettings(modelInvite$SettingsAccess$getPendingInviteSettings$p);
        }
        Channel targetChannel = this.$data.getTargetChannel();
        if (targetChannel != null) {
            this.this$0.getViewModel().generateInviteLink(Long.valueOf(targetChannel.getId()).longValue());
        }
        this.this$0.getOnGenerateLinkListener().invoke();
    }
}
