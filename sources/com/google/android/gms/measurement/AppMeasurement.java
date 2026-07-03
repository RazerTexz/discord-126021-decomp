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
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p330i.p332b.C3968a;
import p007b.p225i.p226a.p288f.p330i.p332b.C3999c6;
import p007b.p225i.p226a.p288f.p330i.p332b.C4051ga;
import p007b.p225i.p226a.p288f.p330i.p332b.C4072i7;
import p007b.p225i.p226a.p288f.p330i.p332b.C4196t9;
import p007b.p225i.p226a.p288f.p330i.p332b.C4202u4;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4138o6;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4171r6;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class AppMeasurement {

    /* JADX INFO: renamed from: a */
    public static volatile AppMeasurement f20652a;

    /* JADX INFO: renamed from: b */
    public final C4202u4 f20653b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC3988b7 f20654c;

    /* JADX INFO: renamed from: d */
    public final boolean f20655d;

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

        /* JADX INFO: renamed from: a */
        public final Bundle m9108a() {
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
                C3404f.m4282d2(bundle, obj);
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
            this.mAppId = (String) C3404f.m4245S1(bundle, "app_id", String.class, null);
            this.mOrigin = (String) C3404f.m4245S1(bundle, "origin", String.class, null);
            this.mName = (String) C3404f.m4245S1(bundle, ModelAuditLogEntry.CHANGE_KEY_NAME, String.class, null);
            this.mValue = C3404f.m4245S1(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) C3404f.m4245S1(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) C3404f.m4245S1(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) C3404f.m4245S1(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) C3404f.m4245S1(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) C3404f.m4245S1(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) C3404f.m4245S1(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) C3404f.m4245S1(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) C3404f.m4245S1(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) C3404f.m4245S1(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) C3404f.m4245S1(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) C3404f.m4245S1(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) C3404f.m4245S1(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    public AppMeasurement(C4202u4 c4202u4) {
        Objects.requireNonNull(c4202u4, "null reference");
        this.f20653b = c4202u4;
        this.f20654c = null;
        this.f20655d = false;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        InterfaceC3988b7 interfaceC3988b7;
        if (f20652a == null) {
            synchronized (AppMeasurement.class) {
                if (f20652a == null) {
                    try {
                        interfaceC3988b7 = (InterfaceC3988b7) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    } catch (ClassNotFoundException | Exception unused) {
                        interfaceC3988b7 = null;
                    }
                    if (interfaceC3988b7 != null) {
                        f20652a = new AppMeasurement(interfaceC3988b7);
                    } else {
                        f20652a = new AppMeasurement(C4202u4.m5933b(context, new zzae(0L, 0L, true, null, null, null, null), null));
                    }
                }
            }
        }
        return f20652a;
    }

    @Keep
    public void beginAdUnitExposure(@NonNull @Size(min = 1) String str) {
        if (this.f20655d) {
            this.f20654c.mo5508g(str);
            return;
        }
        C3968a c3968aM5937A = this.f20653b.m5937A();
        Objects.requireNonNull((C3401c) this.f20653b.f11267o);
        c3968aM5937A.m5442v(str, SystemClock.elapsedRealtime());
    }

    @Keep
    public void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.f20655d) {
            this.f20654c.mo5513l(str, str2, bundle);
        } else {
            this.f20653b.m5948s().m5555R(str, str2, bundle);
        }
    }

    @Keep
    public void endAdUnitExposure(@NonNull @Size(min = 1) String str) {
        if (this.f20655d) {
            this.f20654c.mo5511j(str);
            return;
        }
        C3968a c3968aM5937A = this.f20653b.m5937A();
        Objects.requireNonNull((C3401c) this.f20653b.f11267o);
        c3968aM5937A.m5445y(str, SystemClock.elapsedRealtime());
    }

    @Keep
    public long generateEventId() {
        return this.f20655d ? this.f20654c.mo5506e() : this.f20653b.m5949t().m5922t0();
    }

    @Nullable
    @Keep
    public String getAppInstanceId() {
        return this.f20655d ? this.f20654c.mo5504c() : this.f20653b.m5948s().f10598g.get();
    }

    @Keep
    @WorkerThread
    public List<ConditionalUserProperty> getConditionalUserProperties(@Nullable String str, @Nullable @Size(max = 23, min = 1) String str2) {
        List<Bundle> listM5881j0;
        if (this.f20655d) {
            listM5881j0 = this.f20654c.mo5509h(str, str2);
        } else {
            C3999c6 c3999c6M5948s = this.f20653b.m5948s();
            if (c3999c6M5948s.mo5725f().m5855y()) {
                c3999c6M5948s.mo5726g().f11141f.m5860a("Cannot get conditional user properties from analytics worker thread");
                listM5881j0 = new ArrayList<>(0);
            } else if (C4051ga.m5647a()) {
                c3999c6M5948s.mo5726g().f11141f.m5860a("Cannot get conditional user properties from main thread");
                listM5881j0 = new ArrayList<>(0);
            } else {
                AtomicReference atomicReference = new AtomicReference();
                c3999c6M5948s.f11202a.mo5725f().m5849s(atomicReference, 5000L, "get conditional user properties", new RunnableC4138o6(c3999c6M5948s, atomicReference, str, str2));
                List list = (List) atomicReference.get();
                if (list == null) {
                    c3999c6M5948s.mo5726g().f11141f.m5861b("Timed out waiting for get conditional user properties", null);
                    listM5881j0 = new ArrayList<>();
                } else {
                    listM5881j0 = C4196t9.m5881j0(list);
                }
            }
        }
        ArrayList arrayList = new ArrayList(listM5881j0 != null ? listM5881j0.size() : 0);
        Iterator<Bundle> it = listM5881j0.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty(it.next()));
        }
        return arrayList;
    }

    @Nullable
    @Keep
    public String getCurrentScreenClass() {
        if (this.f20655d) {
            return this.f20654c.mo5503b();
        }
        C4072i7 c4072i7 = this.f20653b.m5948s().f11202a.m5952w().f10775c;
        if (c4072i7 != null) {
            return c4072i7.f10817b;
        }
        return null;
    }

    @Nullable
    @Keep
    public String getCurrentScreenName() {
        if (this.f20655d) {
            return this.f20654c.mo5502a();
        }
        C4072i7 c4072i7 = this.f20653b.m5948s().f11202a.m5952w().f10775c;
        if (c4072i7 != null) {
            return c4072i7.f10816a;
        }
        return null;
    }

    @Nullable
    @Keep
    public String getGmpAppId() {
        return this.f20655d ? this.f20654c.mo5505d() : this.f20653b.m5948s().m5552O();
    }

    @Keep
    @WorkerThread
    public int getMaxUserProperties(@NonNull @Size(min = 1) String str) {
        if (this.f20655d) {
            return this.f20654c.mo5510i(str);
        }
        this.f20653b.m5948s();
        C1460d.m583w(str);
        return 25;
    }

    @Keep
    @WorkerThread
    public Map<String, Object> getUserProperties(@Nullable String str, @Nullable @Size(max = 24, min = 1) String str2, boolean z2) {
        if (this.f20655d) {
            return this.f20654c.mo5512k(str, str2, z2);
        }
        C3999c6 c3999c6M5948s = this.f20653b.m5948s();
        if (c3999c6M5948s.mo5725f().m5855y()) {
            c3999c6M5948s.mo5726g().f11141f.m5860a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (C4051ga.m5647a()) {
            c3999c6M5948s.mo5726g().f11141f.m5860a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        c3999c6M5948s.f11202a.mo5725f().m5849s(atomicReference, 5000L, "get user properties", new RunnableC4171r6(c3999c6M5948s, atomicReference, str, str2, z2));
        List<zzku> list = (List) atomicReference.get();
        if (list == null) {
            c3999c6M5948s.mo5726g().f11141f.m5861b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z2));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzku zzkuVar : list) {
            arrayMap.put(zzkuVar.f20671k, zzkuVar.m9117w0());
        }
        return arrayMap;
    }

    @Keep
    public void logEventInternal(String str, String str2, Bundle bundle) {
        if (this.f20655d) {
            this.f20654c.mo5514m(str, str2, bundle);
        } else {
            this.f20653b.m5948s().m5545H(str, str2, bundle);
        }
    }

    @Keep
    public void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty) {
        Objects.requireNonNull(conditionalUserProperty, "null reference");
        if (this.f20655d) {
            this.f20654c.mo5507f(conditionalUserProperty.m9108a());
            return;
        }
        C3999c6 c3999c6M5948s = this.f20653b.m5948s();
        Bundle bundleM9108a = conditionalUserProperty.m9108a();
        Objects.requireNonNull((C3401c) c3999c6M5948s.f11202a.f11267o);
        c3999c6M5948s.m5558y(bundleM9108a, System.currentTimeMillis());
    }

    public AppMeasurement(InterfaceC3988b7 interfaceC3988b7) {
        this.f20654c = interfaceC3988b7;
        this.f20653b = null;
        this.f20655d = true;
    }
}
