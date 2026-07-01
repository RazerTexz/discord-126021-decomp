package com.lytefast.flexinput.adapters;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: EmptyListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptyListAdapter$ViewHolder extends RecyclerView$ViewHolder {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final View actionBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyListAdapter$ViewHolder(EmptyListAdapter emptyListAdapter, View view) {
        super(view);
        m.checkNotNullParameter(view, "itemView");
        View viewFindViewById = view.findViewById(EmptyListAdapter.access$getActionBtnId$p(emptyListAdapter));
        m.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(actionBtnId)");
        this.actionBtn = viewFindViewById;
    }
}
