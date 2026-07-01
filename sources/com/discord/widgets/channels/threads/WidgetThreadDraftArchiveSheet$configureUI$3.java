package com.discord.widgets.channels.threads;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.utilities.threads.ThreadUtils$ThreadArchiveDurations;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ StoreThreadDraft$ThreadDraftState $draftState;
    public final /* synthetic */ WidgetThreadDraftArchiveSheet this$0;

    public WidgetThreadDraftArchiveSheet$configureUI$3(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState) {
        this.this$0 = widgetThreadDraftArchiveSheet;
        this.$draftState = storeThreadDraft$ThreadDraftState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(this.this$0, this.$draftState, ThreadUtils$ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
    }
}
