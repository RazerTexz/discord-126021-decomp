package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;
import p007b.p225i.p226a.p288f.p313h.p325l.C3630da;
import p007b.p225i.p226a.p288f.p313h.p325l.C3780ob;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3819rb;

/* JADX INFO: renamed from: b.i.a.f.i.b.q7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4161q7 extends AbstractC3974a5 {

    /* JADX INFO: renamed from: c */
    public final ServiceConnectionC4096k8 f11153c;

    /* JADX INFO: renamed from: d */
    public InterfaceC4068i3 f11154d;

    /* JADX INFO: renamed from: e */
    public volatile Boolean f11155e;

    /* JADX INFO: renamed from: f */
    public final AbstractC4064i f11156f;

    /* JADX INFO: renamed from: g */
    public final C4026e9 f11157g;

    /* JADX INFO: renamed from: h */
    public final List<Runnable> f11158h;

    /* JADX INFO: renamed from: i */
    public final AbstractC4064i f11159i;

    public C4161q7(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11158h = new ArrayList();
        this.f11157g = new C4026e9(c4202u4.f11267o);
        this.f11153c = new ServiceConnectionC4096k8(this);
        this.f11156f = new C4150p7(this, c4202u4);
        this.f11159i = new C4260z7(this, c4202u4);
    }

    /* JADX INFO: renamed from: x */
    public static void m5802x(C4161q7 c4161q7, ComponentName componentName) {
        c4161q7.mo5848b();
        if (c4161q7.f11154d != null) {
            c4161q7.f11154d = null;
            c4161q7.mo5726g().f11149n.m5861b("Disconnected from device MeasurementService", componentName);
            c4161q7.mo5848b();
            c4161q7.m5805C();
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: A */
    public final void m5803A(AtomicReference<String> atomicReference) {
        mo5848b();
        m5497t();
        m5814z(new RunnableC4216v7(this, atomicReference, m5811I(false)));
    }

    @WorkerThread
    /* JADX INFO: renamed from: B */
    public final boolean m5804B() {
        mo5848b();
        m5497t();
        return this.f11154d != null;
    }

    @WorkerThread
    /* JADX INFO: renamed from: C */
    public final void m5805C() {
        mo5848b();
        m5497t();
        if (m5804B()) {
            return;
        }
        if (m5809G()) {
            ServiceConnectionC4096k8 serviceConnectionC4096k8 = this.f11153c;
            serviceConnectionC4096k8.f10894l.mo5848b();
            Context context = serviceConnectionC4096k8.f10894l.f11202a.f11254b;
            synchronized (serviceConnectionC4096k8) {
                if (serviceConnectionC4096k8.f10892j) {
                    serviceConnectionC4096k8.f10894l.mo5726g().f11149n.m5860a("Connection attempt already in progress");
                    return;
                }
                if (serviceConnectionC4096k8.f10893k != null && (serviceConnectionC4096k8.f10893k.m4130e() || serviceConnectionC4096k8.f10893k.m4134j())) {
                    serviceConnectionC4096k8.f10894l.mo5726g().f11149n.m5860a("Already awaiting connection attempt");
                    return;
                }
                serviceConnectionC4096k8.f10893k = new C4168r3(context, Looper.getMainLooper(), serviceConnectionC4096k8, serviceConnectionC4096k8);
                serviceConnectionC4096k8.f10894l.mo5726g().f11149n.m5860a("Connecting to remote service");
                serviceConnectionC4096k8.f10892j = true;
                serviceConnectionC4096k8.f10893k.m4137q();
                return;
            }
        }
        if (this.f11202a.f11260h.m5521C()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = this.f11202a.f11254b.getPackageManager().queryIntentServices(new Intent().setClassName(this.f11202a.f11254b, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!(listQueryIntentServices != null && listQueryIntentServices.size() > 0)) {
            mo5726g().f11141f.m5860a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(this.f11202a.f11254b, "com.google.android.gms.measurement.AppMeasurementService"));
        ServiceConnectionC4096k8 serviceConnectionC4096k9 = this.f11153c;
        serviceConnectionC4096k9.f10894l.mo5848b();
        Context context2 = serviceConnectionC4096k9.f10894l.f11202a.f11254b;
        C3398a c3398aM4181b = C3398a.m4181b();
        synchronized (serviceConnectionC4096k9) {
            if (serviceConnectionC4096k9.f10892j) {
                serviceConnectionC4096k9.f10894l.mo5726g().f11149n.m5860a("Connection attempt already in progress");
                return;
            }
            serviceConnectionC4096k9.f10894l.mo5726g().f11149n.m5860a("Using local app measurement service");
            serviceConnectionC4096k9.f10892j = true;
            c3398aM4181b.m4182a(context2, intent, serviceConnectionC4096k9.f10894l.f11153c, Opcodes.LOR);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: D */
    public final void m5806D() {
        mo5848b();
        m5497t();
        ServiceConnectionC4096k8 serviceConnectionC4096k8 = this.f11153c;
        if (serviceConnectionC4096k8.f10893k != null && (serviceConnectionC4096k8.f10893k.m4134j() || serviceConnectionC4096k8.f10893k.m4130e())) {
            serviceConnectionC4096k8.f10893k.mo4036h();
        }
        serviceConnectionC4096k8.f10893k = null;
        try {
            C3398a.m4181b().m4183c(this.f11202a.f11254b, this.f11153c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f11154d = null;
    }

    @WorkerThread
    /* JADX INFO: renamed from: E */
    public final boolean m5807E() {
        mo5848b();
        m5497t();
        if (this.f11202a.f11260h.m5526o(C4142p.f11039J0)) {
            return !m5809G() || m5866e().m5928y0() >= C4142p.f11041K0.m5693a(null).intValue();
        }
        return false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: F */
    public final void m5808F() {
        mo5848b();
        C4026e9 c4026e9 = this.f11157g;
        Objects.requireNonNull((C3401c) c4026e9.f10696a);
        c4026e9.f10697b = SystemClock.elapsedRealtime();
        this.f11156f.m5663b(C4142p.f11038J.m5693a(null).longValue());
    }

    @WorkerThread
    /* JADX INFO: renamed from: G */
    public final boolean m5809G() throws PackageManager.NameNotFoundException {
        boolean z2;
        mo5848b();
        m5497t();
        if (this.f11155e == null) {
            mo5848b();
            m5497t();
            C4009d4 c4009d4M5867l = m5867l();
            c4009d4M5867l.mo5848b();
            boolean z3 = false;
            Boolean boolValueOf = !c4009d4M5867l.m5579w().contains("use_service") ? null : Boolean.valueOf(c4009d4M5867l.m5579w().getBoolean("use_service", false));
            boolean z4 = true;
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                C4124n3 c4124n3M5970o = m5970o();
                c4124n3M5970o.m5497t();
                if (c4124n3M5970o.f10986j == 1) {
                    z2 = true;
                } else {
                    mo5726g().f11149n.m5860a("Checking service availability");
                    C4196t9 c4196t9M5866e = m5866e();
                    Objects.requireNonNull(c4196t9M5866e);
                    int iMo4018b = C3256c.f9307b.mo4018b(c4196t9M5866e.f11202a.f11254b, 12451000);
                    if (iMo4018b != 0) {
                        if (iMo4018b == 1) {
                            mo5726g().f11149n.m5860a("Service missing");
                        } else if (iMo4018b != 2) {
                            if (iMo4018b == 3) {
                                mo5726g().f11144i.m5860a("Service disabled");
                            } else if (iMo4018b == 9) {
                                mo5726g().f11144i.m5860a("Service invalid");
                            } else if (iMo4018b != 18) {
                                mo5726g().f11144i.m5861b("Unexpected service status", Integer.valueOf(iMo4018b));
                            } else {
                                mo5726g().f11144i.m5860a("Service updating");
                            }
                            z4 = false;
                        } else {
                            mo5726g().f11148m.m5860a("Service container out of date");
                            if (m5866e().m5928y0() >= 17443) {
                                z4 = boolValueOf == null;
                                z2 = false;
                            }
                        }
                        z2 = z4;
                        z4 = false;
                    } else {
                        mo5726g().f11149n.m5860a("Service available");
                    }
                    z2 = true;
                }
                if (z4 || !this.f11202a.f11260h.m5521C()) {
                    z3 = z2;
                } else {
                    mo5726g().f11141f.m5860a("No way to upload. Consider using the full version of Analytics");
                }
                if (z3) {
                    C4009d4 c4009d4M5867l2 = m5867l();
                    c4009d4M5867l2.mo5848b();
                    SharedPreferences.Editor editorEdit = c4009d4M5867l2.m5579w().edit();
                    editorEdit.putBoolean("use_service", z4);
                    editorEdit.apply();
                }
            }
            this.f11155e = Boolean.valueOf(z4);
        }
        return this.f11155e.booleanValue();
    }

    @WorkerThread
    /* JADX INFO: renamed from: H */
    public final void m5810H() {
        mo5848b();
        mo5726g().f11149n.m5861b("Processing queued up service tasks", Integer.valueOf(this.f11158h.size()));
        Iterator<Runnable> it = this.f11158h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                mo5726g().f11141f.m5861b("Task exception while flushing queue", e);
            }
        }
        this.f11158h.clear();
        this.f11159i.m5664c();
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0237  */
    @Nullable
    @WorkerThread
    /* JADX INFO: renamed from: I */
    public final zzn m5811I(boolean z2) {
        boolean z3;
        String str;
        List<String> list;
        long j;
        String str2;
        String strM5568d;
        long j2;
        C4124n3 c4124n3M5970o = m5970o();
        String strM5796E = z2 ? mo5726g().m5796E() : null;
        c4124n3M5970o.mo5848b();
        c4124n3M5970o.m5497t();
        String str3 = c4124n3M5970o.f10979c;
        c4124n3M5970o.m5497t();
        String str4 = c4124n3M5970o.f10987k;
        c4124n3M5970o.m5497t();
        String str5 = c4124n3M5970o.f10980d;
        c4124n3M5970o.m5497t();
        long j3 = c4124n3M5970o.f10981e;
        c4124n3M5970o.m5497t();
        String str6 = c4124n3M5970o.f10982f;
        c4124n3M5970o.m5497t();
        c4124n3M5970o.mo5848b();
        if (c4124n3M5970o.f10983g == 0) {
            C4196t9 c4196t9M5949t = c4124n3M5970o.f11202a.m5949t();
            Context context = c4124n3M5970o.f11202a.f11254b;
            String packageName = context.getPackageName();
            c4196t9M5949t.mo5848b();
            C1460d.m583w(packageName);
            PackageManager packageManager = context.getPackageManager();
            MessageDigest messageDigestM5889x0 = C4196t9.m5889x0();
            long jM5888w = -1;
            if (messageDigestM5889x0 == null) {
                c4196t9M5949t.mo5726g().f11141f.m5860a("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (!c4196t9M5949t.m5917o0(context, packageName)) {
                            Signature[] signatureArr = C3411b.m4376a(context).m4374b(c4196t9M5949t.f11202a.f11254b.getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                c4196t9M5949t.mo5726g().f11144i.m5860a("Could not get signatures");
                            } else {
                                jM5888w = C4196t9.m5888w(messageDigestM5889x0.digest(signatureArr[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        c4196t9M5949t.mo5726g().f11141f.m5861b("Package name not found", e);
                    }
                    c4124n3M5970o.f10983g = j2;
                }
                j2 = 0;
                c4124n3M5970o.f10983g = j2;
            }
            j2 = jM5888w;
            c4124n3M5970o.f10983g = j2;
        }
        long j4 = c4124n3M5970o.f10983g;
        boolean zM5940d = c4124n3M5970o.f11202a.m5940d();
        boolean z4 = !c4124n3M5970o.m5867l().f10653w;
        c4124n3M5970o.mo5848b();
        if (c4124n3M5970o.f11202a.m5940d()) {
            if (((InterfaceC3819rb) C3780ob.f10185j.mo4555a()).mo5196a() && c4124n3M5970o.f11202a.f11260h.m5526o(C4142p.f11084l0)) {
                c4124n3M5970o.mo5726g().f11149n.m5860a("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = c4124n3M5970o.f11202a.f11254b.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            Method declaredMethod = clsLoadClass.getDeclaredMethod("getInstance", Context.class);
                            Object[] objArr = new Object[1];
                            z3 = zM5940d;
                            try {
                                objArr[0] = c4124n3M5970o.f11202a.f11254b;
                                Object objInvoke = declaredMethod.invoke(null, objArr);
                                if (objInvoke == null) {
                                    str = null;
                                } else {
                                    try {
                                        str = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                                    } catch (Exception unused) {
                                        c4124n3M5970o.mo5726g().f11146k.m5860a("Failed to retrieve Firebase Instance Id");
                                        str = null;
                                    }
                                }
                            } catch (Exception unused2) {
                                c4124n3M5970o.mo5726g().f11145j.m5860a("Failed to obtain Firebase Analytics instance");
                            }
                        } catch (Exception unused3) {
                            z3 = zM5940d;
                        }
                    }
                } catch (ClassNotFoundException unused4) {
                }
                str = null;
            }
            z3 = zM5940d;
            str = null;
        } else {
            z3 = zM5940d;
            str = null;
        }
        C4202u4 c4202u4 = c4124n3M5970o.f11202a;
        Long lValueOf = Long.valueOf(c4202u4.m5946o().f10641k.m5648a());
        long jMin = lValueOf.longValue() == 0 ? c4202u4.f11253H : Math.min(c4202u4.f11253H, lValueOf.longValue());
        c4124n3M5970o.m5497t();
        int i = c4124n3M5970o.f10986j;
        boolean zBooleanValue = c4124n3M5970o.f11202a.f11260h.m5536y().booleanValue();
        Boolean boolM5534w = c4124n3M5970o.f11202a.f11260h.m5534w("google_analytics_ssaid_collection_enabled");
        boolean zBooleanValue2 = Boolean.valueOf(boolM5534w == null || boolM5534w.booleanValue()).booleanValue();
        C4009d4 c4009d4M5867l = c4124n3M5970o.m5867l();
        c4009d4M5867l.mo5848b();
        boolean z5 = c4009d4M5867l.m5579w().getBoolean("deferred_analytics_collection", false);
        c4124n3M5970o.m5497t();
        String str7 = c4124n3M5970o.f10988l;
        Boolean boolM5534w2 = c4124n3M5970o.f11202a.f11260h.m5534w("google_analytics_default_allow_ad_personalization_signals");
        Boolean boolValueOf = boolM5534w2 == null ? null : Boolean.valueOf(!boolM5534w2.booleanValue());
        long j5 = c4124n3M5970o.f10984h;
        List<String> list2 = c4124n3M5970o.f10985i;
        if (C3630da.m4644b()) {
            list = list2;
            j = j5;
            if (c4124n3M5970o.f11202a.f11260h.m5526o(C4142p.f11080j0)) {
                c4124n3M5970o.m5497t();
                str2 = c4124n3M5970o.f10989m;
            }
            if (C3842t8.m5293b() || !c4124n3M5970o.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
                strM5568d = "";
            } else {
                strM5568d = c4124n3M5970o.m5867l().m5581y().m5568d();
            }
            return new zzn(str3, str4, str5, j3, str6, 33025L, j4, strM5796E, z3, z4, str, 0L, jMin, i, zBooleanValue, zBooleanValue2, z5, str7, boolValueOf, j, list, str2, strM5568d);
        }
        list = list2;
        j = j5;
        str2 = null;
        if (C3842t8.m5293b()) {
            strM5568d = "";
        } else {
            strM5568d = "";
        }
        return new zzn(str3, str4, str5, j3, str6, 33025L, j4, strM5796E, z3, z4, str, 0L, jMin, i, zBooleanValue, zBooleanValue2, z5, str7, boolValueOf, j, list, str2, strM5568d);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC3974a5
    /* JADX INFO: renamed from: v */
    public final boolean mo5499v() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x01df  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:122:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:124:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:130:0x0210  */
    /* JADX WARN: Code duplicated, block: B:132:0x0215  */
    /* JADX WARN: Code duplicated, block: B:135:0x0222  */
    /* JADX WARN: Code duplicated, block: B:137:0x0227  */
    /* JADX WARN: Code duplicated, block: B:205:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:207:0x0218 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:209:0x0218 A[SYNTHETIC] */
    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final void m5812w(InterfaceC4068i3 interfaceC4068i3, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) throws Throwable {
        ArrayList arrayList;
        int size;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabaseM5754A;
        Cursor cursor;
        Cursor cursorQuery;
        String str;
        String[] strArr;
        zzz zzzVarCreateFromParcel;
        zzku zzkuVarCreateFromParcel;
        mo5848b();
        m5497t();
        int i = 100;
        int i2 = 0;
        int i3 = 100;
        int i4 = 0;
        while (i4 < 1001 && i3 == i) {
            ArrayList arrayList2 = new ArrayList();
            C4113m3 c4113m3M5973r = m5973r();
            c4113m3M5973r.mo5848b();
            if (c4113m3M5973r.f10962d) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                if (c4113m3M5973r.f11202a.f11254b.getDatabasePath("google_app_measurement_local.db").exists()) {
                    int i5 = 5;
                    int i6 = 0;
                    int i7 = 5;
                    while (true) {
                        if (i6 < i5) {
                            try {
                                sQLiteDatabaseM5754A = c4113m3M5973r.m5754A();
                                if (sQLiteDatabaseM5754A == null) {
                                    try {
                                        c4113m3M5973r.f10962d = true;
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        arrayList = null;
                                    } catch (SQLiteDatabaseLockedException unused) {
                                        cursorQuery = null;
                                        SystemClock.sleep(i7);
                                        i7 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteFullException e) {
                                        e = e;
                                        cursorQuery = null;
                                        c4113m3M5973r.mo5726g().f11141f.m5861b("Error reading entries from local database", e);
                                        c4113m3M5973r.f10962d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        cursorQuery = null;
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.endTransaction();
                                        }
                                        c4113m3M5973r.mo5726g().f11141f.m5861b("Error reading entries from local database", e);
                                        c4113m3M5973r.f10962d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (Throwable th) {
                                        th = th;
                                        sQLiteDatabase = sQLiteDatabaseM5754A;
                                        cursor = null;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th;
                                    }
                                } else {
                                    sQLiteDatabaseM5754A.beginTransaction();
                                    long jM5753w = C4113m3.m5753w(sQLiteDatabaseM5754A);
                                    long j = -1;
                                    if (jM5753w != -1) {
                                        String[] strArr2 = new String[1];
                                        strArr2[i2] = String.valueOf(jM5753w);
                                        str = "rowid<?";
                                        strArr = strArr2;
                                    } else {
                                        str = null;
                                        strArr = null;
                                    }
                                    cursorQuery = sQLiteDatabaseM5754A.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(i));
                                    while (cursorQuery.moveToNext()) {
                                        try {
                                            try {
                                                j = cursorQuery.getLong(i2);
                                                int i8 = cursorQuery.getInt(1);
                                                byte[] blob = cursorQuery.getBlob(2);
                                                if (i8 == 0) {
                                                    Parcel parcelObtain = Parcel.obtain();
                                                    try {
                                                        try {
                                                            parcelObtain.unmarshall(blob, i2, blob.length);
                                                            parcelObtain.setDataPosition(i2);
                                                            zzaq zzaqVarCreateFromParcel = zzaq.CREATOR.createFromParcel(parcelObtain);
                                                            parcelObtain.recycle();
                                                            if (zzaqVarCreateFromParcel != null) {
                                                                arrayList3.add(zzaqVarCreateFromParcel);
                                                            }
                                                        } catch (SafeParcelReader$ParseException unused2) {
                                                            c4113m3M5973r.mo5726g().f11141f.m5860a("Failed to load event from local database");
                                                            parcelObtain.recycle();
                                                        }
                                                    } catch (Throwable th2) {
                                                        parcelObtain.recycle();
                                                        throw th2;
                                                    }
                                                } else if (i8 == 1) {
                                                    Parcel parcelObtain2 = Parcel.obtain();
                                                    try {
                                                        try {
                                                            parcelObtain2.unmarshall(blob, i2, blob.length);
                                                            parcelObtain2.setDataPosition(i2);
                                                            zzkuVarCreateFromParcel = zzku.CREATOR.createFromParcel(parcelObtain2);
                                                            parcelObtain2.recycle();
                                                        } catch (SafeParcelReader$ParseException unused3) {
                                                            c4113m3M5973r.mo5726g().f11141f.m5860a("Failed to load user property from local database");
                                                            parcelObtain2.recycle();
                                                            zzkuVarCreateFromParcel = null;
                                                        }
                                                        if (zzkuVarCreateFromParcel != null) {
                                                            arrayList3.add(zzkuVarCreateFromParcel);
                                                        }
                                                    } catch (Throwable th3) {
                                                        parcelObtain2.recycle();
                                                        throw th3;
                                                    }
                                                } else if (i8 == 2) {
                                                    Parcel parcelObtain3 = Parcel.obtain();
                                                    try {
                                                        try {
                                                            parcelObtain3.unmarshall(blob, i2, blob.length);
                                                            parcelObtain3.setDataPosition(i2);
                                                            zzzVarCreateFromParcel = zzz.CREATOR.createFromParcel(parcelObtain3);
                                                            parcelObtain3.recycle();
                                                        } catch (SafeParcelReader$ParseException unused4) {
                                                            c4113m3M5973r.mo5726g().f11141f.m5860a("Failed to load conditional user property from local database");
                                                            parcelObtain3.recycle();
                                                            zzzVarCreateFromParcel = null;
                                                        }
                                                        if (zzzVarCreateFromParcel != null) {
                                                            arrayList3.add(zzzVarCreateFromParcel);
                                                        }
                                                    } catch (Throwable th4) {
                                                        parcelObtain3.recycle();
                                                        throw th4;
                                                    }
                                                } else if (i8 == 3) {
                                                    c4113m3M5973r.mo5726g().f11144i.m5860a("Skipping app launch break");
                                                } else {
                                                    c4113m3M5973r.mo5726g().f11141f.m5860a("Unknown record type in local database");
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                sQLiteDatabase = sQLiteDatabaseM5754A;
                                                cursor = cursorQuery;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                throw th;
                                            }
                                        } catch (SQLiteDatabaseLockedException unused5) {
                                        } catch (SQLiteFullException e3) {
                                            e = e3;
                                        } catch (SQLiteException e4) {
                                            e = e4;
                                        }
                                    }
                                    String[] strArr3 = new String[1];
                                    try {
                                        strArr3[0] = Long.toString(j);
                                        if (sQLiteDatabaseM5754A.delete("messages", "rowid <= ?", strArr3) < arrayList3.size()) {
                                            c4113m3M5973r.mo5726g().f11141f.m5860a("Fewer entries removed from local database than expected");
                                        }
                                        sQLiteDatabaseM5754A.setTransactionSuccessful();
                                        sQLiteDatabaseM5754A.endTransaction();
                                        cursorQuery.close();
                                        sQLiteDatabaseM5754A.close();
                                        arrayList = arrayList3;
                                    } catch (SQLiteDatabaseLockedException unused6) {
                                        SystemClock.sleep(i7);
                                        i7 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteFullException e5) {
                                        e = e5;
                                        c4113m3M5973r.mo5726g().f11141f.m5861b("Error reading entries from local database", e);
                                        c4113m3M5973r.f10962d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteException e6) {
                                        e = e6;
                                        if (sQLiteDatabaseM5754A != null && sQLiteDatabaseM5754A.inTransaction()) {
                                            sQLiteDatabaseM5754A.endTransaction();
                                        }
                                        c4113m3M5973r.mo5726g().f11141f.m5861b("Error reading entries from local database", e);
                                        c4113m3M5973r.f10962d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseM5754A != null) {
                                            sQLiteDatabaseM5754A.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    }
                                }
                            } catch (SQLiteDatabaseLockedException unused7) {
                                sQLiteDatabaseM5754A = null;
                            } catch (SQLiteFullException e7) {
                                e = e7;
                                sQLiteDatabaseM5754A = null;
                            } catch (SQLiteException e8) {
                                e = e8;
                                sQLiteDatabaseM5754A = null;
                            } catch (Throwable th6) {
                                th = th6;
                                sQLiteDatabase = null;
                            }
                        } else {
                            c4113m3M5973r.mo5726g().f11144i.m5860a("Failed to read events from database in reasonable time");
                            arrayList = null;
                        }
                        i6++;
                        i = 100;
                        i2 = 0;
                        i5 = 5;
                    }
                } else {
                    arrayList = arrayList3;
                }
            }
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
                size = arrayList.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList2.add(abstractSafeParcelable);
            }
            int size2 = arrayList2.size();
            int i9 = 0;
            while (i9 < size2) {
                int i10 = i9 + 1;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList2.get(i9);
                if (abstractSafeParcelable2 instanceof zzaq) {
                    try {
                        interfaceC4068i3.mo5675l0((zzaq) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e9) {
                        mo5726g().f11141f.m5861b("Failed to send event to the service", e9);
                    }
                } else if (abstractSafeParcelable2 instanceof zzku) {
                    try {
                        interfaceC4068i3.mo5678p0((zzku) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e10) {
                        mo5726g().f11141f.m5861b("Failed to send user property to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzz) {
                    try {
                        interfaceC4068i3.mo5679q0((zzz) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e11) {
                        mo5726g().f11141f.m5861b("Failed to send conditional user property to the service", e11);
                    }
                } else {
                    mo5726g().f11141f.m5860a("Discarding data. Unrecognized parcel type.");
                }
                i9 = i10;
            }
            i4++;
            i3 = size;
            i = 100;
            i2 = 0;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: y */
    public final void m5813y(zzz zzzVar) {
        boolean zM5755x;
        mo5848b();
        m5497t();
        C4113m3 c4113m3M5973r = m5973r();
        c4113m3M5973r.m5866e();
        byte[] bArrM5880g0 = C4196t9.m5880g0(zzzVar);
        if (bArrM5880g0.length > 131072) {
            c4113m3M5973r.mo5726g().f11142g.m5860a("Conditional user property too long for local database. Sending directly to service");
            zM5755x = false;
        } else {
            zM5755x = c4113m3M5973r.m5755x(2, bArrM5880g0);
        }
        m5814z(new RunnableC4049g8(this, zM5755x, new zzz(zzzVar), m5811I(true), zzzVar));
    }

    @WorkerThread
    /* JADX INFO: renamed from: z */
    public final void m5814z(Runnable runnable) throws IllegalStateException {
        mo5848b();
        if (m5804B()) {
            runnable.run();
        } else {
            if (this.f11158h.size() >= 1000) {
                mo5726g().f11141f.m5860a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f11158h.add(runnable);
            this.f11159i.m5663b(60000L);
            m5805C();
        }
    }
}
