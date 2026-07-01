package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.j;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthUndeleteAccount$onViewBoundOrOnResume$1 implements View$OnClickListener {
    public static final WidgetAuthUndeleteAccount$onViewBoundOrOnResume$1 INSTANCE = new WidgetAuthUndeleteAccount$onViewBoundOrOnResume$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        j.c(context, false, null, 4);
    }
}
