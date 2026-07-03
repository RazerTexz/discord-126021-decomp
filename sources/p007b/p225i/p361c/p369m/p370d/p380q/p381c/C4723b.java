package p007b.p225i.p361c.p369m.p370d.p380q.p381c;

import java.io.File;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.q.c.b */
/* JADX INFO: compiled from: NativeSessionReport.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4723b implements InterfaceC4724c {

    /* JADX INFO: renamed from: a */
    public final File f12712a;

    public C4723b(File file) {
        this.f12712a = file;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: a */
    public String mo6672a() {
        return this.f12712a.getName();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: b */
    public Map<String, String> mo6673b() {
        return null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: c */
    public File mo6674c() {
        return null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: d */
    public int mo6675d() {
        return 2;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: e */
    public File[] mo6676e() {
        return this.f12712a.listFiles();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: f */
    public String mo6677f() {
        return null;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    public void remove() {
        for (File file : mo6676e()) {
            C4592b c4592b = C4592b.f12227a;
            StringBuilder sbM833U = C1643a.m833U("Removing native report file at ");
            sbM833U.append(file.getPath());
            c4592b.m6371b(sbM833U.toString());
            file.delete();
        }
        C4592b c4592b2 = C4592b.f12227a;
        StringBuilder sbM833U2 = C1643a.m833U("Removing native report directory at ");
        sbM833U2.append(this.f12712a);
        c4592b2.m6371b(sbM833U2.toString());
        this.f12712a.delete();
    }
}
