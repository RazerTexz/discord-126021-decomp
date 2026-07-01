package com.discord.utilities.surveys;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: SurveyUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SurveyUtils {
    public static final SurveyUtils INSTANCE = new SurveyUtils();
    private static final long MIN_APP_INSTALL_TIME = 604800000;
    private static Application applicationContext;

    private SurveyUtils() {
    }

    private final boolean isInstallOldEnough() {
        try {
            Application application = applicationContext;
            if (application == null) {
                m.throwUninitializedPropertyAccessException("applicationContext");
            }
            PackageManager packageManager = application.getPackageManager();
            Application application2 = applicationContext;
            if (application2 == null) {
                m.throwUninitializedPropertyAccessException("applicationContext");
            }
            return ClockFactory.get().currentTimeMillis() - packageManager.getPackageInfo(application2.getPackageName(), 0).firstInstallTime >= MIN_APP_INSTALL_TIME;
        } catch (PackageManager$NameNotFoundException unused) {
            return false;
        }
    }

    public final Observable<SurveyUtils$Survey> getSurveyToShow() {
        if (isInstallOldEnough()) {
            Observable observableG = StoreStream.Companion.getUserSurvey().observeUserSurvey().G(SurveyUtils$getSurveyToShow$1.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…  )\n          }\n        }");
            return observableG;
        }
        k kVar = new k(SurveyUtils$Survey$None.INSTANCE);
        m.checkNotNullExpressionValue(kVar, "Observable.just(Survey.None)");
        return kVar;
    }

    public final void init(Application applicationContext2) {
        m.checkNotNullParameter(applicationContext2, "applicationContext");
        applicationContext = applicationContext2;
    }
}
