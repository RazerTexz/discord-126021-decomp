package com.discord.widgets.guild_role_subscriptions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerAdapter extends RecyclerView$Adapter<PriceTierViewHolder> {
    private final Function1<Integer, Unit> itemClickListener;
    private List<Integer> items;

    /* JADX WARN: Multi-variable type inference failed */
    public PriceTierPickerAdapter(Function1<? super Integer, Unit> function1) {
        m.checkNotNullParameter(function1, "itemClickListener");
        this.itemClickListener = function1;
        this.items = n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((PriceTierViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<Integer> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(PriceTierViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.configureUI(this.items.get(position).intValue(), this.itemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public PriceTierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingA = DialogSimpleSelectorItemBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
        m.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingA, "DialogSimpleSelectorItem…rent,\n        false\n    )");
        return new PriceTierViewHolder(dialogSimpleSelectorItemBindingA);
    }
}
