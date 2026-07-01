package b.i.c.m.d.q.c;

import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: NativeSessionReport.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements c {
    public final File a;

    public b(File file) {
        this.a = file;
    }

    @Override // b.i.c.m.d.q.c.c
    public String a() {
        return this.a.getName();
    }

    @Override // b.i.c.m.d.q.c.c
    public Map<String, String> b() {
        return null;
    }

    @Override // b.i.c.m.d.q.c.c
    public File c() {
        return null;
    }

    @Override // b.i.c.m.d.q.c.c
    public int d() {
        return 2;
    }

    @Override // b.i.c.m.d.q.c.c
    public File[] e() {
        return this.a.listFiles();
    }

    @Override // b.i.c.m.d.q.c.c
    public String f() {
        return null;
    }

    @Override // b.i.c.m.d.q.c.c
    public void remove() {
        for (File file : e()) {
            b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
            StringBuilder sbU = b.d.b.a.a.U("Removing native report file at ");
            sbU.append(file.getPath());
            bVar.b(sbU.toString());
            file.delete();
        }
        b.i.c.m.d.b bVar2 = b.i.c.m.d.b.a;
        StringBuilder sbU2 = b.d.b.a.a.U("Removing native report directory at ");
        sbU2.append(this.a);
        bVar2.b(sbU2.toString());
        this.a.delete();
    }
}
