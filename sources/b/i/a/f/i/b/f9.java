package b.i.a.f.i.b;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class f9 {
    public final /* synthetic */ w8 a;

    public f9(w8 w8Var) {
        this.a = w8Var;
    }

    @WorkerThread
    public final void a() {
        this.a.b();
        d4 d4VarL = this.a.l();
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.a.o);
        if (d4VarL.u(System.currentTimeMillis())) {
            this.a.l().f1524s.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.a.g().n.a("Detected application was in foreground");
                Objects.requireNonNull((b.i.a.f.e.o.c) this.a.a.o);
                c(System.currentTimeMillis(), false);
            }
        }
    }

    @WorkerThread
    public final void b(long j, boolean z2) {
        this.a.b();
        this.a.x();
        if (this.a.l().u(j)) {
            this.a.l().f1524s.a(true);
        }
        this.a.l().v.b(j);
        if (this.a.l().f1524s.b()) {
            c(j, z2);
        }
    }

    @WorkerThread
    public final void c(long j, boolean z2) {
        this.a.b();
        if (this.a.a.d()) {
            this.a.l().v.b(j);
            Objects.requireNonNull((b.i.a.f.e.o.c) this.a.a.o);
            this.a.g().n.b("Session started, time", Long.valueOf(SystemClock.elapsedRealtime()));
            Long lValueOf = Long.valueOf(j / 1000);
            this.a.n().K("auto", "_sid", lValueOf, j);
            this.a.l().f1524s.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", lValueOf.longValue());
            if (this.a.a.h.o(p.k0) && z2) {
                bundle.putLong("_aib", 1L);
            }
            this.a.n().E("auto", "_s", j, bundle);
            if (b.i.a.f.h.l.a9.b() && this.a.a.h.o(p.p0)) {
                String strA = this.a.l().A.a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", strA);
                this.a.n().E("auto", "_ssr", j, bundle2);
            }
        }
    }
}
