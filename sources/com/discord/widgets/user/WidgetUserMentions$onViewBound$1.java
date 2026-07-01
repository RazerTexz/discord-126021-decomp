package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserMentions this$0;

    public WidgetUserMentions$onViewBound$1(WidgetUserMentions widgetUserMentions) {
        this.this$0 = widgetUserMentions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserMentions.access$getDismissViewModel$p(this.this$0).dismiss();
    }
}
