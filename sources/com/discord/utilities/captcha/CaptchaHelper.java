package com.discord.utilities.captcha;

import android.app.Activity;
import android.content.pm.PackageManager$NameNotFoundException;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentManager;
import b.i.a.f.e.h.c;
import b.i.a.f.e.h.j.d;
import b.i.a.f.e.k.k;
import b.i.a.f.e.k.k$b;
import b.i.a.f.e.k.s;
import b.i.a.f.e.k.v;
import b.i.a.f.h.o.i;
import b.i.a.f.h.o.j;
import b.i.a.f.k.a;
import b.i.a.f.n.c0;
import b.i.a.f.n.g;
import com.discord.app.AppActivity;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi$RecaptchaTokenResponse;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import d0.z.d.m;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Emitter$BackpressureMode;
import rx.Observable;

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

    private CaptchaHelper() {
    }

    public static final /* synthetic */ void access$ensurePlayServicesAvailable(CaptchaHelper captchaHelper, GoogleApiAvailability googleApiAvailability, Activity activity, Function0 function0, Function1 function1) throws PackageManager$NameNotFoundException {
        captchaHelper.ensurePlayServicesAvailable(googleApiAvailability, activity, function0, function1);
    }

    public static final /* synthetic */ void access$showCaptcha(CaptchaHelper captchaHelper, SafetyNetClient safetyNetClient, Function1 function1, Function1 function2) {
        captchaHelper.showCaptcha(safetyNetClient, function1, function2);
    }

    private final void ensurePlayServicesAvailable(GoogleApiAvailability googleApiAvailability, Activity activity, Function0<Unit> function0, Function1<? super CaptchaHelper$Failure, Unit> function1) throws PackageManager$NameNotFoundException {
        int iC = googleApiAvailability.c(activity);
        if (iC == 0 || !googleApiAvailability.d(iC)) {
            if (iC == 0) {
                function0.invoke();
                return;
            } else {
                function1.invoke(new CaptchaHelper$Failure(2131887457, FAILED_DEVICE_UNSUPPORTED));
                return;
            }
        }
        Task<Void> taskE = googleApiAvailability.e(activity);
        CaptchaHelper$ensurePlayServicesAvailable$1 captchaHelper$ensurePlayServicesAvailable$1 = new CaptchaHelper$ensurePlayServicesAvailable$1(function0);
        c0 c0Var = (c0) taskE;
        Objects.requireNonNull(c0Var);
        Executor executor = g.a;
        c0Var.g(executor, captchaHelper$ensurePlayServicesAvailable$1);
        c0Var.e(executor, new CaptchaHelper$ensurePlayServicesAvailable$2(function1));
        m.checkNotNullExpressionValue(c0Var, "makeGooglePlayServicesAv…ISSING_DEPS))\n          }");
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    private final void showCaptcha(SafetyNetClient safetyNetClient, Function1<? super String, Unit> function1, Function1<? super CaptchaHelper$Failure, Unit> function2) {
        Objects.requireNonNull(safetyNetClient);
        SafetyNetApi safetyNetApi = a.d;
        c cVar = safetyNetClient.g;
        Objects.requireNonNull((i) safetyNetApi);
        if (TextUtils.isEmpty(RECAPTCHA_SITE_KEY)) {
            throw new IllegalArgumentException("Null or empty site key in verifyWithRecaptcha");
        }
        d dVarA = cVar.a(new j(cVar, RECAPTCHA_SITE_KEY));
        v vVar = new v(new SafetyNetApi$RecaptchaTokenResponse());
        k$b k_b = k.a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        dVarA.c(new s(dVarA, taskCompletionSource, vVar, k_b));
        c0<TResult> c0Var = taskCompletionSource.a;
        CaptchaHelper$showCaptcha$1 captchaHelper$showCaptcha$1 = new CaptchaHelper$showCaptcha$1(function1);
        Objects.requireNonNull(c0Var);
        Executor executor = g.a;
        c0Var.g(executor, captchaHelper$showCaptcha$1);
        c0Var.e(executor, new CaptchaHelper$showCaptcha$2(function2));
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
        WidgetNoticeDialog$Builder negativeButton$default = WidgetNoticeDialog$Builder.setNegativeButton$default(new WidgetNoticeDialog$Builder(activity).setTitle(2131887460).setMessage(2131887461).setPositiveButton(2131887459, new CaptchaHelper$showCaptchaHelpDialog$$inlined$let$lambda$1(activity, onOpenBrowser)), 2131887437, (Function1) null, 2, (Object) null);
        m.checkNotNullExpressionValue(supportFragmentManager, "it");
        negativeButton$default.show(supportFragmentManager);
    }

    public final Observable<String> tryShowCaptcha(CaptchaHelper$CaptchaRequest captchaRequest) {
        m.checkNotNullParameter(captchaRequest, "captchaRequest");
        Observable<String> observableO = Observable.o(new CaptchaHelper$tryShowCaptcha$1(captchaRequest), Emitter$BackpressureMode.BUFFER);
        m.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.BUFFER)");
        return observableO;
    }
}
