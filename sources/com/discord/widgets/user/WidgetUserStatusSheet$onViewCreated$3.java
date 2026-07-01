package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.presence.ClientStatus;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet$onViewCreated$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserStatusSheet this$0;

    public WidgetUserStatusSheet$onViewCreated$3(WidgetUserStatusSheet widgetUserStatusSheet) {
        this.this$0 = widgetUserStatusSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserStatusSheet.access$updateStateAndDismiss(this.this$0, ClientStatus.DND);
    }
}
