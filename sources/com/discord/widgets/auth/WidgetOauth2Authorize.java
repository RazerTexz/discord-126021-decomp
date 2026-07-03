package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.databinding.WidgetOauthAuthorizeBinding;
import com.discord.i18n.RenderContext;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetOauth2Authorize extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetOauth2Authorize.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_PARAM_URI = "REQ_URI";
    private static final String QUERY_INTERNAL_REFERRER = "internal_referrer";
    private static final String QUERY_PARAM_CLIENT_ID = "client_id";
    private static final String QUERY_PARAM_CODE_CHALLENGE = "code_challenge";
    private static final String QUERY_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    private static final String QUERY_PARAM_PERMISSIONS = "permissions";
    private static final String QUERY_PARAM_REDIRECT = "redirect_uri";
    private static final String QUERY_PARAM_RESPONSE_TYPE = "response_type";
    private static final String QUERY_PARAM_SCOPE = "scope";
    private static final String QUERY_PARAM_STATE = "state";
    private static final String ROOT_ERROR_KEY = "_root";
    private final SimpleRecyclerAdapter<PermissionModel, OAuthPermissionViewHolder> adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* JADX INFO: renamed from: oauth2ViewModel$delegate, reason: from kotlin metadata */
    private final Lazy oauth2ViewModel;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Intent createLaunchIntent(Uri requestUri, OAuth2Authorize oAuth2Authorize) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetOauth2Authorize.INTENT_PARAM_URI, requestUri);
            String internalReferrer = oAuth2Authorize.getInternalReferrer();
            if ((internalReferrer == null || !Boolean.parseBoolean(internalReferrer)) && !oAuth2Authorize.isUnsupported()) {
                intent.addFlags(268468224);
            }
            return intent;
        }

        private final OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
            WidgetOauth2Authorize$Companion$createOauthAuthorize$1 widgetOauth2Authorize$Companion$createOauthAuthorize$1 = WidgetOauth2Authorize$Companion$createOauthAuthorize$1.INSTANCE;
            long j = Long.parseLong(widgetOauth2Authorize$Companion$createOauthAuthorize$1.invoke(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_CLIENT_ID));
            String queryParameter = requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_REDIRECT);
            return new OAuth2Authorize(j, requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_STATE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_RESPONSE_TYPE), queryParameter, null, widgetOauth2Authorize$Companion$createOauthAuthorize$1.invoke(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_SCOPE), requestUrl.getQueryParameter("permissions"), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE_METHOD), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_INTERNAL_REFERRER), 16, null);
        }

        private final void handleError(Context context, Exception e, Function0<Unit> onComplete) {
            String string = C1107b.m210b(context, C5419R.string.oauth2_request_missing_param, new Object[]{e.getMessage()}, (4 & 4) != 0 ? C1107b.b.f1491j : null).toString();
            AppLog.f14950g.mo8370w(string, e);
            C0876m.m170h(context, string, 1, null, 8);
            onComplete.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleError$default(Companion companion, Context context, Exception exc, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = WidgetOauth2Authorize$Companion$handleError$1.INSTANCE;
            }
            companion.handleError(context, exc, function0);
        }

        public final String getNoticeName(long clientId) {
            return C1643a.m877t("OAUTH_REQUEST:", clientId);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0048  */
        public final void launch(Context context, Uri requestUri) {
            OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize;
            boolean z2;
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(requestUri, "requestUri");
            try {
                oAuth2AuthorizeCreateOauthAuthorize = createOauthAuthorize(requestUri);
            } catch (Exception e) {
                handleError$default(this, context, e, null, 4, null);
                oAuth2AuthorizeCreateOauthAuthorize = null;
            }
            if (oAuth2AuthorizeCreateOauthAuthorize != null) {
                long clientId = oAuth2AuthorizeCreateOauthAuthorize.getClientId();
                AnalyticsTracker.INSTANCE.oauth2AuthorizedViewed(clientId);
                if (C12238m.areEqual(String.valueOf(clientId), "591317049637339146")) {
                    z2 = Build.VERSION.SDK_INT >= 28 && C12103t.equals(Build.MANUFACTURER, "samsung", true);
                }
                C0870j.m156d(context, z2 ? WidgetOauth2AuthorizeSamsung.class : WidgetOauth2Authorize.class, createLaunchIntent(requestUri, oAuth2AuthorizeCreateOauthAuthorize));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final /* data */ class OAuth2Authorize {
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

        public OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            C12238m.checkNotNullParameter(str4, "prompt");
            C12238m.checkNotNullParameter(str5, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
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

        private final boolean getHasBotPermission() {
            List<String> listSplit$default = C12106w.split$default((CharSequence) this.scope, new String[]{" "}, false, 0, 6, (Object) null);
            if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
                return false;
            }
            for (String str : listSplit$default) {
                if (C12103t.equals(str, OAuthScope.Bot.INSTANCE.getScopeName(), true) || C12103t.equals(str, OAuthScope.WebhookIncoming.INSTANCE.getScopeName(), true)) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ Observable post$default(OAuth2Authorize oAuth2Authorize, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return oAuth2Authorize.post(str, str2);
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

        public final OAuth2Authorize copy(long clientId, String state, String responseType, String redirectUrl, String prompt, String scope, String permissions, String codeChallenge, String codeChallengeMethod, String internalReferrer) {
            C12238m.checkNotNullParameter(prompt, "prompt");
            C12238m.checkNotNullParameter(scope, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
            return new OAuth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, internalReferrer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuth2Authorize)) {
                return false;
            }
            OAuth2Authorize oAuth2Authorize = (OAuth2Authorize) other;
            return this.clientId == oAuth2Authorize.clientId && C12238m.areEqual(this.state, oAuth2Authorize.state) && C12238m.areEqual(this.responseType, oAuth2Authorize.responseType) && C12238m.areEqual(this.redirectUrl, oAuth2Authorize.redirectUrl) && C12238m.areEqual(this.prompt, oAuth2Authorize.prompt) && C12238m.areEqual(this.scope, oAuth2Authorize.scope) && C12238m.areEqual(this.permissions, oAuth2Authorize.permissions) && C12238m.areEqual(this.codeChallenge, oAuth2Authorize.codeChallenge) && C12238m.areEqual(this.codeChallengeMethod, oAuth2Authorize.codeChallengeMethod) && C12238m.areEqual(this.internalReferrer, oAuth2Authorize.internalReferrer);
        }

        public final Observable<RestAPIParams.OAuth2Authorize.ResponseGet> get() {
            return RestAPI.INSTANCE.getApi().getOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions);
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
            int iM3a = C0002b.m3a(this.clientId) * 31;
            String str = this.state;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
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

        public final Observable<RestAPIParams.OAuth2Authorize.ResponsePost> post(String captchaKey, String captchaRqtoken) {
            return RestAPI.INSTANCE.getApi().postOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions, this.codeChallenge, this.codeChallengeMethod, C12136h0.plus(C12136h0.plus(C12134g0.mapOf(C12116o.m10073to("authorize", "true")), captchaKey != null ? C12134g0.mapOf(C12116o.m10073to(CaptchaHelper.CAPTCHA_KEY, captchaKey)) : C12136h0.emptyMap()), captchaRqtoken != null ? C12134g0.mapOf(C12116o.m10073to("captcha_rqtoken", captchaRqtoken)) : C12136h0.emptyMap()));
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("OAuth2Authorize(clientId=");
            sbM833U.append(this.clientId);
            sbM833U.append(", state=");
            sbM833U.append(this.state);
            sbM833U.append(", responseType=");
            sbM833U.append(this.responseType);
            sbM833U.append(", redirectUrl=");
            sbM833U.append(this.redirectUrl);
            sbM833U.append(", prompt=");
            sbM833U.append(this.prompt);
            sbM833U.append(", scope=");
            sbM833U.append(this.scope);
            sbM833U.append(", permissions=");
            sbM833U.append(this.permissions);
            sbM833U.append(", codeChallenge=");
            sbM833U.append(this.codeChallenge);
            sbM833U.append(", codeChallengeMethod=");
            sbM833U.append(this.codeChallengeMethod);
            sbM833U.append(", internalReferrer=");
            return C1643a.m822J(sbM833U, this.internalReferrer, ")");
        }

        public /* synthetic */ OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? "consent" : str4, str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
        }
    }

    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class OAuth2ViewModel extends AbstractC0859d0<Unit> {
        public OAuth2Authorize oauthAuthorize;
        private RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse;

        public OAuth2ViewModel() {
            super(null, 1, null);
        }

        public final OAuth2Authorize getOauthAuthorize() {
            OAuth2Authorize oAuth2Authorize = this.oauthAuthorize;
            if (oAuth2Authorize == null) {
                C12238m.throwUninitializedPropertyAccessException("oauthAuthorize");
            }
            return oAuth2Authorize;
        }

        public final RestAPIParams.OAuth2Authorize.ResponseGet getOauthGetResponse() {
            return this.oauthGetResponse;
        }

        public final void setOauthAuthorize(OAuth2Authorize oAuth2Authorize) {
            C12238m.checkNotNullParameter(oAuth2Authorize, "<set-?>");
            this.oauthAuthorize = oAuth2Authorize;
        }

        public final void setOauthGetResponse(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            this.oauthGetResponse = responseGet;
        }
    }

    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class OAuthPermissionViewHolder extends SimpleRecyclerAdapter.ViewHolder<PermissionModel> {
        private final OauthTokenPermissionDetailedListItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public OAuthPermissionViewHolder(OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding) {
            C12238m.checkNotNullParameter(oauthTokenPermissionDetailedListItemBinding, "binding");
            ConstraintLayout constraintLayout = oauthTokenPermissionDetailedListItemBinding.f15201a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.binding = oauthTokenPermissionDetailedListItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(PermissionModel data) {
            C12238m.checkNotNullParameter(data, "data");
            if (data.getScope() != null) {
                this.binding.f15202b.setImageResource(C5419R.drawable.ic_check_circle_green_24dp);
                TextView textView = this.binding.f15203c;
                C12238m.checkNotNullExpressionValue(textView, "binding.oauthTokenPermissionDetailedName");
                OAuthPermissionViews.m8548a(textView, data.getScope());
                return;
            }
            if (data.getFakeText() != null) {
                this.binding.f15202b.setImageResource(C5419R.drawable.ic_close_circle_grey_24dp);
                this.binding.f15203c.setText(data.getFakeText().intValue());
            }
        }
    }

    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class PermissionModel {
        private final Integer fakeText;
        private final OAuthScope scope;

        public PermissionModel(OAuthScope oAuthScope, Integer num) {
            this.scope = oAuthScope;
            this.fakeText = num;
        }

        public final Integer getFakeText() {
            return this.fakeText;
        }

        public final OAuthScope getScope() {
            return this.scope;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$1 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72411 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetOauth2Authorize.this.requireContext();
            ActivityResultLauncher<Intent> captchaLauncher = WidgetOauth2Authorize.this.getCaptchaLauncher();
            ValidationManager validationManager = WidgetOauth2Authorize.this.getValidationManager();
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            C12238m.checkNotNullExpressionValue(messages, "error.response.messages");
            companion.processErrorsForCaptcha(contextRequireContext, captchaLauncher, C12163u.toMutableList((Collection) validationManager.setErrors(messages)), error);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$2 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72422 extends AbstractC12240o implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public C72422() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            invoke2(responsePost);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            C12238m.checkNotNullParameter(responsePost, "it");
            Uri uri = Uri.parse(responsePost.getLocation());
            Logger.d$default(AppLog.f14950g, "Redirect OAuth flow to: " + uri, null, 2, null);
            Intent intentAddFlags = new Intent("android.intent.action.VIEW", uri).addFlags(268435456);
            C12238m.checkNotNullExpressionValue(intentAddFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.startActivity(intentAddFlags);
            }
            AppActivity appActivity2 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.setResult(-1);
            }
            AppActivity appActivity3 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity3 != null) {
                appActivity3.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureSecurityNoticeUI$1 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72441 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C72441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetOauth2Authorize.this.requireContext(), C5419R.attr.colorHeaderPrimary));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72461 extends AbstractC12240o implements Function0<Unit> {
        public C72461() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(0);
            }
            AppActivity appActivity2 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72481 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72481() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            C12238m.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            C12238m.checkNotNullExpressionValue(messages, "it");
            if (!(!messages.isEmpty())) {
                messages = null;
            }
            if (messages == null) {
                Error.Response response2 = error.getResponse();
                C12238m.checkNotNullExpressionValue(response2, "error.response");
                messages = C12134g0.mapOf(C12116o.m10073to(WidgetOauth2Authorize.ROOT_ERROR_KEY, C12145m.listOf(response2.getMessage())));
            }
            error.setShowErrorToasts(!WidgetOauth2Authorize.this.getValidationManager().setErrors(messages).isEmpty());
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class C72492 extends AbstractC12240o implements Function1<RestAPIParams.OAuth2Authorize.ResponseGet, Unit> {
        public C72492() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            invoke2(responseGet);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            C12238m.checkNotNullParameter(responseGet, "response");
            WidgetOauth2Authorize.this.getOauth2ViewModel().setOauthGetResponse(responseGet);
            WidgetOauth2Authorize.this.configureUI(responseGet);
        }
    }

    public WidgetOauth2Authorize() {
        super(C5419R.layout.widget_oauth_authorize);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetOauth2Authorize$binding$2.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2Authorize$captchaLauncher$1(this));
        WidgetOauth2Authorize$oauth2ViewModel$2 widgetOauth2Authorize$oauth2ViewModel$2 = WidgetOauth2Authorize$oauth2ViewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.oauth2ViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(OAuth2ViewModel.class), new WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetOauth2Authorize$oauth2ViewModel$2));
        this.validationManager = C12083g.lazy(new WidgetOauth2Authorize$validationManager$2(this));
        this.adapter = new SimpleRecyclerAdapter<>(null, WidgetOauth2Authorize$adapter$1.INSTANCE, 1, null);
    }

    private final void authorizeApplication(CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72411()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72422());
    }

    private final void configureAgeNoticeUI(long clientId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(clientId));
        TextView textView = getBinding().f17330b;
        C12238m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeAgeNotice");
        C1107b.m221m(textView, C5419R.string.oauth2_details_creation_date, new Object[]{DateUtils.formatDateTime(requireContext(), snowflake, 65536)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    private final void configureNotSupportedUI(final Uri uri) {
        LinearLayout linearLayout = getBinding().f17338j;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().f17336h;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().f17333e;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(8);
        getBinding().f17342n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2Authorize.configureNotSupportedUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Exception {
                C0876m.m165c(C1643a.m885x(view, "it", "it.context"), String.valueOf(uri), 0, 4);
                AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        });
    }

    private final void configureSecurityNoticeUI(List<String> scopeNames) {
        int i = scopeNames.contains(OAuthScope.MessagesRead.INSTANCE.getScopeName()) ? C5419R.string.oauth2_can_read_notice : C5419R.string.oauth2_cannot_read_send_notice;
        TextView textView = getBinding().f17341m;
        C12238m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeSecurityNotice");
        C1107b.m221m(textView, i, new Object[0], new C72441());
    }

    public static /* synthetic */ void getCaptchaLauncher$annotations() {
    }

    private final int getRandomFakeScopeText() {
        switch (AbstractC11216c.f22272k.nextInt(8)) {
            case 0:
                return C5419R.string.oauth2_fake_scope_1;
            case 1:
                return C5419R.string.oauth2_fake_scope_2;
            case 2:
                return C5419R.string.oauth2_fake_scope_3;
            case 3:
                return C5419R.string.oauth2_fake_scope_4;
            case 4:
                return C5419R.string.oauth2_fake_scope_5;
            case 5:
                return C5419R.string.oauth2_fake_scope_6;
            case 6:
                return C5419R.string.oauth2_fake_scope_7;
            default:
                return C5419R.string.oauth2_fake_scope_8;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void onUnknownScope(OAuthPermissionViews.InvalidScopeException e) {
        AppLog appLog = AppLog.f14950g;
        StringBuilder sbM833U = C1643a.m833U("invalid scope ");
        sbM833U.append(e.getScope());
        sbM833U.append(" in ");
        sbM833U.append(getClass().getSimpleName());
        Logger.e$default(appLog, sbM833U.toString(), e, null, 4, null);
        C0876m.m170h(requireContext(), C1107b.m210b(requireContext(), C5419R.string.oauth2_request_invalid_scope, new Object[]{e.getScope()}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 1, null, 8);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(0);
            appActivity.finish();
        }
    }

    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        C12238m.checkNotNullParameter(data, "data");
        LinearLayout linearLayout = getBinding().f17338j;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().f17336h;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().f17333e;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(0);
        User user = data.getUser();
        SimpleDraweeView simpleDraweeView = getBinding().f17344p;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthAuthorizeUserIcon");
        Long lValueOf = Long.valueOf(user.getId());
        NullSerializable<String> nullSerializableM8288a = user.m8288a();
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableM8288a != null ? nullSerializableM8288a.mo8429a() : null, null, false, null, 28, null), 0, 0, false, null, null, 124, null);
        Application application = data.getApplication();
        TextView textView = getBinding().f17332d;
        C12238m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeApplicationName");
        textView.setText(application.getName());
        TextView textView2 = getBinding().f17339k;
        C12238m.checkNotNullExpressionValue(textView2, "binding.oauthAuthorizePermissionsLabelTv");
        C1107b.m221m(textView2, C5419R.string.oauth2_scopes_label, new Object[]{application.getName()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        SimpleDraweeView simpleDraweeView2 = getBinding().f17331c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.oauthAuthorizeApplicationIcon");
        String icon = application.getIcon();
        MGImages.setImage$default(simpleDraweeView2, icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        try {
            List listSplit$default = C12106w.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                Objects.requireNonNull(OAuthScopeTypeAdapter.INSTANCE);
                arrayList2.add(new PermissionModel((OAuthScope) OAuthScopeTypeAdapter.nameToScopeMap.get(str), null));
            }
            List mutableList = C12163u.toMutableList((Collection) arrayList2);
            this.adapter.setData(C12163u.plus((Collection) mutableList, (Iterable) (mutableList.isEmpty() ^ true ? C12145m.listOf(new PermissionModel(null, Integer.valueOf(getRandomFakeScopeText()))) : C12147n.emptyList())));
            getBinding().f17335g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2Authorize.configureUI.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetOauth2Authorize.this.authorizeApplication(null);
                }
            });
        } catch (OAuthPermissionViews.InvalidScopeException e) {
            onUnknownScope(e);
        }
    }

    public OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        C12238m.checkNotNullParameter(requestUrl, "requestUrl");
        return INSTANCE.createOauthAuthorize(requestUrl);
    }

    public final WidgetOauthAuthorizeBinding getBinding() {
        return (WidgetOauthAuthorizeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    public final OAuth2ViewModel getOauth2ViewModel() {
        return (OAuth2ViewModel) this.oauth2ViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f17340l;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.oauthAuthorizePermissionsList");
        recyclerView.setAdapter(this.adapter);
        Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        try {
            OAuth2ViewModel oauth2ViewModel = getOauth2ViewModel();
            C12238m.checkNotNullExpressionValue(uri, "requestUrl");
            oauth2ViewModel.setOauthAuthorize(createOauthAuthorize(uri));
            Iterator it = C12147n.listOf((Object[]) new MaterialButton[]{getBinding().f17334f, getBinding().f17337i, getBinding().f17343o}).iterator();
            while (it.hasNext()) {
                ((MaterialButton) it.next()).setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$$inlined$forEach$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) throws Exception {
                        AppActivity appActivity = this.this$0.getAppActivity();
                        if (appActivity != null) {
                            appActivity.onBackPressed();
                        }
                    }
                });
            }
            AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.auth.WidgetOauth2Authorize.onViewBound.3
                @Override // p658rx.functions.Func0, java.util.concurrent.Callable
                public final Boolean call() {
                    AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
                    if (appActivity != null) {
                        appActivity.finishAndRemoveTask();
                    }
                    return Boolean.TRUE;
                }
            }, 0, 2, null);
            configureAgeNoticeUI(getOauth2ViewModel().getOauthAuthorize().getClientId());
            configureSecurityNoticeUI(C12106w.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null));
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), INSTANCE.getNoticeName(getOauth2ViewModel().getOauthAuthorize().getClientId()), 0L, 2, null);
        } catch (IllegalArgumentException e) {
            INSTANCE.handleError(requireContext(), e, new C72461());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || !appActivity.isFinishing()) {
            if (getOauth2ViewModel().getOauthAuthorize().isUnsupported()) {
                Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
                if (uri == null) {
                    uri = Uri.EMPTY;
                }
                C12238m.checkNotNullExpressionValue(uri, "requestUrl");
                configureNotSupportedUI(uri);
                return;
            }
            RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse = getOauth2ViewModel().getOauthGetResponse();
            if (oauthGetResponse != null) {
                configureUI(oauthGetResponse);
                return;
            }
            LinearLayout linearLayout = getBinding().f17338j;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().f17333e;
            C12238m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeContent");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = getBinding().f17336h;
            C12238m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeLoading");
            linearLayout3.setVisibility(0);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().get(), false, 1, null), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72481()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72492());
        }
    }
}
