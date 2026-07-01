package b.i.a.b.j.v;

import android.os.SystemClock;

/* JADX INFO: renamed from: b.i.a.b.j.v.d, reason: use source file name */
/* JADX INFO: compiled from: UptimeClock.java */
/* JADX INFO: loaded from: classes3.dex */
public class UptimeClock implements Clock3 {
    @Override // b.i.a.b.j.v.Clock3
    public long a() {
        return SystemClock.elapsedRealtime();
    }
}
