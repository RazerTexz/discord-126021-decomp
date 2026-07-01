package b.i.a.f.i.b;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.l.a1;
import b.i.a.f.h.l.c1;
import b.i.a.f.h.l.d1;
import b.i.a.f.h.l.e1;
import b.i.a.f.h.l.hb;
import b.i.a.f.h.l.i1;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class k9 implements t5 {
    public static volatile k9 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p4 f1542b;
    public x3 c;
    public g d;
    public b4 e;
    public h9 f;
    public ba g;
    public final q9 h;
    public g7 i;
    public q8 j;
    public final u4 k;
    public boolean m;
    public long n;
    public List<Runnable> o;
    public int p;
    public int q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1543s;
    public boolean t;
    public FileLock u;
    public FileChannel v;
    public List<Long> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<Long> f1544x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f1545y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Map<String, d> f1546z;
    public boolean l = false;
    public final v9 A = new n9(this);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
    public class a {
        public b.i.a.f.h.l.e1 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Long> f1547b;
        public List<b.i.a.f.h.l.a1> c;
        public long d;

        public a(k9 k9Var, j9 j9Var) {
        }

        public final void a(b.i.a.f.h.l.e1 e1Var) {
            this.a = e1Var;
        }

        public final boolean b(long j, b.i.a.f.h.l.a1 a1Var) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.f1547b == null) {
                this.f1547b = new ArrayList();
            }
            if (this.c.size() > 0 && ((this.c.get(0).H() / 1000) / 60) / 60 != ((a1Var.H() / 1000) / 60) / 60) {
                return false;
            }
            long jG = this.d + ((long) a1Var.g());
            if (jG >= Math.max(0, p.i.a(null).intValue())) {
                return false;
            }
            this.d = jG;
            this.c.add(a1Var);
            this.f1547b.add(Long.valueOf(j));
            return this.c.size() < Math.max(1, p.j.a(null).intValue());
        }
    }

    public k9(r9 r9Var) {
        u4 u4VarB = u4.b(r9Var.a, null, null);
        this.k = u4VarB;
        this.f1545y = -1L;
        q9 q9Var = new q9(this);
        q9Var.o();
        this.h = q9Var;
        x3 x3Var = new x3(this);
        x3Var.o();
        this.c = x3Var;
        p4 p4Var = new p4(this);
        p4Var.o();
        this.f1542b = p4Var;
        this.f1546z = new HashMap();
        u4VarB.f().v(new j9(this, r9Var));
    }

    public static void C(i9 i9Var) {
        if (i9Var == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (i9Var.c) {
            return;
        }
        String strValueOf = String.valueOf(i9Var.getClass());
        throw new IllegalStateException(outline.j(strValueOf.length() + 27, "Component not initialized: ", strValueOf));
    }

    public static k9 b(Context context) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(context.getApplicationContext(), "null reference");
        if (a == null) {
            synchronized (k9.class) {
                if (a == null) {
                    a = new k9(new r9(context));
                }
            }
        }
        return a;
    }

    public static void d(a1.a aVar, int i, String str) {
        List<b.i.a.f.h.l.c1> listV = aVar.v();
        for (int i2 = 0; i2 < listV.size(); i2++) {
            if ("_err".equals(listV.get(i2).B())) {
                return;
            }
        }
        c1.a aVarQ = b.i.a.f.h.l.c1.Q();
        aVarQ.s("_err");
        aVarQ.r(Long.valueOf(i).longValue());
        b.i.a.f.h.l.c1 c1Var = (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ.p());
        c1.a aVarQ2 = b.i.a.f.h.l.c1.Q();
        aVarQ2.s("_ev");
        aVarQ2.t(str);
        b.i.a.f.h.l.c1 c1Var2 = (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ2.p());
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.a1.A((b.i.a.f.h.l.a1) aVar.k, c1Var);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.a1.A((b.i.a.f.h.l.a1) aVar.k, c1Var2);
    }

    public static void e(a1.a aVar, @NonNull String str) {
        List<b.i.a.f.h.l.c1> listV = aVar.v();
        for (int i = 0; i < listV.size(); i++) {
            if (str.equals(listV.get(i).B())) {
                aVar.x(i);
                return;
            }
        }
    }

    public final void A(a1.a aVar, a1.a aVar2) {
        AnimatableValueParser.l("_e".equals(aVar.y()));
        N();
        b.i.a.f.h.l.c1 c1VarW = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar.p()), "_et");
        if (!c1VarW.I() || c1VarW.J() <= 0) {
            return;
        }
        long J = c1VarW.J();
        N();
        b.i.a.f.h.l.c1 c1VarW2 = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar2.p()), "_et");
        if (c1VarW2 != null && c1VarW2.J() > 0) {
            J += c1VarW2.J();
        }
        N();
        q9.E(aVar2, "_et", Long.valueOf(J));
        N();
        q9.E(aVar, "_fr", 1L);
    }

    @WorkerThread
    public final void B(zzaq zzaqVar, zzn zznVar) throws Throwable {
        if (b.i.a.f.h.l.ea.b() && this.k.h.o(p.A0)) {
            u3 u3VarB = u3.b(zzaqVar);
            this.k.t().H(u3VarB.d, K().h0(zznVar.j));
            this.k.t().Q(u3VarB, this.k.h.m(zznVar.j));
            zzaqVar = u3VarB.a();
        }
        if (this.k.h.o(p.f1556e0) && "_cmp".equals(zzaqVar.j) && "referrer API v2".equals(zzaqVar.k.j.getString("_cis"))) {
            String string = zzaqVar.k.j.getString("gclid");
            if (!TextUtils.isEmpty(string)) {
                o(new zzku("_lgclid", zzaqVar.m, string, "auto"), zznVar);
            }
        }
        l(zzaqVar, zznVar);
    }

    @WorkerThread
    public final void D(zzku zzkuVar, zzn zznVar) throws Throwable {
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            if ("_npa".equals(zzkuVar.k) && zznVar.B != null) {
                this.k.g().m.a("Falling back to manifest metadata value for ad personalization");
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                o(new zzku("_npa", System.currentTimeMillis(), Long.valueOf(zznVar.B.booleanValue() ? 1L : 0L), "auto"), zznVar);
                return;
            }
            this.k.g().m.b("Removing user property", this.k.u().y(zzkuVar.k));
            K().b0();
            try {
                G(zznVar);
                K().V(zznVar.j, zzkuVar.k);
                K().s();
                this.k.g().m.b("User property removed", this.k.u().y(zzkuVar.k));
            } finally {
                K().e0();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x038a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0237  */
    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final void E(zzn zznVar) throws Throwable {
        a4 a4Var;
        l lVarZ;
        String str;
        long j;
        String str2;
        long j2;
        PackageInfo packageInfoB;
        ApplicationInfo applicationInfoA;
        boolean z2;
        U();
        P();
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.w(zznVar.j);
        if (L(zznVar)) {
            a4 a4VarT = K().T(zznVar.j);
            if (a4VarT != null && TextUtils.isEmpty(a4VarT.v()) && !TextUtils.isEmpty(zznVar.k)) {
                a4VarT.F(0L);
                K().I(a4VarT);
                p4 p4VarH = H();
                String str3 = zznVar.j;
                p4VarH.b();
                p4VarH.g.remove(str3);
            }
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            long jCurrentTimeMillis = zznVar.v;
            if (jCurrentTimeMillis == 0) {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            j jVarY = this.k.y();
            jVarY.b();
            jVarY.g = null;
            jVarY.h = 0L;
            int i = zznVar.w;
            if (i != 0 && i != 1) {
                this.k.g().i.c("Incorrect app type, assuming installed app. appId, appType", q3.s(zznVar.j), Integer.valueOf(i));
                i = 0;
            }
            K().b0();
            try {
                u9 u9VarY = K().Y(zznVar.j, "_npa");
                if (u9VarY == null || "auto".equals(u9VarY.f1576b)) {
                    Boolean bool = zznVar.B;
                    if (bool != null) {
                        a4Var = null;
                        zzku zzkuVar = new zzku("_npa", jCurrentTimeMillis, Long.valueOf(bool.booleanValue() ? 1L : 0L), "auto");
                        if (u9VarY == null || !u9VarY.e.equals(zzkuVar.m)) {
                            o(zzkuVar, zznVar);
                        }
                    } else {
                        a4Var = null;
                        if (u9VarY != null) {
                            D(new zzku("_npa", jCurrentTimeMillis, null, "auto"), zznVar);
                        }
                    }
                } else {
                    a4Var = null;
                }
                a4 a4VarT2 = K().T(zznVar.j);
                if (a4VarT2 != null) {
                    this.k.t();
                    if (t9.d0(zznVar.k, a4VarT2.v(), zznVar.A, a4VarT2.y())) {
                        this.k.g().i.b("New GMP App Id passed in. Removing cached database data. appId", q3.s(a4VarT2.o()));
                        g gVarK = K();
                        String strO = a4VarT2.o();
                        gVarK.n();
                        gVarK.b();
                        AnimatableValueParser.w(strO);
                        try {
                            SQLiteDatabase sQLiteDatabaseT = gVarK.t();
                            String[] strArr = {strO};
                            int iDelete = sQLiteDatabaseT.delete("events", "app_id=?", strArr) + 0 + sQLiteDatabaseT.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseT.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseT.delete("apps", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseT.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseT.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseT.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseT.delete("consent_settings", "app_id=?", strArr);
                            if (iDelete > 0) {
                                gVarK.g().n.c("Deleted application data. app, records", strO, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e) {
                            gVarK.g().f.c("Error deleting application data. appId, error", q3.s(strO), e);
                        }
                        a4VarT2 = a4Var;
                    }
                }
                if (a4VarT2 != null) {
                    if (((a4VarT2.N() == -2147483648L || a4VarT2.N() == zznVar.f3012s) ? false : true) | ((a4VarT2.N() != -2147483648L || a4VarT2.M() == null || a4VarT2.M().equals(zznVar.l)) ? false : true)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", a4VarT2.M());
                        l(new zzaq("_au", new zzap(bundle), "auto", jCurrentTimeMillis), zznVar);
                    }
                }
                G(zznVar);
                if (i == 0) {
                    lVarZ = K().z(zznVar.j, "_f");
                } else {
                    lVarZ = i == 1 ? K().z(zznVar.j, "_v") : a4Var;
                }
                if (lVarZ == null) {
                    long j3 = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                    if (i == 0) {
                        o(new zzku("_fot", jCurrentTimeMillis, Long.valueOf(j3), "auto"), zznVar);
                        U();
                        this.k.f1572x.a(zznVar.j);
                        U();
                        P();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        if (this.k.h.u(zznVar.j, p.T)) {
                            str2 = "_et";
                            j2 = 1;
                            bundle2.putLong(str2, 1L);
                        } else {
                            str2 = "_et";
                            j2 = 1;
                        }
                        if (zznVar.f3015z) {
                            bundle2.putLong("_dac", j2);
                        }
                        g gVarK2 = K();
                        String str4 = zznVar.j;
                        AnimatableValueParser.w(str4);
                        gVarK2.b();
                        gVarK2.n();
                        long jG0 = gVarK2.g0(str4, "first_open_count");
                        if (this.k.f1570b.getPackageManager() == null) {
                            this.k.g().f.b("PackageManager is null, first open report might be inaccurate. appId", q3.s(zznVar.j));
                            str2 = str2;
                            jG0 = jG0;
                        } else {
                            try {
                                packageInfoB = b.i.a.f.e.p.b.a(this.k.f1570b).b(zznVar.j, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                this.k.g().f.c("Package info is null, first open report might be inaccurate. appId", q3.s(zznVar.j), e2);
                                packageInfoB = a4Var;
                            }
                            if (packageInfoB != 0) {
                                long j4 = packageInfoB.firstInstallTime;
                                if (j4 != 0) {
                                    if (j4 != packageInfoB.lastUpdateTime) {
                                        if (!this.k.h.o(p.n0) || jG0 == 0) {
                                            bundle2.putLong("_uwa", 1L);
                                        }
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    o(new zzku("_fi", jCurrentTimeMillis, Long.valueOf(z2 ? 1L : 0L), "auto"), zznVar);
                                }
                            }
                            try {
                                applicationInfoA = b.i.a.f.e.p.b.a(this.k.f1570b).a(zznVar.j, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                this.k.g().f.c("Application info is null, first open report might be inaccurate. appId", q3.s(zznVar.j), e3);
                                applicationInfoA = a4Var;
                            }
                            if (applicationInfoA != 0) {
                                if ((applicationInfoA.flags & 1) != 0) {
                                    bundle2.putLong("_sys", 1L);
                                }
                                if ((applicationInfoA.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", 1L);
                                }
                            }
                        }
                        if (jG0 >= 0) {
                            bundle2.putLong("_pfo", jG0);
                        }
                        B(new zzaq("_f", new zzap(bundle2), "auto", jCurrentTimeMillis), zznVar);
                        str = str2;
                    } else {
                        str = "_et";
                        if (i == 1) {
                            o(new zzku("_fvt", jCurrentTimeMillis, Long.valueOf(j3), "auto"), zznVar);
                            U();
                            P();
                            Bundle bundle3 = new Bundle();
                            bundle3.putLong("_c", 1L);
                            bundle3.putLong("_r", 1L);
                            if (this.k.h.u(zznVar.j, p.T)) {
                                j = 1;
                                bundle3.putLong(str, 1L);
                            } else {
                                j = 1;
                            }
                            if (zznVar.f3015z) {
                                bundle3.putLong("_dac", j);
                            }
                            B(new zzaq("_v", new zzap(bundle3), "auto", jCurrentTimeMillis), zznVar);
                        }
                    }
                    if (!this.k.h.u(zznVar.j, p.U)) {
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong(str, 1L);
                        if (this.k.h.u(zznVar.j, p.T)) {
                            bundle4.putLong("_fr", 1L);
                        }
                        B(new zzaq("_e", new zzap(bundle4), "auto", jCurrentTimeMillis), zznVar);
                    }
                } else if (zznVar.r) {
                    B(new zzaq("_cd", new zzap(new Bundle()), "auto", jCurrentTimeMillis), zznVar);
                }
                K().s();
                K().e0();
            } catch (Throwable th) {
                K().e0();
                throw th;
            }
        }
    }

    @WorkerThread
    public final void F(zzz zzzVar, zzn zznVar) throws Throwable {
        Objects.requireNonNull(zzzVar, "null reference");
        AnimatableValueParser.w(zzzVar.j);
        Objects.requireNonNull(zzzVar.l, "null reference");
        AnimatableValueParser.w(zzzVar.l.k);
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            K().b0();
            try {
                G(zznVar);
                zzz zzzVarZ = K().Z(zzzVar.j, zzzVar.l.k);
                if (zzzVarZ != null) {
                    this.k.g().m.c("Removing conditional user property", zzzVar.j, this.k.u().y(zzzVar.l.k));
                    K().a0(zzzVar.j, zzzVar.l.k);
                    if (zzzVarZ.n) {
                        K().V(zzzVar.j, zzzVar.l.k);
                    }
                    zzaq zzaqVar = zzzVar.t;
                    if (zzaqVar != null) {
                        zzap zzapVar = zzaqVar.k;
                        Bundle bundleX0 = zzapVar != null ? zzapVar.x0() : null;
                        t9 t9VarT = this.k.t();
                        String str = zzzVar.j;
                        zzaq zzaqVar2 = zzzVar.t;
                        I(t9VarT.B(str, zzaqVar2.j, bundleX0, zzzVarZ.k, zzaqVar2.m, true, b.i.a.f.h.l.x7.b() && this.k.h.o(p.M0)), zznVar);
                    }
                } else {
                    this.k.g().i.c("Conditional user property doesn't exist", q3.s(zzzVar.j), this.k.u().y(zzzVar.l.k));
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:130:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:133:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:158:0x0351  */
    /* JADX WARN: Code duplicated, block: B:166:0x0375  */
    /* JADX WARN: Code duplicated, block: B:169:0x0383  */
    /* JADX WARN: Code duplicated, block: B:172:0x0391  */
    /* JADX WARN: Code duplicated, block: B:174:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:182:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:185:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:194:0x0404  */
    /* JADX WARN: Code duplicated, block: B:196:0x0407  */
    @WorkerThread
    public final a4 G(zzn zznVar) throws Throwable {
        boolean z2;
        long j;
        String str;
        long j2;
        String str2;
        U();
        P();
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.w(zznVar.j);
        a4 a4VarT = K().T(zznVar.j);
        d dVarH = d.a;
        d dVarH2 = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) ? a(zznVar.j).h(d.b(zznVar.F)) : dVarH;
        String strT = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !dVarH2.j()) ? "" : this.j.t(zznVar.j);
        if (((b.i.a.f.h.l.p9) b.i.a.f.h.l.m9.j.a()).a() && this.k.h.o(p.o0)) {
            if (a4VarT == null) {
                a4VarT = new a4(this.k, zznVar.j);
                if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                    if (dVarH2.k()) {
                        a4VarT.c(c(dVarH2));
                    }
                    if (dVarH2.j()) {
                        a4VarT.x(strT);
                    }
                } else {
                    a4VarT.c(W());
                    a4VarT.x(strT);
                }
            } else if ((!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0) || dVarH2.j()) && !strT.equals(a4VarT.E())) {
                a4VarT.x(strT);
                if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                    a4VarT.c(c(dVarH2));
                } else {
                    a4VarT.c(W());
                }
            } else if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && TextUtils.isEmpty(a4VarT.s()) && dVarH2.k()) {
                a4VarT.c(c(dVarH2));
            }
            a4VarT.m(zznVar.k);
            a4VarT.q(zznVar.A);
            if (b.i.a.f.h.l.da.b() && this.k.h.u(a4VarT.o(), p.f1561j0)) {
                a4VarT.u(zznVar.E);
            }
            if (!TextUtils.isEmpty(zznVar.t)) {
                a4VarT.A(zznVar.t);
            }
            long j3 = zznVar.n;
            if (j3 != 0) {
                a4VarT.t(j3);
            }
            if (!TextUtils.isEmpty(zznVar.l)) {
                a4VarT.D(zznVar.l);
            }
            a4VarT.p(zznVar.f3012s);
            String str3 = zznVar.m;
            if (str3 != null) {
                a4VarT.G(str3);
            }
            a4VarT.w(zznVar.o);
            a4VarT.e(zznVar.q);
            if (!TextUtils.isEmpty(zznVar.p)) {
                a4VarT.J(zznVar.p);
            }
            if (!this.k.h.o(p.y0)) {
                a4VarT.R(zznVar.u);
            }
            a4VarT.n(zznVar.f3013x);
            a4VarT.r(zznVar.f3014y);
            a4VarT.b(zznVar.B);
            a4VarT.z(zznVar.C);
            a4VarT.a.f().b();
            if (a4VarT.E) {
                K().I(a4VarT);
            }
            return a4VarT;
        }
        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
            dVarH = a(zznVar.j).h(d.b(zznVar.F));
        }
        boolean z3 = true;
        if (a4VarT == null) {
            a4VarT = new a4(this.k, zznVar.j);
            if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                if (dVarH.k()) {
                    a4VarT.c(c(dVarH));
                }
                if (dVarH.j()) {
                    a4VarT.x(strT);
                }
            } else {
                a4VarT.c(W());
                a4VarT.x(strT);
            }
        } else {
            if ((b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !dVarH.j()) || strT.equals(a4VarT.E())) {
                if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && TextUtils.isEmpty(a4VarT.s()) && dVarH.k()) {
                    a4VarT.c(c(dVarH));
                } else {
                    z2 = false;
                }
                if (!TextUtils.equals(zznVar.k, a4VarT.v())) {
                    a4VarT.m(zznVar.k);
                    z2 = true;
                }
                if (!TextUtils.equals(zznVar.A, a4VarT.y())) {
                    a4VarT.q(zznVar.A);
                    z2 = true;
                }
                if (b.i.a.f.h.l.da.b() && this.k.h.u(a4VarT.o(), p.f1561j0) && !TextUtils.equals(zznVar.E, a4VarT.B())) {
                    a4VarT.u(zznVar.E);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.t) && !zznVar.t.equals(a4VarT.H())) {
                    a4VarT.A(zznVar.t);
                    z2 = true;
                }
                j = zznVar.n;
                if (j != 0 && j != a4VarT.P()) {
                    a4VarT.t(zznVar.n);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.l) && !zznVar.l.equals(a4VarT.M())) {
                    a4VarT.D(zznVar.l);
                    z2 = true;
                }
                if (zznVar.f3012s != a4VarT.N()) {
                    a4VarT.p(zznVar.f3012s);
                    z2 = true;
                }
                str = zznVar.m;
                if (str != null && !str.equals(a4VarT.O())) {
                    a4VarT.G(zznVar.m);
                    z2 = true;
                }
                if (zznVar.o != a4VarT.Q()) {
                    a4VarT.w(zznVar.o);
                    z2 = true;
                }
                if (zznVar.q != a4VarT.T()) {
                    a4VarT.e(zznVar.q);
                    z2 = true;
                }
                if (!TextUtils.isEmpty(zznVar.p)) {
                    str2 = zznVar.p;
                    a4VarT.a.f().b();
                    if (!str2.equals(a4VarT.D)) {
                        a4VarT.J(zznVar.p);
                        z2 = true;
                    }
                }
                if (!this.k.h.o(p.y0) && zznVar.u != a4VarT.g()) {
                    a4VarT.R(zznVar.u);
                    z2 = true;
                }
                if (zznVar.f3013x != a4VarT.h()) {
                    a4VarT.n(zznVar.f3013x);
                    z2 = true;
                }
                if (zznVar.f3014y != a4VarT.i()) {
                    a4VarT.r(zznVar.f3014y);
                    z2 = true;
                }
                if (zznVar.B != a4VarT.j()) {
                    a4VarT.b(zznVar.B);
                    z2 = true;
                }
                j2 = zznVar.C;
                if (j2 != 0 || j2 == a4VarT.S()) {
                    z3 = z2;
                } else {
                    a4VarT.z(zznVar.C);
                }
                if (z3) {
                    K().I(a4VarT);
                }
                return a4VarT;
            }
            a4VarT.x(strT);
            if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) {
                a4VarT.c(W());
            } else if (dVarH.k()) {
                a4VarT.c(c(dVarH));
            }
        }
        z2 = true;
        if (!TextUtils.equals(zznVar.k, a4VarT.v())) {
            a4VarT.m(zznVar.k);
            z2 = true;
        }
        if (!TextUtils.equals(zznVar.A, a4VarT.y())) {
            a4VarT.q(zznVar.A);
            z2 = true;
        }
        if (b.i.a.f.h.l.da.b()) {
            a4VarT.u(zznVar.E);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.t)) {
            a4VarT.A(zznVar.t);
            z2 = true;
        }
        j = zznVar.n;
        if (j != 0) {
            a4VarT.t(zznVar.n);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.l)) {
            a4VarT.D(zznVar.l);
            z2 = true;
        }
        if (zznVar.f3012s != a4VarT.N()) {
            a4VarT.p(zznVar.f3012s);
            z2 = true;
        }
        str = zznVar.m;
        if (str != null) {
            a4VarT.G(zznVar.m);
            z2 = true;
        }
        if (zznVar.o != a4VarT.Q()) {
            a4VarT.w(zznVar.o);
            z2 = true;
        }
        if (zznVar.q != a4VarT.T()) {
            a4VarT.e(zznVar.q);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zznVar.p)) {
            str2 = zznVar.p;
            a4VarT.a.f().b();
            if (!str2.equals(a4VarT.D)) {
                a4VarT.J(zznVar.p);
                z2 = true;
            }
        }
        if (!this.k.h.o(p.y0)) {
            a4VarT.R(zznVar.u);
            z2 = true;
        }
        if (zznVar.f3013x != a4VarT.h()) {
            a4VarT.n(zznVar.f3013x);
            z2 = true;
        }
        if (zznVar.f3014y != a4VarT.i()) {
            a4VarT.r(zznVar.f3014y);
            z2 = true;
        }
        if (zznVar.B != a4VarT.j()) {
            a4VarT.b(zznVar.B);
            z2 = true;
        }
        j2 = zznVar.C;
        if (j2 != 0) {
            z3 = z2;
        } else {
            z3 = z2;
        }
        if (z3) {
            K().I(a4VarT);
        }
        return a4VarT;
    }

    public final p4 H() {
        C(this.f1542b);
        return this.f1542b;
    }

    /* JADX WARN: Code duplicated, block: B:293:0x0946  */
    /* JADX WARN: Code duplicated, block: B:94:0x02ba A[Catch: all -> 0x099c, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:98:0x02f3 A[Catch: all -> 0x099c, TRY_LEAVE, TryCatch #2 {all -> 0x099c, blocks: (B:38:0x013e, B:41:0x014d, B:43:0x0157, B:48:0x0163, B:55:0x0175, B:58:0x0181, B:60:0x0198, B:65:0x01b1, B:70:0x01e6, B:72:0x01ec, B:74:0x01fa, B:76:0x0202, B:78:0x020c, B:80:0x0217, B:83:0x021e, B:92:0x02b0, B:94:0x02ba, B:98:0x02f3, B:102:0x0305, B:104:0x0352, B:106:0x0357, B:107:0x0370, B:111:0x0381, B:113:0x0396, B:115:0x039b, B:116:0x03b4, B:120:0x03d9, B:124:0x03fe, B:125:0x0417, B:128:0x0426, B:131:0x0449, B:132:0x0465, B:134:0x046f, B:136:0x047b, B:138:0x0481, B:139:0x048c, B:141:0x0498, B:142:0x04af, B:144:0x04d7, B:147:0x04f0, B:150:0x0536, B:152:0x054e, B:154:0x0585, B:155:0x058a, B:157:0x0592, B:158:0x0597, B:160:0x059f, B:161:0x05a4, B:163:0x05ad, B:164:0x05b1, B:166:0x05be, B:167:0x05c3, B:169:0x05c9, B:171:0x05d7, B:172:0x05ee, B:174:0x05f4, B:176:0x0604, B:178:0x060e, B:180:0x0616, B:181:0x061b, B:183:0x0625, B:185:0x062f, B:187:0x0637, B:193:0x0654, B:195:0x065c, B:196:0x065f, B:198:0x066e, B:199:0x0671, B:201:0x0687, B:203:0x0695, B:227:0x073f, B:229:0x0784, B:230:0x0789, B:232:0x0791, B:234:0x0797, B:236:0x07a5, B:238:0x07ac, B:241:0x07b4, B:242:0x07b7, B:237:0x07a9, B:243:0x07b8, B:245:0x07c4, B:247:0x07d3, B:249:0x07e1, B:251:0x07f0, B:253:0x0800, B:255:0x080e, B:258:0x081f, B:260:0x0854, B:261:0x0859, B:257:0x0814, B:250:0x07e9, B:262:0x0865, B:264:0x086b, B:266:0x0879, B:271:0x0890, B:273:0x089a, B:274:0x08a1, B:275:0x08ac, B:277:0x08b2, B:279:0x08e1, B:280:0x08f1, B:282:0x08f9, B:283:0x08fd, B:285:0x0906, B:294:0x0947, B:296:0x094d, B:299:0x0969, B:288:0x0913, B:290:0x0931, B:298:0x0951, B:268:0x087f, B:270:0x0889, B:205:0x069b, B:207:0x06ad, B:209:0x06b1, B:211:0x06bc, B:212:0x06c7, B:214:0x06d9, B:216:0x06dd, B:218:0x06e3, B:220:0x06f3, B:222:0x0705, B:226:0x073c, B:223:0x071f, B:225:0x0725, B:188:0x063d, B:190:0x0647, B:192:0x064f, B:151:0x0540, B:85:0x0248, B:86:0x0267, B:91:0x0293, B:90:0x0282, B:77:0x0207, B:68:0x01bf, B:69:0x01dc), top: B:309:0x013e, inners: #0, #1 }] */
    @WorkerThread
    public final void I(zzaq zzaqVar, zzn zznVar) throws Throwable {
        int i;
        l lVarA;
        boolean z2;
        u9 u9VarY;
        long jLongValue;
        boolean z3;
        g gVarK;
        u9 u9Var;
        u9 u9Var2;
        a4 a4VarT;
        zzaq zzaqVarA = zzaqVar;
        AnimatableValueParser.A(zznVar);
        AnimatableValueParser.w(zznVar.j);
        long jNanoTime = System.nanoTime();
        U();
        P();
        String str = zznVar.j;
        N();
        if (q9.O(zzaqVar, zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            boolean z4 = true;
            if (H().x(str, zzaqVarA.j)) {
                this.k.g().A().c("Dropping blacklisted event. appId", q3.s(str), this.k.u().u(zzaqVarA.j));
                if (!H().C(str) && !H().D(str)) {
                    z4 = false;
                }
                if (!z4 && !"_err".equals(zzaqVarA.j)) {
                    this.k.t().S(this.A, str, 11, "_ev", zzaqVarA.j, 0);
                }
                if (!z4 || (a4VarT = K().T(str)) == null || Math.abs(((b.i.a.f.e.o.c) this.k.i()).a() - Math.max(a4VarT.W(), a4VarT.V())) <= p.f1565z.a(null).longValue()) {
                    return;
                }
                this.k.g().C().a("Fetching config for blacklisted app");
                n(a4VarT);
                return;
            }
            if (b.i.a.f.h.l.o8.b() && this.k.a().o(p.w0)) {
                u3 u3VarB = u3.b(zzaqVar);
                this.k.t().Q(u3VarB, this.k.a().m(str));
                zzaqVarA = u3VarB.a();
            }
            if (this.k.g().x(2)) {
                this.k.g().D().b("Logging event", this.k.u().t(zzaqVarA));
            }
            K().b0();
            try {
                G(zznVar);
                boolean z5 = "ecommerce_purchase".equals(zzaqVarA.j) || "purchase".equals(zzaqVarA.j) || "refund".equals(zzaqVarA.j);
                if ("_iap".equals(zzaqVarA.j) || z5) {
                    String strA0 = zzaqVarA.k.A0("currency");
                    if (z5) {
                        double dDoubleValue = zzaqVarA.k.z0("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = zzaqVarA.k.y0("value").longValue() * 1000000.0d;
                        }
                        if (dDoubleValue > 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            this.k.g().A().c("Data lost. Currency value is too big. appId", q3.s(str), Double.valueOf(dDoubleValue));
                            jNanoTime = jNanoTime;
                            i = 0;
                            z3 = false;
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if ("refund".equals(zzaqVarA.j)) {
                                jLongValue = -jLongValue;
                            }
                        }
                        if (!z3) {
                            K().s();
                            K().e0();
                            return;
                        }
                    } else {
                        jLongValue = zzaqVarA.k.y0("value").longValue();
                    }
                    if (TextUtils.isEmpty(strA0)) {
                        jNanoTime = jNanoTime;
                        i = 0;
                        z3 = true;
                        if (!z3) {
                            K().s();
                            K().e0();
                            return;
                        }
                    } else {
                        String upperCase = strA0.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String strConcat = upperCase.length() != 0 ? "_ltv_".concat(upperCase) : new String("_ltv_");
                            u9 u9VarY2 = K().Y(str, strConcat);
                            if (u9VarY2 != null) {
                                Object obj = u9VarY2.e;
                                if (obj instanceof Long) {
                                    i = 0;
                                    u9Var = new u9(str, zzaqVarA.l, strConcat, ((b.i.a.f.e.o.c) this.k.i()).a(), Long.valueOf(((Long) obj).longValue() + jLongValue));
                                } else {
                                    i = 0;
                                    gVarK = K();
                                    int iQ = this.k.a().q(str, p.E) - 1;
                                    AnimatableValueParser.w(str);
                                    gVarK.b();
                                    gVarK.n();
                                    try {
                                        gVarK.t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iQ)});
                                    } catch (SQLiteException e) {
                                        gVarK.g().z().c("Error pruning currencies. appId", q3.s(str), e);
                                    }
                                    u9Var = new u9(str, zzaqVarA.l, strConcat, ((b.i.a.f.e.o.c) this.k.i()).a(), Long.valueOf(jLongValue));
                                }
                                u9Var2 = u9Var;
                                if (!K().M(u9Var2)) {
                                    this.k.g().z().d("Too many unique user properties are set. Ignoring user property. appId", q3.s(str), this.k.u().y(u9Var2.c), u9Var2.e);
                                    this.k.t().S(this.A, str, 9, null, null, 0);
                                }
                            } else {
                                i = 0;
                                gVarK = K();
                                int iQ2 = this.k.a().q(str, p.E) - 1;
                                AnimatableValueParser.w(str);
                                gVarK.b();
                                gVarK.n();
                                gVarK.t().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(iQ2)});
                                u9Var = new u9(str, zzaqVarA.l, strConcat, ((b.i.a.f.e.o.c) this.k.i()).a(), Long.valueOf(jLongValue));
                                u9Var2 = u9Var;
                                if (!K().M(u9Var2)) {
                                    this.k.g().z().d("Too many unique user properties are set. Ignoring user property. appId", q3.s(str), this.k.u().y(u9Var2.c), u9Var2.e);
                                    this.k.t().S(this.A, str, 9, null, null, 0);
                                }
                            }
                        } else {
                            jNanoTime = jNanoTime;
                            i = 0;
                        }
                        z3 = true;
                        if (!z3) {
                            K().s();
                            K().e0();
                            return;
                        }
                    }
                } else {
                    jNanoTime = jNanoTime;
                    i = 0;
                }
                boolean zX = t9.X(zzaqVarA.j);
                boolean zEquals = "_err".equals(zzaqVarA.j);
                this.k.t();
                f fVarX = K().x(V(), str, t9.v(zzaqVarA.k) + 1, true, zX, false, zEquals, false);
                long jIntValue = fVarX.f1532b - ((long) p.k.a(null).intValue());
                if (jIntValue > 0) {
                    if (jIntValue % 1000 == 1) {
                        this.k.g().z().c("Data loss. Too many events logged. appId, count", q3.s(str), Long.valueOf(fVarX.f1532b));
                    }
                    K().s();
                    K().e0();
                    return;
                }
                if (zX) {
                    long jIntValue2 = fVarX.a - ((long) p.m.a(null).intValue());
                    if (jIntValue2 > 0) {
                        if (jIntValue2 % 1000 == 1) {
                            this.k.g().z().c("Data loss. Too many public events logged. appId, count", q3.s(str), Long.valueOf(fVarX.a));
                        }
                        this.k.t().S(this.A, str, 16, "_ev", zzaqVarA.j, 0);
                        K().s();
                        K().e0();
                        return;
                    }
                }
                if (zEquals) {
                    long jMax = fVarX.d - ((long) Math.max(i, Math.min(1000000, this.k.a().q(zznVar.j, p.l))));
                    if (jMax > 0) {
                        if (jMax == 1) {
                            this.k.g().z().c("Too many error events logged. appId, count", q3.s(str), Long.valueOf(fVarX.d));
                        }
                        K().s();
                        K().e0();
                        return;
                    }
                }
                Bundle bundleX0 = zzaqVarA.k.x0();
                this.k.t().I(bundleX0, "_o", zzaqVarA.l);
                if (this.k.t().s0(str)) {
                    this.k.t().I(bundleX0, "_dbg", 1L);
                    this.k.t().I(bundleX0, "_r", 1L);
                }
                if ("_s".equals(zzaqVarA.j) && (u9VarY = K().Y(zznVar.j, "_sno")) != null && (u9VarY.e instanceof Long)) {
                    this.k.t().I(bundleX0, "_sno", u9VarY.e);
                }
                long jX = K().X(str);
                if (jX > 0) {
                    this.k.g().A().c("Data lost. Too many events stored on disk, deleted. appId", q3.s(str), Long.valueOf(jX));
                }
                m mVar = new m(this.k, zzaqVarA.l, str, zzaqVarA.j, zzaqVarA.m, 0L, bundleX0);
                l lVarZ = K().z(str, mVar.f1549b);
                if (lVarZ != null) {
                    mVar = mVar.a(this.k, lVarZ.f);
                    lVarA = lVarZ.a(mVar.d);
                } else {
                    if (K().f0(str) >= this.k.a().p(str) && zX) {
                        this.k.g().z().d("Too many event names used, ignoring event. appId, name, supported count", q3.s(str), this.k.u().u(mVar.f1549b), Integer.valueOf(this.k.a().p(str)));
                        this.k.t().S(this.A, str, 8, null, null, 0);
                        K().e0();
                        return;
                    }
                    lVarA = new l(str, mVar.f1549b, mVar.d);
                }
                K().H(lVarA);
                U();
                P();
                AnimatableValueParser.A(mVar);
                AnimatableValueParser.A(zznVar);
                AnimatableValueParser.w(mVar.a);
                AnimatableValueParser.l(mVar.a.equals(zznVar.j));
                e1.a aVarU0 = b.i.a.f.h.l.e1.u0();
                aVarU0.q();
                aVarU0.x("android");
                if (!TextUtils.isEmpty(zznVar.j)) {
                    aVarU0.X(zznVar.j);
                }
                if (!TextUtils.isEmpty(zznVar.m)) {
                    aVarU0.T(zznVar.m);
                }
                if (!TextUtils.isEmpty(zznVar.l)) {
                    aVarU0.a0(zznVar.l);
                }
                long j = zznVar.f3012s;
                if (j != -2147483648L) {
                    aVarU0.c0((int) j);
                }
                aVarU0.W(zznVar.n);
                if (!TextUtils.isEmpty(zznVar.k)) {
                    aVarU0.m0(zznVar.k);
                }
                if (b.i.a.f.h.l.t8.b() && this.k.a().o(p.J0)) {
                    aVarU0.w0(a(zznVar.j).h(d.b(zznVar.F)).d());
                }
                if (b.i.a.f.h.l.da.b() && this.k.a().v(zznVar.j, p.f1561j0)) {
                    if (TextUtils.isEmpty(aVarU0.s0()) && !TextUtils.isEmpty(zznVar.E)) {
                        aVarU0.u0(zznVar.E);
                    }
                    if (TextUtils.isEmpty(aVarU0.s0()) && TextUtils.isEmpty(aVarU0.x0()) && !TextUtils.isEmpty(zznVar.A)) {
                        aVarU0.r0(zznVar.A);
                    }
                } else if (TextUtils.isEmpty(aVarU0.s0()) && !TextUtils.isEmpty(zznVar.A)) {
                    aVarU0.r0(zznVar.A);
                }
                long j2 = zznVar.o;
                if (j2 != 0) {
                    aVarU0.d0(j2);
                }
                aVarU0.l0(zznVar.C);
                List<Integer> listU = N().U();
                if (listU != null) {
                    aVarU0.M(listU);
                }
                d dVarH = a(zznVar.j).h(d.b(zznVar.F));
                if (!b.i.a.f.h.l.t8.b() || !this.k.a().o(p.J0) || dVarH.j()) {
                    Pair<String, Boolean> pairS = this.j.s(zznVar.j, dVarH);
                    if (TextUtils.isEmpty((CharSequence) pairS.first)) {
                        if (!this.k.y().s(this.k.j()) && zznVar.f3014y && (!hb.b() || !this.k.a().v(zznVar.j, p.G0))) {
                            String string = Settings.Secure.getString(this.k.j().getContentResolver(), "android_id");
                            if (string == null) {
                                this.k.g().A().b("null secure ID. appId", q3.s(aVarU0.k0()));
                                string = "null";
                            } else if (string.isEmpty()) {
                                this.k.g().A().b("empty secure ID. appId", q3.s(aVarU0.k0()));
                            }
                            aVarU0.o0(string);
                        }
                    } else if (zznVar.f3013x) {
                        aVarU0.e0((String) pairS.first);
                        Object obj2 = pairS.second;
                        if (obj2 != null) {
                            aVarU0.y(((Boolean) obj2).booleanValue());
                        }
                    }
                }
                this.k.y().o();
                aVarU0.J(Build.MODEL);
                this.k.y().o();
                aVarU0.E(Build.VERSION.RELEASE);
                aVarU0.V((int) this.k.y().t());
                aVarU0.N(this.k.y().u());
                if (!this.k.a().o(p.y0)) {
                    aVarU0.i0(zznVar.u);
                }
                if (this.k.d()) {
                    if (b.i.a.f.h.l.t8.b() && this.k.a().o(p.J0)) {
                        aVarU0.k0();
                    } else {
                        aVarU0.k0();
                    }
                    if (!TextUtils.isEmpty(null)) {
                        aVarU0.q0();
                        throw null;
                    }
                }
                a4 a4VarT2 = K().T(zznVar.j);
                if (a4VarT2 == null) {
                    a4VarT2 = new a4(this.k, zznVar.j);
                    if (b.i.a.f.h.l.t8.b() && this.k.a().o(p.J0)) {
                        a4VarT2.c(c(dVarH));
                    } else {
                        a4VarT2.c(W());
                    }
                    a4VarT2.A(zznVar.t);
                    a4VarT2.m(zznVar.k);
                    if (!b.i.a.f.h.l.t8.b() || !this.k.a().o(p.J0) || dVarH.j()) {
                        a4VarT2.x(this.j.t(zznVar.j));
                    }
                    a4VarT2.C(0L);
                    a4VarT2.a(0L);
                    a4VarT2.l(0L);
                    a4VarT2.D(zznVar.l);
                    a4VarT2.p(zznVar.f3012s);
                    a4VarT2.G(zznVar.m);
                    a4VarT2.t(zznVar.n);
                    a4VarT2.w(zznVar.o);
                    a4VarT2.e(zznVar.q);
                    if (!this.k.a().o(p.y0)) {
                        a4VarT2.R(zznVar.u);
                    }
                    a4VarT2.z(zznVar.C);
                    K().I(a4VarT2);
                }
                if ((!b.i.a.f.h.l.t8.b() || !this.k.a().o(p.J0) || dVarH.k()) && !TextUtils.isEmpty(a4VarT2.s())) {
                    aVarU0.h0(a4VarT2.s());
                }
                if (!TextUtils.isEmpty(a4VarT2.H())) {
                    aVarU0.n0(a4VarT2.H());
                }
                List<u9> listC = K().C(zznVar.j);
                for (int i2 = 0; i2 < listC.size(); i2++) {
                    i1.a aVarL = b.i.a.f.h.l.i1.L();
                    aVarL.r(listC.get(i2).c);
                    aVarL.q(listC.get(i2).d);
                    N().G(aVarL, listC.get(i2).e);
                    aVarU0.u(aVarL);
                }
                try {
                    long jV = K().v((b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) aVarU0.p()));
                    g gVarK2 = K();
                    zzap zzapVar = mVar.f;
                    if (zzapVar != null) {
                        Iterator<String> it = zzapVar.iterator();
                        while (true) {
                            n nVar = (n) it;
                            if (!nVar.hasNext()) {
                                z2 = H().y(mVar.a, mVar.f1549b) && K().y(V(), mVar.a, false, false).e < ((long) this.k.a().s(mVar.a));
                            } else if ("_r".equals((String) nVar.next())) {
                            }
                        }
                    }
                    if (gVarK2.L(mVar, jV, z2)) {
                        this.n = 0L;
                    }
                } catch (IOException e2) {
                    this.k.g().z().c("Data loss. Failed to insert raw event metadata. appId", q3.s(aVarU0.k0()), e2);
                }
                K().s();
                K().e0();
                w();
                this.k.g().D().b("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
            } catch (Throwable th) {
                K().e0();
                throw th;
            }
        }
    }

    public final x3 J() {
        C(this.c);
        return this.c;
    }

    public final g K() {
        C(this.d);
        return this.d;
    }

    public final boolean L(zzn zznVar) {
        if (b.i.a.f.h.l.da.b() && this.k.h.u(zznVar.j, p.f1561j0)) {
            return (TextUtils.isEmpty(zznVar.k) && TextUtils.isEmpty(zznVar.E) && TextUtils.isEmpty(zznVar.A)) ? false : true;
        }
        return (TextUtils.isEmpty(zznVar.k) && TextUtils.isEmpty(zznVar.A)) ? false : true;
    }

    public final ba M() {
        C(this.g);
        return this.g;
    }

    public final q9 N() {
        C(this.h);
        return this.h;
    }

    public final o3 O() {
        return this.k.u();
    }

    public final void P() {
        if (!this.l) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    public final void Q() {
        a4 a4VarT;
        String strJ;
        U();
        P();
        this.t = true;
        try {
            Boolean bool = this.k.x().e;
            if (bool == null) {
                this.k.g().i.a("Upload data called on the client side before use of service was decided");
                return;
            }
            if (bool.booleanValue()) {
                this.k.g().f.a("Upload called in the client side when service should be used");
                return;
            }
            if (this.n > 0) {
                w();
                return;
            }
            U();
            if (this.w != null) {
                this.k.g().n.a("Uploading requested multiple times");
                return;
            }
            if (!J().u()) {
                this.k.g().n.a("Network not connected, ignoring upload request");
                w();
                return;
            }
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iQ = this.k.h.q(null, p.Q);
            long jLongValue = jCurrentTimeMillis - p.d.a(null).longValue();
            for (int i = 0; i < iQ && t(jLongValue); i++) {
            }
            long jA = this.k.o().f.a();
            if (jA != 0) {
                this.k.g().m.b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jA)));
            }
            String strU = K().u();
            if (TextUtils.isEmpty(strU)) {
                this.f1545y = -1L;
                String strB = K().B(jCurrentTimeMillis - p.d.a(null).longValue());
                if (!TextUtils.isEmpty(strB) && (a4VarT = K().T(strB)) != null) {
                    n(a4VarT);
                }
            } else {
                if (this.f1545y == -1) {
                    this.f1545y = K().j0();
                }
                List<Pair<b.i.a.f.h.l.e1, Long>> listD = K().D(strU, this.k.h.q(strU, p.g), Math.max(0, this.k.h.q(strU, p.h)));
                if (!listD.isEmpty()) {
                    if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0) || a(strU).j()) {
                        Iterator<Pair<b.i.a.f.h.l.e1, Long>> it = listD.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                strJ = null;
                                break;
                            }
                            b.i.a.f.h.l.e1 e1Var = (b.i.a.f.h.l.e1) it.next().first;
                            if (!TextUtils.isEmpty(e1Var.J())) {
                                strJ = e1Var.J();
                                break;
                            }
                        }
                        if (strJ != null) {
                            for (int i2 = 0; i2 < listD.size(); i2++) {
                                b.i.a.f.h.l.e1 e1Var2 = (b.i.a.f.h.l.e1) listD.get(i2).first;
                                if (!TextUtils.isEmpty(e1Var2.J()) && !e1Var2.J().equals(strJ)) {
                                    listD = listD.subList(0, i2);
                                    break;
                                }
                            }
                        }
                    }
                    d1.a aVarX = b.i.a.f.h.l.d1.x();
                    int size = listD.size();
                    ArrayList arrayList = new ArrayList(listD.size());
                    boolean z2 = "1".equals(this.k.h.c.h(strU, "gaia_collection_enabled")) && !(b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !a(strU).j());
                    boolean z3 = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !a(strU).j()) ? false : true;
                    boolean z4 = (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !a(strU).k()) ? false : true;
                    int i3 = 0;
                    while (i3 < size) {
                        e1.a aVarT = ((b.i.a.f.h.l.e1) listD.get(i3).first).t();
                        arrayList.add((Long) listD.get(i3).second);
                        ArrayList arrayList2 = arrayList;
                        if (aVarT.l) {
                            aVarT.n();
                            aVarT.l = false;
                        }
                        b.i.a.f.h.l.e1.W0((b.i.a.f.h.l.e1) aVarT.k, 33025L);
                        if (aVarT.l) {
                            aVarT.n();
                            aVarT.l = false;
                        }
                        b.i.a.f.h.l.e1.y((b.i.a.f.h.l.e1) aVarT.k, jCurrentTimeMillis);
                        if (aVarT.l) {
                            aVarT.n();
                            aVarT.l = false;
                        }
                        b.i.a.f.h.l.e1.m0((b.i.a.f.h.l.e1) aVarT.k, false);
                        if (!z2) {
                            if (aVarT.l) {
                                aVarT.n();
                                aVarT.l = false;
                            }
                            b.i.a.f.h.l.e1.i1((b.i.a.f.h.l.e1) aVarT.k);
                        }
                        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
                            if (!z3) {
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.e1.F0((b.i.a.f.h.l.e1) aVarT.k);
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.e1.L0((b.i.a.f.h.l.e1) aVarT.k);
                            }
                            if (!z4) {
                                if (aVarT.l) {
                                    aVarT.n();
                                    aVarT.l = false;
                                }
                                b.i.a.f.h.l.e1.Q0((b.i.a.f.h.l.e1) aVarT.k);
                            }
                        }
                        if (this.k.h.u(strU, p.X)) {
                            long jT = N().t(((b.i.a.f.h.l.e1) ((b.i.a.f.h.l.u4) aVarT.p())).d());
                            if (aVarT.l) {
                                aVarT.n();
                                aVarT.l = false;
                            }
                            b.i.a.f.h.l.e1.p1((b.i.a.f.h.l.e1) aVarT.k, jT);
                        }
                        aVarX.q(aVarT);
                        i3++;
                        arrayList = arrayList2;
                    }
                    ArrayList arrayList3 = arrayList;
                    String strZ = this.k.g().x(2) ? N().z((b.i.a.f.h.l.d1) ((b.i.a.f.h.l.u4) aVarX.p())) : null;
                    N();
                    byte[] bArrD = ((b.i.a.f.h.l.d1) ((b.i.a.f.h.l.u4) aVarX.p())).d();
                    String strA = p.q.a(null);
                    try {
                        URL url = new URL(strA);
                        AnimatableValueParser.l(!arrayList3.isEmpty());
                        if (this.w != null) {
                            this.k.g().f.a("Set uploading progress before finishing the previous upload");
                        } else {
                            this.w = new ArrayList(arrayList3);
                        }
                        this.k.o().g.b(jCurrentTimeMillis);
                        this.k.g().n.d("Uploading data. app, uncompressed size, data", size > 0 ? ((b.i.a.f.h.l.d1) aVarX.k).u().G1() : "?", Integer.valueOf(bArrD.length), strZ);
                        this.f1543s = true;
                        x3 x3VarJ = J();
                        m9 m9Var = new m9(this, strU);
                        x3VarJ.b();
                        x3VarJ.n();
                        x3VarJ.f().x(new c4(x3VarJ, strU, url, bArrD, null, m9Var));
                    } catch (MalformedURLException unused) {
                        this.k.g().f.c("Failed to parse upload URL. Not uploading. appId", q3.s(strU), strA);
                    }
                }
            }
        } finally {
            this.t = false;
            x();
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:45:0x010b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0124  */
    /* JADX WARN: Code duplicated, block: B:49:0x012b  */
    /* JADX WARN: Code duplicated, block: B:59:0x017d  */
    /* JADX WARN: Code duplicated, block: B:62:0x018b  */
    /* JADX WARN: Code duplicated, block: B:63:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    @WorkerThread
    public final void R() {
        boolean z2;
        FileChannel fileChannel;
        int i;
        int i2;
        FileChannel fileChannel2;
        FileLock fileLock;
        U();
        P();
        if (this.m) {
            return;
        }
        boolean z3 = true;
        this.m = true;
        U();
        if (this.k.h.o(p.f1560i0) && (fileLock = this.u) != null && fileLock.isValid()) {
            this.k.g().n.a("Storage concurrent access okay");
        } else {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.k.f1570b.getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.v = channel;
                FileLock fileLockTryLock = channel.tryLock();
                this.u = fileLockTryLock;
                if (fileLockTryLock == null) {
                    this.k.g().f.a("Storage concurrent data access panic");
                    z2 = false;
                    if (z2) {
                        fileChannel = this.v;
                        U();
                        if (fileChannel == null && fileChannel.isOpen()) {
                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                            try {
                                fileChannel.position(0L);
                                int i3 = fileChannel.read(byteBufferAllocate);
                                if (i3 == 4) {
                                    byteBufferAllocate.flip();
                                    i = byteBufferAllocate.getInt();
                                } else if (i3 != -1) {
                                    this.k.g().i.b("Unexpected data length. Bytes read", Integer.valueOf(i3));
                                }
                            } catch (IOException e) {
                                this.k.g().f.b("Failed to read from channel", e);
                            }
                            n3 n3VarZ = this.k.z();
                            n3VarZ.t();
                            i2 = n3VarZ.e;
                            U();
                            if (i > i2) {
                                this.k.g().f.c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                return;
                            }
                            if (i < i2) {
                                fileChannel2 = this.v;
                                U();
                                if (fileChannel2 == null && fileChannel2.isOpen()) {
                                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                                    byteBufferAllocate2.putInt(i2);
                                    byteBufferAllocate2.flip();
                                    try {
                                        fileChannel2.truncate(0L);
                                        this.k.h.o(p.s0);
                                        fileChannel2.write(byteBufferAllocate2);
                                        fileChannel2.force(true);
                                        if (fileChannel2.size() != 4) {
                                            this.k.g().f.b("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                                        }
                                    } catch (IOException e2) {
                                        this.k.g().f.b("Failed to write to channel", e2);
                                        z3 = false;
                                    }
                                    if (z3) {
                                        this.k.g().n.c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                    } else {
                                        this.k.g().f.c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                    }
                                }
                                this.k.g().f.a("Bad channel to read from");
                                z3 = false;
                                if (z3) {
                                    this.k.g().n.c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                } else {
                                    this.k.g().f.c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                                }
                            }
                        }
                        this.k.g().f.a("Bad channel to read from");
                        i = 0;
                        n3 n3VarZ2 = this.k.z();
                        n3VarZ2.t();
                        i2 = n3VarZ2.e;
                        U();
                        if (i > i2) {
                            this.k.g().f.c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                            return;
                        }
                        if (i < i2) {
                            fileChannel2 = this.v;
                            U();
                            if (fileChannel2 == null) {
                                this.k.g().f.a("Bad channel to read from");
                                z3 = false;
                            } else {
                                this.k.g().f.a("Bad channel to read from");
                                z3 = false;
                            }
                            if (z3) {
                                this.k.g().n.c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                            } else {
                                this.k.g().f.c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                            }
                        }
                    }
                }
                this.k.g().n.a("Storage concurrent access okay");
            } catch (FileNotFoundException e3) {
                this.k.g().f.b("Failed to acquire storage lock", e3);
            } catch (IOException e4) {
                this.k.g().f.b("Failed to access storage lock file", e4);
            } catch (OverlappingFileLockException e5) {
                this.k.g().i.b("Storage lock already acquired", e5);
            }
        }
        z2 = true;
        if (z2) {
            fileChannel = this.v;
            U();
            if (fileChannel == null) {
                this.k.g().f.a("Bad channel to read from");
                i = 0;
            } else {
                this.k.g().f.a("Bad channel to read from");
                i = 0;
            }
            n3 n3VarZ3 = this.k.z();
            n3VarZ3.t();
            i2 = n3VarZ3.e;
            U();
            if (i > i2) {
                this.k.g().f.c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return;
            }
            if (i < i2) {
                fileChannel2 = this.v;
                U();
                if (fileChannel2 == null) {
                    this.k.g().f.a("Bad channel to read from");
                    z3 = false;
                } else {
                    this.k.g().f.a("Bad channel to read from");
                    z3 = false;
                }
                if (z3) {
                    this.k.g().n.c("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                } else {
                    this.k.g().f.c("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
        }
    }

    public final b4 S() {
        b4 b4Var = this.e;
        if (b4Var != null) {
            return b4Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final h9 T() {
        C(this.f);
        return this.f;
    }

    @WorkerThread
    public final void U() {
        this.k.f().b();
    }

    public final long V() {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        d4 d4VarO = this.k.o();
        d4VarO.o();
        d4VarO.b();
        long jA = d4VarO.j.a();
        if (jA == 0) {
            jA = 1 + ((long) d4VarO.e().v0().nextInt(86400000));
            d4VarO.j.b(jA);
        }
        return ((((jCurrentTimeMillis + jA) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    @Deprecated
    public final String W() {
        byte[] bArr = new byte[16];
        this.k.t().v0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @WorkerThread
    public final d a(String str) {
        String string;
        d dVar = d.a;
        if (!b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) {
            return dVar;
        }
        U();
        P();
        d dVar2 = this.f1546z.get(str);
        if (dVar2 != null) {
            return dVar2;
        }
        g gVarK = K();
        Objects.requireNonNull(gVarK);
        Objects.requireNonNull(str, "null reference");
        gVarK.b();
        gVarK.n();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = gVarK.t().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                } else {
                    cursorRawQuery.close();
                    string = "G1";
                }
                d dVarB = d.b(string);
                s(str, dVarB);
                return dVarB;
            } catch (SQLiteException e) {
                gVarK.g().f.c("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final String c(d dVar) {
        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0) && !dVar.k()) {
            return null;
        }
        return W();
    }

    @Override // b.i.a.f.i.b.t5
    public final r4 f() {
        return this.k.f();
    }

    @Override // b.i.a.f.i.b.t5
    public final q3 g() {
        return this.k.g();
    }

    public final void h(e1.a aVar, long j, boolean z2) throws Throwable {
        u9 u9Var;
        boolean z3;
        String str = z2 ? "_se" : "_lte";
        u9 u9VarY = K().Y(aVar.k0(), str);
        if (u9VarY == null || u9VarY.e == null) {
            String strK0 = aVar.k0();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            u9Var = new u9(strK0, "auto", str, System.currentTimeMillis(), Long.valueOf(j));
        } else {
            String strK1 = aVar.k0();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            u9Var = new u9(strK1, "auto", str, System.currentTimeMillis(), Long.valueOf(((Long) u9VarY.e).longValue() + j));
        }
        i1.a aVarL = b.i.a.f.h.l.i1.L();
        aVarL.r(str);
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        aVarL.q(System.currentTimeMillis());
        aVarL.s(((Long) u9Var.e).longValue());
        b.i.a.f.h.l.i1 i1Var = (b.i.a.f.h.l.i1) ((b.i.a.f.h.l.u4) aVarL.p());
        int iS = q9.s(aVar, str);
        if (iS >= 0) {
            if (aVar.l) {
                aVar.n();
                aVar.l = false;
            }
            b.i.a.f.h.l.e1.x((b.i.a.f.h.l.e1) aVar.k, iS, i1Var);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (aVar.l) {
                aVar.n();
                aVar.l = false;
            }
            b.i.a.f.h.l.e1.A((b.i.a.f.h.l.e1) aVar.k, i1Var);
        }
        if (j > 0) {
            K().M(u9Var);
            this.k.g().n.c("Updated engagement user property. scope, value", z2 ? "session-scoped" : "lifetime", u9Var.e);
        }
    }

    @Override // b.i.a.f.i.b.t5
    public final b.i.a.f.e.o.b i() {
        return this.k.o;
    }

    @Override // b.i.a.f.i.b.t5
    public final Context j() {
        return this.k.f1570b;
    }

    @Override // b.i.a.f.i.b.t5
    public final ga k() {
        return this.k.g;
    }

    @WorkerThread
    public final void l(zzaq zzaqVar, zzn zznVar) throws Throwable {
        List<zzz> listF;
        List<zzz> listF2;
        List<zzz> listF3;
        zzaq zzaqVar2 = zzaqVar;
        Objects.requireNonNull(zznVar, "null reference");
        AnimatableValueParser.w(zznVar.j);
        U();
        P();
        String str = zznVar.j;
        long j = zzaqVar2.m;
        N();
        if (q9.O(zzaqVar, zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            List<String> list = zznVar.D;
            if (list != null) {
                if (!list.contains(zzaqVar2.j)) {
                    this.k.g().m.d("Dropping non-safelisted event. appId, event name, origin", str, zzaqVar2.j, zzaqVar2.l);
                    return;
                } else {
                    Bundle bundleX0 = zzaqVar2.k.x0();
                    bundleX0.putLong("ga_safelisted", 1L);
                    zzaqVar2 = new zzaq(zzaqVar2.j, new zzap(bundleX0), zzaqVar2.l, zzaqVar2.m);
                }
            }
            K().b0();
            try {
                g gVarK = K();
                AnimatableValueParser.w(str);
                gVarK.b();
                gVarK.n();
                if (j < 0) {
                    gVarK.g().i.c("Invalid time querying timed out conditional properties", q3.s(str), Long.valueOf(j));
                    listF = Collections.emptyList();
                } else {
                    listF = gVarK.F("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzz zzzVar : listF) {
                    if (zzzVar != null) {
                        this.k.g().n.d("User property timed out", zzzVar.j, this.k.u().y(zzzVar.l.k), zzzVar.l.w0());
                        zzaq zzaqVar3 = zzzVar.p;
                        if (zzaqVar3 != null) {
                            I(new zzaq(zzaqVar3, j), zznVar);
                        }
                        K().a0(str, zzzVar.l.k);
                    }
                }
                g gVarK2 = K();
                AnimatableValueParser.w(str);
                gVarK2.b();
                gVarK2.n();
                if (j < 0) {
                    gVarK2.g().i.c("Invalid time querying expired conditional properties", q3.s(str), Long.valueOf(j));
                    listF2 = Collections.emptyList();
                } else {
                    listF2 = gVarK2.F("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listF2.size());
                for (zzz zzzVar2 : listF2) {
                    if (zzzVar2 != null) {
                        this.k.g().n.d("User property expired", zzzVar2.j, this.k.u().y(zzzVar2.l.k), zzzVar2.l.w0());
                        K().V(str, zzzVar2.l.k);
                        zzaq zzaqVar4 = zzzVar2.t;
                        if (zzaqVar4 != null) {
                            arrayList.add(zzaqVar4);
                        }
                        K().a0(str, zzzVar2.l.k);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    I(new zzaq((zzaq) obj, j), zznVar);
                }
                g gVarK3 = K();
                String str2 = zzaqVar2.j;
                AnimatableValueParser.w(str);
                AnimatableValueParser.w(str2);
                gVarK3.b();
                gVarK3.n();
                if (j < 0) {
                    gVarK3.g().i.d("Invalid time querying triggered conditional properties", q3.s(str), gVarK3.d().u(str2), Long.valueOf(j));
                    listF3 = Collections.emptyList();
                } else {
                    listF3 = gVarK3.F("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listF3.size());
                for (zzz zzzVar3 : listF3) {
                    if (zzzVar3 != null) {
                        zzku zzkuVar = zzzVar3.l;
                        u9 u9Var = new u9(zzzVar3.j, zzzVar3.k, zzkuVar.k, j, zzkuVar.w0());
                        if (K().M(u9Var)) {
                            this.k.g().n.d("User property triggered", zzzVar3.j, this.k.u().y(u9Var.c), u9Var.e);
                        } else {
                            this.k.g().f.d("Too many active user properties, ignoring", q3.s(zzzVar3.j), this.k.u().y(u9Var.c), u9Var.e);
                        }
                        zzaq zzaqVar5 = zzzVar3.r;
                        if (zzaqVar5 != null) {
                            arrayList2.add(zzaqVar5);
                        }
                        zzzVar3.l = new zzku(u9Var);
                        zzzVar3.n = true;
                        K().N(zzzVar3);
                    }
                }
                I(zzaqVar2, zznVar);
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    I(new zzaq((zzaq) obj2, j), zznVar);
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00d7  */
    @WorkerThread
    public final void m(zzaq zzaqVar, String str) throws Throwable {
        boolean z2;
        String strD;
        a4 a4VarT = K().T(str);
        if (a4VarT == null || TextUtils.isEmpty(a4VarT.M())) {
            this.k.g().m.b("No app data available; dropping event", str);
            return;
        }
        Boolean boolZ = z(a4VarT);
        if (boolZ == null) {
            if (!"_ui".equals(zzaqVar.j)) {
                this.k.g().i.b("Could not find package. appId", q3.s(str));
            }
        } else if (!boolZ.booleanValue()) {
            this.k.g().f.b("App version does not match; dropping event. appId", q3.s(str));
            return;
        }
        String strV = a4VarT.v();
        String strM = a4VarT.M();
        long jN = a4VarT.N();
        String strO = a4VarT.O();
        long jP = a4VarT.P();
        long jQ = a4VarT.Q();
        boolean zT = a4VarT.T();
        String strH = a4VarT.H();
        long jG = a4VarT.g();
        boolean zH = a4VarT.h();
        boolean zI = a4VarT.i();
        String strY = a4VarT.y();
        Boolean boolJ = a4VarT.j();
        long jS = a4VarT.S();
        List<String> listK = a4VarT.k();
        if (b.i.a.f.h.l.da.b()) {
            z2 = zT;
            String strB = this.k.h.u(a4VarT.o(), p.f1561j0) ? a4VarT.B() : null;
            if (b.i.a.f.h.l.t8.b() || !this.k.h.o(p.J0)) {
                strD = "";
            } else {
                strD = a(str).d();
            }
            B(zzaqVar, new zzn(str, strV, strM, jN, strO, jP, jQ, (String) null, z2, false, strH, jG, 0L, 0, zH, zI, false, strY, boolJ, jS, listK, strB, strD));
        }
        z2 = zT;
        if (b.i.a.f.h.l.t8.b()) {
            strD = "";
        } else {
            strD = "";
        }
        B(zzaqVar, new zzn(str, strV, strM, jN, strO, jP, jQ, (String) null, z2, false, strH, jG, 0L, 0, zH, zI, false, strY, boolJ, jS, listK, strB, strD));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009d  */
    @WorkerThread
    public final void n(a4 a4Var) throws Throwable {
        U();
        if (b.i.a.f.h.l.da.b() && this.k.h.u(a4Var.o(), p.f1561j0)) {
            if (TextUtils.isEmpty(a4Var.v()) && TextUtils.isEmpty(a4Var.B()) && TextUtils.isEmpty(a4Var.y())) {
                r(a4Var.o(), 204, null, null, null);
                return;
            }
        } else if (TextUtils.isEmpty(a4Var.v()) && TextUtils.isEmpty(a4Var.y())) {
            r(a4Var.o(), 204, null, null, null);
            return;
        }
        c cVar = this.k.h;
        Objects.requireNonNull(cVar);
        Uri.Builder builder = new Uri.Builder();
        String strV = a4Var.v();
        if (TextUtils.isEmpty(strV)) {
            if (b.i.a.f.h.l.da.b() && cVar.a.h.u(a4Var.o(), p.f1561j0)) {
                strV = a4Var.B();
                if (TextUtils.isEmpty(strV)) {
                    strV = a4Var.y();
                }
            } else {
                strV = a4Var.y();
            }
        }
        ArrayMap arrayMap = null;
        Uri.Builder builderEncodedAuthority = builder.scheme(p.e.a(null)).encodedAuthority(p.f.a(null));
        String strValueOf = String.valueOf(strV);
        builderEncodedAuthority.path(strValueOf.length() != 0 ? "config/app/".concat(strValueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", a4Var.s()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "33025");
        String string = builder.build().toString();
        try {
            URL url = new URL(string);
            this.k.g().n.b("Fetching remote configuration", a4Var.o());
            b.i.a.f.h.l.u0 u0VarS = H().s(a4Var.o());
            p4 p4VarH = H();
            String strO = a4Var.o();
            p4VarH.b();
            String str = p4VarH.i.get(strO);
            if (u0VarS != null && !TextUtils.isEmpty(str)) {
                arrayMap = new ArrayMap();
                arrayMap.put("If-Modified-Since", str);
            }
            this.r = true;
            x3 x3VarJ = J();
            String strO2 = a4Var.o();
            l9 l9Var = new l9(this);
            x3VarJ.b();
            x3VarJ.n();
            x3VarJ.f().x(new c4(x3VarJ, strO2, url, null, arrayMap, l9Var));
        } catch (MalformedURLException unused) {
            this.k.g().f.c("Failed to parse config URL. Not fetching. appId", q3.s(a4Var.o()), string);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f0  */
    @WorkerThread
    public final void o(zzku zzkuVar, zzn zznVar) throws Throwable {
        l lVarZ;
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            int iH0 = this.k.t().h0(zzkuVar.k);
            if (iH0 != 0) {
                this.k.t();
                String strE = t9.E(zzkuVar.k, 24, true);
                String str = zzkuVar.k;
                this.k.t().S(this.A, zznVar.j, iH0, "_ev", strE, str != null ? str.length() : 0);
                return;
            }
            int iI0 = this.k.t().i0(zzkuVar.k, zzkuVar.w0());
            if (iI0 != 0) {
                this.k.t();
                String strE2 = t9.E(zzkuVar.k, 24, true);
                Object objW0 = zzkuVar.w0();
                this.k.t().S(this.A, zznVar.j, iI0, "_ev", strE2, (objW0 == null || !((objW0 instanceof String) || (objW0 instanceof CharSequence))) ? 0 : String.valueOf(objW0).length());
                return;
            }
            Object objN0 = this.k.t().n0(zzkuVar.k, zzkuVar.w0());
            if (objN0 == null) {
                return;
            }
            if ("_sid".equals(zzkuVar.k)) {
                long j = zzkuVar.l;
                String str2 = zzkuVar.o;
                long jLongValue = 0;
                u9 u9VarY = K().Y(zznVar.j, "_sno");
                if (u9VarY != null) {
                    Object obj = u9VarY.e;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (u9VarY != null) {
                            this.k.g().i.b("Retrieved last session number from database does not contain a valid (long) value", u9VarY.e);
                        }
                        lVarZ = K().z(zznVar.j, "_s");
                        if (lVarZ != null) {
                            jLongValue = lVarZ.c;
                            this.k.g().n.b("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        }
                    }
                } else {
                    if (u9VarY != null) {
                        this.k.g().i.b("Retrieved last session number from database does not contain a valid (long) value", u9VarY.e);
                    }
                    lVarZ = K().z(zznVar.j, "_s");
                    if (lVarZ != null) {
                        jLongValue = lVarZ.c;
                        this.k.g().n.b("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                    }
                }
                o(new zzku("_sno", j, Long.valueOf(jLongValue + 1), str2), zznVar);
            }
            u9 u9Var = new u9(zznVar.j, zzkuVar.o, zzkuVar.k, zzkuVar.l, objN0);
            this.k.g().n.c("Setting user property", this.k.u().y(u9Var.c), objN0);
            K().b0();
            try {
                G(zznVar);
                boolean zM = K().M(u9Var);
                K().s();
                if (!zM) {
                    this.k.g().f.c("Too many unique user properties are set. Ignoring user property", this.k.u().y(u9Var.c), u9Var.e);
                    this.k.t().S(this.A, zznVar.j, 9, null, null, 0);
                }
            } finally {
                K().e0();
            }
        }
    }

    @WorkerThread
    public final void p(zzn zznVar) throws Throwable {
        if (this.w != null) {
            ArrayList arrayList = new ArrayList();
            this.f1544x = arrayList;
            arrayList.addAll(this.w);
        }
        g gVarK = K();
        String str = zznVar.j;
        AnimatableValueParser.w(str);
        gVarK.b();
        gVarK.n();
        try {
            SQLiteDatabase sQLiteDatabaseT = gVarK.t();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseT.delete("apps", "app_id=?", strArr) + 0 + sQLiteDatabaseT.delete("events", "app_id=?", strArr) + sQLiteDatabaseT.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseT.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseT.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseT.delete("queue", "app_id=?", strArr) + sQLiteDatabaseT.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseT.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseT.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                gVarK.g().n.c("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            gVarK.g().f.c("Error resetting analytics data. appId, error", q3.s(str), e);
        }
        if (zznVar.q) {
            E(zznVar);
        }
    }

    @WorkerThread
    public final void q(zzz zzzVar, zzn zznVar) throws Throwable {
        zzaq zzaqVar;
        boolean z2;
        Objects.requireNonNull(zzzVar, "null reference");
        AnimatableValueParser.w(zzzVar.j);
        Objects.requireNonNull(zzzVar.k, "null reference");
        Objects.requireNonNull(zzzVar.l, "null reference");
        AnimatableValueParser.w(zzzVar.l.k);
        U();
        P();
        if (L(zznVar)) {
            if (!zznVar.q) {
                G(zznVar);
                return;
            }
            zzz zzzVar2 = new zzz(zzzVar);
            boolean z3 = false;
            zzzVar2.n = false;
            K().b0();
            try {
                zzz zzzVarZ = K().Z(zzzVar2.j, zzzVar2.l.k);
                if (zzzVarZ != null && !zzzVarZ.k.equals(zzzVar2.k)) {
                    this.k.g().i.d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.k.u().y(zzzVar2.l.k), zzzVar2.k, zzzVarZ.k);
                }
                if (zzzVarZ != null && (z2 = zzzVarZ.n)) {
                    zzzVar2.k = zzzVarZ.k;
                    zzzVar2.m = zzzVarZ.m;
                    zzzVar2.q = zzzVarZ.q;
                    zzzVar2.o = zzzVarZ.o;
                    zzzVar2.r = zzzVarZ.r;
                    zzzVar2.n = z2;
                    zzku zzkuVar = zzzVar2.l;
                    zzzVar2.l = new zzku(zzkuVar.k, zzzVarZ.l.l, zzkuVar.w0(), zzzVarZ.l.o);
                } else if (TextUtils.isEmpty(zzzVar2.o)) {
                    zzku zzkuVar2 = zzzVar2.l;
                    zzzVar2.l = new zzku(zzkuVar2.k, zzzVar2.m, zzkuVar2.w0(), zzzVar2.l.o);
                    zzzVar2.n = true;
                    z3 = true;
                }
                if (zzzVar2.n) {
                    zzku zzkuVar3 = zzzVar2.l;
                    u9 u9Var = new u9(zzzVar2.j, zzzVar2.k, zzkuVar3.k, zzkuVar3.l, zzkuVar3.w0());
                    if (K().M(u9Var)) {
                        this.k.g().m.d("User property updated immediately", zzzVar2.j, this.k.u().y(u9Var.c), u9Var.e);
                    } else {
                        this.k.g().f.d("(2)Too many active user properties, ignoring", q3.s(zzzVar2.j), this.k.u().y(u9Var.c), u9Var.e);
                    }
                    if (z3 && (zzaqVar = zzzVar2.r) != null) {
                        I(new zzaq(zzaqVar, zzzVar2.m), zznVar);
                    }
                }
                if (K().N(zzzVar2)) {
                    this.k.g().m.d("Conditional property added", zzzVar2.j, this.k.u().y(zzzVar2.l.k), zzzVar2.l.w0());
                } else {
                    this.k.g().f.d("Too many conditional properties, ignoring", q3.s(zzzVar2.j), this.k.u().y(zzzVar2.l.k), zzzVar2.l.w0());
                }
                K().s();
            } finally {
                K().e0();
            }
        }
    }

    @WorkerThread
    public final void r(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        U();
        P();
        AnimatableValueParser.w(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.r = false;
                x();
                throw th2;
            }
        }
        this.k.g().n.b("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        K().b0();
        try {
            a4 a4VarT = K().T(str);
            boolean z2 = true;
            boolean z3 = (i == 200 || i == 204 || i == 304) && th == null;
            if (a4VarT == null) {
                this.k.g().i.b("App does not exist in onConfigFetched. appId", q3.s(str));
            } else if (z3 || i == 404) {
                List<String> list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : list.get(0);
                if (i != 404 && i != 304) {
                    H().w(str, bArr, str2);
                } else if (H().s(str) == null) {
                    H().w(str, null, null);
                }
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                a4VarT.F(System.currentTimeMillis());
                K().I(a4VarT);
                if (i == 404) {
                    this.k.g().k.b("Config not found. Using empty config. appId", str);
                } else {
                    this.k.g().n.c("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (J().u() && v()) {
                    Q();
                } else {
                    w();
                }
            } else {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                a4VarT.I(System.currentTimeMillis());
                K().I(a4VarT);
                this.k.g().n.c("Fetching config failed. code, error", Integer.valueOf(i), th);
                p4 p4VarH = H();
                p4VarH.b();
                p4VarH.i.put(str, null);
                h4 h4Var = this.k.o().g;
                Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                h4Var.b(System.currentTimeMillis());
                if (i != 503 && i != 429) {
                    z2 = false;
                }
                if (z2) {
                    h4 h4Var2 = this.k.o().h;
                    Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
                    h4Var2.b(System.currentTimeMillis());
                }
                w();
            }
            K().s();
            K().e0();
            this.r = false;
            x();
        } catch (Throwable th3) {
            K().e0();
            throw th3;
        }
    }

    @WorkerThread
    public final void s(String str, d dVar) {
        if (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) {
            U();
            P();
            this.f1546z.put(str, dVar);
            g gVarK = K();
            if (b.i.a.f.h.l.t8.b() && gVarK.a.h.o(p.J0)) {
                Objects.requireNonNull(str, "null reference");
                gVarK.b();
                gVarK.n();
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("consent_state", dVar.d());
                try {
                    if (gVarK.t().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                        gVarK.g().f.b("Failed to insert/update consent setting (got -1). appId", q3.s(str));
                    }
                } catch (SQLiteException e) {
                    gVarK.g().f.c("Error storing consent setting. appId, error", q3.s(str), e);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 42621. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @androidx.annotation.WorkerThread
    public final boolean t(long r44) {
        /*
            Method dump skipped, instruction units count: 4262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.f.i.b.k9.t(long):boolean");
    }

    public final boolean u(a1.a aVar, a1.a aVar2) {
        AnimatableValueParser.l("_e".equals(aVar.y()));
        N();
        b.i.a.f.h.l.c1 c1VarW = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar.p()), "_sc");
        String strG = c1VarW == null ? null : c1VarW.G();
        N();
        b.i.a.f.h.l.c1 c1VarW2 = q9.w((b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVar2.p()), "_pc");
        String strG2 = c1VarW2 != null ? c1VarW2.G() : null;
        if (strG2 == null || !strG2.equals(strG)) {
            return false;
        }
        A(aVar, aVar2);
        return true;
    }

    public final boolean v() throws Throwable {
        U();
        P();
        return ((K().S("select count(1) > 0 from raw_events", null) > 0L ? 1 : (K().S("select count(1) > 0 from raw_events", null) == 0L ? 0 : -1)) != 0) || !TextUtils.isEmpty(K().u());
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00a5  */
    @WorkerThread
    public final void w() throws Throwable {
        boolean z2;
        long jMax;
        long jMax2;
        int iIntValue;
        U();
        P();
        if (this.n > 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            long jAbs = 3600000 - Math.abs(SystemClock.elapsedRealtime() - this.n);
            if (jAbs > 0) {
                this.k.g().n.b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                S().a();
                T().s();
                return;
            }
            this.n = 0L;
        }
        if (!this.k.m() || !v()) {
            this.k.g().n.a("Nothing to upload or uploading impossible");
            S().a();
            T().s();
            return;
        }
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax3 = Math.max(0L, p.A.a(null).longValue());
        if (K().S("select count(1) > 0 from raw_events where realtime = 1", null) != 0) {
            z2 = true;
        } else {
            if (K().S("select count(1) > 0 from queue where has_realtime = 1", null) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            String strH = this.k.h.h("debug.firebase.analytics.app", "");
            jMax = (TextUtils.isEmpty(strH) || ".none.".equals(strH)) ? Math.max(0L, p.u.a(null).longValue()) : Math.max(0L, p.v.a(null).longValue());
        } else {
            jMax = Math.max(0L, p.t.a(null).longValue());
        }
        long jA = this.k.o().f.a();
        long jA2 = this.k.o().g.a();
        long j = jMax;
        long jMax4 = Math.max(K().w("select max(bundle_end_timestamp) from queue", null, 0L), K().w("select max(timestamp) from raw_events", null, 0L));
        if (jMax4 != 0) {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jA - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jA2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jAbs3, jAbs4);
            jMax2 = jMax3 + jAbs2;
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + j;
            }
            if (!N().N(jMax5, j)) {
                jMax2 = jMax5 + j;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    if (i >= Math.min(20, Math.max(0, p.C.a(null).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    jMax2 += Math.max(0L, p.B.a(null).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } else {
            jMax2 = 0;
            break;
        }
        if (jMax2 == 0) {
            this.k.g().n.a("Next upload time is 0");
            S().a();
            T().s();
            return;
        }
        if (!J().u()) {
            this.k.g().n.a("No network");
            b4 b4VarS = S();
            b4VarS.a.P();
            b4VarS.a.f().b();
            if (!b4VarS.f1520b) {
                b4VarS.a.k.f1570b.registerReceiver(b4VarS, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                b4VarS.c = b4VarS.a.J().u();
                b4VarS.a.g().n.b("Registering connectivity change receiver. Network connected", Boolean.valueOf(b4VarS.c));
                b4VarS.f1520b = true;
            }
            T().s();
            return;
        }
        long jA3 = this.k.o().h.a();
        long jMax6 = Math.max(0L, p.r.a(null).longValue());
        if (!N().N(jA3, jMax6)) {
            jMax2 = Math.max(jMax2, jA3 + jMax6);
        }
        S().a();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
        long jCurrentTimeMillis2 = jMax2 - System.currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            jCurrentTimeMillis2 = Math.max(0L, p.w.a(null).longValue());
            h4 h4Var = this.k.o().f;
            Objects.requireNonNull((b.i.a.f.e.o.c) this.k.o);
            h4Var.b(System.currentTimeMillis());
        }
        this.k.g().n.b("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        h9 h9VarT = T();
        h9VarT.n();
        Context context = h9VarT.a.f1570b;
        if (!n4.a(context)) {
            h9VarT.g().m.a("Receiver not registered/enabled");
        }
        if (!t9.U(context)) {
            h9VarT.g().m.a("Service not registered/enabled");
        }
        h9VarT.s();
        h9VarT.g().n.b("Scheduling upload, millis", Long.valueOf(jCurrentTimeMillis2));
        Objects.requireNonNull((b.i.a.f.e.o.c) h9VarT.a.o);
        long jElapsedRealtime = SystemClock.elapsedRealtime() + jCurrentTimeMillis2;
        if (jCurrentTimeMillis2 < Math.max(0L, p.f1563x.a(null).longValue())) {
            if (!(h9VarT.e.d != 0)) {
                h9VarT.e.b(jCurrentTimeMillis2);
            }
        }
        if (Build.VERSION.SDK_INT < 24) {
            h9VarT.d.setInexactRepeating(2, jElapsedRealtime, Math.max(p.f1562s.a(null).longValue(), jCurrentTimeMillis2), h9VarT.u());
            return;
        }
        Context context2 = h9VarT.a.f1570b;
        ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iT = h9VarT.t();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        JobInfo jobInfoBuild = new JobInfo.Builder(iT, componentName).setMinimumLatency(jCurrentTimeMillis2).setOverrideDeadline(jCurrentTimeMillis2 << 1).setExtras(persistableBundle).build();
        Method method = b.i.a.f.h.l.a4.a;
        JobScheduler jobScheduler = (JobScheduler) context2.getSystemService("jobscheduler");
        if (b.i.a.f.h.l.a4.a == null || context2.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            jobScheduler.schedule(jobInfoBuild);
            return;
        }
        Method method2 = b.i.a.f.h.l.a4.f1435b;
        if (method2 != null) {
            try {
                iIntValue = ((Integer) method2.invoke(null, new Object[0])).intValue();
            } catch (IllegalAccessException | InvocationTargetException e) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e);
                }
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        Method method3 = b.i.a.f.h.l.a4.a;
        if (method3 != null) {
            try {
                ((Integer) method3.invoke(jobScheduler, jobInfoBuild, "com.google.android.gms", Integer.valueOf(iIntValue), "UploadAlarm")).intValue();
                return;
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e("UploadAlarm", "error calling scheduleAsPackage", e2);
            }
        }
        jobScheduler.schedule(jobInfoBuild);
    }

    @WorkerThread
    public final void x() {
        U();
        if (this.r || this.f1543s || this.t) {
            this.k.g().n.d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.f1543s), Boolean.valueOf(this.t));
            return;
        }
        this.k.g().n.a("Stopping uploading service(s)");
        List<Runnable> list = this.o;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.o.clear();
    }

    @WorkerThread
    public final zzn y(String str) throws Throwable {
        a4 a4VarT = K().T(str);
        if (a4VarT == null || TextUtils.isEmpty(a4VarT.M())) {
            this.k.g().m.b("No app data available; dropping", str);
            return null;
        }
        Boolean boolZ = z(a4VarT);
        if (boolZ != null && !boolZ.booleanValue()) {
            this.k.g().f.b("App version does not match; dropping. appId", q3.s(str));
            return null;
        }
        return new zzn(str, a4VarT.v(), a4VarT.M(), a4VarT.N(), a4VarT.O(), a4VarT.P(), a4VarT.Q(), (String) null, a4VarT.T(), false, a4VarT.H(), a4VarT.g(), 0L, 0, a4VarT.h(), a4VarT.i(), false, a4VarT.y(), a4VarT.j(), a4VarT.S(), a4VarT.k(), (b.i.a.f.h.l.da.b() && this.k.h.u(str, p.f1561j0)) ? a4VarT.B() : null, (b.i.a.f.h.l.t8.b() && this.k.h.o(p.J0)) ? a(str).d() : "");
    }

    @WorkerThread
    public final Boolean z(a4 a4Var) {
        try {
            if (a4Var.N() != -2147483648L) {
                if (a4Var.N() == b.i.a.f.e.p.b.a(this.k.f1570b).b(a4Var.o(), 0).versionCode) {
                    return Boolean.TRUE;
                }
            } else {
                String str = b.i.a.f.e.p.b.a(this.k.f1570b).b(a4Var.o(), 0).versionName;
                if (a4Var.M() != null && a4Var.M().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
