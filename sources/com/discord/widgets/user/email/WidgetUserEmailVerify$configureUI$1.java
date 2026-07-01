package com.discord.widgets.user.email;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserEmailVerify this$0;

    public WidgetUserEmailVerify$configureUI$1(WidgetUserEmailVerify widgetUserEmailVerify) {
        this.this$0 = widgetUserEmailVerify;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserEmailUpdate$Companion.launch$default(WidgetUserEmailUpdate.Companion, a.x(view, "it", "it.context"), WidgetUserEmailVerify.access$getMode$p(this.this$0), null, 4, null);
    }
}
