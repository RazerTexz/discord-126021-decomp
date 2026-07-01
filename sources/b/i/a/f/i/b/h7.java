package b.i.a.f.i.b;

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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class h7 extends a5 {
    public volatile i7 c;
    public i7 d;
    public i7 e;
    public final Map<Activity, i7> f;
    public Activity g;
    public volatile boolean h;
    public volatile i7 i;
    public i7 j;
    public boolean k;
    public final Object l;
    public String m;

    public h7(u4 u4Var) {
        super(u4Var);
        this.l = new Object();
        this.f = new ConcurrentHashMap();
    }

    public static void A(i7 i7Var, Bundle bundle, boolean z2) {
        if (i7Var == null || (bundle.containsKey("_sc") && !z2)) {
            if (i7Var == null && z2) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = i7Var.a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = i7Var.f1537b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", i7Var.c);
    }

    public static String x(String str) {
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:67:0x0126  */
    @WorkerThread
    public final void B(i7 i7Var, i7 i7Var2, long j, boolean z2, Bundle bundle) {
        boolean z3;
        i7 i7Var3;
        String str;
        long j2;
        long jB;
        b();
        if (this.a.h.o(p.T)) {
            z3 = z2 && this.e != null;
            if (z3) {
                C(this.e, true, j);
            }
        } else {
            if (z2 && (i7Var3 = this.e) != null) {
                C(i7Var3, true, j);
            }
            z3 = false;
        }
        if ((i7Var2 != null && i7Var2.c == i7Var.c && t9.q0(i7Var2.f1537b, i7Var.f1537b) && t9.q0(i7Var2.a, i7Var.a)) ? false : true) {
            Bundle bundle2 = new Bundle();
            if (this.a.h.o(p.v0)) {
                bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            }
            Bundle bundle3 = bundle2;
            A(i7Var, bundle3, true);
            if (i7Var2 != null) {
                String str2 = i7Var2.a;
                if (str2 != null) {
                    bundle3.putString("_pn", str2);
                }
                String str3 = i7Var2.f1537b;
                if (str3 != null) {
                    bundle3.putString("_pc", str3);
                }
                bundle3.putLong("_pi", i7Var2.c);
            }
            if (this.a.h.o(p.T) && z3) {
                if (((b.i.a.f.h.l.v9) b.i.a.f.h.l.s9.j.a()).a() && this.a.h.o(p.V)) {
                    d9 d9Var = s().e;
                    jB = j - d9Var.f1528b;
                    d9Var.f1528b = j;
                } else {
                    jB = s().e.b();
                }
                if (jB > 0) {
                    e().G(bundle3, jB);
                }
            }
            if (this.a.h.o(p.v0)) {
                if (!this.a.h.z().booleanValue()) {
                    bundle3.putLong("_mst", 1L);
                }
                if (i7Var.e) {
                    str = "app";
                } else {
                    str = "auto";
                }
            } else {
                str = "auto";
            }
            String str4 = str;
            if (this.a.h.o(p.v0)) {
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (i7Var.e) {
                    long j3 = i7Var.f;
                    if (j3 != 0) {
                        j2 = j3;
                    } else {
                        j2 = jCurrentTimeMillis;
                    }
                } else {
                    j2 = jCurrentTimeMillis;
                }
                n().E(str4, "_vs", j2, bundle3);
            } else {
                c6 c6VarN = n();
                c6VarN.b();
                Objects.requireNonNull((b.i.a.f.e.o.c) c6VarN.a.o);
                c6VarN.E(str4, "_vs", System.currentTimeMillis(), bundle3);
            }
        }
        this.e = i7Var;
        if (this.a.h.o(p.v0) && i7Var.e) {
            this.j = i7Var;
        }
        q7 q7VarP = p();
        q7VarP.b();
        q7VarP.t();
        q7VarP.z(new w7(q7VarP, i7Var));
    }

    @WorkerThread
    public final void C(i7 i7Var, boolean z2, long j) {
        a aVarM = m();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        aVarM.t(SystemClock.elapsedRealtime());
        if (!s().w(i7Var != null && i7Var.d, z2, j) || i7Var == null) {
            return;
        }
        i7Var.d = false;
    }

    @WorkerThread
    public final void D(String str, i7 i7Var) {
        b();
        synchronized (this) {
            String str2 = this.m;
            if (str2 == null || str2.equals(str)) {
                this.m = str;
            }
        }
    }

    @MainThread
    public final i7 E(@NonNull Activity activity) {
        Objects.requireNonNull(activity, "null reference");
        i7 i7Var = this.f.get(activity);
        if (i7Var == null) {
            i7 i7Var2 = new i7(null, x(activity.getClass().getCanonicalName()), e().t0());
            this.f.put(activity, i7Var2);
            i7Var = i7Var2;
        }
        return (this.a.h.o(p.v0) && this.i != null) ? this.i : i7Var;
    }

    @Override // b.i.a.f.i.b.a5
    public final boolean v() {
        return false;
    }

    @WorkerThread
    public final i7 w(boolean z2) {
        t();
        b();
        if (!this.a.h.o(p.v0) || !z2) {
            return this.e;
        }
        i7 i7Var = this.e;
        return i7Var != null ? i7Var : this.j;
    }

    @MainThread
    public final void y(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.a.h.z().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f.put(activity, new i7(bundle2.getString(ModelAuditLogEntry.CHANGE_KEY_NAME), bundle2.getString("referrer_name"), bundle2.getLong(ModelAuditLogEntry.CHANGE_KEY_ID)));
    }

    @MainThread
    public final void z(Activity activity, i7 i7Var, boolean z2) {
        i7 i7Var2;
        i7 i7Var3 = this.c == null ? this.d : this.c;
        if (i7Var.f1537b == null) {
            i7Var2 = new i7(i7Var.a, activity != null ? x(activity.getClass().getCanonicalName()) : null, i7Var.c, i7Var.e, i7Var.f);
        } else {
            i7Var2 = i7Var;
        }
        this.d = this.c;
        this.c = i7Var2;
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        f().v(new j7(this, i7Var2, i7Var3, SystemClock.elapsedRealtime(), z2));
    }
}
