package com.discord.app;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;
import b.a.e.b;
import b.a.e.d;
import b.a.k.a;
import b.i.c.c;
import com.discord.BuildConfig;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AdjustConfig;
import com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.buildutils.BuildUtils;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.debug.DebugPrintableCollection;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.images.MGImagesConfig;
import com.discord.utilities.lifecycle.ActivityProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.persister.PersisterConfig;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public class App extends Application {
    public static final App$a Companion = new App$a(null);
    private static final boolean IS_LOCAL = w.contains$default((CharSequence) BuildConfig.FLAVOR, (CharSequence) "local", false, 2, (Object) null);
    private final boolean isUnderTest;

    public static final /* synthetic */ boolean access$getIS_LOCAL$cp() {
        return IS_LOCAL;
    }

    public void initializeFlipper() {
        m.checkNotNullParameter(this, "context");
    }

    public void initializeRLottie() {
        System.loadLibrary("dsti");
    }

    /* JADX INFO: renamed from: isUnderTest, reason: from getter */
    public boolean getIsUnderTest() {
        return this.isUnderTest;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        SharedPreferencesProvider.INSTANCE.init(this);
        ApplicationProvider.INSTANCE.init(this);
        ActivityProvider.Companion.init(this);
        ClockFactory.INSTANCE.init(this);
        int i = AppLog.minLoggingPriority;
        m.checkNotNullParameter(this, "application");
        AppLog.initCalled = true;
        AppLog.minLoggingPriority = 0;
        AppLog.cache = PreferenceManager.getDefaultSharedPreferences(this);
        LoggingProvider loggingProvider = LoggingProvider.INSTANCE;
        AppLog appLog = AppLog.g;
        loggingProvider.init(appLog);
        c.e(this);
        if (BuildUtils.INSTANCE.isValidBuildVersionName(BuildConfig.VERSION_NAME)) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        } else {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false);
            Logger.w$default(appLog, "Disable crashlytics logging, likely modified client detected.", null, 2, null);
        }
        SystemLogUtils.INSTANCE.initSystemLogCapture();
        Objects.requireNonNull(appLog);
        Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
        String string = bundle != null ? bundle.getString("libdiscord_version") : null;
        if (string == null) {
            string = "Unknown";
        }
        appLog.recordBreadcrumb(string, "libdiscord_version");
        DebugPrintableCollection.Companion.initialize(string);
        AdjustConfig.INSTANCE.init(this, getIsUnderTest());
        d dVar = d.d;
        App$b app$b = App$b.j;
        m.checkNotNullParameter(this, "application");
        m.checkNotNullParameter(app$b, "onError");
        registerActivityLifecycleCallbacks(new b(app$b));
        PersisterConfig.INSTANCE.init(this, ClockFactory.get());
        b.a.k.g.d dVar2 = b.a.k.g.d.f247b;
        b.a.k.g.d dVar3 = (b.a.k.g.d) b.a.k.g.d.a.getValue();
        App$c app$c = App$c.j;
        App$d app$d = App$d.j;
        m.checkNotNullParameter(dVar3, "formattingParserProvider");
        m.checkNotNullParameter(app$c, "defaultClickableTextColorProvider");
        m.checkNotNullParameter(app$d, "defaultUrlOnClick");
        a aVar = a.d;
        m.checkNotNullParameter(dVar3, "formattingParserProvider");
        m.checkNotNullParameter(app$c, "defaultClickableTextColorProvider");
        m.checkNotNullParameter(app$d, "defaultUrlOnClick");
        a.a = dVar3;
        a.f245b = app$c;
        a.c = app$d;
        RestAPI.Companion.init(this);
        NotificationClient.INSTANCE.init(this);
        MGImagesConfig.INSTANCE.init(this);
        Error.init(new b.a.d.a(new App$e(appLog)));
        LinkifiedTextView.Companion.init(App$f.j);
        ModelEmojiCustom.setCdnUri(BuildConfig.HOST_CDN);
        SurveyUtils.INSTANCE.init(this);
        AppCompatDelegate.setDefaultNightMode(1);
        initializeFlipper();
        initializeRLottie();
        Objects.requireNonNull(appLog);
        if (FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) {
            AnalyticsTracker.INSTANCE.appCrashed();
        }
        AnalyticsDeviceResourceUsageMonitor.INSTANCE.start();
        Observable<R> observableG = StoreStream.Companion.getExperiments().observeUserExperiment("2022-01_rna_rollout_experiment_validation", true).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        m.checkNotNullExpressionValue(observableZ, "StoreStream.getExperimen…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, App$g.j, 62, (Object) null);
        AppLog.i("Application initialized.");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MGImagesConfig.INSTANCE.onTrimMemory(level);
    }
}
