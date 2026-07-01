package com.discord.widgets.servers.role_members;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.member.GuildMember;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$configureUI$1$1 implements View$OnClickListener {
    public final /* synthetic */ GuildMember $guildMember;
    public final /* synthetic */ WidgetServerSettingsRoleMembers$configureUI$1 this$0;

    public WidgetServerSettingsRoleMembers$configureUI$1$1(WidgetServerSettingsRoleMembers$configureUI$1 widgetServerSettingsRoleMembers$configureUI$1, GuildMember guildMember) {
        this.this$0 = widgetServerSettingsRoleMembers$configureUI$1;
        this.$guildMember = guildMember;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsRoleMembers.access$getViewModel$p(this.this$0.this$0).removeRoleFromMember(this.$guildMember);
    }
}
