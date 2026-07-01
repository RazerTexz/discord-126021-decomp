package com.discord.utilities.analytics;

import android.app.Application;
import com.adjust.sdk.Adjust;
import d0.z.d.m;

/* JADX INFO: compiled from: AdjustConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdjustConfig {
    private static final String ADJUST_APP_TOKEN = "d8fcx8xdmrr4";
    public static final AdjustConfig INSTANCE = new AdjustConfig();
    private static final String ADJUST_ENVIRONMENT = "production";

    private AdjustConfig() {
    }

    public final void init(Application application, boolean isUnderTest) {
        m.checkNotNullParameter(application, "application");
        if (isUnderTest) {
            return;
        }
        com.adjust.sdk.AdjustConfig adjustConfig = new com.adjust.sdk.AdjustConfig(application, ADJUST_APP_TOKEN, ADJUST_ENVIRONMENT);
        adjustConfig.setOnAttributionChangedListener(AdjustConfig$init$1$1.INSTANCE);
        Adjust.onCreate(adjustConfig);
        Adjust.getGoogleAdId(application, AdjustConfig$init$2.INSTANCE);
        InstallReferrer.Companion.init(new AdjustConfig$init$3(application));
        application.registerActivityLifecycleCallbacks(new AdjustConfig$AdjustLifecycleListener());
    }
}
