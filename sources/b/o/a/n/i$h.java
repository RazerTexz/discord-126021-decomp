package b.o.a.n;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$h implements Thread$UncaughtExceptionHandler {
    public final /* synthetic */ i a;

    public i$h(i iVar, i$c i_c) {
        this.a = iVar;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th) {
        i.b(this.a, th, true);
    }
}
