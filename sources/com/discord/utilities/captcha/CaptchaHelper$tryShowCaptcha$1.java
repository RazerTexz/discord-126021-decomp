package com.discord.utilities.captcha;

import android.app.Activity;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import b.j.a.a;
import b.j.a.c;
import com.discord.stores.StoreStream;
import com.google.android.gms.common.GoogleApiAvailability;
import com.hcaptcha.sdk.HCaptcha$1;
import com.hcaptcha.sdk.HCaptchaConfig;
import com.hcaptcha.sdk.HCaptchaConfig$a;
import com.hcaptcha.sdk.HCaptchaSize;
import com.hcaptcha.sdk.HCaptchaTheme;
import d0.z.d.m;
import java.util.Objects;
import rx.Emitter;
import rx.functions.Action1;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$tryShowCaptcha$1<T> implements Action1<Emitter<String>> {
    public final /* synthetic */ CaptchaHelper$CaptchaRequest $captchaRequest;

    public CaptchaHelper$tryShowCaptcha$1(CaptchaHelper$CaptchaRequest captchaHelper$CaptchaRequest) {
        this.$captchaRequest = captchaHelper$CaptchaRequest;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Emitter<String> emitter) throws PackageManager$NameNotFoundException {
        call2(emitter);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Emitter<String> emitter) throws PackageManager$NameNotFoundException {
        CaptchaHelper$tryShowCaptcha$1$errorHandler$1 captchaHelper$tryShowCaptcha$1$errorHandler$1 = new CaptchaHelper$tryShowCaptcha$1$errorHandler$1(emitter);
        CaptchaHelper$CaptchaRequest captchaHelper$CaptchaRequest = this.$captchaRequest;
        if (!(captchaHelper$CaptchaRequest instanceof CaptchaHelper$CaptchaRequest$HCaptcha)) {
            if (captchaHelper$CaptchaRequest instanceof CaptchaHelper$CaptchaRequest$ReCaptcha) {
                Activity activity = ((CaptchaHelper$CaptchaRequest$ReCaptcha) captchaHelper$CaptchaRequest).getActivity();
                CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
                Object obj = GoogleApiAvailability.c;
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.d;
                m.checkNotNullExpressionValue(googleApiAvailability, "GoogleApiAvailability\n              .getInstance()");
                CaptchaHelper.access$ensurePlayServicesAvailable(captchaHelper, googleApiAvailability, activity, new CaptchaHelper$tryShowCaptcha$1$3(activity, emitter, captchaHelper$tryShowCaptcha$1$errorHandler$1), captchaHelper$tryShowCaptcha$1$errorHandler$1);
                return;
            }
            return;
        }
        Activity activity2 = ((CaptchaHelper$CaptchaRequest$HCaptcha) captchaHelper$CaptchaRequest).getActivity();
        HCaptchaConfig$a hCaptchaConfig$aBuilder = HCaptchaConfig.builder();
        String siteKey = ((CaptchaHelper$CaptchaRequest$HCaptcha) this.$captchaRequest).getSiteKey();
        Objects.requireNonNull(hCaptchaConfig$aBuilder);
        Objects.requireNonNull(siteKey, "siteKey is marked non-null but is null");
        hCaptchaConfig$aBuilder.a = siteKey;
        hCaptchaConfig$aBuilder.n = StoreStream.Companion.getUserSettingsSystem().getLocale();
        hCaptchaConfig$aBuilder.m = true;
        if (((CaptchaHelper$CaptchaRequest$HCaptcha) this.$captchaRequest).getRqdata() != null) {
            hCaptchaConfig$aBuilder.f = ((CaptchaHelper$CaptchaRequest$HCaptcha) this.$captchaRequest).getRqdata();
        }
        Boolean boolAccess$000 = hCaptchaConfig$aBuilder.c;
        if (!hCaptchaConfig$aBuilder.f3141b) {
            boolAccess$000 = HCaptchaConfig.access$000();
        }
        Boolean bool = boolAccess$000;
        Boolean boolAccess$100 = hCaptchaConfig$aBuilder.e;
        if (!hCaptchaConfig$aBuilder.d) {
            boolAccess$100 = HCaptchaConfig.access$100();
        }
        Boolean bool2 = boolAccess$100;
        String strAccess$200 = hCaptchaConfig$aBuilder.h;
        if (!hCaptchaConfig$aBuilder.g) {
            strAccess$200 = HCaptchaConfig.access$200();
        }
        String str = strAccess$200;
        String strAccess$300 = hCaptchaConfig$aBuilder.n;
        if (!hCaptchaConfig$aBuilder.m) {
            strAccess$300 = HCaptchaConfig.access$300();
        }
        String str2 = strAccess$300;
        HCaptchaSize hCaptchaSizeAccess$400 = hCaptchaConfig$aBuilder.p;
        if (!hCaptchaConfig$aBuilder.o) {
            hCaptchaSizeAccess$400 = HCaptchaConfig.access$400();
        }
        HCaptchaSize hCaptchaSize = hCaptchaSizeAccess$400;
        HCaptchaTheme hCaptchaThemeAccess$500 = hCaptchaConfig$aBuilder.r;
        if (!hCaptchaConfig$aBuilder.q) {
            hCaptchaThemeAccess$500 = HCaptchaConfig.access$500();
        }
        HCaptchaConfig hCaptchaConfig = new HCaptchaConfig(hCaptchaConfig$aBuilder.a, bool, bool2, hCaptchaConfig$aBuilder.f, str, hCaptchaConfig$aBuilder.i, hCaptchaConfig$aBuilder.j, hCaptchaConfig$aBuilder.k, hCaptchaConfig$aBuilder.l, str2, hCaptchaSize, hCaptchaThemeAccess$500);
        a aVar = new a(activity2);
        HCaptcha$1 hCaptcha$1 = new HCaptcha$1(aVar);
        String str3 = c.j;
        Bundle bundle = new Bundle();
        bundle.putSerializable("hCaptchaConfig", hCaptchaConfig);
        bundle.putParcelable("hCaptchaDialogListener", hCaptcha$1);
        c cVar = new c();
        cVar.setArguments(bundle);
        cVar.show(aVar.e, c.j);
        aVar.c.add(new CaptchaHelper$tryShowCaptcha$1$1(emitter));
        aVar.a();
        aVar.d.add(new CaptchaHelper$tryShowCaptcha$1$2(emitter, captchaHelper$tryShowCaptcha$1$errorHandler$1));
        aVar.a();
    }
}
