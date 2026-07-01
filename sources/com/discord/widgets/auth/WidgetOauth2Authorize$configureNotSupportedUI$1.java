package com.discord.widgets.auth;

import android.net.Uri;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import b.d.b.a.a;
import com.discord.app.AppActivity;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$configureNotSupportedUI$1 implements View$OnClickListener {
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    public WidgetOauth2Authorize$configureNotSupportedUI$1(WidgetOauth2Authorize widgetOauth2Authorize, Uri uri) {
        this.this$0 = widgetOauth2Authorize;
        this.$uri = uri;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) throws Exception {
        m.c(a.x(view, "it", "it.context"), String.valueOf(this.$uri), 0, 4);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
