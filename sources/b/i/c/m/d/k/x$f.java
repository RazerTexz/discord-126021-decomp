package b.i.c.m.d.k;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$f implements FilenameFilter {
    public x$f(x$a x_a) {
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return !((x$b) x.f1699b).accept(file, str) && x.e.matcher(str).matches();
    }
}
