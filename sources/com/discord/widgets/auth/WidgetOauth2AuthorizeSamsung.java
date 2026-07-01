package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.core.view.PointerIconCompat;
import b.a.r.a;
import b.a.r.b;
import b.a.r.c;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams$OAuth2Authorize$ResponseGet;
import com.discord.samsung.SamsungConnect$SamsungCallbackException;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.samsung.SamsungConnectActivity$Result$Failure;
import com.discord.samsung.SamsungConnectActivity$Result$Success;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.y;
import d0.l;
import d0.z.d.m;
import f0.x;
import f0.x$a;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.n;
import s.a.k0;
import s.a.l1;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung extends WidgetOauth2Authorize {
    public static final WidgetOauth2AuthorizeSamsung$Companion Companion = new WidgetOauth2AuthorizeSamsung$Companion(null);
    private static final int REQ_CODE_SAMSUNG = 5459;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private String samsungAuthCode;
    private final ActivityResultLauncher<Intent> samsungConnectLauncher;
    private final ActivityResultLauncher<Intent> samsungDisclaimerLauncher;

    public WidgetOauth2AuthorizeSamsung() {
        WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1 widgetOauth2AuthorizeSamsung$samsungConnectLauncher$1 = new WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1(this);
        m.checkNotNullParameter(this, "fragment");
        m.checkNotNullParameter(widgetOauth2AuthorizeSamsung$samsungConnectLauncher$1, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new c(widgetOauth2AuthorizeSamsung$samsungConnectLauncher$1));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        this.samsungConnectLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1(this));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…inish()\n        }\n      }");
        this.samsungDisclaimerLauncher = activityResultLauncherRegisterForActivityResult2;
        this.captchaLauncher = WidgetAuthCaptcha.Companion.registerForResult(this, new WidgetOauth2AuthorizeSamsung$captchaLauncher$1(this));
    }

    public static final /* synthetic */ void access$authorizeForSamsung(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetOauth2AuthorizeSamsung.authorizeForSamsung(str, captchaHelper$CaptchaPayload);
    }

    public static final /* synthetic */ String access$getSamsungAuthCode$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungAuthCode;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getSamsungConnectLauncher$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungConnectLauncher;
    }

    public static final /* synthetic */ ActivityResultLauncher access$getSamsungDisclaimerLauncher$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        return widgetOauth2AuthorizeSamsung.samsungDisclaimerLauncher;
    }

    public static final /* synthetic */ void access$handleConnectActivityFailure(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, SamsungConnectActivity$Result$Failure samsungConnectActivity$Result$Failure) {
        widgetOauth2AuthorizeSamsung.handleConnectActivityFailure(samsungConnectActivity$Result$Failure);
    }

    public static final /* synthetic */ void access$handleConnectActivitySuccess(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, SamsungConnectActivity$Result$Success samsungConnectActivity$Result$Success) {
        widgetOauth2AuthorizeSamsung.handleConnectActivitySuccess(samsungConnectActivity$Result$Success);
    }

    public static final /* synthetic */ void access$setSamsungAuthCode$p(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung, String str) {
        widgetOauth2AuthorizeSamsung.samsungAuthCode = str;
    }

    private final void authorizeForSamsung(String samsungAuthCode, CaptchaHelper$CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), WidgetOauth2AuthorizeSamsung.class, (Context) null, (Function1) null, new WidgetOauth2AuthorizeSamsung$authorizeForSamsung$1(this), (Function0) null, (Function0) null, new WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2(this, samsungAuthCode), 54, (Object) null);
    }

    private final void handleConnectActivityFailure(SamsungConnectActivity$Result$Failure result) {
        if (!result.isRetryAllowed || result.attemptCount >= 2) {
            return;
        }
        WidgetOauth2AuthorizeSamsung$Companion.logW$default(Companion, "Retrying SA connection.\nBecause sometimes it just doesn't bind the first time.", null, 2, null);
        SamsungConnectActivity.b(requireContext(), this.samsungConnectLauncher, result.attemptCount);
    }

    private final void handleConnectActivitySuccess(SamsungConnectActivity$Result$Success result) {
        String str = result.authCode;
        this.samsungAuthCode = str;
        startSamsungAccountLink(result.serverUrl, str);
    }

    private final void startSamsungAccountLink(String saUrl, String samsungAuthCode) {
        String str;
        m.checkNotNullParameter(saUrl, "authServerUrl");
        String strTake = y.take(saUrl, 2);
        int iHashCode = strTake.hashCode();
        if (iHashCode != 3179) {
            if (iHashCode == 3248) {
                strTake.equals("eu");
            } else if (iHashCode == 3742 && strTake.equals("us")) {
                str = "https://us.account.samsung.com";
            }
        } else {
            str = strTake.equals("cn") ? "https://account.samsung.cn" : "https://account.samsung.com";
        }
        WidgetOauth2AuthorizeSamsung$Companion widgetOauth2AuthorizeSamsung$Companion = Companion;
        WidgetOauth2AuthorizeSamsung$Companion.access$logI(widgetOauth2AuthorizeSamsung$Companion, "GET /authorize " + str);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(widgetOauth2AuthorizeSamsung$Companion.getForSamsung(getOauth2ViewModel().getOauthAuthorize(), str), false, 1, null), this, null, 2, null), WidgetOauth2AuthorizeSamsung.class, requireContext(), (Function1) null, new WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1(this), (Function0) null, (Function0) null, new WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2(this, samsungAuthCode), 52, (Object) null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public void configureUI(RestAPIParams$OAuth2Authorize$ResponseGet data) {
        m.checkNotNullParameter(data, "data");
        super.configureUI(data);
        getBinding().g.setOnClickListener(new WidgetOauth2AuthorizeSamsung$configureUI$1(this));
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public WidgetOauth2Authorize$OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        m.checkNotNullParameter(requestUrl, "requestUrl");
        WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize = super.createOauthAuthorize(requestUrl);
        String state = widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize.getState();
        if (state == null) {
            state = WidgetOauth2AuthorizeSamsung$Companion.access$createSAStateId(Companion);
        }
        return WidgetOauth2Authorize$OAuth2Authorize.copy$default(widgetOauth2Authorize$OAuth2AuthorizeCreateOauthAuthorize, 0L, state, null, "https://discord.com/api/v6/oauth2/samsung/authorize/callback", null, null, null, null, null, null, PointerIconCompat.TYPE_ALL_SCROLL, null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0106 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object samsungCallbackHandshake(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1;
        String str3;
        x xVar;
        WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung;
        String queryParameter;
        l1 l1Var;
        WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2 widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2;
        if (continuation instanceof WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1) {
            widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 = (WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1) continuation;
            int i = widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label = i - Integer.MIN_VALUE;
            } else {
                widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 = new WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1(this, continuation);
            }
        } else {
            widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 = new WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1(this, continuation);
        }
        Object objC1 = widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                x xVar2 = (x) widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$2;
                String str4 = (String) widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$1;
                WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung2 = (WidgetOauth2AuthorizeSamsung) widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$0;
                l.throwOnFailure(objC1);
                xVar = xVar2;
                str3 = str4;
                widgetOauth2AuthorizeSamsung = widgetOauth2AuthorizeSamsung2;
            } else if (i2 == 2) {
                widgetOauth2AuthorizeSamsung = (WidgetOauth2AuthorizeSamsung) widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$0;
                l.throwOnFailure(objC1);
                WidgetOauth2AuthorizeSamsung$Companion.access$logI(Companion, "POST /callback success " + ((Uri) objC1));
                CoroutineDispatcher coroutineDispatcher = k0.a;
                l1Var = n.f3830b;
                widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2 = new WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2(widgetOauth2AuthorizeSamsung, null);
                widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$0 = null;
                widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label = 3;
                if (f.C1(l1Var, widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2, widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(objC1);
            }
            return Unit.a;
        }
        l.throwOnFailure(objC1);
        x$a x_a = new x$a();
        x_a.h = false;
        x xVar3 = new x(x_a);
        WidgetOauth2AuthorizeSamsung$Companion.access$logI(Companion, "GET /callback");
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$0 = this;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$1 = str2;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$2 = xVar3;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label = 1;
        Object objC2 = f.C1(k0.f3842b, new a(str, xVar3, null), widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1);
        if (objC2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str2;
        xVar = xVar3;
        objC1 = objC2;
        widgetOauth2AuthorizeSamsung = this;
        Uri uri = (Uri) objC1;
        if (uri == null || (queryParameter = uri.getQueryParameter("redirect_uri")) == null) {
            throw new SamsungConnect$SamsungCallbackException("no_redirect_uri", "no redirect uri returned from GET/callback");
        }
        m.checkNotNullExpressionValue(queryParameter, "getCallbackUri?.getQuery…m GET/callback\"\n        )");
        WidgetOauth2AuthorizeSamsung$Companion.access$logI(Companion, "POST /callback " + queryParameter);
        String state = widgetOauth2AuthorizeSamsung.getOauth2ViewModel().getOauthAuthorize().getState();
        m.checkNotNull(state);
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$0 = widgetOauth2AuthorizeSamsung;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$1 = null;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$2 = null;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label = 2;
        objC1 = f.C1(k0.f3842b, new b(state, str3, queryParameter, xVar, null), widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1);
        if (objC1 == coroutine_suspended) {
            return coroutine_suspended;
        }
        WidgetOauth2AuthorizeSamsung$Companion.access$logI(Companion, "POST /callback success " + ((Uri) objC1));
        CoroutineDispatcher coroutineDispatcher2 = k0.a;
        l1Var = n.f3830b;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2 = new WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2(widgetOauth2AuthorizeSamsung, null);
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.L$0 = null;
        widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1.label = 3;
        if (f.C1(l1Var, widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2, widgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.a;
    }
}
