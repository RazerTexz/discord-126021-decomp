package b.i.c.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build;
import android.os.Build$VERSION;
import android.util.Log;
import b.i.c.j.a.a$a;
import b.i.c.l.e;
import b.i.c.l.f;
import b.i.c.m.d.h;
import b.i.c.m.d.i.d;
import b.i.c.m.d.k.b0;
import b.i.c.m.d.k.e1;
import b.i.c.m.d.k.h1;
import b.i.c.m.d.k.k0;
import b.i.c.m.d.k.l0;
import b.i.c.m.d.k.m0;
import b.i.c.m.d.k.p0;
import b.i.c.m.d.k.q0;
import b.i.c.m.d.k.r;
import b.i.c.m.d.k.r0;
import b.i.c.m.d.k.v0;
import b.i.c.m.d.k.x;
import b.i.c.u.g;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CrashlyticsRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements f {
    public final CrashlyticsRegistrar a;

    public b(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.a = crashlyticsRegistrar;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x026b  */
    /* JADX WARN: Code duplicated, block: B:42:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x03a0  */
    @Override // b.i.c.l.f
    public Object a(e eVar) {
        b.i.c.m.d.j.a bVar;
        b.i.c.m.d.i.a fVar;
        boolean z2;
        String str;
        boolean z3;
        ExecutorService executorService;
        boolean z4;
        String str2;
        boolean zExists;
        b.i.c.m.d.i.a aVar;
        b.i.c.m.d.j.a bVar2;
        Objects.requireNonNull(this.a);
        b.i.c.c cVar = (b.i.c.c) eVar.a(b.i.c.c.class);
        b.i.c.m.d.a aVar2 = (b.i.c.m.d.a) eVar.a(b.i.c.m.d.a.class);
        b.i.c.j.a.a aVar3 = (b.i.c.j.a.a) eVar.a(b.i.c.j.a.a.class);
        g gVar = (g) eVar.a(g.class);
        cVar.a();
        Context context = cVar.d;
        v0 v0Var = new v0(context, context.getPackageName(), gVar);
        q0 q0Var = new q0(cVar);
        b.i.c.m.d.a cVar2 = aVar2 == null ? new b.i.c.m.d.c() : aVar2;
        h hVar = new h(cVar, context, v0Var, q0Var);
        if (aVar3 != null) {
            b.i.c.m.d.b bVar3 = b.i.c.m.d.b.a;
            bVar3.b("Firebase Analytics is available.");
            b.i.c.m.d.i.e eVar2 = new b.i.c.m.d.i.e(aVar3);
            a aVar4 = new a();
            a$a a_aC = aVar3.c("clx", aVar4);
            if (a_aC == null) {
                bVar3.b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
                a_aC = aVar3.c("crash", aVar4);
                if (a_aC != null) {
                    bVar3.g("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
                }
            }
            if (a_aC != null) {
                bVar3.b("Firebase Analytics listener registered successfully.");
                d dVar = new d();
                b.i.c.m.d.i.c cVar3 = new b.i.c.m.d.i.c(eVar2, 500, TimeUnit.MILLISECONDS);
                aVar4.f1672b = dVar;
                aVar4.a = cVar3;
                aVar = cVar3;
                bVar2 = dVar;
            } else {
                bVar3.b("Firebase Analytics listener registration failed.");
                bVar2 = new b.i.c.m.d.j.b();
                aVar = eVar2;
            }
            bVar = bVar2;
            fVar = aVar;
        } else {
            b.i.c.m.d.b.a.b("Firebase Analytics is unavailable.");
            bVar = new b.i.c.m.d.j.b();
            fVar = new b.i.c.m.d.i.f();
        }
        k0 k0Var = new k0(cVar, v0Var, cVar2, q0Var, bVar, fVar, b.i.a.f.e.o.f.n("Crashlytics Exception Handler"));
        try {
            hVar.i = hVar.l.c();
            hVar.d = context.getPackageManager();
            String packageName = context.getPackageName();
            hVar.e = packageName;
            PackageInfo packageInfo = hVar.d.getPackageInfo(packageName, 0);
            hVar.f = packageInfo;
            hVar.g = Integer.toString(packageInfo.versionCode);
            String str3 = hVar.f.versionName;
            if (str3 == null) {
                str3 = "0.0";
            }
            hVar.h = str3;
            hVar.j = hVar.d.getApplicationLabel(context.getApplicationInfo()).toString();
            hVar.k = Integer.toString(context.getApplicationInfo().targetSdkVersion);
            z2 = true;
        } catch (PackageManager$NameNotFoundException e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Failed init", e);
            }
            z2 = false;
        }
        if (!z2) {
            b.i.c.m.d.b.a.d("Unable to start Crashlytics.");
            return null;
        }
        ExecutorService executorServiceN = b.i.a.f.e.o.f.n("com.google.firebase.crashlytics.startup");
        cVar.a();
        String str4 = cVar.f.f1655b;
        v0 v0Var2 = hVar.l;
        b.i.c.m.d.n.b bVar4 = hVar.a;
        String str5 = hVar.g;
        String str6 = hVar.h;
        String strC = hVar.c();
        q0 q0Var2 = hVar.m;
        String strC2 = v0Var2.c();
        e1 e1Var = new e1();
        b.i.c.m.d.s.e eVar3 = new b.i.c.m.d.s.e(e1Var);
        b.i.c.m.d.s.a aVar5 = new b.i.c.m.d.s.a(context);
        Locale locale = Locale.US;
        b.i.c.m.d.s.c cVar4 = new b.i.c.m.d.s.c(context, new b.i.c.m.d.s.h.g(str4, String.format(locale, "%s/%s", v0Var2.e(Build.MANUFACTURER), v0Var2.e(Build.MODEL)), v0Var2.e(Build$VERSION.INCREMENTAL), v0Var2.e(Build$VERSION.RELEASE), v0Var2, b.i.c.m.d.k.h.f(b.i.c.m.d.k.h.l(context), str4, str6, str5), str6, str5, r0.f(strC2).g()), e1Var, eVar3, aVar5, new b.i.c.m.d.s.i.c(strC, String.format(locale, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str4), bVar4), q0Var2);
        cVar4.d(1, executorServiceN).i(executorServiceN, new b.i.c.m.d.g(hVar));
        String strL = b.i.c.m.d.k.h.l(k0Var.a);
        b.i.c.m.d.b bVar5 = b.i.c.m.d.b.a;
        b.d.b.a.a.o0("Mapping file ID is: ", strL, bVar5);
        if (b.i.c.m.d.k.h.j(k0Var.a, "com.crashlytics.RequireBuildId", true)) {
            if (b.i.c.m.d.k.h.t(strL)) {
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
            b.i.c.c cVar5 = k0Var.f1689b;
            cVar5.a();
            String str7 = cVar5.f.f1655b;
            try {
                bVar5.f("Initializing Crashlytics 17.3.0");
                Context context2 = k0Var.a;
                b.i.c.m.d.o.h hVar2 = new b.i.c.m.d.o.h(context2);
                k0Var.f = new m0("crash_marker", hVar2);
                k0Var.e = new m0("initialization_marker", hVar2);
                b.i.c.m.d.n.b bVar6 = new b.i.c.m.d.n.b();
                b.i.c.m.d.u.a aVar6 = new b.i.c.m.d.u.a(context2);
                v0 v0Var3 = k0Var.i;
                String packageName2 = context2.getPackageName();
                String strC3 = v0Var3.c();
                PackageInfo packageInfo2 = context2.getPackageManager().getPackageInfo(packageName2, 0);
                String string = Integer.toString(packageInfo2.versionCode);
                str2 = packageInfo2.versionName;
                if (str2 == null) {
                    str2 = "0.0";
                }
                executorService = executorServiceN;
                try {
                    b.i.c.m.d.k.b bVar7 = new b.i.c.m.d.k.b(str7, strL, strC3, packageName2, string, str2, aVar6);
                    bVar5.b("Installer package name is: " + strC3);
                    k0Var.h = new x(k0Var.a, k0Var.m, bVar6, k0Var.i, k0Var.c, hVar2, k0Var.f, bVar7, null, null, k0Var.n, k0Var.k, cVar4);
                    zExists = k0Var.e.b().exists();
                    try {
                        k0Var.g = Boolean.TRUE.equals((Boolean) h1.a(k0Var.m.b(new l0(k0Var))));
                    } catch (Exception unused) {
                        k0Var.g = false;
                    }
                    x xVar = k0Var.h;
                    Thread$UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                    xVar.m.b(new r(xVar));
                    p0 p0Var = new p0(new b0(xVar), cVar4, defaultUncaughtExceptionHandler);
                    xVar.B = p0Var;
                    Thread.setDefaultUncaughtExceptionHandler(p0Var);
                    if (zExists || !b.i.c.m.d.k.h.b(k0Var.a)) {
                        b.i.c.m.d.b.a.b("Exception handling initialization successful");
                        z4 = true;
                    } else {
                        b.i.c.m.d.b.a.b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                        k0Var.b(cVar4);
                        z4 = false;
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (b.i.c.m.d.b.a.a(6)) {
                        Log.e(str, "Crashlytics was not started due to an exception during initialization", e);
                    }
                    k0Var.h = null;
                }
            } catch (Exception e3) {
                e = e3;
                executorService = executorServiceN;
            }
            b.i.a.f.e.o.f.o(executorService, new c(hVar, executorService, cVar4, z4, k0Var));
            return new FirebaseCrashlytics(k0Var);
        }
        bVar5.b("Configured not to require a build ID.");
        z3 = true;
        str = "FirebaseCrashlytics";
        if (z3) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        }
        b.i.c.c cVar6 = k0Var.f1689b;
        cVar6.a();
        String str8 = cVar6.f.f1655b;
        bVar5.f("Initializing Crashlytics 17.3.0");
        Context context3 = k0Var.a;
        b.i.c.m.d.o.h hVar3 = new b.i.c.m.d.o.h(context3);
        k0Var.f = new m0("crash_marker", hVar3);
        k0Var.e = new m0("initialization_marker", hVar3);
        b.i.c.m.d.n.b bVar8 = new b.i.c.m.d.n.b();
        b.i.c.m.d.u.a aVar7 = new b.i.c.m.d.u.a(context3);
        v0 v0Var4 = k0Var.i;
        String packageName3 = context3.getPackageName();
        String strC4 = v0Var4.c();
        PackageInfo packageInfo3 = context3.getPackageManager().getPackageInfo(packageName3, 0);
        String string2 = Integer.toString(packageInfo3.versionCode);
        str2 = packageInfo3.versionName;
        if (str2 == null) {
            str2 = "0.0";
        }
        executorService = executorServiceN;
        b.i.c.m.d.k.b bVar9 = new b.i.c.m.d.k.b(str8, strL, strC4, packageName3, string2, str2, aVar7);
        bVar5.b("Installer package name is: " + strC4);
        k0Var.h = new x(k0Var.a, k0Var.m, bVar8, k0Var.i, k0Var.c, hVar3, k0Var.f, bVar9, null, null, k0Var.n, k0Var.k, cVar4);
        zExists = k0Var.e.b().exists();
        k0Var.g = Boolean.TRUE.equals((Boolean) h1.a(k0Var.m.b(new l0(k0Var))));
        x xVar2 = k0Var.h;
        Thread$UncaughtExceptionHandler defaultUncaughtExceptionHandler2 = Thread.getDefaultUncaughtExceptionHandler();
        xVar2.m.b(new r(xVar2));
        p0 p0Var2 = new p0(new b0(xVar2), cVar4, defaultUncaughtExceptionHandler2);
        xVar2.B = p0Var2;
        Thread.setDefaultUncaughtExceptionHandler(p0Var2);
        if (zExists) {
        }
        b.i.c.m.d.b.a.b("Exception handling initialization successful");
        z4 = true;
        b.i.a.f.e.o.f.o(executorService, new c(hVar, executorService, cVar4, z4, k0Var));
        return new FirebaseCrashlytics(k0Var);
    }
}
