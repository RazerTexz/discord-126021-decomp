package b.i.c.m.d.k;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: compiled from: CommonUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class h$a implements Comparator<File> {
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return (int) (file.lastModified() - file2.lastModified());
    }
}
