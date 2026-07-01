package b.o.a.n.v;

import androidx.annotation.NonNull;
import b.o.a.n.i$c;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a<T> implements b.i.a.f.n.c<T> {
    public final /* synthetic */ c a;

    public c$a(c cVar) {
        this.a = cVar;
    }

    @Override // b.i.a.f.n.c
    public void onComplete(@NonNull Task<T> task) {
        Exception excK = task.k();
        if (excK != null) {
            a.a.a(2, this.a.j.a.toUpperCase(), "- Finished with ERROR.", excK);
            c cVar = this.a;
            if (cVar.j.d) {
                b.o.a.n.i.b(((i$c) cVar.l.f1941b).a, excK, false);
            }
            this.a.j.f1942b.a(excK);
        } else if (task.n()) {
            a.a.a(1, this.a.j.a.toUpperCase(), "- Finished because ABORTED.");
            this.a.j.f1942b.a(new CancellationException());
        } else {
            a.a.a(1, this.a.j.a.toUpperCase(), "- Finished.");
            this.a.j.f1942b.b(task.l());
        }
        synchronized (this.a.l.e) {
            c cVar2 = this.a;
            a.a(cVar2.l, cVar2.j);
        }
    }
}
