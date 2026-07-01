package b.i.a.f.i.b;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w4 implements Runnable {
    public final /* synthetic */ y5 j;
    public final /* synthetic */ u4 k;

    public w4(u4 u4Var, y5 y5Var) {
        this.k = u4Var;
        this.j = y5Var;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0319  */
    /* JADX WARN: Code duplicated, block: B:111:0x0356  */
    /* JADX WARN: Code duplicated, block: B:113:0x037c  */
    /* JADX WARN: Code duplicated, block: B:139:0x0487  */
    /* JADX WARN: Code duplicated, block: B:145:0x04ac  */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String string;
        String str2;
        d4 d4VarO;
        d4 d4VarO2;
        Boolean boolX;
        boolean zD;
        d dVarG;
        String strConcat;
        s3 s3Var;
        u4 u4Var = this.k;
        y5 y5Var = this.j;
        u4Var.f().b();
        j jVar = new j(u4Var);
        jVar.p();
        u4Var.v = jVar;
        n3 n3Var = new n3(u4Var, y5Var.f);
        n3Var.u();
        u4Var.w = n3Var;
        m3 m3Var = new m3(u4Var);
        m3Var.u();
        u4Var.t = m3Var;
        q7 q7Var = new q7(u4Var);
        q7Var.u();
        u4Var.u = q7Var;
        u4Var.m.q();
        u4Var.i.q();
        u4Var.f1572x = new m4(u4Var);
        n3 n3Var2 = u4Var.w;
        if (n3Var2.f1518b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        n3Var2.w();
        n3Var2.a.G.incrementAndGet();
        boolean z2 = true;
        n3Var2.f1518b = true;
        u4Var.g().l.b("App measurement initialized, version", 33025L);
        u4Var.g().l.a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        n3Var.t();
        String str3 = n3Var.c;
        if (TextUtils.isEmpty(u4Var.c)) {
            if (u4Var.t().s0(str3)) {
                s3Var = u4Var.g().l;
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                s3 s3Var2 = u4Var.g().l;
                String strValueOf = String.valueOf(str3);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                s3Var = s3Var2;
            }
            s3Var.a(strConcat);
        }
        u4Var.g().m.a("Debug-level message logging enabled");
        if (u4Var.F != u4Var.G.get()) {
            u4Var.g().f.c("Not all components initialized", Integer.valueOf(u4Var.F), Integer.valueOf(u4Var.G.get()));
        }
        u4Var.f1573y = true;
        u4 u4Var2 = this.k;
        zzae zzaeVar = this.j.g;
        u4Var2.f().b();
        if (b.i.a.f.h.l.t8.b() && u4Var2.h.o(p.H0)) {
            d dVarY = u4Var2.o().y();
            d4 d4VarO3 = u4Var2.o();
            d4VarO3.b();
            int i = d4VarO3.w().getInt("consent_source", 100);
            int i2 = 40;
            if (u4Var2.h.o(p.I0)) {
                c cVar = u4Var2.h;
                Objects.requireNonNull(cVar);
                Boolean boolW = (b.i.a.f.h.l.t8.b() && cVar.o(p.I0)) ? cVar.w("google_analytics_default_allow_ad_storage") : null;
                c cVar2 = u4Var2.h;
                Objects.requireNonNull(cVar2);
                Boolean boolW2 = (b.i.a.f.h.l.t8.b() && cVar2.o(p.I0)) ? cVar2.w("google_analytics_default_allow_analytics_storage") : null;
                if (!(boolW == null && boolW2 == null) && u4Var2.o().t(20)) {
                    dVarG = new d(boolW, boolW2);
                    i2 = 20;
                } else {
                    n3 n3VarZ = u4Var2.z();
                    n3VarZ.t();
                    if (!TextUtils.isEmpty(n3VarZ.k) && (i == 30 || i == 40)) {
                        u4Var2.s().A(d.a, 20, u4Var2.H);
                    } else if (zzaeVar != null && zzaeVar.p != null && u4Var2.o().t(40)) {
                        dVarG = d.g(zzaeVar.p);
                        if (dVarG.equals(d.a)) {
                        }
                    }
                    dVarG = null;
                    i2 = 0;
                }
                if (dVarG != null) {
                    u4Var2.s().A(dVarG, i2, u4Var2.H);
                    dVarY = dVarG;
                }
            } else if (zzaeVar != null && zzaeVar.p != null && u4Var2.o().t(40)) {
                dVarG = d.g(zzaeVar.p);
                if (!dVarG.equals(d.a)) {
                    u4Var2.s().A(dVarG, 40, u4Var2.H);
                    dVarY = dVarG;
                }
            }
            u4Var2.s().z(dVarY);
        }
        if (u4Var2.o().f.a() == 0) {
            h4 h4Var = u4Var2.o().f;
            Objects.requireNonNull((b.i.a.f.e.o.c) u4Var2.o);
            h4Var.b(System.currentTimeMillis());
        }
        if (Long.valueOf(u4Var2.o().k.a()).longValue() == 0) {
            u4Var2.g().n.b("Persisting first open", Long.valueOf(u4Var2.H));
            u4Var2.o().k.b(u4Var2.H);
        }
        if (u4Var2.h.o(p.D0)) {
            y9 y9Var = u4Var2.s().n;
            if (y9Var.c() && y9Var.b()) {
                y9Var.a.o().B.b(null);
            }
        }
        if (u4Var2.m()) {
            n3 n3VarZ2 = u4Var2.z();
            n3VarZ2.t();
            if (TextUtils.isEmpty(n3VarZ2.k)) {
                n3 n3VarZ3 = u4Var2.z();
                n3VarZ3.t();
                if (!TextUtils.isEmpty(n3VarZ3.l)) {
                    u4Var2.t();
                    n3 n3VarZ4 = u4Var2.z();
                    n3VarZ4.t();
                    str = n3VarZ4.k;
                    d4 d4VarO4 = u4Var2.o();
                    d4VarO4.b();
                    string = d4VarO4.w().getString("gmp_app_id", null);
                    n3 n3VarZ5 = u4Var2.z();
                    n3VarZ5.t();
                    str2 = n3VarZ5.l;
                    d4VarO = u4Var2.o();
                    d4VarO.b();
                    if (t9.d0(str, string, str2, d4VarO.w().getString("admob_app_id", null))) {
                        u4Var2.g().l.a("Rechecking which service to use due to a GMP App Id change");
                        d4VarO2 = u4Var2.o();
                        d4VarO2.b();
                        boolX = d4VarO2.x();
                        SharedPreferences.Editor editorEdit = d4VarO2.w().edit();
                        editorEdit.clear();
                        editorEdit.apply();
                        if (boolX != null) {
                            d4VarO2.s(boolX);
                        }
                        u4.p(u4Var2.t);
                        u4Var2.t.y();
                        u4Var2.u.D();
                        u4Var2.u.C();
                        u4Var2.o().k.b(u4Var2.H);
                        u4Var2.o().m.b(null);
                    }
                    d4 d4VarO5 = u4Var2.o();
                    n3 n3VarZ6 = u4Var2.z();
                    n3VarZ6.t();
                    String str4 = n3VarZ6.k;
                    d4VarO5.b();
                    SharedPreferences.Editor editorEdit2 = d4VarO5.w().edit();
                    editorEdit2.putString("gmp_app_id", str4);
                    editorEdit2.apply();
                    d4 d4VarO6 = u4Var2.o();
                    n3 n3VarZ7 = u4Var2.z();
                    n3VarZ7.t();
                    String str5 = n3VarZ7.l;
                    d4VarO6.b();
                    SharedPreferences.Editor editorEdit3 = d4VarO6.w().edit();
                    editorEdit3.putString("admob_app_id", str5);
                    editorEdit3.apply();
                }
            } else {
                u4Var2.t();
                n3 n3VarZ8 = u4Var2.z();
                n3VarZ8.t();
                str = n3VarZ8.k;
                d4 d4VarO7 = u4Var2.o();
                d4VarO7.b();
                string = d4VarO7.w().getString("gmp_app_id", null);
                n3 n3VarZ9 = u4Var2.z();
                n3VarZ9.t();
                str2 = n3VarZ9.l;
                d4VarO = u4Var2.o();
                d4VarO.b();
                if (t9.d0(str, string, str2, d4VarO.w().getString("admob_app_id", null))) {
                    u4Var2.g().l.a("Rechecking which service to use due to a GMP App Id change");
                    d4VarO2 = u4Var2.o();
                    d4VarO2.b();
                    boolX = d4VarO2.x();
                    SharedPreferences.Editor editorEdit4 = d4VarO2.w().edit();
                    editorEdit4.clear();
                    editorEdit4.apply();
                    if (boolX != null) {
                        d4VarO2.s(boolX);
                    }
                    u4.p(u4Var2.t);
                    u4Var2.t.y();
                    u4Var2.u.D();
                    u4Var2.u.C();
                    u4Var2.o().k.b(u4Var2.H);
                    u4Var2.o().m.b(null);
                }
                d4 d4VarO8 = u4Var2.o();
                n3 n3VarZ10 = u4Var2.z();
                n3VarZ10.t();
                String str6 = n3VarZ10.k;
                d4VarO8.b();
                SharedPreferences.Editor editorEdit5 = d4VarO8.w().edit();
                editorEdit5.putString("gmp_app_id", str6);
                editorEdit5.apply();
                d4 d4VarO9 = u4Var2.o();
                n3 n3VarZ11 = u4Var2.z();
                n3VarZ11.t();
                String str7 = n3VarZ11.l;
                d4VarO9.b();
                SharedPreferences.Editor editorEdit6 = d4VarO9.w().edit();
                editorEdit6.putString("admob_app_id", str7);
                editorEdit6.apply();
            }
            if (b.i.a.f.h.l.t8.b() && u4Var2.h.o(p.H0) && !u4Var2.o().y().k()) {
                u4Var2.o().m.b(null);
            }
            u4Var2.s().g.set(u4Var2.o().m.a());
            if (b.i.a.f.h.l.a9.b() && u4Var2.h.o(p.p0)) {
                t9 t9VarT = u4Var2.t();
                Objects.requireNonNull(t9VarT);
                try {
                    t9VarT.a.f1570b.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (!z2 && !TextUtils.isEmpty(u4Var2.o().A.a())) {
                    u4Var2.g().i.a("Remote config removed with active feature rollouts");
                    u4Var2.o().A.b(null);
                }
            }
            n3 n3VarZ12 = u4Var2.z();
            n3VarZ12.t();
            if (TextUtils.isEmpty(n3VarZ12.k)) {
                n3 n3VarZ13 = u4Var2.z();
                n3VarZ13.t();
                if (!TextUtils.isEmpty(n3VarZ13.l)) {
                    zD = u4Var2.d();
                    if (!u4Var2.o().d.contains("deferred_analytics_collection") && !u4Var2.h.x()) {
                        u4Var2.o().v(!zD);
                    }
                    if (zD) {
                        u4Var2.s().N();
                    }
                    u4Var2.r().d.a();
                    u4Var2.x().A(new AtomicReference<>());
                    if (b.i.a.f.h.l.ea.b() && u4Var2.h.o(p.z0)) {
                        q7 q7VarX = u4Var2.x();
                        Bundle bundleA = u4Var2.o().D.a();
                        q7VarX.b();
                        q7VarX.t();
                        q7VarX.z(new a8(q7VarX, bundleA, q7VarX.I(false)));
                    }
                }
            } else {
                zD = u4Var2.d();
                if (!u4Var2.o().d.contains("deferred_analytics_collection")) {
                    u4Var2.o().v(!zD);
                }
                if (zD) {
                    u4Var2.s().N();
                }
                u4Var2.r().d.a();
                u4Var2.x().A(new AtomicReference<>());
                if (b.i.a.f.h.l.ea.b()) {
                    q7 q7VarX2 = u4Var2.x();
                    Bundle bundleA2 = u4Var2.o().D.a();
                    q7VarX2.b();
                    q7VarX2.t();
                    q7VarX2.z(new a8(q7VarX2, bundleA2, q7VarX2.I(false)));
                }
            }
        } else if (u4Var2.d()) {
            if (!u4Var2.t().p0("android.permission.INTERNET")) {
                u4Var2.g().f.a("App is missing INTERNET permission");
            }
            if (!u4Var2.t().p0("android.permission.ACCESS_NETWORK_STATE")) {
                u4Var2.g().f.a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!b.i.a.f.e.p.b.a(u4Var2.f1570b).c() && !u4Var2.h.C()) {
                if (!n4.a(u4Var2.f1570b)) {
                    u4Var2.g().f.a("AppMeasurementReceiver not registered/enabled");
                }
                if (!t9.U(u4Var2.f1570b)) {
                    u4Var2.g().f.a("AppMeasurementService not registered/enabled");
                }
            }
            u4Var2.g().f.a("Uploading is not possible. App measurement disabled");
        }
        u4Var2.o().u.a(u4Var2.h.o(p.Y));
    }
}
