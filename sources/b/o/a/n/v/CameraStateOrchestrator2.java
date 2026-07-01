package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.o.a.n.v.CameraStateOrchestrator;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.o.a.n.v.g, reason: use source file name */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraStateOrchestrator2<T> implements b.i.a.f.n.a<T, Task<T>> {
    public final /* synthetic */ CameraStateOrchestrator.b a;

    public CameraStateOrchestrator2(CameraStateOrchestrator.b bVar) {
        this.a = bVar;
    }

    @Override // b.i.a.f.n.a
    public Object a(@NonNull Task task) throws Exception {
        if (task.p() || this.a.n) {
            CameraStateOrchestrator.b bVar = this.a;
            CameraStateOrchestrator.this.f = bVar.l;
        }
        return task;
    }
}
