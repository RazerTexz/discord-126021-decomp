package com.discord.widgets.changelog;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.f;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial$onViewBound$4(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler.handle$default(UriHandler.INSTANCE, this.this$0.requireContext(), f.a.a(360056891113L, null), false, false, null, 28, null);
    }
}
