package com.discord.utilities.captcha;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.stores.StoreStream;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaDialogListener;
import com.hcaptcha.sdk.HCaptchaError;
import com.hcaptcha.sdk.HCaptchaException;
import com.hcaptcha.sdk.HCaptchaSize;
import com.hcaptcha.sdk.HCaptchaTheme;
import com.hcaptcha.sdk.HCaptchaTokenResponse;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.AbstractC3284d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3363k;
import p007b.p225i.p226a.p288f.p299e.p304k.C3379s;
import p007b.p225i.p226a.p288f.p299e.p304k.C3385v;
import p007b.p225i.p226a.p288f.p313h.p328o.C3962i;
import p007b.p225i.p226a.p288f.p313h.p328o.C3963j;
import p007b.p225i.p226a.p288f.p313h.p328o.C3965l;
import p007b.p225i.p226a.p288f.p336k.C4327a;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4363g;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4359d;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p437j.p438a.C5065a;
import p007b.p437j.p438a.C5067c;
import p007b.p437j.p438a.p439f.InterfaceC5070a;
import p007b.p437j.p438a.p439f.InterfaceC5072c;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper {
    public static final String CAPTCHA_KEY = "captcha_key";
    private static final String FAILED_CAPTCHA_EXPIRED = "expired";
    private static final String FAILED_DEVICE_UNSUPPORTED = "unsupported_device";
    private static final String FAILED_MISSING_DEPS = "missing_dependencies";
    public static final CaptchaHelper INSTANCE = new CaptchaHelper();
    private static final String RECAPTCHA_SITE_KEY = "6Lff5jIUAAAAAImNXvYYPv2VW2En3Dexy4oX2o4s";
    private static String captchaRqtoken;
    private static String captchaToken;

    /* JADX INFO: compiled from: CaptchaHelper.kt */
    public static final /* data */ class CaptchaPayload {
        private final String captchaKey;
        private final String captchaRqtoken;

        public CaptchaPayload(String str, String str2) {
            C12238m.checkNotNullParameter(str, "captchaKey");
            this.captchaKey = str;
            this.captchaRqtoken = str2;
        }

        public static /* synthetic */ CaptchaPayload copy$default(CaptchaPayload captchaPayload, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = captchaPayload.captchaKey;
            }
            if ((i & 2) != 0) {
                str2 = captchaPayload.captchaRqtoken;
            }
            return captchaPayload.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public final CaptchaPayload copy(String captchaKey, String captchaRqtoken) {
            C12238m.checkNotNullParameter(captchaKey, "captchaKey");
            return new CaptchaPayload(captchaKey, captchaRqtoken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CaptchaPayload)) {
                return false;
            }
            CaptchaPayload captchaPayload = (CaptchaPayload) other;
            return C12238m.areEqual(this.captchaKey, captchaPayload.captchaKey) && C12238m.areEqual(this.captchaRqtoken, captchaPayload.captchaRqtoken);
        }

        public final String getCaptchaKey() {
            return this.captchaKey;
        }

        public final String getCaptchaRqtoken() {
            return this.captchaRqtoken;
        }

        public int hashCode() {
            String str = this.captchaKey;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.captchaRqtoken;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CaptchaPayload(captchaKey=");
            sbM833U.append(this.captchaKey);
            sbM833U.append(", captchaRqtoken=");
            return C1643a.m822J(sbM833U, this.captchaRqtoken, ")");
        }

        public /* synthetic */ CaptchaPayload(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }
    }

    /* JADX INFO: compiled from: CaptchaHelper.kt */
    public static abstract class CaptchaRequest {

        /* JADX INFO: compiled from: CaptchaHelper.kt */
        public static final /* data */ class HCaptcha extends CaptchaRequest {
            private final Activity activity;
            private final String rqdata;
            private final String siteKey;

            public /* synthetic */ HCaptcha(String str, Activity activity, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, activity, (i & 4) != 0 ? null : str2);
            }

            public static /* synthetic */ HCaptcha copy$default(HCaptcha hCaptcha, String str, Activity activity, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = hCaptcha.siteKey;
                }
                if ((i & 2) != 0) {
                    activity = hCaptcha.activity;
                }
                if ((i & 4) != 0) {
                    str2 = hCaptcha.rqdata;
                }
                return hCaptcha.copy(str, activity, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSiteKey() {
                return this.siteKey;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getRqdata() {
                return this.rqdata;
            }

            public final HCaptcha copy(String siteKey, Activity activity, String rqdata) {
                C12238m.checkNotNullParameter(siteKey, "siteKey");
                C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                return new HCaptcha(siteKey, activity, rqdata);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HCaptcha)) {
                    return false;
                }
                HCaptcha hCaptcha = (HCaptcha) other;
                return C12238m.areEqual(this.siteKey, hCaptcha.siteKey) && C12238m.areEqual(this.activity, hCaptcha.activity) && C12238m.areEqual(this.rqdata, hCaptcha.rqdata);
            }

            public final Activity getActivity() {
                return this.activity;
            }

            public final String getRqdata() {
                return this.rqdata;
            }

            public final String getSiteKey() {
                return this.siteKey;
            }

            public int hashCode() {
                String str = this.siteKey;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Activity activity = this.activity;
                int iHashCode2 = (iHashCode + (activity != null ? activity.hashCode() : 0)) * 31;
                String str2 = this.rqdata;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("HCaptcha(siteKey=");
                sbM833U.append(this.siteKey);
                sbM833U.append(", activity=");
                sbM833U.append(this.activity);
                sbM833U.append(", rqdata=");
                return C1643a.m822J(sbM833U, this.rqdata, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HCaptcha(String str, Activity activity, String str2) {
                super(null);
                C12238m.checkNotNullParameter(str, "siteKey");
                C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                this.siteKey = str;
                this.activity = activity;
                this.rqdata = str2;
            }
        }

        /* JADX INFO: compiled from: CaptchaHelper.kt */
        public static final /* data */ class ReCaptcha extends CaptchaRequest {
            private final Activity activity;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReCaptcha(Activity activity) {
                super(null);
                C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                this.activity = activity;
            }

            public static /* synthetic */ ReCaptcha copy$default(ReCaptcha reCaptcha, Activity activity, int i, Object obj) {
                if ((i & 1) != 0) {
                    activity = reCaptcha.activity;
                }
                return reCaptcha.copy(activity);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Activity getActivity() {
                return this.activity;
            }

            public final ReCaptcha copy(Activity activity) {
                C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                return new ReCaptcha(activity);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReCaptcha) && C12238m.areEqual(this.activity, ((ReCaptcha) other).activity);
                }
                return true;
            }

            public final Activity getActivity() {
                return this.activity;
            }

            public int hashCode() {
                Activity activity = this.activity;
                if (activity != null) {
                    return activity.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ReCaptcha(activity=");
                sbM833U.append(this.activity);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private CaptchaRequest() {
        }

        public /* synthetic */ CaptchaRequest(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: CaptchaHelper.kt */
    public static final /* data */ class Failure extends Throwable {
        private final int errorStringId;
        private final String reasonCode;

        public Failure(int i, String str) {
            C12238m.checkNotNullParameter(str, "reasonCode");
            this.errorStringId = i;
            this.reasonCode = str;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = failure.errorStringId;
            }
            if ((i2 & 2) != 0) {
                str = failure.reasonCode;
            }
            return failure.copy(i, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getErrorStringId() {
            return this.errorStringId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getReasonCode() {
            return this.reasonCode;
        }

        public final Failure copy(int errorStringId, String reasonCode) {
            C12238m.checkNotNullParameter(reasonCode, "reasonCode");
            return new Failure(errorStringId, reasonCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) other;
            return this.errorStringId == failure.errorStringId && C12238m.areEqual(this.reasonCode, failure.reasonCode);
        }

        public final int getErrorStringId() {
            return this.errorStringId;
        }

        public final String getReasonCode() {
            return this.reasonCode;
        }

        public int hashCode() {
            int i = this.errorStringId * 31;
            String str = this.reasonCode;
            return i + (str != null ? str.hashCode() : 0);
        }

        @Override // java.lang.Throwable
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Failure(errorStringId=");
            sbM833U.append(this.errorStringId);
            sbM833U.append(", reasonCode=");
            return C1643a.m822J(sbM833U, this.reasonCode, ")");
        }
    }

    private CaptchaHelper() {
    }

    private final void ensurePlayServicesAvailable(GoogleApiAvailability googleApiAvailability, Activity activity, final Function0<Unit> function0, final Function1<? super Failure, Unit> function1) throws PackageManager.NameNotFoundException {
        int iM9024c = googleApiAvailability.m9024c(activity);
        if (iM9024c == 0 || !googleApiAvailability.m9025d(iM9024c)) {
            if (iM9024c == 0) {
                function0.invoke();
                return;
            } else {
                function1.invoke(new Failure(C5419R.string.captcha_failed_unsupported, FAILED_DEVICE_UNSUPPORTED));
                return;
            }
        }
        Task<Void> taskM9026e = googleApiAvailability.m9026e(activity);
        InterfaceC4361e<Void> interfaceC4361e = new InterfaceC4361e<Void>() { // from class: com.discord.utilities.captcha.CaptchaHelper.ensurePlayServicesAvailable.1
            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
            public final void onSuccess(Void r1) {
                function0.invoke();
            }
        };
        C4358c0 c4358c0 = (C4358c0) taskM9026e;
        Objects.requireNonNull(c4358c0);
        Executor executor = C4363g.f11479a;
        c4358c0.mo6012g(executor, interfaceC4361e);
        c4358c0.mo6010e(executor, new InterfaceC4359d() { // from class: com.discord.utilities.captcha.CaptchaHelper.ensurePlayServicesAvailable.2
            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
            public final void onFailure(Exception exc) {
                function1.invoke(new Failure(C5419R.string.captcha_failed_play_services, CaptchaHelper.FAILED_MISSING_DEPS));
            }
        });
        C12238m.checkNotNullExpressionValue(c4358c0, "makeGooglePlayServicesAv…ISSING_DEPS))\n          }");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private final void showCaptcha(SafetyNetClient safetyNetClient, final Function1<? super String, Unit> function1, final Function1<? super Failure, Unit> function2) {
        Objects.requireNonNull(safetyNetClient);
        SafetyNetApi safetyNetApi = C4327a.f11446d;
        AbstractC3268c abstractC3268c = safetyNetClient.f9332g;
        Objects.requireNonNull((C3962i) safetyNetApi);
        if (TextUtils.isEmpty(RECAPTCHA_SITE_KEY)) {
            throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
        }
        AbstractC3284d abstractC3284dMo4048a = abstractC3268c.mo4048a(new C3963j(abstractC3268c, RECAPTCHA_SITE_KEY));
        C3385v c3385v = new C3385v(new SafetyNetApi.RecaptchaTokenResponse());
        C3363k.b bVar = C3363k.f9531a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        abstractC3284dMo4048a.mo4051c(new C3379s(abstractC3284dMo4048a, taskCompletionSource, c3385v, bVar));
        C4358c0<TResult> c4358c0 = taskCompletionSource.f20845a;
        InterfaceC4361e<SafetyNetApi.RecaptchaTokenResponse> interfaceC4361e = new InterfaceC4361e<SafetyNetApi.RecaptchaTokenResponse>() { // from class: com.discord.utilities.captcha.CaptchaHelper.showCaptcha.1
            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
            public final void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                C12238m.checkNotNullExpressionValue(recaptchaTokenResponse, "it");
                String strMo5438C = ((SafetyNetApi.InterfaceC10813a) recaptchaTokenResponse.f9340a).mo5438C();
                C12238m.checkNotNullExpressionValue(strMo5438C, "userResponseToken");
                if (strMo5438C.length() == 0) {
                    return;
                }
                function1.invoke("android:" + strMo5438C);
            }
        };
        Objects.requireNonNull(c4358c0);
        Executor executor = C4363g.f11479a;
        c4358c0.mo6012g(executor, interfaceC4361e);
        c4358c0.mo6010e(executor, new InterfaceC4359d() { // from class: com.discord.utilities.captcha.CaptchaHelper.showCaptcha.2
            @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
            public final void onFailure(Exception exc) {
                function2.invoke(new Failure(C5419R.string.captcha_failed, CaptchaHelper.FAILED_CAPTCHA_EXPIRED));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showCaptchaHelpDialog$default(CaptchaHelper captchaHelper, AppActivity appActivity, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        captchaHelper.showCaptchaHelpDialog(appActivity, function0);
    }

    public final String getCaptchaRqtoken() {
        return captchaRqtoken;
    }

    public final String getCaptchaToken() {
        return captchaToken;
    }

    public final void setCaptchaRqtoken(String str) {
        captchaRqtoken = str;
    }

    public final void setCaptchaToken(String str) {
        captchaToken = str;
    }

    public final void showCaptchaHelpDialog(AppActivity activity, Function0<Unit> onOpenBrowser) {
        FragmentManager supportFragmentManager;
        if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
            return;
        }
        WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(activity).setTitle(C5419R.string.captcha_problems).setMessage(C5419R.string.captcha_problems_info).setPositiveButton(C5419R.string.captcha_open_browser, new CaptchaHelper$showCaptchaHelpDialog$$inlined$let$lambda$1(activity, onOpenBrowser)), C5419R.string.cancel, (Function1) null, 2, (Object) null);
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "it");
        negativeButton$default.show(supportFragmentManager);
    }

    public final Observable<String> tryShowCaptcha(final CaptchaRequest captchaRequest) {
        C12238m.checkNotNullParameter(captchaRequest, "captchaRequest");
        Observable<String> observableM11080o = Observable.m11080o(new Action1<Emitter<String>>() { // from class: com.discord.utilities.captcha.CaptchaHelper.tryShowCaptcha.1

            /* JADX INFO: renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: CaptchaHelper.kt */
            public static final class AnonymousClass3 extends AbstractC12240o implements Function0<Unit> {
                public final /* synthetic */ Activity $activity;
                public final /* synthetic */ Emitter $emitter;
                public final /* synthetic */ Function1 $errorHandler;

                /* JADX INFO: renamed from: com.discord.utilities.captcha.CaptchaHelper$tryShowCaptcha$1$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: CaptchaHelper.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function1<String, Unit> {
                    public AnonymousClass1() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.f27425a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str) {
                        C12238m.checkNotNullParameter(str, "token");
                        AnonymousClass3.this.$emitter.onNext(str);
                        AnonymousClass3.this.$emitter.onCompleted();
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(Activity activity, Emitter emitter, Function1 function1) {
                    super(0);
                    this.$activity = activity;
                    this.$emitter = emitter;
                    this.$errorHandler = function1;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
                    Activity activity = this.$activity;
                    C3266a.g<C3965l> gVar = C4327a.f11443a;
                    SafetyNetClient safetyNetClient = new SafetyNetClient(activity);
                    C12238m.checkNotNullExpressionValue(safetyNetClient, "SafetyNet\n              …     .getClient(activity)");
                    captchaHelper.showCaptcha(safetyNetClient, new AnonymousClass1(), this.$errorHandler);
                }
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // p658rx.functions.Action1
            public final void call(final Emitter<String> emitter) throws PackageManager.NameNotFoundException {
                final CaptchaHelper$tryShowCaptcha$1$errorHandler$1 captchaHelper$tryShowCaptcha$1$errorHandler$1 = new CaptchaHelper$tryShowCaptcha$1$errorHandler$1(emitter);
                CaptchaRequest captchaRequest2 = captchaRequest;
                if (!(captchaRequest2 instanceof CaptchaRequest.HCaptcha)) {
                    if (captchaRequest2 instanceof CaptchaRequest.ReCaptcha) {
                        Activity activity = ((CaptchaRequest.ReCaptcha) captchaRequest2).getActivity();
                        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
                        Object obj = GoogleApiAvailability.f20480c;
                        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.f20481d;
                        C12238m.checkNotNullExpressionValue(googleApiAvailability, "GoogleApiAvailability\n              .getInstance()");
                        captchaHelper.ensurePlayServicesAvailable(googleApiAvailability, activity, new AnonymousClass3(activity, emitter, captchaHelper$tryShowCaptcha$1$errorHandler$1), captchaHelper$tryShowCaptcha$1$errorHandler$1);
                        return;
                    }
                    return;
                }
                Activity activity2 = ((CaptchaRequest.HCaptcha) captchaRequest2).getActivity();
                HCaptchaConfig.C11151a c11151aBuilder = HCaptchaConfig.builder();
                String siteKey = ((CaptchaRequest.HCaptcha) captchaRequest).getSiteKey();
                Objects.requireNonNull(c11151aBuilder);
                Objects.requireNonNull(siteKey, "siteKey is marked non-null but is null");
                c11151aBuilder.f21674a = siteKey;
                c11151aBuilder.f21687n = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
                c11151aBuilder.f21686m = true;
                if (((CaptchaRequest.HCaptcha) captchaRequest).getRqdata() != null) {
                    c11151aBuilder.f21679f = ((CaptchaRequest.HCaptcha) captchaRequest).getRqdata();
                }
                Boolean bool = c11151aBuilder.f21676c;
                if (!c11151aBuilder.f21675b) {
                    bool = Boolean.TRUE;
                }
                Boolean bool2 = bool;
                Boolean bool3 = c11151aBuilder.f21678e;
                if (!c11151aBuilder.f21677d) {
                    bool3 = Boolean.TRUE;
                }
                Boolean bool4 = bool3;
                String str$default$apiEndpoint = c11151aBuilder.f21681h;
                if (!c11151aBuilder.f21680g) {
                    str$default$apiEndpoint = HCaptchaConfig.$default$apiEndpoint();
                }
                String str = str$default$apiEndpoint;
                String str$default$locale = c11151aBuilder.f21687n;
                if (!c11151aBuilder.f21686m) {
                    str$default$locale = HCaptchaConfig.$default$locale();
                }
                String str2 = str$default$locale;
                HCaptchaSize hCaptchaSize = c11151aBuilder.f21689p;
                if (!c11151aBuilder.f21688o) {
                    hCaptchaSize = HCaptchaSize.INVISIBLE;
                }
                HCaptchaSize hCaptchaSize2 = hCaptchaSize;
                HCaptchaTheme hCaptchaTheme = c11151aBuilder.f21691r;
                if (!c11151aBuilder.f21690q) {
                    hCaptchaTheme = HCaptchaTheme.LIGHT;
                }
                HCaptchaConfig hCaptchaConfig = new HCaptchaConfig(c11151aBuilder.f21674a, bool2, bool4, c11151aBuilder.f21679f, str, c11151aBuilder.f21682i, c11151aBuilder.f21683j, c11151aBuilder.f21684k, c11151aBuilder.f21685l, str2, hCaptchaSize2, hCaptchaTheme);
                final C5065a c5065a = new C5065a(activity2);
                HCaptchaDialogListener hCaptchaDialogListener = new HCaptchaDialogListener() { // from class: com.hcaptcha.sdk.HCaptcha$1
                    @Override // com.hcaptcha.sdk.HCaptchaDialogListener
                    /* JADX INFO: renamed from: a */
                    public void mo9263a(HCaptchaException hCaptchaException) {
                        C5065a c5065a2 = c5065a;
                        c5065a2.f13595b = hCaptchaException;
                        c5065a2.m7120a();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.hcaptcha.sdk.HCaptchaDialogListener
                    /* JADX INFO: renamed from: b */
                    public void mo9264b(HCaptchaTokenResponse hCaptchaTokenResponse) {
                        C5065a c5065a2 = c5065a;
                        c5065a2.f13594a = hCaptchaTokenResponse;
                        c5065a2.m7120a();
                    }
                };
                String str3 = C5067c.f13582j;
                Bundle bundle = new Bundle();
                bundle.putSerializable("hCaptchaConfig", hCaptchaConfig);
                bundle.putParcelable("hCaptchaDialogListener", hCaptchaDialogListener);
                C5067c c5067c = new C5067c();
                c5067c.setArguments(bundle);
                c5067c.show(c5065a.f13580e, C5067c.f13582j);
                c5065a.f13596c.add((InterfaceC5072c<TResult>) new InterfaceC5072c<HCaptchaTokenResponse>() { // from class: com.discord.utilities.captcha.CaptchaHelper.tryShowCaptcha.1.1
                    @Override // p007b.p437j.p438a.p439f.InterfaceC5072c
                    public final void onSuccess(HCaptchaTokenResponse hCaptchaTokenResponse) {
                        Emitter emitter2 = emitter;
                        C12238m.checkNotNullExpressionValue(hCaptchaTokenResponse, "hCaptchaTokenResponse");
                        emitter2.onNext(hCaptchaTokenResponse.f21692a);
                        emitter.onCompleted();
                    }
                });
                c5065a.m7120a();
                c5065a.f13597d.add(new InterfaceC5070a() { // from class: com.discord.utilities.captcha.CaptchaHelper.tryShowCaptcha.1.2
                    @Override // p007b.p437j.p438a.p439f.InterfaceC5070a
                    public final void onFailure(HCaptchaException hCaptchaException) {
                        C12238m.checkNotNullExpressionValue(hCaptchaException, "hCaptchaException");
                        if (hCaptchaException.m9265a() == HCaptchaError.CHALLENGE_CLOSED) {
                            emitter.onCompleted();
                            return;
                        }
                        String strName = hCaptchaException.m9265a().name();
                        Locale locale = Locale.ROOT;
                        C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
                        String lowerCase = strName.toLowerCase(locale);
                        C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                        captchaHelper$tryShowCaptcha$1$errorHandler$1.invoke(new Failure(C5419R.string.captcha_failed, lowerCase));
                    }
                });
                c5065a.m7120a();
            }
        }, Emitter.BackpressureMode.BUFFER);
        C12238m.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableM11080o;
    }
}
