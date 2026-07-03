package p007b.p225i.p361c.p369m.p370d.p373k;

import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p380q.C4720a;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4723b;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.C4725d;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c;

/* JADX INFO: renamed from: b.i.c.m.d.k.g0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class CallableC4626g0 implements Callable<Task<Void>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Boolean f12294j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4663x.e f12295k;

    public CallableC4626g0(C4663x.e eVar, Boolean bool) {
        this.f12295k = eVar;
        this.f12294j = bool;
    }

    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        C4720a c4720a = C4663x.this.f12441u;
        Objects.requireNonNull(c4720a);
        C4592b.f12227a.m6371b("Checking for crash reports...");
        File[] fileArrM6480q = C4663x.this.m6480q();
        File[] fileArrListFiles = C4663x.this.m6477m().listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        LinkedList linkedList = new LinkedList();
        if (fileArrM6480q != null) {
            for (File file : fileArrM6480q) {
                C4592b c4592b = C4592b.f12227a;
                StringBuilder sbM833U = C1643a.m833U("Found crash report ");
                sbM833U.append(file.getPath());
                c4592b.m6371b(sbM833U.toString());
                linkedList.add(new C4725d(file, Collections.emptyMap()));
            }
        }
        for (File file2 : fileArrListFiles) {
            linkedList.add(new C4723b(file2));
        }
        if (linkedList.isEmpty()) {
            C4592b.f12227a.m6371b("No reports found.");
        }
        if (this.f12294j.booleanValue()) {
            C4592b.f12227a.m6371b("Reports are being sent.");
            boolean zBooleanValue = this.f12294j.booleanValue();
            C4650q0 c4650q0 = C4663x.this.f12430j;
            Objects.requireNonNull(c4650q0);
            if (!zBooleanValue) {
                throw new IllegalStateException("An invalid data collection token was used.");
            }
            c4650q0.f12378h.m9126b(null);
            C4663x.e eVar = this.f12295k;
            Executor executor = C4663x.this.f12433m.f12315a;
            return eVar.f12447a.mo6023r(executor, new C4623f0(this, linkedList, zBooleanValue, executor));
        }
        C4592b.f12227a.m6371b("Reports are being deleted.");
        for (File file3 : C4663x.m6467r(C4663x.this.m6476l(), C4641m.f12347a)) {
            file3.delete();
        }
        Objects.requireNonNull(C4663x.this.f12441u);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((InterfaceC4724c) it.next()).remove();
        }
        C4663x.this.f12422A.f12279b.m6632b();
        C4663x.this.f12426E.m9126b(null);
        return C3404f.m4264Z(null);
    }
}
