package com.discord.widgets.hubs.events;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.databinding.WidgetHubEventsFooterBinding;
import com.discord.stores.utilities.Loading;
import com.discord.views.LoadingButton;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageFooterViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsFooterBinding binding;
    private final HubEventsEventListener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageFooterViewHolder(WidgetHubEventsFooterBinding widgetHubEventsFooterBinding, HubEventsEventListener hubEventsEventListener) {
        C12238m.checkNotNullParameter(widgetHubEventsFooterBinding, "binding");
        C12238m.checkNotNullParameter(hubEventsEventListener, "listener");
        LinearLayout linearLayout = widgetHubEventsFooterBinding.f17181a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = widgetHubEventsFooterBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind(final HubEventsPage.Footer footer) {
        C12238m.checkNotNullParameter(footer, "footer");
        LoadingButton loadingButton = this.binding.f17182b;
        loadingButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getListener().fetchGuildScheduledEvents();
            }
        });
        loadingButton.setIsLoading(footer.getEventsAsync() instanceof Loading);
    }

    public final WidgetHubEventsFooterBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
