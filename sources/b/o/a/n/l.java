package b.o.a.n;

import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class l implements Callable<Task<b.o.a.c>> {
    public final /* synthetic */ i j;

    public l(i iVar) {
        this.j = iVar;
    }

    @Override // java.util.concurrent.Callable
    public Task<b.o.a.c> call() throws Exception {
        i iVar = this.j;
        if (iVar.c(iVar.l())) {
            return this.j.Q();
        }
        i.j.a(3, "onStartEngine:", "No camera available for facing", this.j.l());
        throw new CameraException(6);
    }
}
