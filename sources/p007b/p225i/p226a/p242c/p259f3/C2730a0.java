package p007b.p225i.p226a.p242c.p259f3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.f3.a0 */
/* JADX INFO: compiled from: SystemClock.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2730a0 implements InterfaceC2740g {
    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g
    /* JADX INFO: renamed from: a */
    public long mo2949a() {
        return SystemClock.uptimeMillis();
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g
    /* JADX INFO: renamed from: b */
    public InterfaceC2748o mo2950b(Looper looper, @Nullable Handler.Callback callback) {
        return new C2732b0(new Handler(looper, callback));
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g
    /* JADX INFO: renamed from: c */
    public void mo2951c() {
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g
    /* JADX INFO: renamed from: d */
    public long mo2952d() {
        return SystemClock.elapsedRealtime();
    }
}
