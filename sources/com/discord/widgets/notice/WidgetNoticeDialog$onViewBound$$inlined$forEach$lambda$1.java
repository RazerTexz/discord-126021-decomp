package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Map$Entry $entry;
    public final /* synthetic */ View $view$inlined;
    public final /* synthetic */ WidgetNoticeDialog this$0;

    public WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1(Map$Entry map$Entry, WidgetNoticeDialog widgetNoticeDialog, View view) {
        this.$entry = map$Entry;
        this.this$0 = widgetNoticeDialog;
        this.$view$inlined = view;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ((Function1) this.$entry.getValue()).invoke(this.$view$inlined);
        this.this$0.dismiss();
    }
}
