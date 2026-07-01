package b.o.a.n;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$i implements Thread$UncaughtExceptionHandler {
    public i$i(i$c i_c) {
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        i.j.a(2, "EXCEPTION:", "In the NoOpExceptionHandler, probably while destroying.", "Thread:", thread, "Error:", th);
    }
}
