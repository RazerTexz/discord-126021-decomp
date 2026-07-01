package com.discord.widgets.share;

import android.view.View;
import android.view.View$OnClickListener;
import b.i.a.f.e.o.f;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBound$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetIncomingShare this$0;

    public WidgetIncomingShare$onViewBound$4(WidgetIncomingShare widgetIncomingShare) {
        this.this$0 = widgetIncomingShare;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextInputLayout textInputLayout = WidgetIncomingShare.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalShareSearch");
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(textInputLayout);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new WidgetIncomingShare$onViewBound$4$1(this, null), 3, null);
        }
        WidgetIncomingShare.access$getSelectedReceiverPublisher$p(this.this$0).onNext(null);
    }
}
