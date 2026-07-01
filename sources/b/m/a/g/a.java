package b.m.a.g;

import android.os.SystemClock;

/* JADX INFO: compiled from: AndroidSystemClock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements b.m.a.b {
    @Override // b.m.a.b
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // b.m.a.b
    public long b() {
        return SystemClock.elapsedRealtime();
    }
}
