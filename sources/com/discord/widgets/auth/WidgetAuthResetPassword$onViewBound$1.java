package com.discord.widgets.auth;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: WidgetAuthResetPassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthResetPassword$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthResetPassword this$0;

    public WidgetAuthResetPassword$onViewBound$1(WidgetAuthResetPassword widgetAuthResetPassword) {
        this.this$0 = widgetAuthResetPassword;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UriHandler uriHandler = UriHandler.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        StringBuilder sbU = a.U("https://discord.com/reset#token=");
        sbU.append(WidgetAuthResetPassword.access$getToken$p(this.this$0));
        UriHandler.handle$default(uriHandler, contextRequireContext, sbU.toString(), false, false, null, 28, null);
        this.this$0.requireActivity().finish();
    }
}
