package b.o.a.n.v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CameraStateOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class g<T> implements b.i.a.f.n.a<T, Task<T>> {
    public final /* synthetic */ f$b a;

    public g(f$b f_b) {
        this.a = f_b;
    }

    @Override // b.i.a.f.n.a
    public Object a(@NonNull Task task) throws Exception {
        if (task.p() || this.a.n) {
            f$b f_b = this.a;
            f_b.o.f = f_b.l;
        }
        return task;
    }
}
