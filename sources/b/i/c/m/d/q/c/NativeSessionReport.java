package b.i.c.m.d.q.c;

import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import java.io.File;
import java.util.Map;

/* JADX INFO: renamed from: b.i.c.m.d.q.c.b, reason: use source file name */
/* JADX INFO: compiled from: NativeSessionReport.java */
/* JADX INFO: loaded from: classes3.dex */
public class NativeSessionReport implements Report2 {
    public final File a;

    public NativeSessionReport(File file) {
        this.a = file;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public String a() {
        return this.a.getName();
    }

    @Override // b.i.c.m.d.q.c.Report2
    public Map<String, String> b() {
        return null;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public File c() {
        return null;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public int d() {
        return 2;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public File[] e() {
        return this.a.listFiles();
    }

    @Override // b.i.c.m.d.q.c.Report2
    public String f() {
        return null;
    }

    @Override // b.i.c.m.d.q.c.Report2
    public void remove() {
        for (File file : e()) {
            Logger3 logger3 = Logger3.a;
            StringBuilder sbU = outline.U("Removing native report file at ");
            sbU.append(file.getPath());
            logger3.b(sbU.toString());
            file.delete();
        }
        Logger3 logger4 = Logger3.a;
        StringBuilder sbU2 = outline.U("Removing native report directory at ");
        sbU2.append(this.a);
        logger4.b(sbU2.toString());
        this.a.delete();
    }
}
