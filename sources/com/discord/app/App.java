package com.discord.app;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;
import b.a.d.App2;
import b.a.e.Backgrounded2;
import b.a.e.Backgrounded4;
import b.a.k.Format;
import b.a.k.g.FormattingParserProvider2;
import b.i.c.FirebaseApp2;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AdjustConfig;
import com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.buildutils.BuildUtils;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.debug.DebugPrintable3;
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
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.Strings4;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public class App extends Application {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_LOCAL = Strings4.contains$default((CharSequence) BuildConfig.FLAVOR, (CharSequence) "local", false, 2, (Object) null);
    private final boolean isUnderTest;

    /* JADX INFO: renamed from: com.discord.app.App$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: App.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: App.kt */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics3.checkNotNullParameter(th2, "throwable");
            Logger.e$default(AppLog.g, "Subscription error in backgrounded delay, " + th2, null, null, 6, null);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: App.kt */
    public static final class c extends Lambda implements Function0<Integer> {
        public static final c j = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(ColorCompat.getThemedColor(ActivityProvider.INSTANCE.getActivity(), R.attr.colorTextLink));
        }
    }

    /* JADX INFO: compiled from: App.kt */
    public static final class d extends Lambda implements Function2<String, View, Unit> {
        public static final d j = new d();

        public d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, View view) {
            String str2 = str;
            View view2 = view;
            Intrinsics3.checkNotNullParameter(str2, "url");
            Intrinsics3.checkNotNullParameter(view2, "view");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: App.kt */
    public static final /* synthetic */ class e extends FunctionReferenceImpl implements Function3<String, Throwable, Map<String, ? extends String>, Unit> {
        public e(AppLog appLog) {
            super(3, appLog, AppLog.class, "e", "e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(String str, Throwable th, Map<String, ? extends String> map) {
            String str2 = str;
            Intrinsics3.checkNotNullParameter(str2, "p1");
            ((AppLog) this.receiver).e(str2, th, map);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: App.kt */
    public static final class f extends Lambda implements Function2<View, String, Unit> {
        public static final f j = new f();

        public f() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(View view, String str) {
            View view2 = view;
            String str2 = str;
            Intrinsics3.checkNotNullParameter(view2, "textView");
            Intrinsics3.checkNotNullParameter(str2, "url");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "textView.context");
            UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: App.kt */
    public static final class g extends Lambda implements Function1<Experiment, Unit> {
        public static final g j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Experiment experiment) {
            return Unit.a;
        }
    }

    public void initializeFlipper() {
        Intrinsics3.checkNotNullParameter(this, "context");
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
        Intrinsics3.checkNotNullParameter(this, "application");
        AppLog.initCalled = true;
        AppLog.minLoggingPriority = 0;
        AppLog.cache = PreferenceManager.getDefaultSharedPreferences(this);
        LoggingProvider loggingProvider = LoggingProvider.INSTANCE;
        AppLog appLog = AppLog.g;
        loggingProvider.init(appLog);
        FirebaseApp2.e(this);
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
        DebugPrintable3.INSTANCE.initialize(string);
        AdjustConfig.INSTANCE.init(this, getIsUnderTest());
        Backgrounded4 backgrounded4 = Backgrounded4.d;
        b bVar = b.j;
        Intrinsics3.checkNotNullParameter(this, "application");
        Intrinsics3.checkNotNullParameter(bVar, "onError");
        registerActivityLifecycleCallbacks(new Backgrounded2(bVar));
        PersisterConfig.INSTANCE.init(this, ClockFactory.get());
        FormattingParserProvider2 formattingParserProvider2 = FormattingParserProvider2.f247b;
        FormattingParserProvider2 formattingParserProvider3 = (FormattingParserProvider2) FormattingParserProvider2.a.getValue();
        c cVar = c.j;
        d dVar = d.j;
        Intrinsics3.checkNotNullParameter(formattingParserProvider3, "formattingParserProvider");
        Intrinsics3.checkNotNullParameter(cVar, "defaultClickableTextColorProvider");
        Intrinsics3.checkNotNullParameter(dVar, "defaultUrlOnClick");
        Format format = Format.d;
        Intrinsics3.checkNotNullParameter(formattingParserProvider3, "formattingParserProvider");
        Intrinsics3.checkNotNullParameter(cVar, "defaultClickableTextColorProvider");
        Intrinsics3.checkNotNullParameter(dVar, "defaultUrlOnClick");
        Format.a = formattingParserProvider3;
        Format.f245b = cVar;
        Format.c = dVar;
        RestAPI.INSTANCE.init(this);
        NotificationClient.INSTANCE.init(this);
        MGImagesConfig.INSTANCE.init(this);
        Error.init(new App2(new e(appLog)));
        LinkifiedTextView.INSTANCE.init(f.j);
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
        Observable<R> observableG = StoreStream.INSTANCE.getExperiments().observeUserExperiment("2022-01_rna_rollout_experiment_validation", true).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getExperimen…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), g.j);
        AppLog.i("Application initialized.");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MGImagesConfig.INSTANCE.onTrimMemory(level);
    }
}
