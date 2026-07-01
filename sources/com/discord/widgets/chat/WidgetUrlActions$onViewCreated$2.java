package com.discord.widgets.chat;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions$onViewCreated$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetUrlActions this$0;

    public WidgetUrlActions$onViewCreated$2(WidgetUrlActions widgetUrlActions) {
        this.this$0 = widgetUrlActions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), WidgetUrlActions.access$getUrl$p(this.this$0), false, false, null, 28, null);
        this.this$0.dismiss();
    }
}
