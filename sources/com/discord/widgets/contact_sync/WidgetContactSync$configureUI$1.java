package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureUI$1 implements View$OnClickListener {
    public static final WidgetContactSync$configureUI$1 INSTANCE = new WidgetContactSync$configureUI$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        m.checkNotNullExpressionValue(view, "view");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        Uri uriFromParts = Uri.fromParts("package", context.getPackageName(), null);
        m.checkNotNullExpressionValue(uriFromParts, "Uri.fromParts(\"package\",…ontext.packageName, null)");
        intent.setData(uriFromParts);
        view.getContext().startActivity(intent);
    }
}
