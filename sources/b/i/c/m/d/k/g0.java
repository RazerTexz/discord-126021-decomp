package b.i.c.m.d.k;

import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.x;
import b.i.c.m.d.q.ReportManager;
import b.i.c.m.d.q.c.NativeSessionReport;
import b.i.c.m.d.q.c.Report2;
import b.i.c.m.d.q.c.SessionReport;
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
    public final /* synthetic */ x.e k;

    public g0(x.e eVar, Boolean bool) {
        this.k = eVar;
        this.j = bool;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        ReportManager reportManager = x.this.u;
        Objects.requireNonNull(reportManager);
        Logger3.a.b("Checking for crash reports...");
        File[] fileArrQ = x.this.q();
        File[] fileArrListFiles = x.this.m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrQ != null) {
            for (File file : fileArrQ) {
                Logger3 logger3 = Logger3.a;
                StringBuilder sbU = outline.U("Found crash report ");
                sbU.append(file.getPath());
                logger3.b(sbU.toString());
                linkedList.add(new SessionReport(file, Collections.emptyMap()));
            }
        }
        for (File file2 : fileArrListFiles) {
            linkedList.add(new NativeSessionReport(file2));
        }
        if (linkedList.isEmpty()) {
            Logger3.a.b("No reports found.");
        }
        if (this.j.booleanValue()) {
            Logger3.a.b("Reports are being sent.");
            boolean zBooleanValue = this.j.booleanValue();
            DataCollectionArbiter dataCollectionArbiter = x.this.j;
            Objects.requireNonNull(dataCollectionArbiter);
            if (!zBooleanValue) {
                throw new IllegalStateException("An invalid data collection token was used.");
            }
            dataCollectionArbiter.h.b(null);
            x.e eVar = this.k;
            Executor executor = x.this.m.a;
            return eVar.a.r(executor, new f0(this, linkedList, zBooleanValue, executor));
        }
        Logger3.a.b("Reports are being deleted.");
        for (File file3 : x.r(x.this.l(), m.a)) {
            file3.delete();
        }
        Objects.requireNonNull(x.this.u);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Report2) it.next()).remove();
        }
        x.this.A.f1680b.b();
        x.this.E.b(null);
        return b.i.a.f.e.o.f.Z(null);
    }
}
