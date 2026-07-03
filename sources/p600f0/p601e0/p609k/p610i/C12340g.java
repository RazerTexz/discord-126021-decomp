package p600f0.p601e0.p609k.p610i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;
import p600f0.p601e0.p609k.C12328c;
import p600f0.p601e0.p609k.C12333h;
import p600f0.p601e0.p609k.p610i.C12343j;

/* JADX INFO: renamed from: f0.e0.k.i.g */
/* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12340g implements InterfaceC12344k {

    /* JADX INFO: renamed from: a */
    public static final C12343j.a f25800a = new a();

    /* JADX INFO: renamed from: f0.e0.k.i.g$a */
    /* JADX INFO: compiled from: BouncyCastleSocketAdapter.kt */
    public static final class a implements C12343j.a {
        @Override // p600f0.p601e0.p609k.p610i.C12343j.a
        /* JADX INFO: renamed from: a */
        public boolean mo10339a(SSLSocket sSLSocket) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            C12328c.a aVar = C12328c.f25764e;
            return C12328c.f25763d && (sSLSocket instanceof BCSSLSocket);
        }

        @Override // p600f0.p601e0.p609k.p610i.C12343j.a
        /* JADX INFO: renamed from: b */
        public InterfaceC12344k mo10340b(SSLSocket sSLSocket) {
            C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
            return new C12340g();
        }
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: a */
    public boolean mo10334a(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: b */
    public boolean mo10335b() {
        C12328c.a aVar = C12328c.f25764e;
        return C12328c.f25763d;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: c */
    public String mo10336c(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String applicationProtocol = ((BCSSLSocket) sSLSocket).getApplicationProtocol();
        if (applicationProtocol == null || C12238m.areEqual(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // p600f0.p601e0.p609k.p610i.InterfaceC12344k
    /* JADX INFO: renamed from: d */
    public void mo10337d(SSLSocket sSLSocket, String str, List<? extends EnumC12381y> list) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        if (mo10334a(sSLSocket)) {
            BCSSLSocket bCSSLSocket = (BCSSLSocket) sSLSocket;
            BCSSLParameters parameters = bCSSLSocket.getParameters();
            C12238m.checkExpressionValueIsNotNull(parameters, "sslParameters");
            Object[] array = C12333h.f25785c.m10331a(list).toArray(new String[0]);
            if (array == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            parameters.setApplicationProtocols((String[]) array);
            bCSSLSocket.setParameters(parameters);
        }
    }
}
