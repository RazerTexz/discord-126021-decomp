package com.discord.widgets.channels;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChannelOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelOnboarding$onViewCreated$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChannelOnboarding this$0;

    public WidgetChannelOnboarding$onViewCreated$1(WidgetChannelOnboarding widgetChannelOnboarding) {
        this.this$0 = widgetChannelOnboarding;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
    }
}
