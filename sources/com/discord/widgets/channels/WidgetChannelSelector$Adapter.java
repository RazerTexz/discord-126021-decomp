package com.discord.widgets.channels;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$Adapter extends MGRecyclerAdapterSimple<WidgetChannelSelector$Model$Item> {
    private final WidgetChannelSelector dialog;
    private final int noChannelStringId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector$Adapter(RecyclerView recyclerView, WidgetChannelSelector widgetChannelSelector, int i) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(widgetChannelSelector, "dialog");
        this.dialog = widgetChannelSelector;
        this.noChannelStringId = i;
    }

    public static final /* synthetic */ WidgetChannelSelector access$getDialog$p(WidgetChannelSelector$Adapter widgetChannelSelector$Adapter) {
        return widgetChannelSelector$Adapter.dialog;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetChannelSelector$Adapter$ItemChannel onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetChannelSelector$Adapter$ItemChannel(R$layout.widget_channel_selector_item, this, this.noChannelStringId);
    }
}
