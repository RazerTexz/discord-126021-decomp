package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsRolesAdapter$RoleItem $roleItem;
    public final /* synthetic */ WidgetServerSettingsRolesAdapter$RoleListItem this$0;

    public WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$1(WidgetServerSettingsRolesAdapter$RoleListItem widgetServerSettingsRolesAdapter$RoleListItem, WidgetServerSettingsRolesAdapter$RoleItem widgetServerSettingsRolesAdapter$RoleItem) {
        this.this$0 = widgetServerSettingsRolesAdapter$RoleListItem;
        this.$roleItem = widgetServerSettingsRolesAdapter$RoleItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MGRecyclerAdapter mGRecyclerAdapterAccess$getAdapter$p = WidgetServerSettingsRolesAdapter$RoleListItem.access$getAdapter$p(this.this$0);
        Objects.requireNonNull(mGRecyclerAdapterAccess$getAdapter$p, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter");
        WidgetServerSettingsRolesAdapter.access$getRoleSelectedListener$p((WidgetServerSettingsRolesAdapter) mGRecyclerAdapterAccess$getAdapter$p).invoke(this.$roleItem.getRole());
    }
}
