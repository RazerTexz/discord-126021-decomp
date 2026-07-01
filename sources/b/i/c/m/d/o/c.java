package b.i.c.m.d.o;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements FilenameFilter {
    public static final c a = new c();

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        Charset charset = g.a;
        return str.startsWith("event") && !str.endsWith("_");
    }
}
