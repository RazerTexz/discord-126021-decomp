package p007b.p225i.p226a.p288f.p313h.p323j;

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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p307n.C3398a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p310p.C3411b;

/* JADX INFO: renamed from: b.i.a.f.h.j.r */
/* JADX INFO: loaded from: classes3.dex */
public final class C3538r extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public boolean f9782l;

    /* JADX INFO: renamed from: m */
    public final C3532o f9783m;

    /* JADX INFO: renamed from: n */
    public final C3533o0 f9784n;

    /* JADX INFO: renamed from: o */
    public final C3531n0 f9785o;

    /* JADX INFO: renamed from: p */
    public final C3522j f9786p;

    /* JADX INFO: renamed from: q */
    public long f9787q;

    /* JADX INFO: renamed from: r */
    public final AbstractC3498a0 f9788r;

    /* JADX INFO: renamed from: s */
    public final AbstractC3498a0 f9789s;

    /* JADX INFO: renamed from: t */
    public final C3553y0 f9790t;

    /* JADX INFO: renamed from: u */
    public long f9791u;

    /* JADX INFO: renamed from: v */
    public boolean f9792v;

    public C3538r(C3515g c3515g, C3520i c3520i) {
        super(c3515g);
        this.f9787q = Long.MIN_VALUE;
        this.f9785o = new C3531n0(c3515g);
        this.f9783m = new C3532o(c3515g);
        this.f9784n = new C3533o0(c3515g);
        this.f9786p = new C3522j(c3515g);
        this.f9790t = new C3553y0(this.f9684j.f9724d);
        this.f9788r = new C3540s(this, c3515g);
        this.f9789s = new C3542t(this, c3515g);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        this.f9783m.m4443J();
        this.f9784n.m4443J();
        this.f9786p.m4443J();
    }

    /* JADX INFO: renamed from: O */
    public final void m4487O() {
        C3180f.m3967b();
        C3180f.m3967b();
        m4444N();
        if (!C3510e0.f9689a.f9716a.booleanValue()) {
            m4428D("Service client disabled. Can't dispatch local hits to device AnalyticsService");
        }
        if (!this.f9786p.m4458R()) {
            m4427C("Service not connected");
            return;
        }
        if (this.f9783m.m4469R()) {
            return;
        }
        m4427C("Dispatching local hits to device AnalyticsService");
        while (true) {
            try {
                ArrayList arrayList = (ArrayList) this.f9783m.m4471T(C3554z.m4509c());
                if (arrayList.isEmpty()) {
                    m4491U();
                    return;
                }
                while (!arrayList.isEmpty()) {
                    C3523j0 c3523j0 = (C3523j0) arrayList.get(0);
                    if (!this.f9786p.m4459S(c3523j0)) {
                        m4491U();
                        return;
                    }
                    arrayList.remove(c3523j0);
                    try {
                        this.f9783m.m4474W(c3523j0.f9748c);
                    } catch (SQLiteException e) {
                        m4426A("Failed to remove hit that was send for delivery", e);
                        m4493W();
                        return;
                    }
                }
            } catch (SQLiteException e2) {
                m4426A("Failed to read hits from store", e2);
                m4493W();
                return;
            }
        }
    }

    /* JADX INFO: renamed from: R */
    public final void m4488R(InterfaceC3507d0 interfaceC3507d0) {
        long jAbs;
        long j = this.f9791u;
        C3180f.m3967b();
        m4444N();
        long jM4485O = m4438u().m4485O();
        if (jM4485O != 0) {
            Objects.requireNonNull((C3401c) this.f9684j.f9724d);
            jAbs = Math.abs(System.currentTimeMillis() - jM4485O);
        } else {
            jAbs = -1;
        }
        m4432d("Dispatching local hits. Elapsed time since last dispatch (ms)", Long.valueOf(jAbs));
        m4489S();
        try {
            m4490T();
            m4438u().m4486R();
            m4491U();
            if (interfaceC3507d0 != null) {
                interfaceC3507d0.mo4441a(null);
            }
            if (this.f9791u != j) {
                Context context = this.f9785o.f9765b.f9722b;
                Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
                intent.addCategory(context.getPackageName());
                intent.putExtra(C3531n0.f9764a, true);
                context.sendOrderedBroadcast(intent, null);
            }
        } catch (Exception e) {
            m4426A("Local dispatch failed", e);
            m4438u().m4486R();
            m4491U();
            if (interfaceC3507d0 != null) {
                interfaceC3507d0.mo4441a(e);
            }
        }
    }

    /* JADX INFO: renamed from: S */
    public final void m4489S() {
        InterfaceC3525k0 interfaceC3525k0;
        if (this.f9792v || !C3510e0.f9689a.f9716a.booleanValue() || this.f9786p.m4458R()) {
            return;
        }
        if (this.f9790t.m4507b(C3510e0.f9714z.f9716a.longValue())) {
            this.f9790t.m4506a();
            m4427C("Connecting to service");
            C3522j c3522j = this.f9786p;
            Objects.requireNonNull(c3522j);
            C3180f.m3967b();
            c3522j.m4444N();
            boolean z2 = true;
            if (c3522j.f9743m == null) {
                ServiceConnectionC3526l serviceConnectionC3526l = c3522j.f9742l;
                Objects.requireNonNull(serviceConnectionC3526l);
                C3180f.m3967b();
                Intent intent = new Intent("com.google.android.gms.analytics.service.START");
                intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
                Context context = serviceConnectionC3526l.f9756l.f9684j.f9722b;
                intent.putExtra("app_package_name", context.getPackageName());
                C3398a c3398aM4181b = C3398a.m4181b();
                synchronized (serviceConnectionC3526l) {
                    interfaceC3525k0 = null;
                    try {
                        serviceConnectionC3526l.f9754j = null;
                        serviceConnectionC3526l.f9755k = true;
                        boolean zM4182a = c3398aM4181b.m4182a(context, intent, serviceConnectionC3526l.f9756l.f9742l, Opcodes.LOR);
                        serviceConnectionC3526l.f9756l.m4431b("Bind to service requested", Boolean.valueOf(zM4182a));
                        if (zM4182a) {
                            try {
                                serviceConnectionC3526l.wait(C3510e0.f9713y.f9716a.longValue());
                            } catch (InterruptedException unused) {
                                serviceConnectionC3526l.f9756l.m4428D("Wait for service connect was interrupted");
                            }
                            serviceConnectionC3526l.f9755k = false;
                            InterfaceC3525k0 interfaceC3525k1 = serviceConnectionC3526l.f9754j;
                            serviceConnectionC3526l.f9754j = null;
                            if (interfaceC3525k1 == null) {
                                serviceConnectionC3526l.f9756l.m4429H("Successfully bound to service but never got onServiceConnected callback");
                            }
                            interfaceC3525k0 = interfaceC3525k1;
                        } else {
                            serviceConnectionC3526l.f9755k = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (interfaceC3525k0 != null) {
                    c3522j.f9743m = interfaceC3525k0;
                    c3522j.m4460T();
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                m4427C("Connected to service");
                this.f9790t.f9825b = 0L;
                m4487O();
            }
        }
    }

    /* JADX INFO: renamed from: T */
    public final boolean m4490T() {
        C3180f.m3967b();
        m4444N();
        m4427C("Dispatching a batch of local hits");
        boolean z2 = !this.f9786p.m4458R();
        boolean z3 = !this.f9784n.m4482W();
        if (z2 && z3) {
            m4427C("No network or service available. Will retry later");
            return false;
        }
        long jMax = Math.max(C3554z.m4509c(), C3510e0.f9696h.f9716a.intValue());
        ArrayList arrayList = new ArrayList();
        long jMax2 = 0;
        while (true) {
            try {
                C3532o c3532o = this.f9783m;
                c3532o.m4444N();
                c3532o.m4468O().beginTransaction();
                arrayList.clear();
                try {
                    List<C3523j0> listM4471T = this.f9783m.m4471T(jMax);
                    ArrayList arrayList2 = (ArrayList) listM4471T;
                    if (arrayList2.isEmpty()) {
                        m4427C("Store is empty, nothing to dispatch");
                        m4493W();
                        try {
                            this.f9783m.setTransactionSuccessful();
                            this.f9783m.endTransaction();
                            return false;
                        } catch (SQLiteException e) {
                            m4426A("Failed to commit local dispatch transaction", e);
                            m4493W();
                            return false;
                        }
                    }
                    m4431b("Hits loaded from store. count", Integer.valueOf(arrayList2.size()));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        if (((C3523j0) it.next()).f9748c == jMax2) {
                            m4440y("Database contains successfully uploaded hit", Long.valueOf(jMax2), Integer.valueOf(arrayList2.size()));
                            m4493W();
                            try {
                                this.f9783m.setTransactionSuccessful();
                                this.f9783m.endTransaction();
                                return false;
                            } catch (SQLiteException e2) {
                                m4426A("Failed to commit local dispatch transaction", e2);
                                m4493W();
                                return false;
                            }
                        }
                    }
                    if (this.f9786p.m4458R()) {
                        m4427C("Service connected, sending hits to the service");
                        while (!arrayList2.isEmpty()) {
                            C3523j0 c3523j0 = (C3523j0) arrayList2.get(0);
                            if (!this.f9786p.m4459S(c3523j0)) {
                                break;
                            }
                            jMax2 = Math.max(jMax2, c3523j0.f9748c);
                            arrayList2.remove(c3523j0);
                            m4432d("Hit sent do device AnalyticsService for delivery", c3523j0);
                            try {
                                this.f9783m.m4474W(c3523j0.f9748c);
                                arrayList.add(Long.valueOf(c3523j0.f9748c));
                            } catch (SQLiteException e3) {
                                m4426A("Failed to remove hit that was send for delivery", e3);
                                m4493W();
                                try {
                                    this.f9783m.setTransactionSuccessful();
                                    this.f9783m.endTransaction();
                                    return false;
                                } catch (SQLiteException e4) {
                                    m4426A("Failed to commit local dispatch transaction", e4);
                                    m4493W();
                                    return false;
                                }
                            }
                        }
                    }
                    if (this.f9784n.m4482W()) {
                        List<Long> listM4481V = this.f9784n.m4481V(listM4471T);
                        Iterator<Long> it2 = listM4481V.iterator();
                        while (it2.hasNext()) {
                            jMax2 = Math.max(jMax2, it2.next().longValue());
                        }
                        try {
                            this.f9783m.m4470S(listM4481V);
                            arrayList.addAll(listM4481V);
                        } catch (SQLiteException e5) {
                            m4426A("Failed to remove successfully uploaded hits", e5);
                            m4493W();
                            try {
                                this.f9783m.setTransactionSuccessful();
                                this.f9783m.endTransaction();
                                return false;
                            } catch (SQLiteException e6) {
                                m4426A("Failed to commit local dispatch transaction", e6);
                                m4493W();
                                return false;
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        try {
                            this.f9783m.setTransactionSuccessful();
                            this.f9783m.endTransaction();
                            return false;
                        } catch (SQLiteException e7) {
                            m4426A("Failed to commit local dispatch transaction", e7);
                            m4493W();
                            return false;
                        }
                    }
                    try {
                        this.f9783m.setTransactionSuccessful();
                        this.f9783m.endTransaction();
                    } catch (SQLiteException e8) {
                        m4426A("Failed to commit local dispatch transaction", e8);
                        m4493W();
                        return false;
                    }
                } catch (SQLiteException e9) {
                    m4439x("Failed to read hits from persisted store", e9);
                    m4493W();
                    try {
                        this.f9783m.setTransactionSuccessful();
                        this.f9783m.endTransaction();
                        return false;
                    } catch (SQLiteException e10) {
                        m4426A("Failed to commit local dispatch transaction", e10);
                        m4493W();
                        return false;
                    }
                }
            } catch (Throwable th) {
                this.f9783m.setTransactionSuccessful();
                this.f9783m.endTransaction();
                throw th;
            }
            try {
                this.f9783m.setTransactionSuccessful();
                this.f9783m.endTransaction();
                throw th;
            } catch (SQLiteException e11) {
                m4426A("Failed to commit local dispatch transaction", e11);
                m4493W();
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: U */
    public final void m4491U() {
        long jMin;
        long jAbs;
        C3180f.m3967b();
        m4444N();
        boolean z2 = true;
        if (!(!this.f9792v && m4494X() > 0)) {
            this.f9785o.m4466a();
            m4493W();
            return;
        }
        if (this.f9783m.m4469R()) {
            this.f9785o.m4466a();
            m4493W();
            return;
        }
        if (!C3510e0.f9711w.f9716a.booleanValue()) {
            C3531n0 c3531n0 = this.f9785o;
            c3531n0.f9765b.m4451c();
            c3531n0.f9765b.m4453e();
            if (!c3531n0.f9766c) {
                Context context = c3531n0.f9765b.f9722b;
                context.registerReceiver(c3531n0, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
                intentFilter.addCategory(context.getPackageName());
                context.registerReceiver(c3531n0, intentFilter);
                c3531n0.f9767d = c3531n0.m4467b();
                c3531n0.f9765b.m4451c().m4431b("Registering connectivity change receiver. Network connected", Boolean.valueOf(c3531n0.f9767d));
                c3531n0.f9766c = true;
            }
            C3531n0 c3531n1 = this.f9785o;
            if (!c3531n1.f9766c) {
                c3531n1.f9765b.m4451c().m4428D("Connectivity unknown. Receiver not registered");
            }
            z2 = c3531n1.f9767d;
        }
        if (!z2) {
            m4493W();
            m4492V();
            return;
        }
        m4492V();
        long jM4494X = m4494X();
        long jM4485O = m4438u().m4485O();
        if (jM4485O != 0) {
            Objects.requireNonNull((C3401c) this.f9684j.f9724d);
            jMin = jM4494X - Math.abs(System.currentTimeMillis() - jM4485O);
            if (jMin <= 0) {
                jMin = Math.min(C3510e0.f9692d.f9716a.longValue(), jM4494X);
            }
        } else {
            jMin = Math.min(C3510e0.f9692d.f9716a.longValue(), jM4494X);
        }
        m4431b("Dispatch scheduled (ms)", Long.valueOf(jMin));
        if (!this.f9788r.m4419d()) {
            this.f9788r.m4420e(jMin);
            return;
        }
        AbstractC3498a0 abstractC3498a0 = this.f9788r;
        if (abstractC3498a0.f9665d == 0) {
            jAbs = 0;
        } else {
            Objects.requireNonNull((C3401c) abstractC3498a0.f9663b.f9724d);
            jAbs = Math.abs(System.currentTimeMillis() - abstractC3498a0.f9665d);
        }
        long jMax = Math.max(1L, jMin + jAbs);
        AbstractC3498a0 abstractC3498a1 = this.f9788r;
        if (abstractC3498a1.m4419d()) {
            if (jMax < 0) {
                abstractC3498a1.m4416a();
                return;
            }
            Objects.requireNonNull((C3401c) abstractC3498a1.f9663b.f9724d);
            long jAbs2 = jMax - Math.abs(System.currentTimeMillis() - abstractC3498a1.f9665d);
            long j = jAbs2 >= 0 ? jAbs2 : 0L;
            abstractC3498a1.m4417b().removeCallbacks(abstractC3498a1.f9664c);
            if (abstractC3498a1.m4417b().postDelayed(abstractC3498a1.f9664c, j)) {
                return;
            }
            abstractC3498a1.f9663b.m4451c().m4426A("Failed to adjust delayed post. time", Long.valueOf(j));
        }
    }

    /* JADX INFO: renamed from: V */
    public final void m4492V() {
        long jM4473V;
        C3515g c3515g = this.f9684j;
        C3515g.m4449a(c3515g.f9729i);
        C3504c0 c3504c0 = c3515g.f9729i;
        if (c3504c0.f9679l && !c3504c0.f9680m) {
            C3180f.m3967b();
            m4444N();
            try {
                jM4473V = this.f9783m.m4473V();
            } catch (SQLiteException e) {
                m4426A("Failed to get min/max hit times from local store", e);
                jM4473V = 0;
            }
            if (jM4473V != 0) {
                Objects.requireNonNull((C3401c) this.f9684j.f9724d);
                if (Math.abs(System.currentTimeMillis() - jM4473V) <= C3510e0.f9694f.f9716a.longValue()) {
                    m4431b("Dispatch alarm scheduled (ms)", Long.valueOf(C3554z.m4508b()));
                    c3504c0.m4444N();
                    C1460d.m435G(c3504c0.f9679l, "Receiver not registered");
                    long jM4508b = C3554z.m4508b();
                    if (jM4508b > 0) {
                        c3504c0.m4421O();
                        Objects.requireNonNull((C3401c) c3504c0.f9684j.f9724d);
                        long jElapsedRealtime = SystemClock.elapsedRealtime() + jM4508b;
                        c3504c0.f9680m = true;
                        C3510e0.f9688C.f9716a.booleanValue();
                        if (Build.VERSION.SDK_INT < 24) {
                            c3504c0.m4427C("Scheduling upload with AlarmManager");
                            c3504c0.f9681n.setInexactRepeating(2, jElapsedRealtime, jM4508b, c3504c0.m4423S());
                            return;
                        }
                        c3504c0.m4427C("Scheduling upload with JobScheduler");
                        Context context = c3504c0.f9684j.f9722b;
                        ComponentName componentName = new ComponentName(context, "com.google.android.gms.analytics.AnalyticsJobService");
                        int iM4422R = c3504c0.m4422R();
                        PersistableBundle persistableBundle = new PersistableBundle();
                        persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
                        JobInfo jobInfoBuild = new JobInfo.Builder(iM4422R, componentName).setMinimumLatency(jM4508b).setOverrideDeadline(jM4508b << 1).setExtras(persistableBundle).build();
                        c3504c0.m4431b("Scheduling job. JobID", Integer.valueOf(iM4422R));
                        Method method = C3502b1.f9674a;
                        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
                        if (C3502b1.f9674a != null) {
                            Objects.requireNonNull((C3505c1) C3502b1.f9676c);
                        }
                        jobScheduler.schedule(jobInfoBuild);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: W */
    public final void m4493W() {
        if (this.f9788r.m4419d()) {
            m4427C("All hits dispatched or no network/service. Going to power save mode");
        }
        this.f9788r.m4416a();
        C3515g c3515g = this.f9684j;
        C3515g.m4449a(c3515g.f9729i);
        C3504c0 c3504c0 = c3515g.f9729i;
        if (c3504c0.f9680m) {
            c3504c0.m4421O();
        }
    }

    /* JADX INFO: renamed from: X */
    public final long m4494X() {
        long j = this.f9787q;
        if (j != Long.MIN_VALUE) {
            return j;
        }
        long jLongValue = C3510e0.f9691c.f9716a.longValue();
        C3499a1 c3499a1M4437t = m4437t();
        c3499a1M4437t.m4444N();
        if (!c3499a1M4437t.f9668n) {
            return jLongValue;
        }
        C3499a1 c3499a1M4437t2 = m4437t();
        c3499a1M4437t2.m4444N();
        return ((long) c3499a1M4437t2.f9669o) * 1000;
    }

    /* JADX INFO: renamed from: b0 */
    public final boolean m4495b0(String str) {
        return C3411b.m4376a(this.f9684j.f9722b).f9605a.checkCallingOrSelfPermission(str) == 0;
    }
}
