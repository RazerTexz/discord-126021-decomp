package com.discord.app;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AdjustConfig;
import com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.buildutils.BuildUtils;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.debug.DebugPrintableCollection;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.images.MGImagesConfig;
import com.discord.utilities.lifecycle.ActivityProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.PersisterConfig;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0852a;
import p007b.p008a.p020e.C0892b;
import p007b.p008a.p020e.C0894d;
import p007b.p008a.p027k.C1106a;
import p007b.p008a.p027k.p030g.C1118d;
import p007b.p225i.p361c.C4542c;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public class App extends Application {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_LOCAL = C12106w.contains$default((CharSequence) BuildConfig.FLAVOR, (CharSequence) "local", false, 2, (Object) null);
    private final boolean isUnderTest;

    /* JADX INFO: renamed from: com.discord.app.App$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: App.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: com.discord.app.App$b */
    /* JADX INFO: compiled from: App.kt */
    public static final class C5425b extends AbstractC12240o implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C5425b f14903j = new C5425b();

        public C5425b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            C12238m.checkNotNullParameter(th2, "throwable");
            Logger.e$default(AppLog.f14950g, "Subscription error in backgrounded delay, " + th2, null, null, 6, null);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.app.App$c */
    /* JADX INFO: compiled from: App.kt */
    public static final class C5426c extends AbstractC12240o implements Function0<Integer> {

        /* JADX INFO: renamed from: j */
        public static final C5426c f14904j = new C5426c();

        public C5426c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(ColorCompat.getThemedColor(ActivityProvider.INSTANCE.getActivity(), C5419R.attr.colorTextLink));
        }
    }

    /* JADX INFO: renamed from: com.discord.app.App$d */
    /* JADX INFO: compiled from: App.kt */
    public static final class C5427d extends AbstractC12240o implements Function2<String, View, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C5427d f14905j = new C5427d();

        public C5427d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, View view) {
            String str2 = str;
            View view2 = view;
            C12238m.checkNotNullParameter(str2, "url");
            C12238m.checkNotNullParameter(view2, "view");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view2.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.app.App$e */
    /* JADX INFO: compiled from: App.kt */
    public static final /* synthetic */ class C5428e extends C12236k implements Function3<String, Throwable, Map<String, ? extends String>, Unit> {
        public C5428e(AppLog appLog) {
            super(3, appLog, AppLog.class, "e", "e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(String str, Throwable th, Map<String, ? extends String> map) {
            String str2 = str;
            C12238m.checkNotNullParameter(str2, "p1");
            ((AppLog) this.receiver).mo8364e(str2, th, map);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.app.App$f */
    /* JADX INFO: compiled from: App.kt */
    public static final class C5429f extends AbstractC12240o implements Function2<View, String, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C5429f f14906j = new C5429f();

        public C5429f() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(View view, String str) {
            View view2 = view;
            String str2 = str;
            C12238m.checkNotNullParameter(view2, "textView");
            C12238m.checkNotNullParameter(str2, "url");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view2.getContext();
            C12238m.checkNotNullExpressionValue(context, "textView.context");
            UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.app.App$g */
    /* JADX INFO: compiled from: App.kt */
    public static final class C5430g extends AbstractC12240o implements Function1<Experiment, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C5430g f14907j = new C5430g();

        public C5430g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Experiment experiment) {
            return Unit.f27425a;
        }
    }

    public void initializeFlipper() {
        C12238m.checkNotNullParameter(this, "context");
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
        ActivityProvider.INSTANCE.init(this);
        ClockFactory.INSTANCE.init(this);
        int i = AppLog.minLoggingPriority;
        C12238m.checkNotNullParameter(this, "application");
        AppLog.initCalled = true;
        AppLog.minLoggingPriority = 0;
        AppLog.cache = PreferenceManager.getDefaultSharedPreferences(this);
        LoggingProvider loggingProvider = LoggingProvider.INSTANCE;
        AppLog appLog = AppLog.f14950g;
        loggingProvider.init(appLog);
        C4542c.m6328e(this);
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
        DebugPrintableCollection.INSTANCE.initialize(string);
        AdjustConfig.INSTANCE.init(this, getIsUnderTest());
        C0894d c0894d = C0894d.f600d;
        C5425b c5425b = C5425b.f14903j;
        C12238m.checkNotNullParameter(this, "application");
        C12238m.checkNotNullParameter(c5425b, "onError");
        registerActivityLifecycleCallbacks(new C0892b(c5425b));
        PersisterConfig.INSTANCE.init(this, ClockFactory.get());
        C1118d c1118d = C1118d.f1504b;
        C1118d c1118d2 = (C1118d) C1118d.f1503a.getValue();
        C5426c c5426c = C5426c.f14904j;
        C5427d c5427d = C5427d.f14905j;
        C12238m.checkNotNullParameter(c1118d2, "formattingParserProvider");
        C12238m.checkNotNullParameter(c5426c, "defaultClickableTextColorProvider");
        C12238m.checkNotNullParameter(c5427d, "defaultUrlOnClick");
        C1106a c1106a = C1106a.f1486d;
        C12238m.checkNotNullParameter(c1118d2, "formattingParserProvider");
        C12238m.checkNotNullParameter(c5426c, "defaultClickableTextColorProvider");
        C12238m.checkNotNullParameter(c5427d, "defaultUrlOnClick");
        C1106a.f1483a = c1118d2;
        C1106a.f1484b = c5426c;
        C1106a.f1485c = c5427d;
        RestAPI.INSTANCE.init(this);
        NotificationClient.INSTANCE.init(this);
        MGImagesConfig.INSTANCE.init(this);
        Error.init(new C0852a(new C5428e(appLog)));
        LinkifiedTextView.INSTANCE.init(C5429f.f14906j);
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
        Observable<R> observableM11083G = StoreStream.INSTANCE.getExperiments().observeUserExperiment("2022-01_rna_rollout_experiment_validation", true).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11100Z = observableM11083G.m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "StoreStream.getExperimen…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C5430g.f14907j);
        AppLog.m8358i("Application initialized.");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MGImagesConfig.INSTANCE.onTrimMemory(level);
    }
}
