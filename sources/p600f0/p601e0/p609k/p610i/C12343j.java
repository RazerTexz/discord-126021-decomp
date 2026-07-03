package p600f0.p601e0.p609k.p610i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;

/* JADX INFO: renamed from: f0.e0.k.i.j */
/* JADX INFO: compiled from: DeferredSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12343j implements InterfaceC12344k {

    /* JADX INFO: renamed from: a */
    public InterfaceC12344k f25805a;

    /* JADX INFO: renamed from: b */
    public final a f25806b;

    /* JADX INFO: renamed from: f0.e0.k.i.j$a */
    /* JADX INFO: compiled from: DeferredSocketAdapter.kt */
    public interface a {
        /* JADX INFO: renamed from: a */
        boolean mo10339a(SSLSocket sSLSocket);

        /* JADX INFO: renamed from: b */
        InterfaceC12344k mo10340b(SSLSocket sSLSocket);
    }

    public C12343j(a aVar) {
        C12238m.checkParameterIsNotNull(aVar, "socketAdapterFactory");
        this.f25806b = aVar;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.f25806b.mo10339a(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: b */
    public boolean mo10335b() {
        return true;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        InterfaceC12344k interfaceC12344kM10341e = m10341e(sSLSocket);
        if (interfaceC12344kM10341e != null) {
            return interfaceC12344kM10341e.mo10336c(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        InterfaceC12344k interfaceC12344kM10341e = m10341e(sSLSocket);
        if (interfaceC12344kM10341e != null) {
            interfaceC12344kM10341e.mo10337d(sSLSocket, str, list);
        }
    }

    /* JADX INFO: renamed from: e */
    public final synchronized InterfaceC12344k m10341e(SSLSocket sSLSocket) {
        if (this.f25805a == null && this.f25806b.mo10339a(sSLSocket)) {
            this.f25805a = this.f25806b.mo10340b(sSLSocket);
        }
        return this.f25805a;
    }
}
