package b.i.c.m.d.q.c;

import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.i.c.m.d.q.c.d, reason: use source file name */
/* JADX INFO: compiled from: SessionReport.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionReport implements Report2 {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File[] f1743b;
    public final Map<String, String> c;

    public SessionReport(File file, Map<String, String> map) {
        this.a = file;
        this.f1743b = new File[]{file};
        this.c = new HashMap(map);
    }

    @Override // b.i.c.m.d.q.c.Report2
    public String a() {
        String strF = f();
        return strF.substring(0, strF.lastIndexOf(46));
    }

    @Override // b.i.c.m.d.q.c.Report2
    public Map<String, String> b() {
        return Collections.unmodifiableMap(this.c);
    }

    @Override // b.i.c.m.d.q.c.Report2
    public File c() {
        return this.a;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public int d() {
        return 1;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public File[] e() {
        return this.f1743b;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public String f() {
        return this.a.getName();
    }

    @Override // b.i.c.m.d.q.c.Report2
    public void remove() {
        Logger3 logger3 = Logger3.a;
        StringBuilder sbU = outline.U("Removing report at ");
        sbU.append(this.a.getPath());
        logger3.b(sbU.toString());
        this.a.delete();
    }
}
