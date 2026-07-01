package com.discord.widgets.user.usersheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$6 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureProfileActionButtons$6(WidgetUserSheet widgetUserSheet) {
        this.this$0 = widgetUserSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserSheet.access$getViewModel$p(this.this$0).launchVideoCall();
    }
}
