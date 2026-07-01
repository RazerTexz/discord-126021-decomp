package com.discord.widgets.donut;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDonutBetaPopup$onViewBound$1 implements View$OnClickListener {
    public static final WidgetDonutBetaPopup$onViewBound$1 INSTANCE = new WidgetDonutBetaPopup$onViewBound$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), "https://play.google.com/apps/testing/com.discord", false, false, null, 28, null);
    }
}
