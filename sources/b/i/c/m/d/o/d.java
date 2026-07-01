package b.i.c.m.d.o;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* JADX INFO: compiled from: CrashlyticsReportPersistence.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Comparator {
    public static final d j = new d();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        Charset charset = g.a;
        String name = ((File) obj).getName();
        int i = g.f1738b;
        return name.substring(0, i).compareTo(((File) obj2).getName().substring(0, i));
    }
}
