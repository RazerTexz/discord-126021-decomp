package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndGuildScheduledEventBottomSheet$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetEndGuildScheduledEventBottomSheet this$0;

    public WidgetEndGuildScheduledEventBottomSheet$onViewCreated$2(WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet) {
        this.this$0 = widgetEndGuildScheduledEventBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetEndGuildScheduledEventBottomSheet.access$onConfirmEnd(this.this$0);
        WidgetEndGuildScheduledEventBottomSheet.access$callOnActionTaken(this.this$0);
    }
}
