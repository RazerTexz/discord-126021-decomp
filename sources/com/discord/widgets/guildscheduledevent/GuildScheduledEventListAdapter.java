package com.discord.widgets.guildscheduledevent;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventListItem> {
    private final Function1<GuildScheduledEventListItem$Event, Unit> onCardClicked;
    private final Function1<GuildScheduledEventListItem$Event, Unit> onEventStartClicked;
    private final Function1<GuildScheduledEventListItem$Event, Unit> onJoinClicked;
    private final Function1<GuildScheduledEventListItem$Event, Unit> onRsvpClicked;
    private final Function1<GuildScheduledEventListItem$Event, Unit> onShareClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventListAdapter(RecyclerView recyclerView, Function1<? super GuildScheduledEventListItem$Event, Unit> function1, Function1<? super GuildScheduledEventListItem$Event, Unit> function2, Function1<? super GuildScheduledEventListItem$Event, Unit> function3, Function1<? super GuildScheduledEventListItem$Event, Unit> function4, Function1<? super GuildScheduledEventListItem$Event, Unit> function5) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function1, "onRsvpClicked");
        m.checkNotNullParameter(function2, "onEventStartClicked");
        m.checkNotNullParameter(function3, "onCardClicked");
        m.checkNotNullParameter(function4, "onJoinClicked");
        m.checkNotNullParameter(function5, "onShareClicked");
        this.onRsvpClicked = function1;
        this.onEventStartClicked = function2;
        this.onCardClicked = function3;
        this.onJoinClicked = function4;
        this.onShareClicked = function5;
    }

    public final Function1<GuildScheduledEventListItem$Event, Unit> getOnCardClicked() {
        return this.onCardClicked;
    }

    public final Function1<GuildScheduledEventListItem$Event, Unit> getOnEventStartClicked() {
        return this.onEventStartClicked;
    }

    public final Function1<GuildScheduledEventListItem$Event, Unit> getOnJoinClicked() {
        return this.onJoinClicked;
    }

    public final Function1<GuildScheduledEventListItem$Event, Unit> getOnRsvpClicked() {
        return this.onRsvpClicked;
    }

    public final Function1<GuildScheduledEventListItem$Event, Unit> getOnShareClicked() {
        return this.onShareClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GuildScheduledEventListAdapter$EventViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
