package b.i.c.m.d.k;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$n implements FilenameFilter {
    public final String a;

    public x$n(String str) {
        this.a = str;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(".cls");
        return (str.equals(sb.toString()) || !str.contains(this.a) || str.endsWith(".cls_temp")) ? false : true;
    }
}
