package com.discord.widgets.channels;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$RolesAdapter extends MGRecyclerAdapterSimple<SingleTypePayload<GuildRole>> {
    private final Map<Long, Integer> checkedRoles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$RolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.checkedRoles = new HashMap();
    }

    public static final /* synthetic */ void access$onRoleClicked(WidgetCreateChannel$RolesAdapter widgetCreateChannel$RolesAdapter, boolean z2, int i, long j) {
        widgetCreateChannel$RolesAdapter.onRoleClicked(z2, i, j);
    }

    private final void onRoleClicked(boolean checked, int position, long roleId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(position));
        if (checked) {
            this.checkedRoles.put(Long.valueOf(roleId), Integer.valueOf(position));
        } else {
            this.checkedRoles.remove(Long.valueOf(roleId));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (iIntValue < getItemCount()) {
                notifyItemChanged(iIntValue);
            }
        }
    }

    public final Map<Long, Integer> getCheckedRoles() {
        return this.checkedRoles;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
    public void setData(List<SingleTypePayload<GuildRole>> data) {
        m.checkNotNullParameter(data, "data");
        super.setData(data);
        this.checkedRoles.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, SingleTypePayload<GuildRole>> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetCreateChannel$RolesAdapter$RoleListItem(this);
    }
}
