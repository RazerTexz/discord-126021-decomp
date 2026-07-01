package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$onViewBoundOrOnResume$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetAgeVerify this$0;

    public WidgetAgeVerify$onViewBoundOrOnResume$1(WidgetAgeVerify widgetAgeVerify) {
        this.this$0 = widgetAgeVerify;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requireAppActivity().refreshEnabled = true;
        this.this$0.requireActivity().finish();
    }
}
