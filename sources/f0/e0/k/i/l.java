package f0.e0.k.i;

import d0.z.d.m;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends f {
    public static final l$a h = new l$a(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        m.checkParameterIsNotNull(cls, "sslSocketClass");
        m.checkParameterIsNotNull(cls2, "sslSocketFactoryClass");
        m.checkParameterIsNotNull(cls3, "paramClass");
    }
}
