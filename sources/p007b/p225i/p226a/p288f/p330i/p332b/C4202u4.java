package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzae;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3295h;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.InterfaceC3400b;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3732l2;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3836t2;
import p007b.p225i.p226a.p288f.p313h.p325l.C3608c2;
import p007b.p225i.p226a.p288f.p313h.p325l.C3823s2;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;
import p007b.p225i.p226a.p288f.p313h.p325l.C3861v1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3900y1;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2;

/* JADX INFO: renamed from: b.i.a.f.i.b.u4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4202u4 implements InterfaceC4192t5 {

    /* JADX INFO: renamed from: a */
    public static volatile C4202u4 f11245a;

    /* JADX INFO: renamed from: A */
    public long f11246A;

    /* JADX INFO: renamed from: B */
    public volatile Boolean f11247B;

    /* JADX INFO: renamed from: C */
    public Boolean f11248C;

    /* JADX INFO: renamed from: D */
    public Boolean f11249D;

    /* JADX INFO: renamed from: E */
    public volatile boolean f11250E;

    /* JADX INFO: renamed from: F */
    public int f11251F;

    /* JADX INFO: renamed from: H */
    public final long f11253H;

    /* JADX INFO: renamed from: b */
    public final Context f11254b;

    /* JADX INFO: renamed from: c */
    public final String f11255c;

    /* JADX INFO: renamed from: d */
    public final String f11256d;

    /* JADX INFO: renamed from: e */
    public final String f11257e;

    /* JADX INFO: renamed from: f */
    public final boolean f11258f;

    /* JADX INFO: renamed from: g */
    public final C4051ga f11259g;

    /* JADX INFO: renamed from: h */
    public final C3992c f11260h;

    /* JADX INFO: renamed from: i */
    public final C4009d4 f11261i;

    /* JADX INFO: renamed from: j */
    public final C4157q3 f11262j;

    /* JADX INFO: renamed from: k */
    public final C4169r4 f11263k;

    /* JADX INFO: renamed from: l */
    public final C4228w8 f11264l;

    /* JADX INFO: renamed from: m */
    public final C4196t9 f11265m;

    /* JADX INFO: renamed from: n */
    public final C4135o3 f11266n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC3400b f11267o;

    /* JADX INFO: renamed from: p */
    public final C4060h7 f11268p;

    /* JADX INFO: renamed from: q */
    public final C3999c6 f11269q;

    /* JADX INFO: renamed from: r */
    public final C3968a f11270r;

    /* JADX INFO: renamed from: s */
    public final C4012d7 f11271s;

    /* JADX INFO: renamed from: t */
    public C4113m3 f11272t;

    /* JADX INFO: renamed from: u */
    public C4161q7 f11273u;

    /* JADX INFO: renamed from: v */
    public C4076j f11274v;

    /* JADX INFO: renamed from: w */
    public C4124n3 f11275w;

    /* JADX INFO: renamed from: x */
    public C4114m4 f11276x;

    /* JADX INFO: renamed from: z */
    public Boolean f11278z;

    /* JADX INFO: renamed from: y */
    public boolean f11277y = false;

    /* JADX INFO: renamed from: G */
    public AtomicInteger f11252G = new AtomicInteger(0);

    public C4202u4(C4247y5 c4247y5) {
        Context context;
        Bundle bundle;
        boolean z2 = false;
        Context context2 = c4247y5.f11370a;
        C4051ga c4051ga = new C4051ga();
        this.f11259g = c4051ga;
        C3404f.f9589c = c4051ga;
        this.f11254b = context2;
        this.f11255c = c4247y5.f11371b;
        this.f11256d = c4247y5.f11372c;
        this.f11257e = c4247y5.f11373d;
        this.f11258f = c4247y5.f11377h;
        this.f11247B = c4247y5.f11374e;
        this.f11250E = true;
        zzae zzaeVar = c4247y5.f11376g;
        if (zzaeVar != null && (bundle = zzaeVar.f20627p) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.f11248C = (Boolean) obj;
            }
            Object obj2 = zzaeVar.f20627p.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.f11249D = (Boolean) obj2;
            }
        }
        synchronized (AbstractC3732l2.f10069a) {
            AbstractC3836t2 abstractC3836t2 = AbstractC3732l2.f10070b;
            final Context applicationContext = context2.getApplicationContext();
            applicationContext = applicationContext == null ? context2 : applicationContext;
            if (abstractC3836t2 == null || abstractC3836t2.mo5277a() != applicationContext) {
                C3900y1.m5377c();
                C3823s2.m5214b();
                synchronized (C3608c2.class) {
                    C3608c2 c3608c2 = C3608c2.f9871a;
                    if (c3608c2 != null && (context = c3608c2.f9872b) != null && c3608c2.f9873c != null) {
                        context.getContentResolver().unregisterContentObserver(C3608c2.f9871a.f9873c);
                    }
                    C3608c2.f9871a = null;
                }
                AbstractC3732l2.f10070b = new C3861v1(applicationContext, C3404f.m4239Q1(new InterfaceC3914z2(applicationContext) { // from class: b.i.a.f.h.l.k2

                    /* JADX INFO: renamed from: j */
                    public final Context f10051j;

                    {
                        this.f10051j = applicationContext;
                    }

                    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3914z2
                    /* JADX INFO: renamed from: a */
                    public final Object mo4555a() {
                        AbstractC3888x2 c3901y2;
                        Context contextCreateDeviceProtectedStorageContext = this.f10051j;
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        if (!((str.equals("eng") || str.equals("userdebug")) && (str2.contains("dev-keys") || str2.contains("test-keys")))) {
                            return C3875w2.f10378j;
                        }
                        if (C3874w1.m5341a() && !contextCreateDeviceProtectedStorageContext.isDeviceProtectedStorage()) {
                            contextCreateDeviceProtectedStorageContext = contextCreateDeviceProtectedStorageContext.createDeviceProtectedStorageContext();
                        }
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            StrictMode.allowThreadDiskWrites();
                            try {
                                File file = new File(contextCreateDeviceProtectedStorageContext.getDir("phenotype_hermetic", 0), "overrides.txt");
                                c3901y2 = file.exists() ? new C3901y2(file) : C3875w2.f10378j;
                            } catch (RuntimeException e) {
                                Log.e("HermeticFileOverrides", "no data dir", e);
                                c3901y2 = C3875w2.f10378j;
                            }
                            if (!c3901y2.mo5342b()) {
                                return C3875w2.f10378j;
                            }
                            File file2 = (File) c3901y2.mo5343c();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                try {
                                    HashMap map = new HashMap();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            String strValueOf = String.valueOf(file2);
                                            StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                                            sb.append("Parsed ");
                                            sb.append(strValueOf);
                                            Log.i("HermeticFileOverrides", sb.toString());
                                            C3678h2 c3678h2 = new C3678h2(map);
                                            bufferedReader.close();
                                            return new C3901y2(c3678h2);
                                        }
                                        String[] strArrSplit = line.split(" ", 3);
                                        if (strArrSplit.length != 3) {
                                            Log.e("HermeticFileOverrides", line.length() != 0 ? "Invalid: ".concat(line) : new String("Invalid: "));
                                        } else {
                                            String str3 = strArrSplit[0];
                                            String strDecode = Uri.decode(strArrSplit[1]);
                                            String strDecode2 = Uri.decode(strArrSplit[2]);
                                            if (!map.containsKey(str3)) {
                                                map.put(str3, new HashMap());
                                            }
                                            ((Map) map.get(str3)).put(strDecode, strDecode2);
                                        }
                                        throw new RuntimeException(e);
                                    }
                                } catch (Throwable th) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th2) {
                                        C3665g3.f9966a.mo4876a(th, th2);
                                    }
                                    throw th;
                                }
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    }
                }));
                AbstractC3732l2.f10072d.incrementAndGet();
            }
        }
        this.f11267o = C3401c.f9584a;
        Long l = c4247y5.f11378i;
        this.f11253H = l != null ? l.longValue() : System.currentTimeMillis();
        this.f11260h = new C3992c(this);
        C4009d4 c4009d4 = new C4009d4(this);
        c4009d4.m5858p();
        this.f11261i = c4009d4;
        C4157q3 c4157q3 = new C4157q3(this);
        c4157q3.m5858p();
        this.f11262j = c4157q3;
        C4196t9 c4196t9 = new C4196t9(this);
        c4196t9.m5858p();
        this.f11265m = c4196t9;
        C4135o3 c4135o3 = new C4135o3(this);
        c4135o3.m5858p();
        this.f11266n = c4135o3;
        this.f11270r = new C3968a(this);
        C4060h7 c4060h7 = new C4060h7(this);
        c4060h7.m5498u();
        this.f11268p = c4060h7;
        C3999c6 c3999c6 = new C3999c6(this);
        c3999c6.m5498u();
        this.f11269q = c3999c6;
        C4228w8 c4228w8 = new C4228w8(this);
        c4228w8.m5498u();
        this.f11264l = c4228w8;
        C4012d7 c4012d7 = new C4012d7(this);
        c4012d7.m5858p();
        this.f11271s = c4012d7;
        C4169r4 c4169r4 = new C4169r4(this);
        c4169r4.m5858p();
        this.f11263k = c4169r4;
        zzae zzaeVar2 = c4247y5.f11376g;
        if (zzaeVar2 != null && zzaeVar2.f20622k != 0) {
            z2 = true;
        }
        boolean z3 = !z2;
        if (context2.getApplicationContext() instanceof Application) {
            C3999c6 c3999c6M5948s = m5948s();
            if (c3999c6M5948s.f11202a.f11254b.getApplicationContext() instanceof Application) {
                Application application = (Application) c3999c6M5948s.f11202a.f11254b.getApplicationContext();
                if (c3999c6M5948s.f10594c == null) {
                    c3999c6M5948s.f10594c = new C4248y6(c3999c6M5948s, null);
                }
                if (z3) {
                    application.unregisterActivityLifecycleCallbacks(c3999c6M5948s.f10594c);
                    application.registerActivityLifecycleCallbacks(c3999c6M5948s.f10594c);
                    c3999c6M5948s.mo5726g().f11149n.m5860a("Registered activity lifecycle callback");
                }
            }
        } else {
            mo5726g().f11144i.m5860a("Application context is not an Application");
        }
        c4169r4.m5852v(new RunnableC4224w4(this, c4247y5));
    }

    /* JADX INFO: renamed from: b */
    public static C4202u4 m5933b(Context context, zzae zzaeVar, Long l) {
        Bundle bundle;
        if (zzaeVar != null && (zzaeVar.f20625n == null || zzaeVar.f20626o == null)) {
            zzaeVar = new zzae(zzaeVar.f20621j, zzaeVar.f20622k, zzaeVar.f20623l, zzaeVar.f20624m, null, null, zzaeVar.f20627p);
        }
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (f11245a == null) {
            synchronized (C4202u4.class) {
                if (f11245a == null) {
                    f11245a = new C4202u4(new C4247y5(context, zzaeVar, l));
                }
            }
        } else if (zzaeVar != null && (bundle = zzaeVar.f20627p) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            f11245a.f11247B = Boolean.valueOf(zzaeVar.f20627p.getBoolean("dataCollectionDefaultEnabled"));
        }
        return f11245a;
    }

    /* JADX INFO: renamed from: c */
    public static void m5934c(C4181s5 c4181s5) {
        if (c4181s5 == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* JADX INFO: renamed from: p */
    public static void m5935p(AbstractC3974a5 abstractC3974a5) {
        if (abstractC3974a5 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (abstractC3974a5.f10542b) {
            return;
        }
        String strValueOf = String.valueOf(abstractC3974a5.getClass());
        throw new IllegalStateException(C1643a.m857j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    /* JADX INFO: renamed from: q */
    public static void m5936q(AbstractC4170r5 abstractC4170r5) {
        if (abstractC4170r5 == null) {
            throw new IllegalStateException("Component not created");
        }
        if (abstractC4170r5.m5856n()) {
            return;
        }
        String strValueOf = String.valueOf(abstractC4170r5.getClass());
        throw new IllegalStateException(C1643a.m857j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    /* JADX INFO: renamed from: A */
    public final C3968a m5937A() {
        C3968a c3968a = this.f11270r;
        if (c3968a != null) {
            return c3968a;
        }
        throw new IllegalStateException("Component not created");
    }

    @WorkerThread
    /* JADX INFO: renamed from: B */
    public final boolean m5938B() {
        return this.f11247B != null && this.f11247B.booleanValue();
    }

    /* JADX INFO: renamed from: a */
    public final C3992c m5939a() {
        return this.f11260h;
    }

    @WorkerThread
    /* JADX INFO: renamed from: d */
    public final boolean m5940d() {
        return m5941e() == 0;
    }

    @WorkerThread
    /* JADX INFO: renamed from: e */
    public final int m5941e() {
        mo5725f().mo5848b();
        if (this.f11260h.m5535x()) {
            return 1;
        }
        Boolean bool = this.f11249D;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (C3842t8.m5293b() && this.f11260h.m5526o(C4142p.f11035H0) && !m5942h()) {
            return 8;
        }
        Boolean boolM5580x = m5946o().m5580x();
        if (boolM5580x != null) {
            return boolM5580x.booleanValue() ? 0 : 3;
        }
        Boolean boolM5534w = this.f11260h.m5534w("firebase_analytics_collection_enabled");
        if (boolM5534w != null) {
            return boolM5534w.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.f11248C;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (C3295h.m4105a("isMeasurementExplicitlyDisabled").f9425e) {
            return 6;
        }
        return (!this.f11260h.m5526o(C4142p.f11053S) || this.f11247B == null || this.f11247B.booleanValue()) ? 0 : 7;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* JADX INFO: renamed from: f */
    public final C4169r4 mo5725f() {
        m5936q(this.f11263k);
        return this.f11263k;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* JADX INFO: renamed from: g */
    public final C4157q3 mo5726g() {
        m5936q(this.f11262j);
        return this.f11262j;
    }

    @WorkerThread
    /* JADX INFO: renamed from: h */
    public final boolean m5942h() {
        mo5725f().mo5848b();
        return this.f11250E;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* JADX INFO: renamed from: i */
    public final InterfaceC3400b mo5728i() {
        return this.f11267o;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* JADX INFO: renamed from: j */
    public final Context mo5729j() {
        return this.f11254b;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4192t5
    /* JADX INFO: renamed from: k */
    public final C4051ga mo5730k() {
        return this.f11259g;
    }

    /* JADX INFO: renamed from: l */
    public final void m5943l() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0035  */
    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    /* JADX WARN: Code duplicated, block: B:28:0x008f  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c3  */
    /* JADX WARN: Instruction removed from duplicated block: B:12:0x0035, please report this as an issue */
    @WorkerThread
    /* JADX INFO: renamed from: m */
    public final boolean m5944m() {
        boolean z2;
        Boolean boolValueOf;
        C4196t9 c4196t9M5949t;
        String str;
        String str2;
        C4124n3 c4124n3M5955z;
        boolean z3;
        if (!this.f11277y) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        mo5725f().mo5848b();
        Boolean bool = this.f11278z;
        if (bool == null || this.f11246A == 0) {
            Objects.requireNonNull((C3401c) this.f11267o);
            this.f11246A = SystemClock.elapsedRealtime();
            if (!m5949t().m5918p0("android.permission.INTERNET") && m5949t().m5918p0("android.permission.ACCESS_NETWORK_STATE") && (C3411b.m4376a(this.f11254b).m4375c() || this.f11260h.m5521C() || (C4125n4.m5761a(this.f11254b) && C4196t9.m5874U(this.f11254b)))) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolValueOf = Boolean.valueOf(z2);
            this.f11278z = boolValueOf;
            if (boolValueOf.booleanValue()) {
                c4196t9M5949t = m5949t();
                C4124n3 c4124n3M5955z2 = m5955z();
                c4124n3M5955z2.m5497t();
                str = c4124n3M5955z2.f10987k;
                C4124n3 c4124n3M5955z3 = m5955z();
                c4124n3M5955z3.m5497t();
                str2 = c4124n3M5955z3.f10988l;
                c4124n3M5955z = m5955z();
                c4124n3M5955z.m5497t();
                if (!c4196t9M5949t.m5911c0(str, str2, c4124n3M5955z.f10989m)) {
                    C4124n3 c4124n3M5955z4 = m5955z();
                    c4124n3M5955z4.m5497t();
                    z3 = TextUtils.isEmpty(c4124n3M5955z4.f10988l) ? false : true;
                }
                this.f11278z = Boolean.valueOf(z3);
            }
        } else if (!bool.booleanValue()) {
            Objects.requireNonNull((C3401c) this.f11267o);
            if (Math.abs(SystemClock.elapsedRealtime() - this.f11246A) > 1000) {
                Objects.requireNonNull((C3401c) this.f11267o);
                this.f11246A = SystemClock.elapsedRealtime();
                if (!m5949t().m5918p0("android.permission.INTERNET")) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                boolValueOf = Boolean.valueOf(z2);
                this.f11278z = boolValueOf;
                if (boolValueOf.booleanValue()) {
                    c4196t9M5949t = m5949t();
                    C4124n3 c4124n3M5955z5 = m5955z();
                    c4124n3M5955z5.m5497t();
                    str = c4124n3M5955z5.f10987k;
                    C4124n3 c4124n3M5955z6 = m5955z();
                    c4124n3M5955z6.m5497t();
                    str2 = c4124n3M5955z6.f10988l;
                    c4124n3M5955z = m5955z();
                    c4124n3M5955z.m5497t();
                    if (!c4196t9M5949t.m5911c0(str, str2, c4124n3M5955z.f10989m)) {
                        C4124n3 c4124n3M5955z7 = m5955z();
                        c4124n3M5955z7.m5497t();
                        if (TextUtils.isEmpty(c4124n3M5955z7.f10988l)) {
                        }
                    }
                    this.f11278z = Boolean.valueOf(z3);
                }
            }
        }
        return this.f11278z.booleanValue();
    }

    /* JADX INFO: renamed from: n */
    public final C4012d7 m5945n() {
        m5936q(this.f11271s);
        return this.f11271s;
    }

    /* JADX INFO: renamed from: o */
    public final C4009d4 m5946o() {
        m5934c(this.f11261i);
        return this.f11261i;
    }

    /* JADX INFO: renamed from: r */
    public final C4228w8 m5947r() {
        m5935p(this.f11264l);
        return this.f11264l;
    }

    /* JADX INFO: renamed from: s */
    public final C3999c6 m5948s() {
        m5935p(this.f11269q);
        return this.f11269q;
    }

    /* JADX INFO: renamed from: t */
    public final C4196t9 m5949t() {
        m5934c(this.f11265m);
        return this.f11265m;
    }

    /* JADX INFO: renamed from: u */
    public final C4135o3 m5950u() {
        m5934c(this.f11266n);
        return this.f11266n;
    }

    /* JADX INFO: renamed from: v */
    public final boolean m5951v() {
        return TextUtils.isEmpty(this.f11255c);
    }

    /* JADX INFO: renamed from: w */
    public final C4060h7 m5952w() {
        m5935p(this.f11268p);
        return this.f11268p;
    }

    /* JADX INFO: renamed from: x */
    public final C4161q7 m5953x() {
        m5935p(this.f11273u);
        return this.f11273u;
    }

    /* JADX INFO: renamed from: y */
    public final C4076j m5954y() {
        m5936q(this.f11274v);
        return this.f11274v;
    }

    /* JADX INFO: renamed from: z */
    public final C4124n3 m5955z() {
        m5935p(this.f11275w);
        return this.f11275w;
    }
}
