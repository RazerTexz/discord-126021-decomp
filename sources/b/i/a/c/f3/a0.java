package b.i.a.c.f3;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SystemClock.java */
/* JADX INFO: loaded from: classes3.dex */
public class a0 implements g {
    @Override // b.i.a.c.f3.g
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // b.i.a.c.f3.g
    public o b(Looper looper, @Nullable Handler$Callback handler$Callback) {
        return new b0(new Handler(looper, handler$Callback));
    }

    @Override // b.i.a.c.f3.g
    public void c() {
    }

    @Override // b.i.a.c.f3.g
    public long d() {
        return SystemClock.elapsedRealtime();
    }
}
