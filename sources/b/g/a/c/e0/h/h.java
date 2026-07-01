package b.g.a.c.e0.h;

import b.g.a.c.h0.n;

/* JADX INFO: compiled from: MinimalClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends f {
    public final String c;

    public h(b.g.a.c.j jVar, n nVar, b.g.a.c.e0.c cVar) {
        super(jVar, nVar, cVar);
        String name = jVar._class.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.c = ".";
        } else {
            this.c = name.substring(0, iLastIndexOf + 1);
            name.substring(0, iLastIndexOf);
        }
    }

    @Override // b.g.a.c.e0.h.f, b.g.a.c.e0.e
    public String a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.c) ? name.substring(this.c.length() - 1) : name;
    }
}
