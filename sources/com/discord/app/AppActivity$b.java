package com.discord.app;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.ShareUtils;
import com.discord.utilities.accessibility.AccessibilityMonitor;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.bugreports.BugReportManager;
import com.discord.utilities.lifecycle.ApplicationProvider;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppActivity$b extends o implements Function0<Unit> {
    public static final AppActivity$b j = new AppActivity$b();

    public AppActivity$b() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (AppActivity.o) {
            AppActivity.o = false;
            AppLog.i("Application activity initialized.");
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            ApplicationProvider applicationProvider = ApplicationProvider.INSTANCE;
            storeStream$Companion.initialize(applicationProvider.get());
            AnalyticsUtils.INSTANCE.initAppOpen(applicationProvider.get());
            AccessibilityMonitor.Companion.initialize(applicationProvider.get());
            ShareUtils.INSTANCE.updateDirectShareTargets(applicationProvider.get());
            GooglePlayBillingManager.INSTANCE.init(applicationProvider.get());
            AppLog appLog = AppLog.g;
            m.checkNotNullParameter(appLog, "logger");
            Application application = applicationProvider.get();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationProvider.get());
            m.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…pplicationProvider.get())");
            ScreenshotDetector.a = new ScreenshotDetector(application, appLog, defaultSharedPreferences);
            BugReportManager.Companion.init();
        }
    }
}
