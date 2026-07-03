package com.lytefast.flexinput.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmptyListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class EmptyListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final int actionBtnId;
    private final int itemLayoutId;
    private final View.OnClickListener onClickListener;

    /* JADX INFO: compiled from: EmptyListAdapter.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final View actionBtn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(EmptyListAdapter emptyListAdapter, View view) {
            super(view);
            C12238m.checkNotNullParameter(view, "itemView");
            View viewFindViewById = view.findViewById(emptyListAdapter.actionBtnId);
            C12238m.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(actionBtnId)");
            this.actionBtn = viewFindViewById;
        }
    }

    public EmptyListAdapter(@LayoutRes int i, @IdRes int i2, View.OnClickListener onClickListener) {
        C12238m.checkNotNullParameter(onClickListener, "onClickListener");
        this.itemLayoutId = i;
        this.actionBtnId = i2;
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.actionBtn.setOnClickListener(this.onClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(this.itemLayoutId, parent, false);
        C12238m.checkNotNullExpressionValue(viewInflate, "view");
        return new ViewHolder(this, viewInflate);
    }
}
