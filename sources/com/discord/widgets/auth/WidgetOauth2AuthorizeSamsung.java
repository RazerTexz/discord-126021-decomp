package com.discord.widgets.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.view.PointerIconCompat;
import b.a.d.AppToast;
import b.a.r.SamsungConnect;
import b.a.r.SamsungConnect2;
import b.a.r.SamsungConnectActivity2;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.samsung.SamsungConnect3;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
import d0.Result3;
import d0.g0.Strings4;
import d0.g0._Strings;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.OkHttpClient;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import s.a.CoroutineScope2;
import s.a.Dispatchers;
import s.a.MainCoroutineDispatcher;
import s.a.a.MainDispatchers;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung extends WidgetOauth2Authorize {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQ_CODE_SAMSUNG = 5459;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private String samsungAuthCode;
    private final ActivityResultLauncher<Intent> samsungConnectLauncher;
    private final ActivityResultLauncher<Intent> samsungDisclaimerLauncher;

    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String createSAStateId() {
            StringBuilder sbU = outline.U("SA");
            sbU.append(UUID.randomUUID());
            return _Strings.take(sbU.toString(), 115);
        }

        private final void logI(String message) {
            AppLog appLog = AppLog.g;
            appLog.c(message, "Samsung", null, new WidgetOauth2AuthorizeSamsung2(appLog));
        }

        private final void logW(String message, Throwable throwable) {
            AppLog appLog = AppLog.g;
            appLog.c(message, "Samsung", throwable, new WidgetOauth2AuthorizeSamsung3(appLog));
        }

        public static /* synthetic */ void logW$default(Companion companion, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            companion.logW(str, th);
        }

        public final Observable<Void> getForSamsung(WidgetOauth2Authorize.OAuth2Authorize oAuth2Authorize, String str) {
            Intrinsics3.checkNotNullParameter(oAuth2Authorize, "$this$getForSamsung");
            Intrinsics3.checkNotNullParameter(str, "accountUri");
            return RestAPI.INSTANCE.getApi().getOauth2SamsungAuthorize(String.valueOf(oAuth2Authorize.getClientId()), oAuth2Authorize.getState(), oAuth2Authorize.getResponseType(), str, oAuth2Authorize.getPrompt(), oAuth2Authorize.getScope());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
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
            WidgetOauth2AuthorizeSamsung.INSTANCE.logI("POST /authorize: error " + error);
            String bodyText = error.getBodyText();
            if (bodyText == null || !Strings4.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) {
                return;
            }
            WidgetAuthCaptcha.INSTANCE.launch(WidgetOauth2AuthorizeSamsung.this.requireContext(), WidgetOauth2AuthorizeSamsung.this.getCaptchaLauncher(), CaptchaErrorBody.INSTANCE.createFromError(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
        @DebugMetadata(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1", f = "WidgetOauth2AuthorizeSamsung.kt", l = {157}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ RestAPIParams.OAuth2Authorize.ResponsePost $it;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestAPIParams.OAuth2Authorize.ResponsePost responsePost, Continuation continuation) {
                super(2, continuation);
                this.$it = responsePost;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass2.this.new AnonymousClass1(this.$it, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung = WidgetOauth2AuthorizeSamsung.this;
                    String location = this.$it.getLocation();
                    String str = AnonymousClass2.this.$samsungAuthCode;
                    this.label = 1;
                    if (widgetOauth2AuthorizeSamsung.samsungCallbackHandshake(location, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            invoke2(responsePost);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            Intrinsics3.checkNotNullParameter(responsePost, "it");
            WidgetOauth2AuthorizeSamsung.INSTANCE.logI("POST /authorize success");
            f.H0(CoroutineScope2.j, Dispatchers.f3842b, null, new AnonymousClass1(responsePost, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @DebugMetadata(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung", f = "WidgetOauth2AuthorizeSamsung.kt", l = {Opcodes.RETURN, Opcodes.NEWARRAY, Opcodes.CHECKCAST}, m = "samsungCallbackHandshake")
    public static final class AnonymousClass1 extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WidgetOauth2AuthorizeSamsung.this.samsungCallbackHandshake(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @DebugMetadata(c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2", f = "WidgetOauth2AuthorizeSamsung.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return WidgetOauth2AuthorizeSamsung.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            AppToast.i(WidgetOauth2AuthorizeSamsung.this, R.string.authorized, 0, 4);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity == null) {
                return null;
            }
            appActivity.finish();
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
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
            WidgetOauth2AuthorizeSamsung.INSTANCE.logI("GET /authorize: error " + error);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetOauth2AuthorizeSamsung.this.authorizeForSamsung(this.$samsungAuthCode, null);
        }
    }

    public WidgetOauth2AuthorizeSamsung() {
        WidgetOauth2AuthorizeSamsung5 widgetOauth2AuthorizeSamsung5 = new WidgetOauth2AuthorizeSamsung5(this);
        Intrinsics3.checkNotNullParameter(this, "fragment");
        Intrinsics3.checkNotNullParameter(widgetOauth2AuthorizeSamsung5, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new SamsungConnectActivity2(widgetOauth2AuthorizeSamsung5));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        this.samsungConnectLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(ActivityResult activityResult) {
                Bundle extras;
                Bundle extras2;
                Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                if (activityResult.getResultCode() == -1) {
                    SamsungConnectActivity.b(this.this$0.requireContext(), this.this$0.samsungConnectLauncher, 5459);
                    return;
                }
                Intent data = activityResult.getData();
                Object obj = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.get("error_message");
                Intent data2 = activityResult.getData();
                Object obj2 = (data2 == null || (extras = data2.getExtras()) == null) ? null : extras.get("error_code");
                WidgetOauth2AuthorizeSamsung.Companion.logW$default(WidgetOauth2AuthorizeSamsung.INSTANCE, "Connection requires disclaimer acceptance. [" + obj2 + "] " + obj, null, 2, null);
                AppToast.i(this.this$0, R.string.failed, 0, 4);
                AppActivity appActivity = this.this$0.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
        });
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…inish()\n        }\n      }");
        this.samsungDisclaimerLauncher = activityResultLauncherRegisterForActivityResult2;
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2AuthorizeSamsung4(this));
    }

    private final void authorizeForSamsung(String samsungAuthCode, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), (Class<?>) WidgetOauth2AuthorizeSamsung.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(samsungAuthCode));
    }

    private final void handleConnectActivityFailure(SamsungConnectActivity.Result.Failure result) {
        if (!result.isRetryAllowed || result.attemptCount >= 2) {
            return;
        }
        Companion.logW$default(INSTANCE, "Retrying SA connection.\nBecause sometimes it just doesn't bind the first time.", null, 2, null);
        SamsungConnectActivity.b(requireContext(), this.samsungConnectLauncher, result.attemptCount);
    }

    private final void handleConnectActivitySuccess(SamsungConnectActivity.Result.Success result) {
        String str = result.authCode;
        this.samsungAuthCode = str;
        startSamsungAccountLink(result.serverUrl, str);
    }

    private final void startSamsungAccountLink(String saUrl, String samsungAuthCode) {
        String str;
        Intrinsics3.checkNotNullParameter(saUrl, "authServerUrl");
        String strTake = _Strings.take(saUrl, 2);
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
        Companion companion = INSTANCE;
        companion.logI("GET /authorize " + str);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(companion.getForSamsung(getOauth2ViewModel().getOauthAuthorize(), str), false, 1, null), this, null, 2, null), (Class<?>) WidgetOauth2AuthorizeSamsung.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(samsungAuthCode));
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.configureUI(data);
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                Intrinsics3.checkNotNullParameter(context, "context");
                Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
                Intrinsics3.checkNotNullExpressionValue(accountsByType, "accountManager.getAccoun…yType(SA_ACCOUNT_SERVICE)");
                if (!(!(accountsByType.length == 0))) {
                    WidgetOauth2AuthorizeSamsung.INSTANCE.logI("Not Logged into Samsung Account");
                }
                try {
                    ActivityResultLauncher activityResultLauncher = WidgetOauth2AuthorizeSamsung.this.samsungDisclaimerLauncher;
                    Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_NEW_THIRD_PARTY_INTEGRATION_WITH_SAMSUNG_ACCOUNT");
                    intent.putExtra("client_id", "97t47j218f");
                    intent.putExtra("progress_theme", ModelUserSettings.THEME_DARK);
                    activityResultLauncher.launch(intent);
                } catch (ActivityNotFoundException unused) {
                    AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
                    if (appActivity != null) {
                        appActivity.finish();
                    }
                }
            }
        });
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public WidgetOauth2Authorize.OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        Intrinsics3.checkNotNullParameter(requestUrl, "requestUrl");
        WidgetOauth2Authorize.OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize = super.createOauthAuthorize(requestUrl);
        String state = oAuth2AuthorizeCreateOauthAuthorize.getState();
        if (state == null) {
            state = INSTANCE.createSAStateId();
        }
        return oAuth2AuthorizeCreateOauthAuthorize.copy((PointerIconCompat.TYPE_ALL_SCROLL & 1) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.clientId : 0L, (PointerIconCompat.TYPE_ALL_SCROLL & 2) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.state : state, (PointerIconCompat.TYPE_ALL_SCROLL & 4) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.responseType : null, (PointerIconCompat.TYPE_ALL_SCROLL & 8) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.redirectUrl : "https://discord.com/api/v6/oauth2/samsung/authorize/callback", (PointerIconCompat.TYPE_ALL_SCROLL & 16) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.prompt : null, (PointerIconCompat.TYPE_ALL_SCROLL & 32) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.scope : null, (PointerIconCompat.TYPE_ALL_SCROLL & 64) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.permissions : null, (PointerIconCompat.TYPE_ALL_SCROLL & 128) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.codeChallenge : null, (PointerIconCompat.TYPE_ALL_SCROLL & 256) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.codeChallengeMethod : null, (PointerIconCompat.TYPE_ALL_SCROLL & 512) != 0 ? oAuth2AuthorizeCreateOauthAuthorize.internalReferrer : null);
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0106 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object samsungCallbackHandshake(String str, String str2, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        String str3;
        OkHttpClient okHttpClient;
        WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung;
        String queryParameter;
        MainCoroutineDispatcher mainCoroutineDispatcher;
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objC1 = anonymousClass1.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                OkHttpClient okHttpClient2 = (OkHttpClient) anonymousClass1.L$2;
                String str4 = (String) anonymousClass1.L$1;
                WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung2 = (WidgetOauth2AuthorizeSamsung) anonymousClass1.L$0;
                Result3.throwOnFailure(objC1);
                okHttpClient = okHttpClient2;
                str3 = str4;
                widgetOauth2AuthorizeSamsung = widgetOauth2AuthorizeSamsung2;
            } else if (i2 == 2) {
                widgetOauth2AuthorizeSamsung = (WidgetOauth2AuthorizeSamsung) anonymousClass1.L$0;
                Result3.throwOnFailure(objC1);
                INSTANCE.logI("POST /callback success " + ((Uri) objC1));
                CoroutineDispatcher coroutineDispatcher = Dispatchers.a;
                mainCoroutineDispatcher = MainDispatchers.f3830b;
                anonymousClass2 = widgetOauth2AuthorizeSamsung.new AnonymousClass2(null);
                anonymousClass1.L$0 = null;
                anonymousClass1.label = 3;
                if (f.C1(mainCoroutineDispatcher, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(objC1);
            }
            return Unit.a;
        }
        Result3.throwOnFailure(objC1);
        OkHttpClient.a aVar = new OkHttpClient.a();
        aVar.h = false;
        OkHttpClient okHttpClient3 = new OkHttpClient(aVar);
        INSTANCE.logI("GET /callback");
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = str2;
        anonymousClass1.L$2 = okHttpClient3;
        anonymousClass1.label = 1;
        Object objC2 = f.C1(Dispatchers.f3842b, new SamsungConnect(str, okHttpClient3, null), anonymousClass1);
        if (objC2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str2;
        okHttpClient = okHttpClient3;
        objC1 = objC2;
        widgetOauth2AuthorizeSamsung = this;
        Uri uri = (Uri) objC1;
        if (uri == null || (queryParameter = uri.getQueryParameter("redirect_uri")) == null) {
            throw new SamsungConnect3("no_redirect_uri", "no redirect uri returned from GET/callback");
        }
        Intrinsics3.checkNotNullExpressionValue(queryParameter, "getCallbackUri?.getQuery…m GET/callback\"\n        )");
        INSTANCE.logI("POST /callback " + queryParameter);
        String state = widgetOauth2AuthorizeSamsung.getOauth2ViewModel().getOauthAuthorize().getState();
        Intrinsics3.checkNotNull(state);
        anonymousClass1.L$0 = widgetOauth2AuthorizeSamsung;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.label = 2;
        objC1 = f.C1(Dispatchers.f3842b, new SamsungConnect2(state, str3, queryParameter, okHttpClient, null), anonymousClass1);
        if (objC1 == coroutine_suspended) {
            return coroutine_suspended;
        }
        INSTANCE.logI("POST /callback success " + ((Uri) objC1));
        CoroutineDispatcher coroutineDispatcher2 = Dispatchers.a;
        mainCoroutineDispatcher = MainDispatchers.f3830b;
        anonymousClass2 = widgetOauth2AuthorizeSamsung.new AnonymousClass2(null);
        anonymousClass1.L$0 = null;
        anonymousClass1.label = 3;
        if (f.C1(mainCoroutineDispatcher, anonymousClass2, anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.a;
    }
}
