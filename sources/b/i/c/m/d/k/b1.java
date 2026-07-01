package b.i.c.m.d.k;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.Objects;

/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b1 implements b.i.a.f.n.a {
    public final d1 a;

    public b1(d1 d1Var) {
        this.a = d1Var;
    }

    @Override // b.i.a.f.n.a
    public Object a(Task task) {
        boolean z2;
        d1 d1Var = this.a;
        Objects.requireNonNull(d1Var);
        if (task.p()) {
            o0 o0Var = (o0) task.l();
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Crashlytics report successfully enqueued to DataTransport: ");
            sbU.append(o0Var.b());
            bVar.b(sbU.toString());
            d1Var.f1680b.c(o0Var.b());
            z2 = true;
        } else {
            b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
            Exception excK = task.k();
            if (bVar2.a(3)) {
                Log.d("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", excK);
            }
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
