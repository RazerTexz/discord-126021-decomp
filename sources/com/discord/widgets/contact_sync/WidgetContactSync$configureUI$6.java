package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureUI$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetContactSync this$0;

    public WidgetContactSync$configureUI$6(WidgetContactSync widgetContactSync) {
        this.this$0 = widgetContactSync;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetContactSync.access$getViewModel$p(this.this$0).onBulkAddFriends();
    }
}
