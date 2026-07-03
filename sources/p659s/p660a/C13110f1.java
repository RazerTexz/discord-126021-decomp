package p659s.p660a;

import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: s.a.f1 */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C13110f1 extends C13116h1 implements InterfaceC13153u {

    /* JADX INFO: renamed from: k */
    public final boolean f27843k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13110f1(Job job) {
        C13116h1 c13116h1;
        super(true);
        boolean z2 = true;
        m11294P(job);
        InterfaceC13138p interfaceC13138p = (InterfaceC13138p) this._parentHandle;
        C13141q c13141q = (C13141q) (interfaceC13138p instanceof C13141q ? interfaceC13138p : null);
        if (c13141q == null || (c13116h1 = (C13116h1) c13141q.f27845m) == null) {
            z2 = false;
            break;
        }
        while (!c13116h1.mo11279J()) {
            InterfaceC13138p interfaceC13138p2 = (InterfaceC13138p) c13116h1._parentHandle;
            C13141q c13141q2 = (C13141q) (interfaceC13138p2 instanceof C13141q ? interfaceC13138p2 : null);
            if (c13141q2 == null || (c13116h1 = (C13116h1) c13141q2.f27845m) == null) {
                z2 = false;
                break;
            }
        }
        this.f27843k = z2;
    }

    @Override // p659s.p660a.C13116h1
    /* JADX INFO: renamed from: J */
    public boolean mo11279J() {
        return this.f27843k;
    }

    @Override // p659s.p660a.C13116h1
    /* JADX INFO: renamed from: K */
    public boolean mo11280K() {
        return true;
    }
}
