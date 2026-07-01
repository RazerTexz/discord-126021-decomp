package com.discord.widgets.auth;

import a0.a.a.b;
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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.Tuples;
import d0.c0.Random;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetOauth2Authorize extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetOauth2Authorize.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", 0)};

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
            WidgetOauth2Authorize2 widgetOauth2Authorize2 = WidgetOauth2Authorize2.INSTANCE;
            long j = Long.parseLong(widgetOauth2Authorize2.invoke(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_CLIENT_ID));
            String queryParameter = requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_REDIRECT);
            return new OAuth2Authorize(j, requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_STATE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_RESPONSE_TYPE), queryParameter, null, widgetOauth2Authorize2.invoke(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_SCOPE), requestUrl.getQueryParameter("permissions"), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE_METHOD), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_INTERNAL_REFERRER), 16, null);
        }

        private final void handleError(Context context, Exception e, Function0<Unit> onComplete) {
            String string = FormatUtils.b(context, R.string.oauth2_request_missing_param, new Object[]{e.getMessage()}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString();
            AppLog.g.w(string, e);
            AppToast.h(context, string, 1, null, 8);
            onComplete.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleError$default(Companion companion, Context context, Exception exc, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = WidgetOauth2Authorize3.INSTANCE;
            }
            companion.handleError(context, exc, function0);
        }

        public final String getNoticeName(long clientId) {
            return outline.t("OAUTH_REQUEST:", clientId);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0048  */
        public final void launch(Context context, Uri requestUri) {
            OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize;
            boolean z2;
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(requestUri, "requestUri");
            try {
                oAuth2AuthorizeCreateOauthAuthorize = createOauthAuthorize(requestUri);
            } catch (Exception e) {
                handleError$default(this, context, e, null, 4, null);
                oAuth2AuthorizeCreateOauthAuthorize = null;
            }
            if (oAuth2AuthorizeCreateOauthAuthorize != null) {
                long clientId = oAuth2AuthorizeCreateOauthAuthorize.getClientId();
                AnalyticsTracker.INSTANCE.oauth2AuthorizedViewed(clientId);
                if (Intrinsics3.areEqual(String.valueOf(clientId), "591317049637339146")) {
                    z2 = Build.VERSION.SDK_INT >= 28 && StringsJVM.equals(Build.MANUFACTURER, "samsung", true);
                }
                AppScreen2.d(context, z2 ? WidgetOauth2AuthorizeSamsung.class : WidgetOauth2Authorize.class, createLaunchIntent(requestUri, oAuth2AuthorizeCreateOauthAuthorize));
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
            Intrinsics3.checkNotNullParameter(str4, "prompt");
            Intrinsics3.checkNotNullParameter(str5, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
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
            List<String> listSplit$default = Strings4.split$default((CharSequence) this.scope, new String[]{" "}, false, 0, 6, (Object) null);
            if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
                return false;
            }
            for (String str : listSplit$default) {
                if (StringsJVM.equals(str, OAuthScope.Bot.INSTANCE.getScopeName(), true) || StringsJVM.equals(str, OAuthScope.WebhookIncoming.INSTANCE.getScopeName(), true)) {
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
            Intrinsics3.checkNotNullParameter(prompt, "prompt");
            Intrinsics3.checkNotNullParameter(scope, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
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
            return this.clientId == oAuth2Authorize.clientId && Intrinsics3.areEqual(this.state, oAuth2Authorize.state) && Intrinsics3.areEqual(this.responseType, oAuth2Authorize.responseType) && Intrinsics3.areEqual(this.redirectUrl, oAuth2Authorize.redirectUrl) && Intrinsics3.areEqual(this.prompt, oAuth2Authorize.prompt) && Intrinsics3.areEqual(this.scope, oAuth2Authorize.scope) && Intrinsics3.areEqual(this.permissions, oAuth2Authorize.permissions) && Intrinsics3.areEqual(this.codeChallenge, oAuth2Authorize.codeChallenge) && Intrinsics3.areEqual(this.codeChallengeMethod, oAuth2Authorize.codeChallengeMethod) && Intrinsics3.areEqual(this.internalReferrer, oAuth2Authorize.internalReferrer);
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

        public final Observable<RestAPIParams.OAuth2Authorize.ResponsePost> post(String captchaKey, String captchaRqtoken) {
            return RestAPI.INSTANCE.getApi().postOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions, this.codeChallenge, this.codeChallengeMethod, Maps6.plus(Maps6.plus(MapsJVM.mapOf(Tuples.to("authorize", "true")), captchaKey != null ? MapsJVM.mapOf(Tuples.to(CaptchaHelper.CAPTCHA_KEY, captchaKey)) : Maps6.emptyMap()), captchaRqtoken != null ? MapsJVM.mapOf(Tuples.to("captcha_rqtoken", captchaRqtoken)) : Maps6.emptyMap()));
        }

        public String toString() {
            StringBuilder sbU = outline.U("OAuth2Authorize(clientId=");
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
            return outline.J(sbU, this.internalReferrer, ")");
        }

        public /* synthetic */ OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? "consent" : str4, str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
        }
    }

    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class OAuth2ViewModel extends AppViewModel<Unit> {
        public OAuth2Authorize oauthAuthorize;
        private RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse;

        public OAuth2ViewModel() {
            super(null, 1, null);
        }

        public final OAuth2Authorize getOauthAuthorize() {
            OAuth2Authorize oAuth2Authorize = this.oauthAuthorize;
            if (oAuth2Authorize == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("oauthAuthorize");
            }
            return oAuth2Authorize;
        }

        public final RestAPIParams.OAuth2Authorize.ResponseGet getOauthGetResponse() {
            return this.oauthGetResponse;
        }

        public final void setOauthAuthorize(OAuth2Authorize oAuth2Authorize) {
            Intrinsics3.checkNotNullParameter(oAuth2Authorize, "<set-?>");
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
            Intrinsics3.checkNotNullParameter(oauthTokenPermissionDetailedListItemBinding, "binding");
            ConstraintLayout constraintLayout = oauthTokenPermissionDetailedListItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.binding = oauthTokenPermissionDetailedListItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(PermissionModel data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            if (data.getScope() != null) {
                this.binding.f2133b.setImageResource(R.drawable.ic_check_circle_green_24dp);
                TextView textView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthTokenPermissionDetailedName");
                OAuthPermissionViews.a(textView, data.getScope());
                return;
            }
            if (data.getFakeText() != null) {
                this.binding.f2133b.setImageResource(R.drawable.ic_close_circle_grey_24dp);
                this.binding.c.setText(data.getFakeText().intValue());
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

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetOauth2Authorize.this.requireContext();
            ActivityResultLauncher<Intent> captchaLauncher = WidgetOauth2Authorize.this.getCaptchaLauncher();
            ValidationManager validationManager = WidgetOauth2Authorize.this.getValidationManager();
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
            companion.processErrorsForCaptcha(contextRequireContext, captchaLauncher, _Collections.toMutableList((Collection) validationManager.setErrors(messages)), error);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            invoke2(responsePost);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            Intrinsics3.checkNotNullParameter(responsePost, "it");
            Uri uri = Uri.parse(responsePost.getLocation());
            Logger.d$default(AppLog.g, "Redirect OAuth flow to: " + uri, null, 2, null);
            Intent intentAddFlags = new Intent("android.intent.action.VIEW", uri).addFlags(268435456);
            Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
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

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureSecurityNoticeUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetOauth2Authorize.this.requireContext(), R.attr.colorHeaderPrimary));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            Intrinsics3.checkNotNullExpressionValue(messages, "it");
            if (!(!messages.isEmpty())) {
                messages = null;
            }
            if (messages == null) {
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                messages = MapsJVM.mapOf(Tuples.to(WidgetOauth2Authorize.ROOT_ERROR_KEY, CollectionsJVM.listOf(response2.getMessage())));
            }
            error.setShowErrorToasts(!WidgetOauth2Authorize.this.getValidationManager().setErrors(messages).isEmpty());
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponseGet, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            invoke2(responseGet);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            Intrinsics3.checkNotNullParameter(responseGet, "response");
            WidgetOauth2Authorize.this.getOauth2ViewModel().setOauthGetResponse(responseGet);
            WidgetOauth2Authorize.this.configureUI(responseGet);
        }
    }

    public WidgetOauth2Authorize() {
        super(R.layout.widget_oauth_authorize);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetOauth2Authorize5.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2Authorize6(this));
        WidgetOauth2Authorize7 widgetOauth2Authorize7 = WidgetOauth2Authorize7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.oauth2ViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(OAuth2ViewModel.class), new WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetOauth2Authorize7));
        this.validationManager = LazyJVM.lazy(new WidgetOauth2Authorize9(this));
        this.adapter = new SimpleRecyclerAdapter<>(null, WidgetOauth2Authorize4.INSTANCE, 1, null);
    }

    private final void authorizeApplication(CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    private final void configureAgeNoticeUI(long clientId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(clientId));
        TextView textView = getBinding().f2506b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeAgeNotice");
        FormatUtils.m(textView, R.string.oauth2_details_creation_date, new Object[]{DateUtils.formatDateTime(requireContext(), snowflake, 65536)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    private final void configureNotSupportedUI(final Uri uri) {
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(8);
        getBinding().n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2Authorize.configureNotSupportedUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Exception {
                AppToast.c(outline.x(view, "it", "it.context"), String.valueOf(uri), 0, 4);
                AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        });
    }

    private final void configureSecurityNoticeUI(List<String> scopeNames) {
        int i = scopeNames.contains(OAuthScope.MessagesRead.INSTANCE.getScopeName()) ? R.string.oauth2_can_read_notice : R.string.oauth2_cannot_read_send_notice;
        TextView textView = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeSecurityNotice");
        FormatUtils.m(textView, i, new Object[0], new AnonymousClass1());
    }

    public static /* synthetic */ void getCaptchaLauncher$annotations() {
    }

    private final int getRandomFakeScopeText() {
        switch (Random.k.nextInt(8)) {
            case 0:
                return R.string.oauth2_fake_scope_1;
            case 1:
                return R.string.oauth2_fake_scope_2;
            case 2:
                return R.string.oauth2_fake_scope_3;
            case 3:
                return R.string.oauth2_fake_scope_4;
            case 4:
                return R.string.oauth2_fake_scope_5;
            case 5:
                return R.string.oauth2_fake_scope_6;
            case 6:
                return R.string.oauth2_fake_scope_7;
            default:
                return R.string.oauth2_fake_scope_8;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void onUnknownScope(OAuthPermissionViews.InvalidScopeException e) {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = outline.U("invalid scope ");
        sbU.append(e.getScope());
        sbU.append(" in ");
        sbU.append(getClass().getSimpleName());
        Logger.e$default(appLog, sbU.toString(), e, null, 4, null);
        AppToast.h(requireContext(), FormatUtils.b(requireContext(), R.string.oauth2_request_invalid_scope, new Object[]{e.getScope()}, (4 & 4) != 0 ? FormatUtils.b.j : null), 1, null, 8);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(0);
            appActivity.finish();
        }
    }

    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(0);
        User user = data.getUser();
        SimpleDraweeView simpleDraweeView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthAuthorizeUserIcon");
        Long lValueOf = Long.valueOf(user.getId());
        NullSerializable<String> nullSerializableA = user.a();
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, null, false, null, 28, null), 0, 0, false, null, null, 124, null);
        Application application = data.getApplication();
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeApplicationName");
        textView.setText(application.getName());
        TextView textView2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.oauthAuthorizePermissionsLabelTv");
        FormatUtils.m(textView2, R.string.oauth2_scopes_label, new Object[]{application.getName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        SimpleDraweeView simpleDraweeView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.oauthAuthorizeApplicationIcon");
        String icon = application.getIcon();
        MGImages.setImage$default(simpleDraweeView2, icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        try {
            List listSplit$default = Strings4.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                Objects.requireNonNull(OAuthScopeTypeAdapter.INSTANCE);
                arrayList2.add(new PermissionModel((OAuthScope) OAuthScopeTypeAdapter.nameToScopeMap.get(str), null));
            }
            List mutableList = _Collections.toMutableList((Collection) arrayList2);
            this.adapter.setData(_Collections.plus((Collection) mutableList, (Iterable) (mutableList.isEmpty() ^ true ? CollectionsJVM.listOf(new PermissionModel(null, Integer.valueOf(getRandomFakeScopeText()))) : Collections2.emptyList())));
            getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2Authorize.configureUI.3
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
        Intrinsics3.checkNotNullParameter(requestUrl, "requestUrl");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.oauthAuthorizePermissionsList");
        recyclerView.setAdapter(this.adapter);
        Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        try {
            OAuth2ViewModel oauth2ViewModel = getOauth2ViewModel();
            Intrinsics3.checkNotNullExpressionValue(uri, "requestUrl");
            oauth2ViewModel.setOauthAuthorize(createOauthAuthorize(uri));
            Iterator it = Collections2.listOf((Object[]) new MaterialButton[]{getBinding().f, getBinding().i, getBinding().o}).iterator();
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
                @Override // rx.functions.Func0, java.util.concurrent.Callable
                public final Boolean call() {
                    AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
                    if (appActivity != null) {
                        appActivity.finishAndRemoveTask();
                    }
                    return Boolean.TRUE;
                }
            }, 0, 2, null);
            configureAgeNoticeUI(getOauth2ViewModel().getOauthAuthorize().getClientId());
            configureSecurityNoticeUI(Strings4.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null));
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), INSTANCE.getNoticeName(getOauth2ViewModel().getOauthAuthorize().getClientId()), 0L, 2, null);
        } catch (IllegalArgumentException e) {
            INSTANCE.handleError(requireContext(), e, new AnonymousClass1());
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
                Intrinsics3.checkNotNullExpressionValue(uri, "requestUrl");
                configureNotSupportedUI(uri);
                return;
            }
            RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse = getOauth2ViewModel().getOauthGetResponse();
            if (oauthGetResponse != null) {
                configureUI(oauthGetResponse);
                return;
            }
            LinearLayout linearLayout = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeContent");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeLoading");
            linearLayout3.setVisibility(0);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().get(), false, 1, null), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        }
    }
}
