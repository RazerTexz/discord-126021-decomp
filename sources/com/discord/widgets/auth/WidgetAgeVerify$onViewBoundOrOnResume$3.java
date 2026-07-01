package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify$onViewBoundOrOnResume$3 implements View$OnClickListener {
    public final /* synthetic */ boolean $isNSFWChannel;
    public final /* synthetic */ WidgetAgeVerify this$0;

    public WidgetAgeVerify$onViewBoundOrOnResume$3(WidgetAgeVerify widgetAgeVerify, boolean z2) {
        this.this$0 = widgetAgeVerify;
        this.$isNSFWChannel = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAgeVerify.access$getViewModel$p(this.this$0).submit(this.$isNSFWChannel);
    }
}
