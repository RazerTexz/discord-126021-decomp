package b.i.c.m.d.k;

import java.io.File;
import java.util.Comparator;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class x$c implements Comparator<File> {
    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        return file2.getName().compareTo(file.getName());
    }
}
