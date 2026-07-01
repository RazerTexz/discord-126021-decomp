package b.o.a.n;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: b.o.a.n.n, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraEngine6 implements Callable<Task<Void>> {
    public final /* synthetic */ CameraEngine j;

    public CameraEngine6(CameraEngine cameraEngine) {
        this.j = cameraEngine;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return this.j.T();
    }
}
