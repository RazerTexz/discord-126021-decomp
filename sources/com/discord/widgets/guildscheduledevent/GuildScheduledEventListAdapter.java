package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.GuildScheduledEventListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildScheduledEventListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter extends MGRecyclerAdapterSimple<GuildScheduledEventListItem> {
    private final Function1<GuildScheduledEventListItem.Event, Unit> onCardClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onEventStartClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onJoinClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onRsvpClicked;
    private final Function1<GuildScheduledEventListItem.Event, Unit> onShareClicked;

    /* JADX INFO: compiled from: GuildScheduledEventListAdapter.kt */
    public final class EventViewHolder extends MGRecyclerViewHolder<GuildScheduledEventListAdapter, GuildScheduledEventListItem> {
        private final GuildScheduledEventListItemBinding binding;

        public EventViewHolder() {
            super(R.layout.guild_scheduled_event_list_item, GuildScheduledEventListAdapter.this);
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
            GuildScheduledEventListItemBinding guildScheduledEventListItemBinding = new GuildScheduledEventListItemBinding(guildScheduledEventItemView, guildScheduledEventItemView);
            Intrinsics3.checkNotNullExpressionValue(guildScheduledEventListItemBinding, "GuildScheduledEventListItemBinding.bind(itemView)");
            this.binding = guildScheduledEventListItemBinding;
        }

        public static final /* synthetic */ GuildScheduledEventListAdapter access$getAdapter$p(EventViewHolder eventViewHolder) {
            return (GuildScheduledEventListAdapter) eventViewHolder.adapter;
        }

        public final GuildScheduledEventListItemBinding getBinding() {
            return this.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, GuildScheduledEventListItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final GuildScheduledEventListItem.Event event = (GuildScheduledEventListItem.Event) data;
            this.binding.f2121b.configureInEventList(event, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnCardClicked().invoke(event);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnRsvpClicked().invoke(event);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnEventStartClicked().invoke(event);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnShareClicked().invoke(event);
                }
            }, new View.OnClickListener() { // from class: com.discord.widgets.guildscheduledevent.GuildScheduledEventListAdapter$EventViewHolder$onConfigure$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildScheduledEventListAdapter.EventViewHolder.access$getAdapter$p(this.this$0).getOnJoinClicked().invoke(event);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildScheduledEventListAdapter(RecyclerView recyclerView, Function1<? super GuildScheduledEventListItem.Event, Unit> function1, Function1<? super GuildScheduledEventListItem.Event, Unit> function2, Function1<? super GuildScheduledEventListItem.Event, Unit> function3, Function1<? super GuildScheduledEventListItem.Event, Unit> function4, Function1<? super GuildScheduledEventListItem.Event, Unit> function5) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(function1, "onRsvpClicked");
        Intrinsics3.checkNotNullParameter(function2, "onEventStartClicked");
        Intrinsics3.checkNotNullParameter(function3, "onCardClicked");
        Intrinsics3.checkNotNullParameter(function4, "onJoinClicked");
        Intrinsics3.checkNotNullParameter(function5, "onShareClicked");
        this.onRsvpClicked = function1;
        this.onEventStartClicked = function2;
        this.onCardClicked = function3;
        this.onJoinClicked = function4;
        this.onShareClicked = function5;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnCardClicked() {
        return this.onCardClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnEventStartClicked() {
        return this.onEventStartClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnJoinClicked() {
        return this.onJoinClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnRsvpClicked() {
        return this.onRsvpClicked;
    }

    public final Function1<GuildScheduledEventListItem.Event, Unit> getOnShareClicked() {
        return this.onShareClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, GuildScheduledEventListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new EventViewHolder();
        }
        throw invalidViewTypeException(viewType);
    }
}
