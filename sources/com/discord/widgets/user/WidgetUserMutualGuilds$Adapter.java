package com.discord.widgets.user;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.user.profile.WidgetUserProfileEmptyListItem;
import d0.z.d.m;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Adapter extends MGRecyclerAdapterSimple<WidgetUserMutualGuilds$Model$Item> {
    private final Action0 guildSelectedCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMutualGuilds$Adapter(RecyclerView recyclerView, Action0 action0) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(action0, "guildSelectedCallback");
        this.guildSelectedCallback = action0;
    }

    public static final /* synthetic */ Action0 access$getGuildSelectedCallback$p(WidgetUserMutualGuilds$Adapter widgetUserMutualGuilds$Adapter) {
        return widgetUserMutualGuilds$Adapter.guildSelectedCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetUserMutualGuilds$Model$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetUserProfileEmptyListItem(R$layout.widget_user_profile_adapter_item_empty, this, 2130969608, 2131893269);
        }
        if (viewType == 1) {
            return new WidgetUserMutualGuilds$Adapter$ViewHolder(R$layout.widget_user_profile_adapter_item_server, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
