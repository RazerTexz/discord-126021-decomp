package com.discord.widgets.client;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetClientOutdated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetClientOutdated$onViewCreated$1 implements View$OnClickListener {
    public static final WidgetClientOutdated$onViewCreated$1 INSTANCE = new WidgetClientOutdated$onViewCreated$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.checkNotNullExpressionValue(view, "v");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "v.context");
        UriHandler.directToPlayStore$default(context, null, null, 6, null);
    }
}
