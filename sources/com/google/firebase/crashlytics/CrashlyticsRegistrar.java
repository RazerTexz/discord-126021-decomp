package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p368l.C4572d;
import p007b.p225i.p361c.p368l.C4583o;
import p007b.p225i.p361c.p368l.InterfaceC4573e;
import p007b.p225i.p361c.p368l.InterfaceC4574f;
import p007b.p225i.p361c.p368l.InterfaceC4575g;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.C4593c;
import p007b.p225i.p361c.p369m.p370d.C4597g;
import p007b.p225i.p361c.p369m.p370d.C4598h;
import p007b.p225i.p361c.p369m.p370d.InterfaceC4591a;
import p007b.p225i.p361c.p369m.p370d.p371i.C4601c;
import p007b.p225i.p361c.p369m.p370d.p371i.C4602d;
import p007b.p225i.p361c.p369m.p370d.p371i.C4603e;
import p007b.p225i.p361c.p369m.p370d.p371i.C4604f;
import p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4599a;
import p007b.p225i.p361c.p369m.p370d.p372j.C4606b;
import p007b.p225i.p361c.p369m.p370d.p372j.InterfaceC4605a;
import p007b.p225i.p361c.p369m.p370d.p373k.C4610b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4611b0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4621e1;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p007b.p225i.p361c.p369m.p370d.p373k.C4630h1;
import p007b.p225i.p361c.p369m.p370d.p373k.C4638k0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4642m0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4648p0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4650q0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4660v0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4640l0;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4651r;
import p007b.p225i.p361c.p369m.p370d.p373k.EnumC4652r0;
import p007b.p225i.p361c.p369m.p370d.p377n.C4706b;
import p007b.p225i.p361c.p369m.p370d.p378o.C4715h;
import p007b.p225i.p361c.p369m.p370d.p384s.C4733a;
import p007b.p225i.p361c.p369m.p370d.p384s.C4735c;
import p007b.p225i.p361c.p369m.p370d.p384s.C4737e;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.C4746g;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.C4749c;
import p007b.p225i.p361c.p369m.p370d.p388u.C4757a;
import p007b.p225i.p361c.p401u.InterfaceC4843g;

/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsRegistrar implements InterfaceC4575g {
    @Override // p007b.p225i.p361c.p368l.InterfaceC4575g
    public List<C4572d<?>> getComponents() {
        C4572d.b bVarM6348a = C4572d.m6348a(FirebaseCrashlytics.class);
        bVarM6348a.m6351a(new C4583o(C4542c.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4843g.class, 1, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4549a.class, 0, 0));
        bVarM6348a.m6351a(new C4583o(InterfaceC4591a.class, 0, 0));
        bVarM6348a.m6353c(new InterfaceC4574f(this) { // from class: b.i.c.m.b

            /* JADX INFO: renamed from: a */
            public final CrashlyticsRegistrar f12221a;

            {
                this.f12221a = this;
            }

            /* JADX WARN: Code duplicated, block: B:39:0x026b  */
            /* JADX WARN: Code duplicated, block: B:42:0x02b9  */
            /* JADX WARN: Code duplicated, block: B:67:0x03a0  */
            @Override // p007b.p225i.p361c.p368l.InterfaceC4574f
            /* JADX INFO: renamed from: a */
            public Object mo6341a(InterfaceC4573e interfaceC4573e) {
                InterfaceC4605a c4606b;
                InterfaceC4599a c4604f;
                boolean z2;
                String str;
                boolean z3;
                ExecutorService executorService;
                boolean z4;
                String str2;
                boolean zExists;
                InterfaceC4599a interfaceC4599a;
                InterfaceC4605a c4606b2;
                Objects.requireNonNull(this.f12221a);
                C4542c c4542c = (C4542c) interfaceC4573e.mo6346a(C4542c.class);
                InterfaceC4591a interfaceC4591a = (InterfaceC4591a) interfaceC4573e.mo6346a(InterfaceC4591a.class);
                InterfaceC4549a interfaceC4549a = (InterfaceC4549a) interfaceC4573e.mo6346a(InterfaceC4549a.class);
                InterfaceC4843g interfaceC4843g = (InterfaceC4843g) interfaceC4573e.mo6346a(InterfaceC4843g.class);
                c4542c.m6330a();
                Context context = c4542c.f12118d;
                C4660v0 c4660v0 = new C4660v0(context, context.getPackageName(), interfaceC4843g);
                C4650q0 c4650q0 = new C4650q0(c4542c);
                InterfaceC4591a c4593c = interfaceC4591a == null ? new C4593c() : interfaceC4591a;
                C4598h c4598h = new C4598h(c4542c, context, c4660v0, c4650q0);
                if (interfaceC4549a != null) {
                    C4592b c4592b = C4592b.f12227a;
                    c4592b.m6371b("Firebase Analytics is available.");
                    C4603e c4603e = new C4603e(interfaceC4549a);
                    C4588a c4588a = new C4588a();
                    InterfaceC4549a.a aVarMo6340c = interfaceC4549a.mo6340c("clx", c4588a);
                    if (aVarMo6340c == null) {
                        c4592b.m6371b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
                        aVarMo6340c = interfaceC4549a.mo6340c("crash", c4588a);
                        if (aVarMo6340c != null) {
                            c4592b.m6376g("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
                        }
                    }
                    if (aVarMo6340c != null) {
                        c4592b.m6371b("Firebase Analytics listener registered successfully.");
                        C4602d c4602d = new C4602d();
                        C4601c c4601c = new C4601c(c4603e, 500, TimeUnit.MILLISECONDS);
                        c4588a.f12220b = c4602d;
                        c4588a.f12219a = c4601c;
                        interfaceC4599a = c4601c;
                        c4606b2 = c4602d;
                    } else {
                        c4592b.m6371b("Firebase Analytics listener registration failed.");
                        c4606b2 = new C4606b();
                        interfaceC4599a = c4603e;
                    }
                    c4606b = c4606b2;
                    c4604f = interfaceC4599a;
                } else {
                    C4592b.f12227a.m6371b("Firebase Analytics is unavailable.");
                    c4606b = new C4606b();
                    c4604f = new C4604f();
                }
                C4638k0 c4638k0 = new C4638k0(c4542c, c4660v0, c4593c, c4650q0, c4606b, c4604f, C3404f.m4319n("Crashlytics Exception Handler"));
                try {
                    c4598h.f12242i = c4598h.f12245l.m6457c();
                    c4598h.f12237d = context.getPackageManager();
                    String packageName = context.getPackageName();
                    c4598h.f12238e = packageName;
                    PackageInfo packageInfo = c4598h.f12237d.getPackageInfo(packageName, 0);
                    c4598h.f12239f = packageInfo;
                    c4598h.f12240g = Integer.toString(packageInfo.versionCode);
                    String str3 = c4598h.f12239f.versionName;
                    if (str3 == null) {
                        str3 = "0.0";
                    }
                    c4598h.f12241h = str3;
                    c4598h.f12243j = c4598h.f12237d.getApplicationLabel(context.getApplicationInfo()).toString();
                    c4598h.f12244k = Integer.toString(context.getApplicationInfo().targetSdkVersion);
                    z2 = true;
                } catch (PackageManager.NameNotFoundException e) {
                    if (C4592b.f12227a.m6370a(6)) {
                        Log.e("FirebaseCrashlytics", "Failed init", e);
                    }
                    z2 = false;
                }
                if (!z2) {
                    C4592b.f12227a.m6373d("Unable to start Crashlytics.");
                    return null;
                }
                ExecutorService executorServiceM4319n = C3404f.m4319n("com.google.firebase.crashlytics.startup");
                c4542c.m6330a();
                String str4 = c4542c.f12120f.f12135b;
                C4660v0 c4660v1 = c4598h.f12245l;
                C4706b c4706b = c4598h.f12234a;
                String str5 = c4598h.f12240g;
                String str6 = c4598h.f12241h;
                String strM6385c = c4598h.m6385c();
                C4650q0 c4650q1 = c4598h.f12246m;
                String strM6457c = c4660v1.m6457c();
                C4621e1 c4621e1 = new C4621e1();
                C4737e c4737e = new C4737e(c4621e1);
                C4733a c4733a = new C4733a(context);
                Locale locale = Locale.US;
                C4735c c4735c = new C4735c(context, new C4746g(str4, String.format(locale, "%s/%s", c4660v1.m6459e(Build.MANUFACTURER), c4660v1.m6459e(Build.MODEL)), c4660v1.m6459e(Build.VERSION.INCREMENTAL), c4660v1.m6459e(Build.VERSION.RELEASE), c4660v1, C4628h.m6412f(C4628h.m6418l(context), str4, str6, str5), str6, str5, EnumC4652r0.m6452f(strM6457c).m6453g()), c4621e1, c4737e, c4733a, new C4749c(strM6385c, String.format(locale, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str4), c4706b), c4650q1);
                c4735c.m6686d(1, executorServiceM4319n).mo6014i(executorServiceM4319n, new C4597g(c4598h));
                String strM6418l = C4628h.m6418l(c4638k0.f12329a);
                C4592b c4592b2 = C4592b.f12227a;
                C1643a.m868o0("Mapping file ID is: ", strM6418l, c4592b2);
                if (C4628h.m6416j(c4638k0.f12329a, "com.crashlytics.RequireBuildId", true)) {
                    if (C4628h.m6426t(strM6418l)) {
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
                    C4542c c4542c2 = c4638k0.f12330b;
                    c4542c2.m6330a();
                    String str7 = c4542c2.f12120f.f12135b;
                    try {
                        c4592b2.m6375f("Initializing Crashlytics 17.3.0");
                        Context context2 = c4638k0.f12329a;
                        C4715h c4715h = new C4715h(context2);
                        c4638k0.f12334f = new C4642m0("crash_marker", c4715h);
                        c4638k0.f12333e = new C4642m0("initialization_marker", c4715h);
                        C4706b c4706b2 = new C4706b();
                        C4757a c4757a = new C4757a(context2);
                        C4660v0 c4660v2 = c4638k0.f12337i;
                        String packageName2 = context2.getPackageName();
                        String strM6457c2 = c4660v2.m6457c();
                        PackageInfo packageInfo2 = context2.getPackageManager().getPackageInfo(packageName2, 0);
                        String string = Integer.toString(packageInfo2.versionCode);
                        str2 = packageInfo2.versionName;
                        if (str2 == null) {
                            str2 = "0.0";
                        }
                        executorService = executorServiceM4319n;
                        try {
                            C4610b c4610b = new C4610b(str7, strM6418l, strM6457c2, packageName2, string, str2, c4757a);
                            c4592b2.m6371b("Installer package name is: " + strM6457c2);
                            c4638k0.f12336h = new C4663x(c4638k0.f12329a, c4638k0.f12341m, c4706b2, c4638k0.f12337i, c4638k0.f12331c, c4715h, c4638k0.f12334f, c4610b, null, null, c4638k0.f12342n, c4638k0.f12339k, c4735c);
                            zExists = c4638k0.f12333e.m6445b().exists();
                            try {
                                c4638k0.f12335g = Boolean.TRUE.equals((Boolean) C4630h1.m6432a(c4638k0.f12341m.m6437b(new CallableC4640l0(c4638k0))));
                            } catch (Exception unused) {
                                c4638k0.f12335g = false;
                            }
                            C4663x c4663x = c4638k0.f12336h;
                            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                            c4663x.f12433m.m6437b(new CallableC4651r(c4663x));
                            C4648p0 c4648p0 = new C4648p0(new C4611b0(c4663x), c4735c, defaultUncaughtExceptionHandler);
                            c4663x.f12423B = c4648p0;
                            Thread.setDefaultUncaughtExceptionHandler(c4648p0);
                            if (zExists || !C4628h.m6408b(c4638k0.f12329a)) {
                                C4592b.f12227a.m6371b("Exception handling initialization successful");
                                z4 = true;
                            } else {
                                C4592b.f12227a.m6371b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                                c4638k0.m6440b(c4735c);
                                z4 = false;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            if (C4592b.f12227a.m6370a(6)) {
                                Log.e(str, "Crashlytics was not started due to an exception during initialization", e);
                            }
                            c4638k0.f12336h = null;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        executorService = executorServiceM4319n;
                    }
                    C3404f.m4323o(executorService, new CallableC4590c(c4598h, executorService, c4735c, z4, c4638k0));
                    return new FirebaseCrashlytics(c4638k0);
                }
                c4592b2.m6371b("Configured not to require a build ID.");
                z3 = true;
                str = "FirebaseCrashlytics";
                if (z3) {
                    throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
                }
                C4542c c4542c3 = c4638k0.f12330b;
                c4542c3.m6330a();
                String str8 = c4542c3.f12120f.f12135b;
                c4592b2.m6375f("Initializing Crashlytics 17.3.0");
                Context context3 = c4638k0.f12329a;
                C4715h c4715h2 = new C4715h(context3);
                c4638k0.f12334f = new C4642m0("crash_marker", c4715h2);
                c4638k0.f12333e = new C4642m0("initialization_marker", c4715h2);
                C4706b c4706b3 = new C4706b();
                C4757a c4757a2 = new C4757a(context3);
                C4660v0 c4660v3 = c4638k0.f12337i;
                String packageName3 = context3.getPackageName();
                String strM6457c3 = c4660v3.m6457c();
                PackageInfo packageInfo3 = context3.getPackageManager().getPackageInfo(packageName3, 0);
                String string2 = Integer.toString(packageInfo3.versionCode);
                str2 = packageInfo3.versionName;
                if (str2 == null) {
                    str2 = "0.0";
                }
                executorService = executorServiceM4319n;
                C4610b c4610b2 = new C4610b(str8, strM6418l, strM6457c3, packageName3, string2, str2, c4757a2);
                c4592b2.m6371b("Installer package name is: " + strM6457c3);
                c4638k0.f12336h = new C4663x(c4638k0.f12329a, c4638k0.f12341m, c4706b3, c4638k0.f12337i, c4638k0.f12331c, c4715h2, c4638k0.f12334f, c4610b2, null, null, c4638k0.f12342n, c4638k0.f12339k, c4735c);
                zExists = c4638k0.f12333e.m6445b().exists();
                c4638k0.f12335g = Boolean.TRUE.equals((Boolean) C4630h1.m6432a(c4638k0.f12341m.m6437b(new CallableC4640l0(c4638k0))));
                C4663x c4663x2 = c4638k0.f12336h;
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler2 = Thread.getDefaultUncaughtExceptionHandler();
                c4663x2.f12433m.m6437b(new CallableC4651r(c4663x2));
                C4648p0 c4648p1 = new C4648p0(new C4611b0(c4663x2), c4735c, defaultUncaughtExceptionHandler2);
                c4663x2.f12423B = c4648p1;
                Thread.setDefaultUncaughtExceptionHandler(c4648p1);
                if (zExists) {
                }
                C4592b.f12227a.m6371b("Exception handling initialization successful");
                z4 = true;
                C3404f.m4323o(executorService, new CallableC4590c(c4598h, executorService, c4735c, z4, c4638k0));
                return new FirebaseCrashlytics(c4638k0);
            }
        });
        bVarM6348a.m6354d(2);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-cls", "17.3.0"));
    }
}
