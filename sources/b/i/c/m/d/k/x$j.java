package b.i.c.m.d.k;

import b.i.c.m.d.l.b$b;
import java.io.File;

/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x$j implements b$b {
    public final b.i.c.m.d.o.h a;

    public x$j(b.i.c.m.d.o.h hVar) {
        this.a = hVar;
    }

    public File a() {
        File file = new File(this.a.a(), "log-files");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
