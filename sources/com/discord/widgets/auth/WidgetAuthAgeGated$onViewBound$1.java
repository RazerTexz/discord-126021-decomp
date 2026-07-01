package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetAuthAgeGated.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthAgeGated$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthAgeGated this$0;

    public WidgetAuthAgeGated$onViewBound$1(WidgetAuthAgeGated widgetAuthAgeGated) {
        this.this$0 = widgetAuthAgeGated;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.requireActivity().finish();
    }
}
