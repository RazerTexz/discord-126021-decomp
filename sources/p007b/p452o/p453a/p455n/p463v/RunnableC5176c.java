package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CancellationException;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;
import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p467r.C5206g;

/* JADX INFO: renamed from: b.o.a.n.v.c */
/* JADX INFO: compiled from: CameraOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5176c implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C5174a.c f14017j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C5206g f14018k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C5174a f14019l;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: b.o.a.n.v.c$a */
    /* JADX INFO: compiled from: CameraOrchestrator.java */
    public class a<T> implements InterfaceC4357c<T> {
        public a() {
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
        public void onComplete(@NonNull Task<T> task) {
            Exception excMo6016k = task.mo6016k();
            if (excMo6016k != null) {
                C5174a.f14005a.m7159a(2, RunnableC5176c.this.f14017j.f14011a.toUpperCase(), "- Finished with ERROR.", excMo6016k);
                RunnableC5176c runnableC5176c = RunnableC5176c.this;
                if (runnableC5176c.f14017j.f14014d) {
                    AbstractC5135i.m7317b(AbstractC5135i.this, excMo6016k, false);
                }
                RunnableC5176c.this.f14017j.f14012b.m9125a(excMo6016k);
            } else if (task.mo6019n()) {
                C5174a.f14005a.m7159a(1, RunnableC5176c.this.f14017j.f14011a.toUpperCase(), "- Finished because ABORTED.");
                RunnableC5176c.this.f14017j.f14012b.m9125a(new CancellationException());
            } else {
                C5174a.f14005a.m7159a(1, RunnableC5176c.this.f14017j.f14011a.toUpperCase(), "- Finished.");
                RunnableC5176c.this.f14017j.f14012b.m9126b(task.mo6017l());
            }
            synchronized (RunnableC5176c.this.f14019l.f14009e) {
                RunnableC5176c runnableC5176c2 = RunnableC5176c.this;
                C5174a.m7362a(runnableC5176c2.f14019l, runnableC5176c2.f14017j);
            }
        }
    }

    public RunnableC5176c(C5174a c5174a, C5174a.c cVar, C5206g c5206g) {
        this.f14019l = c5174a;
        this.f14017j = cVar;
        this.f14018k = c5206g;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            C5174a.f14005a.m7159a(1, this.f14017j.f14011a.toUpperCase(), "- Executing.");
            Task task = (Task) this.f14017j.f14013c.call();
            C5206g c5206g = this.f14018k;
            a aVar = new a();
            if (task.mo6020o()) {
                c5206g.m7404c(new RunnableC5177d(aVar, task));
            } else {
                task.mo6008c(c5206g.f14133g, aVar);
            }
        } catch (Exception e) {
            C5174a.f14005a.m7159a(1, this.f14017j.f14011a.toUpperCase(), "- Finished with ERROR.", e);
            if (this.f14017j.f14014d) {
                AbstractC5135i.m7317b(AbstractC5135i.this, e, false);
            }
            this.f14017j.f14012b.m9125a(e);
            synchronized (this.f14019l.f14009e) {
                C5174a.m7362a(this.f14019l, this.f14017j);
            }
        }
    }
}
