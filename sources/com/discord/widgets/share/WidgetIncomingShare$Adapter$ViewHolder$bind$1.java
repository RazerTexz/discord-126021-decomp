package com.discord.widgets.share;

import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$Adapter$ViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ WidgetIncomingShare$Adapter$ViewHolder this$0;

    public WidgetIncomingShare$Adapter$ViewHolder$bind$1(WidgetIncomingShare$Adapter$ViewHolder widgetIncomingShare$Adapter$ViewHolder, Uri uri) {
        this.this$0 = widgetIncomingShare$Adapter$ViewHolder;
        this.$uri = uri;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetIncomingShare$Adapter.access$getOnItemClickListener$p(this.this$0.this$0).invoke(this.$uri);
    }
}
