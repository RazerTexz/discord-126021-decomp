package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class g0 implements Callable<Task<Void>> {
    public final /* synthetic */ Boolean j;
    public final /* synthetic */ x$e k;

    public g0(x$e x_e, Boolean bool) {
        this.k = x_e;
        this.j = bool;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        b.i.c.m.d.q.a aVar = this.k.c.u;
        Objects.requireNonNull(aVar);
        b.i.c.m.d.b.a.b("Checking for crash reports...");
        File[] fileArrQ = ((x$k) aVar.a).a.q();
        File[] fileArrListFiles = ((x$k) aVar.a).a.m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrQ != null) {
            for (File file : fileArrQ) {
                b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
                StringBuilder sbU = b.d.b.a.a.U("Found crash report ");
                sbU.append(file.getPath());
                bVar.b(sbU.toString());
                linkedList.add(new b.i.c.m.d.q.c.d(file, Collections.emptyMap()));
            }
        }
        for (File file2 : fileArrListFiles) {
            linkedList.add(new b.i.c.m.d.q.c.b(file2));
        }
        if (linkedList.isEmpty()) {
            b.i.c.m.d.b.a.b("No reports found.");
        }
        if (this.j.booleanValue()) {
            b.i.c.m.d.b.a.b("Reports are being sent.");
            boolean zBooleanValue = this.j.booleanValue();
            q0 q0Var = this.k.c.j;
            Objects.requireNonNull(q0Var);
            if (!zBooleanValue) {
                throw new IllegalStateException("An invalid data collection token was used.");
            }
            q0Var.h.b(null);
            x$e x_e = this.k;
            Executor executor = x_e.c.m.a;
            return x_e.a.r(executor, new f0(this, linkedList, zBooleanValue, executor));
        }
        b.i.c.m.d.b.a.b("Reports are being deleted.");
        for (File file3 : x.r(this.k.c.l(), m.a)) {
            file3.delete();
        }
        Objects.requireNonNull(this.k.c.u);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((b.i.c.m.d.q.c.c) it.next()).remove();
        }
        this.k.c.A.f1680b.b();
        this.k.c.E.b(null);
        return b.i.a.f.e.o.f.Z(null);
    }
}
