package com.discord.widgets.auth;

import android.content.Intent;
import android.net.Uri;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponsePost;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$authorizeApplication$2 extends o implements Function1<RestAPIParams$OAuth2Authorize$ResponsePost, Unit> {
    public final /* synthetic */ WidgetOauth2Authorize this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2Authorize$authorizeApplication$2(WidgetOauth2Authorize widgetOauth2Authorize) {
        super(1);
        this.this$0 = widgetOauth2Authorize;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams$OAuth2Authorize$ResponsePost restAPIParams$OAuth2Authorize$ResponsePost) throws Exception {
        invoke2(restAPIParams$OAuth2Authorize$ResponsePost);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestAPIParams$OAuth2Authorize$ResponsePost restAPIParams$OAuth2Authorize$ResponsePost) throws Exception {
        m.checkNotNullParameter(restAPIParams$OAuth2Authorize$ResponsePost, "it");
        Uri uri = Uri.parse(restAPIParams$OAuth2Authorize$ResponsePost.getLocation());
        Logger.d$default(AppLog.g, "Redirect OAuth flow to: " + uri, null, 2, null);
        Intent intentAddFlags = new Intent("android.intent.action.VIEW", uri).addFlags(268435456);
        m.checkNotNullExpressionValue(intentAddFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.startActivity(intentAddFlags);
        }
        AppActivity appActivity2 = this.this$0.getAppActivity();
        if (appActivity2 != null) {
            appActivity2.setResult(-1);
        }
        AppActivity appActivity3 = this.this$0.getAppActivity();
        if (appActivity3 != null) {
            appActivity3.onBackPressed();
        }
    }
}
