package com.discord.widgets.chat;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.intent.IntentUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions$onViewCreated$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetUrlActions this$0;

    public WidgetUrlActions$onViewCreated$3(WidgetUrlActions widgetUrlActions) {
        this.this$0 = widgetUrlActions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        String strAccess$getUrl$p = WidgetUrlActions.access$getUrl$p(this.this$0);
        String string = this.this$0.getString(2131889259);
        m.checkNotNullExpressionValue(string, "getString(R.string.form_label_send_to)");
        IntentUtils.performChooserSendIntent(contextRequireContext, strAccess$getUrl$p, string);
        this.this$0.dismiss();
    }
}
