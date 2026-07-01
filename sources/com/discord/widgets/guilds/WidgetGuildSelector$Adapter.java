package com.discord.widgets.guilds;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector$Adapter extends MGRecyclerAdapterSimple<WidgetGuildSelector$Item> {
    private final WidgetGuildSelector dialog;
    private final int noGuildStringId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildSelector$Adapter(RecyclerView recyclerView, WidgetGuildSelector widgetGuildSelector, int i) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(widgetGuildSelector, "dialog");
        this.dialog = widgetGuildSelector;
        this.noGuildStringId = i;
    }

    public static final /* synthetic */ WidgetGuildSelector access$getDialog$p(WidgetGuildSelector$Adapter widgetGuildSelector$Adapter) {
        return widgetGuildSelector$Adapter.dialog;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetGuildSelector$Adapter$ItemGuild onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetGuildSelector$Adapter$ItemGuild(R$layout.widget_guild_selector_item, this, this.noGuildStringId);
    }
}
