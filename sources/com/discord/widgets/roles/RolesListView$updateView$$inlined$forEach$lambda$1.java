package com.discord.widgets.roles;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.k.b;
import com.discord.api.role.GuildRole;
import d0.z.d.m;

/* JADX INFO: compiled from: RolesListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RolesListView$updateView$$inlined$forEach$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $developerModeEnabled$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ int $roleDefaultColor$inlined;
    public final /* synthetic */ RolesListView this$0;

    public RolesListView$updateView$$inlined$forEach$lambda$1(GuildRole guildRole, RolesListView rolesListView, int i, long j, boolean z2) {
        this.$role = guildRole;
        this.this$0 = rolesListView;
        this.$roleDefaultColor$inlined = i;
        this.$guildId$inlined = j;
        this.$developerModeEnabled$inlined = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        m.checkNotNullExpressionValue(context, "context");
        b.a.d.m.b(context, String.valueOf(this.$role.getId()), b.j(this.this$0, 2131894940, new Object[]{this.$role.getName()}, null, 4));
    }
}
