package b.i.c.m.d.o;

import java.io.File;
import java.io.FileFilter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements FileFilter {
    public final String a;

    public b(String str) {
        this.a = str;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        String str = this.a;
        Charset charset = g.a;
        return file.isDirectory() && !file.getName().equals(str);
    }
}
