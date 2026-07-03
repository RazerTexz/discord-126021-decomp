package p007b.p445m.p446a.p447g;

import android.os.SystemClock;
import p007b.p445m.p446a.InterfaceC5083b;

/* JADX INFO: renamed from: b.m.a.g.a */
/* JADX INFO: compiled from: AndroidSystemClock.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5088a implements InterfaceC5083b {
    @Override // p007b.p445m.p446a.InterfaceC5083b
    /* JADX INFO: renamed from: a */
    public long mo7128a() {
        return System.currentTimeMillis();
    }

    @Override // p007b.p445m.p446a.InterfaceC5083b
    /* JADX INFO: renamed from: b */
    public long mo7129b() {
        return SystemClock.elapsedRealtime();
    }
}
