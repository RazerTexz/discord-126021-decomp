package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$4(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        this.this$0 = widgetGuildScheduledEventDetailsBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetGuildScheduledEventDetailsExtrasBottomSheet$Companion widgetGuildScheduledEventDetailsExtrasBottomSheet$Companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetGuildScheduledEventDetailsExtrasBottomSheet$Companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(this.this$0));
    }
}
