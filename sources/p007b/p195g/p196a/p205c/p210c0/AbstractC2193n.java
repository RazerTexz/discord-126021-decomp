package p007b.p195g.p196a.p205c.p210c0;

import p007b.p195g.p196a.p205c.AbstractC2360j;

/* JADX INFO: renamed from: b.g.a.c.c0.n */
/* JADX INFO: compiled from: AnnotatedWithParams.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2193n extends AbstractC2188i {
    private static final long serialVersionUID = 1;
    public final C2195p[] _paramAnnotations;

    public AbstractC2193n(InterfaceC2182e0 interfaceC2182e0, C2195p c2195p, C2195p[] c2195pArr) {
        super(interfaceC2182e0, c2195p);
        this._paramAnnotations = c2195pArr;
    }

    /* JADX INFO: renamed from: m */
    public final C2192m m1910m(int i) {
        AbstractC2360j abstractC2360jMo1891n = mo1891n(i);
        InterfaceC2182e0 interfaceC2182e0 = this.f4716j;
        C2195p[] c2195pArr = this._paramAnnotations;
        return new C2192m(this, abstractC2360jMo1891n, interfaceC2182e0, (c2195pArr == null || i < 0 || i >= c2195pArr.length) ? null : c2195pArr[i], i);
    }

    /* JADX INFO: renamed from: n */
    public abstract AbstractC2360j mo1891n(int i);
}
