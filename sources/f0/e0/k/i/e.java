package f0.e0.k.i;

import d0.g0.t;
import d0.z.d.m;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements j$a {
    public final /* synthetic */ String a;

    public e(String str) {
        this.a = str;
    }

    @Override // f0.e0.k.i.j$a
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        m.checkExpressionValueIsNotNull(name, "sslSocket.javaClass.name");
        return t.startsWith$default(name, b.d.b.a.a.H(new StringBuilder(), this.a, '.'), false, 2, null);
    }

    @Override // f0.e0.k.i.j$a
    public k b(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        f$a f_a = f.f3653b;
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (superclass != null && (!m.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        if (superclass == null) {
            m.throwNpe();
        }
        return new f(superclass);
    }
}
