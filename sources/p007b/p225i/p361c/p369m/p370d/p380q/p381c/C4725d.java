package p007b.p225i.p361c.p369m.p370d.p380q.p381c;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.C4592b;

/* JADX INFO: renamed from: b.i.c.m.d.q.c.d */
/* JADX INFO: compiled from: SessionReport.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4725d implements InterfaceC4724c {

    /* JADX INFO: renamed from: a */
    public final File f12713a;

    /* JADX INFO: renamed from: b */
    public final File[] f12714b;

    /* JADX INFO: renamed from: c */
    public final Map<String, String> f12715c;

    public C4725d(File file, Map<String, String> map) {
        this.f12713a = file;
        this.f12714b = new File[]{file};
        this.f12715c = new HashMap(map);
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: a */
    public String mo6672a() {
        String strMo6677f = mo6677f();
        return strMo6677f.substring(0, strMo6677f.lastIndexOf(46));
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: b */
    public Map<String, String> mo6673b() {
        return Collections.unmodifiableMap(this.f12715c);
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: c */
    public File mo6674c() {
        return this.f12713a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: d */
    public int mo6675d() {
        return 1;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: e */
    public File[] mo6676e() {
        return this.f12714b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    /* JADX INFO: renamed from: f */
    public String mo6677f() {
        return this.f12713a.getName();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p381c.InterfaceC4724c
    public void remove() {
        C4592b c4592b = C4592b.f12227a;
        StringBuilder sbM833U = C1643a.m833U("Removing report at ");
        sbM833U.append(this.f12713a.getPath());
        c4592b.m6371b(sbM833U.toString());
        this.f12713a.delete();
    }
}
