package com.discord.widgets.user.account;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.email.WidgetUserEmailVerify$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserAccountVerify this$0;

    public WidgetUserAccountVerify$onViewBound$$inlined$with$lambda$1(WidgetUserAccountVerify widgetUserAccountVerify) {
        this.this$0 = widgetUserAccountVerify;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullParameter(view, "v");
        WidgetUserEmailVerify$Companion widgetUserEmailVerify$Companion = WidgetUserEmailVerify.Companion;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        widgetUserEmailVerify$Companion.launch(context, this.this$0.getMode());
    }
}
