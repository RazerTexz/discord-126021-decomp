package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScope$MessagesRead;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetOauthAuthorizeBinding;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponseGet;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews$InvalidScopeException;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.c0.c;
import d0.g;
import d0.g0.w;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetOauth2Authorize.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetOauth2Authorize extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetOauth2Authorize.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", 0)};
    public static final WidgetOauth2Authorize$Companion Companion = new WidgetOauth2Authorize$Companion(null);
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
    private final SimpleRecyclerAdapter<WidgetOauth2Authorize$PermissionModel, WidgetOauth2Authorize$OAuthPermissionViewHolder> adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* JADX INFO: renamed from: oauth2ViewModel$delegate, reason: from kotlin metadata */
    private final Lazy oauth2ViewModel;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    public WidgetOauth2Authorize() {
        super(R$layout.widget_oauth_authorize);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetOauth2Authorize$binding$2.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetAuthCaptcha.Companion.registerForResult(this, new WidgetOauth2Authorize$captchaLauncher$1(this));
        WidgetOauth2Authorize$oauth2ViewModel$2 widgetOauth2Authorize$oauth2ViewModel$2 = WidgetOauth2Authorize$oauth2ViewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.oauth2ViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetOauth2Authorize$OAuth2ViewModel.class), new WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetOauth2Authorize$oauth2ViewModel$2));
        this.validationManager = g.lazy(new WidgetOauth2Authorize$validationManager$2(this));
        this.adapter = new SimpleRecyclerAdapter<>(null, WidgetOauth2Authorize$adapter$1.INSTANCE, 1, null);
    }

    public static final /* synthetic */ void access$authorizeApplication(WidgetOauth2Authorize widgetOauth2Authorize, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetOauth2Authorize.authorizeApplication(captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ ValidationManager access$getValidationManager$p(WidgetOauth2Authorize widgetOauth2Authorize) {
        return widgetOauth2Authorize.getValidationManager();
    }

    private final void authorizeApplication(CaptchaHelper$CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), getClass(), (Context) null, (Function1) null, new WidgetOauth2Authorize$authorizeApplication$1(this), (Function0) null, (Function0) null, new WidgetOauth2Authorize$authorizeApplication$2(this), 54, (Object) null);
    }

    private final void configureAgeNoticeUI(long clientId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(clientId));
        TextView textView = getBinding().f2506b;
        m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeAgeNotice");
        b.n(textView, 2131893472, new Object[]{DateUtils.formatDateTime(requireContext(), snowflake, 65536)}, null, 4);
    }

    private final void configureNotSupportedUI(Uri uri) {
        LinearLayout linearLayout = getBinding().j;
        m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(8);
        getBinding().n.setOnClickListener(new WidgetOauth2Authorize$configureNotSupportedUI$1(this, uri));
    }

    private final void configureSecurityNoticeUI(List<String> scopeNames) {
        int i = scopeNames.contains(OAuthScope$MessagesRead.INSTANCE.getScopeName()) ? 2131893468 : 2131893469;
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeSecurityNotice");
        b.m(textView, i, new Object[0], new WidgetOauth2Authorize$configureSecurityNoticeUI$1(this));
    }

    public static /* synthetic */ void getCaptchaLauncher$annotations() {
    }

    private final int getRandomFakeScopeText() {
        switch (c.k.nextInt(8)) {
            case 0:
                return 2131893480;
            case 1:
                return 2131893481;
            case 2:
                return 2131893482;
            case 3:
                return 2131893483;
            case 4:
                return 2131893484;
            case 5:
                return 2131893485;
            case 6:
                return 2131893486;
            default:
                return 2131893487;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void onUnknownScope(OAuthPermissionViews$InvalidScopeException e) {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("invalid scope ");
        sbU.append(e.getScope());
        sbU.append(" in ");
        sbU.append(getClass().getSimpleName());
        Logger.e$default(appLog, sbU.toString(), e, null, 4, null);
        b.a.d.m.h(requireContext(), b.h(requireContext(), 2131893490, new Object[]{e.getScope()}, null, 4), 1, null, 8);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(0);
            appActivity.finish();
        }
    }

    public void configureUI(RestAPIParams$OAuth2Authorize$ResponseGet data) {
        m.checkNotNullParameter(data, "data");
        LinearLayout linearLayout = getBinding().j;
        m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(0);
        User user = data.getUser();
        SimpleDraweeView simpleDraweeView = getBinding().p;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthAuthorizeUserIcon");
        Long lValueOf = Long.valueOf(user.getId());
        NullSerializable<String> nullSerializableA = user.a();
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, null, false, null, 28, null), 0, 0, false, null, null, 124, null);
        Application application = data.getApplication();
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeApplicationName");
        textView.setText(application.getName());
        TextView textView2 = getBinding().k;
        m.checkNotNullExpressionValue(textView2, "binding.oauthAuthorizePermissionsLabelTv");
        b.n(textView2, 2131893493, new Object[]{application.getName()}, null, 4);
        SimpleDraweeView simpleDraweeView2 = getBinding().c;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.oauthAuthorizeApplicationIcon");
        String icon = application.getIcon();
        MGImages.setImage$default(simpleDraweeView2, icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        try {
            List listSplit$default = w.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                Objects.requireNonNull(OAuthScopeTypeAdapter.Companion);
                arrayList2.add(new WidgetOauth2Authorize$PermissionModel((OAuthScope) OAuthScopeTypeAdapter.a().get(str), null));
            }
            List mutableList = u.toMutableList((Collection) arrayList2);
            this.adapter.setData(u.plus((Collection) mutableList, (Iterable) (mutableList.isEmpty() ^ true ? d0.t.m.listOf(new WidgetOauth2Authorize$PermissionModel(null, Integer.valueOf(getRandomFakeScopeText()))) : n.emptyList())));
            getBinding().g.setOnClickListener(new WidgetOauth2Authorize$configureUI$3(this));
        } catch (OAuthPermissionViews$InvalidScopeException e) {
            onUnknownScope(e);
        }
    }

    public WidgetOauth2Authorize$OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        m.checkNotNullParameter(requestUrl, "requestUrl");
        return WidgetOauth2Authorize$Companion.access$createOauthAuthorize(Companion, requestUrl);
    }

    public final WidgetOauthAuthorizeBinding getBinding() {
        return (WidgetOauthAuthorizeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    public final WidgetOauth2Authorize$OAuth2ViewModel getOauth2ViewModel() {
        return (WidgetOauth2Authorize$OAuth2ViewModel) this.oauth2ViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().l;
        m.checkNotNullExpressionValue(recyclerView, "binding.oauthAuthorizePermissionsList");
        recyclerView.setAdapter(this.adapter);
        Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        try {
            WidgetOauth2Authorize$OAuth2ViewModel oauth2ViewModel = getOauth2ViewModel();
            m.checkNotNullExpressionValue(uri, "requestUrl");
            oauth2ViewModel.setOauthAuthorize(createOauthAuthorize(uri));
            Iterator it = n.listOf((Object[]) new MaterialButton[]{getBinding().f, getBinding().i, getBinding().o}).iterator();
            while (it.hasNext()) {
                ((MaterialButton) it.next()).setOnClickListener(new WidgetOauth2Authorize$onViewBound$$inlined$forEach$lambda$1(this));
            }
            AppFragment.setOnBackPressed$default(this, new WidgetOauth2Authorize$onViewBound$3(this), 0, 2, null);
            configureAgeNoticeUI(getOauth2ViewModel().getOauthAuthorize().getClientId());
            configureSecurityNoticeUI(w.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null));
            StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), Companion.getNoticeName(getOauth2ViewModel().getOauthAuthorize().getClientId()), 0L, 2, null);
        } catch (IllegalArgumentException e) {
            WidgetOauth2Authorize$Companion.access$handleError(Companion, requireContext(), e, new WidgetOauth2Authorize$onViewBound$1(this));
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
                m.checkNotNullExpressionValue(uri, "requestUrl");
                configureNotSupportedUI(uri);
                return;
            }
            RestAPIParams$OAuth2Authorize$ResponseGet oauthGetResponse = getOauth2ViewModel().getOauthGetResponse();
            if (oauthGetResponse != null) {
                configureUI(oauthGetResponse);
                return;
            }
            LinearLayout linearLayout = getBinding().j;
            m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().e;
            m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeContent");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = getBinding().h;
            m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeLoading");
            linearLayout3.setVisibility(0);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().get(), false, 1, null), this, null, 2, null), getClass(), requireContext(), (Function1) null, new WidgetOauth2Authorize$onViewBoundOrOnResume$1(this), (Function0) null, (Function0) null, new WidgetOauth2Authorize$onViewBoundOrOnResume$2(this), 52, (Object) null);
        }
    }
}
