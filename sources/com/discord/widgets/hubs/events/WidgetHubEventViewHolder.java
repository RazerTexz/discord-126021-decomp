package com.discord.widgets.hubs.events;

import android.view.View;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final HubEventsEventListener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventViewHolder(WidgetHubEventBinding widgetHubEventBinding, HubEventsEventListener hubEventsEventListener) {
        C12238m.checkNotNullParameter(widgetHubEventBinding, "binding");
        C12238m.checkNotNullParameter(hubEventsEventListener, "listener");
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.f17179a;
        C12238m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind(final HubGuildScheduledEventData eventData) {
        C12238m.checkNotNullParameter(eventData, "eventData");
        this.binding.f17180b.configureInDirectoryEventList(eventData, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventViewHolder.this.getListener().onCardClicked(eventData);
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventViewHolder.this.getListener().onSecondaryButtonClicked(eventData);
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventViewHolder.this.getListener().onPrimaryButtonClicked(eventData);
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventViewHolder.this.getListener().onShareClicked(eventData);
            }
        });
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
