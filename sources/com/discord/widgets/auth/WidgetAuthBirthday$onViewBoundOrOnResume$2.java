package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$onViewBoundOrOnResume$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthBirthday this$0;

    public WidgetAuthBirthday$onViewBoundOrOnResume$2(WidgetAuthBirthday widgetAuthBirthday) {
        this.this$0 = widgetAuthBirthday;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.submit();
    }
}
