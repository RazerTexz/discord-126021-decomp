package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetBanUser this$0;

    public WidgetBanUser$onViewBound$2(WidgetBanUser widgetBanUser) {
        this.this$0 = widgetBanUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
