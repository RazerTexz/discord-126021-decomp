package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import b.c.a.a0.d;
import b.i.a.f.f.a;
import b.i.a.f.f.b;
import b.i.a.f.h.l.c;
import b.i.a.f.h.l.dc;
import b.i.a.f.h.l.fc;
import b.i.a.f.h.l.t8;
import b.i.a.f.i.b.a6;
import b.i.a.f.i.b.a7;
import b.i.a.f.i.b.b6;
import b.i.a.f.i.b.c6;
import b.i.a.f.i.b.d6;
import b.i.a.f.i.b.g6;
import b.i.a.f.i.b.h6;
import b.i.a.f.i.b.h7;
import b.i.a.f.i.b.i6;
import b.i.a.f.i.b.i7;
import b.i.a.f.i.b.l6;
import b.i.a.f.i.b.m6;
import b.i.a.f.i.b.p;
import b.i.a.f.i.b.s6;
import b.i.a.f.i.b.t6;
import b.i.a.f.i.b.t9;
import b.i.a.f.i.b.u4;
import b.i.a.f.i.b.u6;
import b.i.a.f.i.b.v6;
import b.i.a.f.i.b.w9;
import b.i.a.f.i.b.x9;
import b.i.a.f.i.b.y6;
import b.i.a.f.i.b.y7;
import b.i.a.f.i.b.z5;
import b.i.a.f.i.b.z8;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@DynamiteApi
public class AppMeasurementDynamiteService extends dc {
    public u4 a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("listenerMap")
    public final Map<Integer, z5> f3009b = new ArrayMap();

    @Override // b.i.a.f.h.l.ec
    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        g();
        this.a.A().v(str, j);
    }

    @Override // b.i.a.f.h.l.ec
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        g();
        this.a.s().R(str, str2, bundle);
    }

    @Override // b.i.a.f.h.l.ec
    public void clearMeasurementEnabled(long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        c6VarS.t();
        c6VarS.f().v(new u6(c6VarS, null));
    }

    @Override // b.i.a.f.h.l.ec
    public void endAdUnitExposure(String str, long j) throws RemoteException {
        g();
        this.a.A().y(str, j);
    }

    public final void g() {
        if (this.a == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void generateEventId(fc fcVar) throws RemoteException {
        g();
        this.a.t().K(fcVar, this.a.t().t0());
    }

    @Override // b.i.a.f.h.l.ec
    public void getAppInstanceId(fc fcVar) throws RemoteException {
        g();
        this.a.f().v(new a6(this, fcVar));
    }

    @Override // b.i.a.f.h.l.ec
    public void getCachedAppInstanceId(fc fcVar) throws RemoteException {
        g();
        this.a.t().M(fcVar, this.a.s().g.get());
    }

    @Override // b.i.a.f.h.l.ec
    public void getConditionalUserProperties(String str, String str2, fc fcVar) throws RemoteException {
        g();
        this.a.f().v(new z8(this, fcVar, str, str2));
    }

    @Override // b.i.a.f.h.l.ec
    public void getCurrentScreenClass(fc fcVar) throws RemoteException {
        g();
        i7 i7Var = this.a.s().a.w().c;
        this.a.t().M(fcVar, i7Var != null ? i7Var.f1537b : null);
    }

    @Override // b.i.a.f.h.l.ec
    public void getCurrentScreenName(fc fcVar) throws RemoteException {
        g();
        i7 i7Var = this.a.s().a.w().c;
        this.a.t().M(fcVar, i7Var != null ? i7Var.a : null);
    }

    @Override // b.i.a.f.h.l.ec
    public void getGmpAppId(fc fcVar) throws RemoteException {
        g();
        this.a.t().M(fcVar, this.a.s().O());
    }

    @Override // b.i.a.f.h.l.ec
    public void getMaxUserProperties(String str, fc fcVar) throws RemoteException {
        g();
        this.a.s();
        d.w(str);
        this.a.t().J(fcVar, 25);
    }

    @Override // b.i.a.f.h.l.ec
    public void getTestFlag(fc fcVar, int i) throws RemoteException {
        g();
        if (i == 0) {
            t9 t9VarT = this.a.t();
            c6 c6VarS = this.a.s();
            Objects.requireNonNull(c6VarS);
            AtomicReference atomicReference = new AtomicReference();
            t9VarT.M(fcVar, (String) c6VarS.f().s(atomicReference, 15000L, "String test flag value", new m6(c6VarS, atomicReference)));
            return;
        }
        if (i == 1) {
            t9 t9VarT2 = this.a.t();
            c6 c6VarS2 = this.a.s();
            Objects.requireNonNull(c6VarS2);
            AtomicReference atomicReference2 = new AtomicReference();
            t9VarT2.K(fcVar, ((Long) c6VarS2.f().s(atomicReference2, 15000L, "long test flag value", new t6(c6VarS2, atomicReference2))).longValue());
            return;
        }
        if (i == 2) {
            t9 t9VarT3 = this.a.t();
            c6 c6VarS3 = this.a.s();
            Objects.requireNonNull(c6VarS3);
            AtomicReference atomicReference3 = new AtomicReference();
            double dDoubleValue = ((Double) c6VarS3.f().s(atomicReference3, 15000L, "double test flag value", new v6(c6VarS3, atomicReference3))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", dDoubleValue);
            try {
                fcVar.f(bundle);
                return;
            } catch (RemoteException e) {
                t9VarT3.a.g().i.b("Error returning double value to wrapper", e);
                return;
            }
        }
        if (i == 3) {
            t9 t9VarT4 = this.a.t();
            c6 c6VarS4 = this.a.s();
            Objects.requireNonNull(c6VarS4);
            AtomicReference atomicReference4 = new AtomicReference();
            t9VarT4.J(fcVar, ((Integer) c6VarS4.f().s(atomicReference4, 15000L, "int test flag value", new s6(c6VarS4, atomicReference4))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        t9 t9VarT5 = this.a.t();
        c6 c6VarS5 = this.a.s();
        Objects.requireNonNull(c6VarS5);
        AtomicReference atomicReference5 = new AtomicReference();
        t9VarT5.O(fcVar, ((Boolean) c6VarS5.f().s(atomicReference5, 15000L, "boolean test flag value", new d6(c6VarS5, atomicReference5))).booleanValue());
    }

    @Override // b.i.a.f.h.l.ec
    public void getUserProperties(String str, String str2, boolean z2, fc fcVar) throws RemoteException {
        g();
        this.a.f().v(new a7(this, fcVar, str, str2, z2));
    }

    @Override // b.i.a.f.h.l.ec
    public void initForTests(Map map) throws RemoteException {
        g();
    }

    @Override // b.i.a.f.h.l.ec
    public void initialize(a aVar, zzae zzaeVar, long j) throws RemoteException {
        Context context = (Context) b.i(aVar);
        u4 u4Var = this.a;
        if (u4Var == null) {
            this.a = u4.b(context, zzaeVar, Long.valueOf(j));
        } else {
            u4Var.g().i.a("Attempting to initialize multiple times");
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void isDataCollectionEnabled(fc fcVar) throws RemoteException {
        g();
        this.a.f().v(new x9(this, fcVar));
    }

    @Override // b.i.a.f.h.l.ec
    public void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) throws RemoteException {
        g();
        this.a.s().I(str, str2, bundle, z2, z3, j);
    }

    @Override // b.i.a.f.h.l.ec
    public void logEventAndBundle(String str, String str2, Bundle bundle, fc fcVar, long j) throws RemoteException {
        g();
        d.w(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        this.a.f().v(new y7(this, fcVar, new zzaq(str2, new zzap(bundle), "app", j), str));
    }

    @Override // b.i.a.f.h.l.ec
    public void logHealthData(int i, String str, a aVar, a aVar2, a aVar3) throws RemoteException {
        g();
        this.a.g().w(i, true, false, str, aVar == null ? null : b.i(aVar), aVar2 == null ? null : b.i(aVar2), aVar3 != null ? b.i(aVar3) : null);
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivityCreated(a aVar, Bundle bundle, long j) throws RemoteException {
        g();
        y6 y6Var = this.a.s().c;
        if (y6Var != null) {
            this.a.s().M();
            y6Var.onActivityCreated((Activity) b.i(aVar), bundle);
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivityDestroyed(a aVar, long j) throws RemoteException {
        g();
        y6 y6Var = this.a.s().c;
        if (y6Var != null) {
            this.a.s().M();
            y6Var.onActivityDestroyed((Activity) b.i(aVar));
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivityPaused(a aVar, long j) throws RemoteException {
        g();
        y6 y6Var = this.a.s().c;
        if (y6Var != null) {
            this.a.s().M();
            y6Var.onActivityPaused((Activity) b.i(aVar));
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivityResumed(a aVar, long j) throws RemoteException {
        g();
        y6 y6Var = this.a.s().c;
        if (y6Var != null) {
            this.a.s().M();
            y6Var.onActivityResumed((Activity) b.i(aVar));
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivitySaveInstanceState(a aVar, fc fcVar, long j) throws RemoteException {
        g();
        y6 y6Var = this.a.s().c;
        Bundle bundle = new Bundle();
        if (y6Var != null) {
            this.a.s().M();
            y6Var.onActivitySaveInstanceState((Activity) b.i(aVar), bundle);
        }
        try {
            fcVar.f(bundle);
        } catch (RemoteException e) {
            this.a.g().i.b("Error returning bundle value to wrapper", e);
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivityStarted(a aVar, long j) throws RemoteException {
        g();
        if (this.a.s().c != null) {
            this.a.s().M();
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void onActivityStopped(a aVar, long j) throws RemoteException {
        g();
        if (this.a.s().c != null) {
            this.a.s().M();
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void performAction(Bundle bundle, fc fcVar, long j) throws RemoteException {
        g();
        fcVar.f(null);
    }

    @Override // b.i.a.f.h.l.ec
    public void registerOnMeasurementEventListener(c cVar) throws RemoteException {
        z5 appMeasurementDynamiteService$b;
        g();
        synchronized (this.f3009b) {
            appMeasurementDynamiteService$b = this.f3009b.get(Integer.valueOf(cVar.a()));
            if (appMeasurementDynamiteService$b == null) {
                appMeasurementDynamiteService$b = new AppMeasurementDynamiteService$b(this, cVar);
                this.f3009b.put(Integer.valueOf(cVar.a()), appMeasurementDynamiteService$b);
            }
        }
        c6 c6VarS = this.a.s();
        c6VarS.t();
        if (c6VarS.e.add(appMeasurementDynamiteService$b)) {
            return;
        }
        c6VarS.g().i.a("OnEventListener already registered");
    }

    @Override // b.i.a.f.h.l.ec
    public void resetAnalyticsData(long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        c6VarS.g.set(null);
        c6VarS.f().v(new l6(c6VarS, j));
    }

    @Override // b.i.a.f.h.l.ec
    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        g();
        if (bundle == null) {
            this.a.g().f.a("Conditional user property must not be null");
        } else {
            this.a.s().y(bundle, j);
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void setConsent(Bundle bundle, long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        if (t8.b() && c6VarS.a.h.u(null, p.H0)) {
            c6VarS.x(bundle, 30, j);
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void setConsentThirdParty(Bundle bundle, long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        if (t8.b() && c6VarS.a.h.u(null, p.I0)) {
            c6VarS.x(bundle, 10, j);
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void setCurrentScreen(a aVar, String str, String str2, long j) throws RemoteException {
        g();
        h7 h7VarW = this.a.w();
        Activity activity = (Activity) b.i(aVar);
        if (!h7VarW.a.h.z().booleanValue()) {
            h7VarW.g().k.a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (h7VarW.c == null) {
            h7VarW.g().k.a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (h7VarW.f.get(activity) == null) {
            h7VarW.g().k.a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = h7.x(activity.getClass().getCanonicalName());
        }
        boolean zQ0 = t9.q0(h7VarW.c.f1537b, str2);
        boolean zQ1 = t9.q0(h7VarW.c.a, str);
        if (zQ0 && zQ1) {
            h7VarW.g().k.a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            h7VarW.g().k.b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            h7VarW.g().k.b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        h7VarW.g().n.c("Setting current screen to name, class", str == null ? "null" : str, str2);
        i7 i7Var = new i7(str, str2, h7VarW.e().t0());
        h7VarW.f.put(activity, i7Var);
        h7VarW.z(activity, i7Var, true);
    }

    @Override // b.i.a.f.h.l.ec
    public void setDataCollectionEnabled(boolean z2) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        c6VarS.t();
        c6VarS.f().v(new g6(c6VarS, z2));
    }

    @Override // b.i.a.f.h.l.ec
    public void setDefaultEventParameters(Bundle bundle) {
        g();
        c6 c6VarS = this.a.s();
        c6VarS.f().v(new b6(c6VarS, bundle == null ? null : new Bundle(bundle)));
    }

    @Override // b.i.a.f.h.l.ec
    public void setEventInterceptor(c cVar) throws RemoteException {
        g();
        AppMeasurementDynamiteService$a appMeasurementDynamiteService$a = new AppMeasurementDynamiteService$a(this, cVar);
        if (this.a.f().y()) {
            this.a.s().B(appMeasurementDynamiteService$a);
        } else {
            this.a.f().v(new w9(this, appMeasurementDynamiteService$a));
        }
    }

    @Override // b.i.a.f.h.l.ec
    public void setInstanceIdProvider(b.i.a.f.h.l.d dVar) throws RemoteException {
        g();
    }

    @Override // b.i.a.f.h.l.ec
    public void setMeasurementEnabled(boolean z2, long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        Boolean boolValueOf = Boolean.valueOf(z2);
        c6VarS.t();
        c6VarS.f().v(new u6(c6VarS, boolValueOf));
    }

    @Override // b.i.a.f.h.l.ec
    public void setMinimumSessionDuration(long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        c6VarS.f().v(new i6(c6VarS, j));
    }

    @Override // b.i.a.f.h.l.ec
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        g();
        c6 c6VarS = this.a.s();
        c6VarS.f().v(new h6(c6VarS, j));
    }

    @Override // b.i.a.f.h.l.ec
    public void setUserId(String str, long j) throws RemoteException {
        g();
        this.a.s().L(null, "_id", str, true, j);
    }

    @Override // b.i.a.f.h.l.ec
    public void setUserProperty(String str, String str2, a aVar, boolean z2, long j) throws RemoteException {
        g();
        this.a.s().L(str, str2, b.i(aVar), z2, j);
    }

    @Override // b.i.a.f.h.l.ec
    public void unregisterOnMeasurementEventListener(c cVar) throws RemoteException {
        z5 z5VarRemove;
        g();
        synchronized (this.f3009b) {
            z5VarRemove = this.f3009b.remove(Integer.valueOf(cVar.a()));
        }
        if (z5VarRemove == null) {
            z5VarRemove = new AppMeasurementDynamiteService$b(this, cVar);
        }
        c6 c6VarS = this.a.s();
        c6VarS.t();
        if (c6VarS.e.remove(z5VarRemove)) {
            return;
        }
        c6VarS.g().i.a("OnEventListener had not been registered");
    }
}
