package p600f0.p601e0.p609k.p610i;

import javax.net.ssl.SSLSocket;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.k.i.e */
/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12338e implements C12343j.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f25792a;

    public C12338e(String str) {
        this.f25792a = str;
    }

    @Override // p600f0.p601e0.p609k.p610i.C12343j.a
    /* JADX INFO: renamed from: a */
    public boolean mo10339a(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        C12238m.checkExpressionValueIsNotNull(name, "sslSocket.javaClass.name");
        return C12103t.startsWith$default(name, C1643a.m820H(new StringBuilder(), this.f25792a, '.'), false, 2, null);
    }

    @Override // p600f0.p601e0.p609k.p610i.C12343j.a
    /* JADX INFO: renamed from: b */
    public InterfaceC12344k mo10340b(SSLSocket sSLSocket) {
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12339f.a aVar = C12339f.f25794b;
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (superclass != null && (!C12238m.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        if (superclass == null) {
            C12238m.throwNpe();
        }
        return new C12339f(superclass);
    }
}
