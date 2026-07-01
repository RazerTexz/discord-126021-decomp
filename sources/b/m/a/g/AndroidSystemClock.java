package b.m.a.g;

import android.os.SystemClock;
import b.m.a.Clock5;

/* JADX INFO: renamed from: b.m.a.g.a, reason: use source file name */
/* JADX INFO: compiled from: AndroidSystemClock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSystemClock implements Clock5 {
    @Override // b.m.a.Clock5
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // b.m.a.Clock5
    public long b() {
        return SystemClock.elapsedRealtime();
    }
}
