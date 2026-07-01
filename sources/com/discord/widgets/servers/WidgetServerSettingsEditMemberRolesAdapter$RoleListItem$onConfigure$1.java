package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter$RoleListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter$RoleItem $data;
    public final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter$RoleListItem this$0;

    public WidgetServerSettingsEditMemberRolesAdapter$RoleListItem$onConfigure$1(WidgetServerSettingsEditMemberRolesAdapter$RoleListItem widgetServerSettingsEditMemberRolesAdapter$RoleListItem, WidgetServerSettingsEditMemberRolesAdapter$RoleItem widgetServerSettingsEditMemberRolesAdapter$RoleItem) {
        this.this$0 = widgetServerSettingsEditMemberRolesAdapter$RoleListItem;
        this.$data = widgetServerSettingsEditMemberRolesAdapter$RoleItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getRoleClickListener$p = WidgetServerSettingsEditMemberRolesAdapter.access$getRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter$RoleListItem.access$getAdapter$p(this.this$0));
        if (function1Access$getRoleClickListener$p != null) {
        }
    }
}
