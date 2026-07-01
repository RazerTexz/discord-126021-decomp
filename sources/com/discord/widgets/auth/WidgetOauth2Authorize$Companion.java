package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build$VERSION;
import b.a.d.j;
import b.a.d.m;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.g0.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$Companion {
    private WidgetOauth2Authorize$Companion() {
    }

    public static final /* synthetic */ WidgetOauth2Authorize$OAuth2Authorize access$createOauthAuthorize(WidgetOauth2Authorize$Companion widgetOauth2Authorize$Companion, Uri uri) {
        return widgetOauth2Authorize$Companion.createOauthAuthorize(uri);
    }

    public static final /* synthetic */ void access$handleError(WidgetOauth2Authorize$Companion widgetOauth2Authorize$Companion, Context context, Exception exc, Function0 function0) {
        widgetOauth2Authorize$Companion.handleError(context, exc, function0);
    }

    private final Intent createLaunchIntent(Uri requestUri, WidgetOauth2Authorize$OAuth2Authorize oAuth2Authorize) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.putExtra("REQ_URI", requestUri);
        String internalReferrer = oAuth2Authorize.getInternalReferrer();
        if ((internalReferrer == null || !Boolean.parseBoolean(internalReferrer)) && !oAuth2Authorize.isUnsupported()) {
            intent.addFlags(268468224);
        }
        return intent;
    }

    private final WidgetOauth2Authorize$OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        WidgetOauth2Authorize$Companion$createOauthAuthorize$1 widgetOauth2Authorize$Companion$createOauthAuthorize$1 = WidgetOauth2Authorize$Companion$createOauthAuthorize$1.INSTANCE;
        long j = Long.parseLong(widgetOauth2Authorize$Companion$createOauthAuthorize$1.invoke2(requestUrl, "client_id"));
        String queryParameter = requestUrl.getQueryParameter("redirect_uri");
        return new WidgetOauth2Authorize$OAuth2Authorize(j, requestUrl.getQueryParameter("state"), requestUrl.getQueryParameter("response_type"), queryParameter, null, widgetOauth2Authorize$Companion$createOauthAuthorize$1.invoke2(requestUrl, "scope"), requestUrl.getQueryParameter(ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS), requestUrl.getQueryParameter("code_challenge"), requestUrl.getQueryParameter("code_challenge_method"), requestUrl.getQueryParameter("internal_referrer"), 16, null);
    }

    private final void handleError(Context context, Exception e, Function0<Unit> onComplete) {
        String string = b.h(context, 2131893491, new Object[]{e.getMessage()}, null, 4).toString();
        AppLog.g.w(string, e);
        m.h(context, string, 1, null, 8);
        onComplete.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleError$default(WidgetOauth2Authorize$Companion widgetOauth2Authorize$Companion, Context context, Exception exc, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = WidgetOauth2Authorize$Companion$handleError$1.INSTANCE;
        }
        widgetOauth2Authorize$Companion.handleError(context, exc, function0);
    }

    public final String getNoticeName(long clientId) {
        return a.t("OAUTH_REQUEST:", clientId);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    public final void launch(Context context, Uri requestUri) {
        WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize;
        boolean z2;
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(requestUri, "requestUri");
        try {
            widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize = createOauthAuthorize(requestUri);
        } catch (Exception e) {
            handleError$default(this, context, e, null, 4, null);
            widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize = null;
        }
        if (widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize != null) {
            long clientId = widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize.getClientId();
            AnalyticsTracker.INSTANCE.oauth2AuthorizedViewed(clientId);
            if (d0.z.d.m.areEqual(String.valueOf(clientId), "591317049637339146")) {
                z2 = Build$VERSION.SDK_INT >= 28 && t.equals(Build.MANUFACTURER, "samsung", true);
            }
            j.d(context, z2 ? WidgetOauth2AuthorizeSamsung.class : WidgetOauth2Authorize.class, createLaunchIntent(requestUri, widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize));
        }
    }

    public /* synthetic */ WidgetOauth2Authorize$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
