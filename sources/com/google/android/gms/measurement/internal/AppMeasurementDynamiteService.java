package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractBinderC3632dc;
import p007b.p225i.p226a.p288f.p313h.p325l.C3644ea;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3605c;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3619d;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3660fc;
import p007b.p225i.p226a.p288f.p330i.p332b.C3999c6;
import p007b.p225i.p226a.p288f.p330i.p332b.C4060h7;
import p007b.p225i.p226a.p288f.p330i.p332b.C4072i7;
import p007b.p225i.p226a.p288f.p330i.p332b.C4142p;
import p007b.p225i.p226a.p288f.p330i.p332b.C4196t9;
import p007b.p225i.p226a.p288f.p330i.p332b.C4202u4;
import p007b.p225i.p226a.p288f.p330i.p332b.C4248y6;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4225w5;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4258z5;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC3975a6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC3976a7;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4011d6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4047g6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4059h6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4071i6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4105l6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4116m6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4182s6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4193t6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4204u6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4215v6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4229w9;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4240x9;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4249y7;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4261z8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends AbstractBinderC3632dc {

    /* JADX INFO: renamed from: a */
    public C4202u4 f20659a = null;

    /* JADX INFO: renamed from: b */
    @GuardedBy("listenerMap")
    public final Map<Integer, InterfaceC4258z5> f20660b = new ArrayMap();

    /* JADX INFO: renamed from: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$a */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    public class C10806a implements InterfaceC4225w5 {

        /* JADX INFO: renamed from: a */
        public InterfaceC3605c f20661a;

        public C10806a(InterfaceC3605c interfaceC3605c) {
            this.f20661a = interfaceC3605c;
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$b */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
    public class C10807b implements InterfaceC4258z5 {

        /* JADX INFO: renamed from: a */
        public InterfaceC3605c f20663a;

        public C10807b(InterfaceC3605c interfaceC3605c) {
            this.f20663a = interfaceC3605c;
        }

        @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4258z5
        /* JADX INFO: renamed from: a */
        public final void mo5979a(String str, String str2, Bundle bundle, long j) {
            try {
                this.f20663a.mo4572Z(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.f20659a.mo5726g().f11144i.m5861b("Event listener threw exception", e);
            }
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        m9111g();
        this.f20659a.m5937A().m5442v(str, j);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        m9111g();
        this.f20659a.m5948s().m5555R(str, str2, bundle);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void clearMeasurementEnabled(long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.m5497t();
        c3999c6M5948s.mo5725f().m5852v(new RunnableC4204u6(c3999c6M5948s, null));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        m9111g();
        this.f20659a.m5937A().m5445y(str, j);
    }

    /* JADX INFO: renamed from: g */
    public final void m9111g() {
        if (this.f20659a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void generateEventId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.m5949t().m5897K(interfaceC3660fc, this.f20659a.m5949t().m5922t0());
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getAppInstanceId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.mo5725f().m5852v(new RunnableC3975a6(this, interfaceC3660fc));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getCachedAppInstanceId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.m5949t().m5899M(interfaceC3660fc, this.f20659a.m5948s().f10598g.get());
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getConditionalUserProperties(String str, String str2, InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.mo5725f().m5852v(new RunnableC4261z8(this, interfaceC3660fc, str, str2));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getCurrentScreenClass(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        C4072i7 c4072i7 = this.f20659a.m5948s().f11202a.m5952w().f10775c;
        this.f20659a.m5949t().m5899M(interfaceC3660fc, c4072i7 != null ? c4072i7.f10817b : null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getCurrentScreenName(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        C4072i7 c4072i7 = this.f20659a.m5948s().f11202a.m5952w().f10775c;
        this.f20659a.m5949t().m5899M(interfaceC3660fc, c4072i7 != null ? c4072i7.f10816a : null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getGmpAppId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.m5949t().m5899M(interfaceC3660fc, this.f20659a.m5948s().m5552O());
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getMaxUserProperties(String str, InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.m5948s();
        C1460d.m583w(str);
        this.f20659a.m5949t().m5896J(interfaceC3660fc, 25);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getTestFlag(InterfaceC3660fc interfaceC3660fc, int i) throws RemoteException {
        m9111g();
        if (i == 0) {
            C4196t9 c4196t9M5949t = this.f20659a.m5949t();
            C3999c6 c3999c6M5948s = this.f20659a.m5948s();
            Objects.requireNonNull(c3999c6M5948s);
            AtomicReference atomicReference = new AtomicReference();
            c4196t9M5949t.m5899M(interfaceC3660fc, (String) c3999c6M5948s.mo5725f().m5849s(atomicReference, 15000L, "String test flag value", new RunnableC4116m6(c3999c6M5948s, atomicReference)));
            return;
        }
        if (i == 1) {
            C4196t9 c4196t9M5949t2 = this.f20659a.m5949t();
            C3999c6 c3999c6M5948s2 = this.f20659a.m5948s();
            Objects.requireNonNull(c3999c6M5948s2);
            AtomicReference atomicReference2 = new AtomicReference();
            c4196t9M5949t2.m5897K(interfaceC3660fc, ((Long) c3999c6M5948s2.mo5725f().m5849s(atomicReference2, 15000L, "long test flag value", new RunnableC4193t6(c3999c6M5948s2, atomicReference2))).longValue());
            return;
        }
        if (i == 2) {
            C4196t9 c4196t9M5949t3 = this.f20659a.m5949t();
            C3999c6 c3999c6M5948s3 = this.f20659a.m5948s();
            Objects.requireNonNull(c3999c6M5948s3);
            AtomicReference atomicReference3 = new AtomicReference();
            double dDoubleValue = ((Double) c3999c6M5948s3.mo5725f().m5849s(atomicReference3, 15000L, "double test flag value", new RunnableC4215v6(c3999c6M5948s3, atomicReference3))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                interfaceC3660fc.mo4619f(bundle);
                return;
            } catch (RemoteException e) {
                c4196t9M5949t3.f11202a.mo5726g().f11144i.m5861b("Error returning double value to wrapper", e);
                return;
            }
        }
        if (i == 3) {
            C4196t9 c4196t9M5949t4 = this.f20659a.m5949t();
            C3999c6 c3999c6M5948s4 = this.f20659a.m5948s();
            Objects.requireNonNull(c3999c6M5948s4);
            AtomicReference atomicReference4 = new AtomicReference();
            c4196t9M5949t4.m5896J(interfaceC3660fc, ((Integer) c3999c6M5948s4.mo5725f().m5849s(atomicReference4, 15000L, "int test flag value", new RunnableC4182s6(c3999c6M5948s4, atomicReference4))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        C4196t9 c4196t9M5949t5 = this.f20659a.m5949t();
        C3999c6 c3999c6M5948s5 = this.f20659a.m5948s();
        Objects.requireNonNull(c3999c6M5948s5);
        AtomicReference atomicReference5 = new AtomicReference();
        c4196t9M5949t5.m5901O(interfaceC3660fc, ((Boolean) c3999c6M5948s5.mo5725f().m5849s(atomicReference5, 15000L, "boolean test flag value", new RunnableC4011d6(c3999c6M5948s5, atomicReference5))).booleanValue());
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void getUserProperties(String str, String str2, boolean z2, InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.mo5725f().m5852v(new RunnableC3976a7(this, interfaceC3660fc, str, str2, z2));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void initForTests(Map map) throws RemoteException {
        m9111g();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void initialize(InterfaceC3422a interfaceC3422a, zzae zzaeVar, long j) throws RemoteException {
        Context context = (Context) BinderC3423b.m4381i(interfaceC3422a);
        C4202u4 c4202u4 = this.f20659a;
        if (c4202u4 == null) {
            this.f20659a = C4202u4.m5933b(context, zzaeVar, Long.valueOf(j));
        } else {
            c4202u4.mo5726g().f11144i.m5860a("Attempting to initialize multiple times");
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void isDataCollectionEnabled(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        m9111g();
        this.f20659a.mo5725f().m5852v(new RunnableC4240x9(this, interfaceC3660fc));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) throws RemoteException {
        m9111g();
        this.f20659a.m5948s().m5546I(str, str2, bundle, z2, z3, j);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void logEventAndBundle(String str, String str2, Bundle bundle, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException {
        m9111g();
        C1460d.m583w(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.f20659a.mo5725f().m5852v(new RunnableC4249y7(this, interfaceC3660fc, new zzaq(str2, new zzap(bundle), "app", j), str));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void logHealthData(int i, String str, InterfaceC3422a interfaceC3422a, InterfaceC3422a interfaceC3422a2, InterfaceC3422a interfaceC3422a3) throws RemoteException {
        m9111g();
        this.f20659a.mo5726g().m5799w(i, true, false, str, interfaceC3422a == null ? null : BinderC3423b.m4381i(interfaceC3422a), interfaceC3422a2 == null ? null : BinderC3423b.m4381i(interfaceC3422a2), interfaceC3422a3 != null ? BinderC3423b.m4381i(interfaceC3422a3) : null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivityCreated(InterfaceC3422a interfaceC3422a, Bundle bundle, long j) throws RemoteException {
        m9111g();
        C4248y6 c4248y6 = this.f20659a.m5948s().f10594c;
        if (c4248y6 != null) {
            this.f20659a.m5948s().m5550M();
            c4248y6.onActivityCreated((Activity) BinderC3423b.m4381i(interfaceC3422a), bundle);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivityDestroyed(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        m9111g();
        C4248y6 c4248y6 = this.f20659a.m5948s().f10594c;
        if (c4248y6 != null) {
            this.f20659a.m5948s().m5550M();
            c4248y6.onActivityDestroyed((Activity) BinderC3423b.m4381i(interfaceC3422a));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivityPaused(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        m9111g();
        C4248y6 c4248y6 = this.f20659a.m5948s().f10594c;
        if (c4248y6 != null) {
            this.f20659a.m5948s().m5550M();
            c4248y6.onActivityPaused((Activity) BinderC3423b.m4381i(interfaceC3422a));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivityResumed(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        m9111g();
        C4248y6 c4248y6 = this.f20659a.m5948s().f10594c;
        if (c4248y6 != null) {
            this.f20659a.m5948s().m5550M();
            c4248y6.onActivityResumed((Activity) BinderC3423b.m4381i(interfaceC3422a));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivitySaveInstanceState(InterfaceC3422a interfaceC3422a, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException {
        m9111g();
        C4248y6 c4248y6 = this.f20659a.m5948s().f10594c;
        Bundle bundle = new Bundle();
        if (c4248y6 != null) {
            this.f20659a.m5948s().m5550M();
            c4248y6.onActivitySaveInstanceState((Activity) BinderC3423b.m4381i(interfaceC3422a), bundle);
        }
        try {
            interfaceC3660fc.mo4619f(bundle);
        } catch (RemoteException e) {
            this.f20659a.mo5726g().f11144i.m5861b("Error returning bundle value to wrapper", e);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivityStarted(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        m9111g();
        if (this.f20659a.m5948s().f10594c != null) {
            this.f20659a.m5948s().m5550M();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void onActivityStopped(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        m9111g();
        if (this.f20659a.m5948s().f10594c != null) {
            this.f20659a.m5948s().m5550M();
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void performAction(Bundle bundle, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException {
        m9111g();
        interfaceC3660fc.mo4619f(null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void registerOnMeasurementEventListener(InterfaceC3605c interfaceC3605c) throws RemoteException {
        InterfaceC4258z5 c10807b;
        m9111g();
        synchronized (this.f20660b) {
            c10807b = this.f20660b.get(Integer.valueOf(interfaceC3605c.mo4573a()));
            if (c10807b == null) {
                c10807b = new C10807b(interfaceC3605c);
                this.f20660b.put(Integer.valueOf(interfaceC3605c.mo4573a()), c10807b);
            }
        }
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.m5497t();
        if (c3999c6M5948s.f10596e.add(c10807b)) {
            return;
        }
        c3999c6M5948s.mo5726g().f11144i.m5860a("OnEventListener already registered");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void resetAnalyticsData(long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.f10598g.set(null);
        c3999c6M5948s.mo5725f().m5852v(new RunnableC4105l6(c3999c6M5948s, j));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        m9111g();
        if (bundle == null) {
            this.f20659a.mo5726g().f11141f.m5860a("Conditional user property must not be null");
        } else {
            this.f20659a.m5948s().m5558y(bundle, j);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setConsent(Bundle bundle, long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        if (C3842t8.m5293b() && c3999c6M5948s.f11202a.f11260h.m5532u(null, C4142p.f11035H0)) {
            c3999c6M5948s.m5557x(bundle, 30, j);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        if (C3842t8.m5293b() && c3999c6M5948s.f11202a.f11260h.m5532u(null, C4142p.f11037I0)) {
            c3999c6M5948s.m5557x(bundle, 10, j);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setCurrentScreen(InterfaceC3422a interfaceC3422a, String str, String str2, long j) throws RemoteException {
        m9111g();
        C4060h7 c4060h7M5952w = this.f20659a.m5952w();
        Activity activity = (Activity) BinderC3423b.m4381i(interfaceC3422a);
        if (!c4060h7M5952w.f11202a.f11260h.m5537z().booleanValue()) {
            c4060h7M5952w.mo5726g().f11146k.m5860a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (c4060h7M5952w.f10775c == null) {
            c4060h7M5952w.mo5726g().f11146k.m5860a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (c4060h7M5952w.f10778f.get(activity) == null) {
            c4060h7M5952w.mo5726g().f11146k.m5860a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = C4060h7.m5651x(activity.getClass().getCanonicalName());
        }
        boolean zM5884q0 = C4196t9.m5884q0(c4060h7M5952w.f10775c.f10817b, str2);
        boolean zM5884q1 = C4196t9.m5884q0(c4060h7M5952w.f10775c.f10816a, str);
        if (zM5884q0 && zM5884q1) {
            c4060h7M5952w.mo5726g().f11146k.m5860a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            c4060h7M5952w.mo5726g().f11146k.m5861b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            c4060h7M5952w.mo5726g().f11146k.m5861b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        c4060h7M5952w.mo5726g().f11149n.m5862c("Setting current screen to name, class", str == null ? "null" : str, str2);
        C4072i7 c4072i7 = new C4072i7(str, str2, c4060h7M5952w.m5866e().m5922t0());
        c4060h7M5952w.f10778f.put(activity, c4072i7);
        c4060h7M5952w.m5658z(activity, c4072i7, true);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setDataCollectionEnabled(boolean z2) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.m5497t();
        c3999c6M5948s.mo5725f().m5852v(new RunnableC4047g6(c3999c6M5948s, z2));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setDefaultEventParameters(Bundle bundle) {
        m9111g();
        final C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        final Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
        c3999c6M5948s.mo5725f().m5852v(new Runnable(c3999c6M5948s, bundle2) { // from class: b.i.a.f.i.b.b6

            /* JADX INFO: renamed from: j */
            public final C3999c6 f10567j;

            /* JADX INFO: renamed from: k */
            public final Bundle f10568k;

            {
                this.f10567j = c3999c6M5948s;
                this.f10568k = bundle2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z2;
                C3999c6 c3999c6 = this.f10567j;
                Bundle bundle3 = this.f10568k;
                Objects.requireNonNull(c3999c6);
                if (C3644ea.m4872b() && c3999c6.f11202a.f11260h.m5526o(C4142p.f11112z0)) {
                    if (bundle3 == null) {
                        c3999c6.m5867l().f10633D.m5682b(new Bundle());
                        return;
                    }
                    Bundle bundleM5681a = c3999c6.m5867l().f10633D.m5681a();
                    for (String str : bundle3.keySet()) {
                        Object obj = bundle3.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            c3999c6.m5866e();
                            if (C4196t9.m5876W(obj)) {
                                c3999c6.m5866e().m5904R(c3999c6.f10607p, 27, null, null, 0);
                            }
                            c3999c6.mo5726g().f11146k.m5862c("Invalid default event parameter type. Name, value", str, obj);
                        } else if (C4196t9.m5885r0(str)) {
                            c3999c6.mo5726g().f11146k.m5861b("Invalid default event parameter name. Name", str);
                        } else if (obj == null) {
                            bundleM5681a.remove(str);
                        } else if (c3999c6.m5866e().m5910b0("param", str, 100, obj)) {
                            c3999c6.m5866e().m5895I(bundleM5681a, str, obj);
                        }
                    }
                    c3999c6.m5866e();
                    int iM5531t = c3999c6.f11202a.f11260h.m5531t();
                    if (bundleM5681a.size() > iM5531t) {
                        Iterator it = new TreeSet(bundleM5681a.keySet()).iterator();
                        int i = 0;
                        while (true) {
                            z2 = true;
                            if (!it.hasNext()) {
                                break;
                            }
                            String str2 = (String) it.next();
                            i++;
                            if (i > iM5531t) {
                                bundleM5681a.remove(str2);
                            }
                        }
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        c3999c6.m5866e().m5904R(c3999c6.f10607p, 26, null, null, 0);
                        c3999c6.mo5726g().f11146k.m5860a("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                    c3999c6.m5867l().f10633D.m5682b(bundleM5681a);
                    C4161q7 c4161q7M5971p = c3999c6.m5971p();
                    c4161q7M5971p.mo5848b();
                    c4161q7M5971p.m5497t();
                    c4161q7M5971p.m5814z(new RunnableC3977a8(c4161q7M5971p, bundleM5681a, c4161q7M5971p.m5811I(false)));
                }
            }
        });
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setEventInterceptor(InterfaceC3605c interfaceC3605c) throws RemoteException {
        m9111g();
        C10806a c10806a = new C10806a(interfaceC3605c);
        if (this.f20659a.mo5725f().m5855y()) {
            this.f20659a.m5948s().m5540B(c10806a);
        } else {
            this.f20659a.mo5725f().m5852v(new RunnableC4229w9(this, c10806a));
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setInstanceIdProvider(InterfaceC3619d interfaceC3619d) throws RemoteException {
        m9111g();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setMeasurementEnabled(boolean z2, long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        Boolean boolValueOf = Boolean.valueOf(z2);
        c3999c6M5948s.m5497t();
        c3999c6M5948s.mo5725f().m5852v(new RunnableC4204u6(c3999c6M5948s, boolValueOf));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setMinimumSessionDuration(long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.mo5725f().m5852v(new RunnableC4071i6(c3999c6M5948s, j));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        m9111g();
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.mo5725f().m5852v(new RunnableC4059h6(c3999c6M5948s, j));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setUserId(String str, long j) throws RemoteException {
        m9111g();
        this.f20659a.m5948s().m5549L(null, "_id", str, true, j);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void setUserProperty(String str, String str2, InterfaceC3422a interfaceC3422a, boolean z2, long j) throws RemoteException {
        m9111g();
        this.f20659a.m5948s().m5549L(str, str2, BinderC3423b.m4381i(interfaceC3422a), z2, j);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public void unregisterOnMeasurementEventListener(InterfaceC3605c interfaceC3605c) throws RemoteException {
        InterfaceC4258z5 interfaceC4258z5Remove;
        m9111g();
        synchronized (this.f20660b) {
            interfaceC4258z5Remove = this.f20660b.remove(Integer.valueOf(interfaceC3605c.mo4573a()));
        }
        if (interfaceC4258z5Remove == null) {
            interfaceC4258z5Remove = new C10807b(interfaceC3605c);
        }
        C3999c6 c3999c6M5948s = this.f20659a.m5948s();
        c3999c6M5948s.m5497t();
        if (c3999c6M5948s.f10596e.remove(interfaceC4258z5Remove)) {
            return;
        }
        c3999c6M5948s.mo5726g().f11144i.m5860a("OnEventListener had not been registered");
    }
}
