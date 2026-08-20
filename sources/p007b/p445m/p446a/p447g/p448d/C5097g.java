package p007b.p445m.p446a.p447g.p448d;

import p007b.p445m.p446a.InterfaceC5083b;
import p007b.p445m.p446a.InterfaceC5087f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.m.a.g.d.g */
/* JADX INFO: compiled from: SntpResponseCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5097g implements InterfaceC5096f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5087f f13656a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5083b f13657b;

    public C5097g(InterfaceC5087f interfaceC5087f, InterfaceC5083b interfaceC5083b) {
        C12238m.checkParameterIsNotNull(interfaceC5087f, "syncResponseCache");
        C12238m.checkParameterIsNotNull(interfaceC5083b, "deviceClock");
        this.f13656a = interfaceC5087f;
        this.f13657b = interfaceC5083b;
    }

    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5096f
    /* JADX INFO: renamed from: a */
    public void mo7149a(C5095e.b bVar) {
        C12238m.checkParameterIsNotNull(bVar, "response");
        this.f13656a.mo7138f(bVar.f13652a);
        this.f13656a.mo7133a(bVar.f13653b);
        this.f13656a.mo7134b(bVar.f13654c);
    }

    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5096f
    public void clear() {
        this.f13656a.clear();
    }

    @Override // p007b.p445m.p446a.p447g.p448d.InterfaceC5096f
    public C5095e.b get() {
        long jMo7137e = this.f13656a.mo7137e();
        long jMo7135c = this.f13656a.mo7135c();
        long jMo7136d = this.f13656a.mo7136d();
        if (jMo7135c == 0) {
            return null;
        }
        return new C5095e.b(jMo7137e, jMo7135c, jMo7136d, this.f13657b);
    }
}
