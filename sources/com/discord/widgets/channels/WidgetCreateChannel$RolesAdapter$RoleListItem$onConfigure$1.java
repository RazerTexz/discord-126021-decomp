package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.role.GuildRole;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ WidgetCreateChannel$RolesAdapter$RoleListItem this$0;

    public WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1(WidgetCreateChannel$RolesAdapter$RoleListItem widgetCreateChannel$RolesAdapter$RoleListItem, GuildRole guildRole) {
        this.this$0 = widgetCreateChannel$RolesAdapter$RoleListItem;
        this.$role = guildRole;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel$RolesAdapter widgetCreateChannel$RolesAdapterAccess$getAdapter$p = WidgetCreateChannel$RolesAdapter$RoleListItem.access$getAdapter$p(this.this$0);
        CheckedSetting checkedSetting = WidgetCreateChannel$RolesAdapter$RoleListItem.access$getBinding$p(this.this$0).f2180b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.roleItemCheckedSetting");
        WidgetCreateChannel$RolesAdapter.access$onRoleClicked(widgetCreateChannel$RolesAdapterAccess$getAdapter$p, !checkedSetting.isChecked(), this.this$0.getAdapterPosition(), this.$role.getId());
    }
}
