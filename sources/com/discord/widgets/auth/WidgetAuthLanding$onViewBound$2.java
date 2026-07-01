package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.j;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding$onViewBound$2 implements View$OnClickListener {
    public static final WidgetAuthLanding$onViewBound$2 INSTANCE = new WidgetAuthLanding$onViewBound$2();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        j.e(context, WidgetAuthLogin.class, null, 4);
    }
}
