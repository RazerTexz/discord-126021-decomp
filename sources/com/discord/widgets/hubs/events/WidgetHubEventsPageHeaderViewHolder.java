package com.discord.widgets.hubs.events;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageHeaderViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsHeaderBinding binding;
    private final HubEventsEventListener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageHeaderViewHolder(WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding, HubEventsEventListener hubEventsEventListener) {
        C12238m.checkNotNullParameter(widgetHubEventsHeaderBinding, "binding");
        C12238m.checkNotNullParameter(hubEventsEventListener, "listener");
        ConstraintLayout constraintLayout = widgetHubEventsHeaderBinding.f17183a;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = widgetHubEventsHeaderBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind() {
        this.binding.f17184b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventsPageHeaderViewHolder$bind$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getListener().dismissHeader();
            }
        });
    }

    public final WidgetHubEventsHeaderBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
