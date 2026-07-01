package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.CheckedSetting;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetPreviewGuildScheduledEvent this$0;

    public WidgetPreviewGuildScheduledEvent$onViewBound$3(WidgetPreviewGuildScheduledEvent widgetPreviewGuildScheduledEvent) {
        this.this$0 = widgetPreviewGuildScheduledEvent;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModelAccess$getViewModel$p = WidgetPreviewGuildScheduledEvent.access$getViewModel$p(this.this$0);
        CheckedSetting checkedSetting = WidgetPreviewGuildScheduledEvent.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(checkedSetting, "checkedSetting");
        previewGuildScheduledEventViewModelAccess$getViewModel$p.onBottomButtonClicked(this.this$0.requireContext(), (checkedSetting.getVisibility() == 0) && checkedSetting.isChecked(), new WidgetPreviewGuildScheduledEvent$onViewBound$3$2(this));
    }
}
