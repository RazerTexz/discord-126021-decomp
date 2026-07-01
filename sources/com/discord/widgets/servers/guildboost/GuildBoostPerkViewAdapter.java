package com.discord.widgets.servers.guildboost;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildBoostPerkViewAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostPerkViewAdapter extends MGRecyclerAdapterSimple<GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostPerkViewAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void configure(List<GuildBoostPerkViewAdapter$GuildBoostPerkViewListItem> perkItems) {
        m.checkNotNullParameter(perkItems, "perkItems");
        setData(perkItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public GuildBoostPerkViewAdapter$PerkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new GuildBoostPerkViewAdapter$PerkViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
