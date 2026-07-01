package com.discord.widgets.settings.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.ExperimentOverridesListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.experiments.ExperimentOverrideView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ExperimentOverridesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentOverridesAdapter extends RecyclerView$Adapter<ExperimentOverridesAdapter$ExperimentViewHolder> {
    private List<? extends ExperimentOverridesAdapter$Item> items = n.emptyList();

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((ExperimentOverridesAdapter$ExperimentViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends ExperimentOverridesAdapter$Item> items) {
        m.checkNotNullParameter(items, "items");
        this.items = items;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ExperimentOverridesAdapter$ExperimentViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        holder.bind(this.items.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public ExperimentOverridesAdapter$ExperimentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.experiment_overrides_list_item, parent, false);
        ExperimentOverrideView experimentOverrideView = (ExperimentOverrideView) viewInflate.findViewById(R$id.experiment_overrides_list_item_experiment_override_view);
        if (experimentOverrideView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R$id.experiment_overrides_list_item_experiment_override_view)));
        }
        ExperimentOverridesListItemBinding experimentOverridesListItemBinding = new ExperimentOverridesListItemBinding((CardView) viewInflate, experimentOverrideView);
        m.checkNotNullExpressionValue(experimentOverridesListItemBinding, "ExperimentOverridesListI….context), parent, false)");
        return new ExperimentOverridesAdapter$ExperimentViewHolder(experimentOverridesListItemBinding);
    }
}
