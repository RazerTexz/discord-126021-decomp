package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthPhoneVerify$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthPhoneVerify this$0;

    public WidgetAuthPhoneVerify$onViewBound$2(WidgetAuthPhoneVerify widgetAuthPhoneVerify) {
        this.this$0 = widgetAuthPhoneVerify;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthPhoneVerify.access$bailoutToEmail(this.this$0);
    }
}
