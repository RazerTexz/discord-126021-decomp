package com.discord.widgets.channels.permissions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PermissionOwnerListView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PermissionOwnerListView$Adapter extends RecyclerView$Adapter<PermissionOwnerListView$PermissionOwnerViewHolder> {
    private Function1<? super PermissionOwner, Unit> onRemoveClicked = PermissionOwnerListView$Adapter$onRemoveClicked$1.INSTANCE;
    private List<PermissionOwnerListView$Item> data = n.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final Function1<PermissionOwner, Unit> getOnRemoveClicked() {
        return this.onRemoveClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((PermissionOwnerListView$PermissionOwnerViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<PermissionOwnerListView$Item> data) {
        m.checkNotNullParameter(data, "data");
        this.data = data;
        notifyDataSetChanged();
    }

    public final void setOnRemoveClicked(Function1<? super PermissionOwner, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onRemoveClicked = function1;
    }

    public void onBindViewHolder(PermissionOwnerListView$PermissionOwnerViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.configure(this.data.get(position), new PermissionOwnerListView$Adapter$onBindViewHolder$1(this, this.data.get(position)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public PermissionOwnerListView$PermissionOwnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingA = RemovablePermissionOwnerViewBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
        m.checkNotNullExpressionValue(removablePermissionOwnerViewBindingA, "RemovablePermissionOwner…,\n          false\n      )");
        return new PermissionOwnerListView$PermissionOwnerViewHolder(removablePermissionOwnerViewBindingA);
    }
}
