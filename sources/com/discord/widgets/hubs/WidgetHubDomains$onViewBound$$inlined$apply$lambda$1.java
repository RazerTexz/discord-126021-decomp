package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.j;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$onViewBound$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetHubDomains this$0;

    public WidgetHubDomains$onViewBound$$inlined$apply$lambda$1(Context context, WidgetHubDomains widgetHubDomains) {
        this.$context = context;
        this.this$0 = widgetHubDomains;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.g(j.g, this.this$0.getParentFragmentManager(), this.$context, WidgetHubWaitlist.class, 0, true, null, new HubWaitlistArgs(this.this$0.getArgs().getEmail()), 40);
    }
}
