package b.i.a.f.i.b;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends z1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Long> f1512b;
    public final Map<String, Integer> c;
    public long d;

    public a(u4 u4Var) {
        super(u4Var);
        this.c = new ArrayMap();
        this.f1512b = new ArrayMap();
    }

    @WorkerThread
    public final void t(long j) {
        i7 i7VarW = q().w(false);
        for (String str : this.f1512b.keySet()) {
            w(str, j - this.f1512b.get(str).longValue(), i7VarW);
        }
        if (!this.f1512b.isEmpty()) {
            u(j - this.d, i7VarW);
        }
        x(j);
    }

    @WorkerThread
    public final void u(long j, i7 i7Var) {
        if (i7Var == null) {
            g().n.a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            g().n.b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        h7.A(i7Var, bundle, true);
        n().H("am", "_xa", bundle);
    }

    public final void v(String str, long j) {
        if (str == null || str.length() == 0) {
            g().f.a("Ad unit id must be a non-empty string");
        } else {
            f().v(new y0(this, str, j));
        }
    }

    @WorkerThread
    public final void w(String str, long j, i7 i7Var) {
        if (i7Var == null) {
            g().n.a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            g().n.b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        h7.A(i7Var, bundle, true);
        n().H("am", "_xu", bundle);
    }

    @WorkerThread
    public final void x(long j) {
        Iterator<String> it = this.f1512b.keySet().iterator();
        while (it.hasNext()) {
            this.f1512b.put(it.next(), Long.valueOf(j));
        }
        if (this.f1512b.isEmpty()) {
            return;
        }
        this.d = j;
    }

    public final void y(String str, long j) {
        if (str == null || str.length() == 0) {
            g().f.a("Ad unit id must be a non-empty string");
        } else {
            f().v(new x(this, str, j));
        }
    }
}
