package com.discord.widgets.auth;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.auth.OAuthScope$Bot;
import com.discord.api.auth.OAuthScope$WebhookIncoming;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponseGet;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponsePost;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.rest.RestAPI;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetOauth2Authorize$OAuth2Authorize {
    private final long clientId;
    private final String codeChallenge;
    private final String codeChallengeMethod;
    private final String internalReferrer;
    private final String permissions;
    private final String prompt;
    private final String redirectUrl;
    private final String responseType;
    private final String scope;
    private final String state;

    public WidgetOauth2Authorize$OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        m.checkNotNullParameter(str4, "prompt");
        m.checkNotNullParameter(str5, "scope");
        this.clientId = j;
        this.state = str;
        this.responseType = str2;
        this.redirectUrl = str3;
        this.prompt = str4;
        this.scope = str5;
        this.permissions = str6;
        this.codeChallenge = str7;
        this.codeChallengeMethod = str8;
        this.internalReferrer = str9;
    }

    public static /* synthetic */ WidgetOauth2Authorize$OAuth2Authorize copy$default(WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2Authorize, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        return widgetOauth2Authorize$OAuth2Authorize.copy((i & 1) != 0 ? widgetOauth2Authorize$OAuth2Authorize.clientId : j, (i & 2) != 0 ? widgetOauth2Authorize$OAuth2Authorize.state : str, (i & 4) != 0 ? widgetOauth2Authorize$OAuth2Authorize.responseType : str2, (i & 8) != 0 ? widgetOauth2Authorize$OAuth2Authorize.redirectUrl : str3, (i & 16) != 0 ? widgetOauth2Authorize$OAuth2Authorize.prompt : str4, (i & 32) != 0 ? widgetOauth2Authorize$OAuth2Authorize.scope : str5, (i & 64) != 0 ? widgetOauth2Authorize$OAuth2Authorize.permissions : str6, (i & 128) != 0 ? widgetOauth2Authorize$OAuth2Authorize.codeChallenge : str7, (i & 256) != 0 ? widgetOauth2Authorize$OAuth2Authorize.codeChallengeMethod : str8, (i & 512) != 0 ? widgetOauth2Authorize$OAuth2Authorize.internalReferrer : str9);
    }

    private final boolean getHasBotPermission() {
        List<String> listSplit$default = w.split$default((CharSequence) this.scope, new String[]{" "}, false, 0, 6, (Object) null);
        if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
            return false;
        }
        for (String str : listSplit$default) {
            if (t.equals(str, OAuthScope$Bot.INSTANCE.getScopeName(), true) || t.equals(str, OAuthScope$WebhookIncoming.INSTANCE.getScopeName(), true)) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ Observable post$default(WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2Authorize, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return widgetOauth2Authorize$OAuth2Authorize.post(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getInternalReferrer() {
        return this.internalReferrer;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getPermissions() {
        return this.permissions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    public final WidgetOauth2Authorize$OAuth2Authorize copy(long clientId, String state, String responseType, String redirectUrl, String prompt, String scope, String permissions, String codeChallenge, String codeChallengeMethod, String internalReferrer) {
        m.checkNotNullParameter(prompt, "prompt");
        m.checkNotNullParameter(scope, "scope");
        return new WidgetOauth2Authorize$OAuth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, internalReferrer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetOauth2Authorize$OAuth2Authorize)) {
            return false;
        }
        WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2Authorize = (WidgetOauth2Authorize$OAuth2Authorize) other;
        return this.clientId == widgetOauth2Authorize$OAuth2Authorize.clientId && m.areEqual(this.state, widgetOauth2Authorize$OAuth2Authorize.state) && m.areEqual(this.responseType, widgetOauth2Authorize$OAuth2Authorize.responseType) && m.areEqual(this.redirectUrl, widgetOauth2Authorize$OAuth2Authorize.redirectUrl) && m.areEqual(this.prompt, widgetOauth2Authorize$OAuth2Authorize.prompt) && m.areEqual(this.scope, widgetOauth2Authorize$OAuth2Authorize.scope) && m.areEqual(this.permissions, widgetOauth2Authorize$OAuth2Authorize.permissions) && m.areEqual(this.codeChallenge, widgetOauth2Authorize$OAuth2Authorize.codeChallenge) && m.areEqual(this.codeChallengeMethod, widgetOauth2Authorize$OAuth2Authorize.codeChallengeMethod) && m.areEqual(this.internalReferrer, widgetOauth2Authorize$OAuth2Authorize.internalReferrer);
    }

    public final Observable<RestAPIParams$OAuth2Authorize$ResponseGet> get() {
        return RestAPI.Companion.getApi().getOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions);
    }

    public final long getClientId() {
        return this.clientId;
    }

    public final String getCodeChallenge() {
        return this.codeChallenge;
    }

    public final String getCodeChallengeMethod() {
        return this.codeChallengeMethod;
    }

    public final String getInternalReferrer() {
        return this.internalReferrer;
    }

    public final String getPermissions() {
        return this.permissions;
    }

    public final String getPrompt() {
        return this.prompt;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        int iA = b.a(this.clientId) * 31;
        String str = this.state;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.responseType;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.redirectUrl;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.prompt;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.scope;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.permissions;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.codeChallenge;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.codeChallengeMethod;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.internalReferrer;
        return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
    }

    public final boolean isUnsupported() {
        return getHasBotPermission();
    }

    public final Observable<RestAPIParams$OAuth2Authorize$ResponsePost> post(String captchaKey, String captchaRqtoken) {
        return RestAPI.Companion.getApi().postOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions, this.codeChallenge, this.codeChallengeMethod, h0.plus(h0.plus(g0.mapOf(o.to("authorize", "true")), captchaKey != null ? g0.mapOf(o.to(CaptchaHelper.CAPTCHA_KEY, captchaKey)) : h0.emptyMap()), captchaRqtoken != null ? g0.mapOf(o.to("captcha_rqtoken", captchaRqtoken)) : h0.emptyMap()));
    }

    public String toString() {
        StringBuilder sbU = a.U("OAuth2Authorize(clientId=");
        sbU.append(this.clientId);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", responseType=");
        sbU.append(this.responseType);
        sbU.append(", redirectUrl=");
        sbU.append(this.redirectUrl);
        sbU.append(", prompt=");
        sbU.append(this.prompt);
        sbU.append(", scope=");
        sbU.append(this.scope);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", codeChallenge=");
        sbU.append(this.codeChallenge);
        sbU.append(", codeChallengeMethod=");
        sbU.append(this.codeChallengeMethod);
        sbU.append(", internalReferrer=");
        return a.J(sbU, this.internalReferrer, ")");
    }

    public /* synthetic */ WidgetOauth2Authorize$OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? "consent" : str4, str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
    }
}
