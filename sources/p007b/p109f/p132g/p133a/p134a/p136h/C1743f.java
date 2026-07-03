package p007b.p109f.p132g.p133a.p134a.p136h;

import android.graphics.Rect;
import com.facebook.common.internal.Supplier;
import java.util.Iterator;
import java.util.List;
import p007b.p109f.p115d.p119d.C1689l;
import p007b.p109f.p115d.p126k.InterfaceC1714b;
import p007b.p109f.p132g.p133a.p134a.C1732c;
import p007b.p109f.p132g.p133a.p134a.p136h.p137i.C1746a;
import p007b.p109f.p132g.p133a.p134a.p136h.p137i.C1747b;
import p007b.p109f.p132g.p133a.p134a.p136h.p137i.C1748c;
import p007b.p109f.p132g.p145h.InterfaceC1798a;
import p007b.p109f.p148h.p158b.p159a.C1828c;
import p007b.p109f.p161j.p176k.C1926c;

/* JADX INFO: renamed from: b.f.g.a.a.h.f */
/* JADX INFO: compiled from: ImagePerfMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class C1743f implements InterfaceC1744g {

    /* JADX INFO: renamed from: a */
    public final C1732c f3204a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1714b f3205b;

    /* JADX INFO: renamed from: c */
    public final C1745h f3206c = new C1745h();

    /* JADX INFO: renamed from: d */
    public final Supplier<Boolean> f3207d;

    /* JADX INFO: renamed from: e */
    public C1740c f3208e;

    /* JADX INFO: renamed from: f */
    public InterfaceC1739b f3209f;

    /* JADX INFO: renamed from: g */
    public C1748c f3210g;

    /* JADX INFO: renamed from: h */
    public C1746a f3211h;

    /* JADX INFO: renamed from: i */
    public C1926c f3212i;

    /* JADX INFO: renamed from: j */
    public List<InterfaceC1742e> f3213j;

    /* JADX INFO: renamed from: k */
    public boolean f3214k;

    public C1743f(InterfaceC1714b interfaceC1714b, C1732c c1732c, Supplier<Boolean> supplier) {
        this.f3205b = interfaceC1714b;
        this.f3204a = c1732c;
        this.f3207d = supplier;
    }

    /* JADX INFO: renamed from: a */
    public void m1065a(C1745h c1745h, int i) {
        List<InterfaceC1742e> list;
        if (!this.f3214k || (list = this.f3213j) == null || list.isEmpty()) {
            return;
        }
        C1741d c1741dM1070c = c1745h.m1070c();
        Iterator<InterfaceC1742e> it = this.f3213j.iterator();
        while (it.hasNext()) {
            it.next().m1064b(c1741dM1070c, i);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1066b(C1745h c1745h, int i) {
        List<InterfaceC1742e> list;
        InterfaceC1798a interfaceC1798a;
        c1745h.f3237v = i;
        if (!this.f3214k || (list = this.f3213j) == null || list.isEmpty()) {
            return;
        }
        if (i == 3 && (interfaceC1798a = this.f3204a.f19461k) != null && interfaceC1798a.mo8670e() != null) {
            Rect bounds = interfaceC1798a.mo8670e().getBounds();
            this.f3206c.f3234s = bounds.width();
            this.f3206c.f3235t = bounds.height();
        }
        C1741d c1741dM1070c = c1745h.m1070c();
        Iterator<InterfaceC1742e> it = this.f3213j.iterator();
        while (it.hasNext()) {
            it.next().m1063a(c1741dM1070c, i);
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: c */
    public void m1067c(boolean z2) {
        this.f3214k = z2;
        if (!z2) {
            InterfaceC1739b interfaceC1739b = this.f3209f;
            if (interfaceC1739b != null) {
                C1732c c1732c = this.f3204a;
                synchronized (c1732c) {
                    InterfaceC1739b interfaceC1739b2 = c1732c.f3176G;
                    if (interfaceC1739b2 instanceof C1738a) {
                        C1738a c1738a = (C1738a) interfaceC1739b2;
                        synchronized (c1738a) {
                            c1738a.f3199a.remove(interfaceC1739b);
                        }
                    } else if (interfaceC1739b2 == interfaceC1739b) {
                        c1732c.f3176G = null;
                    }
                }
            }
            C1746a c1746a = this.f3211h;
            if (c1746a != null) {
                C1828c<INFO> c1828c = this.f3204a.f19460j;
                synchronized (c1828c) {
                    int iIndexOf = c1828c.f3568j.indexOf(c1746a);
                    if (iIndexOf != -1) {
                        c1828c.f3568j.remove(iIndexOf);
                    }
                }
            }
            C1926c c1926c = this.f3212i;
            if (c1926c != null) {
                this.f3204a.m1044L(c1926c);
                return;
            }
            return;
        }
        if (this.f3211h == null) {
            this.f3211h = new C1746a(this.f3205b, this.f3206c, this, this.f3207d, C1689l.f3101a);
        }
        if (this.f3210g == null) {
            this.f3210g = new C1748c(this.f3205b, this.f3206c);
        }
        if (this.f3209f == null) {
            this.f3209f = new C1747b(this.f3206c, this);
        }
        C1740c c1740c = this.f3208e;
        if (c1740c == null) {
            this.f3208e = new C1740c(this.f3204a.f19463m, this.f3209f);
        } else {
            c1740c.f3200a = this.f3204a.f19463m;
        }
        if (this.f3212i == null) {
            this.f3212i = new C1926c(this.f3210g, this.f3208e);
        }
        InterfaceC1739b interfaceC1739b3 = this.f3209f;
        if (interfaceC1739b3 != null) {
            this.f3204a.m1038F(interfaceC1739b3);
        }
        C1746a c1746a2 = this.f3211h;
        if (c1746a2 != null) {
            C1828c<INFO> c1828c2 = this.f3204a.f19460j;
            synchronized (c1828c2) {
                c1828c2.f3568j.add(c1746a2);
            }
        }
        C1926c c1926c2 = this.f3212i;
        if (c1926c2 != null) {
            this.f3204a.m1039G(c1926c2);
        }
    }
}
