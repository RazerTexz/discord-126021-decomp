package b.i.c.m.d.p;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: compiled from: ClsFileOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return str.endsWith(".cls_temp");
    }
}
