package b.i.c.m.d.k;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$h implements FilenameFilter {
    public final String a;

    public x$h(String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.contains(this.a) && !str.endsWith(".cls_temp");
    }
}
