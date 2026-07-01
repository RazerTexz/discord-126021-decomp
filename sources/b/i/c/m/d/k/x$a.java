package b.i.c.m.d.k;

import java.io.File;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$a extends x$h {
    public x$a(String str) {
        super(str);
    }

    @Override // b.i.c.m.d.k.x$h, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return super.accept(file, str) && str.endsWith(".cls");
    }
}
