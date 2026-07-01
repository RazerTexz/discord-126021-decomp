package com.lytefast.flexinput.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: EmptyListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EmptyListAdapter extends RecyclerView$Adapter<EmptyListAdapter$ViewHolder> {
    private final int actionBtnId;
    private final int itemLayoutId;
    private final View$OnClickListener onClickListener;

    public EmptyListAdapter(@LayoutRes int i, @IdRes int i2, View$OnClickListener view$OnClickListener) {
        m.checkNotNullParameter(view$OnClickListener, "onClickListener");
        this.itemLayoutId = i;
        this.actionBtnId = i2;
        this.onClickListener = view$OnClickListener;
    }

    public static final /* synthetic */ int access$getActionBtnId$p(EmptyListAdapter emptyListAdapter) {
        return emptyListAdapter.actionBtnId;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((EmptyListAdapter$ViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(EmptyListAdapter$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.actionBtn.setOnClickListener(this.onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public EmptyListAdapter$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayoutId, parent, false);
        m.checkNotNullExpressionValue(viewInflate, "view");
        return new EmptyListAdapter$ViewHolder(this, viewInflate);
    }
}
