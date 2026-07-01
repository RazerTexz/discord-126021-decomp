package com.discord.widgets.hubs.events;

import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final HubEventsEventListener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventViewHolder(WidgetHubEventBinding widgetHubEventBinding, HubEventsEventListener hubEventsEventListener) {
        m.checkNotNullParameter(widgetHubEventBinding, "binding");
        m.checkNotNullParameter(hubEventsEventListener, "listener");
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.a;
        m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind(HubGuildScheduledEventData eventData) {
        m.checkNotNullParameter(eventData, "eventData");
        this.binding.f2474b.configureInDirectoryEventList(eventData, new WidgetHubEventViewHolder$bind$1(this, eventData), new WidgetHubEventViewHolder$bind$2(this, eventData), new WidgetHubEventViewHolder$bind$3(this, eventData), new WidgetHubEventViewHolder$bind$4(this, eventData));
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
