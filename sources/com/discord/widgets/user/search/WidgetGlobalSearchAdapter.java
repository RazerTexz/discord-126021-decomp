package com.discord.widgets.user.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchModel$ItemDataPayload> {
    private Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel$ItemDataPayload, ? super Boolean, Unit> onSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onSelectedListener = WidgetGlobalSearchAdapter$onSelectedListener$1.INSTANCE;
    }

    public final Function4<View, Integer, WidgetGlobalSearchModel$ItemDataPayload, Boolean, Unit> getOnSelectedListener() {
        return this.onSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnSelectedListener(Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel$ItemDataPayload, ? super Boolean, Unit> function4) {
        m.checkNotNullParameter(function4, "<set-?>");
        this.onSelectedListener = function4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel$ItemDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == -1) {
            return new WidgetGlobalSearchAdapter$HeaderViewHolder(this);
        }
        if (viewType == 0) {
            return new WidgetGlobalSearchAdapter$ChannelViewHolder(this);
        }
        if (viewType == 1) {
            return new WidgetGlobalSearchAdapter$UserViewHolder(this);
        }
        if (viewType == 2) {
            return new WidgetGlobalSearchAdapter$GuildViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
