package com.discord.widgets.share;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBound$3 implements View$OnFocusChangeListener {
    public final /* synthetic */ WidgetIncomingShare this$0;

    public WidgetIncomingShare$onViewBound$3(WidgetIncomingShare widgetIncomingShare) {
        this.this$0 = widgetIncomingShare;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            NestedScrollView nestedScrollView = WidgetIncomingShare.access$getBinding$p(this.this$0).j;
            TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(this.this$0).d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareComment");
            nestedScrollView.smoothScrollTo(0, textInputLayout.getBottom());
        }
    }
}
