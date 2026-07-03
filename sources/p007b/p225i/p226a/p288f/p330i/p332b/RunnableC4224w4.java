package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3587a9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3644ea;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.w4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4224w4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4247y5 f11319j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4202u4 f11320k;

    public RunnableC4224w4(C4202u4 c4202u4, C4247y5 c4247y5) {
        this.f11320k = c4202u4;
        this.f11319j = c4247y5;
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
        C4009d4 c4009d4M5946o;
        C4009d4 c4009d4M5946o2;
        Boolean boolM5580x;
        boolean zM5940d;
        C4004d c4004dM5566g;
        String strConcat;
        C4179s3 c4179s3;
        C4202u4 c4202u4 = this.f11320k;
        C4247y5 c4247y5 = this.f11319j;
        c4202u4.mo5725f().mo5848b();
        C4076j c4076j = new C4076j(c4202u4);
        c4076j.m5858p();
        c4202u4.f11274v = c4076j;
        C4124n3 c4124n3 = new C4124n3(c4202u4, c4247y5.f11375f);
        c4124n3.m5498u();
        c4202u4.f11275w = c4124n3;
        C4113m3 c4113m3 = new C4113m3(c4202u4);
        c4113m3.m5498u();
        c4202u4.f11272t = c4113m3;
        C4161q7 c4161q7 = new C4161q7(c4202u4);
        c4161q7.m5498u();
        c4202u4.f11273u = c4161q7;
        c4202u4.f11265m.m5859q();
        c4202u4.f11261i.m5859q();
        c4202u4.f11276x = new C4114m4(c4202u4);
        C4124n3 c4124n4 = c4202u4.f11275w;
        if (c4124n4.f10542b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        c4124n4.m5760w();
        c4124n4.f11202a.f11252G.incrementAndGet();
        boolean z2 = true;
        c4124n4.f10542b = true;
        c4202u4.mo5726g().f11147l.m5861b("App measurement initialized, version", 33025L);
        c4202u4.mo5726g().f11147l.m5860a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        c4124n3.m5497t();
        String str3 = c4124n3.f10979c;
        if (TextUtils.isEmpty(c4202u4.f11255c)) {
            if (c4202u4.m5949t().m5920s0(str3)) {
                c4179s3 = c4202u4.mo5726g().f11147l;
                strConcat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                C4179s3 c4179s4 = c4202u4.mo5726g().f11147l;
                String strValueOf = String.valueOf(str3);
                strConcat = strValueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(strValueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                c4179s3 = c4179s4;
            }
            c4179s3.m5860a(strConcat);
        }
        c4202u4.mo5726g().f11148m.m5860a("Debug-level message logging enabled");
        if (c4202u4.f11251F != c4202u4.f11252G.get()) {
            c4202u4.mo5726g().f11141f.m5862c("Not all components initialized", Integer.valueOf(c4202u4.f11251F), Integer.valueOf(c4202u4.f11252G.get()));
        }
        c4202u4.f11277y = true;
        C4202u4 c4202u5 = this.f11320k;
        zzae zzaeVar = this.f11319j.f11376g;
        c4202u5.mo5725f().mo5848b();
        if (C3842t8.m5293b() && c4202u5.f11260h.m5526o(C4142p.f11035H0)) {
            C4004d c4004dM5581y = c4202u5.m5946o().m5581y();
            C4009d4 c4009d4M5946o3 = c4202u5.m5946o();
            c4009d4M5946o3.mo5848b();
            int i = c4009d4M5946o3.m5579w().getInt("consent_source", 100);
            int i2 = 40;
            if (c4202u5.f11260h.m5526o(C4142p.f11037I0)) {
                C3992c c3992c = c4202u5.f11260h;
                Objects.requireNonNull(c3992c);
                Boolean boolM5534w = (C3842t8.m5293b() && c3992c.m5526o(C4142p.f11037I0)) ? c3992c.m5534w("google_analytics_default_allow_ad_storage") : null;
                C3992c c3992c2 = c4202u5.f11260h;
                Objects.requireNonNull(c3992c2);
                Boolean boolM5534w2 = (C3842t8.m5293b() && c3992c2.m5526o(C4142p.f11037I0)) ? c3992c2.m5534w("google_analytics_default_allow_analytics_storage") : null;
                if (!(boolM5534w == null && boolM5534w2 == null) && c4202u5.m5946o().m5576t(20)) {
                    c4004dM5566g = new C4004d(boolM5534w, boolM5534w2);
                    i2 = 20;
                } else {
                    C4124n3 c4124n3M5955z = c4202u5.m5955z();
                    c4124n3M5955z.m5497t();
                    if (!TextUtils.isEmpty(c4124n3M5955z.f10987k) && (i == 30 || i == 40)) {
                        c4202u5.m5948s().m5539A(C4004d.f10622a, 20, c4202u5.f11253H);
                    } else if (zzaeVar != null && zzaeVar.f20627p != null && c4202u5.m5946o().m5576t(40)) {
                        c4004dM5566g = C4004d.m5566g(zzaeVar.f20627p);
                        if (c4004dM5566g.equals(C4004d.f10622a)) {
                        }
                    }
                    c4004dM5566g = null;
                    i2 = 0;
                }
                if (c4004dM5566g != null) {
                    c4202u5.m5948s().m5539A(c4004dM5566g, i2, c4202u5.f11253H);
                    c4004dM5581y = c4004dM5566g;
                }
            } else if (zzaeVar != null && zzaeVar.f20627p != null && c4202u5.m5946o().m5576t(40)) {
                c4004dM5566g = C4004d.m5566g(zzaeVar.f20627p);
                if (!c4004dM5566g.equals(C4004d.f10622a)) {
                    c4202u5.m5948s().m5539A(c4004dM5566g, 40, c4202u5.f11253H);
                    c4004dM5581y = c4004dM5566g;
                }
            }
            c4202u5.m5948s().m5559z(c4004dM5581y);
        }
        if (c4202u5.m5946o().f10636f.m5648a() == 0) {
            C4057h4 c4057h4 = c4202u5.m5946o().f10636f;
            Objects.requireNonNull((C3401c) c4202u5.f11267o);
            c4057h4.m5649b(System.currentTimeMillis());
        }
        if (Long.valueOf(c4202u5.m5946o().f10641k.m5648a()).longValue() == 0) {
            c4202u5.mo5726g().f11149n.m5861b("Persisting first open", Long.valueOf(c4202u5.f11253H));
            c4202u5.m5946o().f10641k.m5649b(c4202u5.f11253H);
        }
        if (c4202u5.f11260h.m5526o(C4142p.f11027D0)) {
            C4251y9 c4251y9 = c4202u5.m5948s().f10605n;
            if (c4251y9.m5967c() && c4251y9.m5966b()) {
                c4251y9.f11386a.m5946o().f10631B.m5695b(null);
            }
        }
        if (c4202u5.m5944m()) {
            C4124n3 c4124n3M5955z2 = c4202u5.m5955z();
            c4124n3M5955z2.m5497t();
            if (TextUtils.isEmpty(c4124n3M5955z2.f10987k)) {
                C4124n3 c4124n3M5955z3 = c4202u5.m5955z();
                c4124n3M5955z3.m5497t();
                if (!TextUtils.isEmpty(c4124n3M5955z3.f10988l)) {
                    c4202u5.m5949t();
                    C4124n3 c4124n3M5955z4 = c4202u5.m5955z();
                    c4124n3M5955z4.m5497t();
                    str = c4124n3M5955z4.f10987k;
                    C4009d4 c4009d4M5946o4 = c4202u5.m5946o();
                    c4009d4M5946o4.mo5848b();
                    string = c4009d4M5946o4.m5579w().getString("gmp_app_id", null);
                    C4124n3 c4124n3M5955z5 = c4202u5.m5955z();
                    c4124n3M5955z5.m5497t();
                    str2 = c4124n3M5955z5.f10988l;
                    c4009d4M5946o = c4202u5.m5946o();
                    c4009d4M5946o.mo5848b();
                    if (C4196t9.m5878d0(str, string, str2, c4009d4M5946o.m5579w().getString("admob_app_id", null))) {
                        c4202u5.mo5726g().f11147l.m5860a("Rechecking which service to use due to a GMP App Id change");
                        c4009d4M5946o2 = c4202u5.m5946o();
                        c4009d4M5946o2.mo5848b();
                        boolM5580x = c4009d4M5946o2.m5580x();
                        SharedPreferences.Editor editorEdit = c4009d4M5946o2.m5579w().edit();
                        editorEdit.clear();
                        editorEdit.apply();
                        if (boolM5580x != null) {
                            c4009d4M5946o2.m5575s(boolM5580x);
                        }
                        C4202u4.m5935p(c4202u5.f11272t);
                        c4202u5.f11272t.m5756y();
                        c4202u5.f11273u.m5806D();
                        c4202u5.f11273u.m5805C();
                        c4202u5.m5946o().f10641k.m5649b(c4202u5.f11253H);
                        c4202u5.m5946o().f10643m.m5695b(null);
                    }
                    C4009d4 c4009d4M5946o5 = c4202u5.m5946o();
                    C4124n3 c4124n3M5955z6 = c4202u5.m5955z();
                    c4124n3M5955z6.m5497t();
                    String str4 = c4124n3M5955z6.f10987k;
                    c4009d4M5946o5.mo5848b();
                    SharedPreferences.Editor editorEdit2 = c4009d4M5946o5.m5579w().edit();
                    editorEdit2.putString("gmp_app_id", str4);
                    editorEdit2.apply();
                    C4009d4 c4009d4M5946o6 = c4202u5.m5946o();
                    C4124n3 c4124n3M5955z7 = c4202u5.m5955z();
                    c4124n3M5955z7.m5497t();
                    String str5 = c4124n3M5955z7.f10988l;
                    c4009d4M5946o6.mo5848b();
                    SharedPreferences.Editor editorEdit3 = c4009d4M5946o6.m5579w().edit();
                    editorEdit3.putString("admob_app_id", str5);
                    editorEdit3.apply();
                }
            } else {
                c4202u5.m5949t();
                C4124n3 c4124n3M5955z8 = c4202u5.m5955z();
                c4124n3M5955z8.m5497t();
                str = c4124n3M5955z8.f10987k;
                C4009d4 c4009d4M5946o7 = c4202u5.m5946o();
                c4009d4M5946o7.mo5848b();
                string = c4009d4M5946o7.m5579w().getString("gmp_app_id", null);
                C4124n3 c4124n3M5955z9 = c4202u5.m5955z();
                c4124n3M5955z9.m5497t();
                str2 = c4124n3M5955z9.f10988l;
                c4009d4M5946o = c4202u5.m5946o();
                c4009d4M5946o.mo5848b();
                if (C4196t9.m5878d0(str, string, str2, c4009d4M5946o.m5579w().getString("admob_app_id", null))) {
                    c4202u5.mo5726g().f11147l.m5860a("Rechecking which service to use due to a GMP App Id change");
                    c4009d4M5946o2 = c4202u5.m5946o();
                    c4009d4M5946o2.mo5848b();
                    boolM5580x = c4009d4M5946o2.m5580x();
                    SharedPreferences.Editor editorEdit4 = c4009d4M5946o2.m5579w().edit();
                    editorEdit4.clear();
                    editorEdit4.apply();
                    if (boolM5580x != null) {
                        c4009d4M5946o2.m5575s(boolM5580x);
                    }
                    C4202u4.m5935p(c4202u5.f11272t);
                    c4202u5.f11272t.m5756y();
                    c4202u5.f11273u.m5806D();
                    c4202u5.f11273u.m5805C();
                    c4202u5.m5946o().f10641k.m5649b(c4202u5.f11253H);
                    c4202u5.m5946o().f10643m.m5695b(null);
                }
                C4009d4 c4009d4M5946o8 = c4202u5.m5946o();
                C4124n3 c4124n3M5955z10 = c4202u5.m5955z();
                c4124n3M5955z10.m5497t();
                String str6 = c4124n3M5955z10.f10987k;
                c4009d4M5946o8.mo5848b();
                SharedPreferences.Editor editorEdit5 = c4009d4M5946o8.m5579w().edit();
                editorEdit5.putString("gmp_app_id", str6);
                editorEdit5.apply();
                C4009d4 c4009d4M5946o9 = c4202u5.m5946o();
                C4124n3 c4124n3M5955z11 = c4202u5.m5955z();
                c4124n3M5955z11.m5497t();
                String str7 = c4124n3M5955z11.f10988l;
                c4009d4M5946o9.mo5848b();
                SharedPreferences.Editor editorEdit6 = c4009d4M5946o9.m5579w().edit();
                editorEdit6.putString("admob_app_id", str7);
                editorEdit6.apply();
            }
            if (C3842t8.m5293b() && c4202u5.f11260h.m5526o(C4142p.f11035H0) && !c4202u5.m5946o().m5581y().m5572k()) {
                c4202u5.m5946o().f10643m.m5695b(null);
            }
            c4202u5.m5948s().f10598g.set(c4202u5.m5946o().f10643m.m5694a());
            if (C3587a9.m4561b() && c4202u5.f11260h.m5526o(C4142p.f11092p0)) {
                C4196t9 c4196t9M5949t = c4202u5.m5949t();
                Objects.requireNonNull(c4196t9M5949t);
                try {
                    c4196t9M5949t.f11202a.f11254b.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                if (!z2 && !TextUtils.isEmpty(c4202u5.m5946o().f10630A.m5694a())) {
                    c4202u5.mo5726g().f11144i.m5860a("Remote config removed with active feature rollouts");
                    c4202u5.m5946o().f10630A.m5695b(null);
                }
            }
            C4124n3 c4124n3M5955z12 = c4202u5.m5955z();
            c4124n3M5955z12.m5497t();
            if (TextUtils.isEmpty(c4124n3M5955z12.f10987k)) {
                C4124n3 c4124n3M5955z13 = c4202u5.m5955z();
                c4124n3M5955z13.m5497t();
                if (!TextUtils.isEmpty(c4124n3M5955z13.f10988l)) {
                    zM5940d = c4202u5.m5940d();
                    if (!c4202u5.m5946o().f10634d.contains("deferred_analytics_collection") && !c4202u5.f11260h.m5535x()) {
                        c4202u5.m5946o().m5578v(!zM5940d);
                    }
                    if (zM5940d) {
                        c4202u5.m5948s().m5551N();
                    }
                    c4202u5.m5947r().f11329d.m5599a();
                    c4202u5.m5953x().m5803A(new AtomicReference<>());
                    if (C3644ea.m4872b() && c4202u5.f11260h.m5526o(C4142p.f11112z0)) {
                        C4161q7 c4161q7M5953x = c4202u5.m5953x();
                        Bundle bundleM5681a = c4202u5.m5946o().f10633D.m5681a();
                        c4161q7M5953x.mo5848b();
                        c4161q7M5953x.m5497t();
                        c4161q7M5953x.m5814z(new RunnableC3977a8(c4161q7M5953x, bundleM5681a, c4161q7M5953x.m5811I(false)));
                    }
                }
            } else {
                zM5940d = c4202u5.m5940d();
                if (!c4202u5.m5946o().f10634d.contains("deferred_analytics_collection")) {
                    c4202u5.m5946o().m5578v(!zM5940d);
                }
                if (zM5940d) {
                    c4202u5.m5948s().m5551N();
                }
                c4202u5.m5947r().f11329d.m5599a();
                c4202u5.m5953x().m5803A(new AtomicReference<>());
                if (C3644ea.m4872b()) {
                    C4161q7 c4161q7M5953x2 = c4202u5.m5953x();
                    Bundle bundleM5681a2 = c4202u5.m5946o().f10633D.m5681a();
                    c4161q7M5953x2.mo5848b();
                    c4161q7M5953x2.m5497t();
                    c4161q7M5953x2.m5814z(new RunnableC3977a8(c4161q7M5953x2, bundleM5681a2, c4161q7M5953x2.m5811I(false)));
                }
            }
        } else if (c4202u5.m5940d()) {
            if (!c4202u5.m5949t().m5918p0("android.permission.INTERNET")) {
                c4202u5.mo5726g().f11141f.m5860a("App is missing INTERNET permission");
            }
            if (!c4202u5.m5949t().m5918p0("android.permission.ACCESS_NETWORK_STATE")) {
                c4202u5.mo5726g().f11141f.m5860a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!C3411b.m4376a(c4202u5.f11254b).m4375c() && !c4202u5.f11260h.m5521C()) {
                if (!C4125n4.m5761a(c4202u5.f11254b)) {
                    c4202u5.mo5726g().f11141f.m5860a("AppMeasurementReceiver not registered/enabled");
                }
                if (!C4196t9.m5874U(c4202u5.f11254b)) {
                    c4202u5.mo5726g().f11141f.m5860a("AppMeasurementService not registered/enabled");
                }
            }
            c4202u5.mo5726g().f11141f.m5860a("Uploading is not possible. App measurement disabled");
        }
        c4202u5.m5946o().f10651u.m5596a(c4202u5.f11260h.m5526o(C4142p.f11059Y));
    }
}
