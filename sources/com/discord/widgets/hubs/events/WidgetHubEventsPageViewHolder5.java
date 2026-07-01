package com.discord.widgets.hubs.events;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.databinding.WidgetHubEventsHeaderBinding;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPageHeaderViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEventsPageViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPageViewHolder5 extends WidgetHubEventsPageViewHolder {
    private final WidgetHubEventsHeaderBinding binding;
    private final WidgetHubEventsPage3 listener;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetHubEventsPageViewHolder5(WidgetHubEventsHeaderBinding widgetHubEventsHeaderBinding, WidgetHubEventsPage3 widgetHubEventsPage3) {
        Intrinsics3.checkNotNullParameter(widgetHubEventsHeaderBinding, "binding");
        Intrinsics3.checkNotNullParameter(widgetHubEventsPage3, "listener");
        ConstraintLayout constraintLayout = widgetHubEventsHeaderBinding.a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        super(constraintLayout, null);
        this.binding = widgetHubEventsHeaderBinding;
        this.listener = widgetHubEventsPage3;
    }

    public final void bind() {
        this.binding.f2476b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.events.WidgetHubEventsPageHeaderViewHolder$bind$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getListener().dismissHeader();
            }
        });
    }

    public final WidgetHubEventsHeaderBinding getBinding() {
        return this.binding;
    }

    public final WidgetHubEventsPage3 getListener() {
        return this.listener;
    }
}
