package b.o.a.n.v;

import b.o.a.n.i$c;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Runnable {
    public final /* synthetic */ a$c j;
    public final /* synthetic */ b.o.a.r.g k;
    public final /* synthetic */ a l;

    public c(a aVar, a$c a_c, b.o.a.r.g gVar) {
        this.l = aVar;
        this.j = a_c;
        this.k = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.a.a(1, this.j.a.toUpperCase(), "- Executing.");
            Task task = (Task) this.j.c.call();
            b.o.a.r.g gVar = this.k;
            c$a c_a = new c$a(this);
            if (task.o()) {
                gVar.c(new d(c_a, task));
            } else {
                task.c(gVar.g, c_a);
            }
        } catch (Exception e) {
            a.a.a(1, this.j.a.toUpperCase(), "- Finished with ERROR.", e);
            if (this.j.d) {
                b.o.a.n.i.b(((i$c) this.l.f1941b).a, e, false);
            }
            this.j.f1942b.a(e);
            synchronized (this.l.e) {
                a.a(this.l, this.j);
            }
        }
    }
}
