package com.discord.widgets.servers;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter extends MGRecyclerAdapterSimple<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> {
    private Function1<? super Long, Unit> roleClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMemberRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
        return widgetServerSettingsEditMemberRolesAdapter.roleClickListener;
    }

    public static final /* synthetic */ void access$setRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter, Function1 function1) {
        widgetServerSettingsEditMemberRolesAdapter.roleClickListener = function1;
    }

    public final void configure(List<WidgetServerSettingsEditMemberRolesAdapter$RoleItem> roleItems, Function1<? super Long, Unit> roleClickListener) {
        m.checkNotNullParameter(roleItems, "roleItems");
        m.checkNotNullParameter(roleClickListener, "roleClickListener");
        this.roleClickListener = roleClickListener;
        setData(roleItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetServerSettingsEditMemberRolesAdapter$RoleListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new WidgetServerSettingsEditMemberRolesAdapter$RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
