package com.discord.utilities.surveys;

import android.app.Application;
import android.content.pm.PackageManager;
import com.discord.api.user.UserSurvey;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: compiled from: SurveyUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SurveyUtils {
    public static final SurveyUtils INSTANCE = new SurveyUtils();
    private static final long MIN_APP_INSTALL_TIME = 604800000;
    private static Application applicationContext;

    /* JADX INFO: compiled from: SurveyUtils.kt */
    public static class Survey {
        private final String noticeKey;
        private final String surveyBody;
        private final String surveyId;
        private final String surveyTitle;
        private final String surveyURL;

        /* JADX INFO: compiled from: SurveyUtils.kt */
        public static final class None extends Survey {
            public static final None INSTANCE = new None();

            private None() {
                super("", "", "", "", "");
            }
        }

        public Survey(String str, String str2, String str3, String str4, String str5) {
            C12238m.checkNotNullParameter(str, "surveyId");
            C12238m.checkNotNullParameter(str2, "surveyURL");
            C12238m.checkNotNullParameter(str3, "noticeKey");
            C12238m.checkNotNullParameter(str4, "surveyBody");
            C12238m.checkNotNullParameter(str5, "surveyTitle");
            this.surveyId = str;
            this.surveyURL = str2;
            this.noticeKey = str3;
            this.surveyBody = str4;
            this.surveyTitle = str5;
        }

        public String getNoticeKey() {
            return this.noticeKey;
        }

        public String getSurveyBody() {
            return this.surveyBody;
        }

        public String getSurveyId() {
            return this.surveyId;
        }

        public String getSurveyTitle() {
            return this.surveyTitle;
        }

        public String getSurveyURL() {
            return this.surveyURL;
        }
    }

    private SurveyUtils() {
    }

    private final boolean isInstallOldEnough() {
        try {
            Application application = applicationContext;
            if (application == null) {
                C12238m.throwUninitializedPropertyAccessException("applicationContext");
            }
            PackageManager packageManager = application.getPackageManager();
            Application application2 = applicationContext;
            if (application2 == null) {
                C12238m.throwUninitializedPropertyAccessException("applicationContext");
            }
            return ClockFactory.get().currentTimeMillis() - packageManager.getPackageInfo(application2.getPackageName(), 0).firstInstallTime >= MIN_APP_INSTALL_TIME;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final Observable<Survey> getSurveyToShow() {
        if (isInstallOldEnough()) {
            Observable observableM11083G = StoreStream.INSTANCE.getUserSurvey().observeUserSurvey().m11083G(new InterfaceC12589b<UserSurvey, Survey>() { // from class: com.discord.utilities.surveys.SurveyUtils.getSurveyToShow.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Survey call(UserSurvey userSurvey) {
                    if (userSurvey != null) {
                        return new Survey(userSurvey.getKey(), userSurvey.getUrl(), userSurvey.getKey(), userSurvey.getPrompt(), userSurvey.getCta());
                    }
                    return null;
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get…  )\n          }\n        }");
            return observableM11083G;
        }
        C12721k c12721k = new C12721k(Survey.None.INSTANCE);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(Survey.None)");
        return c12721k;
    }

    public final void init(Application applicationContext2) {
        C12238m.checkNotNullParameter(applicationContext2, "applicationContext");
        applicationContext = applicationContext2;
    }
}
