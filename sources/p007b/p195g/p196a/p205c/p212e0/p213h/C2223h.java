package p007b.p195g.p196a.p205c.p212e0.p213h;

import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2211c;
import p007b.p195g.p196a.p205c.p218h0.C2335n;

/* JADX INFO: renamed from: b.g.a.c.e0.h.h */
/* JADX INFO: compiled from: MinimalClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2223h extends C2221f {

    /* JADX INFO: renamed from: c */
    public final String f4773c;

    public C2223h(AbstractC2360j abstractC2360j, C2335n c2335n, AbstractC2211c abstractC2211c) {
        super(abstractC2360j, c2335n, abstractC2211c);
        String name = abstractC2360j._class.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.f4773c = ".";
        } else {
            this.f4773c = name.substring(0, iLastIndexOf + 1);
            name.substring(0, iLastIndexOf);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.p213h.C2221f, p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e
    /* JADX INFO: renamed from: a */
    public String mo1946a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.f4773c) ? name.substring(this.f4773c.length() - 1) : name;
    }
}
