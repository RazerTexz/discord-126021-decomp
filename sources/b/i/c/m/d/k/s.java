package b.i.c.m.d.k;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class s implements Runnable {
    public final /* synthetic */ x j;

    public s(x xVar) {
        this.j = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x xVar = this.j;
        File[] fileArrR = x.r(xVar.l(), new x$i());
        Objects.requireNonNull(xVar);
        HashSet hashSet = new HashSet();
        for (File file : fileArrR) {
            b.i.c.m.d.b.a.b("Found invalid session part file: " + file);
            hashSet.add(x.o(file));
        }
        if (hashSet.isEmpty()) {
            return;
        }
        for (File file2 : x.r(xVar.l(), new t(xVar, hashSet))) {
            b.i.c.m.d.b.a.b("Deleting invalid session file: " + file2);
            file2.delete();
        }
    }
}
