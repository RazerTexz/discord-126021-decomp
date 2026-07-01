package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import b.c.a.a0.d;
import b.i.a.f.e.o.c;
import b.i.a.f.i.b.a;
import b.i.a.f.i.b.b7;
import b.i.a.f.i.b.c6;
import b.i.a.f.i.b.ga;
import b.i.a.f.i.b.i7;
import b.i.a.f.i.b.o6;
import b.i.a.f.i.b.r6;
import b.i.a.f.i.b.t9;
import b.i.a.f.i.b.u4;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzku;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class AppMeasurement {
    public static volatile AppMeasurement a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4 f3008b;
    public final b7 c;
    public final boolean d;

    public AppMeasurement(u4 u4Var) {
        Objects.requireNonNull(u4Var, "null reference");
        this.f3008b = u4Var;
        this.c = null;
        this.d = false;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        b7 b7Var;
        if (a == null) {
            synchronized (AppMeasurement.class) {
                if (a == null) {
                    try {
                        b7Var = (b7) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    } catch (ClassNotFoundException | Exception unused) {
                        b7Var = null;
                    }
                    if (b7Var != null) {
                        a = new AppMeasurement(b7Var);
                    } else {
                        a = new AppMeasurement(u4.b(context, new zzae(0L, 0L, true, null, null, null, null), null));
                    }
                }
            }
        }
        return a;
    }

    @Keep
    public void beginAdUnitExposure(@NonNull @Size(min = 1) String str) {
        if (this.d) {
            this.c.g(str);
            return;
        }
        a aVarA = this.f3008b.A();
        Objects.requireNonNull((c) this.f3008b.o);
        aVarA.v(str, SystemClock.elapsedRealtime());
    }

    @Keep
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.d) {
            this.c.l(str, str2, bundle);
        } else {
            this.f3008b.s().R(str, str2, bundle);
        }
    }

    @Keep
    public void endAdUnitExposure(@NonNull @Size(min = 1) String str) {
        if (this.d) {
            this.c.j(str);
            return;
        }
        a aVarA = this.f3008b.A();
        Objects.requireNonNull((c) this.f3008b.o);
        aVarA.y(str, SystemClock.elapsedRealtime());
    }

    @Keep
    public long generateEventId() {
        return this.d ? this.c.e() : this.f3008b.t().t0();
    }

    @Nullable
    @Keep
    public String getAppInstanceId() {
        return this.d ? this.c.c() : this.f3008b.s().g.get();
    }

    @Keep
    @WorkerThread
    public List<AppMeasurement$ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        List<Bundle> listJ0;
        if (this.d) {
            listJ0 = this.c.h(str, str2);
        } else {
            c6 c6VarS = this.f3008b.s();
            if (c6VarS.f().y()) {
                c6VarS.g().f.a("Cannot get conditional user properties from analytics worker thread");
                listJ0 = new ArrayList<>(0);
            } else if (ga.a()) {
                c6VarS.g().f.a("Cannot get conditional user properties from main thread");
                listJ0 = new ArrayList<>(0);
            } else {
                AtomicReference atomicReference = new AtomicReference();
                c6VarS.a.f().s(atomicReference, 5000L, "get conditional user properties", new o6(c6VarS, atomicReference, str, str2));
                List list = (List) atomicReference.get();
                if (list == null) {
                    c6VarS.g().f.b("Timed out waiting for get conditional user properties", null);
                    listJ0 = new ArrayList<>();
                } else {
                    listJ0 = t9.j0(list);
                }
            }
        }
        ArrayList arrayList = new ArrayList(listJ0 != null ? listJ0.size() : 0);
        Iterator<Bundle> it = listJ0.iterator();
        while (it.hasNext()) {
            arrayList.add(new AppMeasurement$ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Nullable
    @Keep
    public String getCurrentScreenClass() {
        if (this.d) {
            return this.c.b();
        }
        i7 i7Var = this.f3008b.s().a.w().c;
        if (i7Var != null) {
            return i7Var.f1537b;
        }
        return null;
    }

    @Nullable
    @Keep
    public String getCurrentScreenName() {
        if (this.d) {
            return this.c.a();
        }
        i7 i7Var = this.f3008b.s().a.w().c;
        if (i7Var != null) {
            return i7Var.a;
        }
        return null;
    }

    @Nullable
    @Keep
    public String getGmpAppId() {
        return this.d ? this.c.d() : this.f3008b.s().O();
    }

    @Keep
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        if (this.d) {
            return this.c.i(str);
        }
        this.f3008b.s();
        d.w(str);
        return 25;
    }

    @Keep
    @WorkerThread
    public Map<String, Object> getUserProperties(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z2) {
        if (this.d) {
            return this.c.k(str, str2, z2);
        }
        c6 c6VarS = this.f3008b.s();
        if (c6VarS.f().y()) {
            c6VarS.g().f.a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (ga.a()) {
            c6VarS.g().f.a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        c6VarS.a.f().s(atomicReference, 5000L, "get user properties", new r6(c6VarS, atomicReference, str, str2, z2));
        List<zzku> list = (List) atomicReference.get();
        if (list == null) {
            c6VarS.g().f.b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z2));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzku zzkuVar : list) {
            arrayMap.put(zzkuVar.k, zzkuVar.w0());
        }
        return arrayMap;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.d) {
            this.c.m(str, str2, bundle);
        } else {
            this.f3008b.s().H(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(@NonNull AppMeasurement$ConditionalUserProperty appMeasurement$ConditionalUserProperty) {
        Objects.requireNonNull(appMeasurement$ConditionalUserProperty, "null reference");
        if (this.d) {
            this.c.f(appMeasurement$ConditionalUserProperty.a());
            return;
        }
        c6 c6VarS = this.f3008b.s();
        Bundle bundleA = appMeasurement$ConditionalUserProperty.a();
        Objects.requireNonNull((c) c6VarS.a.o);
        c6VarS.y(bundleA, System.currentTimeMillis());
    }

    public AppMeasurement(b7 b7Var) {
        this.c = b7Var;
        this.f3008b = null;
        this.d = true;
    }
}
