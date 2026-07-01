package com.discord.widgets.auth;

import b.a.d.d0;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponseGet;
import d0.z.d.m;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2Authorize$OAuth2ViewModel extends d0<Unit> {
    public WidgetOauth2Authorize$OAuth2Authorize oauthAuthorize;
    private RestAPIParams$OAuth2Authorize$ResponseGet oauthGetResponse;

    public WidgetOauth2Authorize$OAuth2ViewModel() {
        super(null, 1, null);
    }

    public final WidgetOauth2Authorize$OAuth2Authorize getOauthAuthorize() {
        WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2Authorize = this.oauthAuthorize;
        if (widgetOauth2Authorize$OAuth2Authorize == null) {
            m.throwUninitializedPropertyAccessException("oauthAuthorize");
        }
        return widgetOauth2Authorize$OAuth2Authorize;
    }

    public final RestAPIParams$OAuth2Authorize$ResponseGet getOauthGetResponse() {
        return this.oauthGetResponse;
    }

    public final void setOauthAuthorize(WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2Authorize) {
        m.checkNotNullParameter(widgetOauth2Authorize$OAuth2Authorize, "<set-?>");
        this.oauthAuthorize = widgetOauth2Authorize$OAuth2Authorize;
    }

    public final void setOauthGetResponse(RestAPIParams$OAuth2Authorize$ResponseGet restAPIParams$OAuth2Authorize$ResponseGet) {
        this.oauthGetResponse = restAPIParams$OAuth2Authorize$ResponseGet;
    }
}
