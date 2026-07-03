package p007b.p109f.p161j.p181p;

import java.util.concurrent.CancellationException;
import p007b.p109f.p161j.p175j.C1919e;
import p686z.C13202g;
import p686z.InterfaceC13198c;

/* JADX INFO: renamed from: b.f.j.p.q */
/* JADX INFO: compiled from: DiskCacheReadProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2005q implements InterfaceC13198c<C1919e, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ InterfaceC2024z0 f4185a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ InterfaceC2020x0 f4186b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ InterfaceC1995l f4187c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C2009s f4188d;

    public C2005q(C2009s c2009s, InterfaceC2024z0 interfaceC2024z0, InterfaceC2020x0 interfaceC2020x0, InterfaceC1995l interfaceC1995l) {
        this.f4188d = c2009s;
        this.f4185a = interfaceC2024z0;
        this.f4186b = interfaceC2020x0;
        this.f4187c = interfaceC1995l;
    }

    @Override // p686z.InterfaceC13198c
    /* JADX INFO: renamed from: a */
    public Void mo1510a(C13202g<C1919e> c13202g) throws Exception {
        boolean z2;
        C1919e c1919e;
        synchronized (c13202g.f27983g) {
            z2 = c13202g.f27985i;
        }
        if (z2 || (c13202g.m11370e() && (c13202g.m11369d() instanceof CancellationException))) {
            this.f4185a.mo1357d(this.f4186b, "DiskCacheProducer", null);
            this.f4187c.mo1426d();
        } else if (c13202g.m11370e()) {
            this.f4185a.mo1364k(this.f4186b, "DiskCacheProducer", c13202g.m11369d(), null);
            this.f4188d.f4205d.mo1417b(this.f4187c, this.f4186b);
        } else {
            synchronized (c13202g.f27983g) {
                c1919e = c13202g.f27986j;
            }
            C1919e c1919e2 = c1919e;
            if (c1919e2 != null) {
                InterfaceC2024z0 interfaceC2024z0 = this.f4185a;
                InterfaceC2020x0 interfaceC2020x0 = this.f4186b;
                interfaceC2024z0.mo1363j(interfaceC2020x0, "DiskCacheProducer", C2009s.m1516c(interfaceC2024z0, interfaceC2020x0, true, c1919e2.m1344n()));
                this.f4185a.mo1356c(this.f4186b, "DiskCacheProducer", true);
                this.f4186b.mo1456n("disk");
                this.f4187c.mo1423a(1.0f);
                this.f4187c.mo1424b(c1919e2, 1);
                c1919e2.close();
            } else {
                InterfaceC2024z0 interfaceC2024z1 = this.f4185a;
                InterfaceC2020x0 interfaceC2020x1 = this.f4186b;
                interfaceC2024z1.mo1363j(interfaceC2020x1, "DiskCacheProducer", C2009s.m1516c(interfaceC2024z1, interfaceC2020x1, false, 0));
                this.f4188d.f4205d.mo1417b(this.f4187c, this.f4186b);
            }
        }
        return null;
    }
}
