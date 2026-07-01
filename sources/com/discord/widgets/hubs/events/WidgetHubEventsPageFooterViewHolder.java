package com.discord.widgets.hubs.events;

import android.widget.LinearLayout;
import com.discord.databinding.WidgetHubEventsFooterBinding;
import com.discord.stores.utilities.Loading;
import com.discord.views.LoadingButton;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageFooterViewHolder extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsFooterBinding binding;
    private final HubEventsEventListener listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageFooterViewHolder(WidgetHubEventsFooterBinding widgetHubEventsFooterBinding, HubEventsEventListener hubEventsEventListener) {
        m.checkNotNullParameter(widgetHubEventsFooterBinding, "binding");
        m.checkNotNullParameter(hubEventsEventListener, "listener");
        LinearLayout linearLayout = widgetHubEventsFooterBinding.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        super(linearLayout, null);
        this.binding = widgetHubEventsFooterBinding;
        this.listener = hubEventsEventListener;
    }

    public final void bind(HubEventsPage$Footer footer) {
        m.checkNotNullParameter(footer, "footer");
        LoadingButton loadingButton = this.binding.f2475b;
        loadingButton.setOnClickListener(new WidgetHubEventsPageFooterViewHolder$bind$$inlined$apply$lambda$1(this, footer));
        loadingButton.setIsLoading(footer.getEventsAsync() instanceof Loading);
    }

    public final WidgetHubEventsFooterBinding getBinding() {
        return this.binding;
    }

    public final HubEventsEventListener getListener() {
        return this.listener;
    }
}
