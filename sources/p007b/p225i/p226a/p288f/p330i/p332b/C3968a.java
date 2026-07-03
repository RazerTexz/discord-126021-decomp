package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.f.i.b.a */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3968a extends C4254z1 {

    /* JADX INFO: renamed from: b */
    public final Map<String, Long> f10501b;

    /* JADX INFO: renamed from: c */
    public final Map<String, Integer> f10502c;

    /* JADX INFO: renamed from: d */
    public long f10503d;

    public C3968a(C4202u4 c4202u4) {
        super(c4202u4);
        this.f10502c = new ArrayMap();
        this.f10501b = new ArrayMap();
    }

    @WorkerThread
    /* JADX INFO: renamed from: t */
    public final void m5440t(long j) {
        C4072i7 c4072i7M5656w = m5972q().m5656w(false);
        for (String str : this.f10501b.keySet()) {
            m5443w(str, j - this.f10501b.get(str).longValue(), c4072i7M5656w);
        }
        if (!this.f10501b.isEmpty()) {
            m5441u(j - this.f10503d, c4072i7M5656w);
        }
        m5444x(j);
    }

    @WorkerThread
    /* JADX INFO: renamed from: u */
    public final void m5441u(long j, C4072i7 c4072i7) {
        if (c4072i7 == null) {
            mo5726g().f11149n.m5860a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo5726g().f11149n.m5861b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        C4060h7.m5650A(c4072i7, bundle, true);
        m5969n().m5545H("am", "_xa", bundle);
    }

    /* JADX INFO: renamed from: v */
    public final void m5442v(String str, long j) {
        if (str == null || str.length() == 0) {
            mo5726g().f11141f.m5860a("Ad unit id must be a non-empty string");
        } else {
            mo5725f().m5852v(new RunnableC4242y0(this, str, j));
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: w */
    public final void m5443w(String str, long j, C4072i7 c4072i7) {
        if (c4072i7 == null) {
            mo5726g().f11149n.m5860a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo5726g().f11149n.m5861b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        C4060h7.m5650A(c4072i7, bundle, true);
        m5969n().m5545H("am", "_xu", bundle);
    }

    @WorkerThread
    /* JADX INFO: renamed from: x */
    public final void m5444x(long j) {
        Iterator<String> it = this.f10501b.keySet().iterator();
        while (it.hasNext()) {
            this.f10501b.put(it.next(), Long.valueOf(j));
        }
        if (this.f10501b.isEmpty()) {
            return;
        }
        this.f10503d = j;
    }

    /* JADX INFO: renamed from: y */
    public final void m5445y(String str, long j) {
        if (str == null || str.length() == 0) {
            mo5726g().f11141f.m5860a("Ad unit id must be a non-empty string");
        } else {
            mo5725f().m5852v(new RunnableC4230x(this, str, j));
        }
    }
}
