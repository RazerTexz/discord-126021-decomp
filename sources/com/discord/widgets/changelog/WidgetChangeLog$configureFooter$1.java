package com.discord.widgets.changelog;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$configureFooter$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog$configureFooter$1(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, this.this$0.requireContext(), this.this$0.getString(2131896484), false, false, null, 28, null);
    }
}
