package p007b.p225i.p361c.p369m.p370d.p373k;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.k.s */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC4653s implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4663x f12386j;

    public RunnableC4653s(C4663x c4663x) {
        this.f12386j = c4663x;
    }

    @Override // java.lang.Runnable
    public void run() {
        C4663x c4663x = this.f12386j;
        File[] fileArrM6467r = C4663x.m6467r(c4663x.m6476l(), new C4663x.i());
        Objects.requireNonNull(c4663x);
        HashSet hashSet = new HashSet();
        for (File file : fileArrM6467r) {
            C4592b.f12227a.m6371b("Found invalid session part file: " + file);
            hashSet.add(C4663x.m6466o(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (File file2 : C4663x.m6467r(c4663x.m6476l(), new C4655t(c4663x, hashSet))) {
            C4592b.f12227a.m6371b("Deleting invalid session file: " + file2);
            file2.delete();
        }
    }
}
