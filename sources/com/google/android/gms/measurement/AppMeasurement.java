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
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.o.c;
import b.i.a.f.e.o.f;
import b.i.a.f.i.b.a;
import b.i.a.f.i.b.b7;
import b.i.a.f.i.b.c6;
import b.i.a.f.i.b.ga;
import b.i.a.f.i.b.i7;
import b.i.a.f.i.b.o6;
import b.i.a.f.i.b.r6;
import b.i.a.f.i.b.t9;
import b.i.a.f.i.b.u4;
import com.discord.models.domain.ModelAuditLogEntry;
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

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
    public static class ConditionalUserProperty {

        @Keep
        public boolean mActive;

        @Keep
        public String mAppId;

        @Keep
        public long mCreationTimestamp;

        @Keep
        public String mExpiredEventName;

        @Keep
        public Bundle mExpiredEventParams;

        @Keep
        public String mName;

        @Keep
        public String mOrigin;

        @Keep
        public long mTimeToLive;

        @Keep
        public String mTimedOutEventName;

        @Keep
        public Bundle mTimedOutEventParams;

        @Keep
        public String mTriggerEventName;

        @Keep
        public long mTriggerTimeout;

        @Keep
        public String mTriggeredEventName;

        @Keep
        public Bundle mTriggeredEventParams;

        @Keep
        public long mTriggeredTimestamp;

        @Keep
        public Object mValue;

        public ConditionalUserProperty() {
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            String str = this.mAppId;
            if (str != null) {
                bundle.putString("app_id", str);
            }
            String str2 = this.mOrigin;
            if (str2 != null) {
                bundle.putString("origin", str2);
            }
            String str3 = this.mName;
            if (str3 != null) {
                bundle.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, str3);
            }
            Object obj = this.mValue;
            if (obj != null) {
                f.d2(bundle, obj);
            }
            String str4 = this.mTriggerEventName;
            if (str4 != null) {
                bundle.putString("trigger_event_name", str4);
            }
            bundle.putLong("trigger_timeout", this.mTriggerTimeout);
            String str5 = this.mTimedOutEventName;
            if (str5 != null) {
                bundle.putString("timed_out_event_name", str5);
            }
            Bundle bundle2 = this.mTimedOutEventParams;
            if (bundle2 != null) {
                bundle.putBundle("timed_out_event_params", bundle2);
            }
            String str6 = this.mTriggeredEventName;
            if (str6 != null) {
                bundle.putString("triggered_event_name", str6);
            }
            Bundle bundle3 = this.mTriggeredEventParams;
            if (bundle3 != null) {
                bundle.putBundle("triggered_event_params", bundle3);
            }
            bundle.putLong("time_to_live", this.mTimeToLive);
            String str7 = this.mExpiredEventName;
            if (str7 != null) {
                bundle.putString("expired_event_name", str7);
            }
            Bundle bundle4 = this.mExpiredEventParams;
            if (bundle4 != null) {
                bundle.putBundle("expired_event_params", bundle4);
            }
            bundle.putLong("creation_timestamp", this.mCreationTimestamp);
            bundle.putBoolean("active", this.mActive);
            bundle.putLong("triggered_timestamp", this.mTriggeredTimestamp);
            return bundle;
        }

        public ConditionalUserProperty(@NonNull Bundle bundle) {
            Objects.requireNonNull(bundle, "null reference");
            this.mAppId = (String) f.S1(bundle, "app_id", String.class, null);
            this.mOrigin = (String) f.S1(bundle, "origin", String.class, null);
            this.mName = (String) f.S1(bundle, ModelAuditLogEntry.CHANGE_KEY_NAME, String.class, null);
            this.mValue = f.S1(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) f.S1(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) f.S1(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) f.S1(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) f.S1(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) f.S1(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) f.S1(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) f.S1(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) f.S1(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) f.S1(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) f.S1(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) f.S1(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) f.S1(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

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
    public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
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
            arrayList.add(new ConditionalUserProperty(it.next()));
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
        AnimatableValueParser.w(str);
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
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Objects.requireNonNull(conditionalUserProperty, "null reference");
        if (this.d) {
            this.c.f(conditionalUserProperty.a());
            return;
        }
        c6 c6VarS = this.f3008b.s();
        Bundle bundleA = conditionalUserProperty.a();
        Objects.requireNonNull((c) c6VarS.a.o);
        c6VarS.y(bundleA, System.currentTimeMillis());
    }

    public AppMeasurement(b7 b7Var) {
        this.c = b7Var;
        this.f3008b = null;
        this.d = true;
    }
}
