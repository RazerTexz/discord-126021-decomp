package b.i.c.m.d.k;

import b.i.c.m.d.p.b$a;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$i implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return ((b$a) b.i.c.m.d.p.b.j).accept(file, str) || str.contains("SessionMissingBinaryImages");
    }
}
