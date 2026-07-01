package com.discord.widgets.roles;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.role.GuildRole;
import d0.z.d.m;

/* JADX INFO: compiled from: RoleIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconView$setRole$1 implements View$OnClickListener {
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ RoleIconView this$0;

    public RoleIconView$setRole$1(RoleIconView roleIconView, GuildRole guildRole) {
        this.this$0 = roleIconView;
        this.$role = guildRole;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        RoleIconView roleIconView = this.this$0;
        Context context = roleIconView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        RoleIconView.access$showRoleIconToast(roleIconView, context, this.$role);
    }
}
