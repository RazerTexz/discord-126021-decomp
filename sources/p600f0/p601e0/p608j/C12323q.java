package p600f0.p601e0.p608j;

import java.io.IOException;
import java.util.List;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12388e;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.e0.j.q */
/* JADX INFO: compiled from: PushObserver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12323q implements InterfaceC12324r {
    @Override // p600f0.p601e0.p608j.InterfaceC12324r
    /* JADX INFO: renamed from: a */
    public boolean mo10308a(int i, List<C12308b> list) {
        C12238m.checkParameterIsNotNull(list, "requestHeaders");
        return true;
    }

    @Override // p600f0.p601e0.p608j.InterfaceC12324r
    /* JADX INFO: renamed from: b */
    public boolean mo10309b(int i, List<C12308b> list, boolean z2) {
        C12238m.checkParameterIsNotNull(list, "responseHeaders");
        return true;
    }

    @Override // p600f0.p601e0.p608j.InterfaceC12324r
    /* JADX INFO: renamed from: c */
    public void mo10310c(int i, EnumC12307a enumC12307a) {
        C12238m.checkParameterIsNotNull(enumC12307a, "errorCode");
    }

    @Override // p600f0.p601e0.p608j.InterfaceC12324r
    /* JADX INFO: renamed from: d */
    public boolean mo10311d(int i, InterfaceC12390g interfaceC12390g, int i2, boolean z2) throws IOException {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        ((C12388e) interfaceC12390g).skip(i2);
        return true;
    }
}
