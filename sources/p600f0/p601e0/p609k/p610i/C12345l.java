package p600f0.p601e0.p609k.p610i;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.e0.k.i.l */
/* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12345l extends C12339f {

    /* JADX INFO: renamed from: h */
    public static final a f25807h = new a(null);

    /* JADX INFO: renamed from: f0.e0.k.i.l$a */
    /* JADX INFO: compiled from: StandardAndroidSocketAdapter.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12345l(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        C12238m.checkParameterIsNotNull(cls, "sslSocketClass");
        C12238m.checkParameterIsNotNull(cls2, "sslSocketFactoryClass");
        C12238m.checkParameterIsNotNull(cls3, "paramClass");
    }
}
