package b.i.a.f.h.j;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import b.c.a.a0.AnimatableValueParser;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends e {
    public boolean l;
    public final o m;
    public final o0 n;
    public final n0 o;
    public final j p;
    public long q;
    public final a0 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final a0 f1424s;
    public final y0 t;
    public long u;
    public boolean v;

    public r(g gVar, i iVar) {
        super(gVar);
        this.q = Long.MIN_VALUE;
        this.o = new n0(gVar);
        this.m = new o(gVar);
        this.n = new o0(gVar);
        this.p = new j(gVar);
        this.t = new y0(this.j.d);
        this.r = new s(this, gVar);
        this.f1424s = new t(this, gVar);
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        this.m.J();
        this.n.J();
        this.p.J();
    }

    public final void O() {
        b.i.a.f.b.f.b();
        b.i.a.f.b.f.b();
        N();
        if (!e0.a.a.booleanValue()) {
            D("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.p.R()) {
            C("Service not connected");
            return;
        }
        if (this.m.R()) {
            return;
        }
        C("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                ArrayList arrayList = (ArrayList) this.m.T(z.c());
                if (arrayList.isEmpty()) {
                    U();
                    return;
                }
                while (!arrayList.isEmpty()) {
                    j0 j0Var = (j0) arrayList.get(0);
                    if (!this.p.S(j0Var)) {
                        U();
                        return;
                    }
                    arrayList.remove(j0Var);
                    try {
                        this.m.W(j0Var.c);
                    } catch (SQLiteException e) {
                        A("Failed to remove hit that was send for delivery", e);
                        W();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                A("Failed to read hits from store", e2);
                W();
                return;
            }
        }
    }

    public final void R(d0 d0Var) {
        long jAbs;
        long j = this.u;
        b.i.a.f.b.f.b();
        N();
        long jO = u().O();
        if (jO != 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
            jAbs = Math.abs(System.currentTimeMillis() - jO);
        } else {
            jAbs = -1;
        }
        d("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jAbs));
        S();
        try {
            T();
            u().R();
            U();
            if (d0Var != null) {
                d0Var.a(null);
            }
            if (this.u != j) {
                Context context = this.o.f1423b.f1417b;
                Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                intent.addCategory(context.getPackageName());
                intent.putExtra(n0.a, true);
                context.sendOrderedBroadcast(intent, null);
            }
        } catch (Exception e) {
            A("Local dispatch failed", e);
            u().R();
            U();
            if (d0Var != null) {
                d0Var.a(e);
            }
        }
    }

    public final void S() {
        k0 k0Var;
        if (this.v || !e0.a.a.booleanValue() || this.p.R()) {
            return;
        }
        if (this.t.b(e0.f1415z.a.longValue())) {
            this.t.a();
            C("Connecting to service");
            j jVar = this.p;
            Objects.requireNonNull(jVar);
            b.i.a.f.b.f.b();
            jVar.N();
            boolean z2 = true;
            if (jVar.m == null) {
                l lVar = jVar.l;
                Objects.requireNonNull(lVar);
                b.i.a.f.b.f.b();
                Intent intent = new Intent("com.google.android.gms.analytics.service.START");
                intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
                Context context = lVar.l.j.f1417b;
                intent.putExtra("app_package_name", context.getPackageName());
                b.i.a.f.e.n.a aVarB = b.i.a.f.e.n.a.b();
                synchronized (lVar) {
                    k0Var = null;
                    lVar.j = null;
                    lVar.k = true;
                    boolean zA = aVarB.a(context, intent, lVar.l.l, Opcodes.LOR);
                    lVar.l.b("Bind to service requested", Boolean.valueOf(zA));
                    if (zA) {
                        try {
                            lVar.wait(e0.f1414y.a.longValue());
                        } catch (InterruptedException unused) {
                            lVar.l.D("Wait for service connect was interrupted");
                        }
                        lVar.k = false;
                        k0 k0Var2 = lVar.j;
                        lVar.j = null;
                        if (k0Var2 == null) {
                            lVar.l.H("Successfully bound to service but never got onServiceConnected callback");
                        }
                        k0Var = k0Var2;
                    } else {
                        lVar.k = false;
                    }
                }
                if (k0Var != null) {
                    jVar.m = k0Var;
                    jVar.T();
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                C("Connected to service");
                this.t.f1429b = 0L;
                O();
            }
        }
    }

    public final boolean T() {
        b.i.a.f.b.f.b();
        N();
        C("Dispatching a batch of local hits");
        boolean z2 = !this.p.R();
        boolean z3 = !this.n.W();
        if (z2 && z3) {
            C("No network or service available. Will retry later");
            return false;
        }
        long jMax = Math.max(z.c(), e0.h.a.intValue());
        ArrayList arrayList = new ArrayList();
        long jMax2 = 0;
        while (true) {
            try {
                o oVar = this.m;
                oVar.N();
                oVar.O().beginTransaction();
                arrayList.clear();
                try {
                    List<j0> listT = this.m.T(jMax);
                    ArrayList arrayList2 = (ArrayList) listT;
                    if (arrayList2.isEmpty()) {
                        C("Store is empty, nothing to dispatch");
                        W();
                        try {
                            this.m.setTransactionSuccessful();
                            this.m.endTransaction();
                            return false;
                        } catch (SQLiteException e) {
                            A("Failed to commit local dispatch transaction", e);
                            W();
                            return false;
                        }
                    }
                    b("Hits loaded from store. count", Integer.valueOf(arrayList2.size()));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        if (((j0) it.next()).c == jMax2) {
                            y("Database contains successfully uploaded hit", Long.valueOf(jMax2), Integer.valueOf(arrayList2.size()));
                            W();
                            try {
                                this.m.setTransactionSuccessful();
                                this.m.endTransaction();
                                return false;
                            } catch (SQLiteException e2) {
                                A("Failed to commit local dispatch transaction", e2);
                                W();
                                return false;
                            }
                        }
                    }
                    if (this.p.R()) {
                        C("Service connected, sending hits to the service");
                        while (!arrayList2.isEmpty()) {
                            j0 j0Var = (j0) arrayList2.get(0);
                            if (!this.p.S(j0Var)) {
                                break;
                            }
                            jMax2 = Math.max(jMax2, j0Var.c);
                            arrayList2.remove(j0Var);
                            d("Hit sent do device AnalyticsService for delivery", j0Var);
                            try {
                                this.m.W(j0Var.c);
                                arrayList.add(Long.valueOf(j0Var.c));
                            } catch (SQLiteException e3) {
                                A("Failed to remove hit that was send for delivery", e3);
                                W();
                                try {
                                    this.m.setTransactionSuccessful();
                                    this.m.endTransaction();
                                    return false;
                                } catch (SQLiteException e4) {
                                    A("Failed to commit local dispatch transaction", e4);
                                    W();
                                    return false;
                                }
                            }
                        }
                    }
                    if (this.n.W()) {
                        List<Long> listV = this.n.V(listT);
                        Iterator<Long> it2 = listV.iterator();
                        while (it2.hasNext()) {
                            jMax2 = Math.max(jMax2, it2.next().longValue());
                        }
                        try {
                            this.m.S(listV);
                            arrayList.addAll(listV);
                        } catch (SQLiteException e5) {
                            A("Failed to remove successfully uploaded hits", e5);
                            W();
                            try {
                                this.m.setTransactionSuccessful();
                                this.m.endTransaction();
                                return false;
                            } catch (SQLiteException e6) {
                                A("Failed to commit local dispatch transaction", e6);
                                W();
                                return false;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            this.m.setTransactionSuccessful();
                            this.m.endTransaction();
                            return false;
                        } catch (SQLiteException e7) {
                            A("Failed to commit local dispatch transaction", e7);
                            W();
                            return false;
                        }
                    }
                    try {
                        this.m.setTransactionSuccessful();
                        this.m.endTransaction();
                    } catch (SQLiteException e8) {
                        A("Failed to commit local dispatch transaction", e8);
                        W();
                        return false;
                    }
                } catch (SQLiteException e9) {
                    x("Failed to read hits from persisted store", e9);
                    W();
                    try {
                        this.m.setTransactionSuccessful();
                        this.m.endTransaction();
                        return false;
                    } catch (SQLiteException e10) {
                        A("Failed to commit local dispatch transaction", e10);
                        W();
                        return false;
                    }
                }
            } catch (Throwable th) {
                this.m.setTransactionSuccessful();
                this.m.endTransaction();
                throw th;
            }
            try {
                this.m.setTransactionSuccessful();
                this.m.endTransaction();
                throw th;
            } catch (SQLiteException e11) {
                A("Failed to commit local dispatch transaction", e11);
                W();
                return false;
            }
        }
    }

    public final void U() {
        long jMin;
        long jAbs;
        b.i.a.f.b.f.b();
        N();
        boolean z2 = true;
        if (!(!this.v && X() > 0)) {
            this.o.a();
            W();
            return;
        }
        if (this.m.R()) {
            this.o.a();
            W();
            return;
        }
        if (!e0.w.a.booleanValue()) {
            n0 n0Var = this.o;
            n0Var.f1423b.c();
            n0Var.f1423b.e();
            if (!n0Var.c) {
                Context context = n0Var.f1423b.f1417b;
                context.registerReceiver(n0Var, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                intentFilter.addCategory(context.getPackageName());
                context.registerReceiver(n0Var, intentFilter);
                n0Var.d = n0Var.b();
                n0Var.f1423b.c().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(n0Var.d));
                n0Var.c = true;
            }
            n0 n0Var2 = this.o;
            if (!n0Var2.c) {
                n0Var2.f1423b.c().D("Connectivity unknown. Receiver not registered");
            }
            z2 = n0Var2.d;
        }
        if (!z2) {
            W();
            V();
            return;
        }
        V();
        long jX = X();
        long jO = u().O();
        if (jO != 0) {
            Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
            jMin = jX - Math.abs(System.currentTimeMillis() - jO);
            if (jMin <= 0) {
                jMin = Math.min(e0.d.a.longValue(), jX);
            }
        } else {
            jMin = Math.min(e0.d.a.longValue(), jX);
        }
        b("Dispatch scheduled (ms)", Long.valueOf(jMin));
        if (!this.r.d()) {
            this.r.e(jMin);
            return;
        }
        a0 a0Var = this.r;
        if (a0Var.d == 0) {
            jAbs = 0;
        } else {
            Objects.requireNonNull((b.i.a.f.e.o.c) a0Var.f1409b.d);
            jAbs = Math.abs(System.currentTimeMillis() - a0Var.d);
        }
        long jMax = Math.max(1L, jMin + jAbs);
        a0 a0Var2 = this.r;
        if (a0Var2.d()) {
            if (jMax < 0) {
                a0Var2.a();
                return;
            }
            Objects.requireNonNull((b.i.a.f.e.o.c) a0Var2.f1409b.d);
            long jAbs2 = jMax - Math.abs(System.currentTimeMillis() - a0Var2.d);
            long j = jAbs2 >= 0 ? jAbs2 : 0L;
            a0Var2.b().removeCallbacks(a0Var2.c);
            if (a0Var2.b().postDelayed(a0Var2.c, j)) {
                return;
            }
            a0Var2.f1409b.c().A("Failed to adjust delayed post. time", Long.valueOf(j));
        }
    }

    public final void V() {
        long jV;
        g gVar = this.j;
        g.a(gVar.i);
        c0 c0Var = gVar.i;
        if (c0Var.l && !c0Var.m) {
            b.i.a.f.b.f.b();
            N();
            try {
                jV = this.m.V();
            } catch (SQLiteException e) {
                A("Failed to get min/max hit times from local store", e);
                jV = 0;
            }
            if (jV != 0) {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
                if (Math.abs(System.currentTimeMillis() - jV) <= e0.f.a.longValue()) {
                    b("Dispatch alarm scheduled (ms)", Long.valueOf(z.b()));
                    c0Var.N();
                    AnimatableValueParser.G(c0Var.l, "Receiver not registered");
                    long jB = z.b();
                    if (jB > 0) {
                        c0Var.O();
                        Objects.requireNonNull((b.i.a.f.e.o.c) c0Var.j.d);
                        long jElapsedRealtime = SystemClock.elapsedRealtime() + jB;
                        c0Var.m = true;
                        e0.C.a.booleanValue();
                        if (Build.VERSION.SDK_INT < 24) {
                            c0Var.C("Scheduling upload with AlarmManager");
                            c0Var.n.setInexactRepeating(2, jElapsedRealtime, jB, c0Var.S());
                            return;
                        }
                        c0Var.C("Scheduling upload with JobScheduler");
                        Context context = c0Var.j.f1417b;
                        ComponentName componentName = new ComponentName(context, "com.google.android.gms.analytics.AnalyticsJobService");
                        int iR = c0Var.R();
                        PersistableBundle persistableBundle = new PersistableBundle();
                        persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                        JobInfo jobInfoBuild = new JobInfo.Builder(iR, componentName).setMinimumLatency(jB).setOverrideDeadline(jB << 1).setExtras(persistableBundle).build();
                        c0Var.b("Scheduling job. JobID", Integer.valueOf(iR));
                        Method method = b1.a;
                        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                        if (b1.a != null) {
                            Objects.requireNonNull((c1) b1.c);
                        }
                        jobScheduler.schedule(jobInfoBuild);
                    }
                }
            }
        }
    }

    public final void W() {
        if (this.r.d()) {
            C("All hits dispatched or no network/service. Going to power save mode");
        }
        this.r.a();
        g gVar = this.j;
        g.a(gVar.i);
        c0 c0Var = gVar.i;
        if (c0Var.m) {
            c0Var.O();
        }
    }

    public final long X() {
        long j = this.q;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long jLongValue = e0.c.a.longValue();
        a1 a1VarT = t();
        a1VarT.N();
        if (!a1VarT.n) {
            return jLongValue;
        }
        a1 a1VarT2 = t();
        a1VarT2.N();
        return ((long) a1VarT2.o) * 1000;
    }

    public final boolean b0(String str) {
        return b.i.a.f.e.p.b.a(this.j.f1417b).a.checkCallingOrSelfPermission(str) == 0;
    }
}
