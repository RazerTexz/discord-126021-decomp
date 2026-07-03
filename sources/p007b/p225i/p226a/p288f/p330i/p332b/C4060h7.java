package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.C3830s9;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3869v9;

/* JADX INFO: renamed from: b.i.a.f.i.b.h7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4060h7 extends AbstractC3974a5 {

    /* JADX INFO: renamed from: c */
    public volatile C4072i7 f10775c;

    /* JADX INFO: renamed from: d */
    public C4072i7 f10776d;

    /* JADX INFO: renamed from: e */
    public C4072i7 f10777e;

    /* JADX INFO: renamed from: f */
    public final Map<Activity, C4072i7> f10778f;

    /* JADX INFO: renamed from: g */
    public Activity f10779g;

    /* JADX INFO: renamed from: h */
    public volatile boolean f10780h;

    /* JADX INFO: renamed from: i */
    public volatile C4072i7 f10781i;

    /* JADX INFO: renamed from: j */
    public C4072i7 f10782j;

    /* JADX INFO: renamed from: k */
    public boolean f10783k;

    /* JADX INFO: renamed from: l */
    public final Object f10784l;

    /* JADX INFO: renamed from: m */
    public String f10785m;

    public C4060h7(C4202u4 c4202u4) {
        super(c4202u4);
        this.f10784l = new Object();
        this.f10778f = new ConcurrentHashMap();
    }

    /* JADX INFO: renamed from: A */
    public static void m5650A(C4072i7 c4072i7, Bundle bundle, boolean z2) {
        if (c4072i7 == null || (bundle.containsKey("_sc") && !z2)) {
            if (c4072i7 == null && z2) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = c4072i7.f10816a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = c4072i7.f10817b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", c4072i7.f10818c);
    }

    /* JADX INFO: renamed from: x */
    public static String m5651x(String str) {
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:67:0x0126  */
    @WorkerThread
    /* JADX INFO: renamed from: B */
    public final void m5652B(C4072i7 c4072i7, C4072i7 c4072i8, long j, boolean z2, Bundle bundle) {
        boolean z3;
        C4072i7 c4072i9;
        String str;
        long j2;
        long jM5585b;
        mo5848b();
        if (this.f11202a.f11260h.m5526o(C4142p.f11054T)) {
            z3 = z2 && this.f10777e != null;
            if (z3) {
                m5653C(this.f10777e, true, j);
            }
        } else {
            if (z2 && (c4072i9 = this.f10777e) != null) {
                m5653C(c4072i9, true, j);
            }
            z3 = false;
        }
        if ((c4072i8 != null && c4072i8.f10818c == c4072i7.f10818c && C4196t9.m5884q0(c4072i8.f10817b, c4072i7.f10817b) && C4196t9.m5884q0(c4072i8.f10816a, c4072i7.f10816a)) ? false : true) {
            Bundle bundle2 = new Bundle();
            if (this.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            m5650A(c4072i7, bundle3, true);
            if (c4072i8 != null) {
                String str2 = c4072i8.f10816a;
                if (str2 != null) {
                    bundle3.putString("_pn", str2);
                }
                String str3 = c4072i8.f10817b;
                if (str3 != null) {
                    bundle3.putString("_pc", str3);
                }
                bundle3.putLong("_pi", c4072i8.f10818c);
            }
            if (this.f11202a.f11260h.m5526o(C4142p.f11054T) && z3) {
                if (((InterfaceC3869v9) C3830s9.f10317j.mo4555a()).mo5323a() && this.f11202a.f11260h.m5526o(C4142p.f11056V)) {
                    C4014d9 c4014d9 = m5974s().f11330e;
                    jM5585b = j - c4014d9.f10669b;
                    c4014d9.f10669b = j;
                } else {
                    jM5585b = m5974s().f11330e.m5585b();
                }
                if (jM5585b > 0) {
                    m5866e().m5893G(bundle3, jM5585b);
                }
            }
            if (this.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
                if (!this.f11202a.f11260h.m5537z().booleanValue()) {
                    bundle3.putLong("_mst", 1L);
                }
                if (c4072i7.f10820e) {
                    str = "app";
                } else {
                    str = "auto";
                }
            } else {
                str = "auto";
            }
            String str4 = str;
            if (this.f11202a.f11260h.m5526o(C4142p.f11104v0)) {
                Objects.requireNonNull((C3401c) this.f11202a.f11267o);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (c4072i7.f10820e) {
                    long j3 = c4072i7.f10821f;
                    if (j3 != 0) {
                        j2 = j3;
                    } else {
                        j2 = jCurrentTimeMillis;
                    }
                } else {
                    j2 = jCurrentTimeMillis;
                }
                m5969n().m5542E(str4, "_vs", j2, bundle3);
            } else {
                C3999c6 c3999c6M5969n = m5969n();
                c3999c6M5969n.mo5848b();
                Objects.requireNonNull((C3401c) c3999c6M5969n.f11202a.f11267o);
                c3999c6M5969n.m5542E(str4, "_vs", System.currentTimeMillis(), bundle3);
            }
        }
        this.f10777e = c4072i7;
        if (this.f11202a.f11260h.m5526o(C4142p.f11104v0) && c4072i7.f10820e) {
            this.f10782j = c4072i7;
        }
        C4161q7 c4161q7M5971p = m5971p();
        c4161q7M5971p.mo5848b();
        c4161q7M5971p.m5497t();
        c4161q7M5971p.m5814z(new RunnableC4227w7(c4161q7M5971p, c4072i7));
    }

    @WorkerThread
    /* JADX INFO: renamed from: C */
    public final void m5653C(C4072i7 c4072i7, boolean z2, long j) {
        C3968a c3968aM5968m = m5968m();
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        c3968aM5968m.m5440t(SystemClock.elapsedRealtime());
        if (!m5974s().m5959w(c4072i7 != null && c4072i7.f10819d, z2, j) || c4072i7 == null) {
            return;
        }
        c4072i7.f10819d = false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: D */
    public final void m5654D(String str, C4072i7 c4072i7) {
        mo5848b();
        synchronized (this) {
            String str2 = this.f10785m;
            if (str2 == null || str2.equals(str)) {
                this.f10785m = str;
            }
        }
    }

    @MainThread
    /* JADX INFO: renamed from: E */
    public final C4072i7 m5655E(@NonNull Activity activity) {
        Objects.requireNonNull(activity, "null reference");
        C4072i7 c4072i7 = this.f10778f.get(activity);
        if (c4072i7 == null) {
            C4072i7 c4072i8 = new C4072i7(null, m5651x(activity.getClass().getCanonicalName()), m5866e().m5922t0());
            this.f10778f.put(activity, c4072i8);
            c4072i7 = c4072i8;
        }
        return (this.f11202a.f11260h.m5526o(C4142p.f11104v0) && this.f10781i != null) ? this.f10781i : c4072i7;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC3974a5
    /* JADX INFO: renamed from: v */
    public final boolean mo5499v() {
        return false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final C4072i7 m5656w(boolean z2) {
        m5497t();
        mo5848b();
        if (!this.f11202a.f11260h.m5526o(C4142p.f11104v0) || !z2) {
            return this.f10777e;
        }
        C4072i7 c4072i7 = this.f10777e;
        return c4072i7 != null ? c4072i7 : this.f10782j;
    }

    @MainThread
    /* JADX INFO: renamed from: y */
    public final void m5657y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.f11202a.f11260h.m5537z().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f10778f.put(activity, new C4072i7(bundle2.getString(ModelAuditLogEntry.CHANGE_KEY_NAME), bundle2.getString("referrer_name"), bundle2.getLong(ModelAuditLogEntry.CHANGE_KEY_ID)));
    }

    @MainThread
    /* JADX INFO: renamed from: z */
    public final void m5658z(Activity activity, C4072i7 c4072i7, boolean z2) {
        C4072i7 c4072i8;
        C4072i7 c4072i9 = this.f10775c == null ? this.f10776d : this.f10775c;
        if (c4072i7.f10817b == null) {
            c4072i8 = new C4072i7(c4072i7.f10816a, activity != null ? m5651x(activity.getClass().getCanonicalName()) : null, c4072i7.f10818c, c4072i7.f10820e, c4072i7.f10821f);
        } else {
            c4072i8 = c4072i7;
        }
        this.f10776d = this.f10775c;
        this.f10775c = c4072i8;
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        mo5725f().m5852v(new RunnableC4084j7(this, c4072i8, c4072i9, SystemClock.elapsedRealtime(), z2));
    }
}
