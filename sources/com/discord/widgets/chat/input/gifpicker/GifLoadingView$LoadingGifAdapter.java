package com.discord.widgets.chat.input.gifpicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.databinding.LoadingGifItemViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: GifLoadingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifLoadingView$LoadingGifAdapter extends RecyclerView$Adapter<GifLoadingView$LoadingGifViewHolder> {
    private List<Integer> heightsDp = n.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.heightsDp.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((GifLoadingView$LoadingGifViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<Integer> heightsDp) {
        m.checkNotNullParameter(heightsDp, "heightsDp");
        this.heightsDp = heightsDp;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(GifLoadingView$LoadingGifViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.configure(this.heightsDp.get(position).intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public GifLoadingView$LoadingGifViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.loading_gif_item_view, parent, false);
        Objects.requireNonNull(viewInflate, "rootView");
        LoadingGifItemViewBinding loadingGifItemViewBinding = new LoadingGifItemViewBinding((CardView) viewInflate);
        m.checkNotNullExpressionValue(loadingGifItemViewBinding, "LoadingGifItemViewBindin….context), parent, false)");
        return new GifLoadingView$LoadingGifViewHolder(loadingGifItemViewBinding);
    }
}
