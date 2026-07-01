package b.i.a.f.i.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences$Editor;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService$a;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c6 extends a5 {
    public y6 c;
    public w5 d;
    public final Set<z5> e;
    public boolean f;
    public final AtomicReference<String> g;
    public final Object h;

    @GuardedBy("consentLock")
    public d i;

    @GuardedBy("consentLock")
    public int j;
    public final AtomicLong k;
    public long l;
    public int m;
    public final y9 n;
    public boolean o;
    public final v9 p;

    public c6(u4 u4Var) {
        super(u4Var);
        this.e = new CopyOnWriteArraySet();
        this.h = new Object();
        this.o = true;
        this.p = new q6(this);
        this.g = new AtomicReference<>();
        this.i = new d(null, null);
        this.j = 100;
        this.l = -1L;
        this.m = 100;
        this.k = new AtomicLong(0L);
        this.n = new y9(u4Var);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x005f  */
    public static void C(c6 c6Var, d dVar, int i, long j, boolean z2, boolean z3) {
        boolean z4;
        c6Var.b();
        c6Var.t();
        if (j <= c6Var.l && d.e(c6Var.m, i)) {
            c6Var.g().l.b("Dropped out-of-date consent setting, proposed settings", dVar);
            return;
        }
        d4 d4VarL = c6Var.l();
        Objects.requireNonNull(d4VarL);
        if (b.i.a.f.h.l.t8.b() && d4VarL.a.h.o(p.H0)) {
            d4VarL.b();
            if (d4VarL.t(i)) {
                SharedPreferences$Editor sharedPreferences$EditorEdit = d4VarL.w().edit();
                sharedPreferences$EditorEdit.putString("consent_settings", dVar.d());
                sharedPreferences$EditorEdit.putInt("consent_source", i);
                sharedPreferences$EditorEdit.apply();
                z4 = true;
            } else {
                z4 = false;
            }
        } else {
            z4 = false;
        }
        if (!z4) {
            c6Var.g().l.b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        c6Var.l = j;
        c6Var.m = i;
        q7 q7VarP = c6Var.p();
        Objects.requireNonNull(q7VarP);
        if (b.i.a.f.h.l.t8.b() && q7VarP.a.h.o(p.H0)) {
            q7VarP.b();
            q7VarP.t();
            if (z2) {
                q7VarP.r().y();
            }
            if (q7VarP.E()) {
                q7VarP.z(new e8(q7VarP, q7VarP.I(false)));
            }
        }
        if (z3) {
            c6Var.p().A(new AtomicReference<>());
        }
    }

    public final void A(d dVar, int i, long j) {
        boolean z2;
        d dVar2;
        boolean z3;
        boolean zF;
        if (b.i.a.f.h.l.t8.b() && this.a.h.o(p.H0)) {
            t();
            if (!(this.a.h.o(p.I0) && i == 20) && dVar.f1523b == null && dVar.c == null) {
                g().k.a("Discarding empty consent settings");
                return;
            }
            synchronized (this.h) {
                z2 = false;
                if (d.e(i, this.j)) {
                    zF = dVar.f(this.i);
                    if (dVar.k() && !this.i.k()) {
                        z2 = true;
                    }
                    d dVar3 = this.i;
                    Boolean bool = dVar.f1523b;
                    if (bool == null) {
                        bool = dVar3.f1523b;
                    }
                    Boolean bool2 = dVar.c;
                    if (bool2 == null) {
                        bool2 = dVar3.c;
                    }
                    d dVar4 = new d(bool, bool2);
                    this.i = dVar4;
                    this.j = i;
                    z3 = z2;
                    dVar2 = dVar4;
                    z2 = true;
                } else {
                    dVar2 = dVar;
                    z3 = false;
                    zF = false;
                }
            }
            if (!z2) {
                g().l.b("Ignoring lower-priority consent settings, proposed settings", dVar2);
                return;
            }
            long andIncrement = this.k.getAndIncrement();
            if (zF) {
                this.g.set(null);
                f().w(new x6(this, dVar2, j, i, andIncrement, z3));
            } else if (this.a.h.o(p.I0) && (i == 40 || i == 20)) {
                f().w(new w6(this, dVar2, i, andIncrement, z3));
            } else {
                f().v(new z6(this, dVar2, i, andIncrement, z3));
            }
        }
    }

    @WorkerThread
    public final void B(w5 w5Var) {
        w5 w5Var2;
        b();
        t();
        if (w5Var != null && w5Var != (w5Var2 = this.d)) {
            b.c.a.a0.d.G(w5Var2 == null, "EventInterceptor already set.");
        }
        this.d = w5Var;
    }

    @WorkerThread
    public final void D(@Nullable Boolean bool, boolean z2) {
        b();
        t();
        g().m.b("Setting app measurement enabled (FE)", bool);
        l().s(bool);
        if (b.i.a.f.h.l.t8.b() && this.a.h.o(p.H0) && z2) {
            d4 d4VarL = l();
            Objects.requireNonNull(d4VarL);
            if (b.i.a.f.h.l.t8.b() && d4VarL.a.h.o(p.H0)) {
                d4VarL.b();
                SharedPreferences$Editor sharedPreferences$EditorEdit = d4VarL.w().edit();
                if (bool != null) {
                    sharedPreferences$EditorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
                } else {
                    sharedPreferences$EditorEdit.remove("measurement_enabled_from_api");
                }
                sharedPreferences$EditorEdit.apply();
            }
        }
        if (b.i.a.f.h.l.t8.b() && this.a.h.o(p.H0) && !this.a.h() && bool.booleanValue()) {
            return;
        }
        P();
    }

    @WorkerThread
    public final void E(String str, String str2, long j, Bundle bundle) {
        b();
        F(str, str2, j, bundle, true, this.d == null || t9.r0(str2), false, null);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0157  */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014d, code lost:
    
        r5 = 13;
     */
    @WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F(String str, String str2, long j, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
        boolean zX;
        boolean z5;
        Bundle[] bundleArr;
        boolean z6;
        boolean z7;
        b.c.a.a0.d.w(str);
        Objects.requireNonNull(bundle, "null reference");
        b();
        t();
        if (!this.a.d()) {
            g().m.a("Event not sent since app measurement is disabled");
            return;
        }
        List<String> list = o().i;
        if (list != null && !list.contains(str2)) {
            g().m.c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.f) {
            this.f = true;
            try {
                u4 u4Var = this.a;
                try {
                    (!u4Var.f ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, u4Var.f1570b.getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.a.f1570b);
                } catch (Exception e) {
                    g().i.b("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                g().l.a("Tag Manager is not found and thus will not be used");
            }
        }
        if (this.a.h.o(p.f1556e0) && "_cmp".equals(str2) && bundle.containsKey("gclid")) {
            String string = bundle.getString("gclid");
            Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
            K("auto", "_lgclid", string, System.currentTimeMillis());
        }
        if (b.i.a.f.h.l.ea.b() && this.a.h.o(p.z0) && z2) {
            String[] strArr = t9.d;
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
                e().H(bundle, l().D.a());
            }
        }
        if (z4 && !"_iap".equals(str2)) {
            t9 t9VarT = this.a.t();
            boolean z8 = b.i.a.f.h.l.x7.b() && this.a.h.o(p.L0);
            int i2 = 2;
            if (t9VarT.a0("event", str2)) {
                if (z8) {
                    if (t9VarT.Z("event", 40, str2)) {
                        i2 = 0;
                    }
                } else if (t9VarT.Z("event", 40, str2)) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                g().h.b("Invalid public event name. Event will not be logged (FE)", d().u(str2));
                this.a.t();
                this.a.t().R(this.p, i2, "_ev", t9.E(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
        }
        i7 i7VarW = q().w(false);
        if (i7VarW != null && !bundle.containsKey("_sc")) {
            i7VarW.d = true;
        }
        h7.A(i7VarW, bundle, z2 && z4);
        boolean zEquals = "am".equals(str);
        boolean zR0 = t9.r0(str2);
        if (z2 && this.d != null && !zR0 && !zEquals) {
            g().m.c("Passing event to registered event handler (FE)", d().u(str2), d().s(bundle));
            AppMeasurementDynamiteService$a appMeasurementDynamiteService$a = (AppMeasurementDynamiteService$a) this.d;
            Objects.requireNonNull(appMeasurementDynamiteService$a);
            try {
                appMeasurementDynamiteService$a.a.Z(str, str2, bundle, j);
                return;
            } catch (RemoteException e2) {
                appMeasurementDynamiteService$a.f3010b.a.g().i.b("Event interceptor threw exception", e2);
                return;
            }
        }
        if (this.a.m()) {
            int iT = e().t(str2, b.i.a.f.h.l.x7.b() && this.a.h.o(p.L0));
            if (iT != 0) {
                g().h.b("Invalid event name. Event will not be logged (FE)", d().u(str2));
                e();
                this.a.t().S(this.p, str3, iT, "_ev", t9.E(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            String str4 = "_o";
            Bundle bundleZ = e().z(str3, str2, bundle, Collections.unmodifiableList(Arrays.asList("_o", "_sn", "_sc", "_si")), z4);
            if (bundleZ != null && bundleZ.containsKey("_sc") && bundleZ.containsKey("_si")) {
                bundleZ.getString("_sn");
                bundleZ.getString("_sc");
                Long.valueOf(bundleZ.getLong("_si")).longValue();
            }
            if (this.a.h.o(p.T) && q().w(false) != null && "_ae".equals(str2)) {
                long jB = s().e.b();
                if (jB > 0) {
                    e().G(bundleZ, jB);
                }
            }
            if (b.i.a.f.h.l.a9.b() && this.a.h.o(p.p0)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    t9 t9VarE = e();
                    String string2 = bundleZ.getString("_ffr");
                    String strTrim = b.i.a.f.e.o.h.a(string2) ? null : string2.trim();
                    if (t9.q0(strTrim, t9VarE.l().A.a())) {
                        t9VarE.g().m.a("Not logging duplicate session_start_with_rollout event");
                        z6 = false;
                    } else {
                        t9VarE.l().A.b(strTrim);
                        z6 = true;
                    }
                    if (!z6) {
                        return;
                    }
                } else if ("_ae".equals(str2)) {
                    String strA = e().l().A.a();
                    if (!TextUtils.isEmpty(strA)) {
                        bundleZ.putString("_ffr", strA);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZ);
            e().v0().nextLong();
            if (l().v.a() > 0 && l().u(j) && l().f1525x.b()) {
                g().n.a("Current session is expired, remove the session number, ID, and engagement time");
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                K("auto", "_sid", null, System.currentTimeMillis());
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                K("auto", "_sno", null, System.currentTimeMillis());
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                K("auto", "_se", null, System.currentTimeMillis());
            }
            if (bundleZ.getLong("extend_session", 0L) == 1) {
                g().n.a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.a.r().d.b(j, true);
            }
            String[] strArr2 = (String[]) bundleZ.keySet().toArray(new String[bundleZ.size()]);
            Arrays.sort(strArr2);
            for (String str5 : strArr2) {
                e();
                Object obj = bundleZ.get(str5);
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
                    bundleZ.putParcelableArray(str5, bundleArr);
                }
            }
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ArrayList arrayList3 = arrayList;
                Bundle bundleY = (Bundle) arrayList3.get(i3);
                String str6 = i3 != 0 ? "_ep" : str2;
                bundleY.putString(str4, str);
                if (z3) {
                    bundleY = e().y(bundleY);
                }
                Bundle bundle2 = bundleY;
                String str7 = str4;
                zzaq zzaqVar = new zzaq(str6, new zzap(bundle2), str, j);
                q7 q7VarP = p();
                Objects.requireNonNull(q7VarP);
                q7VarP.b();
                q7VarP.t();
                m3 m3VarR = q7VarP.r();
                Objects.requireNonNull(m3VarR);
                Parcel parcelObtain = Parcel.obtain();
                zzaqVar.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                if (bArrMarshall.length > 131072) {
                    m3VarR.g().g.a("Event is too long for local database. Sending event directly to service");
                    z5 = true;
                    zX = false;
                } else {
                    zX = m3VarR.x(0, bArrMarshall);
                    z5 = true;
                }
                q7VarP.z(new d8(q7VarP, true, zX, zzaqVar, q7VarP.I(z5), str3));
                if (!zEquals) {
                    Iterator<z5> it = this.e.iterator();
                    while (it.hasNext()) {
                        it.next().a(str, str2, new Bundle(bundle2), j);
                    }
                }
                i3++;
                str4 = str7;
                arrayList = arrayList3;
            }
            if (q().w(false) == null || !"_ae".equals(str2)) {
                return;
            }
            w8 w8VarS = s();
            Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
            w8VarS.w(true, true, SystemClock.elapsedRealtime());
        }
    }

    public final void G(String str, String str2, long j, Object obj) {
        f().v(new j6(this, str, str2, obj, j));
    }

    public final void H(String str, String str2, Bundle bundle) {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        I(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    public final void I(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) {
        String strX;
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (this.a.h.o(p.v0) && t9.q0(str2, "screen_view")) {
            h7 h7VarQ = q();
            if (!h7VarQ.a.h.o(p.v0)) {
                h7VarQ.g().k.a("Manual screen reporting is disabled.");
                return;
            }
            synchronized (h7VarQ.l) {
                if (!h7VarQ.k) {
                    h7VarQ.g().k.a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String string = bundle2.getString("screen_name");
                if (string != null && (string.length() <= 0 || string.length() > 100)) {
                    h7VarQ.g().k.b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                    return;
                }
                String string2 = bundle2.getString("screen_class");
                if (string2 != null && (string2.length() <= 0 || string2.length() > 100)) {
                    h7VarQ.g().k.b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                    return;
                }
                if (string2 == null) {
                    Activity activity = h7VarQ.g;
                    strX = activity != null ? h7.x(activity.getClass().getCanonicalName()) : "Activity";
                } else {
                    strX = string2;
                }
                if (h7VarQ.h && h7VarQ.c != null) {
                    h7VarQ.h = false;
                    boolean zQ0 = t9.q0(h7VarQ.c.f1537b, strX);
                    boolean zQ1 = t9.q0(h7VarQ.c.a, string);
                    if (zQ0 && zQ1) {
                        h7VarQ.g().k.a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                h7VarQ.g().n.c("Logging screen view with name, class", string == null ? "null" : string, strX == null ? "null" : strX);
                i7 i7Var = h7VarQ.c == null ? h7VarQ.d : h7VarQ.c;
                i7 i7Var2 = new i7(string, strX, h7VarQ.e().t0(), true, j);
                h7VarQ.c = i7Var2;
                h7VarQ.d = i7Var;
                h7VarQ.i = i7Var2;
                Objects.requireNonNull((b.i.a.f.e.o.c) h7VarQ.a.o);
                h7VarQ.f().v(new k7(h7VarQ, bundle2, i7Var2, i7Var, SystemClock.elapsedRealtime()));
                return;
            }
        }
        Q(str3, str2, j, bundle2, z3, !z3 || this.d == null || t9.r0(str2), !z2, null);
    }

    public final void J(String str, String str2, Object obj) {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        L(str, str2, obj, true, System.currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:19:0x0060  */
    @WorkerThread
    public final void K(String str, String str2, Object obj, long j) {
        String str3;
        Object obj2;
        b.c.a.a0.d.w(str);
        b.c.a.a0.d.w(str2);
        b();
        t();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    Long lValueOf = Long.valueOf("false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    l().t.b(lValueOf.longValue() == 1 ? "true" : "false");
                    obj2 = lValueOf;
                } else if (obj == null) {
                    l().t.b("unset");
                    obj2 = obj;
                } else {
                    str3 = str2;
                    obj2 = obj;
                }
            } else if (obj == null) {
                l().t.b("unset");
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
        if (!this.a.d()) {
            g().n.a("User property not set since app measurement is disabled");
            return;
        }
        if (this.a.m()) {
            zzku zzkuVar = new zzku(str3, j, obj2, str);
            q7 q7VarP = p();
            q7VarP.b();
            q7VarP.t();
            m3 m3VarR = q7VarP.r();
            Objects.requireNonNull(m3VarR);
            Parcel parcelObtain = Parcel.obtain();
            boolean zX = false;
            zzkuVar.writeToParcel(parcelObtain, 0);
            byte[] bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
            if (bArrMarshall.length > 131072) {
                m3VarR.g().g.a("User property too long for local database. Sending directly to service");
            } else {
                zX = m3VarR.x(1, bArrMarshall);
            }
            q7VarP.z(new r7(q7VarP, zX, zzkuVar, q7VarP.I(true)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    public final void L(String str, String str2, Object obj, boolean z2, long j) {
        int iH0;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z2) {
            iH0 = e().h0(str2);
        } else {
            t9 t9VarE = e();
            if (!t9VarE.a0("user property", str2)) {
                iH0 = 6;
            } else if (!t9VarE.f0("user property", x5.a, null, str2)) {
                iH0 = 15;
            } else if (t9VarE.Z("user property", 24, str2)) {
                iH0 = 0;
            } else {
                iH0 = 6;
            }
        }
        if (iH0 != 0) {
            e();
            this.a.t().R(this.p, iH0, "_ev", t9.E(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj == null) {
            G(str3, str2, j, null);
            return;
        }
        int iI0 = e().i0(str2, obj);
        if (iI0 != 0) {
            e();
            this.a.t().R(this.p, iI0, "_ev", t9.E(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
        } else {
            Object objN0 = e().n0(str2, obj);
            if (objN0 != null) {
                G(str3, str2, j, objN0);
            }
        }
    }

    public final void M() {
        if (this.a.f1570b.getApplicationContext() instanceof Application) {
            ((Application) this.a.f1570b.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.c);
        }
    }

    @WorkerThread
    public final void N() {
        b();
        t();
        if (this.a.m()) {
            if (this.a.h.o(p.f1555d0)) {
                Boolean boolW = this.a.h.w("google_analytics_deferred_deep_link_enabled");
                if (boolW != null && boolW.booleanValue()) {
                    g().m.a("Deferred Deep Link feature enabled.");
                    f().v(new e6(this));
                }
            }
            q7 q7VarP = p();
            q7VarP.b();
            q7VarP.t();
            zzn zznVarI = q7VarP.I(true);
            q7VarP.r().x(3, new byte[0]);
            q7VarP.z(new x7(q7VarP, zznVarI));
            this.o = false;
            d4 d4VarL = l();
            d4VarL.b();
            String string = d4VarL.w().getString("previous_os_version", null);
            d4VarL.c().o();
            String str = Build$VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences$Editor sharedPreferences$EditorEdit = d4VarL.w().edit();
                sharedPreferences$EditorEdit.putString("previous_os_version", str);
                sharedPreferences$EditorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            c().o();
            if (string.equals(str)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            H("auto", "_ou", bundle);
        }
    }

    @Nullable
    public final String O() {
        u4 u4Var = this.a;
        String str = u4Var.c;
        if (str != null) {
            return str;
        }
        try {
            return b.i.a.f.e.o.f.V1(u4Var.f1570b, "google_app_id");
        } catch (IllegalStateException e) {
            this.a.g().f.b("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @WorkerThread
    public final void P() {
        b();
        String strA = l().t.a();
        if (strA != null) {
            if ("unset".equals(strA)) {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                K("app", "_npa", null, System.currentTimeMillis());
            } else {
                Long lValueOf = Long.valueOf("true".equals(strA) ? 1L : 0L);
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                K("app", "_npa", lValueOf, System.currentTimeMillis());
            }
        }
        if (!this.a.d() || !this.o) {
            g().m.a("Updating Scion state (FE)");
            q7 q7VarP = p();
            q7VarP.b();
            q7VarP.t();
            q7VarP.z(new b8(q7VarP, q7VarP.I(true)));
            return;
        }
        g().m.a("Recording app launch after enabling measurement for the first time (FE)");
        N();
        if (b.i.a.f.h.l.r9.b() && this.a.h.o(p.q0)) {
            s().d.a();
        }
        if (((b.i.a.f.h.l.j9) b.i.a.f.h.l.g9.j.a()).a() && this.a.h.o(p.t0)) {
            if (!(this.a.f1572x.a.o().l.a() > 0)) {
                m4 m4Var = this.a.f1572x;
                m4Var.a(m4Var.a.f1570b.getPackageName());
            }
        }
        if (this.a.h.o(p.D0)) {
            f().v(new f6(this));
        }
    }

    public final void Q(String str, String str2, long j, Bundle bundle, boolean z2, boolean z3, boolean z4, String str3) {
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
        f().v(new k6(this, str, str2, j, bundle2, z2, z3, z4, null));
    }

    public final void R(String str, String str2, Bundle bundle) {
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        long jCurrentTimeMillis = System.currentTimeMillis();
        b.c.a.a0.d.w(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, str);
        bundle2.putLong("creation_timestamp", jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        f().v(new p6(this, bundle2));
    }

    @Override // b.i.a.f.i.b.a5
    public final boolean v() {
        return false;
    }

    public final void w(long j, boolean z2) {
        b();
        t();
        g().m.a("Resetting analytics data (FE)");
        w8 w8VarS = s();
        w8VarS.b();
        d9 d9Var = w8VarS.e;
        d9Var.c.c();
        d9Var.a = 0L;
        d9Var.f1528b = 0L;
        boolean zD = this.a.d();
        d4 d4VarL = l();
        d4VarL.k.b(j);
        if (!TextUtils.isEmpty(d4VarL.l().A.a())) {
            d4VarL.A.b(null);
        }
        if (b.i.a.f.h.l.r9.b() && d4VarL.a.h.o(p.q0)) {
            d4VarL.v.b(0L);
        }
        if (!d4VarL.a.h.x()) {
            d4VarL.v(!zD);
        }
        d4VarL.B.b(null);
        d4VarL.C.b(0L);
        d4VarL.D.b(null);
        if (z2) {
            q7 q7VarP = p();
            q7VarP.b();
            q7VarP.t();
            zzn zznVarI = q7VarP.I(false);
            q7VarP.r().y();
            q7VarP.z(new t7(q7VarP, zznVarI));
        }
        if (b.i.a.f.h.l.r9.b() && this.a.h.o(p.q0)) {
            s().d.a();
        }
        this.o = !zD;
    }

    public final void x(Bundle bundle, int i, long j) {
        if (b.i.a.f.h.l.t8.b() && this.a.h.o(p.H0)) {
            t();
            String string = bundle.getString("ad_storage");
            if ((string == null || d.i(string) != null) && ((string = bundle.getString("analytics_storage")) == null || d.i(string) != null)) {
                string = null;
            }
            if (string != null) {
                g().k.b("Ignoring invalid consent setting", string);
                g().k.a("Valid consent values are 'granted', 'denied'");
            }
            A(d.g(bundle), i, j);
        }
    }

    public final void y(Bundle bundle, long j) {
        Objects.requireNonNull(bundle, "null reference");
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            g().i.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        b.i.a.f.e.o.f.S1(bundle2, "app_id", String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "origin", String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, ModelAuditLogEntry.CHANGE_KEY_NAME, String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "value", Object.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "trigger_event_name", String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "trigger_timeout", Long.class, 0L);
        b.i.a.f.e.o.f.S1(bundle2, "timed_out_event_name", String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "timed_out_event_params", Bundle.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "triggered_event_name", String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "triggered_event_params", Bundle.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "time_to_live", Long.class, 0L);
        b.i.a.f.e.o.f.S1(bundle2, "expired_event_name", String.class, null);
        b.i.a.f.e.o.f.S1(bundle2, "expired_event_params", Bundle.class, null);
        b.c.a.a0.d.w(bundle2.getString(ModelAuditLogEntry.CHANGE_KEY_NAME));
        b.c.a.a0.d.w(bundle2.getString("origin"));
        Objects.requireNonNull(bundle2.get("value"), "null reference");
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
        Object obj = bundle2.get("value");
        if (e().h0(string) != 0) {
            g().f.b("Invalid conditional user property name", d().y(string));
            return;
        }
        if (e().i0(string, obj) != 0) {
            g().f.c("Invalid conditional user property value", d().y(string), obj);
            return;
        }
        Object objN0 = e().n0(string, obj);
        if (objN0 == null) {
            g().f.c("Unable to normalize conditional user property value", d().y(string), obj);
            return;
        }
        b.i.a.f.e.o.f.d2(bundle2, objN0);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            g().f.c("Invalid conditional user property timeout", d().y(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong("time_to_live");
        if (j3 > 15552000000L || j3 < 1) {
            g().f.c("Invalid conditional user property time to live", d().y(string), Long.valueOf(j3));
        } else {
            f().v(new n6(this, bundle2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0066  */
    @WorkerThread
    public final void z(d dVar) {
        Boolean boolValueOf;
        b();
        boolean z2 = (dVar.k() && dVar.j()) || p().E();
        if (z2 != this.a.h()) {
            u4 u4Var = this.a;
            u4Var.f().b();
            u4Var.E = z2;
            d4 d4VarL = l();
            Objects.requireNonNull(d4VarL);
            if (b.i.a.f.h.l.t8.b() && d4VarL.a.h.o(p.H0)) {
                d4VarL.b();
                if (d4VarL.w().contains("measurement_enabled_from_api")) {
                    boolValueOf = Boolean.valueOf(d4VarL.w().getBoolean("measurement_enabled_from_api", true));
                } else {
                    boolValueOf = null;
                }
            } else {
                boolValueOf = null;
            }
            if (!z2 || boolValueOf == null || boolValueOf.booleanValue()) {
                D(Boolean.valueOf(z2), false);
            }
        }
    }
}
