package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.c.FirebaseApp2;
import b.i.c.j.a.a;
import b.i.c.l.Component4;
import b.i.c.l.ComponentContainer;
import b.i.c.l.ComponentFactory;
import b.i.c.l.ComponentRegistrar;
import b.i.c.l.Dependency2;
import b.i.c.m.d.CrashlyticsNativeComponent;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.MissingNativeComponent;
import b.i.c.m.d.Onboarding3;
import b.i.c.m.d.Onboarding4;
import b.i.c.m.d.i.AnalyticsEventLogger;
import b.i.c.m.d.i.BlockingAnalyticsEventLogger;
import b.i.c.m.d.i.BreadcrumbAnalyticsEventReceiver;
import b.i.c.m.d.i.CrashlyticsOriginAnalyticsEventLogger;
import b.i.c.m.d.i.UnavailableAnalyticsEventLogger;
import b.i.c.m.d.j.BreadcrumbSource;
import b.i.c.m.d.j.DisabledBreadcrumbSource;
import b.i.c.m.d.k.AppData;
import b.i.c.m.d.k.CommonUtils;
import b.i.c.m.d.k.CrashlyticsCore3;
import b.i.c.m.d.k.CrashlyticsCore4;
import b.i.c.m.d.k.CrashlyticsFileMarker;
import b.i.c.m.d.k.CrashlyticsUncaughtExceptionHandler;
import b.i.c.m.d.k.DataCollectionArbiter;
import b.i.c.m.d.k.DeliveryMechanism;
import b.i.c.m.d.k.IdManager;
import b.i.c.m.d.k.SystemCurrentTimeProvider;
import b.i.c.m.d.k.Utils3;
import b.i.c.m.d.k.b0;
import b.i.c.m.d.k.r;
import b.i.c.m.d.k.x;
import b.i.c.m.d.n.HttpRequestFactory;
import b.i.c.m.d.o.FileStoreImpl;
import b.i.c.m.d.s.CachedSettingsIo;
import b.i.c.m.d.s.SettingsController;
import b.i.c.m.d.s.SettingsJsonParser;
import b.i.c.m.d.s.h.SettingsRequest;
import b.i.c.m.d.s.i.DefaultSettingsSpiCall;
import b.i.c.m.d.u.ResourceUnityVersionProvider;
import b.i.c.u.g;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.lang.Thread;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarA = Component4.a(FirebaseCrashlytics.class);
        bVarA.a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarA.a(new Dependency2(g.class, 1, 0));
        bVarA.a(new Dependency2(a.class, 0, 0));
        bVarA.a(new Dependency2(CrashlyticsNativeComponent.class, 0, 0));
        bVarA.c(new ComponentFactory(this) { // from class: b.i.c.m.b
            public final CrashlyticsRegistrar a;

            {
                this.a = this;
            }

            /* JADX WARN: Code duplicated, block: B:39:0x026b  */
            /* JADX WARN: Code duplicated, block: B:42:0x02b9  */
            /* JADX WARN: Code duplicated, block: B:67:0x03a0  */
            @Override // b.i.c.l.ComponentFactory
            public Object a(ComponentContainer componentContainer) {
                BreadcrumbSource disabledBreadcrumbSource;
                AnalyticsEventLogger unavailableAnalyticsEventLogger;
                boolean z2;
                String str;
                boolean z3;
                ExecutorService executorService;
                boolean z4;
                String str2;
                boolean zExists;
                AnalyticsEventLogger analyticsEventLogger;
                BreadcrumbSource disabledBreadcrumbSource2;
                Objects.requireNonNull(this.a);
                FirebaseApp2 firebaseApp2 = (FirebaseApp2) componentContainer.a(FirebaseApp2.class);
                CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) componentContainer.a(CrashlyticsNativeComponent.class);
                b.i.c.j.a.a aVar = (b.i.c.j.a.a) componentContainer.a(b.i.c.j.a.a.class);
                g gVar = (g) componentContainer.a(g.class);
                firebaseApp2.a();
                Context context = firebaseApp2.d;
                IdManager idManager = new IdManager(context, context.getPackageName(), gVar);
                DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp2);
                CrashlyticsNativeComponent missingNativeComponent = crashlyticsNativeComponent == null ? new MissingNativeComponent() : crashlyticsNativeComponent;
                Onboarding4 onboarding4 = new Onboarding4(firebaseApp2, context, idManager, dataCollectionArbiter);
                if (aVar != null) {
                    Logger3 logger3 = Logger3.a;
                    logger3.b("Firebase Analytics is available.");
                    CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(aVar);
                    CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
                    a.InterfaceC0046a interfaceC0046aC = aVar.c("clx", crashlyticsAnalyticsListener);
                    if (interfaceC0046aC == null) {
                        logger3.b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
                        interfaceC0046aC = aVar.c("crash", crashlyticsAnalyticsListener);
                        if (interfaceC0046aC != null) {
                            logger3.g("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
                        }
                    }
                    if (interfaceC0046aC != null) {
                        logger3.b("Firebase Analytics listener registered successfully.");
                        BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                        BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                        crashlyticsAnalyticsListener.f1672b = breadcrumbAnalyticsEventReceiver;
                        crashlyticsAnalyticsListener.a = blockingAnalyticsEventLogger;
                        analyticsEventLogger = blockingAnalyticsEventLogger;
                        disabledBreadcrumbSource2 = breadcrumbAnalyticsEventReceiver;
                    } else {
                        logger3.b("Firebase Analytics listener registration failed.");
                        disabledBreadcrumbSource2 = new DisabledBreadcrumbSource();
                        analyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
                    }
                    disabledBreadcrumbSource = disabledBreadcrumbSource2;
                    unavailableAnalyticsEventLogger = analyticsEventLogger;
                } else {
                    Logger3.a.b("Firebase Analytics is unavailable.");
                    disabledBreadcrumbSource = new DisabledBreadcrumbSource();
                    unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
                }
                CrashlyticsCore3 crashlyticsCore3 = new CrashlyticsCore3(firebaseApp2, idManager, missingNativeComponent, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, f.n("Crashlytics Exception Handler"));
                try {
                    onboarding4.i = onboarding4.l.c();
                    onboarding4.d = context.getPackageManager();
                    String packageName = context.getPackageName();
                    onboarding4.e = packageName;
                    PackageInfo packageInfo = onboarding4.d.getPackageInfo(packageName, 0);
                    onboarding4.f = packageInfo;
                    onboarding4.g = Integer.toString(packageInfo.versionCode);
                    String str3 = onboarding4.f.versionName;
                    if (str3 == null) {
                        str3 = "0.0";
                    }
                    onboarding4.h = str3;
                    onboarding4.j = onboarding4.d.getApplicationLabel(context.getApplicationInfo()).toString();
                    onboarding4.k = Integer.toString(context.getApplicationInfo().targetSdkVersion);
                    z2 = true;
                } catch (PackageManager.NameNotFoundException e) {
                    if (Logger3.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "Failed init", e);
                    }
                    z2 = false;
                }
                if (!z2) {
                    Logger3.a.d("Unable to start Crashlytics.");
                    return null;
                }
                ExecutorService executorServiceN = f.n("com.google.firebase.crashlytics.startup");
                firebaseApp2.a();
                String str4 = firebaseApp2.f.f1655b;
                IdManager idManager2 = onboarding4.l;
                HttpRequestFactory httpRequestFactory = onboarding4.a;
                String str5 = onboarding4.g;
                String str6 = onboarding4.h;
                String strC = onboarding4.c();
                DataCollectionArbiter dataCollectionArbiter2 = onboarding4.m;
                String strC2 = idManager2.c();
                SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
                SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
                CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(context);
                Locale locale = Locale.US;
                SettingsController settingsController = new SettingsController(context, new SettingsRequest(str4, String.format(locale, "%s/%s", idManager2.e(Build.MANUFACTURER), idManager2.e(Build.MODEL)), idManager2.e(Build.VERSION.INCREMENTAL), idManager2.e(Build.VERSION.RELEASE), idManager2, CommonUtils.f(CommonUtils.l(context), str4, str6, str5), str6, str5, DeliveryMechanism.f(strC2).g()), systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, new DefaultSettingsSpiCall(strC, String.format(locale, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str4), httpRequestFactory), dataCollectionArbiter2);
                settingsController.d(1, executorServiceN).i(executorServiceN, new Onboarding3(onboarding4));
                String strL = CommonUtils.l(crashlyticsCore3.a);
                Logger3 logger4 = Logger3.a;
                outline.o0("Mapping file ID is: ", strL, logger4);
                if (CommonUtils.j(crashlyticsCore3.a, "com.crashlytics.RequireBuildId", true)) {
                    if (CommonUtils.t(strL)) {
                        str = "FirebaseCrashlytics";
                        Log.e(str, ".");
                        Log.e(str, ".     |  | ");
                        Log.e(str, ".     |  |");
                        Log.e(str, ".     |  |");
                        Log.e(str, ".   \\ |  | /");
                        Log.e(str, ".    \\    /");
                        Log.e(str, ".     \\  /");
                        Log.e(str, ".      \\/");
                        Log.e(str, ".");
                        Log.e(str, "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
                        Log.e(str, ".");
                        Log.e(str, ".      /\\");
                        Log.e(str, ".     /  \\");
                        Log.e(str, ".    /    \\");
                        Log.e(str, ".   / |  | \\");
                        Log.e(str, ".     |  |");
                        Log.e(str, ".     |  |");
                        Log.e(str, ".     |  |");
                        Log.e(str, ".");
                        z3 = false;
                    }
                    if (z3) {
                        throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
                    }
                    FirebaseApp2 firebaseApp3 = crashlyticsCore3.f1689b;
                    firebaseApp3.a();
                    String str7 = firebaseApp3.f.f1655b;
                    try {
                        logger4.f("Initializing Crashlytics 17.3.0");
                        Context context2 = crashlyticsCore3.a;
                        FileStoreImpl fileStoreImpl = new FileStoreImpl(context2);
                        crashlyticsCore3.f = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
                        crashlyticsCore3.e = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl);
                        HttpRequestFactory httpRequestFactory2 = new HttpRequestFactory();
                        ResourceUnityVersionProvider resourceUnityVersionProvider = new ResourceUnityVersionProvider(context2);
                        IdManager idManager3 = crashlyticsCore3.i;
                        String packageName2 = context2.getPackageName();
                        String strC3 = idManager3.c();
                        PackageInfo packageInfo2 = context2.getPackageManager().getPackageInfo(packageName2, 0);
                        String string = Integer.toString(packageInfo2.versionCode);
                        str2 = packageInfo2.versionName;
                        if (str2 == null) {
                            str2 = "0.0";
                        }
                        executorService = executorServiceN;
                        try {
                            AppData appData = new AppData(str7, strL, strC3, packageName2, string, str2, resourceUnityVersionProvider);
                            logger4.b("Installer package name is: " + strC3);
                            crashlyticsCore3.h = new x(crashlyticsCore3.a, crashlyticsCore3.m, httpRequestFactory2, crashlyticsCore3.i, crashlyticsCore3.c, fileStoreImpl, crashlyticsCore3.f, appData, null, null, crashlyticsCore3.n, crashlyticsCore3.k, settingsController);
                            zExists = crashlyticsCore3.e.b().exists();
                            try {
                                crashlyticsCore3.g = Boolean.TRUE.equals((Boolean) Utils3.a(crashlyticsCore3.m.b(new CrashlyticsCore4(crashlyticsCore3))));
                            } catch (Exception unused) {
                                crashlyticsCore3.g = false;
                            }
                            x xVar = crashlyticsCore3.h;
                            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                            xVar.m.b(new r(xVar));
                            CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new b0(xVar), settingsController, defaultUncaughtExceptionHandler);
                            xVar.B = crashlyticsUncaughtExceptionHandler;
                            Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
                            if (zExists || !CommonUtils.b(crashlyticsCore3.a)) {
                                Logger3.a.b("Exception handling initialization successful");
                                z4 = true;
                            } else {
                                Logger3.a.b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                                crashlyticsCore3.b(settingsController);
                                z4 = false;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (Logger3.a.a(6)) {
                                Log.e(str, "Crashlytics was not started due to an exception during initialization", e);
                            }
                            crashlyticsCore3.h = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        executorService = executorServiceN;
                    }
                    f.o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
                    return new FirebaseCrashlytics(crashlyticsCore3);
                }
                logger4.b("Configured not to require a build ID.");
                z3 = true;
                str = "FirebaseCrashlytics";
                if (z3) {
                    throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
                }
                FirebaseApp2 firebaseApp4 = crashlyticsCore3.f1689b;
                firebaseApp4.a();
                String str8 = firebaseApp4.f.f1655b;
                logger4.f("Initializing Crashlytics 17.3.0");
                Context context3 = crashlyticsCore3.a;
                FileStoreImpl fileStoreImpl2 = new FileStoreImpl(context3);
                crashlyticsCore3.f = new CrashlyticsFileMarker("crash_marker", fileStoreImpl2);
                crashlyticsCore3.e = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl2);
                HttpRequestFactory httpRequestFactory3 = new HttpRequestFactory();
                ResourceUnityVersionProvider resourceUnityVersionProvider2 = new ResourceUnityVersionProvider(context3);
                IdManager idManager4 = crashlyticsCore3.i;
                String packageName3 = context3.getPackageName();
                String strC4 = idManager4.c();
                PackageInfo packageInfo3 = context3.getPackageManager().getPackageInfo(packageName3, 0);
                String string2 = Integer.toString(packageInfo3.versionCode);
                str2 = packageInfo3.versionName;
                if (str2 == null) {
                    str2 = "0.0";
                }
                executorService = executorServiceN;
                AppData appData2 = new AppData(str8, strL, strC4, packageName3, string2, str2, resourceUnityVersionProvider2);
                logger4.b("Installer package name is: " + strC4);
                crashlyticsCore3.h = new x(crashlyticsCore3.a, crashlyticsCore3.m, httpRequestFactory3, crashlyticsCore3.i, crashlyticsCore3.c, fileStoreImpl2, crashlyticsCore3.f, appData2, null, null, crashlyticsCore3.n, crashlyticsCore3.k, settingsController);
                zExists = crashlyticsCore3.e.b().exists();
                crashlyticsCore3.g = Boolean.TRUE.equals((Boolean) Utils3.a(crashlyticsCore3.m.b(new CrashlyticsCore4(crashlyticsCore3))));
                x xVar2 = crashlyticsCore3.h;
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler2 = Thread.getDefaultUncaughtExceptionHandler();
                xVar2.m.b(new r(xVar2));
                CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler2 = new CrashlyticsUncaughtExceptionHandler(new b0(xVar2), settingsController, defaultUncaughtExceptionHandler2);
                xVar2.B = crashlyticsUncaughtExceptionHandler2;
                Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler2);
                if (zExists) {
                }
                Logger3.a.b("Exception handling initialization successful");
                z4 = true;
                f.o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
                return new FirebaseCrashlytics(crashlyticsCore3);
            }
        });
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-cls", "17.3.0"));
    }
}
