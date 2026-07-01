package com.discord.utilities.analytics;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.OnAttributionChangedListener;
import com.adjust.sdk.OnDeviceIdsRead;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AdjustConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdjustConfig {
    private static final String ADJUST_APP_TOKEN = "d8fcx8xdmrr4";
    public static final AdjustConfig INSTANCE = new AdjustConfig();
    private static final String ADJUST_ENVIRONMENT = "production";

    /* JADX INFO: compiled from: AdjustConfig.kt */
    public static final class AdjustLifecycleListener implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Adjust.onPause();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Adjust.onResume();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.analytics.AdjustConfig$init$3, reason: invalid class name */
    /* JADX INFO: compiled from: AdjustConfig.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Application $application;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Application application) {
            super(1);
            this.$application = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "referrerUrl");
            Adjust.setReferrer(str, this.$application);
            AnalyticSuperProperties.INSTANCE.setCampaignProperties(str);
        }
    }

    private AdjustConfig() {
    }

    public final void init(Application application, boolean isUnderTest) {
        Intrinsics3.checkNotNullParameter(application, "application");
        if (isUnderTest) {
            return;
        }
        com.adjust.sdk.AdjustConfig adjustConfig = new com.adjust.sdk.AdjustConfig(application, ADJUST_APP_TOKEN, ADJUST_ENVIRONMENT);
        adjustConfig.setOnAttributionChangedListener(new OnAttributionChangedListener() { // from class: com.discord.utilities.analytics.AdjustConfig$init$1$1
            @Override // com.adjust.sdk.OnAttributionChangedListener
            public final void onAttributionChanged(AdjustAttribution adjustAttribution) {
                if (adjustAttribution != null) {
                    AnalyticsTracker.INSTANCE.attributionChange(adjustAttribution);
                }
            }
        });
        Adjust.onCreate(adjustConfig);
        Adjust.getGoogleAdId(application, new OnDeviceIdsRead() { // from class: com.discord.utilities.analytics.AdjustConfig.init.2
            @Override // com.adjust.sdk.OnDeviceIdsRead
            public final void onGoogleAdIdRead(String str) {
                if (str != null) {
                    AnalyticSuperProperties.INSTANCE.setAdvertiserId(str);
                }
            }
        });
        InstallReferrer.INSTANCE.init(new AnonymousClass3(application));
        application.registerActivityLifecycleCallbacks(new AdjustLifecycleListener());
    }
}
