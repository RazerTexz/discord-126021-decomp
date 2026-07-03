package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.C3587a9;

/* JADX INFO: renamed from: b.i.a.f.i.b.f9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4038f9 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4228w8 f10732a;

    public C4038f9(C4228w8 c4228w8) {
        this.f10732a = c4228w8;
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public final void m5599a() {
        this.f10732a.mo5848b();
        C4009d4 c4009d4M5867l = this.f10732a.m5867l();
        Objects.requireNonNull((C3401c) this.f10732a.f11202a.f11267o);
        if (c4009d4M5867l.m5577u(System.currentTimeMillis())) {
            this.f10732a.m5867l().f10649s.m5596a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f10732a.mo5726g().f11149n.m5860a("Detected application was in foreground");
                Objects.requireNonNull((C3401c) this.f10732a.f11202a.f11267o);
                m5601c(System.currentTimeMillis(), false);
            }
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: b */
    public final void m5600b(long j, boolean z2) {
        this.f10732a.mo5848b();
        this.f10732a.m5960x();
        if (this.f10732a.m5867l().m5577u(j)) {
            this.f10732a.m5867l().f10649s.m5596a(true);
        }
        this.f10732a.m5867l().f10652v.m5649b(j);
        if (this.f10732a.m5867l().f10649s.m5597b()) {
            m5601c(j, z2);
        }
    }

    @WorkerThread
    /* JADX INFO: renamed from: c */
    public final void m5601c(long j, boolean z2) {
        this.f10732a.mo5848b();
        if (this.f10732a.f11202a.m5940d()) {
            this.f10732a.m5867l().f10652v.m5649b(j);
            Objects.requireNonNull((C3401c) this.f10732a.f11202a.f11267o);
            this.f10732a.mo5726g().f11149n.m5861b("Session started, time", Long.valueOf(SystemClock.elapsedRealtime()));
            Long lValueOf = Long.valueOf(j / 1000);
            this.f10732a.m5969n().m5548K("auto", "_sid", lValueOf, j);
            this.f10732a.m5867l().f10649s.m5596a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            if (this.f10732a.f11202a.f11260h.m5526o(C4142p.f11082k0) && z2) {
                bundle.putLong("_aib", 1L);
            }
            this.f10732a.m5969n().m5542E("auto", "_s", j, bundle);
            if (C3587a9.m4561b() && this.f10732a.f11202a.f11260h.m5526o(C4142p.f11092p0)) {
                String strM5694a = this.f10732a.m5867l().f10630A.m5694a();
                if (TextUtils.isEmpty(strM5694a)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strM5694a);
                this.f10732a.m5969n().m5542E("auto", "_ssr", j, bundle2);
            }
        }
    }
}
