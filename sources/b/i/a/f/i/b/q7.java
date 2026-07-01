package b.i.a.f.i.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences$Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
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
import b.i.a.f.h.l.ob;
import b.i.a.f.h.l.rb;
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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q7 extends a5 {
    public final k8 c;
    public i3 d;
    public volatile Boolean e;
    public final i f;
    public final e9 g;
    public final List<Runnable> h;
    public final i i;

    public q7(u4 u4Var) {
        super(u4Var);
        this.h = new ArrayList();
        this.g = new e9(u4Var.o);
        this.c = new k8(this);
        this.f = new p7(this, u4Var);
        this.i = new z7(this, u4Var);
    }

    public static void x(q7 q7Var, ComponentName componentName) {
        q7Var.b();
        if (q7Var.d != null) {
            q7Var.d = null;
            q7Var.g().n.b("Disconnected from device MeasurementService", componentName);
            q7Var.b();
            q7Var.C();
        }
    }

    @WorkerThread
    public final void A(AtomicReference<String> atomicReference) {
        b();
        t();
        z(new v7(this, atomicReference, I(false)));
    }

    @WorkerThread
    public final boolean B() {
        b();
        t();
        return this.d != null;
    }

    @WorkerThread
    public final void C() {
        b();
        t();
        if (B()) {
            return;
        }
        if (G()) {
            k8 k8Var = this.c;
            k8Var.l.b();
            Context context = k8Var.l.a.f1570b;
            synchronized (k8Var) {
                if (k8Var.j) {
                    k8Var.l.g().n.a("Connection attempt already in progress");
                    return;
                }
                if (k8Var.k != null && (k8Var.k.e() || k8Var.k.j())) {
                    k8Var.l.g().n.a("Already awaiting connection attempt");
                    return;
                }
                k8Var.k = new r3(context, Looper.getMainLooper(), k8Var, k8Var);
                k8Var.l.g().n.a("Connecting to remote service");
                k8Var.j = true;
                k8Var.k.q();
                return;
            }
        }
        if (this.a.h.C()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = this.a.f1570b.getPackageManager().queryIntentServices(new Intent().setClassName(this.a.f1570b, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (!(listQueryIntentServices != null && listQueryIntentServices.size() > 0)) {
            g().f.a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(this.a.f1570b, "com.google.android.gms.measurement.AppMeasurementService"));
        k8 k8Var2 = this.c;
        k8Var2.l.b();
        Context context2 = k8Var2.l.a.f1570b;
        b.i.a.f.e.n.a aVarB = b.i.a.f.e.n.a.b();
        synchronized (k8Var2) {
            if (k8Var2.j) {
                k8Var2.l.g().n.a("Connection attempt already in progress");
                return;
            }
            k8Var2.l.g().n.a("Using local app measurement service");
            k8Var2.j = true;
            aVarB.a(context2, intent, k8Var2.l.c, Opcodes.LOR);
        }
    }

    @WorkerThread
    public final void D() {
        b();
        t();
        k8 k8Var = this.c;
        if (k8Var.k != null && (k8Var.k.j() || k8Var.k.e())) {
            k8Var.k.h();
        }
        k8Var.k = null;
        try {
            b.i.a.f.e.n.a.b().c(this.a.f1570b, this.c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.d = null;
    }

    @WorkerThread
    public final boolean E() {
        b();
        t();
        if (this.a.h.o(p.J0)) {
            return !G() || e().y0() >= p.K0.a(null).intValue();
        }
        return false;
    }

    @WorkerThread
    public final void F() {
        b();
        e9 e9Var = this.g;
        Objects.requireNonNull((b.i.a.f.e.o.c) e9Var.a);
        e9Var.f1530b = SystemClock.elapsedRealtime();
        this.f.b(p.J.a(null).longValue());
    }

    @WorkerThread
    public final boolean G() throws PackageManager$NameNotFoundException {
        boolean z2;
        b();
        t();
        if (this.e == null) {
            b();
            t();
            d4 d4VarL = l();
            d4VarL.b();
            boolean z3 = false;
            Boolean boolValueOf = !d4VarL.w().contains("use_service") ? null : Boolean.valueOf(d4VarL.w().getBoolean("use_service", false));
            boolean z4 = true;
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                n3 n3VarO = o();
                n3VarO.t();
                if (n3VarO.j == 1) {
                    z2 = true;
                } else {
                    g().n.a("Checking service availability");
                    t9 t9VarE = e();
                    Objects.requireNonNull(t9VarE);
                    int iB = b.i.a.f.e.c.f1346b.b(t9VarE.a.f1570b, 12451000);
                    if (iB != 0) {
                        if (iB == 1) {
                            g().n.a("Service missing");
                        } else if (iB != 2) {
                            if (iB == 3) {
                                g().i.a("Service disabled");
                            } else if (iB == 9) {
                                g().i.a("Service invalid");
                            } else if (iB != 18) {
                                g().i.b("Unexpected service status", Integer.valueOf(iB));
                            } else {
                                g().i.a("Service updating");
                            }
                            z4 = false;
                        } else {
                            g().m.a("Service container out of date");
                            if (e().y0() >= 17443) {
                                z4 = boolValueOf == null;
                                z2 = false;
                            }
                        }
                        z2 = z4;
                        z4 = false;
                    } else {
                        g().n.a("Service available");
                    }
                    z2 = true;
                }
                if (z4 || !this.a.h.C()) {
                    z3 = z2;
                } else {
                    g().f.a("No way to upload. Consider using the full version of Analytics");
                }
                if (z3) {
                    d4 d4VarL2 = l();
                    d4VarL2.b();
                    SharedPreferences$Editor sharedPreferences$EditorEdit = d4VarL2.w().edit();
                    sharedPreferences$EditorEdit.putBoolean("use_service", z4);
                    sharedPreferences$EditorEdit.apply();
                }
            }
            this.e = Boolean.valueOf(z4);
        }
        return this.e.booleanValue();
    }

    @WorkerThread
    public final void H() {
        b();
        g().n.b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        Iterator<Runnable> it = this.h.iterator();
        while (it.hasNext()) {
            try {
                it.next().run();
            } catch (Exception e) {
                g().f.b("Task exception while flushing queue", e);
            }
        }
        this.h.clear();
        this.i.c();
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0237  */
    @Nullable
    @WorkerThread
    public final zzn I(boolean z2) {
        boolean z3;
        String str;
        List<String> list;
        long j;
        String str2;
        String strD;
        long j2;
        n3 n3VarO = o();
        String strE = z2 ? g().E() : null;
        n3VarO.b();
        n3VarO.t();
        String str3 = n3VarO.c;
        n3VarO.t();
        String str4 = n3VarO.k;
        n3VarO.t();
        String str5 = n3VarO.d;
        n3VarO.t();
        long j3 = n3VarO.e;
        n3VarO.t();
        String str6 = n3VarO.f;
        n3VarO.t();
        n3VarO.b();
        if (n3VarO.g == 0) {
            t9 t9VarT = n3VarO.a.t();
            Context context = n3VarO.a.f1570b;
            String packageName = context.getPackageName();
            t9VarT.b();
            b.c.a.a0.d.w(packageName);
            PackageManager packageManager = context.getPackageManager();
            MessageDigest messageDigestX0 = t9.x0();
            long jW = -1;
            if (messageDigestX0 == null) {
                t9VarT.g().f.a("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (!t9VarT.o0(context, packageName)) {
                            Signature[] signatureArr = b.i.a.f.e.p.b.a(context).b(t9VarT.a.f1570b.getPackageName(), 64).signatures;
                            if (signatureArr == null || signatureArr.length <= 0) {
                                t9VarT.g().i.a("Could not get signatures");
                            } else {
                                jW = t9.w(messageDigestX0.digest(signatureArr[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager$NameNotFoundException e) {
                        t9VarT.g().f.b("Package name not found", e);
                    }
                    n3VarO.g = j2;
                }
                j2 = 0;
                n3VarO.g = j2;
            }
            j2 = jW;
            n3VarO.g = j2;
        }
        long j4 = n3VarO.g;
        boolean zD = n3VarO.a.d();
        boolean z4 = !n3VarO.l().w;
        n3VarO.b();
        if (n3VarO.a.d()) {
            if (((rb) ob.j.a()).a() && n3VarO.a.h.o(p.l0)) {
                n3VarO.g().n.a("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = n3VarO.a.f1570b.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            Method declaredMethod = clsLoadClass.getDeclaredMethod("getInstance", Context.class);
                            Object[] objArr = new Object[1];
                            z3 = zD;
                            try {
                                objArr[0] = n3VarO.a.f1570b;
                                Object objInvoke = declaredMethod.invoke(null, objArr);
                                if (objInvoke == null) {
                                    str = null;
                                } else {
                                    try {
                                        str = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                                    } catch (Exception unused) {
                                        n3VarO.g().k.a("Failed to retrieve Firebase Instance Id");
                                        str = null;
                                    }
                                }
                            } catch (Exception unused2) {
                                n3VarO.g().j.a("Failed to obtain Firebase Analytics instance");
                            }
                        } catch (Exception unused3) {
                            z3 = zD;
                        }
                    }
                } catch (ClassNotFoundException unused4) {
                }
                str = null;
            }
            z3 = zD;
            str = null;
        } else {
            z3 = zD;
            str = null;
        }
        u4 u4Var = n3VarO.a;
        Long lValueOf = Long.valueOf(u4Var.o().k.a());
        long jMin = lValueOf.longValue() == 0 ? u4Var.H : Math.min(u4Var.H, lValueOf.longValue());
        n3VarO.t();
        int i = n3VarO.j;
        boolean zBooleanValue = n3VarO.a.h.y().booleanValue();
        Boolean boolW = n3VarO.a.h.w("google_analytics_ssaid_collection_enabled");
        boolean zBooleanValue2 = Boolean.valueOf(boolW == null || boolW.booleanValue()).booleanValue();
        d4 d4VarL = n3VarO.l();
        d4VarL.b();
        boolean z5 = d4VarL.w().getBoolean("deferred_analytics_collection", false);
        n3VarO.t();
        String str7 = n3VarO.l;
        Boolean boolW2 = n3VarO.a.h.w("google_analytics_default_allow_ad_personalization_signals");
        Boolean boolValueOf = boolW2 == null ? null : Boolean.valueOf(!boolW2.booleanValue());
        long j5 = n3VarO.h;
        List<String> list2 = n3VarO.i;
        if (b.i.a.f.h.l.da.b()) {
            list = list2;
            j = j5;
            if (n3VarO.a.h.o(p.f1561j0)) {
                n3VarO.t();
                str2 = n3VarO.m;
            }
            if (b.i.a.f.h.l.t8.b() || !n3VarO.a.h.o(p.H0)) {
                strD = "";
            } else {
                strD = n3VarO.l().y().d();
            }
            return new zzn(str3, str4, str5, j3, str6, 33025L, j4, strE, z3, z4, str, 0L, jMin, i, zBooleanValue, zBooleanValue2, z5, str7, boolValueOf, j, list, str2, strD);
        }
        list = list2;
        j = j5;
        str2 = null;
        if (b.i.a.f.h.l.t8.b()) {
            strD = "";
        } else {
            strD = "";
        }
        return new zzn(str3, str4, str5, j3, str6, 33025L, j4, strE, z3, z4, str, 0L, jMin, i, zBooleanValue, zBooleanValue2, z5, str7, boolValueOf, j, list, str2, strD);
    }

    @Override // b.i.a.f.i.b.a5
    public final boolean v() {
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
    public final void w(i3 i3Var, AbstractSafeParcelable abstractSafeParcelable, zzn zznVar) throws Throwable {
        ArrayList arrayList;
        int size;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursor;
        Cursor cursorQuery;
        String str;
        String[] strArr;
        zzz zzzVarCreateFromParcel;
        zzku zzkuVarCreateFromParcel;
        b();
        t();
        int i = 100;
        int i2 = 0;
        int i3 = 100;
        int i4 = 0;
        while (i4 < 1001 && i3 == i) {
            ArrayList arrayList2 = new ArrayList();
            m3 m3VarR = r();
            m3VarR.b();
            if (m3VarR.d) {
                arrayList = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                if (m3VarR.a.f1570b.getDatabasePath("google_app_measurement_local.db").exists()) {
                    int i5 = 5;
                    int i6 = 0;
                    int i7 = 5;
                    while (true) {
                        if (i6 < i5) {
                            try {
                                sQLiteDatabaseA = m3VarR.A();
                                if (sQLiteDatabaseA == null) {
                                    try {
                                        m3VarR.d = true;
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        arrayList = null;
                                    } catch (SQLiteDatabaseLockedException unused) {
                                        cursorQuery = null;
                                        SystemClock.sleep(i7);
                                        i7 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteFullException e) {
                                        e = e;
                                        cursorQuery = null;
                                        m3VarR.g().f.b("Error reading entries from local database", e);
                                        m3VarR.d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        cursorQuery = null;
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                        m3VarR.g().f.b("Error reading entries from local database", e);
                                        m3VarR.d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (Throwable th) {
                                        th = th;
                                        sQLiteDatabase = sQLiteDatabaseA;
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
                                    sQLiteDatabaseA.beginTransaction();
                                    long jW = m3.w(sQLiteDatabaseA);
                                    long j = -1;
                                    if (jW != -1) {
                                        String[] strArr2 = new String[1];
                                        strArr2[i2] = String.valueOf(jW);
                                        str = "rowid<?";
                                        strArr = strArr2;
                                    } else {
                                        str = null;
                                        strArr = null;
                                    }
                                    cursorQuery = sQLiteDatabaseA.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(i));
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
                                                            m3VarR.g().f.a("Failed to load event from local database");
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
                                                            m3VarR.g().f.a("Failed to load user property from local database");
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
                                                            m3VarR.g().f.a("Failed to load conditional user property from local database");
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
                                                    m3VarR.g().i.a("Skipping app launch break");
                                                } else {
                                                    m3VarR.g().f.a("Unknown record type in local database");
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                sQLiteDatabase = sQLiteDatabaseA;
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
                                        if (sQLiteDatabaseA.delete("messages", "rowid <= ?", strArr3) < arrayList3.size()) {
                                            m3VarR.g().f.a("Fewer entries removed from local database than expected");
                                        }
                                        sQLiteDatabaseA.setTransactionSuccessful();
                                        sQLiteDatabaseA.endTransaction();
                                        cursorQuery.close();
                                        sQLiteDatabaseA.close();
                                        arrayList = arrayList3;
                                    } catch (SQLiteDatabaseLockedException unused6) {
                                        SystemClock.sleep(i7);
                                        i7 += 20;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteFullException e5) {
                                        e = e5;
                                        m3VarR.g().f.b("Error reading entries from local database", e);
                                        m3VarR.d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    } catch (SQLiteException e6) {
                                        e = e6;
                                        if (sQLiteDatabaseA != null && sQLiteDatabaseA.inTransaction()) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                        m3VarR.g().f.b("Error reading entries from local database", e);
                                        m3VarR.d = true;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.close();
                                        }
                                        i6++;
                                        i = 100;
                                        i2 = 0;
                                        i5 = 5;
                                    }
                                }
                            } catch (SQLiteDatabaseLockedException unused7) {
                                sQLiteDatabaseA = null;
                            } catch (SQLiteFullException e7) {
                                e = e7;
                                sQLiteDatabaseA = null;
                            } catch (SQLiteException e8) {
                                e = e8;
                                sQLiteDatabaseA = null;
                            } catch (Throwable th6) {
                                th = th6;
                                sQLiteDatabase = null;
                            }
                        } else {
                            m3VarR.g().i.a("Failed to read events from database in reasonable time");
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
                        i3Var.l0((zzaq) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e9) {
                        g().f.b("Failed to send event to the service", e9);
                    }
                } else if (abstractSafeParcelable2 instanceof zzku) {
                    try {
                        i3Var.p0((zzku) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e10) {
                        g().f.b("Failed to send user property to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzz) {
                    try {
                        i3Var.q0((zzz) abstractSafeParcelable2, zznVar);
                    } catch (RemoteException e11) {
                        g().f.b("Failed to send conditional user property to the service", e11);
                    }
                } else {
                    g().f.a("Discarding data. Unrecognized parcel type.");
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
    public final void y(zzz zzzVar) {
        boolean zX;
        b();
        t();
        m3 m3VarR = r();
        m3VarR.e();
        byte[] bArrG0 = t9.g0(zzzVar);
        if (bArrG0.length > 131072) {
            m3VarR.g().g.a("Conditional user property too long for local database. Sending directly to service");
            zX = false;
        } else {
            zX = m3VarR.x(2, bArrG0);
        }
        z(new g8(this, zX, new zzz(zzzVar), I(true), zzzVar));
    }

    @WorkerThread
    public final void z(Runnable runnable) throws IllegalStateException {
        b();
        if (B()) {
            runnable.run();
        } else {
            if (this.h.size() >= 1000) {
                g().f.a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.h.add(runnable);
            this.i.b(60000L);
            C();
        }
    }
}
