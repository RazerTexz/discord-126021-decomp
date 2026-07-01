package com.discord.widgets.debugging;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.app.AppLog$LoggedItem;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDebugging$Adapter extends MGRecyclerAdapterSimple<AppLog$LoggedItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDebugging$Adapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        setOnUpdated(new WidgetDebugging$Adapter$1(recyclerView));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public /* bridge */ /* synthetic */ MGRecyclerDataPayload getItem(int i) {
        return getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, AppLog$LoggedItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetDebugging$Adapter$Item(R$layout.widget_debugging_adapter_item, this);
        }
        throw invalidViewTypeException(viewType);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, com.discord.utilities.mg_recycler.MGRecyclerAdapter
    public AppLog$LoggedItem getItem(int position) {
        return getInternalData().get((getInternalData().size() - 1) - position);
    }
}
