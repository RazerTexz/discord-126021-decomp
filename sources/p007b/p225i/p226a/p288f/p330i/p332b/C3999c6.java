package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3406h;
import p007b.p225i.p226a.p288f.p313h.p325l.C3587a9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3644ea;
import p007b.p225i.p226a.p288f.p313h.p325l.C3671g9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3817r9;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;
import p007b.p225i.p226a.p288f.p313h.p325l.C3893x7;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3713j9;

/* JADX INFO: renamed from: b.i.a.f.i.b.c6 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3999c6 extends AbstractC3974a5 {

    /* JADX INFO: renamed from: c */
    public C4248y6 f10594c;

    /* JADX INFO: renamed from: d */
    public InterfaceC4225w5 f10595d;

    /* JADX INFO: renamed from: e */
    public final Set<InterfaceC4258z5> f10596e;

    /* JADX INFO: renamed from: f */
    public boolean f10597f;

    /* JADX INFO: renamed from: g */
    public final AtomicReference<String> f10598g;

    /* JADX INFO: renamed from: h */
    public final Object f10599h;

    /* JADX INFO: renamed from: i */
    @GuardedBy("consentLock")
    public C4004d f10600i;

    /* JADX INFO: renamed from: j */
    @GuardedBy("consentLock")
    public int f10601j;

    /* JADX INFO: renamed from: k */
    public final AtomicLong f10602k;

    /* JADX INFO: renamed from: l */
    public long f10603l;

    /* JADX INFO: renamed from: m */
    public int f10604m;

    /* JADX INFO: renamed from: n */
    public final C4251y9 f10605n;

    /* JADX INFO: renamed from: o */
    public boolean f10606o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC4218v9 f10607p;

    public C3999c6(C4202u4 c4202u4) {
        super(c4202u4);
        this.f10596e = new CopyOnWriteArraySet();
        this.f10599h = new Object();
        this.f10606o = true;
        this.f10607p = new C4160q6(this);
        this.f10598g = new AtomicReference<>();
        this.f10600i = new C4004d(null, null);
        this.f10601j = 100;
        this.f10603l = -1L;
        this.f10604m = 100;
        this.f10602k = new AtomicLong(0L);
        this.f10605n = new C4251y9(c4202u4);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005f  */
    /* JADX INFO: renamed from: C */
    public static void m5538C(C3999c6 c3999c6, C4004d c4004d, int i, long j, boolean z2, boolean z3) {
        boolean z4;
        c3999c6.mo5848b();
        c3999c6.m5497t();
        if (j <= c3999c6.f10603l && C4004d.m5565e(c3999c6.f10604m, i)) {
            c3999c6.mo5726g().f11147l.m5861b("Dropped out-of-date consent setting, proposed settings", c4004d);
            return;
        }
        C4009d4 c4009d4M5867l = c3999c6.m5867l();
        Objects.requireNonNull(c4009d4M5867l);
        if (C3842t8.m5293b() && c4009d4M5867l.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
            c4009d4M5867l.mo5848b();
            if (c4009d4M5867l.m5576t(i)) {
                SharedPreferences.Editor editorEdit = c4009d4M5867l.m5579w().edit();
                editorEdit.putString("consent_settings", c4004d.m5568d());
                editorEdit.putInt("consent_source", i);
                editorEdit.apply();
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (!z4) {
            c3999c6.mo5726g().f11147l.m5861b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        c3999c6.f10603l = j;
        c3999c6.f10604m = i;
        C4161q7 c4161q7M5971p = c3999c6.m5971p();
        Objects.requireNonNull(c4161q7M5971p);
        if (C3842t8.m5293b() && c4161q7M5971p.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
            c4161q7M5971p.mo5848b();
            c4161q7M5971p.m5497t();
            if (z2) {
                c4161q7M5971p.m5973r().m5756y();
            }
            if (c4161q7M5971p.m5807E()) {
                c4161q7M5971p.m5814z(new RunnableC4025e8(c4161q7M5971p, c4161q7M5971p.m5811I(false)));
            }
        }
        if (z3) {
            c3999c6.m5971p().m5803A(new AtomicReference<>());
        }
    }

    /* JADX INFO: renamed from: A */
    public final void m5539A(C4004d c4004d, int i, long j) {
        boolean z2;
        C4004d c4004d2;
        boolean z3;
        boolean zM5569f;
        if (C3842t8.m5293b() && this.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
            m5497t();
            if (!(this.f11202a.f11260h.m5526o(C4142p.f11037I0) && i == 20) && c4004d.f10623b == null && c4004d.f10624c == null) {
                mo5726g().f11146k.m5860a("Discarding empty consent settings");
                return;
            }
            synchronized (this.f10599h) {
                z2 = false;
                if (C4004d.m5565e(i, this.f10601j)) {
                    zM5569f = c4004d.m5569f(this.f10600i);
                    if (c4004d.m5572k() && !this.f10600i.m5572k()) {
                        z2 = true;
                    }
                    C4004d c4004d3 = this.f10600i;
                    Boolean bool = c4004d.f10623b;
                    if (bool == null) {
                        bool = c4004d3.f10623b;
                    }
                    Boolean bool2 = c4004d.f10624c;
                    if (bool2 == null) {
                        bool2 = c4004d3.f10624c;
                    }
                    C4004d c4004d4 = new C4004d(bool, bool2);
                    this.f10600i = c4004d4;
                    this.f10601j = i;
                    z3 = z2;
                    c4004d2 = c4004d4;
                    z2 = true;
                } else {
                    c4004d2 = c4004d;
                    z3 = false;
                    zM5569f = false;
                }
            }
            if (!z2) {
                mo5726g().f11147l.m5861b("Ignoring lower-priority consent settings, proposed settings", c4004d2);
                return;
            }
            long andIncrement = this.f10602k.getAndIncrement();
            if (zM5569f) {
                this.f10598g.set(null);
                mo5725f().m5853w(new RunnableC4237x6(this, c4004d2, j, i, andIncrement, z3));
            } else if (this.f11202a.f11260h.m5526o(C4142p.f11037I0) && (i == 40 || i == 20)) {
                mo5725f().m5853w(new RunnableC4226w6(this, c4004d2, i, andIncrement, z3));
            } else {
                mo5725f().m5852v(new RunnableC4259z6(this, c4004d2, i, andIncrement, z3));
            }
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: B */
    public final void m5540B(InterfaceC4225w5 interfaceC4225w5) {
        InterfaceC4225w5 interfaceC4225w6;
        mo5848b();
        m5497t();
        if (interfaceC4225w5 != null && interfaceC4225w5 != (interfaceC4225w6 = this.f10595d)) {
            C1460d.m435G(interfaceC4225w6 == null, "EventInterceptor already set.");
        }
        this.f10595d = interfaceC4225w5;
    }

    @WorkerThread
    /* JADX INFO: renamed from: D */
    public final void m5541D(@Nullable Boolean bool, boolean z2) {
        mo5848b();
        m5497t();
        mo5726g().f11148m.m5861b("Setting app measurement enabled (FE)", bool);
        m5867l().m5575s(bool);
        if (C3842t8.m5293b() && this.f11202a.f11260h.m5526o(C4142p.f11035H0) && z2) {
            C4009d4 c4009d4M5867l = m5867l();
            Objects.requireNonNull(c4009d4M5867l);
            if (C3842t8.m5293b() && c4009d4M5867l.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
                c4009d4M5867l.mo5848b();
                SharedPreferences.Editor editorEdit = c4009d4M5867l.m5579w().edit();
                if (bool != null) {
                    editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    editorEdit.remove("measurement_enabled_from_api");
                }
                editorEdit.apply();
            }
        }
        if (C3842t8.m5293b() && this.f11202a.f11260h.m5526o(C4142p.f11035H0) && !this.f11202a.m5942h() && bool.booleanValue()) {
            return;
        }
        m5553P();
    }

    @WorkerThread
    /* JADX INFO: renamed from: E */
    public final void m5542E(String str, String str2, long j, Bundle bundle) {
        mo5848b();
        m5543F(str, str2, j, bundle, true, this.f10595d == null || C4196t9.m5885r0(str2), false, null);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0157  */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014d, code lost:
    
        r5 = 13;
     */
    @WorkerThread
    /* JADX INFO: renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5543F(String str, String str2, long j, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        boolean zM5755x;
        boolean z5;
        Bundle[] bundleArr;
        boolean z6;
        boolean z7;
        C1460d.m583w(str);
        Objects.requireNonNull(bundle, "null reference");
        mo5848b();
        m5497t();
        if (!this.f11202a.m5940d()) {
            mo5726g().f11148m.m5860a("Event not sent since app measurement is disabled");
            return;
        }
        List<String> list = m5970o().f10985i;
        if (list != null && !list.contains(str2)) {
            mo5726g().f11148m.m5862c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.f10597f) {
            this.f10597f = true;
            try {
                C4202u4 c4202u4 = this.f11202a;
                try {
                    (!c4202u4.f11258f ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, c4202u4.f11254b.getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.f11202a.f11254b);
                } catch (Exception e) {
                    mo5726g().f11144i.m5861b("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                mo5726g().f11147l.m5860a("Tag Manager is not found and thus will not be used");
            }
        }
        if (this.f11202a.f11260h.m5526o(C4142p.f11070e0) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            String string = bundle.getString("gclid");
            Objects.requireNonNull((C3401c) this.f11202a.f11267o);
            m5548K("auto", "_lgclid", string, System.currentTimeMillis());
        }
        if (C3644ea.m4872b() && this.f11202a.f11260h.m5526o(C4142p.f11112z0) && z2) {
            String[] strArr = C4196t9.f11232d;
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z7 = true;
                    break;
                } else {
                    if (strArr[i].equals(str2)) {
                        z7 = false;
                        break;
                    }
                    i++;
                }
            }
            if (z7) {
                m5866e().m5894H(bundle, m5867l().f10633D.m5681a());
            }
        }
        if (z4 && !"_iap".equals(str2)) {
            C4196t9 c4196t9M5949t = this.f11202a.m5949t();
            boolean z8 = C3893x7.m5362b() && this.f11202a.f11260h.m5526o(C4142p.f11043L0);
            int i2 = 2;
            if (c4196t9M5949t.m5909a0("event", str2)) {
                if (z8) {
                    if (c4196t9M5949t.m5908Z("event", 40, str2)) {
                        i2 = 0;
                    }
                } else if (c4196t9M5949t.m5908Z("event", 40, str2)) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                mo5726g().f11143h.m5861b("Invalid public event name. Event will not be logged (FE)", m5865d().m5766u(str2));
                this.f11202a.m5949t();
                this.f11202a.m5949t().m5904R(this.f10607p, i2, "_ev", C4196t9.m5872E(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
        }
        C4072i7 c4072i7M5656w = m5972q().m5656w(false);
        if (c4072i7M5656w != null && !bundle.containsKey("_sc")) {
            c4072i7M5656w.f10819d = true;
        }
        C4060h7.m5650A(c4072i7M5656w, bundle, z2 && z4);
        boolean zEquals = "am".equals(str);
        boolean zM5885r0 = C4196t9.m5885r0(str2);
        if (z2 && this.f10595d != null && !zM5885r0 && !zEquals) {
            mo5726g().f11148m.m5862c("Passing event to registered event handler (FE)", m5865d().m5766u(str2), m5865d().m5764s(bundle));
            AppMeasurementDynamiteService.C10806a c10806a = (AppMeasurementDynamiteService.C10806a) this.f10595d;
            Objects.requireNonNull(c10806a);
            try {
                c10806a.f20661a.mo4572Z(str, str2, bundle, j);
                return;
            } catch (RemoteException e2) {
                AppMeasurementDynamiteService.this.f20659a.mo5726g().f11144i.m5861b("Event interceptor threw exception", e2);
                return;
            }
        }
        if (this.f11202a.m5944m()) {
            int iM5921t = m5866e().m5921t(str2, C3893x7.m5362b() && this.f11202a.f11260h.m5526o(C4142p.f11043L0));
            if (iM5921t != 0) {
                mo5726g().f11143h.m5861b("Invalid event name. Event will not be logged (FE)", m5865d().m5766u(str2));
                m5866e();
                this.f11202a.m5949t().m5905S(this.f10607p, str3, iM5921t, "_ev", C4196t9.m5872E(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            String str4 = "_o";
            Bundle bundleM5929z = m5866e().m5929z(str3, str2, bundle, Collections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si")), z4);
            if (bundleM5929z != null && bundleM5929z.containsKey("_sc") && bundleM5929z.containsKey("_si")) {
                bundleM5929z.getString("_sn");
                bundleM5929z.getString("_sc");
                Long.valueOf(bundleM5929z.getLong("_si")).longValue();
            }
            if (this.f11202a.f11260h.m5526o(C4142p.f11054T) && m5972q().m5656w(false) != null && "_ae".equals(str2)) {
                long jM5585b = m5974s().f11330e.m5585b();
                if (jM5585b > 0) {
                    m5866e().m5893G(bundleM5929z, jM5585b);
                }
            }
            if (C3587a9.m4561b() && this.f11202a.f11260h.m5526o(C4142p.f11092p0)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    C4196t9 c4196t9M5866e = m5866e();
                    String string2 = bundleM5929z.getString("_ffr");
                    String strTrim = C3406h.m4371a(string2) ? null : string2.trim();
                    if (C4196t9.m5884q0(strTrim, c4196t9M5866e.m5867l().f10630A.m5694a())) {
                        c4196t9M5866e.mo5726g().f11148m.m5860a("Not logging duplicate session_start_with_rollout event");
                        z6 = false;
                    } else {
                        c4196t9M5866e.m5867l().f10630A.m5695b(strTrim);
                        z6 = true;
                    }
                    if (!z6) {
                        return;
                    }
                } else if ("_ae".equals(str2)) {
                    String strM5694a = m5866e().m5867l().f10630A.m5694a();
                    if (!TextUtils.isEmpty(strM5694a)) {
                        bundleM5929z.putString("_ffr", strM5694a);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleM5929z);
            m5866e().m5924v0().nextLong();
            if (m5867l().f10652v.m5648a() > 0 && m5867l().m5577u(j) && m5867l().f10654x.m5597b()) {
                mo5726g().f11149n.m5860a("Current session is expired, remove the session number, ID, and engagement time");
                Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                m5548K("auto", "_sid", null, System.currentTimeMillis());
                Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                m5548K("auto", "_sno", null, System.currentTimeMillis());
                Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                m5548K("auto", "_se", null, System.currentTimeMillis());
            }
            if (bundleM5929z.getLong("extend_session", 0L) == 1) {
                mo5726g().f11149n.m5860a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.f11202a.m5947r().f11329d.m5600b(j, true);
            }
            String[] strArr2 = (String[]) bundleM5929z.keySet().toArray(new String[bundleM5929z.size()]);
            Arrays.sort(strArr2);
            for (String str5 : strArr2) {
                m5866e();
                Object obj = bundleM5929z.get(str5);
                if (obj instanceof Bundle) {
                    bundleArr = new Bundle[]{(Bundle) obj};
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList2 = (ArrayList) obj;
                    bundleArr = (Bundle[]) arrayList2.toArray(new Bundle[arrayList2.size()]);
                } else {
                    bundleArr = null;
                }
                if (bundleArr != null) {
                    bundleM5929z.putParcelableArray(str5, bundleArr);
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList3 = arrayList;
                Bundle bundleM5927y = (Bundle) arrayList3.get(i3);
                String str6 = i3 != 0 ? "_ep" : str2;
                bundleM5927y.putString(str4, str);
                if (z3) {
                    bundleM5927y = m5866e().m5927y(bundleM5927y);
                }
                Bundle bundle2 = bundleM5927y;
                String str7 = str4;
                zzaq zzaqVar = new zzaq(str6, new zzap(bundle2), str, j);
                C4161q7 c4161q7M5971p = m5971p();
                Objects.requireNonNull(c4161q7M5971p);
                c4161q7M5971p.mo5848b();
                c4161q7M5971p.m5497t();
                C4113m3 c4113m3M5973r = c4161q7M5971p.m5973r();
                Objects.requireNonNull(c4113m3M5973r);
                Parcel parcelObtain = Parcel.obtain();
                zzaqVar.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                if (bArrMarshall.length > 131072) {
                    c4113m3M5973r.mo5726g().f11142g.m5860a("Event is too long for local database. Sending event directly to service");
                    z5 = true;
                    zM5755x = false;
                } else {
                    zM5755x = c4113m3M5973r.m5755x(0, bArrMarshall);
                    z5 = true;
                }
                c4161q7M5971p.m5814z(new RunnableC4013d8(c4161q7M5971p, true, zM5755x, zzaqVar, c4161q7M5971p.m5811I(z5), str3));
                if (!zEquals) {
                    Iterator<InterfaceC4258z5> it = this.f10596e.iterator();
                    while (it.hasNext()) {
                        it.next().mo5979a(str, str2, new Bundle(bundle2), j);
                    }
                }
                i3++;
                str4 = str7;
                arrayList = arrayList3;
            }
            if (m5972q().m5656w(false) == null || !"_ae".equals(str2)) {
                return;
            }
            C4228w8 c4228w8M5974s = m5974s();
            Objects.requireNonNull((C3401c) this.f11202a.f11267o);
            c4228w8M5974s.m5959w(true, true, SystemClock.elapsedRealtime());
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m5544G(String str, String str2, long j, Object obj) {
        mo5725f().m5852v(new RunnableC4083j6(this, str, str2, obj, j));
    }

    /* JADX INFO: renamed from: H */
    public final void m5545H(String str, String str2, Bundle bundle) {
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        m5546I(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: I */
    public final void m5546I(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) {
        String strM5651x;
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (this.f11202a.f11260h.m5526o(C4142p.f11104v0) && C4196t9.m5884q0(str2, "screen_view")) {
            C4060h7 c4060h7M5972q = m5972q();
            if (!c4060h7M5972q.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
                c4060h7M5972q.mo5726g().f11146k.m5860a("Manual screen reporting is disabled.");
                return;
            }
            synchronized (c4060h7M5972q.f10784l) {
                if (!c4060h7M5972q.f10783k) {
                    c4060h7M5972q.mo5726g().f11146k.m5860a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle2.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > 100)) {
                    c4060h7M5972q.mo5726g().f11146k.m5861b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle2.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > 100)) {
                    c4060h7M5972q.mo5726g().f11146k.m5861b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    Activity activity = c4060h7M5972q.f10779g;
                    strM5651x = activity != null ? C4060h7.m5651x(activity.getClass().getCanonicalName()) : "Activity";
                } else {
                    strM5651x = string2;
                }
                if (c4060h7M5972q.f10780h && c4060h7M5972q.f10775c != null) {
                    c4060h7M5972q.f10780h = false;
                    boolean zM5884q0 = C4196t9.m5884q0(c4060h7M5972q.f10775c.f10817b, strM5651x);
                    boolean zM5884q1 = C4196t9.m5884q0(c4060h7M5972q.f10775c.f10816a, string);
                    if (zM5884q0 && zM5884q1) {
                        c4060h7M5972q.mo5726g().f11146k.m5860a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                c4060h7M5972q.mo5726g().f11149n.m5862c("Logging screen view with name, class", string == null ? "null" : string, strM5651x == null ? "null" : strM5651x);
                C4072i7 c4072i7 = c4060h7M5972q.f10775c == null ? c4060h7M5972q.f10776d : c4060h7M5972q.f10775c;
                C4072i7 c4072i8 = new C4072i7(string, strM5651x, c4060h7M5972q.m5866e().m5922t0(), true, j);
                c4060h7M5972q.f10775c = c4072i8;
                c4060h7M5972q.f10776d = c4072i7;
                c4060h7M5972q.f10781i = c4072i8;
                Objects.requireNonNull((C3401c) c4060h7M5972q.f11202a.f11267o);
                c4060h7M5972q.mo5725f().m5852v(new RunnableC4095k7(c4060h7M5972q, bundle2, c4072i8, c4072i7, SystemClock.elapsedRealtime()));
                return;
            }
        }
        m5554Q(str3, str2, j, bundle2, z3, !z3 || this.f10595d == null || C4196t9.m5885r0(str2), !z2, null);
    }

    /* JADX INFO: renamed from: J */
    public final void m5547J(String str, String str2, Object obj) {
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        m5549L(str, str2, obj, true, System.currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    @WorkerThread
    /* JADX INFO: renamed from: K */
    public final void m5548K(String str, String str2, Object obj, long j) {
        String str3;
        Object obj2;
        C1460d.m583w(str);
        C1460d.m583w(str2);
        mo5848b();
        m5497t();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    Long lValueOf = Long.valueOf("false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    m5867l().f10650t.m5695b(lValueOf.longValue() == 1 ? "true" : "false");
                    obj2 = lValueOf;
                } else if (obj == null) {
                    m5867l().f10650t.m5695b("unset");
                    obj2 = obj;
                } else {
                    str3 = str2;
                    obj2 = obj;
                }
            } else if (obj == null) {
                m5867l().f10650t.m5695b("unset");
                obj2 = obj;
            } else {
                str3 = str2;
                obj2 = obj;
            }
            str3 = "_npa";
        } else {
            str3 = str2;
            obj2 = obj;
        }
        if (!this.f11202a.m5940d()) {
            mo5726g().f11149n.m5860a("User property not set since app measurement is disabled");
            return;
        }
        if (this.f11202a.m5944m()) {
            zzku zzkuVar = new zzku(str3, j, obj2, str);
            C4161q7 c4161q7M5971p = m5971p();
            c4161q7M5971p.mo5848b();
            c4161q7M5971p.m5497t();
            C4113m3 c4113m3M5973r = c4161q7M5971p.m5973r();
            Objects.requireNonNull(c4113m3M5973r);
            Parcel parcelObtain = Parcel.obtain();
            boolean zM5755x = false;
            zzkuVar.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            if (bArrMarshall.length > 131072) {
                c4113m3M5973r.mo5726g().f11142g.m5860a("User property too long for local database. Sending directly to service");
            } else {
                zM5755x = c4113m3M5973r.m5755x(1, bArrMarshall);
            }
            c4161q7M5971p.m5814z(new RunnableC4172r7(c4161q7M5971p, zM5755x, zzkuVar, c4161q7M5971p.m5811I(true)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    /* JADX INFO: renamed from: L */
    public final void m5549L(String str, String str2, Object obj, boolean z2, long j) {
        int iM5913h0;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z2) {
            iM5913h0 = m5866e().m5913h0(str2);
        } else {
            C4196t9 c4196t9M5866e = m5866e();
            if (!c4196t9M5866e.m5909a0("user property", str2)) {
                iM5913h0 = 6;
            } else if (!c4196t9M5866e.m5912f0("user property", C4236x5.f11341a, null, str2)) {
                iM5913h0 = 15;
            } else if (c4196t9M5866e.m5908Z("user property", 24, str2)) {
                iM5913h0 = 0;
            } else {
                iM5913h0 = 6;
            }
        }
        if (iM5913h0 != 0) {
            m5866e();
            this.f11202a.m5949t().m5904R(this.f10607p, iM5913h0, "_ev", C4196t9.m5872E(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj == null) {
            m5544G(str3, str2, j, null);
            return;
        }
        int iM5914i0 = m5866e().m5914i0(str2, obj);
        if (iM5914i0 != 0) {
            m5866e();
            this.f11202a.m5949t().m5904R(this.f10607p, iM5914i0, "_ev", C4196t9.m5872E(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
        } else {
            Object objM5916n0 = m5866e().m5916n0(str2, obj);
            if (objM5916n0 != null) {
                m5544G(str3, str2, j, objM5916n0);
            }
        }
    }

    /* JADX INFO: renamed from: M */
    public final void m5550M() {
        if (this.f11202a.f11254b.getApplicationContext() instanceof Application) {
            ((Application) this.f11202a.f11254b.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f10594c);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: N */
    public final void m5551N() {
        mo5848b();
        m5497t();
        if (this.f11202a.m5944m()) {
            if (this.f11202a.f11260h.m5526o(C4142p.f11068d0)) {
                Boolean boolM5534w = this.f11202a.f11260h.m5534w("google_analytics_deferred_deep_link_enabled");
                if (boolM5534w != null && boolM5534w.booleanValue()) {
                    mo5726g().f11148m.m5860a("Deferred Deep Link feature enabled.");
                    mo5725f().m5852v(new Runnable(this) { // from class: b.i.a.f.i.b.e6

                        /* JADX INFO: renamed from: j */
                        public final C3999c6 f10688j;

                        {
                            this.f10688j = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Pair pair;
                            NetworkInfo activeNetworkInfo;
                            URL url;
                            C3999c6 c3999c6 = this.f10688j;
                            c3999c6.mo5848b();
                            if (c3999c6.m5867l().f10655y.m5597b()) {
                                c3999c6.mo5726g().f11148m.m5860a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jM5648a = c3999c6.m5867l().f10656z.m5648a();
                            c3999c6.m5867l().f10656z.m5649b(jM5648a + 1);
                            if (jM5648a >= 5) {
                                c3999c6.mo5726g().f11144i.m5860a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                c3999c6.m5867l().f10655y.m5596a(true);
                                return;
                            }
                            C4202u4 c4202u4 = c3999c6.f11202a;
                            c4202u4.mo5725f().mo5848b();
                            C4202u4.m5936q(c4202u4.m5945n());
                            C4124n3 c4124n3M5955z = c4202u4.m5955z();
                            c4124n3M5955z.m5497t();
                            String str = c4124n3M5955z.f10979c;
                            C4009d4 c4009d4M5946o = c4202u4.m5946o();
                            c4009d4M5946o.mo5848b();
                            Objects.requireNonNull((C3401c) c4009d4M5946o.f11202a.f11267o);
                            long jElapsedRealtime = SystemClock.elapsedRealtime();
                            if (c4009d4M5946o.f10644n == null || jElapsedRealtime >= c4009d4M5946o.f10646p) {
                                C3992c c3992c = c4009d4M5946o.f11202a.f11260h;
                                Objects.requireNonNull(c3992c);
                                c4009d4M5946o.f10646p = c3992c.m5525n(str, C4142p.f11063b) + jElapsedRealtime;
                                try {
                                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(c4009d4M5946o.f11202a.f11254b);
                                    if (advertisingIdInfo != null) {
                                        c4009d4M5946o.f10644n = advertisingIdInfo.getId();
                                        c4009d4M5946o.f10645o = advertisingIdInfo.isLimitAdTrackingEnabled();
                                    }
                                    if (c4009d4M5946o.f10644n == null) {
                                        c4009d4M5946o.f10644n = "";
                                    }
                                } catch (Exception e) {
                                    c4009d4M5946o.mo5726g().f11148m.m5861b("Unable to get advertising id", e);
                                    c4009d4M5946o.f10644n = "";
                                }
                                pair = new Pair(c4009d4M5946o.f10644n, Boolean.valueOf(c4009d4M5946o.f10645o));
                            } else {
                                pair = new Pair(c4009d4M5946o.f10644n, Boolean.valueOf(c4009d4M5946o.f10645o));
                            }
                            if (!c4202u4.f11260h.m5536y().booleanValue() || ((Boolean) pair.second).booleanValue() || TextUtils.isEmpty((CharSequence) pair.first)) {
                                c4202u4.mo5726g().f11148m.m5860a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
                                return;
                            }
                            C4012d7 c4012d7M5945n = c4202u4.m5945n();
                            c4012d7M5945n.m5857o();
                            try {
                                activeNetworkInfo = ((ConnectivityManager) c4012d7M5945n.f11202a.f11254b.getSystemService("connectivity")).getActiveNetworkInfo();
                            } catch (SecurityException unused) {
                                activeNetworkInfo = null;
                            }
                            if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
                                c4202u4.mo5726g().f11144i.m5860a("Network is not available for Deferred Deep Link request. Skipping");
                                return;
                            }
                            C4196t9 c4196t9M5949t = c4202u4.m5949t();
                            c4202u4.m5955z();
                            String str2 = (String) pair.first;
                            long jM5648a2 = c4202u4.m5946o().f10656z.m5648a() - 1;
                            Objects.requireNonNull(c4196t9M5949t);
                            try {
                                C1460d.m583w(str2);
                                C1460d.m583w(str);
                                String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", 33025L, Integer.valueOf(c4196t9M5949t.m5928y0())), str2, str, Long.valueOf(jM5648a2));
                                if (str.equals(c4196t9M5949t.f11202a.f11260h.m5523h("debug.deferred.deeplink", ""))) {
                                    strConcat = strConcat.concat("&ddl_test=1");
                                }
                                url = new URL(strConcat);
                            } catch (IllegalArgumentException | MalformedURLException e2) {
                                c4196t9M5949t.mo5726g().f11141f.m5861b("Failed to create BOW URL for Deferred Deep Link. exception", e2.getMessage());
                                url = null;
                            }
                            C4012d7 c4012d7M5945n2 = c4202u4.m5945n();
                            C4235x4 c4235x4 = new C4235x4(c4202u4);
                            c4012d7M5945n2.mo5848b();
                            c4012d7M5945n2.m5857o();
                            Objects.requireNonNull(url, "null reference");
                            c4012d7M5945n2.mo5725f().m5854x(new RunnableC4036f7(c4012d7M5945n2, str, url, c4235x4));
                        }
                    });
                }
            }
            C4161q7 c4161q7M5971p = m5971p();
            c4161q7M5971p.mo5848b();
            c4161q7M5971p.m5497t();
            zzn zznVarM5811I = c4161q7M5971p.m5811I(true);
            c4161q7M5971p.m5973r().m5755x(3, new byte[0]);
            c4161q7M5971p.m5814z(new RunnableC4238x7(c4161q7M5971p, zznVarM5811I));
            this.f10606o = false;
            C4009d4 c4009d4M5867l = m5867l();
            c4009d4M5867l.mo5848b();
            String string = c4009d4M5867l.m5579w().getString("previous_os_version", null);
            c4009d4M5867l.m5864c().m5857o();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = c4009d4M5867l.m5579w().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            m5864c().m5857o();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            m5545H("auto", "_ou", bundle);
        }
    }

    @Nullable
    /* JADX INFO: renamed from: O */
    public final String m5552O() {
        C4202u4 c4202u4 = this.f11202a;
        String str = c4202u4.f11255c;
        if (str != null) {
            return str;
        }
        try {
            return C3404f.m4254V1(c4202u4.f11254b, "google_app_id");
        } catch (IllegalStateException e) {
            this.f11202a.mo5726g().f11141f.m5861b("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: P */
    public final void m5553P() {
        mo5848b();
        String strM5694a = m5867l().f10650t.m5694a();
        if (strM5694a != null) {
            if ("unset".equals(strM5694a)) {
                Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                m5548K("app", "_npa", null, System.currentTimeMillis());
            } else {
                Long lValueOf = Long.valueOf("true".equals(strM5694a) ? 1L : 0L);
                Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                m5548K("app", "_npa", lValueOf, System.currentTimeMillis());
            }
        }
        if (!this.f11202a.m5940d() || !this.f10606o) {
            mo5726g().f11148m.m5860a("Updating Scion state (FE)");
            C4161q7 c4161q7M5971p = m5971p();
            c4161q7M5971p.mo5848b();
            c4161q7M5971p.m5497t();
            c4161q7M5971p.m5814z(new RunnableC3989b8(c4161q7M5971p, c4161q7M5971p.m5811I(true)));
            return;
        }
        mo5726g().f11148m.m5860a("Recording app launch after enabling measurement for the first time (FE)");
        m5551N();
        if (C3817r9.m5212b() && this.f11202a.f11260h.m5526o(C4142p.f11094q0)) {
            m5974s().f11329d.m5599a();
        }
        if (((InterfaceC3713j9) C3671g9.f9974j.mo4555a()).mo4962a() && this.f11202a.f11260h.m5526o(C4142p.f11100t0)) {
            if (!(this.f11202a.f11276x.f10963a.m5946o().f10642l.m5648a() > 0)) {
                C4114m4 c4114m4 = this.f11202a.f11276x;
                c4114m4.m5758a(c4114m4.f10963a.f11254b.getPackageName());
            }
        }
        if (this.f11202a.f11260h.m5526o(C4142p.f11027D0)) {
            mo5725f().m5852v(new RunnableC4035f6(this));
        }
    }

    /* JADX INFO: renamed from: Q */
    public final void m5554Q(String str, String str2, long j, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        mo5725f().m5852v(new RunnableC4094k6(this, str, str2, j, bundle2, z2, z3, z4, null));
    }

    /* JADX INFO: renamed from: R */
    public final void m5555R(String str, String str2, Bundle bundle) {
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C1460d.m583w(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        mo5725f().m5852v(new RunnableC4149p6(this, bundle2));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC3974a5
    /* JADX INFO: renamed from: v */
    public final boolean mo5499v() {
        return false;
    }

    /* JADX INFO: renamed from: w */
    public final void m5556w(long j, boolean z2) {
        mo5848b();
        m5497t();
        mo5726g().f11148m.m5860a("Resetting analytics data (FE)");
        C4228w8 c4228w8M5974s = m5974s();
        c4228w8M5974s.mo5848b();
        C4014d9 c4014d9 = c4228w8M5974s.f11330e;
        c4014d9.f10670c.m5664c();
        c4014d9.f10668a = 0L;
        c4014d9.f10669b = 0L;
        boolean zM5940d = this.f11202a.m5940d();
        C4009d4 c4009d4M5867l = m5867l();
        c4009d4M5867l.f10641k.m5649b(j);
        if (!TextUtils.isEmpty(c4009d4M5867l.m5867l().f10630A.m5694a())) {
            c4009d4M5867l.f10630A.m5695b(null);
        }
        if (C3817r9.m5212b() && c4009d4M5867l.f11202a.f11260h.m5526o(C4142p.f11094q0)) {
            c4009d4M5867l.f10652v.m5649b(0L);
        }
        if (!c4009d4M5867l.f11202a.f11260h.m5535x()) {
            c4009d4M5867l.m5578v(!zM5940d);
        }
        c4009d4M5867l.f10631B.m5695b(null);
        c4009d4M5867l.f10632C.m5649b(0L);
        c4009d4M5867l.f10633D.m5682b(null);
        if (z2) {
            C4161q7 c4161q7M5971p = m5971p();
            c4161q7M5971p.mo5848b();
            c4161q7M5971p.m5497t();
            zzn zznVarM5811I = c4161q7M5971p.m5811I(false);
            c4161q7M5971p.m5973r().m5756y();
            c4161q7M5971p.m5814z(new RunnableC4194t7(c4161q7M5971p, zznVarM5811I));
        }
        if (C3817r9.m5212b() && this.f11202a.f11260h.m5526o(C4142p.f11094q0)) {
            m5974s().f11329d.m5599a();
        }
        this.f10606o = !zM5940d;
    }

    /* JADX INFO: renamed from: x */
    public final void m5557x(Bundle bundle, int i, long j) {
        if (C3842t8.m5293b() && this.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
            m5497t();
            String string = bundle.getString("ad_storage");
            if ((string == null || C4004d.m5567i(string) != null) && ((string = bundle.getString("analytics_storage")) == null || C4004d.m5567i(string) != null)) {
                string = null;
            }
            if (string != null) {
                mo5726g().f11146k.m5861b("Ignoring invalid consent setting", string);
                mo5726g().f11146k.m5860a("Valid consent values are 'granted', 'denied'");
            }
            m5539A(C4004d.m5566g(bundle), i, j);
        }
    }

    /* JADX INFO: renamed from: y */
    public final void m5558y(Bundle bundle, long j) {
        Objects.requireNonNull(bundle, "null reference");
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            mo5726g().f11144i.m5860a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        C3404f.m4245S1(bundle2, "app_id", String.class, null);
        C3404f.m4245S1(bundle2, "origin", String.class, null);
        C3404f.m4245S1(bundle2, ModelAuditLogEntry.CHANGE_KEY_NAME, String.class, null);
        C3404f.m4245S1(bundle2, "value", Object.class, null);
        C3404f.m4245S1(bundle2, "trigger_event_name", String.class, null);
        C3404f.m4245S1(bundle2, "trigger_timeout", Long.class, 0L);
        C3404f.m4245S1(bundle2, "timed_out_event_name", String.class, null);
        C3404f.m4245S1(bundle2, "timed_out_event_params", Bundle.class, null);
        C3404f.m4245S1(bundle2, "triggered_event_name", String.class, null);
        C3404f.m4245S1(bundle2, "triggered_event_params", Bundle.class, null);
        C3404f.m4245S1(bundle2, "time_to_live", Long.class, 0L);
        C3404f.m4245S1(bundle2, "expired_event_name", String.class, null);
        C3404f.m4245S1(bundle2, "expired_event_params", Bundle.class, null);
        C1460d.m583w(bundle2.getString(ModelAuditLogEntry.CHANGE_KEY_NAME));
        C1460d.m583w(bundle2.getString("origin"));
        Objects.requireNonNull(bundle2.get("value"), "null reference");
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
        Object obj = bundle2.get("value");
        if (m5866e().m5913h0(string) != 0) {
            mo5726g().f11141f.m5861b("Invalid conditional user property name", m5865d().m5769y(string));
            return;
        }
        if (m5866e().m5914i0(string, obj) != 0) {
            mo5726g().f11141f.m5862c("Invalid conditional user property value", m5865d().m5769y(string), obj);
            return;
        }
        Object objM5916n0 = m5866e().m5916n0(string, obj);
        if (objM5916n0 == null) {
            mo5726g().f11141f.m5862c("Unable to normalize conditional user property value", m5865d().m5769y(string), obj);
            return;
        }
        C3404f.m4282d2(bundle2, objM5916n0);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            mo5726g().f11141f.m5862c("Invalid conditional user property timeout", m5865d().m5769y(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong("time_to_live");
        if (j3 > 15552000000L || j3 < 1) {
            mo5726g().f11141f.m5862c("Invalid conditional user property time to live", m5865d().m5769y(string), Long.valueOf(j3));
        } else {
            mo5725f().m5852v(new RunnableC4127n6(this, bundle2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    @WorkerThread
    /* JADX INFO: renamed from: z */
    public final void m5559z(C4004d c4004d) {
        Boolean boolValueOf;
        mo5848b();
        boolean z2 = (c4004d.m5572k() && c4004d.m5571j()) || m5971p().m5807E();
        if (z2 != this.f11202a.m5942h()) {
            C4202u4 c4202u4 = this.f11202a;
            c4202u4.mo5725f().mo5848b();
            c4202u4.f11250E = z2;
            C4009d4 c4009d4M5867l = m5867l();
            Objects.requireNonNull(c4009d4M5867l);
            if (C3842t8.m5293b() && c4009d4M5867l.f11202a.f11260h.m5526o(C4142p.f11035H0)) {
                c4009d4M5867l.mo5848b();
                if (c4009d4M5867l.m5579w().contains("measurement_enabled_from_api")) {
                    boolValueOf = Boolean.valueOf(c4009d4M5867l.m5579w().getBoolean("measurement_enabled_from_api", true));
                } else {
                    boolValueOf = null;
                }
            } else {
                boolValueOf = null;
            }
            if (!z2 || boolValueOf == null || boolValueOf.booleanValue()) {
                m5541D(Boolean.valueOf(z2), false);
            }
        }
    }
}
