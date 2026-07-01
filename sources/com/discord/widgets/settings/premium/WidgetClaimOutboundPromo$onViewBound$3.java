package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetClaimOutboundPromo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClaimOutboundPromo$onViewBound$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetClaimOutboundPromo this$0;

    public WidgetClaimOutboundPromo$onViewBound$3(WidgetClaimOutboundPromo widgetClaimOutboundPromo) {
        this.this$0 = widgetClaimOutboundPromo;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetClaimOutboundPromo.access$getViewModel$p(this.this$0).maybeLaterClicked();
    }
}
