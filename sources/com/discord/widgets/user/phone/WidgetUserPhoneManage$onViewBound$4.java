package com.discord.widgets.user.phone;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPhoneManage$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserPhoneManage this$0;

    public WidgetUserPhoneManage$onViewBound$4(WidgetUserPhoneManage widgetUserPhoneManage) {
        this.this$0 = widgetUserPhoneManage;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserPhoneManage.updatePhoneNumber$default(this.this$0, null, 1, null);
    }
}
