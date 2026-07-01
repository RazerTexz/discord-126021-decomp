package b.i.a.c.f3;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.f3.a0, reason: use source file name */
/* JADX INFO: compiled from: SystemClock.java */
/* JADX INFO: loaded from: classes3.dex */
public class SystemClock2 implements Clock4 {
    @Override // b.i.a.c.f3.Clock4
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // b.i.a.c.f3.Clock4
    public HandlerWrapper b(Looper looper, @Nullable Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    @Override // b.i.a.c.f3.Clock4
    public void c() {
    }

    @Override // b.i.a.c.f3.Clock4
    public long d() {
        return SystemClock.elapsedRealtime();
    }
}
