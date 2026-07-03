package p007b.p109f.p161j.p181p;

import java.util.Map;
import p007b.p109f.p161j.p176k.InterfaceC1927d;
import p007b.p109f.p161j.p176k.InterfaceC1928e;

/* JADX INFO: renamed from: b.f.j.p.b0 */
/* JADX INFO: compiled from: InternalRequestListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1966b0 implements InterfaceC1927d, InterfaceC2024z0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1964a1 f3994a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC2024z0 f3995b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1928e f3996c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1927d f3997d;

    public C1966b0(InterfaceC1928e interfaceC1928e, InterfaceC1927d interfaceC1927d) {
        this.f3994a = interfaceC1928e;
        this.f3995b = interfaceC1927d;
        this.f3996c = interfaceC1928e;
        this.f3997d = interfaceC1927d;
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: a */
    public void mo1354a(InterfaceC2020x0 interfaceC2020x0, String str, String str2) {
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        if (interfaceC1964a1 != null) {
            interfaceC1964a1.mo1351h(interfaceC2020x0.getId(), str, str2);
        }
        InterfaceC2024z0 interfaceC2024z0 = this.f3995b;
        if (interfaceC2024z0 != null) {
            interfaceC2024z0.mo1354a(interfaceC2020x0, str, str2);
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: b */
    public void mo1355b(InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC1928e interfaceC1928e = this.f3996c;
        if (interfaceC1928e != null) {
            interfaceC1928e.mo1079a(interfaceC2020x0.mo1447e(), interfaceC2020x0.mo1444b(), interfaceC2020x0.getId(), interfaceC2020x0.mo1453k());
        }
        InterfaceC1927d interfaceC1927d = this.f3997d;
        if (interfaceC1927d != null) {
            interfaceC1927d.mo1355b(interfaceC2020x0);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: c */
    public void mo1356c(InterfaceC2020x0 interfaceC2020x0, String str, boolean z2) {
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        if (interfaceC1964a1 != null) {
            interfaceC1964a1.mo1062e(interfaceC2020x0.getId(), str, z2);
        }
        InterfaceC2024z0 interfaceC2024z0 = this.f3995b;
        if (interfaceC2024z0 != null) {
            interfaceC2024z0.mo1356c(interfaceC2020x0, str, z2);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: d */
    public void mo1357d(InterfaceC2020x0 interfaceC2020x0, String str, Map map) {
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        if (interfaceC1964a1 != null) {
            interfaceC1964a1.mo1349d(interfaceC2020x0.getId(), str, map);
        }
        InterfaceC2024z0 interfaceC2024z0 = this.f3995b;
        if (interfaceC2024z0 != null) {
            interfaceC2024z0.mo1357d(interfaceC2020x0, str, map);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: e */
    public void mo1358e(InterfaceC2020x0 interfaceC2020x0, String str) {
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        if (interfaceC1964a1 != null) {
            interfaceC1964a1.mo1348b(interfaceC2020x0.getId(), str);
        }
        InterfaceC2024z0 interfaceC2024z0 = this.f3995b;
        if (interfaceC2024z0 != null) {
            interfaceC2024z0.mo1358e(interfaceC2020x0, str);
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: f */
    public void mo1359f(InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC1928e interfaceC1928e = this.f3996c;
        if (interfaceC1928e != null) {
            interfaceC1928e.mo1080c(interfaceC2020x0.mo1447e(), interfaceC2020x0.getId(), interfaceC2020x0.mo1453k());
        }
        InterfaceC1927d interfaceC1927d = this.f3997d;
        if (interfaceC1927d != null) {
            interfaceC1927d.mo1359f(interfaceC2020x0);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: g */
    public boolean mo1360g(InterfaceC2020x0 interfaceC2020x0, String str) {
        InterfaceC2024z0 interfaceC2024z0;
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        boolean zMo1350f = interfaceC1964a1 != null ? interfaceC1964a1.mo1350f(interfaceC2020x0.getId()) : false;
        return (zMo1350f || (interfaceC2024z0 = this.f3995b) == null) ? zMo1350f : interfaceC2024z0.mo1360g(interfaceC2020x0, str);
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: h */
    public void mo1361h(InterfaceC2020x0 interfaceC2020x0, Throwable th) {
        InterfaceC1928e interfaceC1928e = this.f3996c;
        if (interfaceC1928e != null) {
            interfaceC1928e.mo1081g(interfaceC2020x0.mo1447e(), interfaceC2020x0.getId(), th, interfaceC2020x0.mo1453k());
        }
        InterfaceC1927d interfaceC1927d = this.f3997d;
        if (interfaceC1927d != null) {
            interfaceC1927d.mo1361h(interfaceC2020x0, th);
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: i */
    public void mo1362i(InterfaceC2020x0 interfaceC2020x0) {
        InterfaceC1928e interfaceC1928e = this.f3996c;
        if (interfaceC1928e != null) {
            interfaceC1928e.mo1082k(interfaceC2020x0.getId());
        }
        InterfaceC1927d interfaceC1927d = this.f3997d;
        if (interfaceC1927d != null) {
            interfaceC1927d.mo1362i(interfaceC2020x0);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: j */
    public void mo1363j(InterfaceC2020x0 interfaceC2020x0, String str, Map map) {
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        if (interfaceC1964a1 != null) {
            interfaceC1964a1.mo1352i(interfaceC2020x0.getId(), str, map);
        }
        InterfaceC2024z0 interfaceC2024z0 = this.f3995b;
        if (interfaceC2024z0 != null) {
            interfaceC2024z0.mo1363j(interfaceC2020x0, str, map);
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: k */
    public void mo1364k(InterfaceC2020x0 interfaceC2020x0, String str, Throwable th, Map map) {
        InterfaceC1964a1 interfaceC1964a1 = this.f3994a;
        if (interfaceC1964a1 != null) {
            interfaceC1964a1.mo1353j(interfaceC2020x0.getId(), str, th, map);
        }
        InterfaceC2024z0 interfaceC2024z0 = this.f3995b;
        if (interfaceC2024z0 != null) {
            interfaceC2024z0.mo1364k(interfaceC2020x0, str, th, map);
        }
    }
}
