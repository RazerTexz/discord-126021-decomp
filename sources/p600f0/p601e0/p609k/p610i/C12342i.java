package p600f0.p601e0.p609k.p610i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.conscrypt.Conscrypt;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;
import p600f0.p601e0.p609k.C12329d;
import p600f0.p601e0.p609k.C12333h;

/* JADX INFO: renamed from: f0.e0.k.i.i */
/* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12342i implements InterfaceC12344k {

    /* JADX INFO: renamed from: a */
    public static final C12343j.a f25804a = new a();

    /* JADX INFO: renamed from: f0.e0.k.i.i$a */
    /* JADX INFO: compiled from: ConscryptSocketAdapter.kt */
    public static final class a implements C12343j.a {
        @Override // p600f0.p601e0.p609k.p610i.C12343j.a
        /* JADX INFO: renamed from: a */
        public boolean mo10339a(SSLSocket sSLSocket) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            C12329d.a aVar = C12329d.f25767e;
            return C12329d.f25766d && Conscrypt.isConscrypt(sSLSocket);
        }

        @Override // p600f0.p601e0.p609k.p610i.C12343j.a
        /* JADX INFO: renamed from: b */
        public InterfaceC12344k mo10340b(SSLSocket sSLSocket) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            return new C12342i();
        }
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket);
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: b */
    public boolean mo10335b() {
        C12329d.a aVar = C12329d.f25767e;
        return C12329d.f25766d;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (mo10334a(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        if (mo10334a(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = C12333h.f25785c.m10331a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
        }
    }
}
