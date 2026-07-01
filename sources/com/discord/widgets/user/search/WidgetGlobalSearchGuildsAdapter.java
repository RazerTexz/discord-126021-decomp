package com.discord.widgets.user.search;

import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchGuildsModel$Item> {
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel$Item, Unit> onClickListener;
    private Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel$Item, Unit> onLongClickListener;
    private final int overlayColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter(RecyclerView recyclerView, @ColorInt int i) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.overlayColor = i;
        this.onClickListener = WidgetGlobalSearchGuildsAdapter$onClickListener$1.INSTANCE;
        this.onLongClickListener = WidgetGlobalSearchGuildsAdapter$onLongClickListener$1.INSTANCE;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel$Item, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    public final Function3<Integer, Integer, WidgetGlobalSearchGuildsModel$Item, Unit> getOnLongClickListener() {
        return this.onLongClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel$Item, Unit> function3) {
        m.checkNotNullParameter(function3, "<set-?>");
        this.onClickListener = function3;
    }

    public final void setOnLongClickListener(Function3<? super Integer, ? super Integer, ? super WidgetGlobalSearchGuildsModel$Item, Unit> function3) {
        m.checkNotNullParameter(function3, "<set-?>");
        this.onLongClickListener = function3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetGlobalSearchGuildsModel$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new WidgetGlobalSearchGuildsAdapter$ItemDivider(this, R$layout.widget_global_search_item_divider);
        }
        if (viewType == 2) {
            return new WidgetGlobalSearchGuildsAdapter$ItemDirectMessage(this, R$layout.widget_global_search_item_dm);
        }
        if (viewType == 3) {
            return new WidgetGlobalSearchGuildsAdapter$ItemGuild(this, R$layout.widget_global_search_item_guild, this.overlayColor);
        }
        throw invalidViewTypeException(viewType);
    }
}
