package com.discord.widgets.guild_role_subscriptions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PriceTierPickerAdapter extends RecyclerView.Adapter<PriceTierViewHolder> {
    private final Function1<Integer, Unit> itemClickListener;
    private List<Integer> items;

    /* JADX WARN: Multi-variable type inference failed */
    public PriceTierPickerAdapter(Function1<? super Integer, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "itemClickListener");
        this.itemClickListener = function1;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final void setItems(List<Integer> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PriceTierViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        holder.configureUI(this.items.get(position).intValue(), this.itemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PriceTierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingM8381a = DialogSimpleSelectorItemBinding.m8381a(LayoutInflater.from(parent.getContext()), parent, false);
        C12238m.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingM8381a, "DialogSimpleSelectorItem…rent,\n        false\n    )");
        return new PriceTierViewHolder(dialogSimpleSelectorItemBindingM8381a);
    }
}
