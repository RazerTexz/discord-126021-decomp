package com.discord.widgets.media;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia$onViewBound$1(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetMedia.access$onMediaClick(this.this$0);
    }
}
