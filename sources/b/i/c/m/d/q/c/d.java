package b.i.c.m.d.q.c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SessionReport.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements c {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File[] f1743b;
    public final Map<String, String> c;

    public d(File file, Map<String, String> map) {
        this.a = file;
        this.f1743b = new File[]{file};
        this.c = new HashMap(map);
    }

    @Override // b.i.c.m.d.q.c.c
    public String a() {
        String strF = f();
        return strF.substring(0, strF.lastIndexOf(46));
    }

    @Override // b.i.c.m.d.q.c.c
    public Map<String, String> b() {
        return Collections.unmodifiableMap(this.c);
    }

    @Override // b.i.c.m.d.q.c.c
    public File c() {
        return this.a;
    }

    @Override // b.i.c.m.d.q.c.c
    public int d() {
        return 1;
    }

    @Override // b.i.c.m.d.q.c.c
    public File[] e() {
        return this.f1743b;
    }

    @Override // b.i.c.m.d.q.c.c
    public String f() {
        return this.a.getName();
    }

    @Override // b.i.c.m.d.q.c.c
    public void remove() {
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U("Removing report at ");
        sbU.append(this.a.getPath());
        bVar.b(sbU.toString());
        this.a.delete();
    }
}
