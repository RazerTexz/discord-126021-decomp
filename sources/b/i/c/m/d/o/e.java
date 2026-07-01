package b.i.c.m.d.o;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Comparator {
    public static final e j = new e();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Charset charset = g.a;
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
