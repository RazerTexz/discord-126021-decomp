package f0.e0.k.i;

import b.d.b.a.outline;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.e0.k.i.AndroidSocketAdapter2;
import f0.e0.k.i.DeferredSocketAdapter;
import javax.net.ssl.SSLSocket;

/* JADX INFO: renamed from: f0.e0.k.i.e, reason: use source file name */
/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidSocketAdapter implements DeferredSocketAdapter.a {
    public final /* synthetic */ String a;

    public AndroidSocketAdapter(String str) {
        this.a = str;
    }

    @Override // f0.e0.k.i.DeferredSocketAdapter.a
    public boolean a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        String name = sSLSocket.getClass().getName();
        Intrinsics3.checkExpressionValueIsNotNull(name, "sslSocket.javaClass.name");
        return StringsJVM.startsWith$default(name, outline.H(new StringBuilder(), this.a, '.'), false, 2, null);
    }

    @Override // f0.e0.k.i.DeferredSocketAdapter.a
    public SocketAdapter b(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        AndroidSocketAdapter2.a aVar = AndroidSocketAdapter2.f3653b;
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (superclass != null && (!Intrinsics3.areEqual(superclass.getSimpleName(), "OpenSSLSocketImpl"))) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        if (superclass == null) {
            Intrinsics3.throwNpe();
        }
        return new AndroidSocketAdapter2(superclass);
    }
}
