package com.discord.widgets.hubs.events;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageHeaderViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsHeaderBinding binding;
    private final HubEventsEventListener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageHeaderViewHolder(WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding, HubEventsEventListener hubEventsEventListener) {
        m.checkNotNullParameter(widgetHubEventsHeaderBinding, "binding");
        m.checkNotNullParameter(hubEventsEventListener, "listener");
        ConstraintLayout constraintLayout = widgetHubEventsHeaderBinding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = widgetHubEventsHeaderBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind() {
        this.binding.f2476b.setOnClickListener(new WidgetHubEventsPageHeaderViewHolder$bind$$inlined$apply$lambda$1(this));
    }

    public final WidgetHubEventsHeaderBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
