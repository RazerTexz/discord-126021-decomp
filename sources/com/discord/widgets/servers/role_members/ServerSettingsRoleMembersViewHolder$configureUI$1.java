package com.discord.widgets.servers.role_members;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewHolder$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ ServerSettingsRoleMemberAdapterItem $adapterItem;
    public final /* synthetic */ Function2 $removeMemberClickListener;

    public ServerSettingsRoleMembersViewHolder$configureUI$1(Function2 function2, ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem) {
        this.$removeMemberClickListener = function2;
        this.$adapterItem = serverSettingsRoleMemberAdapterItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$removeMemberClickListener.invoke(this.$adapterItem.getGuildMember(), this.$adapterItem.getPermissionOwner().getUser());
    }
}
