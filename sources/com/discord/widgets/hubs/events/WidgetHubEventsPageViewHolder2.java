package com.discord.widgets.hubs.events;

import android.view.View;
import com.discord.databinding.WidgetHubEventBinding;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder2 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder2(WidgetHubEventBinding widgetHubEventBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        GuildScheduledEventItemView guildScheduledEventItemView = widgetHubEventBinding.a;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.root");
        super(guildScheduledEventItemView, null);
        this.binding = widgetHubEventBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind(final WidgetHubEventsViewModel2 eventData) {
        Intrinsics3.checkNotNullParameter(eventData, "eventData");
        this.binding.f2474b.configureInDirectoryEventList(eventData, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventsPageViewHolder2.this.getListener().onCardClicked(eventData);
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventsPageViewHolder2.this.getListener().onSecondaryButtonClicked(eventData);
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventsPageViewHolder2.this.getListener().onPrimaryButtonClicked(eventData);
            }
        }, new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventViewHolder.bind.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubEventsPageViewHolder2.this.getListener().onShareClicked(eventData);
            }
        });
    }

    public final WidgetHubEventBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
