package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.R$layout;
import com.discord.databinding.GuildScheduledEventListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: GuildScheduledEventListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListAdapter$EventViewHolder extends MGRecyclerViewHolder<GuildScheduledEventListAdapter, GuildScheduledEventListItem> {
    private final GuildScheduledEventListItemBinding binding;
    public final /* synthetic */ GuildScheduledEventListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventListAdapter$EventViewHolder(GuildScheduledEventListAdapter guildScheduledEventListAdapter) {
        super(R$layout.guild_scheduled_event_list_item, guildScheduledEventListAdapter);
        this.this$0 = guildScheduledEventListAdapter;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
        GuildScheduledEventListItemBinding guildScheduledEventListItemBinding = new GuildScheduledEventListItemBinding(guildScheduledEventItemView, guildScheduledEventItemView);
        m.checkNotNullExpressionValue(guildScheduledEventListItemBinding, "GuildScheduledEventListItemBinding.bind(itemView)");
        this.binding = guildScheduledEventListItemBinding;
    }

    public static final /* synthetic */ GuildScheduledEventListAdapter access$getAdapter$p(GuildScheduledEventListAdapter$EventViewHolder guildScheduledEventListAdapter$EventViewHolder) {
        return (GuildScheduledEventListAdapter) guildScheduledEventListAdapter$EventViewHolder.adapter;
    }

    public final GuildScheduledEventListItemBinding getBinding() {
        return this.binding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, GuildScheduledEventListItem guildScheduledEventListItem) {
        onConfigure2(i, guildScheduledEventListItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, GuildScheduledEventListItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GuildScheduledEventListItem$Event guildScheduledEventListItem$Event = (GuildScheduledEventListItem$Event) data;
        this.binding.f2121b.configureInEventList(guildScheduledEventListItem$Event, new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$1(this, guildScheduledEventListItem$Event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$2(this, guildScheduledEventListItem$Event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$3(this, guildScheduledEventListItem$Event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$4(this, guildScheduledEventListItem$Event), new GuildScheduledEventListAdapter$EventViewHolder$onConfigure$5(this, guildScheduledEventListItem$Event));
    }
}
