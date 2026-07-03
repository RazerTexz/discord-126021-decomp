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
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.samsung.SamsungConnect$SamsungCallbackException;
import com.discord.samsung.SamsungConnectActivity;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.auth.WidgetOauth2Authorize;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
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
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p048r.C1269a;
import p007b.p008a.p048r.C1270b;
import p007b.p008a.p048r.C1271c;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.C12108y;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p658rx.Observable;
import p658rx.Subscription;
import p659s.p660a.AbstractC13128l1;
import p659s.p660a.C13124k0;
import p659s.p660a.C13163x0;
import p659s.p660a.p661a.C13031n;

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
            StringBuilder sbM833U = C1643a.m833U("SA");
            sbM833U.append(UUID.randomUUID());
            return C12108y.take(sbM833U.toString(), 115);
        }

        private final void logI(String message) {
            AppLog appLog = AppLog.f14950g;
            appLog.m8360c(message, "Samsung", null, new WidgetOauth2AuthorizeSamsung$Companion$logI$1(appLog));
        }

        private final void logW(String message, Throwable throwable) {
            AppLog appLog = AppLog.f14950g;
            appLog.m8360c(message, "Samsung", throwable, new WidgetOauth2AuthorizeSamsung$Companion$logW$1(appLog));
        }

        public static /* synthetic */ void logW$default(Companion companion, String str, Throwable th, int i, Object obj) {
            if ((i & 2) != 0) {
                th = null;
            }
            companion.logW(str, th);
        }

        public final Observable<Void> getForSamsung(WidgetOauth2Authorize.OAuth2Authorize oAuth2Authorize, String str) {
            C12238m.checkNotNullParameter(oAuth2Authorize, "$this$getForSamsung");
            C12238m.checkNotNullParameter(str, "accountUri");
            return RestAPI.INSTANCE.getApi().getOauth2SamsungAuthorize(String.valueOf(oAuth2Authorize.getClientId()), oAuth2Authorize.getState(), oAuth2Authorize.getResponseType(), str, oAuth2Authorize.getPrompt(), oAuth2Authorize.getScope());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$1 */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class C72521 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72521() {
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
            WidgetOauth2AuthorizeSamsung.INSTANCE.logI("POST /authorize: error " + error);
            String bodyText = error.getBodyText();
            if (bodyText == null || !C12106w.contains$default((CharSequence) bodyText, (CharSequence) CaptchaHelper.CAPTCHA_KEY, false, 2, (Object) null)) {
                return;
            }
            WidgetAuthCaptcha.INSTANCE.launch(WidgetOauth2AuthorizeSamsung.this.requireContext(), WidgetOauth2AuthorizeSamsung.this.getCaptchaLauncher(), CaptchaErrorBody.INSTANCE.createFromError(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2 */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class C72532 extends AbstractC12240o implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
        @InterfaceC12188e(m10084c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$authorizeForSamsung$2$1", m10085f = "WidgetOauth2AuthorizeSamsung.kt", m10086l = {157}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ RestAPIParams.OAuth2Authorize.ResponsePost $it;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(RestAPIParams.OAuth2Authorize.ResponsePost responsePost, Continuation continuation) {
                super(2, continuation);
                this.$it = responsePost;
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C12238m.checkNotNullParameter(continuation, "completion");
                return C72532.this.new AnonymousClass1(this.$it, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    C12113l.throwOnFailure(obj);
                    WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung = WidgetOauth2AuthorizeSamsung.this;
                    String location = this.$it.getLocation();
                    String str = C72532.this.$samsungAuthCode;
                    this.label = 1;
                    if (widgetOauth2AuthorizeSamsung.samsungCallbackHandshake(location, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C12113l.throwOnFailure(obj);
                }
                return Unit.f27425a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C72532(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            invoke2(responsePost);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) {
            C12238m.checkNotNullParameter(responsePost, "it");
            WidgetOauth2AuthorizeSamsung.INSTANCE.logI("POST /authorize success");
            C3404f.m4211H0(C13163x0.f27919j, C13124k0.f27867b, null, new AnonymousClass1(responsePost, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$1 */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung", m10085f = "WidgetOauth2AuthorizeSamsung.kt", m10086l = {Opcodes.RETURN, Opcodes.NEWARRAY, Opcodes.CHECKCAST}, m10087m = "samsungCallbackHandshake")
    public static final class C72551 extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C72551(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return WidgetOauth2AuthorizeSamsung.this.samsungCallbackHandshake(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2 */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungCallbackHandshake$2", m10085f = "WidgetOauth2AuthorizeSamsung.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C72562 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C72562(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return WidgetOauth2AuthorizeSamsung.this.new C72562(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C72562) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            C0876m.m171i(WidgetOauth2AuthorizeSamsung.this, C5419R.string.authorized, 0, 4);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity == null) {
                return null;
            }
            appActivity.finish();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1 */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class C72571 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72571() {
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
            WidgetOauth2AuthorizeSamsung.INSTANCE.logI("GET /authorize: error " + error);
            AppActivity appActivity = WidgetOauth2AuthorizeSamsung.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$2 */
    /* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
    public static final class C72582 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ String $samsungAuthCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C72582(String str) {
            super(1);
            this.$samsungAuthCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r3) {
            WidgetOauth2AuthorizeSamsung.this.authorizeForSamsung(this.$samsungAuthCode, null);
        }
    }

    public WidgetOauth2AuthorizeSamsung() {
        WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1 widgetOauth2AuthorizeSamsung$samsungConnectLauncher$1 = new WidgetOauth2AuthorizeSamsung$samsungConnectLauncher$1(this);
        C12238m.checkNotNullParameter(this, "fragment");
        C12238m.checkNotNullParameter(widgetOauth2AuthorizeSamsung$samsungConnectLauncher$1, "callback");
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1271c(widgetOauth2AuthorizeSamsung$samsungConnectLauncher$1));
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
        this.samsungConnectLauncher = activityResultLauncherRegisterForActivityResult;
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$samsungDisclaimerLauncher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(ActivityResult activityResult) {
                Bundle extras;
                Bundle extras2;
                C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                if (activityResult.getResultCode() == -1) {
                    SamsungConnectActivity.m8504b(this.this$0.requireContext(), this.this$0.samsungConnectLauncher, 5459);
                    return;
                }
                Intent data = activityResult.getData();
                Object obj = (data == null || (extras2 = data.getExtras()) == null) ? null : extras2.get("error_message");
                Intent data2 = activityResult.getData();
                Object obj2 = (data2 == null || (extras = data2.getExtras()) == null) ? null : extras.get("error_code");
                WidgetOauth2AuthorizeSamsung.Companion.logW$default(WidgetOauth2AuthorizeSamsung.INSTANCE, "Connection requires disclaimer acceptance. [" + obj2 + "] " + obj, null, 2, null);
                C0876m.m171i(this.this$0, C5419R.string.failed, 0, 4);
                AppActivity appActivity = this.this$0.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
        });
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult2, "registerForActivityResul…inish()\n        }\n      }");
        this.samsungDisclaimerLauncher = activityResultLauncherRegisterForActivityResult2;
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2AuthorizeSamsung$captchaLauncher$1(this));
    }

    private final void authorizeForSamsung(String samsungAuthCode, CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), (Class<?>) WidgetOauth2AuthorizeSamsung.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72521()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72532(samsungAuthCode));
    }

    private final void handleConnectActivityFailure(SamsungConnectActivity.Result.Failure result) {
        if (!result.isRetryAllowed || result.attemptCount >= 2) {
            return;
        }
        Companion.logW$default(INSTANCE, "Retrying SA connection.\nBecause sometimes it just doesn't bind the first time.", null, 2, null);
        SamsungConnectActivity.m8504b(requireContext(), this.samsungConnectLauncher, result.attemptCount);
    }

    private final void handleConnectActivitySuccess(SamsungConnectActivity.Result.Success result) {
        String str = result.authCode;
        this.samsungAuthCode = str;
        startSamsungAccountLink(result.serverUrl, str);
    }

    private final void startSamsungAccountLink(String saUrl, String samsungAuthCode) {
        String str;
        C12238m.checkNotNullParameter(saUrl, "authServerUrl");
        String strTake = C12108y.take(saUrl, 2);
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(companion.getForSamsung(getOauth2ViewModel().getOauthAuthorize(), str), false, 1, null), this, null, 2, null), (Class<?>) WidgetOauth2AuthorizeSamsung.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72571()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72582(samsungAuthCode));
    }

    @Override // com.discord.widgets.auth.WidgetOauth2Authorize
    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        C12238m.checkNotNullParameter(data, "data");
        super.configureUI(data);
        getBinding().f17335g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                C12238m.checkNotNullParameter(context, "context");
                Account[] accountsByType = AccountManager.get(context).getAccountsByType("com.osp.app.signin");
                C12238m.checkNotNullExpressionValue(accountsByType, "accountManager.getAccoun…yType(SA_ACCOUNT_SERVICE)");
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
        C12238m.checkNotNullParameter(requestUrl, "requestUrl");
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
        C72551 c72551;
        String str3;
        C12380x c12380x;
        WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung;
        String queryParameter;
        AbstractC13128l1 abstractC13128l1;
        C72562 c72562;
        if (continuation instanceof C72551) {
            c72551 = (C72551) continuation;
            int i = c72551.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c72551.label = i - Integer.MIN_VALUE;
            } else {
                c72551 = new C72551(continuation);
            }
        } else {
            c72551 = new C72551(continuation);
        }
        Object objM4197C1 = c72551.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c72551.label;
        if (i2 != 0) {
            if (i2 == 1) {
                C12380x c12380x2 = (C12380x) c72551.L$2;
                String str4 = (String) c72551.L$1;
                WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung2 = (WidgetOauth2AuthorizeSamsung) c72551.L$0;
                C12113l.throwOnFailure(objM4197C1);
                c12380x = c12380x2;
                str3 = str4;
                widgetOauth2AuthorizeSamsung = widgetOauth2AuthorizeSamsung2;
            } else if (i2 == 2) {
                widgetOauth2AuthorizeSamsung = (WidgetOauth2AuthorizeSamsung) c72551.L$0;
                C12113l.throwOnFailure(objM4197C1);
                INSTANCE.logI("POST /callback success " + ((Uri) objM4197C1));
                CoroutineDispatcher coroutineDispatcher = C13124k0.f27866a;
                abstractC13128l1 = C13031n.f27700b;
                c72562 = widgetOauth2AuthorizeSamsung.new C72562(null);
                c72551.L$0 = null;
                c72551.label = 3;
                if (C3404f.m4197C1(abstractC13128l1, c72562, c72551) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(objM4197C1);
            }
            return Unit.f27425a;
        }
        C12113l.throwOnFailure(objM4197C1);
        C12380x.a aVar = new C12380x.a();
        aVar.f26036h = false;
        C12380x c12380x3 = new C12380x(aVar);
        INSTANCE.logI("GET /callback");
        c72551.L$0 = this;
        c72551.L$1 = str2;
        c72551.L$2 = c12380x3;
        c72551.label = 1;
        Object objM4197C2 = C3404f.m4197C1(C13124k0.f27867b, new C1269a(str, c12380x3, null), c72551);
        if (objM4197C2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        str3 = str2;
        c12380x = c12380x3;
        objM4197C1 = objM4197C2;
        widgetOauth2AuthorizeSamsung = this;
        Uri uri = (Uri) objM4197C1;
        if (uri == null || (queryParameter = uri.getQueryParameter("redirect_uri")) == null) {
            throw new SamsungConnect$SamsungCallbackException("no_redirect_uri", "no redirect uri returned from GET/callback");
        }
        C12238m.checkNotNullExpressionValue(queryParameter, "getCallbackUri?.getQuery…m GET/callback\"\n        )");
        INSTANCE.logI("POST /callback " + queryParameter);
        String state = widgetOauth2AuthorizeSamsung.getOauth2ViewModel().getOauthAuthorize().getState();
        C12238m.checkNotNull(state);
        c72551.L$0 = widgetOauth2AuthorizeSamsung;
        c72551.L$1 = null;
        c72551.L$2 = null;
        c72551.label = 2;
        objM4197C1 = C3404f.m4197C1(C13124k0.f27867b, new C1270b(state, str3, queryParameter, c12380x, null), c72551);
        if (objM4197C1 == coroutine_suspended) {
            return coroutine_suspended;
        }
        INSTANCE.logI("POST /callback success " + ((Uri) objM4197C1));
        CoroutineDispatcher coroutineDispatcher2 = C13124k0.f27866a;
        abstractC13128l1 = C13031n.f27700b;
        c72562 = widgetOauth2AuthorizeSamsung.new C72562(null);
        c72551.L$0 = null;
        c72551.label = 3;
        if (C3404f.m4197C1(abstractC13128l1, c72562, c72551) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.f27425a;
    }
}
