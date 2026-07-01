package com.discord.widgets.guildscheduledevent;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventRsvpUserListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventRsvpUserListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventRsvpUserListItem> {
    private final Function1<Long, Unit> onItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventRsvpUserListAdapter(RecyclerView recyclerView, Function1<? super Long, Unit> function1) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function1, "onItemClick");
        this.onItemClick = function1;
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter) {
        return guildScheduledEventRsvpUserListAdapter.onItemClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventRsvpUserListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GuildScheduledEventRsvpUserListAdapter$UserViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
